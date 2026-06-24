public class Main {
    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();

        Observer mobile1 = new MobileApp("User1");
        Observer mobile2 = new MobileApp("User2");
        Observer web1 = new WebApp("Admin");

        stockMarket.registerObserver(mobile1);
        stockMarket.registerObserver(mobile2);
        stockMarket.registerObserver(web1);

        System.out.println("First Price Update:");
        stockMarket.setPrice(100.5f);

        System.out.println();

        stockMarket.removeObserver(mobile2);

        System.out.println("Second Price Update:");
        stockMarket.setPrice(105.75f);
    }
}