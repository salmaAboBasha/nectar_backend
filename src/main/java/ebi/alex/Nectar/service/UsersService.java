package ebi.alex.Nectar.service;

import ebi.alex.Nectar.entity.ProductsEntity;
import ebi.alex.Nectar.entity.UsersEntity;
import ebi.alex.Nectar.exception.CustomException;
import ebi.alex.Nectar.model.ProductsDto;
import ebi.alex.Nectar.model.UsersDto;
import ebi.alex.Nectar.repo.ProductsRepoInt;
import ebi.alex.Nectar.repo.UsersRepoInt;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsersService implements UsersServiceInt{
  private final   UsersRepoInt usersRepo;
  private final ProductsRepoInt productsRepo;
  private final ModelMapper modelMapper=new ModelMapper();
  public UsersService(UsersRepoInt usersRepo, ProductsRepoInt productsRepo) {
    this.productsRepo=productsRepo;
      this.usersRepo = usersRepo;
  }



    @Override
    public UsersDto createUser(UsersDto usersDto) throws CustomException {
      UsersEntity users=modelMapper.map(usersDto, UsersEntity.class);

    if(checkEmail(usersDto.getEmail())){
      throw new CustomException("Email already exists");
    }else{
      UsersEntity usersSignup=usersRepo.save(users);
      return modelMapper.map(usersSignup,UsersDto.class);
    }}

  @Override
  public UsersDto getUsersDto(Long Id) {
    UsersEntity usersEntity = usersRepo.findById(Id).orElseThrow(() -> new CustomException("User not found with ID: " + Id));
    return modelMapper.map(usersEntity,UsersDto.class);
  }


  @Override
    public UsersDto getUsersEmailAndPassword(String email, String password) throws CustomException {
    if(checkEmailPassword(email, password)){
      UsersEntity usersLogin=usersRepo.findByEmailAndPassword(email, password);
      return modelMapper.map(usersLogin,UsersDto.class);
    }
     throw new CustomException("Invalid email or password");
    }

  @Override
  public boolean checkEmail(String email) {
    UsersEntity usersEntity=usersRepo.findByEmail(email);
    return usersEntity!=null;
  }

  @Override
  public boolean checkEmailPassword(String email, String password) {
    UsersEntity usersEntity=usersRepo.findByEmailAndPassword(email, password);
    return usersEntity!=null;
  }
  public UsersDto addFavoriteProduct(UsersDto userId, Long productId) {
    // Fetch customer and product from the database
    UsersEntity user = usersRepo.findById(userId.getId())
            .orElseThrow(() -> new RuntimeException("Customer not found"));
    ProductsEntity product = productsRepo.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found"));

    // Add the product to the customer's favorite products
    Set<ProductsEntity> favorites = user.getFavoriteProducts();
    favorites.add(product);
    user.setFavoriteProducts(favorites);

    // Save the updated customer

    return modelMapper.map(usersRepo.save(user),UsersDto.class);
  }

  public Set<ProductsDto> getFavoriteProducts(Long userId) {
    UsersEntity user = usersRepo.findById(userId)
            .orElseThrow(() -> new RuntimeException("Customer not found"));
    Set<ProductsEntity> favorites = user.getFavoriteProducts();
    return favorites.stream().map(favorite->modelMapper.map(favorite,ProductsDto.class)).collect(Collectors.toSet());
}

  @Override
  public void removeFavoriteProduct(Long userId, Long productId) {
   usersRepo.removeFavoriteProductById(userId,productId);

  }
}
