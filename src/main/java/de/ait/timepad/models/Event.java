package de.ait.timepad.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 7/21/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {

    public enum EventType {
        LOG_IN,
        SIGN_IN,
        SIGN_OUT,
        NOT_FOUND
    }

    private String name;

    private EventType eventType;
}
