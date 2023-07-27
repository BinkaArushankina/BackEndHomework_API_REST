package de.ait.timepad.dto.events;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "event's List")
public class EventsDto {

    @Schema(description = "system event")
    private List<EventDto> events;

    @Schema(description = "total number of event", example = "1")
    private Integer count;
}
