public class AbstractFactoryMain {

    public static void main(String[] args){
        ContinentFactory NAFactory = new NAFactory();
        AnimalWorld world = new AnimalWorld(NAFactory);
        world.runFoodChain();
    }
}

// The "Abstract Factor" Class
abstract class ContinentFactory{
    public abstract Herbivore createHerbivore();
    public abstract Carnivore createCarnivore();
}

// The "Concrete Factory1" Class
class AfricaFactory extends ContinentFactory {

    @Override
    public Herbivore createHerbivore() {
        return new Wildebeest();
    }

    @Override
    public Carnivore createCarnivore() {
        return new Lion();
    }
}

// The "Concrete Factory2" Class

class NAFactory extends ContinentFactory{

    @Override
    public Herbivore createHerbivore() {
        return new Caribou();
    }

    @Override
    public Carnivore createCarnivore() {
        return new Bear();
    }
}

// The "Abstract Product A" Class
abstract class Herbivore{
}

// The "Abstract Product B" Class
abstract class Carnivore{
    public void Eat(){
        System.out.println("Animals might eat other animals");
    }
}

// The "Product A1" Class
class Wildebeest extends Herbivore{
}

// The "Product A2" Class
class Caribou extends Herbivore{
}

// The "Product B1" Class
class Lion extends Carnivore{

    @Override
    public void Eat() {
        System.out.println("Lions eat Wildebeests");
    }
}

// The "Product B2" Class
class Bear extends Carnivore{

    @Override
    public void Eat(){
        System.out.println("Bears eat Caribou");
    }

}

// The "Client" Class
class AnimalWorld {
    private Herbivore herbivore;
    private Carnivore carnivore;

    //Constructor
    public AnimalWorld(ContinentFactory factory){
        carnivore = factory.createCarnivore();
        herbivore = factory.createHerbivore();
    }

    public void runFoodChain(){
        carnivore.Eat();
    }
}


