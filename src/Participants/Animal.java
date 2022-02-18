package Participants;

public enum Animal {

    Cat(10, 3, false, true),
    Snake(0, 5, false, false),
    Elephant(15,10, true, true),
    Hen(3, 0, true, true),
    Dog(10, 10, false, true),
    Horse(80, 10, true, false),
    Fox(10, 8, false, false),
    Rabbit(20, 0, false, false);

    private int maxRun;
    private int maxSwim;
    private boolean canDraw;
    private boolean canSing;

    Animal(int maxRun, int maxSwim, boolean canDraw, boolean canSing) {
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        this.canDraw = canDraw;
        this.canSing = canSing;
    }

    public static Animal getRandomAnimal() {
        return values()[(int) (Math.random() * values().length)];
    }

    public int getMaxRun(){
        return this.maxRun;
    }

    public int getMaxSwim(){
        return this.maxSwim;
    }

    public boolean getDraw(){
        return this.canDraw;
    }
    public boolean getSing(){
        return this.canSing;
    }
}
