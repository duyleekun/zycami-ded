/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnErrorListener
 */
package d.v.a.i.a;

import android.media.MediaPlayer;
import com.zhiyun.account.me.account.AccountMainFragment;

public final class b
implements MediaPlayer.OnErrorListener {
    public static final /* synthetic */ b a;

    static {
        b b10;
        a = b10 = new b();
    }

    public final boolean onError(MediaPlayer mediaPlayer, int n10, int n11) {
        return AccountMainFragment.p(mediaPlayer, n10, n11);
    }
}

