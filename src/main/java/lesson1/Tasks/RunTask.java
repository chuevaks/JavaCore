package lesson1.Tasks;

import lesson1.Competition.Result;
import lesson1.Participants.Animal;
import lesson1.Participants.Team;

public class RunTask extends Task{
    private final int runDistance;

    public RunTask(int runDistance) {
        this.runDistance = runDistance;
    }

    @Override
    public void perform(Team team) {
        Animal[] players = team.getPlayers();
        for (int i = 0; i < players.length; i++) {
            if (runDistance <= players[i].getMaxRun()) {
                team.writeResult(new Result(true, players[i], " successfully runs " + runDistance + " m."));
            } else {
                team.writeResult(new Result(false, players[i]," not passed"));
            }
        }
    }
}