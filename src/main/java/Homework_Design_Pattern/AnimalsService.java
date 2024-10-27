package Homework_Design_Pattern;

public class AnimalsService {

    public void setAnimal(){
        AnimalsBase animalsBase = AnimalsFactory.createAnimal();
        animalsBase.run();
    }
}
