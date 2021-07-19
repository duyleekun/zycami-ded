/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioAttributes
 *  android.media.AudioFocusRequest
 *  android.media.AudioManager$OnAudioFocusChangeListener
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 */
package androidx.media;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.util.ObjectsCompat;
import androidx.media.AudioAttributesCompat;
import androidx.media.AudioAttributesCompat$Builder;

public class AudioFocusRequestCompat {
    public static final AudioAttributesCompat FOCUS_DEFAULT_ATTR;
    private final AudioAttributesCompat mAudioAttributesCompat;
    private final Handler mFocusChangeHandler;
    private final int mFocusGain;
    private final Object mFrameworkAudioFocusRequest;
    private final AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener;
    private final boolean mPauseOnDuck;

    static {
        AudioAttributesCompat$Builder audioAttributesCompat$Builder = new AudioAttributesCompat$Builder();
        FOCUS_DEFAULT_ATTR = audioAttributesCompat$Builder.setUsage(1).build();
    }

    public AudioFocusRequestCompat(int n10, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler, AudioAttributesCompat audioAttributesCompat, boolean bl2) {
        Looper looper;
        Object object;
        this.mFocusGain = n10;
        this.mFocusChangeHandler = handler;
        this.mAudioAttributesCompat = audioAttributesCompat;
        this.mPauseOnDuck = bl2;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 26;
        if (n11 < n12 && (object = handler.getLooper()) != (looper = Looper.getMainLooper())) {
            super(onAudioFocusChangeListener, handler);
            this.mOnAudioFocusChangeListener = object;
        } else {
            this.mOnAudioFocusChangeListener = onAudioFocusChangeListener;
        }
        if (n11 >= n12) {
            super(n10);
            AudioAttributes audioAttributes = this.getAudioAttributes();
            audioAttributes = onAudioFocusChangeListener.setAudioAttributes(audioAttributes).setWillPauseWhenDucked(bl2);
            onAudioFocusChangeListener = this.mOnAudioFocusChangeListener;
            audioAttributes = audioAttributes.setOnAudioFocusChangeListener(onAudioFocusChangeListener, handler).build();
            this.mFrameworkAudioFocusRequest = audioAttributes;
        } else {
            n10 = 0;
            Object var10_11 = null;
            this.mFrameworkAudioFocusRequest = null;
        }
    }

    public boolean equals(Object object) {
        boolean bl2;
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;
        Object object2;
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        int n10 = object instanceof AudioFocusRequestCompat;
        if (n10 == 0) {
            return false;
        }
        object = (AudioFocusRequestCompat)object;
        n10 = this.mFocusGain;
        int n11 = ((AudioFocusRequestCompat)object).mFocusGain;
        if (n10 != n11 || (n10 = (int)(this.mPauseOnDuck ? 1 : 0)) != (n11 = (int)(((AudioFocusRequestCompat)object).mPauseOnDuck ? 1 : 0)) || (n10 = (int)(ObjectsCompat.equals(object2 = this.mOnAudioFocusChangeListener, onAudioFocusChangeListener = ((AudioFocusRequestCompat)object).mOnAudioFocusChangeListener) ? 1 : 0)) == 0 || (n10 = (int)(ObjectsCompat.equals(object2 = this.mFocusChangeHandler, onAudioFocusChangeListener = ((AudioFocusRequestCompat)object).mFocusChangeHandler) ? 1 : 0)) == 0 || !(bl2 = ObjectsCompat.equals(object2 = this.mAudioAttributesCompat, object = ((AudioFocusRequestCompat)object).mAudioAttributesCompat))) {
            bl3 = false;
        }
        return bl3;
    }

    public AudioAttributes getAudioAttributes() {
        AudioAttributesCompat audioAttributesCompat = this.mAudioAttributesCompat;
        audioAttributesCompat = audioAttributesCompat != null ? (AudioAttributes)audioAttributesCompat.unwrap() : null;
        return audioAttributesCompat;
    }

    public AudioAttributesCompat getAudioAttributesCompat() {
        return this.mAudioAttributesCompat;
    }

    public AudioFocusRequest getAudioFocusRequest() {
        return (AudioFocusRequest)this.mFrameworkAudioFocusRequest;
    }

    public Handler getFocusChangeHandler() {
        return this.mFocusChangeHandler;
    }

    public int getFocusGain() {
        return this.mFocusGain;
    }

    public AudioManager.OnAudioFocusChangeListener getOnAudioFocusChangeListener() {
        return this.mOnAudioFocusChangeListener;
    }

    public int hashCode() {
        Object object = this.mFocusGain;
        Object[] objectArray = new Object[]{object, object = this.mOnAudioFocusChangeListener, object = this.mFocusChangeHandler, object = this.mAudioAttributesCompat, object = Boolean.valueOf(this.mPauseOnDuck)};
        return ObjectsCompat.hash(objectArray);
    }

    public boolean willPauseWhenDucked() {
        return this.mPauseOnDuck;
    }
}

