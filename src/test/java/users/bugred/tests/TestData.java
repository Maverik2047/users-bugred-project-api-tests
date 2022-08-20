package users.bugred.tests;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();
    String email = faker.internet().safeEmailAddress();
    String name = faker.name().fullName();
    String password = String.valueOf(faker.random().nextInt(1000, 10000));
}
