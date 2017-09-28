public class SingletonMain {

    private static SingletonMain singletonMain = new SingletonMain();

    public static void main(String[] args){

    }

    public static SingletonMain getSingletonMain(){
        return singletonMain;
    }
}
