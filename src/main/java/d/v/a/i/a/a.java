/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnPreparedListener
 */
package d.v.a.i.a;

import android.media.MediaPlayer;
import com.zhiyun.account.me.account.AccountMainFragment;

public final class a
implements MediaPlayer.OnPreparedListener {
    public final /* synthetic */ AccountMainFragment a;

    public /* synthetic */ a(AccountMainFragment accountMainFragment) {
        this.a = accountMainFragment;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        this.a.o(mediaPlayer);
    }
}

