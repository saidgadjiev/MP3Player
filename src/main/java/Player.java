/**
 * Created by said on 14.08.16.
 */
public interface Player {
    void play(String soundFilePath) throws InterruptedException;

    void stopPlaying();

    void pause();

    void exit();

    void resumePlaying();

    void growVolume();

    void reduseVolume();
}
