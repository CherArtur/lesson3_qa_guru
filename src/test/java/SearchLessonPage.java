import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchLessonPage {
    @Test
    void openPageFromHover() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";

        //Открыть страницу Github
        open("https://github.com/");
        //Проверка загрузки страницы (отображение заголовка на главной)
        $(".h0-mktg").shouldHave(text("Let’s build from here"));
        //Наведение курсора на Solutions и раскрытие списка
        $$("li.HeaderMenu-item").get(1).$(byText("Solutions")).hover();
        //Перейти на страницу Enterprise
        $(byText("Enterprise")).click();
        //Проверка заголовка на странице
        $("h1").shouldHave(Condition.text("Build like the best"));

    }

    @Test
    void useDrugAndDrop() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";

        //Открыть страницу drag and drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //Перетащить блок А на место блока Б
        $("#column-a").dragAndDropTo($("#column-b"));
        //Проверка текста в блоке Б (должно быть установлено А)
        $("#column-b").shouldHave(text("A"));
    }
}
