/**
 * Created by said on 31.07.16.
 */
public class Main {


    public static void main(String[] args) throws InterruptedException {
        Player player = new BassPlayer();
        InputThread inputThread = new InputThread(player);

        inputThread.start();
        player.play("test.mp3");
        inputThread.join();
    }
}
