/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnErrorListener
 */
package d.v.c.y1.f;

import android.content.Context;
import android.media.MediaPlayer;
import com.zhiyun.cama.voice.music.MusicPlayVieModel;

public final class n
implements MediaPlayer.OnErrorListener {
    public final /* synthetic */ Context a;

    public /* synthetic */ n(Context context) {
        this.a = context;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int n10, int n11) {
        return MusicPlayVieModel.j(this.a, mediaPlayer, n10, n11);
    }
}

