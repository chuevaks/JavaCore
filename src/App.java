import Competition.Course;
import Participants.Team;

public class App {
    public static void main(String[] args) {
        Course course = new Course(); // Создаем полосу препятствий
        Team firstTeam = new Team("Scrambled legs"); // Создаем команду
        firstTeam.getTeamInfo();
        course.doIt(firstTeam); // Просим команду пройти полосу
        firstTeam.printResults(); // Показываем результаты

    }

}
