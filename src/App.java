import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {
    public static void main(String[] args) {
        // Создание и инициализация экземпляра класса Person
        Person person = new Person();
        person.setAge(30);
        person.setName("John Doe");
        person.setAddress("123 Main St, City");

        // Сериализация объекта Person в файл
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            objectOutputStream.writeObject(person);
            System.out.println("Объект Person сериализован в файл 'person.ser'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десериализация объекта Person из файла
        Person deserializedPerson = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.ser"))){
            deserializedPerson = (Person) objectInputStream.readObject();
            System.out.println("Объект Person успешно десериализован из файла 'person.ser'");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Вывод данных десериализованного объекта
        if (deserializedPerson != null) {
            System.out.println("Возраст: " + deserializedPerson.getAge());
            System.out.println("Имя: " + deserializedPerson.getName());
            System.out.println("Адрес: " + deserializedPerson.getAddress());
        }
    }
}
