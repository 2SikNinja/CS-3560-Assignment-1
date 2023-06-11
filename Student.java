import java.util.List;

public class Student {
    private String id;
    private List<String> answers;

    public Student(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void submitAnswers(List<String> answers) {
        this.answers = answers;
    }

    public List<String> getAnswers() {
        return answers;
    }
}
