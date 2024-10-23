package ebi.alex.Nectar.controller;

import ebi.alex.Nectar.entity.CustomResponse;
import ebi.alex.Nectar.service.ProductServiceInt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Products")
public class ProductsController {
    private final ProductServiceInt productService;

    public ProductsController(ProductServiceInt productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> fetchProductsDtoById(@PathVariable final Long id) {
        try {
            return new ResponseEntity<>(new CustomResponse("02", "success", productService.fetchProductsDtoById(id)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new CustomResponse("02", "error", e.getMessage()), HttpStatus.OK);
        }
    }

    @GetMapping("/category/{typeofproduct}")
    public ResponseEntity<?> fetchProductsDtoById(@PathVariable final String typeofproduct) {
        try {
            return new ResponseEntity<>(new CustomResponse("02", "success", productService.findByTypeofproduct(typeofproduct)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new CustomResponse("02", "error", e.getMessage()), HttpStatus.OK);
        }
    }




}