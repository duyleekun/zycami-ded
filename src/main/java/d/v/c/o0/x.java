/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnErrorListener
 *  android.widget.VideoView
 */
package d.v.c.o0;

import android.media.MediaPlayer;
import android.widget.VideoView;
import com.zhiyun.cama.album.AlbumPagerAdapter;

public final class x
implements MediaPlayer.OnErrorListener {
    public final /* synthetic */ AlbumPagerAdapter a;
    public final /* synthetic */ VideoView b;

    public /* synthetic */ x(AlbumPagerAdapter albumPagerAdapter, VideoView videoView) {
        this.a = albumPagerAdapter;
        this.b = videoView;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int n10, int n11) {
        AlbumPagerAdapter albumPagerAdapter = this.a;
        VideoView videoView = this.b;
        return albumPagerAdapter.h(videoView, mediaPlayer, n10, n11);
    }
}

