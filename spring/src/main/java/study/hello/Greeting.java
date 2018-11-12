package study.hello;

public class Greeting {
    private String name;
    private String content;

    public Greeting(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
}
