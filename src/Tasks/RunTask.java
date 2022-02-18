package Tasks;

import Competition.Result;
import Participants.Animal;
import Participants.Team;

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