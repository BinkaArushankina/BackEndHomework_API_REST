package de.ait.timepad.controllers.events;
import de.ait.timepad.models.Event;
import de.ait.timepad.models.User;
import de.ait.timepad.repositories.events.EventsRepository;
import de.ait.timepad.repositories.users.UsersRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("EventsController is works: ")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class EventsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EventsRepository eventsRepository;

    @Autowired
    private UsersRepository usersRepository;


    @Nested
    @DisplayName("POST /api/events is works: ")
    class AddEventTest {

        @Test
        public void add_event_for_exist_user() throws Exception {
            usersRepository.save(User.builder().email("test@mail.com")
                    .events(new ArrayList<>())
                    .state(User.State.NOT_CONFIRMED).role(User.Role.USER).build());

            mockMvc.perform(post("/api/events")
                            .header("Content-Type", "application/json")
                            .content("{\n" +
                                    "  \"name\": \"Party\",\n" +
                                    "  \"aboutUserId\": 1,\n" +
                                    "  \"publishDate\": \"2022-02-02\"\n" +
                                    "}"))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.id", is(1)))
                    .andExpect(jsonPath("$.publishDate", is("2022-02-02")))
                    .andExpect(jsonPath("$.about.id", is(1)))
                    .andExpect(jsonPath("$.about.email", is("test@mail.com")));

        }

        @Test
        public void add_event_for_not_exist_user() throws Exception {
            mockMvc.perform(post("/api/events")
                            .header("Content-Type", "application/json")
                            .content("{\n" +
                                    "  \"name\": \"Party\",\n" +
                                    "  \"aboutUserId\": 1,\n" +
                                    "}"))
                    .andExpect(status().isBadRequest());
        }
    }



}