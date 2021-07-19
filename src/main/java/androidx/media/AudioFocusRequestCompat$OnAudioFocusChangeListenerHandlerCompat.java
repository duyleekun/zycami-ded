/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioManager$OnAudioFocusChangeListener
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 */
package androidx.media;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class AudioFocusRequestCompat$OnAudioFocusChangeListenerHandlerCompat
implements Handler.Callback,
AudioManager.OnAudioFocusChangeListener {
    private static final int FOCUS_CHANGE = 2782386;
    private final Handler mHandler;
    private final AudioManager.OnAudioFocusChangeListener mListener;

    public AudioFocusRequestCompat$OnAudioFocusChangeListenerHandlerCompat(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
        this.mListener = onAudioFocusChangeListener;
        handler = handler.getLooper();
        super((Looper)handler, (Handler.Callback)this);
        this.mHandler = onAudioFocusChangeListener;
    }

    public boolean handleMessage(Message message) {
        int n10 = message.what;
        int n11 = 2782386;
        if (n10 == n11) {
            AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.mListener;
            int n12 = message.arg1;
            onAudioFocusChangeListener.onAudioFocusChange(n12);
            return true;
        }
        return false;
    }

    public void onAudioFocusChange(int n10) {
        Handler handler = this.mHandler;
        Message message = Message.obtain((Handler)handler, (int)2782386, (int)n10, (int)0);
        handler.sendMessage(message);
    }
}

