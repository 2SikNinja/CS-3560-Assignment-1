import java.util.*;

public abstract class Question {
    private String question;
    private List<String> choices;
    private List<String> correctAnswers;

    public Question(String question, List<String> choices, List<String> correctAnswers) {
        this.question = question;
        this.choices = choices;
        this.correctAnswers = correctAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getChoices() {
        return choices;
    }

    public List<String> getCorrectAnswers() {
        return correctAnswers;
    }
}
