import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class EinfacherWecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Formatierer für die Uhrzeit
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println("Einfacher Wecker");
        System.out.print("In wie vielen Minuten soll der Alarm ausgelöst werden? ");
        int minuten = scanner.nextInt();

        // Berechne die Alarmzeit
        LocalTime alarmZeit = LocalTime.now().plusMinutes(minuten);
        System.out.println("Der Alarm ist für " + alarmZeit.format(timeFormatter) + " gesetzt.");

        // Timer einrichten
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Alarm! Es ist " + alarmZeit.format(timeFormatter));
                System.exit(0);
            }
        }, minuten * 60000); // Umwandlung von Minuten in Millisekunden

        scanner.close();
    }
}
