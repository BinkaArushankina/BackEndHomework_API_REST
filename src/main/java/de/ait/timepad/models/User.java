package de.ait.timepad.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"events", "articles"})
@Entity
@Table(name = "account")
public class User {


    public enum Role {
        ADMIN,
        USER,
        MANAGER
    }

    public enum State {
        NOT_CONFIRMED,
        CONFIRMED,
        BANNED,
        DELETED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    private Role role;
    private State state;

    @OneToMany(mappedBy = "account")
    private List<Article> articles;

    @OneToMany(mappedBy = "account")
    private List<Event> events;
}
