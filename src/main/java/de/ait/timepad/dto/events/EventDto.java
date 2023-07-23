package de.ait.timepad.dto.events;

import de.ait.timepad.models.Event;
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
public class EventDto {

    private String eventType;
    public static EventDto from (Event event){
        return EventDto.builder()
                .eventType(event.getEventType().name())
                .build();
    }

    public static List<EventDto> from(List<Event> events){
        return events.stream().map(EventDto::from)
                .collect(Collectors.toList());
    }
}
