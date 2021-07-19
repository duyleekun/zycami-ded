/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.widget.VideoView
 */
package d.v.c.o0;

import android.media.MediaPlayer;
import android.widget.VideoView;
import com.zhiyun.cama.album.AlbumPagerAdapter;
import com.zhiyun.cama.album.AlbumSection;
import d.v.c.w0.z9;

public final class b0
implements MediaPlayer.OnPreparedListener {
    public final /* synthetic */ z9 a;
    public final /* synthetic */ AlbumSection b;
    public final /* synthetic */ VideoView c;

    public /* synthetic */ b0(z9 z92, AlbumSection albumSection, VideoView videoView) {
        this.a = z92;
        this.b = albumSection;
        this.c = videoView;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        z9 z92 = this.a;
        AlbumSection albumSection = this.b;
        VideoView videoView = this.c;
        AlbumPagerAdapter.d(z92, albumSection, videoView, mediaPlayer);
    }
}

