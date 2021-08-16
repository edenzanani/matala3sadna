
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello ");
        System.out.println("PLease enter your UserName -only words-");
        String userName = scan.nextLine();
        System.out.println("PLease enter your Password -only numbers- ");
        String password = scan.nextLine();

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\shila\\Downloads\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.aac.ac.il/");
        List<WebElement> elementList = driver.findElements(By.cssSelector("a[href='https://portal.aac.ac.il']"));
        WebElement information = elementList.get(0);
        information.click();
        WebElement userNameInput = driver.findElement(By.id("Ecom_User_ID"));
        userNameInput.sendKeys(userName);
        WebElement userPassword = driver.findElement(By.id("Ecom_Password"));
        userPassword.sendKeys(password);
        WebElement enter = driver.findElement(By.id("wp-submit"));
        enter.click();
        WebElement moodle = driver.findElement(By.cssSelector("a[href='https://moodle.aac.ac.il/login/index.php']"));
        moodle.click();
        Thread.sleep(3000);
        List<WebElement> coursesList = driver.findElements(By.className("multiline"));
        for (int i = 0 ; i < coursesList.size() ; i ++  ){
            System.out.println (i + "-" + coursesList.get(i).getText());
        }
        Thread.sleep(3000);
        System.out.println("which course you choose ? ");
        System.out.println("Enter his number ");
        int userchoose = scan.nextInt();
        coursesList.get(userchoose).getText();
        coursesList.get(userchoose).click();

        Thread.sleep(3000);
        WebElement userButton = driver.findElement(By.className("userbutton"));
       userButton.click();
       WebElement outOfMoodle = driver.findElement(By.id("actionmenuaction-6"));
       outOfMoodle.click();
       WebElement logOut = driver.findElement(By.cssSelector("a[href=https://portal.aac.ac.il/AGLogout]"));
       logOut.click();
    }


}
