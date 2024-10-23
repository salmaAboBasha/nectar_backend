package ebi.alex.Nectar.repo;

import ebi.alex.Nectar.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UsersRepoInt extends JpaRepository<UsersEntity ,Long> {
public UsersEntity findByEmail(String email);
public UsersEntity findByEmailAndPassword(String email, String password);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM customer_favorite_products WHERE customer_id = :userId AND product_id = :productId", nativeQuery = true)
    void removeFavoriteProductById(@Param("userId") Long userId, @Param("productId") Long productId);
}
