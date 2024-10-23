package ebi.alex.Nectar.repo;

import ebi.alex.Nectar.entity.ProductsEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepoInt extends JpaRepository<ProductsEntity,Long> {
    public List<ProductsEntity> findByTypeofproduct(String typeofproduct);

}
