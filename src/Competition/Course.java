package Competition;

import Participants.Team;
import Tasks.*;

public class Course {

    private Task[] tasks;

    public Course() {
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