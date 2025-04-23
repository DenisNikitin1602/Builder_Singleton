import java.util.OptionalInt;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected OptionalInt age = OptionalInt.empty();
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) {
        if (age <= 0) throw new IllegalArgumentException("Возраст должен быть больше нуля");
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }



    public Person build() {
        if ((name == null || name.isBlank()) && (surname == null || surname.isBlank())) {
            throw new IllegalStateException("Нет имени и фамилии");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalStateException("Нет имени");
        }

        if (surname == null || surname.isBlank()) {
            throw new IllegalStateException("Нет фамилии");
        }

        Person person = age.isPresent()
                ? new Person(name, surname, age) : new Person(name, surname);

        person.setAddress(address);
        return person;
    }
}