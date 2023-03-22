package test;

import org.junit.jupiter.api.Test;

public class RegistrationTest extends TestBase {

    @Test
    void fillFormTest() {
        String UserName = "Alyona";
        String UserLastName = "Efros";
        String UserEmail = "Alyona@F.ru";
        String UserGender = "Other";
        String UserNumber = "3478585434";
        String UserBirthDay_day = "29";
        String UserBirthDay_month = "May";
        String UserBirthDay_year = "1999";
        String UserSubjects = "English";
        String UserHobbies = "Reading";
        String UserPictureLocation = "pictures/cat.jpeg";
        String UserAddress = "my address";
        String UserState = "Haryana";
        String UserCity = "Panipat";

        registratoinPage.openPage()
                .setFirstName(UserName)
                .setLastName(UserLastName)
                .setEmail(UserEmail)
                .setGender(UserGender)
                .setNumber(UserNumber)
                .setBirthDate(UserBirthDay_day, UserBirthDay_month, UserBirthDay_year)
                .setSubjects(UserSubjects)
                .setHobbies(UserHobbies)
                .setPicture(UserPictureLocation)
                .setAddress(UserAddress)
                .setState(UserState)
                .setCity(UserCity)
                .setSubmit();

        registratoinPage.verifyModalAppear()
                .verifyResult("Student Name", UserName + " " + UserLastName)
                .verifyResult("Student Email", UserEmail)
                .verifyResult("Gender", UserGender)
                .verifyResult("Mobile", UserNumber)
                .verifyResult("Date of Birth", UserBirthDay_day + " " + UserBirthDay_month + "," + UserBirthDay_year)
                .verifyResult("Subjects", UserSubjects)
                .verifyResult("Hobbies", UserHobbies)
                .verifyResult("Picture", "cat.jpeg")
                .verifyResult("Address", UserAddress)
                .verifyResult("State and City", UserState + " " + UserCity);
    }

}
