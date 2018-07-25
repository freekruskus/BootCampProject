package bootCamp;


import org.testng.Assert;
import org.testng.annotations.Test;

public class HelloWorldTest {

        @Test
        public static void main(String[] args) {
            printString();
        }

        public static String printString(){
            String print = "Hello World";
            Assert.assertEquals("Hello World", print);
            System.out.println(print);
            return print;
        }

}
