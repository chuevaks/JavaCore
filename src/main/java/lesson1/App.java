package lesson1;

import lesson1.Competition.Course1;
import lesson1.Participants.Team;

public class App {
    public static void main(String[] args) {
        Course1 course = new Course1(); // Создаем полосу препятствий
        Team firstTeam = new Team("Scrambled legs"); // Создаем команду
        firstTeam.getTeamInfo();
        course.doIt(firstTeam); // Просим команду пройти полосу
        firstTeam.printResults(); // Показываем результаты

    }

}
