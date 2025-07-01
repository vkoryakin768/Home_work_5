import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class TestOffset {
    @BeforeAll
    static void basicBrowserSettings() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";

    }
    @Test
    void offsetTestAAndB(){
        open("/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(200, 0).release().perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
        actions().moveToElement($("#column-b")).clickAndHold().moveByOffset(-200, 0).release().perform();
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
    }

    @Test
    void dragAndDropTest(){
        open("/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDrop(to("#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
        $("#column-b").dragAndDrop(to("#column-a"));
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

    }
}
