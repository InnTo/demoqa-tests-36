import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm {

    @BeforeAll
    static void setUp(){  //аннотация BeforeAll должна идти с методом static
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillRegistrationFormTest() {
        open("/automation-practice-form");

        //Заполнение формы
        $("#firstName").setValue("Test");
        $("#lastName").setValue("TestLastName");
        $("#userEmail").setValue("Test@test.ru");
        $(byText("Male")).click();
        $("#userNumber").setValue("8961530834");
       // $("#dateOfBirthInput").setValue("Another test address"); //Дата и так есть и можно не вводить

        $("#subjectsInput").setValue("Maths");
        $$(".subjects-auto-complete__option").findBy(text("Maths")).click(); //. указывает, что это класс, а не тег, можно явно прописывать класс


        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("test.jpg");
        $("#currentAddress").setValue("Current test address");

        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Agra")).click();

        $("#submit").click();

        //Проверка заполнения
        $(".table-responsive").shouldHave(text("Test TestLastName"));
        $(".table-responsive").shouldHave(text("Test@test.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("8961530834"));
        $(".table-responsive").shouldHave(text("15 June,2025"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("test.jpg"));
        $(".table-responsive").shouldHave(text("Current test address"));
        $(".table-responsive").shouldHave(text("Uttar Pradesh Agra"));
    }
}
