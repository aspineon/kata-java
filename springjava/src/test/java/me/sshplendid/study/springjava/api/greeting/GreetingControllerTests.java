package me.sshplendid.study.springjava.api.greeting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class GreetingControllerTests {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void whenNoNameIsGiven_greetingWillInclude_World() throws Exception {
        this.mockMvc.perform(get("/api/greeting"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").exists())
                .andExpect(jsonPath("content").value("Hello, World!"))
                ;
    }
    @Test
    public void whenNameIsGiven_greetingWillInclude_Name() throws Exception {
        final String name = "Shawn";

        this.mockMvc.perform(get("/api/greeting").param("name", name))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").exists())
                .andExpect(jsonPath("content").value(String.format("Hello, %s!", name)))
                ;
    }
}
