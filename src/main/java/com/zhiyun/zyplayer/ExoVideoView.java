/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 */
package com.zhiyun.zyplayer;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource$Factory;
import com.google.android.exoplayer2.source.dash.DashMediaSource$Factory;
import com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoListener;
import com.zhiyun.zyplayer.ExoVideoView$a;
import com.zhiyun.zyplayer.ExoVideoView$b;
import com.zhiyun.zyplayer.ExoVideoView$c;
import com.zhiyun.zyplayer.ExoVideoView$d;
import com.zhiyun.zyplayer.ExoVideoView$e;
import com.zhiyun.zyplayer.GestureView;
import com.zhiyun.zyplayer.GestureView$b;
import com.zhiyun.zyplayer.R$id;
import com.zhiyun.zyplayer.R$layout;
import d.v.j0.a;
import d.v.j0.c;
import d.v.j0.d;
import d.v.j0.d$a;
import d.v.j0.d$b;
import d.v.j0.d$c;
import d.v.j0.d$d;

public class ExoVideoView
extends FrameLayout
implements d {
    private static final String C = "ExoVideoView";
    private static final String D = "zyplayer";
    private static final int E = 255;
    private static final int F = 0;
    private static final int G = 1;
    private static final int H = 2;
    private static final int I = 3;
    private static final int J = 4;
    private static final int K = 5;
    private Player$EventListener A;
    private final VideoListener B;
    private int a = 0;
    private int b = 0;
    private PlayerView c;
    private SimpleExoPlayer d;
    private DefaultTrackSelector e;
    private DataSource$Factory f;
    private int g;
    private int h;
    private Uri[] i;
    private boolean j;
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private boolean q = true;
    private boolean r;
    private boolean s = false;
    private d$a t;
    private d$d u;
    private d$b v;
    private d$c w;
    private ExoVideoView$d x;
    private ExoVideoView$e y;
    private a z;

    public ExoVideoView(Context context) {
        this(context, null);
    }

    public ExoVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExoVideoView(Context context, AttributeSet attributeSet, int n10) {
        this(context, attributeSet, n10, 0);
    }

    public ExoVideoView(Context context, AttributeSet object, int n10, int n11) {
        super(context, object, n10, n11);
        Object object2 = new ExoVideoView$b(this);
        this.A = object2;
        this.B = object2 = new ExoVideoView$c(this);
        this.a = 0;
        this.b = 0;
        super();
        this.z = object;
        this.B(context);
    }

    private void B(Context context) {
        this.g = 0;
        this.h = 0;
        int n10 = R$layout.playerview_surfaceview;
        this.w(context, n10);
    }

    private boolean C() {
        int n10;
        int n11;
        SimpleExoPlayer simpleExoPlayer = this.d;
        int n12 = 1;
        if (simpleExoPlayer == null || (n11 = this.a) == (n10 = -1) || n11 == 0 || n11 == n12) {
            n12 = 0;
        }
        return n12 != 0;
    }

    /*
     * Exception decompiling
     */
    private void D() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 33[TRYBLOCK] [129 : 365->369)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private void K() {
        SimpleExoPlayer simpleExoPlayer = this.d;
        if (simpleExoPlayer != null) {
            int n10;
            this.k = n10 = simpleExoPlayer.getCurrentWindowIndex();
            SimpleExoPlayer simpleExoPlayer2 = this.d;
            long l10 = simpleExoPlayer2.getContentPosition();
            long l11 = Math.max(0L, l10);
            this.o = n10 = (int)l11;
        }
    }

    public static /* synthetic */ d$c e(ExoVideoView exoVideoView) {
        return exoVideoView.w;
    }

    public static /* synthetic */ int f(ExoVideoView exoVideoView) {
        return exoVideoView.a;
    }

    public static /* synthetic */ boolean g(ExoVideoView exoVideoView) {
        return exoVideoView.s;
    }

    public static /* synthetic */ int h(ExoVideoView exoVideoView, int n10) {
        exoVideoView.a = n10;
        return n10;
    }

    public static /* synthetic */ SimpleExoPlayer i(ExoVideoView exoVideoView) {
        return exoVideoView.d;
    }

    public static /* synthetic */ d$b j(ExoVideoView exoVideoView) {
        return exoVideoView.v;
    }

    public static /* synthetic */ boolean k(ExoVideoView exoVideoView) {
        return exoVideoView.r;
    }

    public static /* synthetic */ ExoVideoView$e l(ExoVideoView exoVideoView) {
        return exoVideoView.y;
    }

    public static /* synthetic */ int m(ExoVideoView exoVideoView, int n10) {
        exoVideoView.g = n10;
        return n10;
    }

    public static /* synthetic */ int n(ExoVideoView exoVideoView, int n10) {
        exoVideoView.h = n10;
        return n10;
    }

    public static /* synthetic */ int o(ExoVideoView exoVideoView, int n10) {
        exoVideoView.b = n10;
        return n10;
    }

    public static /* synthetic */ d$a p(ExoVideoView exoVideoView) {
        return exoVideoView.t;
    }

    public static /* synthetic */ d$d q(ExoVideoView exoVideoView) {
        return exoVideoView.u;
    }

    public static /* synthetic */ PlayerView r(ExoVideoView exoVideoView) {
        return exoVideoView.c;
    }

    public static /* synthetic */ ExoVideoView$d s(ExoVideoView exoVideoView) {
        return exoVideoView.x;
    }

    public static /* synthetic */ void t(ExoVideoView exoVideoView) {
        exoVideoView.y();
    }

    public static /* synthetic */ void u(ExoVideoView exoVideoView) {
        exoVideoView.D();
    }

    public static /* synthetic */ void v(ExoVideoView exoVideoView) {
        exoVideoView.K();
    }

    private void w(Context object, int n10) {
        object = (PlayerView)LayoutInflater.from((Context)object).inflate(n10, null, false);
        this.c = object;
        n10 = -1;
        object = new FrameLayout.LayoutParams(n10, n10);
        this.c.requestFocus();
        PlayerView playerView = this.c;
        this.addView((View)playerView, (ViewGroup.LayoutParams)object);
    }

    private MediaSource x(Uri object, DataSource$Factory object2) {
        int n10 = Util.inferContentType(object);
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 == n11) {
                        ProgressiveMediaSource$Factory progressiveMediaSource$Factory = new ProgressiveMediaSource$Factory((DataSource$Factory)object2);
                        return progressiveMediaSource$Factory.createMediaSource((Uri)object);
                    }
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Unsupported type: ");
                    ((StringBuilder)object2).append(n10);
                    object2 = ((StringBuilder)object2).toString();
                    object = new IllegalStateException((String)object2);
                    throw object;
                }
                HlsMediaSource$Factory hlsMediaSource$Factory = new HlsMediaSource$Factory((DataSource$Factory)object2);
                return hlsMediaSource$Factory.createMediaSource((Uri)object);
            }
            SsMediaSource$Factory ssMediaSource$Factory = new SsMediaSource$Factory((DataSource$Factory)object2);
            return ssMediaSource$Factory.createMediaSource((Uri)object);
        }
        DashMediaSource$Factory dashMediaSource$Factory = new DashMediaSource$Factory((DataSource$Factory)object2);
        return dashMediaSource$Factory.createMediaSource((Uri)object);
    }

    private void y() {
        this.k = -1;
        this.o = 1;
    }

    private MediaSource z(Uri[] object) {
        String string2;
        Object object2;
        MediaSource[] mediaSourceArray;
        DataSource$Factory dataSource$Factory = this.f;
        if (dataSource$Factory == null) {
            mediaSourceArray = this.getContext();
            object2 = this.getContext();
            string2 = D;
            object2 = Util.getUserAgent(object2, string2);
            this.f = dataSource$Factory = new DefaultDataSourceFactory((Context)mediaSourceArray, (String)object2);
        }
        int n10 = ((Uri[])object).length;
        mediaSourceArray = new MediaSource[n10];
        object2 = null;
        string2 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object3 = object[i10];
            DataSource$Factory dataSource$Factory2 = this.f;
            object3 = this.x((Uri)object3, dataSource$Factory2);
            mediaSourceArray[i10] = object3;
        }
        int n11 = 1;
        object = n10 == n11 ? mediaSourceArray[0] : new ConcatenatingMediaSource(mediaSourceArray);
        return object;
    }

    public void A() {
        this.c.hideController();
    }

    public void E() {
        SimpleExoPlayer simpleExoPlayer;
        boolean bl2 = this.C();
        int n10 = 4;
        if (bl2 && (bl2 = (simpleExoPlayer = this.d).getPlayWhenReady())) {
            simpleExoPlayer = this.d;
            simpleExoPlayer.setPlayWhenReady(false);
            this.a = n10;
        }
        this.b = n10;
    }

    public void F(boolean bl2) {
        SimpleExoPlayer simpleExoPlayer = this.d;
        if (simpleExoPlayer != null) {
            this.c.getOverlayFrameLayout().removeAllViews();
            simpleExoPlayer = this.d;
            Player$EventListener player$EventListener = this.A;
            simpleExoPlayer.removeListener(player$EventListener);
            this.d.release();
            this.d = null;
            this.e = null;
            simpleExoPlayer = null;
            this.a = 0;
            if (bl2) {
                this.y();
                this.b = 0;
            }
        }
    }

    public void G() {
        this.D();
    }

    public void H() {
        this.c.setResizeMode(3);
    }

    public void I() {
        this.c.showController();
    }

    public void J() {
        this.F(true);
    }

    public void L(boolean bl2) {
        int n10 = 0;
        this.F(false);
        this.removeAllViews();
        if (bl2) {
            Context context = this.getContext();
            n10 = R$layout.playerview_surfaceview;
            this.w(context, n10);
        } else {
            Context context = this.getContext();
            n10 = R$layout.playerview_textureview;
            this.w(context, n10);
        }
    }

    public boolean a() {
        return this.m;
    }

    public boolean b() {
        return this.n;
    }

    public void c(int n10) {
        boolean bl2 = this.C();
        if (bl2) {
            SimpleExoPlayer simpleExoPlayer = this.d;
            long l10 = n10;
            simpleExoPlayer.seekTo(l10);
            n10 = 0;
            this.o = 0;
        } else {
            this.o = n10;
        }
    }

    public boolean d() {
        return this.l;
    }

    public int getAudioSessionId() {
        return 0;
    }

    public int getBufferPercentage() {
        SimpleExoPlayer simpleExoPlayer = this.d;
        if (simpleExoPlayer != null) {
            return this.p;
        }
        return 0;
    }

    public int getCurrentPosition() {
        boolean bl2 = this.C();
        if (bl2) {
            return (int)this.d.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        boolean bl2 = this.C();
        if (bl2) {
            return (int)this.d.getDuration();
        }
        return 0;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.c.getOverlayFrameLayout();
    }

    public int getVideoHeight() {
        return this.h;
    }

    public int getVideoWidth() {
        return this.g;
    }

    public boolean isPlaying() {
        SimpleExoPlayer simpleExoPlayer;
        boolean bl2 = this.C();
        if (bl2 && (bl2 = (simpleExoPlayer = this.d).getPlayWhenReady())) {
            bl2 = true;
        } else {
            bl2 = false;
            simpleExoPlayer = null;
        }
        return bl2;
    }

    public void pause() {
        SimpleExoPlayer simpleExoPlayer;
        boolean bl2 = this.C();
        int n10 = 4;
        if (bl2 && (bl2 = (simpleExoPlayer = this.d).getPlayWhenReady())) {
            simpleExoPlayer = this.d;
            simpleExoPlayer.setPlayWhenReady(false);
            this.a = n10;
        }
        this.K();
        this.F(false);
        this.b = n10;
    }

    public void setControllerVisibilityListener(c c10) {
        boolean bl2 = this.q;
        if (bl2) {
            PlayerView playerView = this.c;
            ExoVideoView$a exoVideoView$a = new ExoVideoView$a(this, c10);
            playerView.setControllerVisibilityListener(exoVideoView$a);
        }
    }

    public void setGestureListener(GestureView$b gestureView$b) {
        Object object = this.c;
        int n10 = R$id.gestureview;
        object = (GestureView)object.findViewById(n10);
        n10 = gestureView$b == null ? 8 : 0;
        object.setVisibility(n10);
        ((GestureView)((Object)object)).setVideoGestureListener(gestureView$b);
    }

    public void setLoopPlay(boolean bl2) {
        this.j = bl2;
    }

    public void setMediaControllerDefault(boolean bl2) {
        this.q = bl2;
        this.c.setUseController(bl2);
    }

    public void setOnCompletionListener(d$a d$a) {
        this.t = d$a;
    }

    public void setOnErrorListener(d$b d$b) {
        this.v = d$b;
    }

    public void setOnInfoListener(d$c d$c) {
        this.w = d$c;
    }

    public void setOnPlayWhenReadyListener(ExoVideoView$d exoVideoView$d) {
        this.x = exoVideoView$d;
    }

    public void setOnPreparedListener(d$d d$d) {
        this.u = d$d;
    }

    public void setOnSeekCompleteListener(ExoVideoView$e exoVideoView$e) {
        this.y = exoVideoView$e;
    }

    public void setRawResourceId(int ... nArray) {
        int n10;
        int n11 = nArray.length;
        Uri[] uriArray = new Uri[n11];
        for (int i10 = 0; i10 < (n10 = nArray.length); ++i10) {
            Uri uri;
            n10 = nArray[i10];
            uriArray[i10] = uri = RawResourceDataSource.buildRawResourceUri(n10);
        }
        this.setVideoURI(uriArray);
    }

    public void setShouldBuffering(boolean bl2) {
        this.z.h(bl2);
    }

    public void setStopWhenError(boolean bl2) {
        this.s = bl2;
    }

    public void setVideoPath(String ... stringArray) {
        int n10;
        int n11 = stringArray.length;
        Uri[] uriArray = new Uri[n11];
        for (int i10 = 0; i10 < (n10 = stringArray.length); ++i10) {
            Uri uri;
            uriArray[i10] = uri = Uri.parse((String)stringArray[i10]);
        }
        this.setVideoURI(uriArray);
    }

    public void setVideoPositionChange(boolean bl2) {
        ExoVideoView$e exoVideoView$e;
        this.r = bl2;
        if (!bl2 && (exoVideoView$e = this.y) != null) {
            exoVideoView$e.a();
        }
    }

    public void setVideoURI(Uri ... uriArray) {
        this.i = uriArray;
        this.o = 0;
        this.D();
    }

    public void setVolume(float f10) {
        SimpleExoPlayer simpleExoPlayer = this.d;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVolume(f10);
        }
    }

    public void start() {
        boolean bl2 = this.C();
        int n10 = 3;
        if (bl2) {
            SimpleExoPlayer simpleExoPlayer = this.d;
            boolean bl3 = true;
            simpleExoPlayer.setPlayWhenReady(bl3);
            this.a = n10;
        } else {
            this.D();
        }
        this.b = n10;
    }
}

