import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

/**
 * Created by said on 14.08.16.
 */
public interface BassLibrary extends Library {
    BassLibrary INSTANCE = (BassLibrary)
            Native.loadLibrary("/usr/local/lib/libbass.dylib",
                    BassLibrary.class);
    boolean BASS_Init(int device, int freq, int flags, Pointer win, Pointer dsguid);
    int BASS_StreamCreateFile(boolean mem, String file, int offset, int length, int flags);
    boolean BASS_ChannelPlay(int handle, boolean restart);
    int BASS_ErrorGetCode();
    boolean BASS_Free();
    boolean BASS_ChannelIsActive(int stream);
    boolean BASS_ChannelPause(int handle);
    boolean BASS_ChannelStop(int handle);
    float BASS_GetVolume();
    boolean BASS_SetVolume(float volume);
}
