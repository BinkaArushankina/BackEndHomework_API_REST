package de.ait.timepad.dto.events;
import de.ait.timepad.dto.users.UserInEventDto;
import de.ait.timepad.models.Event;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "users event")
public class EventDto {

    @Schema(description = "event id", example = "1")
    private Long id;

    @Schema(description = "user who will be at this event")
    private UserInEventDto about;

    @Schema(description = "Type event", example = "Party")
    private String eventType;

    @Schema(description = "event date YYYY-MM-DD", example = "2022-02-02")
    private String publishDate;

    public static EventDto from (Event event){
         EventDto result = EventDto.builder()
                .id(event.getId())
                .eventType(event.getEventType().name())
                .build();

        if (event.getAbout() != null) {
            result.setAbout(UserInEventDto.from(event.getAbout()));
        }

        if (event.getPublishDate() != null) {
            result.setPublishDate(event.getPublishDate().toString());
        }

        return result;
    }

    public static List<EventDto> from(List<Event> events){
        return events.stream().map(EventDto::from)
                .collect(Collectors.toList());
    }


}
