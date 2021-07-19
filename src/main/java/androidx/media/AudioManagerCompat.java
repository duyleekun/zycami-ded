/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioFocusRequest
 *  android.media.AudioManager
 *  android.media.AudioManager$OnAudioFocusChangeListener
 *  android.os.Build$VERSION
 */
package androidx.media;

import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import androidx.media.AudioFocusRequestCompat;

public final class AudioManagerCompat {
    public static final int AUDIOFOCUS_GAIN = 1;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE = 4;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
    private static final String TAG = "AudioManCompat";

    private AudioManagerCompat() {
    }

    public static int abandonAudioFocusRequest(AudioManager object, AudioFocusRequestCompat audioFocusRequestCompat) {
        if (object != null) {
            if (audioFocusRequestCompat != null) {
                int n10 = Build.VERSION.SDK_INT;
                int n11 = 26;
                if (n10 >= n11) {
                    audioFocusRequestCompat = audioFocusRequestCompat.getAudioFocusRequest();
                    return object.abandonAudioFocusRequest((AudioFocusRequest)audioFocusRequestCompat);
                }
                audioFocusRequestCompat = audioFocusRequestCompat.getOnAudioFocusChangeListener();
                return object.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)audioFocusRequestCompat);
            }
            object = new IllegalArgumentException("AudioFocusRequestCompat must not be null");
            throw object;
        }
        object = new IllegalArgumentException("AudioManager must not be null");
        throw object;
    }

    public static int getStreamMaxVolume(AudioManager audioManager, int n10) {
        return audioManager.getStreamMaxVolume(n10);
    }

    public static int getStreamMinVolume(AudioManager audioManager, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 28;
        if (n11 >= n12) {
            return audioManager.getStreamMinVolume(n10);
        }
        return 0;
    }

    public static int requestAudioFocus(AudioManager object, AudioFocusRequestCompat audioFocusRequestCompat) {
        if (object != null) {
            if (audioFocusRequestCompat != null) {
                int n10 = Build.VERSION.SDK_INT;
                int n11 = 26;
                if (n10 >= n11) {
                    audioFocusRequestCompat = audioFocusRequestCompat.getAudioFocusRequest();
                    return object.requestAudioFocus((AudioFocusRequest)audioFocusRequestCompat);
                }
                AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = audioFocusRequestCompat.getOnAudioFocusChangeListener();
                n11 = audioFocusRequestCompat.getAudioAttributesCompat().getLegacyStreamType();
                int n12 = audioFocusRequestCompat.getFocusGain();
                return object.requestAudioFocus(onAudioFocusChangeListener, n11, n12);
            }
            object = new IllegalArgumentException("AudioFocusRequestCompat must not be null");
            throw object;
        }
        object = new IllegalArgumentException("AudioManager must not be null");
        throw object;
    }
}

