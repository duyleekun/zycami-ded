/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnErrorListener
 */
package d.v.c.t1;

import android.media.MediaPlayer;
import com.zhiyun.cama.splash.SplashFragment;

public final class e
implements MediaPlayer.OnErrorListener {
    public final /* synthetic */ SplashFragment a;

    public /* synthetic */ e(SplashFragment splashFragment) {
        this.a = splashFragment;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int n10, int n11) {
        return this.a.R(mediaPlayer, n10, n11);
    }
}

