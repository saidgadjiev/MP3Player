/**
 * Created by said on 14.08.16.
 */
public class Sound extends Thread {
    private int stream;

    public Sound(int stream) {
        super("Sound");
        this.stream = stream;
        start();
    }

    @Override
    public void run() {
        while (BassLibrary.INSTANCE.BASS_ChannelIsActive(stream)) {
        }
    }
}
