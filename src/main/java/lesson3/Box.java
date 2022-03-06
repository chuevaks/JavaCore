package lesson3;

import java.util.ArrayList;

public class Box <T extends Fruit>{
    private ArrayList<T> content = new ArrayList<T>();

    public float getBoxWeight() {
        float boxWeight=0;
        for (int i = 0; i < content.size(); i++) {
            boxWeight = content.get(i).getWeight()+boxWeight;
        }
        return boxWeight;
    }

    public void addFruit(T fruit){
        content.add(fruit);
    }

    public boolean compare(Box <?> another){
       return this.getBoxWeight()== another.getBoxWeight();
    }

    public void moveFruits(Box <T> another){

        while (!this.content.isEmpty()) {
            T fruit = this.content.get(0);
            another.content.add(fruit);
            this.content.remove(0);
        }
    }
}
