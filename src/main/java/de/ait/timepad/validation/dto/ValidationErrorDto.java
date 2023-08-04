package de.ait.timepad.validation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "error validation")
public class ValidationErrorDto {

    @Schema(description = "Field, that contains the error", example = "email")
    private String field;

    @Schema(description = "errors message", example = "must be well-formed email address")
    private String message;

    @Schema(description = "what value was received from the client", example = "sidikov.marsel.com")
    private String rejectedValue;
}
