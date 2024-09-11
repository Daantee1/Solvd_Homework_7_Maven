package Homework_9.Enum;

public enum Animals {
    CAT("Cat", 5){
        @Override
        public String getSound() {
            return "Meow";
        }
    },
    DOG("Dog", 6){
        @Override
        public String getSound() {
            return "Woof";
        }
    },
    HORSE("Horse", 2){
    };

    private String name;
    private int quantity;

    Animals(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
    public String getSound(){
        return "Unknown sound";
    }
}
