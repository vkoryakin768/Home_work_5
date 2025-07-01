import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class CheckEnterprize {
    @BeforeAll
    static void basicBrowserSettings() {

        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";

    }
    @Test
    void checkEnterprize(){
        open("https://github.com");
        $(withTagAndText("button", "Solutions")).hover();
        $(withTagAndText("a", "Enterprises")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));



    }
}
