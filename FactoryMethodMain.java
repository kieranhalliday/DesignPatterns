import java.util.ArrayList;

public class FactoryMethodMain {

    public static void main(String[] args){
        FactoryMethodMain factoryMethodMain = new FactoryMethodMain();
        factoryMethodMain.start();
    }

    // The Client
    public void start(){
        BallCreator ballCreator = new BallCreator();
        Ball ball = (Ball) ballCreator.factoryMethod();
        ball.getPrice();
    }

    // Product Class
    public abstract class Product{
        ArrayList<String> attributes = new ArrayList<>();
        int price;

        public Product(){
            this.setPrice();
        }

        public abstract void setPrice();

        public void getPrice(){
            System.out.println("Object costs: " + price);
        }
    }


    // Concrete Product Class 1
    public class Toy extends Product{


        @Override
        public void setPrice() {
            this.price = 2;
        }
    }

    // Concrete Product Class 2
    public class Ball extends Product{
        @Override
        public void setPrice() {
            this.price = 5;
        }
    }

    // Creator Class
    public abstract class Creator{

        public Creator(){
        }

        public abstract Product factoryMethod();
    }


    // Concrete Creator Class 1
    public class BallCreator extends Creator{

        @Override
        public Product factoryMethod() {
            Ball ball = new Ball();
            ball.attributes.add("Round");
            ball.attributes.add("Blue");
            return ball;
        }
    }

    //Concrete Creator Class 2
    public class ToyCreator extends Creator{

        @Override
        public Product factoryMethod() {
            Toy toy = new Toy();
            toy.attributes.add("Soldier");
            toy.attributes.add("British");
            return toy;
        }
    }
}
