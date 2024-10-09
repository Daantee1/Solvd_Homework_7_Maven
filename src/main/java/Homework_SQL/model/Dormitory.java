package Homework_SQL.model;

public class Dormitory {
    private int id;
    private String name;
    private int room;
    private String address;

    public Dormitory(int id, String name, int room, String address) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.address = address;
    }
    public Dormitory(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRoom() {
        return room;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Dormitory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", room=" + room +
                ", address='" + address + '\'' +
                '}';
    }
}
