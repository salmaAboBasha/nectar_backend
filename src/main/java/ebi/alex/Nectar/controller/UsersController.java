package ebi.alex.Nectar.controller;

import ebi.alex.Nectar.entity.CustomResponse;
import ebi.alex.Nectar.exception.CustomException;
import ebi.alex.Nectar.model.UsersDto;
import ebi.alex.Nectar.service.UsersServiceInt;
import jakarta.annotation.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nectar")
public class UsersController {
   private final UsersServiceInt usersService;
   public UsersController(UsersServiceInt usersService) {
       this.usersService = usersService;
   }
   @PostMapping("/signUp")
  public ResponseEntity<?> createUser(@RequestBody final UsersDto usersDto){
       try {
           return new ResponseEntity<>(new CustomResponse("01","success",usersService.createUser(usersDto)), HttpStatus.OK);
       }
       catch (Exception e){
           return new ResponseEntity<>(new CustomResponse("02","error",e.getMessage()), HttpStatus.OK);
       }

  };
   @PostMapping("/login")
   public ResponseEntity<?>getUsersEmailAndPassword(@RequestBody UsersDto userDto){
       try {
           return new ResponseEntity<>(new CustomResponse("01","success",usersService.getUsersEmailAndPassword(userDto.getEmail(), userDto.getPassword())), HttpStatus.OK);
       }
       catch (Exception e){
           return new ResponseEntity<>(new CustomResponse("02","error",e.getMessage()), HttpStatus.OK);
       }
   }
   @GetMapping("/get/{id}")
    public ResponseEntity<?> getUsersById(@PathVariable final Long id){
       try {
           return new ResponseEntity<>(new CustomResponse("01","success",usersService.getUsersDto(id)), HttpStatus.OK);
       }
       catch (Exception e){
           return new ResponseEntity<>(new CustomResponse("02","error",e.getMessage()), HttpStatus.OK);
       }

   }
   @PostMapping("/addFavoriteProduct/{ProductId}")
   public  ResponseEntity<?> PostFavoriteProduct(@RequestBody final UsersDto usersDto,@PathVariable Long ProductId){
       try {
           return new ResponseEntity<>(new CustomResponse("01","success",usersService.addFavoriteProduct(usersDto,ProductId)),HttpStatus.OK);
       }
       catch (Exception e){
           return new ResponseEntity<>(new CustomResponse("02","error",e.getMessage()), HttpStatus.OK);
       }
   }
    @GetMapping("/getFavoriteProduct/{usersDto}")
    public  ResponseEntity<?> getFavoriteProducts(@PathVariable final Long usersDto){
        try {
            return new ResponseEntity<>(new CustomResponse("01","success",usersService.getFavoriteProducts(usersDto)),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new CustomResponse("02","error",e.getMessage()), HttpStatus.OK);
        }
    }
    @DeleteMapping("/deleteFavorite/{productId}/{userId}")
    public ResponseEntity<CustomResponse> deleteFavoriteProduct(
            @PathVariable Long userId, @PathVariable Long productId) {
        try {
            usersService.removeFavoriteProduct(userId, productId);
            return new ResponseEntity<>(
                    new CustomResponse("01", "success", "Product removed from favorites"),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new CustomResponse("02", "error", e.getMessage()),
                    HttpStatus.OK);
        }
    }

}
