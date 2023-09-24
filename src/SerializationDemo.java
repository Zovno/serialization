import java.io.*;
import java.util.Arrays;

public class SerializationDemo {

    public static void main(String[] args) {
        // Создаем массив объектов Person
        Person[] people = new Person[3];
        people[0] = new Person();
        people[0].setName("Alice");
        people[0].setAge(30);
        people[0].setAddress("123 Main St");

        people[1] = new Person();
        people[1].setName("Bob");
        people[1].setAge(25);
        people[1].setAddress("456 Elm St");

        people[2] = new Person();
        people[2].setName("Charlie");
        people[2].setAge(35);
        people[2].setAddress("789 Oak St");

        // Сериализация массива
        try {
            FileOutputStream fileOut = new FileOutputStream("people.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(people);
            out.close();
            fileOut.close();
            System.out.println("Массив объектов Person успешно сериализован в 'people.ser'");
        } catch (IOException i) {
            i.printStackTrace();
        }

        // Десериализация массива
        Person[] deserializedPeople = null;
        try {
            FileInputStream fileIn = new FileInputStream("people.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            deserializedPeople = (Person[]) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Массив объектов Person успешно десериализован из 'people.ser'");
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Person class not found");
            c.printStackTrace();
        }

        // Вывод десериализованных объектов
        if (deserializedPeople != null) {
            System.out.println("Десериализованные объекты:");
            Arrays.stream(deserializedPeople).forEach(System.out::println);
        }
    }
}
