import java.io.Serializable;

public class Person implements Serializable {
    private int age;
    private String name;
    private String address;

    // Геттер для возраста
    public int getAge() {
        return age;
    }

    // Сеттер для возраста
    public void setAge(int age) {
        this.age = age;
    }

    // Геттер для имени
    public String getName() {
        return name;
    }

    // Сеттер для имени
    public void setName(String name) {
        this.name = name;
    }

    // Геттер для адреса
    public String getAddress() {
        return address;
    }

    // Сеттер для адреса
    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
