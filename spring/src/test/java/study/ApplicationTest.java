package study;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ApplicationTest {
    @Test
    public void testApplication() {
        String[] args = {};
        Application app = new Application();
        app.main(args);
        assertNotNull(app);
    }
}
