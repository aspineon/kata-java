package net.sshplendid.study.java.whiteship.events;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EventTests {

    @Test
    public void test_Builder() {
        final String nameOfEvent = "KSUG seminar";

        Event event = Event.builder()
                .name(nameOfEvent)
                .build();

        assertEquals(String.format("Different! %s:%s", nameOfEvent, event.getName()),  nameOfEvent, event.getName());
    }

    @Test
    public void test_javaBean() {
        final String nameOfEvent = "KSUG seminar";

        Event event = new Event();
        event.setName(nameOfEvent);

        assertEquals(String.format("Different! %s:%s", nameOfEvent, event.getName()),  nameOfEvent, event.getName());
    }
}
