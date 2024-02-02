package ru.netology.service;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class AppCard {

    @Test
    void shoulTest() throws InterruptedException {
        int interval = 0;

        open("http://localhost:9999/");
        $("[data-test-id='city'] input").setValue("Ярославль");
        Thread.sleep(interval);
        $("[data-test-id='date'] button").click();
        Thread.sleep(interval);
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        Thread.sleep(interval);
        String date = LocalDate
                .now()
                .plusDays(4)
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id='date'] input").setValue(date);
        Thread.sleep(interval);
        $("[data-test-id='name'] input").setValue("Мягкие Лапки");
        Thread.sleep(interval);
        $("[data-test-id='phone'] input").setValue("+79118226633");
        Thread.sleep(interval);
        $("[data-test-id='agreement']").click();
        Thread.sleep(interval);
        $(".button_view_extra").click();
        Thread.sleep(interval);
        $("[data-test-id='notification'] .notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на " + date));
        Thread.sleep(interval);


    }

}