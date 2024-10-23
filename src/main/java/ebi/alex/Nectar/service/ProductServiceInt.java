package ebi.alex.Nectar.service;

import ebi.alex.Nectar.entity.ProductsEntity;
import ebi.alex.Nectar.model.ProductsDto;

import java.util.List;

public interface ProductServiceInt {
    public ProductsDto fetchProductsDtoById(Long id);
    public List<ProductsDto> findByTypeofproduct(String typeofproduct);
}
