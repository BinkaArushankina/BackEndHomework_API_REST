package de.ait.timepad.controllers.events;

import de.ait.timepad.models.Event;
import de.ait.timepad.repositories.events.EventsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static de.ait.timepad.models.Event.EventType.NOT_FOUND;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
class EventsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EventsRepository eventsRepository;

    @BeforeEach
    public void setUp(){
        eventsRepository.clear();
    }

    @Test
    void addEvents() throws Exception {
        mockMvc.perform(post("/api/events")
                .header("Content-Type","application/json")
                .content("{\n" +
                        " \"name\": \"not-found\"\n" +
                        "}"))
                //.andDo(print());
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.eventType", is("NOT_FOUND")));
    }

    @Test
    void getAllEvents() throws Exception{
        eventsRepository.save(Event.builder().eventType(NOT_FOUND).build());
        eventsRepository.save(Event.builder().eventType(NOT_FOUND).build());

        mockMvc.perform(get("/api/events"))
                .andExpect(jsonPath("$.count", is(2)));
    }
}