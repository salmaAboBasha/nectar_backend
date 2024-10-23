package ebi.alex.Nectar.service;

import ebi.alex.Nectar.model.ProductsDto;
import ebi.alex.Nectar.model.UsersDto;

import java.util.Set;

public interface UsersServiceInt {
    public UsersDto createUser(UsersDto usersDto);
    public UsersDto getUsersDto(Long Id);
    public UsersDto getUsersEmailAndPassword(String email,String password);
    public  boolean checkEmail(String email);
    public  boolean checkEmailPassword(String email,String password);
    public UsersDto addFavoriteProduct(UsersDto customer, Long productId);
    public Set<ProductsDto> getFavoriteProducts(Long customerId);
    public  void removeFavoriteProduct(Long userId, Long productId);
}
