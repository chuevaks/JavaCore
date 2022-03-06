package lesson1.Participants;

import lesson1.Competition.Result;

import java.util.ArrayList;

public class Team {
    private String name;
    private int teamSize = 4;
    private Animal teamPlayers[] = new Animal[teamSize];
    private ArrayList<Result> results = new ArrayList<>();

    public String getName() {
        return name;
    }

    public Team(String name) {
        this.name = name;
        for (int i = 0; i < teamSize; i++) {
            this.teamPlayers[i] = Animal.getRandomAnimal();
        }
    }

    public Animal[] getPlayers() {
        return teamPlayers;
    }

    public void getTeamInfo() {
        System.out.println("Team: " + this.name);
        for (int i = 0; i < teamSize; i++) {
            System.out.println(teamPlayers[i]);
        }
    }

    public void printResults() {
        System.out.println("*****************");
        System.out.println("Results of " + this.name);
        System.out.println("*****************");
        int finalScore = 0;
        for (Result result : results) {
            System.out.println(result.animal+result.message);
            if (result.isPassed) {
                finalScore++;
            }
        }
        System.out.println("********************");
        System.out.println("Final score for team " + this.name + " is: " + finalScore);
    }

    public void writeResult(Result result) {
        results.add(result);
    }
}