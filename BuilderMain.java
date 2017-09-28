import java.util.*;

public class BuilderMain {

    public static void main(String[] args){
        MotorCycleBuilder motorCycleBuilder = new MotorCycleBuilder();
        ScooterBuilder scooterBuilder = new ScooterBuilder();
        Shop shop = new Shop();

        shop.construct(motorCycleBuilder);
        shop.construct(scooterBuilder);

        motorCycleBuilder.vehicle.showParts();
        scooterBuilder.vehicle.showParts();
    }
}

// The Director Class
class Shop{
    public void construct(VehicleBuilder builder){
        builder.buildPartA();
        builder.buildPartB();
    }

}

// The Builder Class
abstract class VehicleBuilder{

    protected Vehicle vehicle;

    public abstract void buildPartA();
    public abstract void buildPartB();
}

// The Concrete Builder 1 Class
class MotorCycleBuilder extends VehicleBuilder{

    MotorCycleBuilder() {
        vehicle = new Vehicle("Motorcycle");
    }

    @Override
    public void buildPartA() {
        vehicle.parts.put("Part A","Tires");
    }

    @Override
    public void buildPartB() {
        vehicle.parts.put("Part B","Doors");

    }
}

// The Concrete Builder 2 Class
class ScooterBuilder extends VehicleBuilder{

    ScooterBuilder() {
        vehicle =  new Vehicle("Scooter");
    }

    @Override
    public void buildPartA() {
        vehicle.parts.put("Part A","Windows");
    }

    @Override
    public void buildPartB() {
        vehicle.parts.put("Part B", "Steering Wheel");
    }
}

// The Product Class
class Vehicle{
    private String vehicleName;
    HashMap<String, String> parts = new HashMap<>();

    public Vehicle(String vehicleName){
        this.vehicleName = vehicleName;
    }

    public void showParts(){
        System.out.println("Part A: " + this.parts.get("Part A"));
        System.out.println("Part B: " + this.parts.get("Part B"));
    }
}