package de.ait.timepad.dto.events;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Schema(description = "data for update")
public class UpdateEventDto {

    @Schema(description = "event's state - NOT_CONFIRMED, CONFIRMED, IGNORED, DELETED", example = "CONFIRMED")
    @NotNull
    @NotBlank
    private String newState;

    @Schema(description = "event's eventType - PARTY, CONCERT", example = "PARTY")
    @NotNull
    @NotBlank
    private String newEventType;
}
