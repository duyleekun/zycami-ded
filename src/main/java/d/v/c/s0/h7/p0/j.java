/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnErrorListener
 */
package d.v.c.s0.h7.p0;

import android.media.MediaPlayer;
import d.v.c.s0.h7.p0.p;

public final class j
implements MediaPlayer.OnErrorListener {
    public static final /* synthetic */ j a;

    static {
        j j10;
        a = j10 = new j();
    }

    public final boolean onError(MediaPlayer mediaPlayer, int n10, int n11) {
        return p.H(mediaPlayer, n10, n11);
    }
}

