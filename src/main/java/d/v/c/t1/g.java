/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnCompletionListener
 */
package d.v.c.t1;

import android.media.MediaPlayer;
import com.zhiyun.cama.splash.SplashFragment;

public final class g
implements MediaPlayer.OnCompletionListener {
    public final /* synthetic */ SplashFragment a;

    public /* synthetic */ g(SplashFragment splashFragment) {
        this.a = splashFragment;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        this.a.I(mediaPlayer);
    }
}

