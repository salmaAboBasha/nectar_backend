package ebi.alex.Nectar.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductsDto {
    private Long productid;
    private String nameproduct;
    private String priceproduct;
    private String typeofproduct;
    private int quantity;

}


