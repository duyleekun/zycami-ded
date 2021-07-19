/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a;

import com.google.android.exoplayer2.AudioFocusManager$AudioFocusListener;

public final class b
implements Runnable {
    public final /* synthetic */ AudioFocusManager$AudioFocusListener a;
    public final /* synthetic */ int b;

    public /* synthetic */ b(AudioFocusManager$AudioFocusListener audioFocusManager$AudioFocusListener, int n10) {
        this.a = audioFocusManager$AudioFocusListener;
        this.b = n10;
    }

    public final void run() {
        AudioFocusManager$AudioFocusListener audioFocusManager$AudioFocusListener = this.a;
        int n10 = this.b;
        audioFocusManager$AudioFocusListener.b(n10);
    }
}

