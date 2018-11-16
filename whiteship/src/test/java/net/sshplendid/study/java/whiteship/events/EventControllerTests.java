package net.sshplendid.study.java.whiteship.events;

import net.sshplendid.study.java.whiteship.common.CommonControllerTests;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EventControllerTests extends CommonControllerTests {

    @Autowired
    EventRepository eventRepository;

    static final private AtomicInteger counter = new AtomicInteger();

    private EventDto event;

    @Before
    public void setUp() {
        // GIVEN
        event = EventDto.builder()
                .name("ksug spring 세미나")
                .location("강남")
                .basePrice(15000)
                .maxPrice(15000)
                .beginEnrollmentDateTime(LocalDateTime.of(2018, 11, 4, 1, 10))
                .closeEnrollmentDateTime(LocalDateTime.of(2018, 11, 14, 1, 10))
                .beginEventDateTime(LocalDateTime.of(2018, 11, 10, 9, 00))
                .endEventDateTime(LocalDateTime.of(2018, 11, 10, 14, 00))
                .build();

        addMockData();
    }

    private void addMockData() {
        eventRepository.save(Event.builder()
                .name("Mock Event " + counter.incrementAndGet())
                .location("Gangnam")
                .basePrice(10000)
                .maxPrice(10000)
                .beginEnrollmentDateTime(LocalDateTime.of(2018, 11, 1, 1, 10))
                .closeEnrollmentDateTime(LocalDateTime.of(2018, 11, 2, 1, 10))
                .beginEventDateTime(LocalDateTime.of(2018, 11, 3, 13, 10))
                .beginEventDateTime(LocalDateTime.of(2018, 11, 3, 15, 10))
                .build());
    }

    @Test
    public void create() throws Exception {

        String requestBody = objectMapper.writeValueAsString(event);

        this.mockMvc
                .perform(post("/api/events")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(requestBody))
                .andDo(print())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void create_WhenIdIsInlucdeInRequest_ServerWillIgnoreThatValue() throws Exception {
        // GIVEN
        String requestBody = objectMapper.writeValueAsString(event);


        this.mockMvc.perform(post("/api/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(requestBody))
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.basePrice").value(String.valueOf(15000)))
                .andExpect(jsonPath("$.location").value("강남"))
                .andExpect(jsonPath("$.name").value(String.valueOf("ksug spring 세미나")))
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void getEvents() throws Exception {
        // GIVEN

        this.mockMvc.perform(get("/api/events"))
                .andDo(print())
                .andExpect(jsonPath("$[0].id").isNumber())
                .andExpect(status().isOk());
    }
}
