import java.util.Scanner;

/**
 * Created by said on 31.07.16.
 */
public class Main {


    public static void main(String[] args) throws InterruptedException {
        BassPlayer player = new BassPlayer();
        boolean isRunning = true;
        char ccommand;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            ccommand = scanner.next().charAt(0);
            switch (ccommand) {
                case 'q':
                    isRunning = false;
                    break;
                case 'p':
                    player.play("test.mp3");
                    break;
                case 's':
                    player.stopPlaying();
                    break;
                case 'l':
                    player.resumePlaying();
                    break;
                case 'v':
                    player.growVolume();
                    break;
                case 'k':
                    player.reduseVolume();
                    break;
                case 'e':
                    player.exit();
                    break;
            }
        }
    }
}
