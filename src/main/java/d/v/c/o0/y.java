/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnCompletionListener
 */
package d.v.c.o0;

import android.media.MediaPlayer;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.zhiyun.cama.album.AlbumPagerAdapter;
import com.zhiyun.cama.album.AlbumSection;

public final class y
implements MediaPlayer.OnCompletionListener {
    public final /* synthetic */ AlbumPagerAdapter a;
    public final /* synthetic */ BaseDataBindingHolder b;
    public final /* synthetic */ AlbumSection c;

    public /* synthetic */ y(AlbumPagerAdapter albumPagerAdapter, BaseDataBindingHolder baseDataBindingHolder, AlbumSection albumSection) {
        this.a = albumPagerAdapter;
        this.b = baseDataBindingHolder;
        this.c = albumSection;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        AlbumPagerAdapter albumPagerAdapter = this.a;
        BaseDataBindingHolder baseDataBindingHolder = this.b;
        AlbumSection albumSection = this.c;
        albumPagerAdapter.f(baseDataBindingHolder, albumSection, mediaPlayer);
    }
}

