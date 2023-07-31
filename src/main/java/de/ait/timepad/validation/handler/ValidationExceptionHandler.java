package de.ait.timepad.validation.handler;

import de.ait.timepad.validation.dto.ValidationErrorDto;
import de.ait.timepad.validation.dto.ValidationErrorsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice//rabota so wsemi controllerami i ich otsleschiwatj
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorsDto> handleException(MethodArgumentNotValidException exception){//exc infa o wsech oschibkach w moment saprosa newUserDto
        //System.out.println(exception.getMessage());//wmesto 400 mi petschataem message, eto perechwat oschibki

        List<ValidationErrorDto> validationErrors = new ArrayList<>();

        BindingResult bindingResult = exception.getBindingResult(); //result validazii
        List<ObjectError> errorList = bindingResult.getAllErrors();//spisok error validazii
        //probeschim po wsem oschibkam i petschataem
        for (ObjectError error : errorList){
            FieldError fieldError = (FieldError)error;//konkretnoe pole pokaschet gde oschibka

            //Json dlja klienta s odnoj oschikoj
            ValidationErrorDto errorDto = ValidationErrorDto.builder()
                    .field(fieldError.getField())
                    .message(error.getDefaultMessage())
                    //.rejectedValue(fieldError.getRejectedValue().toString())
                    .build();

            validationErrors.add(errorDto);//kladem oschiku w spisok i teper klientu goworim s kakim polem proisoschla oschibka
        }

        //podgotowili tela otweta
        ValidationErrorsDto body = ValidationErrorsDto.builder()
                .errors(validationErrors)
                .build();//oschibok moschet bitj mnogo wot spisok oschibok kotorie wosnikli

        //sosdali otwet
        ResponseEntity<ValidationErrorsDto> response = new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        //wernuli otwet
        return response;

        //System.out.println(fieldError.getField() + " " + error.getDefaultMessage() + "bad value" + fieldError.getRejectedValue());

    }
}
