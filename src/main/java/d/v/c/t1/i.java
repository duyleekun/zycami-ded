/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnPreparedListener
 */
package d.v.c.t1;

import android.media.MediaPlayer;
import com.zhiyun.cama.splash.SplashFragment;

public final class i
implements MediaPlayer.OnPreparedListener {
    public final /* synthetic */ SplashFragment a;

    public /* synthetic */ i(SplashFragment splashFragment) {
        this.a = splashFragment;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        this.a.E(mediaPlayer);
    }
}

