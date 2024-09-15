package Homework_10;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.lang.reflect.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final Logger LOGGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {



    ArrayList<String> list = new ArrayList<>();
    list.add("Hello");
    list.add("World");
    list.stream().filter(x -> x.startsWith("W")).forEach(y -> LOGGGER.info(y));

        System.out.println("------");

    HashMap<String, Integer> computerGamesMap = new HashMap<>();
    computerGamesMap.put("Wiedzmin 3", 1);
    computerGamesMap.put("Assassin's Creed Odyssey", 2);
    computerGamesMap.put("Red Dead Redemption 2", 3);
    computerGamesMap.entrySet().stream().filter(x -> x.getValue() > 1).forEach(y -> System.out.println(y.getKey()));

        System.out.println("------");

    List<Car> carList = new ArrayList<>();
    carList.add(new Car("BMW", 2019));
    carList.add(new Car("Ford", 2020));
    carList.stream().map(x -> x.getBrand()).forEach(y -> System.out.println(y));

        System.out.println("------");

    Set<Car> carSet = new HashSet<>();
    carSet.add(new Car("BMW", 2000));
    carSet.add(new Car("Audi", 2002));
    carSet.add(new Car("Volvo", 2008));
    carSet.stream().filter(x -> x.getYear() == 2008).map(x -> x.getBrand()).forEach(y -> System.out.println(y));;

        System.out.println("------");

    Set<Animal> animalSet = new HashSet<>();
    animalSet.add(new Animal("Shark", 20));
    animalSet.add(new Animal("Elephant", 50));
    animalSet.add(new Animal("Tiger", 5));
    int sumOfAges = animalSet.stream().map(x -> x.getAge()).reduce(0, (x,y) -> x+y);
    LOGGGER.info(sumOfAges);

        System.out.println("------");

    List<Student> studentList = new ArrayList<>();
    studentList.add(new Student("Alex", 20));
    studentList.add(new Student("Bob", 22));
    studentList.add(new Student("Maria", 23));
    List<Integer> ages=  studentList.stream().filter(x -> x.getAge() > 21).map(x -> x.getAge()).collect(Collectors.toList());
    LOGGGER.error(ages);

        System.out.println("------");

    TreeMap<Student, Integer> studentMap = new TreeMap<>();
    studentMap.put(new Student("Jacob", 20), 0);
    studentMap.put(new Student("John", 22), 1);
    studentMap.put(new Student("Emma", 23), 2);
    studentMap.entrySet().stream().forEach( x -> System.out.println(x));

        System.out.println("------");

        Class phoneClass = Phone.class;
        Constructor constructor = phoneClass.getConstructor(String.class);
        Phone phone = (Phone) constructor.newInstance("Iphone");
        System.out.println(phone.getModel());

        Method methodMakeCall = phoneClass.getMethod("makeCall");
        methodMakeCall.invoke(phone);

        phone.setModel("Xiaomi");
        methodMakeCall.invoke(phone);


        Field[] fields = phoneClass.getDeclaredFields();
        for(Field field: fields){
            System.out.println(field.getName());
            System.out.println(field.getType());
            System.out.println(field.getModifiers());
        }
        Method[] methods = phoneClass.getDeclaredMethods();
        for(Method method: methods){
            System.out.println(method.getName());
        }
        Constructor[] constructors = phoneClass.getConstructors();
        for(Constructor constructor1: constructors){
            System.out.println(constructor1.getParameterCount());
            Parameter[] parameters = constructor1.getParameters();
            for(Parameter parameter: parameters){
                System.out.println(parameter.getName());
                System.out.println(parameter.getType());

            }
        }



    }
}
