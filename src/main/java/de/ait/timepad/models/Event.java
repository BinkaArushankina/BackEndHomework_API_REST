package de.ait.timepad.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {

    public enum EventType {
        PARTY,
        CONCERT
    }

    public enum State {
        NOT_CONFIRMED,
        CONFIRMED,
        IGNORED,
        DELETED
    }

    private Long id;

    private String name;

    private State state;

    private EventType eventType;

    private User about;

    private LocalDate publishDate;
}
