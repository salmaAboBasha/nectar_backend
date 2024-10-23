package ebi.alex.Nectar.service;

import ebi.alex.Nectar.entity.ProductsEntity;
import ebi.alex.Nectar.exception.CustomException;
import ebi.alex.Nectar.model.ProductsDto;
import ebi.alex.Nectar.repo.ProductsRepoInt;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements ProductServiceInt{
 private  final    ProductsRepoInt productsRepo;
 private  final ModelMapper modelMapper= new ModelMapper();
    public ProductService(ProductsRepoInt productsRepo) {
        this.productsRepo = productsRepo;
    }

    @Override
    public ProductsDto fetchProductsDtoById(Long id) {
        ProductsEntity productsEntity = productsRepo.findById(id).orElseThrow(() -> new CustomException("Product not found with ID: " + id));
        return modelMapper.map(productsEntity, ProductsDto.class);
    }

    @Override
    public List<ProductsDto> findByTypeofproduct(String typeofproduct) {
        List<ProductsEntity> productsEntities = productsRepo.findByTypeofproduct(typeofproduct);
        return productsEntities.stream().map(productsEntity -> modelMapper.map(productsEntity,ProductsDto.class)).collect(Collectors.toList());
    }
}
