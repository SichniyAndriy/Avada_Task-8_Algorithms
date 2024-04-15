package ch_06;

import net.datafaker.Faker;

public class Main {
    private final static Faker faker = new Faker();

    public static void main(String[] args) throws IllegalAccessException {
       Person person = new Person();
       person.setName(faker.name().fullName());
       person.setAge(faker.random().nextInt(20, 75));

       Address address = new Address();
       address.setCity(faker.address().city());
       address.setStreet(faker.address().streetName());
       address.setNumber(Integer.valueOf(faker.address().buildingNumber()));
       person.setAddress(address);

       person.getCard()[0] = faker.stock().nsdqSymbol();
       person.getCard()[1] = faker.stock().nyseSymbol();

       Cat cat = new Cat();
       cat.setBreed(faker.cat().breed());
       cat.setName(faker.cat().name());
       cat.setAge(faker.random().nextInt(1, 12));
       person.getPets().add(cat);

       Dog dog = new Dog();
       dog.setBreed(faker.dog().breed());
       dog.setName(faker.dog().name());
       dog.setAge(faker.random().nextInt(1, 12));
       person.getPets().add(dog);

       for (int i = 0; i < faker.random().nextInt(1, 3); ++i) {
          person.getLanguages().put(faker.programmingLanguage().name(), faker.university().name());
       }

       System.out.println(ConverterToJson.prettyConvertToJson(person));
    }
}
