package ebi.alex.Nectar.exception;

import ebi.alex.Nectar.entity.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler({CustomException.class})
    public ResponseEntity<?> handleCustomException(CustomException customException) {
        return new ResponseEntity(new CustomResponse("02", "fail", customException.getMessage()), HttpStatus.OK);
    }

}
