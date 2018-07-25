package bootCamp;

import org.testng.annotations.Test;

public class AboutMethods {

    @Test
    public void printProduct(){
        System.out.println(multiply(1,2));
    }

    private int multiply(int a, int b){
        return (a * b);
    }
}
