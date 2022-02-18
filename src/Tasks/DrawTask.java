package Tasks;

import Competition.Result;
import Participants.Animal;
import Participants.Team;

public class DrawTask extends Task{

    @Override
    public void perform(Team team) {
        Animal[] players = team.getPlayers();
        for (int i = 0; i < players.length; i++) {
            if (players[i].getDraw()==true) {
                team.writeResult(new Result(true, players[i], " successfully draws some Abstraction "));
            } else {
                team.writeResult(new Result(false,players[i], " not passed"));
            }
        }
    }
}