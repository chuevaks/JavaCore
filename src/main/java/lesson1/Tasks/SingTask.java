package lesson1.Tasks;

import lesson1.Competition.Result;
import lesson1.Participants.Animal;
import lesson1.Participants.Team;

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