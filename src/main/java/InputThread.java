import java.util.Scanner;

/**
 * Created by said on 25.08.16.
 */
public class InputThread extends Thread {

    private Player player;

    public InputThread(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        boolean isRunning = true;
        char ccommand;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            ccommand = scanner.next().charAt(0);
            switch (ccommand) {
                case 'p':
                    System.out.println("Enter music path");
                    Scanner scanner1 = new Scanner(System.in);
                    String musicPath = scanner1.nextLine();

                    player.play(musicPath);
                    break;
                case 's':
                    player.stopPlaying();
                    break;
                case 'o':
                    player.pause();
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
                    isRunning = false;
                    break;
            }
        }
    }
}
