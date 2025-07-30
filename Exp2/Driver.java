class MotorVehicle {
    String brand,colour;
    int maxSpeed;

    MotorVehicle(String brand, int maxSpeed, String colour) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
        this.colour = colour;
    }


    void displayInfo(){
        System.out.println("Brand: "+brand);
        System.out.println("Color: "+colour);
        System.out.println("Max speed: "+maxSpeed);
    }
}
class Car extends MotorVehicle{
    String fuelType, vehicleNumber;

    Car(String brand, int maxSpeed, String colour, String fuelType, String vehicleNumber) {
        super(brand, maxSpeed, colour);
        this.fuelType = fuelType;
        this.vehicleNumber = vehicleNumber;
    }

    void displayInfo(){
        System.out.println("Car - Brand: " + brand + "\n Max Speed: " + maxSpeed + "\n"+"Colour: " + colour + "\nFuel Type: " + fuelType + ",\nVehicle No: " + vehicleNumber);
    }
    void displayInfo(boolean displayNumber) {
        if(displayNumber == true) {
            System.out.println("Vehicle Number: " + vehicleNumber);
        } 
        else {
            displayInfo();
        }
    }
}

class ElectricCar extends Car {
    int batteryCapacity;
    int chargeRemaining;

    ElectricCar(String brand, int maxSpeed, String colour, String fuelType, String vehicleNumber, int batteryCapacity, int chargeRemaining) {
        super(brand, maxSpeed, colour, fuelType, vehicleNumber);
        this.batteryCapacity = batteryCapacity;
        this.chargeRemaining = chargeRemaining;
    }

    void displayInfo() {
        System.out.println("Electric Car - Brand: " + brand + "\nMax Speed: " + maxSpeed +"\nColour: " + colour + "\nFuel Type: " + fuelType +
                "\nVehicle No: " + vehicleNumber + "\nBattery Capacity: " +
                batteryCapacity + "\nCharge Remaining: " + chargeRemaining);
    }

    void displayInfo(boolean displayNumber, int chargeRemaining) {
        if(displayNumber) {
            System.out.println("Vehicle Number: " + vehicleNumber +"\nCharge Remaining: " + chargeRemaining);
        } 
        else {
            displayInfo();
        }
    }
}

public class Driver {
   public static void main(String[] args) {
    MotorVehicle v = new MotorVehicle("Honda", 180, "Red");
    Car c = new Car("Toyota", 200, "Blue", "Petrol", "KA05AB1234");
    ElectricCar e = new ElectricCar("Tesla", 250, "White", "Electric", "KA01EV8765", 85, 65);
    
    v.displayInfo();
    c.displayInfo();
    e.displayInfo();

    c.displayInfo(true);
    e.displayInfo(true, e.chargeRemaining);

    } 
}
