public class WebApp implements Observer {

    private String name;

    public WebApp(String name) {
        this.name = name;
    }

    @Override
    public void update(float price) {
        System.out.println(name + " WebApp notified. Stock Price: " + price);
    }
}