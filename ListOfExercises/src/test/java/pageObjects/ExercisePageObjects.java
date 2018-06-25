package pageObjects;

import Model.Exercise;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julio on 20.6.2017.
 */
public class ExercisePageObjects {

    WebDriver driver;
    WebDriverWait wait;
    private String BASE_URL;
    ArrayList<Exercise> exercises;
    Exercise exercise = new Exercise();

    By searchField = By.id("autocomplete-search-input");
    By leftMenu = By.cssSelector(".left-off-canvas-toggle.menu-icon");
    By exerciseItem = By.cssSelector("li.exercises.active");
    By exerciseDescription = By.cssSelector(".exercise-description");
    By closeToCleanScreen = By.className("close-icon");
    String initialPosition;
    String execution;
    String watch;
    String commonMistakes;


    public ExercisePageObjects(WebDriver driver,WebDriverWait wait,String BASE_URL){
        this.driver = driver;
        this.wait = wait;
        this.BASE_URL = BASE_URL;
    }
    public void checkLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
    }

    public void clickOnLeftMenu(){
        WebElement elementLeftMenu = driver.findElement(leftMenu);
        elementLeftMenu.click();
        wait.until(ExpectedConditions.elementToBeClickable(exerciseItem));
    }
    public void clickOnExerciseItem(){
        WebElement elementExerciseItem = driver.findElement(exerciseItem);
        elementExerciseItem.click();
    }

    public void FillSearchField(String path,int initialRow,int lastRow,int initialCell,int lastCell) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        exercises = exercise.getLines(path,initialRow,lastRow,initialCell,lastCell);
        if(exercises!=null){
            for(int i=0;i<exercises.size();i++){
                WebElement elementSearchField = driver.findElement(searchField);
                elementSearchField.click();
                elementSearchField.clear();
                elementSearchField.sendKeys(exercises.get(i).getExerciseName());
                elementSearchField.sendKeys(Keys.ENTER);

                checkResultAfterSearch(i);
            }
        }else{
            Assert.assertNotNull("Cells of the file were not loaded",exercises);
        }
    }

    public void checkResultAfterSearch_OLDVERSION(int i){//not working for more than 1 result after search
        wait.until(ExpectedConditions.visibilityOfElementLocated(exerciseDescription));

        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        boolean verifyIfHasResults = driver.findElements(exerciseDescription).size() != 0;
        Assert.assertEquals("\nExpected: "+exercises.get(i).getExerciseName()+
                "\nActual: Exercise not found", true, verifyIfHasResults);
    }


    public void checkResultAfterSearch(int positionOfElement) throws InterruptedException {
        //WebElement elementExerciceList = driver.findElement(By.className("exercise-list"));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(listExercises));

        Thread.sleep(3000);
        List<WebElement> listOfElements = driver.findElements(By.className("exercise"));
        int numberOfElementsOnTheScreen = listOfElements.size();

        if(numberOfElementsOnTheScreen>1){
            String encontrar = "<span class=\"exercise-name\">"+exercises.get(positionOfElement).getExerciseName()+"</span>";
            for(int j=0;j<listOfElements.size();j++){
                if(listOfElements.get(j).getAttribute("innerHTML").contains(encontrar)){
                    WebElement e = listOfElements.get(j).findElement(By.className("picture-container"));
                    e.click();
                    checkIfIsTheSameText(positionOfElement,numberOfElementsOnTheScreen);
                    break;
                }
            }

        }else if(numberOfElementsOnTheScreen==1)
            checkIfIsTheSameText(positionOfElement,numberOfElementsOnTheScreen);

    }


    public void checkIfIsTheSameText(int positionOfElement,int numberOfElementsOnTheScreen){
        wait.until(ExpectedConditions.visibilityOfElementLocated(exerciseDescription));

        String exerciseDescriptions[] = driver.findElement(exerciseDescription).getAttribute("innerText").split(" \n");
        initialPosition = exerciseDescriptions[1].split("\n")[0];
        execution = exerciseDescriptions[2].split("\n")[0];
        watch = exerciseDescriptions[3].split("\n")[0];
        commonMistakes = exerciseDescriptions[4].split("\n")[0];

        try {
            Assert.assertEquals("\nExercise: "+exercises.get(positionOfElement).getExerciseName()+"\n",
                    exercises.get(positionOfElement).getInitialPosition(),initialPosition);

            Assert.assertEquals("\nExercise: "+exercises.get(positionOfElement).getExerciseName()+"\n",
                    exercises.get(positionOfElement).getExecution(),execution);

            Assert.assertEquals("\nExercise: "+exercises.get(positionOfElement).getExerciseName()+"\n",
                    exercises.get(positionOfElement).getWatch(),watch);

            Assert.assertEquals("\nExercise: "+exercises.get(positionOfElement).getExerciseName()+"\n",
                    exercises.get(positionOfElement).getCommonMistakes(),commonMistakes);

            if(numberOfElementsOnTheScreen>=3){
                WebElement elementCloseToCleanScreen = driver.findElement(closeToCleanScreen);
                elementCloseToCleanScreen.click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
            }

        }catch (AssertionError e){
            System.out.print(e.getLocalizedMessage()+"\n");
            if(numberOfElementsOnTheScreen>=3){
                WebElement elementCloseToCleanScreen = driver.findElement(closeToCleanScreen);
                elementCloseToCleanScreen.click();
            }
        }
    }
}
