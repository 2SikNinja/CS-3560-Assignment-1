import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SimulationDriver {

    public static void main(String[] args)
    {

     	List<Question> questions = new ArrayList<>();

     	questions.add(new SingleChoiceQuestion("What type is Bulbasaur?", Arrays.asList("Fire", "Water", "Grass/Poison", "Normal"), Arrays.asList("Grass/Poison")));
		questions.add(new SingleChoiceQuestion("Which Pokemon evolves into Ivysaur?", Arrays.asList("Bulbasaur", "Charmander", "Pikachu", "Squirtle"), Arrays.asList("Bulbasaur")));
		questions.add(new SingleChoiceQuestion("Who is Ash's main Pokemon?", Arrays.asList("Charizard", "Pikachu", "Bulbasaur", "Squirtle"), Arrays.asList("Pikachu")));
		questions.add(new SingleChoiceQuestion("What does Pikachu evolve into?", Arrays.asList("Raichu", "Jolteon", "Pichu", "None"), Arrays.asList("Raichu")));
		questions.add(new SingleChoiceQuestion("Which Pokemon evolves into Wartortle?", Arrays.asList("Bulbasaur", "Squirtle", "Charmander", "Pikachu"), Arrays.asList("Squirtle")));
		questions.add(new SingleChoiceQuestion("Who is Ash's main rival?", Arrays.asList("Brock", "Misty", "Gary", "Professor Oak"), Arrays.asList("Gary")));
		questions.add(new SingleChoiceQuestion("What type is Pikachu?", Arrays.asList("Electric", "Water", "Fire", "Grass"), Arrays.asList("Electric")));
		questions.add(new SingleChoiceQuestion("What is Ash's last name?", Arrays.asList("Ketchum", "Oak", "Johto", "Brock"), Arrays.asList("Ketchum")));
		questions.add(new SingleChoiceQuestion("Who is the professor in the first season?", Arrays.asList("Professor Birch", "Professor Oak", "Professor Elm", "Professor Ivy"), Arrays.asList("Professor Oak")));	
		
		questions.add(new MultipleChoiceQuestion("Which of the following are Legendary Pokemon?", Arrays.asList("Pikachu", "Eevee", "Raikou", "Groudon"), Arrays.asList("Raikou", "Groudon")));
		questions.add(new MultipleChoiceQuestion("Which of the following are starter Pokemon?", Arrays.asList("Charmander", "Pikachu", "Eevee", "Squirtle"), Arrays.asList("Charmander", "Squirtle")));
		questions.add(new MultipleChoiceQuestion("Which of the following are Pokemon types?", Arrays.asList("Fire", "Water", "Grass", "None"), Arrays.asList("Fire", "Water", "Grass")));
		questions.add(new MultipleChoiceQuestion("Which of the following are Pokemon regions?", Arrays.asList("Kanto", "Johto", "Hoenn", "None"), Arrays.asList("Kanto", "Johto", "Hoenn")));
		questions.add(new MultipleChoiceQuestion("Which of the following are Pokemon games?", Arrays.asList("Pokemon Red", "Pokemon Blue", "Pokemon Yellow", "Pokemon Green"), Arrays.asList("Pokemon Red", "Pokemon Blue", "Pokemon Yellow")));
		questions.add(new MultipleChoiceQuestion("Which of the following are Pokemon professors?", Arrays.asList("Professor Oak", "Professor Elm", "Professor Birch", "Professor Ivy"), Arrays.asList("Professor Oak", "Professor Elm", "Professor Birch")));
		questions.add(new MultipleChoiceQuestion("Which of the following are Pokemon regions?", Arrays.asList("Kanto", "Johto", "Hoenn", "Sinnoh"), Arrays.asList("Kanto", "Johto", "Hoenn", "Sinnoh")));

	   

        Random random = new Random();
        Question question = questions.get(random.nextInt(questions.size()));
        VotingService votingService = new VotingService(question);

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            students.add(new Student("student" + (i + 1)));
        }

        for (Student student : students) {
            List<String> studentAnswer;

            if (question instanceof SingleChoiceQuestion) {
                studentAnswer = Arrays.asList(question.getChoices().get(random.nextInt(question.getChoices().size())));
            } else {
                studentAnswer = new ArrayList<>();
                for (String choice : question.getChoices()) {
                    if (random.nextBoolean()) {
                        studentAnswer.add(choice);
                    }
                }
            }

            student.submitAnswers(studentAnswer);
            votingService.submitVote(student, studentAnswer);
        }

        votingService.displayResults();
    }
}
