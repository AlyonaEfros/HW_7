package page;

import com.codeborne.selenide.SelenideElement;
import page.components.CalendarComponent;
import page.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistratoinPage {
    private final String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberInput =  $("#userNumber"),
            genderInput =  $("#genterWrapper"),
            dateOfBirthInput = $(".react-datepicker-wrapper"),
            subjectsInput =  $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            stateCityWrapper = $("#stateCity-wrapper"),
            submit = $("#submit");


    public RegistratoinPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#footer').remove()");

        return this;

    }

    public RegistratoinPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }

    public RegistratoinPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public RegistratoinPage setEmail(String value){
        emailInput.setValue(value);

        return this;
    } 
    
    public RegistratoinPage setNumber (String value){
        numberInput.setValue(value);

        return this;
    }

    public RegistratoinPage setGender (String value){
       genderInput.$(byText(value)).click();

        return this;
    }

    public RegistratoinPage setBirthDate (String day, String month, String year){
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistratoinPage verifyModalAppear (){
       registrationResultsModal.verifyModalAppear();

        return this;
    }

    public RegistratoinPage verifyResult(String key, String value){
    registrationResultsModal.verifyResult(key, value);

        return this;
    }

    public RegistratoinPage setSubjects (String value){
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistratoinPage setHobbies (String value){
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    public RegistratoinPage setPicture (String img){
        uploadPicture.uploadFromClasspath(img);

        return this;
    }

    public RegistratoinPage setAddress (String value){
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistratoinPage setState (String value){
        stateInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistratoinPage setCity (String value){
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistratoinPage setSubmit (){
       submit.click();

        return this;
    }
}
