package net.sshplendid.study.java.whiteship.greeting;

import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class GreetingControllerTests extends CommonControllerTests {

    @Test
    public void test_getGreeting_withoutParameter() throws Exception {
        this.mockMvc.perform(get("/greeting"))
                .andDo(print())
//                .andExpect(content().string("Hello, World!"))
                .andExpect(jsonPath("$.content").value("Hello, World!"))
                .andExpect(status().isOk());
    }



    @Test
    public void test_getGreeting_withParameter() throws Exception {
        // GIVEN
        final String name = "Shawn";

        this.mockMvc.perform(get("/greeting").param("name", name))
                .andDo(print())
//                .andExpect(content().string("Hello, Shawn!"))
                .andExpect(jsonPath("$.content").value("Hello, Shawn!"))
                .andExpect(status().isOk());
    }
}
