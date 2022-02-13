package Competition;

import Participants.Animal;

public class Result {

    public final boolean isPassed;
    public final String message;
    public final Animal animal;

    public Result(boolean isPassed,Animal animal, String message) {
        this.isPassed = isPassed;
        this.message = message;
        this.animal = animal;
    }
}