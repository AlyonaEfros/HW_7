package test;

import org.junit.jupiter.api.Test;
import page.RegistrationPage;
import page.components.RegistrationResultsModal;

public class RegistrationTest extends TestBase {
    private final RegistrationPage registrationPage = new RegistrationPage();
    private final RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
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
        String UserSubject = "English";
        String UserHobby = "Reading";
        String UserPictureLocation = "pictures/cat.jpeg";
        String UserAddress = "my address";
        String UserState = "Haryana";
        String UserCity = "Panipat";


        registrationPage.openPage()
                .removeBanners()
                .setFirstName(UserName)
                .setLastName(UserLastName)
                .setEmail(UserEmail)
                .setGender(UserGender)
                .setNumber(UserNumber)
                .setBirthDate(UserBirthDay_day, UserBirthDay_month, UserBirthDay_year)
                .setSubject(UserSubject)
                .setHobby(UserHobby)
                .setPicture(UserPictureLocation)
                .setAddress(UserAddress)
                .setState(UserState)
                .setCity(UserCity)
                .submitButtonClick();

        registrationResultsModal.verifyModalAppear()
                .verifyResult("Student Name", UserName + " " + UserLastName)
                .verifyResult("Student Email", UserEmail)
                .verifyResult("Gender", UserGender)
                .verifyResult("Mobile", UserNumber)
                .verifyResult("Date of Birth", UserBirthDay_day + " " + UserBirthDay_month + "," + UserBirthDay_year)
                .verifyResult("Subjects", UserSubject)
                .verifyResult("Hobbies", UserHobby)
                .verifyResult("Picture", "cat.jpeg")
                .verifyResult("Address", UserAddress)
                .verifyResult("State and City", UserState + " " + UserCity);
    }

}
