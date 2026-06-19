public class Main {
    public static void main(String[] args) {

        Computer gamingPC = new Computer.Builder()
                .setCpu("Intel Core i9")
                .setRam(32)
                .setStorage(1000)
                .setGraphicsCard("NVIDIA RTX 4080")
                .setOperatingSystem("Windows 11")
                .build();

        Computer officePC = new Computer.Builder()
                .setCpu("Intel Core i3 7th Gen")
                .setRam(8)
                .setStorage(1000)
                .setOperatingSystem("Windows 10")
                .build();

        System.out.println("Gaming PC Configuration");
        gamingPC.display();

        System.out.println("Office PC Configuration");
        officePC.display();
    }
}