package de.ait.timepad.dto.events;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Data
@Schema(description = "data for add event")
public class NewEventDto {

    @Schema(description = "event name", example = "Party")
    private String name;
}
