import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class TestWithoutFilling extends BaseRunner{

        @Test
        public void testWithoutFilling() {
            driver.get(baseUrl);
            driver.findElement(By.name("fio")).click();
            driver.findElement(By.name("phone_mobile")).click();
            driver.findElement(By.name("email")).click();
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия, имя и отчество'])[1]/following::div[3]")).click();
            assertEquals("Укажите ваше ФИО", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия, имя и отчество'])[1]/following::div[3]")).getText());
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Контактный телефон'])[1]/following::div[2]")).click();
            assertEquals("Необходимо указать номер телефона", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Контактный телефон'])[1]/following::div[2]")).getText());
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Не имею гражданства РФ'])[2]/following::div[8]")).click();
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Оставить заявку'])[1]/following::div[2]")).click();
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='условия передачи информации'])[1]/following::div[1]")).click();
            assertEquals("Для продолжения нужно согласие с условиями", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='условия передачи информации'])[1]/following::div[1]")).getText());
        }


    }

