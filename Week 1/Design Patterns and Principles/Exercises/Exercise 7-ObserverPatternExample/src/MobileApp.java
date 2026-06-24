public class MobileApp implements Observer {

    private String name;

    public MobileApp(String name) {
        this.name = name;
    }

    @Override
    public void update(float price) {
        System.out.println(name + " MobileApp notified. Stock Price: " + price);
    }
}