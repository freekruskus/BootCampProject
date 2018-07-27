package frameworkExercises;

public class Auto{

    public void setColor(String carColor){
        System.out.println("The color of your car is: " + carColor);
    }

    public void setBrand(String carBrand){
        System.out.println("The brand of your car is: " + carBrand);
    }

    public void setDoors(int carDoors){
        System.out.println("Your car has " + carDoors + " doors.");
    }

    public void setMotor(double carMotor){
        System.out.println("Your car has a " + carMotor + " liter engine.");
    }

    public void setTorque(int carForce, int carRPMs){
        System.out.println("Your car has " + ((carForce * 5252)/carRPMs) + " N-M of torque.");
    }
}
