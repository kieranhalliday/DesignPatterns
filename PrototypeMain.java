public class PrototypeMain {

    public static void main(String[] args){
        PrototypeMain prototypeMain = new PrototypeMain();
        prototypeMain.start();
    }

    // The Client
    public void start(){
        ConcretePrototype1 concretePrototype1 = new ConcretePrototype1(1,1,1);
        ConcretePrototype1 clone = (ConcretePrototype1) concretePrototype1.makeCopy();
        clone.showStats();
    }


    // The Prototype Class
    public abstract class Prototype{
        Prototype prototype;

        public abstract Prototype makeCopy();
    }

    // The Concrete Prototype 1
    public class ConcretePrototype1 extends Prototype {
        int R, G, B;

        ConcretePrototype1(int R, int G, int B) {
            this.R = R;
            this.G = G;
            this.B = B;
        }

        public void showStats(){
            System.out.println("R: " + R + " G: "+ G + " B:" + B);
        }

        @Override
        public Prototype makeCopy() {
            return new ConcretePrototype1(R, G, B);
        }
    }

}
