/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnPreparedListener
 */
package d.v.c.s0.h7.p0;

import android.media.MediaPlayer;
import d.v.c.s0.h7.p0.p;

public final class i
implements MediaPlayer.OnPreparedListener {
    public static final /* synthetic */ i a;

    static {
        i i10;
        a = i10 = new i();
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        p.I(mediaPlayer);
    }
}

