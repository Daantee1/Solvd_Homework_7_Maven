package Homework_9.Enum;

public enum Cars {
    TOYOTA("Toyota", 150, "Japan"),
    BMW("BMW", 250, "Germany"),
    FORD("Ford", 200, "USA"),
    TESLA("Tesla", 300, "USA"){
        @Override
        public String getEngine() {
            return "Electric engine";
        }
    };

    private String name;
    private int horsePower;
    private String country;

    Cars(String name, int horsePower, String country) {
        this.name = name;
        this.horsePower = horsePower;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getCountry() {
        return country;
    }
    public String getEngine(){
        return "Combustion engine";
    }
}
