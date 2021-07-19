/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.VideoView
 */
package d.v.c.o0;

import android.widget.VideoView;
import com.zhiyun.cama.album.AlbumPagerAdapter;
import e.a.v0.g;

public final class a0
implements g {
    public final /* synthetic */ AlbumPagerAdapter a;
    public final /* synthetic */ VideoView b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public /* synthetic */ a0(AlbumPagerAdapter albumPagerAdapter, VideoView videoView, int n10, int n11) {
        this.a = albumPagerAdapter;
        this.b = videoView;
        this.c = n10;
        this.d = n11;
    }

    public final void accept(Object object) {
        AlbumPagerAdapter albumPagerAdapter = this.a;
        VideoView videoView = this.b;
        int n10 = this.c;
        int n11 = this.d;
        object = (Long)object;
        albumPagerAdapter.k(videoView, n10, n11, (Long)object);
    }
}

