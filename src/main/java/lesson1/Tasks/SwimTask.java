package lesson1.Tasks;

import lesson1.Competition.Result;
import lesson1.Participants.Animal;
import lesson1.Participants.Team;

public class SwimTask extends Task{
    private final int swimDistance;

    public SwimTask(int swimDistance) {
        this.swimDistance = swimDistance;
    }

    @Override
    public void perform(Team team) {
        Animal[] players = team.getPlayers();
        for (int i = 0; i < players.length; i++) {
            if (swimDistance <= players[i].getMaxRun()) {
                team.writeResult(new Result(true, players[i]," successfully swims " + swimDistance + " m."));
            } else {
                team.writeResult(new Result(false, players[i], " not passed"));
            }
        }
    }
}