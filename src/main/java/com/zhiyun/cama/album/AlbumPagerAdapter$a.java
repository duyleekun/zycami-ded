/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.SeekBar
 *  android.widget.SeekBar$OnSeekBarChangeListener
 *  android.widget.VideoView
 */
package com.zhiyun.cama.album;

import android.widget.SeekBar;
import android.widget.VideoView;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.zhiyun.cama.album.AlbumPagerAdapter;
import com.zhiyun.cama.album.AlbumSection;

public class AlbumPagerAdapter$a
implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ VideoView a;
    public final /* synthetic */ AlbumSection b;
    public final /* synthetic */ BaseDataBindingHolder c;
    public final /* synthetic */ AlbumPagerAdapter d;

    public AlbumPagerAdapter$a(AlbumPagerAdapter albumPagerAdapter, VideoView videoView, AlbumSection albumSection, BaseDataBindingHolder baseDataBindingHolder) {
        this.d = albumPagerAdapter;
        this.a = videoView;
        this.b = albumSection;
        this.c = baseDataBindingHolder;
    }

    public void onProgressChanged(SeekBar object, int n10, boolean bl2) {
        if (bl2) {
            VideoView videoView = this.a;
            float f10 = (float)object.getProgress() * 0.01f;
            VideoView videoView2 = this.a;
            int n11 = videoView2.getDuration();
            float f11 = n11;
            int n12 = (int)(f10 *= f11);
            videoView.seekTo(n12);
            object = this.b.getAlbum().playedSec;
            videoView = this.a;
            n10 = videoView.getCurrentPosition() / 1000;
            ((ObservableInt)object).set(n10);
        }
    }

    public void onStartTrackingTouch(SeekBar object) {
        object = this.a;
        boolean bl2 = object.isPlaying();
        if (bl2) {
            this.a.pause();
            object = AlbumPagerAdapter.a(this.d);
            if (object != null && !(bl2 = (object = AlbumPagerAdapter.a(this.d)).isDisposed())) {
                object = AlbumPagerAdapter.a(this.d);
                object.dispose();
            }
        }
    }

    public void onStopTrackingTouch(SeekBar object) {
        object = this.b.getAlbum().playing;
        boolean bl2 = ((ObservableBoolean)object).get();
        if (bl2) {
            this.a.start();
            object = this.d;
            VideoView videoView = this.a;
            BaseDataBindingHolder baseDataBindingHolder = this.c;
            int n10 = baseDataBindingHolder.getLayoutPosition();
            AlbumPagerAdapter.b((AlbumPagerAdapter)object, videoView, n10);
        }
    }
}

