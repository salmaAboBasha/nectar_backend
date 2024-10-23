package ebi.alex.Nectar.service;

import ebi.alex.Nectar.entity.ShoppingCartEntity;
import ebi.alex.Nectar.model.ShoppingCartDto;

public interface ShoppingCartServiceInt {
    public ShoppingCartDto createShoppingCart(ShoppingCartDto shoppingCart,Long userId);
    public ShoppingCartDto fillShoppingCartById(Long id);
    public  ShoppingCartDto addShoppingCart(ShoppingCartDto shoppingId, Long productId);
}
