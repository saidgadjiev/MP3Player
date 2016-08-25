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
                case 'q':
                    isRunning = false;
                    break;
                case 'p':
                    try {
                        player.play("test.mp3");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
