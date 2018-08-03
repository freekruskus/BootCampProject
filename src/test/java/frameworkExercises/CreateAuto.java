package frameworkExercises;

import org.testng.annotations.Test;

public class CreateAuto {

    @Test
    public void createAuto(){

        Auto myFirstAuto = new Auto();

        myFirstAuto.setColor("Green");
        myFirstAuto.setBrand("Volvo");
        myFirstAuto.setDoors(2);
        myFirstAuto.setMotor(1.8);
        myFirstAuto.setTorque(520, 4250);

        AutoAdvanced myConstructorAuto = new AutoAdvanced("Volvo", 300, 300);
        System.out.println(myConstructorAuto.brand);
    }

}
