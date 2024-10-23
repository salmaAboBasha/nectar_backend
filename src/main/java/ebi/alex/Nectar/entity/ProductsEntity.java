package ebi.alex.Nectar.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="products")
public class ProductsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productid;
    private String nameproduct;
    private String priceproduct;
    private String typeofproduct;
    private int quantity;
    @ManyToMany(mappedBy = "cartItems",fetch = FetchType.LAZY)
    @JsonBackReference// Reference to cartItems in ShoppingCartEntity
    private Set<ShoppingCartEntity> shoppingCarts;
    @ManyToMany(mappedBy = "favoriteProducts",fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<UsersEntity> customers = new HashSet<>();
}
