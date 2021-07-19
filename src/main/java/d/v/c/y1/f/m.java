/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnPreparedListener
 */
package d.v.c.y1.f;

import android.media.MediaPlayer;
import com.zhiyun.cama.voice.music.MusicPlayVieModel;

public final class m
implements MediaPlayer.OnPreparedListener {
    public final /* synthetic */ MusicPlayVieModel a;

    public /* synthetic */ m(MusicPlayVieModel musicPlayVieModel) {
        this.a = musicPlayVieModel;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        this.a.f(mediaPlayer);
    }
}

