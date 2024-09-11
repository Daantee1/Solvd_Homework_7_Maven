package Homework_9.Enum;

public enum Phones {
    IPHONE("Iphone", "10"){
        @Override
        public String getSystem() {
            return "iOS";
        }
    },
    SAMSUNG("Samsung", "s11"),
    HUAWEI("Huawei", "p7"),
    XIAOMI("Xiaomi", "pocox6");

    private String name;
    private String model;

    Phones(String name, String model) {
        this.name = name;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }
    public String getSystem(){
        return "Android";
    }
}
