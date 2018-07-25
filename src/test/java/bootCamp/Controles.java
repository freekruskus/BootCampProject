package bootCamp;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class Controles{

    @Test
    public void AssertText(){
        String text = "ThisIsExampleText.";
        Assertions.assertThat(text).as("Text needs to end with a period.").endsWith(".");
    }
    @Test
    public void AssertNumber(){
        int number = 554443;
        Assertions.assertThat(number).as("Number must not be negative.").isNotNegative();
    }
    @Test
    public void AssertBoolean(){
        boolean trial = false;
        boolean premium = true;
        Assertions.assertThat(trial).as("Trial version must not be equal to Premium version.").isNotEqualTo(premium);
    }

}
