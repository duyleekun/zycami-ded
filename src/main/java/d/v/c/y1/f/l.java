/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnCompletionListener
 */
package d.v.c.y1.f;

import android.media.MediaPlayer;
import com.zhiyun.cama.voice.music.MusicPlayVieModel;

public final class l
implements MediaPlayer.OnCompletionListener {
    public final /* synthetic */ MusicPlayVieModel a;

    public /* synthetic */ l(MusicPlayVieModel musicPlayVieModel) {
        this.a = musicPlayVieModel;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        this.a.i(mediaPlayer);
    }
}

