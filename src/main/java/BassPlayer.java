/**
 * Created by said on 14.08.16.
 */
public class BassPlayer implements Player {

    private int stream;
    private boolean isPlaying = true;

    public BassPlayer() {
        BassLibrary.INSTANCE.BASS_Init(-1, 44100, 0, null, null);
    }

    @Override
    public void play(String soundFilePath) throws InterruptedException {
        stream = BassLibrary.INSTANCE.BASS_StreamCreateFile(false, soundFilePath, 0, 0, 0);
        if (stream != 0 && BassLibrary.INSTANCE.BASS_ChannelPlay(stream, false)) {
            while (isPlaying && BassLibrary.INSTANCE.BASS_ChannelIsActive(stream)) {
            }
        } else {
            System.out.println(BassLibrary.INSTANCE.BASS_ErrorGetCode());
        }
    }

    @Override
    public void stopPlaying() {
        BassLibrary.INSTANCE.BASS_ChannelStop(stream);
        isPlaying = false;
    }

    @Override
    public void pause() {
        BassLibrary.INSTANCE.BASS_ChannelPause(stream);
        isPlaying = false;
    }

    @Override
    public void exit() {
        BassLibrary.INSTANCE.BASS_Free();
    }

    @Override
    public void resumePlaying() {
        BassLibrary.INSTANCE.BASS_ChannelPlay(stream, false);
    }

    @Override
    public void growVolume() {
        if (BassLibrary.INSTANCE.BASS_GetVolume() > 0.9f) {
            BassLibrary.INSTANCE.BASS_SetVolume(1.0f);
        } else {
            BassLibrary.INSTANCE.BASS_SetVolume(BassLibrary.INSTANCE.BASS_GetVolume() + 0.1f);
        }
    }

    @Override
    public void reduseVolume() {
        if (BassLibrary.INSTANCE.BASS_GetVolume() < 0.1f) {
            BassLibrary.INSTANCE.BASS_SetVolume(0.0f);
        } else {
            BassLibrary.INSTANCE.BASS_SetVolume(BassLibrary.INSTANCE.BASS_GetVolume() - 0.1f);
        }
    }
}
