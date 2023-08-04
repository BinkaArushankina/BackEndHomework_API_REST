package de.ait.timepad.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private State state;

    private EventType eventType;

    @ManyToOne
    @JoinColumn(name = "about_id")
    private User about;

    private LocalDate publishDate;
}
