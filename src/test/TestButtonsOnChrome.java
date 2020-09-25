package test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestButtonsOnChrome {

	public static void main(String[] args) {
		
		String projectLocation = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", projectLocation+"/lib/ChromeDriver/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://antycaptcha.amberteam.pl");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("EXERCISE 1 - THREE BUTTONS")).click();
		String code = driver.findElement(By.xpath("//table/tbody/tr[4]/td[3]")).getText();
		String[] parts = code.split(": ");
		String part2 = parts[1];

		String stringArray[];
		stringArray = splitToNChar(part2, 2);		
		
		for(int i=0; i<stringArray.length; i++) {
			if (stringArray[i].equals("b1")) {
				driver.findElement(By.id("btnButton1")).click();
			} else {
				driver.findElement(By.id("btnButton2")).click();
			}
		}
		driver.findElement(By.id("solution")).click();
	}

	
	private static String[] splitToNChar(String text, int size) {
        List<String> parts = new ArrayList<>();

        int length = text.length();
        for (int i = 0; i < length; i += size) {
            parts.add(text.substring(i, Math.min(length, i + size)));
        }
        return parts.toArray(new String[0]);
    }
}
