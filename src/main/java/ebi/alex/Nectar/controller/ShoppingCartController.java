//package ebi.alex.Nectar.controller;
//
//import ebi.alex.Nectar.entity.CustomResponse;
//import ebi.alex.Nectar.model.ShoppingCartDto;
//import ebi.alex.Nectar.service.ShoppingCartService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/ShoppingCart")
//public class ShoppingCartController {
//    private final ShoppingCartService shoppingCartService;
//    public ShoppingCartController(ShoppingCartService shoppingCartService) {
//        this.shoppingCartService = shoppingCartService;
//    }
//    @PostMapping("/CreateCart/{userId}")
//    public ResponseEntity<?> CreateCart(@RequestBody ShoppingCartDto shoppingCartDto,@PathVariable Long userId){
//
//            return new ResponseEntity<>(new CustomResponse("01","success",shoppingCartService.createShoppingCart(shoppingCartDto,userId)), HttpStatus.OK);
//    }
//    @PostMapping("/AddItem/{itemId}")
//    public ResponseEntity<?> addShoppingCart(@RequestBody ShoppingCartDto shoppingCartId,@PathVariable Long itemId){
//        return new ResponseEntity<>(new CustomResponse("01","success",shoppingCartService.addShoppingCart(shoppingCartId,itemId)), HttpStatus.OK);
//    }
//}
