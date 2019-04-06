import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.junit.Assert.assertEquals;

public class TestNoValidFilling extends BaseRunner {
    @Test
    public void testNoValidFilling() {
        driver.get(baseUrl);
        driver.findElement(By.name("fio")).click();
        driver.findElement(By.name("fio")).sendKeys("иванов");
        driver.findElement(By.name("phone_mobile")).click();
        driver.findElement(By.name("phone_mobile")).sendKeys("+7(999)");
        driver.findElement(By.name("phone_mobile")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Оставить заявку'])[1]/following::div[2]")).click();
        assertEquals("Номер телефона должен состоять из 10 цифр, начиная с кода оператора", driver.findElement(By.xpath("//div[contains(text(),'Номер телефона должен состоять')]")).getText());
        assertEquals("Недостаточно информации. Введите фамилию, имя и отчество через пробел (Например: Иванов Иван Алексеевич)", driver.findElement(By.xpath("//div[contains(text(),'Недостаточно информации. Введите фамилию, имя и от')]")).getText());
    }

}
