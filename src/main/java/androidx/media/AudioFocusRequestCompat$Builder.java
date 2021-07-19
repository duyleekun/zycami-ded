/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioManager$OnAudioFocusChangeListener
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 */
package androidx.media;

import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.media.AudioAttributesCompat;
import androidx.media.AudioFocusRequestCompat;
import java.util.Objects;

public final class AudioFocusRequestCompat$Builder {
    private AudioAttributesCompat mAudioAttributesCompat;
    private Handler mFocusChangeHandler;
    private int mFocusGain;
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener;
    private boolean mPauseOnDuck;

    public AudioFocusRequestCompat$Builder(int n10) {
        AudioAttributesCompat audioAttributesCompat;
        this.mAudioAttributesCompat = audioAttributesCompat = AudioFocusRequestCompat.FOCUS_DEFAULT_ATTR;
        this.setFocusGain(n10);
    }

    public AudioFocusRequestCompat$Builder(AudioFocusRequestCompat object) {
        AudioAttributesCompat audioAttributesCompat;
        this.mAudioAttributesCompat = audioAttributesCompat = AudioFocusRequestCompat.FOCUS_DEFAULT_ATTR;
        if (object != null) {
            boolean bl2;
            int n10;
            this.mFocusGain = n10 = ((AudioFocusRequestCompat)object).getFocusGain();
            audioAttributesCompat = ((AudioFocusRequestCompat)object).getOnAudioFocusChangeListener();
            this.mOnAudioFocusChangeListener = audioAttributesCompat;
            audioAttributesCompat = ((AudioFocusRequestCompat)object).getFocusChangeHandler();
            this.mFocusChangeHandler = audioAttributesCompat;
            this.mAudioAttributesCompat = audioAttributesCompat = ((AudioFocusRequestCompat)object).getAudioAttributesCompat();
            this.mPauseOnDuck = bl2 = ((AudioFocusRequestCompat)object).willPauseWhenDucked();
            return;
        }
        object = new IllegalArgumentException("AudioFocusRequestCompat to copy must not be null");
        throw object;
    }

    private static boolean isValidFocusGain(int n10) {
        int n11;
        int n12 = 1;
        if (n10 != n12 && n10 != (n11 = 2) && n10 != (n11 = 3) && n10 != (n11 = 4)) {
            return false;
        }
        return n12;
    }

    public AudioFocusRequestCompat build() {
        Object object = this.mOnAudioFocusChangeListener;
        if (object != null) {
            int n10 = this.mFocusGain;
            AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.mOnAudioFocusChangeListener;
            Handler handler = this.mFocusChangeHandler;
            AudioAttributesCompat audioAttributesCompat = this.mAudioAttributesCompat;
            boolean bl2 = this.mPauseOnDuck;
            object = new AudioFocusRequestCompat(n10, onAudioFocusChangeListener, handler, audioAttributesCompat, bl2);
            return object;
        }
        object = new IllegalStateException("Can't build an AudioFocusRequestCompat instance without a listener");
        throw object;
    }

    public AudioFocusRequestCompat$Builder setAudioAttributes(AudioAttributesCompat audioAttributesCompat) {
        Objects.requireNonNull(audioAttributesCompat, "Illegal null AudioAttributes");
        this.mAudioAttributesCompat = audioAttributesCompat;
        return this;
    }

    public AudioFocusRequestCompat$Builder setFocusGain(int n10) {
        int n11 = AudioFocusRequestCompat$Builder.isValidFocusGain(n10);
        if (n11 != 0) {
            n11 = Build.VERSION.SDK_INT;
            int n12 = 19;
            if (n11 < n12 && n10 == (n11 = 4)) {
                n10 = 2;
            }
            this.mFocusGain = n10;
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Illegal audio focus gain type ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public AudioFocusRequestCompat$Builder setOnAudioFocusChangeListener(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        Looper looper = Looper.getMainLooper();
        Handler handler = new Handler(looper);
        return this.setOnAudioFocusChangeListener(onAudioFocusChangeListener, handler);
    }

    public AudioFocusRequestCompat$Builder setOnAudioFocusChangeListener(AudioManager.OnAudioFocusChangeListener object, Handler handler) {
        if (object != null) {
            if (handler != null) {
                this.mOnAudioFocusChangeListener = object;
                this.mFocusChangeHandler = handler;
                return this;
            }
            object = new IllegalArgumentException("Handler must not be null");
            throw object;
        }
        object = new IllegalArgumentException("OnAudioFocusChangeListener must not be null");
        throw object;
    }

    public AudioFocusRequestCompat$Builder setWillPauseWhenDucked(boolean bl2) {
        this.mPauseOnDuck = bl2;
        return this;
    }
}

