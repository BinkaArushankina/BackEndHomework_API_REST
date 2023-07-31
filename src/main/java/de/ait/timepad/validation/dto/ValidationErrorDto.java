package de.ait.timepad.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidationErrorDto {
    private String field;
    private String message;
    private String rejectedValue;
}
