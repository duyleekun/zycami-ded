/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnInfoListener
 */
package d.v.c.t1;

import android.media.MediaPlayer;
import com.zhiyun.cama.splash.SplashFragment;

public final class j
implements MediaPlayer.OnInfoListener {
    public final /* synthetic */ SplashFragment a;

    public /* synthetic */ j(SplashFragment splashFragment) {
        this.a = splashFragment;
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int n10, int n11) {
        return this.a.P(mediaPlayer, n10, n11);
    }
}

