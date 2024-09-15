package Homework_10;

public class Phone {
    private String model;
    public Phone(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void makeCall() {
        System.out.println("Making a call with model: " + model);
    }
}
