package bdd.utils;

import bdd.objects.UserRegistrationData;
import com.github.javafaker.Faker;
import lecture13.homework13.objects.UserRegistrationData;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class FakerUtils {

    private final String emailPostfix = "@email.com";
    protected Faker faker = new Faker();

    public UserRegistrationData generateRegistrationData() {
        UserRegistrationData userRegistrationData = new UserRegistrationData();

        userRegistrationData.setFirstName(faker.name().firstName());
        userRegistrationData.setLastName(faker.name().lastName());
        userRegistrationData.setEmail(faker.name().firstName() + emailPostfix);
        userRegistrationData.setDateOfBirthDay(
                new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                        .format(faker.date().birthday()).split("/")[0]
        );
        userRegistrationData.setDateOfBirthMonth(
                new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                        .format(faker.date().birthday()).split("/")[1]
        );
        userRegistrationData.setDateOfBirthYear(
                new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                        .format(faker.date().birthday()).split("/")[2]
        );
        userRegistrationData.setCountry(faker.country().countryCode2());
        userRegistrationData.setState(faker.country().capital());
        return userRegistrationData;
    }

    public String[] generateDOB() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMMM/yyyy/dd", Locale.ENGLISH);
        String buffer = simpleDateFormat.format(faker.date().birthday());
        return buffer.split("/");
    }

}
