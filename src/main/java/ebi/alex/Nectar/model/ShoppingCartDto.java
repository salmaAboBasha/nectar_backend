package ebi.alex.Nectar.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ShoppingCartDto {
    private Long id;
    private List<ProductsDto> CartItems;
    private UsersDto users;
}
