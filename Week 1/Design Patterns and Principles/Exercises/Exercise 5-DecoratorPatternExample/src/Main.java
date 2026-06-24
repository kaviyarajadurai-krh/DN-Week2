public class Main {
    public static void main(String[] args) {

        Notifier notifier = new EmailNotifier();

        Notifier smsNotifier =
                new SMSNotifierDecorator(notifier);

        Notifier slackAndSmsNotifier =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()));

        System.out.println("Email Notification:");
        notifier.send("Hello User");

        System.out.println();

        System.out.println("Email + SMS Notification:");
        smsNotifier.send("Hello User");

        System.out.println();

        System.out.println("Email + SMS + Slack Notification:");
        slackAndSmsNotifier.send("Hello User");
    }
}