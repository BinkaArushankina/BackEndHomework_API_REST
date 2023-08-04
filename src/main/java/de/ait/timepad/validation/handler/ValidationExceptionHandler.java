package de.ait.timepad.validation.handler;

import de.ait.timepad.validation.dto.ValidationErrorDto;
import de.ait.timepad.validation.dto.ValidationErrorsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice//rabota so wsemi controllerami i ich otsleschiwatj,wmesto 400 mi petschataem message, eto perechwat oschibki
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorsDto> handleException(MethodArgumentNotValidException exception){//exc infa o wsech oschibkach w moment saprosa newUserDto
        //sobiraem spisok wsech oschibok w json wide
        List<ValidationErrorDto> validationErrors = exception
                .getBindingResult()//polutschaem resultati validazii
                .getAllErrors()//polutaschaem wse oschibki validazii
                .stream()//beschim  po wsem oschibkam
                .filter(error -> error instanceof FieldError)//wibrali tolko field error
                .map(error -> (FieldError)error)//sdelali preobrasowanie
                .map(error -> {//soiraem infu ob oschibke w formate json
                    ValidationErrorDto errorDto = ValidationErrorDto.builder()
                            .field(error.getField())
                            .message(error.getDefaultMessage())
                            .build();

                    if(error.getRejectedValue() != null) {//esli polsowatel wwel snatschenie kotoroe ne nrawitsa validatoru
                        errorDto.setRejectedValue(errorDto.getRejectedValue().toString());//to dobawim snatschenie w otwet
                    }

                    return errorDto;

                })
                .collect(Collectors.toList());

        //podgotowili i srasu wernuli, tela otweta, resultat obrabotki oschibki so statusom 400
        return ResponseEntity//sosdali otwet
                .badRequest()
                .body(ValidationErrorsDto.builder()
                .errors(validationErrors)
                .build());//oschibok moschet bitj mnogo wot spisok oschibok kotorie wosnikli
    }
}
