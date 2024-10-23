package ebi.alex.Nectar.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class ShoppingCartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "cart_items", joinColumns = @JoinColumn(name = "shopping_cart_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name="product_id", referencedColumnName = "productid"))
    @JsonManagedReference
    private Set<ProductsEntity> cartItems;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersEntity usersEntity;
}
