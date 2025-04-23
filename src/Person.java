import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age = OptionalInt.empty();
    protected String address;


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, OptionalInt age) {
        this(name, surname);
        this.age = age;
    }

    public boolean hasAge() {
        return age.isPresent();
    }
    public boolean hasAddress() {
        return address != null;
    }

    public void happyBirthday() {
        if (age.isPresent()) {
            age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {;
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.
                setSurname(surname).
                setAge(2).
                setAddress(address);
        return personBuilder;
    }

    @Override
    public String toString() {
        StringBuilder dataPerson = new StringBuilder();
        dataPerson.append(getName() + " ");
        dataPerson.append(getSurname());
        if (hasAge()) {
            dataPerson.append(", возраст: " + getAge().getAsInt());
        } else {
            dataPerson.append(", возраст неизвестен");
        }

        if(hasAddress()) {
            dataPerson.append(", город проживания: " + getAddress());
        } else {
            dataPerson.append(", город проживания неизвестен");
        }

        return dataPerson.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
