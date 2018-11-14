package net.sshplendid.study.java.whiteship.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.sshplendid.study.java.whiteship.greeting.CommonControllerTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EventControllerTests extends CommonControllerTests {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void createEvent() throws Exception {
        // GIVEN
        Event event = Event.builder()
                .name("ksug spring 세미나")
                .location("강남")
                .basePrice(15000)
                .maxPrice(15000)
                .beginEnrollmentDateTime(LocalDateTime.of(2018, 11, 4, 1, 10))
                .closeEnrollmentDateTime(LocalDateTime.of(2018, 11, 14, 1, 10))
                .beginEventDateTime(LocalDateTime.of(2018, 11, 10, 9, 00))
                .endEventDateTime(LocalDateTime.of(2018, 11, 10, 14, 00))
                .build();

        String requestBody = objectMapper.writeValueAsString(event);


        this.mockMvc.perform(post("/api/events")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(requestBody)
                            )
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(status().isOk())
        ;
    }
}
