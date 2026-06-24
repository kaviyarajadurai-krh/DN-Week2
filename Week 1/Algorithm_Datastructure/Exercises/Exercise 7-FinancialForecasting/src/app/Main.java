package app;

import service.ForecastService;

public class Main {

    public static void main(String[] args) {

        ForecastService service = new ForecastService();

        double currentValue = 10000;
        double growthRate = 0.10; 
        int years = 5;

        double futureValue = service.predictFutureValue(
                currentValue,
                growthRate,
                years
        );

        System.out.println("Current Value : " + currentValue);
        System.out.println("Growth Rate   : " + (growthRate * 100) + "%");
        System.out.println("Years         : " + years);
        System.out.println("Future Value  : " + futureValue);
    }
}