package lesson1.Competition;

import lesson1.Participants.Team;
import lesson1.Tasks.*;

public class Course1 {

    private Task[] tasks;

    public Course1() {
        tasks = new Task[4];
        tasks[0] = new RunTask(8);
        tasks[1] = new SwimTask(5);
        tasks[2] = new DrawTask();
        tasks[3] = new SingTask();
    }

    public void doIt(Team team) {
        for (int i = 0; i < tasks.length; i++) {
            tasks[i].perform(team);
        }
    }
}