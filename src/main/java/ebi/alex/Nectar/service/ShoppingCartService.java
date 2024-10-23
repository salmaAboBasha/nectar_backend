package ebi.alex.Nectar.service;

import ebi.alex.Nectar.entity.ProductsEntity;
import ebi.alex.Nectar.entity.ShoppingCartEntity;
import ebi.alex.Nectar.entity.UsersEntity;
import ebi.alex.Nectar.model.ShoppingCartDto;
import ebi.alex.Nectar.repo.ProductsRepoInt;
import ebi.alex.Nectar.repo.ShoppingCartRepoInt;
import ebi.alex.Nectar.repo.UsersRepoInt;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ShoppingCartService implements  ShoppingCartServiceInt {
    private  final ShoppingCartRepoInt shoppingCartRepo;
    private final UsersRepoInt usersRepo;
    private  final ModelMapper modelMapper=new ModelMapper();
    private  final ProductsRepoInt productsRepo;
    public ShoppingCartService(ShoppingCartRepoInt shoppingCartRepo, UsersRepoInt usersRepo, ProductsRepoInt productsRepo) {
        this.shoppingCartRepo = shoppingCartRepo;
        this.usersRepo = usersRepo;
        this.productsRepo = productsRepo;
    }

    @Override
    public ShoppingCartDto createShoppingCart(ShoppingCartDto shoppingCart,Long userId) {
        UsersEntity usersEntity=usersRepo.findById(userId).get();
        ShoppingCartEntity shoppingCartEntity=modelMapper.map(shoppingCart, ShoppingCartEntity.class);
        shoppingCartEntity.setUsersEntity(usersEntity);
        shoppingCartEntity=shoppingCartRepo.save(shoppingCartEntity);
        return modelMapper.map(shoppingCartEntity, ShoppingCartDto.class);
    }

    @Override
    public ShoppingCartDto fillShoppingCartById(Long id) {
        return null;
    }

    @Override
    public ShoppingCartDto addShoppingCart(ShoppingCartDto shoppingId, Long productId) {
        // Fetch product and cart from the database, handling the case when not found
        ProductsEntity productsEntity = productsRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        ShoppingCartEntity shoppingCartEntity = shoppingCartRepo.findById(shoppingId.getId())
                .orElseThrow(() -> new RuntimeException("Shopping Cart not found"));

        // Retrieve existing items in the cart or initialize if empty
        Set<ProductsEntity> productsEntities = shoppingCartEntity.getCartItems();
        if (productsEntities == null) {
            productsEntities = new HashSet<>();
        }

        // Add the new product to the existing items
        productsEntities.add(productsEntity);

        // Update the shopping cart entity with the new set of items
        shoppingCartEntity.setCartItems(productsEntities);

        // Save the updated cart to the database
        shoppingCartRepo.save(shoppingCartEntity);

        // Convert the updated entity back to a DTO and return it
        return modelMapper.map(shoppingCartEntity, ShoppingCartDto.class);
    }
}
