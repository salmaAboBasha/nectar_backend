package ebi.alex.Nectar.repo;

import ebi.alex.Nectar.entity.ShoppingCartEntity;
import ebi.alex.Nectar.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingCartRepoInt  extends JpaRepository<ShoppingCartEntity,Long> {
    public List<ShoppingCartEntity> findByUsersEntity(UsersEntity usersEntity);
}
