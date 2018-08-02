package frameworkExercises;

public class LogInPage {

    public String brand;
    public int hP;
    public int rPM;

    public AutoAdvanced(String brand, int hP, int rPM){
        this.brand = brand;
        this.hP = hP;
        this.rPM = rPM;
        System.out.println("Your car brand is: " + brand);
        System.out.println("Your car's torque is: " + ((hP * 5252)/rPM));
    }
}
