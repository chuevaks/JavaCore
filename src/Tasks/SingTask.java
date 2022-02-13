package Tasks;

import Competition.Result;
import Participants.Animal;
import Participants.Team;

public class SingTask extends Task{

    @Override
    public void perform(Team team) {
        Animal[] players = team.getPlayers();
        for (int i = 0; i < players.length; i++) {
            if (players[i].getSing()==true) {
                team.writeResult(new Result(true, players[i]," successfully sings a song"));
            } else {
                team.writeResult(new Result(false, players[i], " not passed"));
            }
        }
    }
}