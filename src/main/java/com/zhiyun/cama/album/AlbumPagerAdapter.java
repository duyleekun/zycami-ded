/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.net.Uri
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.VideoView
 */
package com.zhiyun.cama.album;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.zhiyun.cama.album.Album;
import com.zhiyun.cama.album.AlbumPagerAdapter$a;
import com.zhiyun.cama.album.AlbumSection;
import d.v.c.o0.a0;
import d.v.c.o0.b0;
import d.v.c.o0.k0;
import d.v.c.o0.x;
import d.v.c.o0.y;
import d.v.c.w0.z9;
import d.v.f.f.a;
import d.v.g0.k$a;
import d.v.g0.k$b;
import e.a.c1.b;
import e.a.h0;
import e.a.v0.g;
import e.a.z;
import java.util.concurrent.TimeUnit;

public class AlbumPagerAdapter
extends BaseQuickAdapter {
    private e.a.s0.b a;
    private ObservableBoolean b;
    private ObservableBoolean c;

    public AlbumPagerAdapter() {
        super(2131558618);
        Object object = new ObservableBoolean();
        this.b = object;
        object = new ObservableBoolean();
        this.c = object;
        Object object2 = object = (Object)new int[4];
        object2[0] = 2131362584;
        object2[1] = 2131363668;
        object2[2] = 2131362992;
        object2[3] = 2131363767;
        this.addChildClickViewIds((int[])object);
    }

    public static /* synthetic */ e.a.s0.b a(AlbumPagerAdapter albumPagerAdapter) {
        return albumPagerAdapter.a;
    }

    public static /* synthetic */ void b(AlbumPagerAdapter albumPagerAdapter, VideoView videoView, int n10) {
        albumPagerAdapter.r(videoView, n10);
    }

    public static /* synthetic */ void d(z9 baseObservable, AlbumSection albumSection, VideoView videoView, MediaPlayer mediaPlayer) {
        int n10 = ((z9)baseObservable).d.getProgress();
        long l10 = albumSection.getAlbum().duration;
        long l11 = n10;
        int n11 = (int)((float)(l10 * l11) * 0.01f);
        albumSection.getAlbum().progress.set(n10);
        baseObservable = albumSection.getAlbum().playedSec;
        int n12 = n11 / 1000;
        ((ObservableInt)baseObservable).set(n12);
        videoView.seekTo(n11);
    }

    private /* synthetic */ void e(BaseDataBindingHolder object, AlbumSection albumSection, MediaPlayer mediaPlayer) {
        int n10 = ((RecyclerView$ViewHolder)object).getLayoutPosition();
        this.p(n10);
        mediaPlayer.seekTo(1);
        albumSection.getAlbum().progress.set(100);
        object = albumSection.getAlbum().playedSec;
        int n11 = Math.round((float)albumSection.getAlbum().duration / 1000.0f);
        ((ObservableInt)object).set(n11);
    }

    private /* synthetic */ boolean g(VideoView object, MediaPlayer object2, int n10, int n11) {
        object.stopPlayback();
        object = object.getContext();
        boolean bl2 = object instanceof AppCompatActivity;
        if (bl2) {
            Object object3 = this.getContext();
            object2 = new k$b((Context)object3);
            n10 = 2131953274;
            object2 = (k$b)((k$a)object2).A(n10);
            object3 = d.v.c.o0.z.a;
            object2 = (k$b)((k$a)object2).w((a)object3);
            object = ((AppCompatActivity)object).getSupportFragmentManager();
            ((k$a)object2).D((FragmentManager)object);
        }
        return true;
    }

    public static /* synthetic */ void i(DialogFragment dialogFragment) {
    }

    private /* synthetic */ void j(VideoView videoView, int n10, int n11, Long l10) {
        double d10;
        double d11;
        double d12;
        int n12 = videoView.getCurrentPosition();
        float f10 = n12;
        int n13 = 1065353216;
        float f11 = 1.0f;
        f10 *= f11;
        float f12 = n10;
        f10 /= f12;
        Object object = this.getData();
        n10 = object.size() + -1;
        if (n11 <= n10) {
            object = ((AlbumSection)this.getItem((int)n11)).getAlbum().progress;
            f11 = 100.0f * f10;
            n13 = (int)f11;
            ((ObservableInt)object).set(n13);
            object = ((AlbumSection)this.getItem((int)n11)).getAlbum().playedSec;
            ((ObservableInt)object).set(n12 /= 1000);
        }
        if ((n12 = (int)((d12 = (d11 = (double)f10) - (d10 = 1.0)) == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1))) >= 0) {
            this.p(n11);
        }
    }

    private void q(VideoView videoView) {
        ConstraintLayout$LayoutParams constraintLayout$LayoutParams = (ConstraintLayout$LayoutParams)videoView.getLayoutParams();
        ObservableBoolean observableBoolean = this.b;
        int n10 = observableBoolean.get();
        int n11 = 0;
        int n12 = -2;
        if (n10 != 0) {
            n10 = 0;
            observableBoolean = null;
        } else {
            n10 = n12;
        }
        constraintLayout$LayoutParams.width = n10;
        observableBoolean = this.b;
        n10 = (int)(observableBoolean.get() ? 1 : 0);
        if (n10 != 0) {
            n11 = n12;
        }
        constraintLayout$LayoutParams.height = n11;
        videoView.setLayoutParams((ViewGroup.LayoutParams)constraintLayout$LayoutParams);
    }

    private void r(VideoView object, int n10) {
        Object object2;
        int n11;
        int n12 = object.getDuration();
        if (n12 == (n11 = -1)) {
            return;
        }
        n11 = object.getCurrentPosition();
        if (n11 == n12) {
            n11 = 1;
            object.seekTo(n11);
        }
        if ((object2 = this.a) != null && (n11 = (int)(object2.isDisposed() ? 1 : 0)) == 0) {
            object2 = this.a;
            object2.dispose();
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        h0 h02 = e.a.c1.b.d();
        object2 = z.o3(500L, timeUnit, h02);
        a0 a02 = new a0(this, (VideoView)object, n12, n10);
        object = k0.a;
        object = ((z)object2).c(a02, (g)object);
        this.a = object;
    }

    public void c(BaseDataBindingHolder object, AlbumSection object2) {
        Object object3 = (z9)((BaseDataBindingHolder)object).getDataBinding();
        if (object3 == null) {
            return;
        }
        ((z9)object3).D((AlbumSection)object2);
        ObservableBoolean observableBoolean = this.b;
        ((z9)object3).B(observableBoolean);
        observableBoolean = this.c;
        ((z9)object3).C(observableBoolean);
        ((ViewDataBinding)object3).executePendingBindings();
        observableBoolean = ((z9)object3).f;
        Object object4 = ((z9)object3).d;
        AlbumPagerAdapter$a albumPagerAdapter$a = new AlbumPagerAdapter$a(this, (VideoView)observableBoolean, (AlbumSection)object2, (BaseDataBindingHolder)object);
        object4.setOnSeekBarChangeListener(albumPagerAdapter$a);
        boolean bl2 = observableBoolean.isPlaying();
        if (bl2) {
            observableBoolean.pause();
        }
        object4 = ((AlbumSection)object2).getAlbum();
        bl2 = ((Album)object4).isVideo;
        if (bl2) {
            this.q((VideoView)observableBoolean);
            object4 = object2.getAlbum().uri;
            if (object4 == null) {
                object4 = object2.getAlbum().path;
                observableBoolean.setVideoPath((String)object4);
            } else {
                object4 = object2.getAlbum().uri;
                observableBoolean.setVideoURI((Uri)object4);
            }
            object4 = new b0((z9)object3, (AlbumSection)object2, (VideoView)observableBoolean);
            observableBoolean.setOnPreparedListener((MediaPlayer.OnPreparedListener)object4);
            object3 = new y(this, (BaseDataBindingHolder)object, (AlbumSection)object2);
            observableBoolean.setOnCompletionListener((MediaPlayer.OnCompletionListener)object3);
            object = new x(this, (VideoView)observableBoolean);
            observableBoolean.setOnErrorListener((MediaPlayer.OnErrorListener)object);
        } else {
            object = ((z9)object3).a;
            object3 = object2.getAlbum().uri;
            object2 = object3 == null ? ImageSource.uri(object2.getAlbum().path) : ImageSource.uri(object2.getAlbum().uri);
            ((SubsamplingScaleImageView)((Object)object)).setImage((ImageSource)object2);
            int n10 = -1;
            ((SubsamplingScaleImageView)((Object)object)).setOrientation(n10);
        }
    }

    public /* synthetic */ void f(BaseDataBindingHolder baseDataBindingHolder, AlbumSection albumSection, MediaPlayer mediaPlayer) {
        this.e(baseDataBindingHolder, albumSection, mediaPlayer);
    }

    public /* synthetic */ boolean h(VideoView videoView, MediaPlayer mediaPlayer, int n10, int n11) {
        return this.g(videoView, mediaPlayer, n10, n11);
    }

    public /* synthetic */ void k(VideoView videoView, int n10, int n11, Long l10) {
        this.j(videoView, n10, n11, l10);
    }

    public void l(BaseDataBindingHolder baseDataBindingHolder) {
        super.onViewDetachedFromWindow(baseDataBindingHolder);
        int n10 = baseDataBindingHolder.getAdapterPosition();
        int n11 = -1;
        if (n10 != n11 && n10 < (n11 = this.getItemCount())) {
            this.p(n10);
        }
    }

    public void m(boolean bl2) {
        this.b.set(bl2);
    }

    public void n(boolean bl2) {
        this.c.set(bl2);
    }

    public void o() {
        e.a.s0.b b10 = this.a;
        if (b10 != null) {
            boolean bl2 = b10.isDisposed();
            if (!bl2) {
                b10 = this.a;
                b10.dispose();
            }
            bl2 = false;
            b10 = null;
            this.a = null;
        }
    }

    public void p(int n10) {
        int n11 = -1;
        if (n10 == n11) {
            return;
        }
        n11 = this.getItemCount();
        if (n11 <= 0) {
            return;
        }
        AlbumSection albumSection = (AlbumSection)this.getItem(n10);
        if (albumSection == null) {
            return;
        }
        albumSection.getAlbum().playing.set(false);
        this.o();
    }

    public void s(int n10, boolean bl2) {
        int n11 = 2131363660;
        VideoView videoView = (VideoView)this.getViewByPosition(n10, n11);
        if (videoView == null) {
            return;
        }
        if (bl2) {
            videoView.start();
            ObservableBoolean observableBoolean = ((AlbumSection)this.getItem((int)n10)).getAlbum().playing;
            boolean bl3 = true;
            observableBoolean.set(bl3);
            this.r(videoView, n10);
        } else {
            videoView.pause();
            ObservableBoolean observableBoolean = ((AlbumSection)this.getItem((int)n10)).getAlbum().playing;
            bl2 = false;
            Object var5_6 = null;
            observableBoolean.set(false);
        }
    }

    public void t(int n10) {
        int n11 = 2131363660;
        VideoView videoView = (VideoView)this.getViewByPosition(n10, n11);
        if (videoView != null) {
            this.q(videoView);
        }
    }
}

