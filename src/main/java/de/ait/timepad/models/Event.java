package de.ait.timepad.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String name;

    private Long id;

    private State state;

    private EventType eventType;
}
