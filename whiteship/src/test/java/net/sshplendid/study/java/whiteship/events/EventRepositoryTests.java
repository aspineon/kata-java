package net.sshplendid.study.java.whiteship.events;

import org.assertj.core.description.Description;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@DataJpaTest
public class EventRepositoryTests {

    @Autowired
    EventRepository eventRepository;

    @Before
    public void setUp() {
        for(int i = 0; i < 3; i++) {
        eventRepository.save(Event.builder()
                .name("스프링 스터디" + i)
                .location(i+"호선")
                .description("돌덩이 맥북과 함께")
                .build());
        }

    }

    @Test
    public void test_whenBasicCaseIsGiven_repoWillSaveEntity() {
        Event e = Event.builder()
                .name("스프링 스터디")
                .location("4호선")
                .description("돌덩이 맥북과 함께")
                .build();

        Event saved = eventRepository.save(e);

        assertThat(saved.getId()).isNotNull();
    }

    @Test
    public void test_whenFindAllEntity_repoWillReturnAtLeast3Entities() {
        List<Event> events = eventRepository.findAll();
        assertThat(events).isNotEmpty();
        events.stream().forEach(e -> {
            assertTrue(String.format("test failed! [%d]", e.getId()), e.getId() > -1);
        });

    }
}
