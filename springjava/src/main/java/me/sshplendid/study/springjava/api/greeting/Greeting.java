package me.sshplendid.study.springjava.api.greeting;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Greeting {
    private static final String GREETING_TEMPLATE = "Hello, %s!";

    @Id @GeneratedValue
    private Integer id;
    private String name;
    private String content;
    private LocalDateTime dateTime;

    public Greeting(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.content = String.format(GREETING_TEMPLATE, name);
        this.dateTime = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
