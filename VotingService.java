import java.util.*;

public class VotingService {
    private Question question;
    private List<Student> students;

    public VotingService(Question question) {
        this.question = question;
        this.students = new ArrayList<>();
    }

    public void submitVote(Student student, List<String> studentAnswer) {
        student.submitAnswers(studentAnswer);
        students.add(student);
    }

    public void displayResults() {
        Map<String, Integer> results = new HashMap<>();

        for (String choice : question.getChoices()) {
            results.put(choice, 0);
        }

        for (Student student : students) {
            for (String answer : student.getAnswers()) {
                results.put(answer, results.get(answer) + 1);
            }
        }

        // print the results
        for (String choice : question.getChoices()) {
            System.out.println(choice + " : " + results.get(choice));
        }

        // print the correct answer(s)
        System.out.println("Correct answer(s): " + String.join(", ", question.getCorrectAnswers()));
    }
}
