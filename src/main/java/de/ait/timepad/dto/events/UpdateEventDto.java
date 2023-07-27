package de.ait.timepad.dto.events;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "data for update")
public class UpdateEventDto {

    @Schema(description = "event's state - NOT_CONFIRMED, CONFIRMED, IGNORED, DELETED", example = "CONFIRMED")
    private String newState;

    @Schema(description = "event's eventType - PARTY, CONCERT", example = "PARTY")
    private String newEventType;
}
