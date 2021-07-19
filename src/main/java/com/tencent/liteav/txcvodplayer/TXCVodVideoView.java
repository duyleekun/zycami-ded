/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.AudioManager
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.util.AttributeSet
 *  android.view.Surface
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 */
package com.tencent.liteav.txcvodplayer;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer$OnBufferingUpdateListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnCompletionListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnErrorListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnHLSKeyErrorListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnHevcVideoDecoderErrorListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnInfoListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnPreparedListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnSeekCompleteListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnTimedTextListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnVideoDecoderErrorListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnVideoSizeChangedListener;
import com.tencent.ijk.media.player.IjkLibLoader;
import com.tencent.ijk.media.player.IjkMediaPlayer;
import com.tencent.ijk.media.player.IjkMediaPlayer$OnNativeInvokeListener;
import com.tencent.ijk.media.player.MediaInfo;
import com.tencent.ijk.media.player.TextureMediaPlayer;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.txcvodplayer.SurfaceRenderView;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView$1;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView$10;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView$11;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView$12;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView$13;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView$14;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView$15;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView$2;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView$3;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView$4;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView$5;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView$6;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView$7;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView$8;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView$9;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView$a;
import com.tencent.liteav.txcvodplayer.TextureRenderView;
import com.tencent.liteav.txcvodplayer.a;
import com.tencent.liteav.txcvodplayer.a$a;
import com.tencent.liteav.txcvodplayer.a$b;
import com.tencent.liteav.txcvodplayer.b;
import com.tencent.liteav.txcvodplayer.d;
import com.tencent.liteav.txcvodplayer.e;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;

public class TXCVodVideoView
extends FrameLayout {
    private int A;
    private String B;
    private float C;
    private com.tencent.liteav.txcvodplayer.a.a D;
    private com.tencent.liteav.txcvodplayer.a.b E;
    private long F;
    private boolean G;
    private int H;
    private float I;
    private float J;
    private boolean K;
    private int L;
    private boolean M;
    private b N;
    private boolean O;
    private IMediaPlayer$OnCompletionListener P;
    private IMediaPlayer$OnInfoListener Q;
    private int R;
    private IMediaPlayer$OnErrorListener S;
    private IMediaPlayer$OnHevcVideoDecoderErrorListener T;
    private IMediaPlayer$OnVideoDecoderErrorListener U;
    private IMediaPlayer$OnBufferingUpdateListener V;
    private IMediaPlayer$OnSeekCompleteListener W;
    public boolean a;
    private IMediaPlayer$OnTimedTextListener aa;
    private IjkMediaPlayer$OnNativeInvokeListener ab;
    private IMediaPlayer$OnHLSKeyErrorListener ac;
    private int ad;
    private e ae;
    private Handler af;
    private boolean ag;
    public boolean b;
    public boolean c;
    public final int d;
    public IMediaPlayer$OnVideoSizeChangedListener e;
    public IMediaPlayer$OnPreparedListener f;
    public a$a g;
    private String h = "TXCVodVideoView";
    private Uri i;
    private int j = 0;
    private int k = 0;
    private a$b l = null;
    private IMediaPlayer m = null;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private Context w;
    private d x;
    private a y;
    private int z;

    public TXCVodVideoView(Context context) {
        super(context);
        com.tencent.liteav.txcvodplayer.a.b b10;
        float f10;
        boolean bl2;
        this.a = bl2 = true;
        this.C = f10 = 1.0f;
        this.E = b10 = com.tencent.liteav.txcvodplayer.a.b.a();
        this.b = bl2;
        this.c = bl2;
        this.d = 0;
        this.G = false;
        this.H = -1;
        this.I = f10;
        this.J = f10;
        this.K = false;
        this.O = false;
        Object object = new TXCVodVideoView$9(this);
        this.e = object;
        this.f = object = new TXCVodVideoView$10(this);
        this.P = object = new TXCVodVideoView$11(this);
        this.Q = object = new TXCVodVideoView$12(this);
        this.S = object = new TXCVodVideoView$13(this);
        this.T = object = new TXCVodVideoView$14(this);
        this.U = object = new TXCVodVideoView$15(this);
        this.V = object = new TXCVodVideoView$2(this);
        this.W = object = new TXCVodVideoView$3(this);
        this.aa = object = new TXCVodVideoView$4(this);
        this.ab = object = new TXCVodVideoView$5(this);
        this.ac = object = new TXCVodVideoView$6(this);
        this.g = object = new TXCVodVideoView$7(this);
        this.ad = 0;
        this.ag = false;
        this.a(context);
    }

    public TXCVodVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        com.tencent.liteav.txcvodplayer.a.b b10;
        float f10;
        boolean bl2;
        this.a = bl2 = true;
        this.C = f10 = 1.0f;
        this.E = b10 = com.tencent.liteav.txcvodplayer.a.b.a();
        this.b = bl2;
        this.c = bl2;
        this.d = 0;
        this.G = false;
        this.H = -1;
        this.I = f10;
        this.J = f10;
        this.K = false;
        this.O = false;
        Object object = new TXCVodVideoView$9(this);
        this.e = object;
        this.f = object = new TXCVodVideoView$10(this);
        this.P = object = new TXCVodVideoView$11(this);
        this.Q = object = new TXCVodVideoView$12(this);
        this.S = object = new TXCVodVideoView$13(this);
        this.T = object = new TXCVodVideoView$14(this);
        this.U = object = new TXCVodVideoView$15(this);
        this.V = object = new TXCVodVideoView$2(this);
        this.W = object = new TXCVodVideoView$3(this);
        this.aa = object = new TXCVodVideoView$4(this);
        this.ab = object = new TXCVodVideoView$5(this);
        this.ac = object = new TXCVodVideoView$6(this);
        this.g = object = new TXCVodVideoView$7(this);
        this.ad = 0;
        this.ag = false;
        this.a(context);
    }

    public TXCVodVideoView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        com.tencent.liteav.txcvodplayer.a.b b10;
        float f10;
        n10 = 1;
        this.a = n10;
        this.C = f10 = 1.0f;
        this.E = b10 = com.tencent.liteav.txcvodplayer.a.b.a();
        this.b = n10;
        this.c = n10;
        this.d = 0;
        this.G = false;
        this.H = -1;
        this.I = f10;
        this.J = f10;
        this.K = false;
        this.O = false;
        Object object = new TXCVodVideoView$9(this);
        this.e = object;
        this.f = object = new TXCVodVideoView$10(this);
        this.P = object = new TXCVodVideoView$11(this);
        this.Q = object = new TXCVodVideoView$12(this);
        this.S = object = new TXCVodVideoView$13(this);
        this.T = object = new TXCVodVideoView$14(this);
        this.U = object = new TXCVodVideoView$15(this);
        this.V = object = new TXCVodVideoView$2(this);
        this.W = object = new TXCVodVideoView$3(this);
        this.aa = object = new TXCVodVideoView$4(this);
        this.ab = object = new TXCVodVideoView$5(this);
        this.ac = object = new TXCVodVideoView$6(this);
        this.g = object = new TXCVodVideoView$7(this);
        this.ad = 0;
        this.ag = false;
        this.a(context);
    }

    public static /* synthetic */ int a(TXCVodVideoView tXCVodVideoView, int n10) {
        tXCVodVideoView.n = n10;
        return n10;
    }

    public static /* synthetic */ long a(TXCVodVideoView tXCVodVideoView, long l10) {
        tXCVodVideoView.F = l10;
        return l10;
    }

    public static /* synthetic */ IMediaPlayer a(TXCVodVideoView tXCVodVideoView, IMediaPlayer iMediaPlayer) {
        tXCVodVideoView.m = iMediaPlayer;
        return iMediaPlayer;
    }

    public static /* synthetic */ a$b a(TXCVodVideoView tXCVodVideoView, a$b a$b) {
        tXCVodVideoView.l = a$b;
        return a$b;
    }

    public static /* synthetic */ a a(TXCVodVideoView tXCVodVideoView) {
        return tXCVodVideoView.y;
    }

    public static /* synthetic */ String a(TXCVodVideoView tXCVodVideoView, String string2) {
        tXCVodVideoView.B = string2;
        return string2;
    }

    private void a(int n10, String string2, String string3) {
        int n11;
        int n12;
        boolean bl2;
        int n13 = 2106;
        int n14 = -2304;
        if ((n10 == n14 || n10 == n13) && (bl2 = this.ag)) {
            return;
        }
        Object object = new Message();
        ((Message)object).what = n12 = 101;
        Object object2 = new Bundle();
        ((Message)object).arg1 = n10;
        String string4 = "description";
        object2.putString(string4, string2);
        object.setData(object2);
        string2 = this.af;
        if (string2 != null) {
            string2.sendMessage((Message)object);
        }
        if (n10 != (n11 = 2018) && n10 != (n11 = 2016)) {
            string2 = this.h;
            object = new StringBuilder();
            ((StringBuilder)object).append("sendSimpleEvent ");
            ((StringBuilder)object).append(n10);
            object2 = " ";
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(string3);
            string3 = ((StringBuilder)object).toString();
            TXCLog.i(string2, string3);
        }
        n10 = n10 != n14 && n10 != n13 ? 0 : 1;
        this.ag = n10;
    }

    private void a(Context object) {
        this.w = object = object.getApplicationContext();
        object = new d();
        this.x = object;
        this.i();
        this.n = 0;
        this.o = 0;
        boolean bl2 = true;
        this.setFocusable(bl2);
        this.setFocusableInTouchMode(bl2);
        this.requestFocus();
        this.j = 0;
        this.k = 0;
        object = Looper.getMainLooper();
        if (object != null) {
            TXCVodVideoView$a tXCVodVideoView$a = new TXCVodVideoView$a(this, (Looper)object);
            this.af = tXCVodVideoView$a;
        } else {
            object = null;
            this.af = null;
        }
        object = new b();
        this.N = object;
    }

    private void a(IMediaPlayer iMediaPlayer, a$b a$b) {
        if (iMediaPlayer == null) {
            return;
        }
        if (a$b == null) {
            iMediaPlayer.setDisplay(null);
            return;
        }
        TXCLog.i(this.h, "bindSurfaceHolder");
        a$b.a(iMediaPlayer);
    }

    public static /* synthetic */ void a(TXCVodVideoView tXCVodVideoView, int n10, String string2, String string3) {
        tXCVodVideoView.a(n10, string2, string3);
    }

    public static /* synthetic */ void a(TXCVodVideoView tXCVodVideoView, IMediaPlayer iMediaPlayer, a$b a$b) {
        tXCVodVideoView.a(iMediaPlayer, a$b);
    }

    public static /* synthetic */ boolean a(TXCVodVideoView tXCVodVideoView, boolean bl2) {
        tXCVodVideoView.M = bl2;
        return bl2;
    }

    public static /* synthetic */ int b(TXCVodVideoView tXCVodVideoView) {
        return tXCVodVideoView.o;
    }

    public static /* synthetic */ int b(TXCVodVideoView tXCVodVideoView, int n10) {
        tXCVodVideoView.o = n10;
        return n10;
    }

    public static /* synthetic */ boolean b(TXCVodVideoView tXCVodVideoView, boolean bl2) {
        tXCVodVideoView.G = bl2;
        return bl2;
    }

    public static /* synthetic */ int c(TXCVodVideoView tXCVodVideoView) {
        return tXCVodVideoView.n;
    }

    public static /* synthetic */ int c(TXCVodVideoView tXCVodVideoView, int n10) {
        tXCVodVideoView.z = n10;
        return n10;
    }

    public static /* synthetic */ int d(TXCVodVideoView tXCVodVideoView) {
        return tXCVodVideoView.z;
    }

    public static /* synthetic */ int d(TXCVodVideoView tXCVodVideoView, int n10) {
        tXCVodVideoView.A = n10;
        return n10;
    }

    public static /* synthetic */ int e(TXCVodVideoView tXCVodVideoView) {
        return tXCVodVideoView.A;
    }

    public static /* synthetic */ int e(TXCVodVideoView tXCVodVideoView, int n10) {
        tXCVodVideoView.k = n10;
        return n10;
    }

    public static /* synthetic */ int f(TXCVodVideoView tXCVodVideoView, int n10) {
        tXCVodVideoView.j = n10;
        return n10;
    }

    public static /* synthetic */ Handler f(TXCVodVideoView tXCVodVideoView) {
        return tXCVodVideoView.af;
    }

    /*
     * Unable to fully structure code
     */
    private boolean f() {
        block182: {
            block184: {
                block183: {
                    block181: {
                        block179: {
                            block173: {
                                block180: {
                                    block178: {
                                        block177: {
                                            block176: {
                                                block175: {
                                                    block174: {
                                                        var1_1 = this;
                                                        TXCLog.i(this.h, "openVideo");
                                                        var2_2 = this.i;
                                                        var3_5 = null;
                                                        if (var2_2 == null) {
                                                            return false;
                                                        }
                                                        this.a(false);
                                                        var4_6 = this.b;
                                                        var5_7 = 3;
                                                        var6_8 = 4.2E-45f;
                                                        var7_9 = 0;
                                                        var8_10 = 1;
                                                        var9_11 = 1.4E-45f;
                                                        if (var4_6) {
                                                            var2_2 = this.w;
                                                            var10_12 = "audio";
                                                            var2_2 = (AudioManager)var2_2.getSystemService((String)var10_12);
                                                            var2_2.requestAudioFocus(null, var5_7, var8_10);
                                                        }
                                                        var2_2 = var1_1.i;
                                                        var2_2 = var2_2.toString();
                                                        var11_13 = "/";
                                                        var12_14 = var2_2.startsWith((String)var11_13);
                                                        if (!var12_14) ** GOTO lbl35
                                                        var11_13 = new File((String)var2_2);
                                                        var12_14 = var11_13.exists();
                                                        if (var12_14) ** GOTO lbl35
                                                        var2_2 = new FileNotFoundException();
                                                        throw var2_2;
lbl35:
                                                        // 2 sources

                                                        if ((var11_13 = var1_1.i) == null) break block173;
                                                        var13_15 = new TXCVodVideoView$8(var1_1);
                                                        var11_13 = new IjkMediaPlayer((IjkLibLoader)var13_15);
                                                        IjkMediaPlayer.native_setLogLevel(var5_7);
                                                        var13_15 = var1_1.ab;
                                                        var11_13.setOnNativeInvokeListener((IjkMediaPlayer$OnNativeInvokeListener)var13_15);
                                                        var13_15 = var1_1.x;
                                                        var14_16 = var13_15.d;
                                                        var15_17 = "mediacodec";
                                                        var16_18 = 1L;
                                                        var18_19 = 0L;
                                                        var20_20 = 0.0;
                                                        var22_21 = 4;
                                                        if (var14_16 == 0) break block174;
                                                        var11_13.setOption(var22_21, (String)var15_17, var16_18);
                                                        var13_15 = "mediacodec-hevc";
                                                        var11_13.setOption(var22_21, (String)var13_15, var16_18);
                                                        var1_1.O = var8_10;
                                                        ** GOTO lbl66
                                                    }
                                                    var11_13.setOption(var22_21, (String)var15_17, var18_19);
                                                    var1_1.O = false;
lbl66:
                                                    // 2 sources

                                                    var13_15 = var1_1.h;
                                                    var15_17 = new StringBuilder();
                                                    var23_22 = "ijk mediacodec ";
                                                    var15_17.append((String)var23_22);
                                                    var23_22 = var1_1.x;
                                                    var24_23 = var23_22.d;
                                                    var15_17.append(var24_23);
                                                    var15_17 = var15_17.toString();
                                                    TXCLog.i((String)var13_15, (String)var15_17);
                                                    var13_15 = "mediacodec-auto-rotate";
                                                    var11_13.setOption(var22_21, (String)var13_15, var18_19);
                                                    var13_15 = "mediacodec-handle-resolution-change";
                                                    var11_13.setOption(var22_21, (String)var13_15, var18_19);
                                                    var13_15 = "opensles";
                                                    var11_13.setOption(var22_21, (String)var13_15, var18_19);
                                                    var13_15 = "overlay-format";
                                                    var25_24 = 842225234L;
                                                    var11_13.setOption(var22_21, (String)var13_15, var25_24);
                                                    var27_25 = "framedrop";
                                                    var11_13.setOption(var22_21, (String)var27_25, var16_18);
                                                    var27_25 = "soundtouch";
                                                    var11_13.setOption(var22_21, (String)var27_25, var16_18);
                                                    var27_25 = "max-fps";
                                                    var28_26 = 30;
                                                    var11_13.setOption(var22_21, (String)var27_25, var28_26);
                                                    var5_7 = (int)var1_1.c;
                                                    var30_27 = "start-on-prepared";
                                                    if (var5_7 == 0) break block175;
                                                    var5_7 = var1_1.k;
                                                    if (var5_7 == var22_21) break block175;
                                                    var11_13.setOption(var22_21, (String)var30_27, var16_18);
                                                    break block176;
                                                }
                                                var11_13.setOption(var22_21, (String)var30_27, var18_19);
                                            }
                                            var27_25 = "load-on-prepared";
                                            var11_13.setOption(var22_21, (String)var27_25, var16_18);
                                            var27_25 = "http-detect-range-support";
                                            var7_9 = 1;
                                            var11_13.setOption(var7_9, (String)var27_25, var18_19);
                                            var27_25 = "skip_loop_filter";
                                            var8_10 = 2;
                                            var9_11 = 2.8E-45f;
                                            var11_13.setOption(var8_10, (String)var27_25, var18_19);
                                            var27_25 = "skip_frame";
                                            var11_13.setOption(var8_10, (String)var27_25, var18_19);
                                            var27_25 = "timeout";
                                            var10_12 = var1_1.x;
                                            var31_28 = var10_12.c;
                                            var32_29 = 1000.0f;
                                            var31_28 = var31_28 * var32_29 * var32_29;
                                            var33_30 = (int)var31_28;
                                            var34_31 = var33_30;
                                            var7_9 = 1;
                                            var11_13.setOption(var7_9, (String)var27_25, var34_31);
                                            var27_25 = "reconnect";
                                            var11_13.setOption(var7_9, (String)var27_25, var16_18);
                                            var27_25 = "analyzeduration";
                                            var34_31 = 90000000L;
                                            var11_13.setOption(var7_9, (String)var27_25, var34_31);
                                            var27_25 = "enable-accurate-seek";
                                            var10_12 = var1_1.x;
                                            var33_30 = (int)var10_12.i;
                                            var34_31 = var33_30 != 0 ? var16_18 : var18_19;
                                            var11_13.setOption(var22_21, (String)var27_25, var34_31);
                                            var27_25 = "disable-bitrate-sync";
                                            var10_12 = var1_1.x;
                                            var33_30 = (int)var10_12.j;
                                            if (var33_30 == 0) break block177;
                                            var16_18 = var18_19;
                                        }
                                        var11_13.setOption(var22_21, (String)var27_25, var16_18);
                                        var27_25 = "dns_cache_timeout";
                                        var7_9 = 1;
                                        var11_13.setOption(var7_9, (String)var27_25, var18_19);
                                        var27_25 = "cache_max_capacity";
                                        var34_31 = 0x7FFFFFFFL;
                                        var11_13.setOption(var7_9, (String)var27_25, var34_31);
                                        var5_7 = var1_1.u;
                                        if (var5_7 <= 0) ** GOTO lbl198
                                        var10_12 = "seek-at-start";
                                        var34_31 = var5_7;
                                        var11_13.setOption(var22_21, (String)var10_12, var34_31);
                                        var27_25 = var1_1.h;
                                        var10_12 = new StringBuilder();
                                        var13_15 = "ijk start time ";
                                        var10_12.append((String)var13_15);
                                        var14_16 = var1_1.u;
                                        var10_12.append(var14_16);
                                        var10_12 = var10_12.toString();
                                        TXCLog.i((String)var27_25, (String)var10_12);
lbl198:
                                        // 2 sources

                                        var27_25 = var1_1.x;
                                        var5_7 = var27_25.m;
                                        if (var5_7 <= 0) ** GOTO lbl223
                                        var10_12 = "max-buffer-size";
                                        var5_7 = var5_7 * 1024 * 1024;
                                        var34_31 = var5_7;
                                        var11_13.setOption(var22_21, (String)var10_12, var34_31);
                                        var27_25 = var1_1.h;
                                        var10_12 = new StringBuilder();
                                        var13_15 = "ijk max buffer size ";
                                        var10_12.append((String)var13_15);
                                        var13_15 = var1_1.x;
                                        var14_16 = var13_15.m;
                                        var10_12.append(var14_16);
                                        var10_12 = var10_12.toString();
                                        TXCLog.i((String)var27_25, (String)var10_12);
lbl223:
                                        // 2 sources

                                        var27_25 = var1_1.x;
                                        var27_25 = var27_25.h;
                                        if (var27_25 == null) ** GOTO lbl292
                                        var27_25 = var27_25.keySet();
                                        var27_25 = var27_25.iterator();
                                        var24_23 = false;
                                        var23_22 = null;
                                        block169: while (true) {
                                            var33_30 = (int)var27_25.hasNext();
                                            if (var33_30 == 0) break block178;
                                            var10_12 = var27_25.next();
                                            var10_12 = (String)var10_12;
                                            var13_15 = "%s: %s";
                                            if (var23_22 != null) break;
                                            var15_17 = new Object[var8_10];
                                            var15_17[0] = var10_12;
                                            var36_32 = var1_1.x;
                                            var36_32 = var36_32.h;
                                            var10_12 = var36_32.get(var10_12);
                                            var7_9 = 1;
                                            var15_17[var7_9] = var10_12;
                                            var10_12 = String.format((String)var13_15, (Object[])var15_17);
lbl257:
                                            // 2 sources

                                            while (true) {
                                                var23_22 = var10_12;
                                                continue block169;
                                                break;
                                            }
                                            break;
                                        }
                                        var15_17 = new StringBuilder();
                                        var15_17.append((String)var23_22);
                                        var36_32 = "\r\n";
                                        var15_17.append((String)var36_32);
                                        var36_32 = new Object[var8_10];
                                        var36_32[0] = var10_12;
                                        var37_33 = var1_1.x;
                                        var37_33 = var37_33.h;
                                        var10_12 = var37_33.get(var10_12);
                                        var7_9 = 1;
                                        var36_32[var7_9] = var10_12;
                                        var10_12 = String.format((String)var13_15, var36_32);
                                        var15_17.append((String)var10_12);
                                        var10_12 = var15_17.toString();
                                        ** continue;
                                    }
                                    var27_25 = "headers";
                                    var7_9 = 1;
                                    var11_13.setOption(var7_9, (String)var27_25, (String)var23_22);
lbl292:
                                    // 2 sources

                                    var5_7 = var1_1.L;
                                    var11_13.setBitrateIndex(var5_7);
                                    var5_7 = 5;
                                    var6_8 = 7.0E-45f;
                                    IjkMediaPlayer.native_setLogLevel(var5_7);
                                    var27_25 = var1_1.x;
                                    var27_25 = var27_25.e;
                                    if (var27_25 == null) break block179;
                                    var27_25 = var1_1.E;
                                    var5_7 = (int)var27_25.e((String)var2_2);
                                    if (var5_7 == 0) break block179;
                                    var27_25 = var1_1.E;
                                    var30_27 = var1_1.x;
                                    var30_27 = var30_27.e;
                                    var27_25.b((String)var30_27);
                                    var27_25 = var1_1.E;
                                    var30_27 = var1_1.x;
                                    var8_10 = var30_27.f;
                                    var27_25.a(var8_10);
                                    var27_25 = var1_1.E;
                                    var27_25 = var27_25.d((String)var2_2);
                                    var1_1.D = var27_25;
                                    if (var27_25 == null) break block179;
                                    var27_25 = var27_25.a();
                                    if (var27_25 == null) break block180;
                                    var2_2 = "cache_file_path";
                                    var27_25 = var1_1.D;
                                    var27_25 = var27_25.a();
                                    var7_9 = 1;
                                    var11_13.setOption(var7_9, (String)var2_2, (String)var27_25);
                                    var2_2 = new StringBuilder();
                                    var27_25 = "ijkio:cache:ffio:";
                                    var2_2.append((String)var27_25);
                                    var27_25 = var1_1.i;
                                    var27_25 = var27_25.toString();
                                    var2_2.append((String)var27_25);
                                    var2_2 = var2_2.toString();
                                    break block179;
                                }
                                var27_25 = var1_1.D;
                                var27_25 = var27_25.b();
                                if (var27_25 == null) break block179;
                                var2_2 = "cache_db_path";
                                var27_25 = var1_1.D;
                                var27_25 = var27_25.b();
                                var7_9 = 1;
                                var11_13.setOption(var7_9, (String)var2_2, (String)var27_25);
                                var2_2 = new StringBuilder();
                                var27_25 = "ijkhlscache:";
                                var2_2.append((String)var27_25);
                                var27_25 = var1_1.i;
                                var27_25 = var27_25.toString();
                                var2_2.append((String)var27_25);
                                var2_2 = var2_2.toString();
                                break block179;
                            }
                            var12_14 = false;
                            var11_13 = null;
                        }
                        var27_25 = var1_1.h;
                        var30_27 = new StringBuilder();
                        var10_12 = "ijk media player ";
                        var30_27.append((String)var10_12);
                        var30_27.append(var11_13);
                        var30_27 = var30_27.toString();
                        TXCLog.i((String)var27_25, (String)var30_27);
                        var27_25 = new TextureMediaPlayer((IMediaPlayer)var11_13);
                        var1_1.m = var27_25;
                        var27_25.setDataSource((String)var2_2);
                        var2_2 = var1_1.m;
                        var27_25 = var1_1.f;
                        var2_2.setOnPreparedListener((IMediaPlayer$OnPreparedListener)var27_25);
                        var2_2 = var1_1.m;
                        var27_25 = var1_1.e;
                        var2_2.setOnVideoSizeChangedListener((IMediaPlayer$OnVideoSizeChangedListener)var27_25);
                        var2_2 = var1_1.m;
                        var27_25 = var1_1.P;
                        var2_2.setOnCompletionListener((IMediaPlayer$OnCompletionListener)var27_25);
                        var2_2 = var1_1.m;
                        var27_25 = var1_1.S;
                        var2_2.setOnErrorListener((IMediaPlayer$OnErrorListener)var27_25);
                        var2_2 = var1_1.m;
                        var27_25 = var1_1.Q;
                        var2_2.setOnInfoListener((IMediaPlayer$OnInfoListener)var27_25);
                        var2_2 = var1_1.m;
                        var27_25 = var1_1.V;
                        var2_2.setOnBufferingUpdateListener((IMediaPlayer$OnBufferingUpdateListener)var27_25);
                        var2_2 = var1_1.m;
                        var27_25 = var1_1.W;
                        var2_2.setOnSeekCompleteListener((IMediaPlayer$OnSeekCompleteListener)var27_25);
                        var2_2 = var1_1.m;
                        var27_25 = var1_1.aa;
                        var2_2.setOnTimedTextListener((IMediaPlayer$OnTimedTextListener)var27_25);
                        var2_2 = var1_1.m;
                        var27_25 = var1_1.ac;
                        var2_2.setOnHLSKeyErrorListener((IMediaPlayer$OnHLSKeyErrorListener)var27_25);
                        var2_2 = var1_1.m;
                        var27_25 = var1_1.T;
                        var2_2.setOnHevcVideoDecoderErrorListener((IMediaPlayer$OnHevcVideoDecoderErrorListener)var27_25);
                        var2_2 = var1_1.m;
                        var27_25 = var1_1.U;
                        var2_2.setOnVideoDecoderErrorListener((IMediaPlayer$OnVideoDecoderErrorListener)var27_25);
                        var1_1.t = 0;
                        var2_2 = var1_1.m;
                        var27_25 = var1_1.l;
                        var1_1.a((IMediaPlayer)var2_2, (a$b)var27_25);
                        var2_2 = var1_1.m;
                        var5_7 = 3;
                        var6_8 = 4.2E-45f;
                        var2_2.setAudioStreamType(var5_7);
                        var2_2 = var1_1.m;
                        var5_7 = 1;
                        var6_8 = 1.4E-45f;
                        var2_2.setScreenOnWhilePlaying((boolean)var5_7);
                        var2_2 = var1_1.m;
                        var2_2.prepareAsync();
                        var2_2 = var1_1.m;
                        var6_8 = var1_1.I;
                        var9_11 = var1_1.J;
                        var2_2.setVolume(var6_8, var9_11);
                        var4_6 = var1_1.K;
                        var1_1.setMute(var4_6);
                        var2_2 = var1_1.N;
                        if (var2_2 == null) break block181;
                        var27_25 = var1_1.m;
                        var2_2.a((IMediaPlayer)var27_25);
                    }
                    var5_7 = 1;
                    var6_8 = 1.4E-45f;
                    try {
                        var1_1.j = var5_7;
                        var7_9 = 1;
                        break block182;
                    }
                    catch (Exception var2_3) {
                        var27_25 = var1_1.h;
                        var2_4 = var2_3.toString();
                        TXCLog.w((String)var27_25, (String)var2_4);
                        var5_7 = -1;
                        var6_8 = 0.0f / 0.0f;
                        var1_1.j = var5_7;
                        var1_1.k = var5_7;
                        var2_4 = var1_1.S;
                        var27_25 = var1_1.m;
                        var7_9 = 1;
                        var2_4.onError((IMediaPlayer)var27_25, var7_9, 0);
                    }
                    {
                        catch (FileNotFoundException v0) {
                            var7_9 = var5_7;
                            break block183;
                        }
                        catch (FileNotFoundException v1) {
                            var5_7 = -1;
                            var6_8 = 0.0f / 0.0f;
                            var7_9 = 1;
                            break block184;
                        }
                    }
                    break block182;
                    catch (FileNotFoundException v2) {
                        var7_9 = var8_10;
                    }
                }
                var5_7 = -1;
                var6_8 = 0.0f / 0.0f;
            }
            var1_1.j = var5_7;
            var1_1.k = var5_7;
            var2_2 = var1_1.S;
            var3_5 = var1_1.m;
            var5_7 = -1004;
            var6_8 = 0.0f / 0.0f;
            var8_10 = -2303;
            var9_11 = 0.0f / 0.0f;
            var2_2.onError(var3_5, var5_7, var8_10);
        }
        return (boolean)var7_9;
    }

    public static /* synthetic */ int g(TXCVodVideoView tXCVodVideoView) {
        return tXCVodVideoView.j;
    }

    public static /* synthetic */ int g(TXCVodVideoView tXCVodVideoView, int n10) {
        tXCVodVideoView.u = n10;
        return n10;
    }

    private void g() {
        int n10;
        Object object = this.h;
        String string2 = "replay";
        TXCLog.i((String)object, string2);
        int n11 = this.u;
        if (n11 == 0 && (object = this.m) != null && (n10 = this.v) > 0) {
            long l10 = object.getCurrentPosition();
            this.u = n11 = (int)l10;
        }
        if ((n11 = (int)(this.f() ? 1 : 0)) == 0) {
            n11 = 0;
            object = null;
            this.a(false);
        }
    }

    public static /* synthetic */ int h(TXCVodVideoView tXCVodVideoView) {
        return tXCVodVideoView.p;
    }

    public static /* synthetic */ int h(TXCVodVideoView tXCVodVideoView, int n10) {
        tXCVodVideoView.s = n10;
        return n10;
    }

    private boolean h() {
        int n10;
        int n11;
        IMediaPlayer iMediaPlayer = this.m;
        int n12 = 1;
        if (iMediaPlayer == null || (n11 = this.j) == (n10 = -1) || n11 == 0 || n11 == n12) {
            n12 = 0;
        }
        return n12 != 0;
    }

    public static /* synthetic */ int i(TXCVodVideoView tXCVodVideoView) {
        return tXCVodVideoView.q;
    }

    public static /* synthetic */ int i(TXCVodVideoView tXCVodVideoView, int n10) {
        tXCVodVideoView.r = n10;
        return n10;
    }

    private void i() {
        this.setRender(0);
    }

    public static /* synthetic */ int j(TXCVodVideoView tXCVodVideoView) {
        return tXCVodVideoView.k;
    }

    public static /* synthetic */ int j(TXCVodVideoView tXCVodVideoView, int n10) {
        tXCVodVideoView.R = n10;
        return n10;
    }

    public static /* synthetic */ int k(TXCVodVideoView tXCVodVideoView, int n10) {
        tXCVodVideoView.t = n10;
        return n10;
    }

    public static /* synthetic */ String k(TXCVodVideoView tXCVodVideoView) {
        return tXCVodVideoView.h;
    }

    public static /* synthetic */ int l(TXCVodVideoView tXCVodVideoView, int n10) {
        tXCVodVideoView.p = n10;
        return n10;
    }

    public static /* synthetic */ boolean l(TXCVodVideoView tXCVodVideoView) {
        return tXCVodVideoView.M;
    }

    public static /* synthetic */ float m(TXCVodVideoView tXCVodVideoView) {
        return tXCVodVideoView.C;
    }

    public static /* synthetic */ int m(TXCVodVideoView tXCVodVideoView, int n10) {
        tXCVodVideoView.q = n10;
        return n10;
    }

    public static /* synthetic */ Uri n(TXCVodVideoView tXCVodVideoView) {
        return tXCVodVideoView.i;
    }

    public static /* synthetic */ int o(TXCVodVideoView tXCVodVideoView) {
        return tXCVodVideoView.s;
    }

    public static /* synthetic */ int p(TXCVodVideoView tXCVodVideoView) {
        return tXCVodVideoView.r;
    }

    public static /* synthetic */ long q(TXCVodVideoView tXCVodVideoView) {
        return tXCVodVideoView.F;
    }

    public static /* synthetic */ int r(TXCVodVideoView tXCVodVideoView) {
        int n10;
        int n11 = tXCVodVideoView.R;
        tXCVodVideoView.R = n10 = n11 + 1;
        return n11;
    }

    public static /* synthetic */ d s(TXCVodVideoView tXCVodVideoView) {
        return tXCVodVideoView.x;
    }

    public static /* synthetic */ void t(TXCVodVideoView tXCVodVideoView) {
        tXCVodVideoView.g();
    }

    public static /* synthetic */ int u(TXCVodVideoView tXCVodVideoView) {
        return tXCVodVideoView.H;
    }

    public static /* synthetic */ String v(TXCVodVideoView tXCVodVideoView) {
        return tXCVodVideoView.B;
    }

    public static /* synthetic */ IMediaPlayer w(TXCVodVideoView tXCVodVideoView) {
        return tXCVodVideoView.m;
    }

    public static /* synthetic */ boolean x(TXCVodVideoView tXCVodVideoView) {
        return tXCVodVideoView.f();
    }

    public static /* synthetic */ e y(TXCVodVideoView tXCVodVideoView) {
        return tXCVodVideoView.ae;
    }

    public void a() {
        IMediaPlayer iMediaPlayer = this.m;
        if (iMediaPlayer != null) {
            iMediaPlayer.setDisplay(null);
        }
    }

    public void a(int n10) {
        Object object = this.h;
        CharSequence charSequence = new StringBuilder();
        String string2 = "seek to ";
        charSequence.append(string2);
        charSequence.append(n10);
        charSequence = charSequence.toString();
        TXCLog.i((String)object, (String)charSequence);
        object = this.getUrlPathExtention();
        charSequence = "m3u8";
        boolean n11 = ((String)object).equals(charSequence);
        if (n11) {
            int n12 = this.getDuration() + -1000;
            n10 = Math.min(n10, n12);
        }
        if (n10 < 0) {
            return;
        }
        boolean bl2 = this.h();
        if (bl2) {
            boolean bl3;
            int n13 = this.getDuration();
            if (n10 > n13) {
                n10 = this.getDuration();
            }
            if (bl3 = this.G) {
                this.H = n10;
            } else {
                int n14;
                this.H = n14 = -1;
                object = this.m;
                long l10 = n10;
                object.seekTo(l10);
            }
            n10 = 1;
            this.G = n10;
        }
    }

    public void a(boolean bl2) {
        Object object = this.m;
        if (object != null) {
            object = this.h;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("release player ");
            IMediaPlayer iMediaPlayer = this.m;
            charSequence.append(iMediaPlayer);
            charSequence = charSequence.toString();
            TXCLog.i((String)object, (String)charSequence);
            this.m.release();
            object = null;
            this.m = null;
            charSequence = null;
            this.j = 0;
            if (bl2) {
                this.k = 0;
                this.n = 0;
                this.o = 0;
            }
            if (bl2 = this.b) {
                Context context = this.w;
                charSequence = "audio";
                context = (AudioManager)context.getSystemService((String)charSequence);
                context.abandonAudioFocus(null);
            }
        }
    }

    public void b() {
        Object object = this.h;
        String string2 = "start";
        TXCLog.i((String)object, string2);
        int n10 = this.h();
        int n11 = 3;
        if (n10 != 0) {
            object = this.m;
            object.start();
            n10 = this.j;
            if (n10 != n11 && (n10 = (int)(this.G ? 1 : 0)) == 0) {
                this.j = n11;
                n10 = 2004;
                String string3 = "Playback started";
                String string4 = "playing";
                this.a(n10, string3, string4);
            }
        }
        this.k = n11;
    }

    public boolean b(boolean bl2) {
        int n10 = this.j;
        if (n10 == 0) {
            this.b = bl2;
            return true;
        }
        return false;
    }

    public void c() {
        int n10;
        Object object = this.m;
        if (object != null) {
            int n11;
            object = this.D;
            n10 = 0;
            String string2 = null;
            if (object != null) {
                n11 = this.getDuration();
                if (n11 <= 0) {
                    object = this.E;
                    String string3 = this.D.d();
                    boolean bl2 = true;
                    ((com.tencent.liteav.txcvodplayer.a.b)object).a(string3, bl2);
                } else {
                    object = this.E;
                    String string4 = this.D.d();
                    ((com.tencent.liteav.txcvodplayer.a.b)object).a(string4, false);
                }
                this.D = null;
            }
            this.m.stop();
            this.m.release();
            this.m = null;
            this.i = null;
            this.n = 0;
            this.o = 0;
            this.C = 1.0f;
            this.G = false;
            this.H = n11 = -1;
            this.j = 0;
            this.k = 0;
            this.M = false;
            this.O = false;
            this.L = 0;
            object = this.N;
            if (object != null) {
                ((b)object).a(null);
            }
            if ((n11 = (int)(this.b ? 1 : 0)) != 0) {
                object = this.w;
                string2 = "audio";
                object = (AudioManager)object.getSystemService(string2);
                object.abandonAudioFocus(null);
            }
        }
        if ((object = this.af) != null) {
            n10 = 102;
            object.removeMessages(n10);
        }
        TXCLog.i(this.h, "stop");
    }

    public void d() {
        int n10;
        this.k = n10 = 4;
        Object object = this.h;
        String string2 = "pause";
        TXCLog.i((String)object, string2);
        boolean bl2 = this.h();
        if (bl2 && (bl2 = (object = this.m).isPlaying())) {
            object = this.m;
            object.pause();
            this.j = n10;
        }
    }

    public boolean e() {
        int n10;
        IMediaPlayer iMediaPlayer;
        int n11 = this.h();
        if (n11 != 0 && (n11 = (iMediaPlayer = this.m).isPlaying()) != 0 && (n11 = this.j) != (n10 = 4)) {
            n11 = 1;
        } else {
            n11 = 0;
            iMediaPlayer = null;
        }
        return n11 != 0;
    }

    public int getBitrateIndex() {
        IMediaPlayer iMediaPlayer = this.m;
        if (iMediaPlayer != null) {
            return iMediaPlayer.getBitrateIndex();
        }
        return this.L;
    }

    public int getBufferDuration() {
        int n10;
        IMediaPlayer iMediaPlayer = this.m;
        if (iMediaPlayer != null) {
            int n11;
            this.getUnwrappedMediaPlayer();
            n10 = this.t;
            int n12 = this.getDuration();
            n10 = n10 * n12 / 100;
            n12 = this.getCurrentPosition();
            if (n10 < n12) {
                n10 = this.getCurrentPosition();
            }
            if ((n12 = Math.abs(this.getDuration() - n10)) < (n11 = 1000)) {
                n10 = this.getDuration();
            }
        } else {
            n10 = 0;
            iMediaPlayer = null;
        }
        return n10;
    }

    public int getCurrentPosition() {
        int n10 = this.G;
        if (n10 != 0 && (n10 = this.H) >= 0) {
            return n10;
        }
        n10 = this.u;
        if (n10 > 0) {
            return n10;
        }
        IMediaPlayer iMediaPlayer = this.m;
        if (iMediaPlayer != null) {
            return (int)iMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        int n10;
        int n11;
        IMediaPlayer iMediaPlayer = this.m;
        if (iMediaPlayer != null && (n11 = this.v) < (n10 = 1)) {
            int n12;
            long l10 = iMediaPlayer.getDuration();
            this.v = n12 = (int)l10;
        }
        return this.v;
    }

    public MediaInfo getMediaInfo() {
        IMediaPlayer iMediaPlayer = this.m;
        if (iMediaPlayer == null) {
            return null;
        }
        return iMediaPlayer.getMediaInfo();
    }

    public int getMetaRotationDegree() {
        return this.s;
    }

    public int getPlayerType() {
        return 0;
    }

    public String getServerIp() {
        return this.B;
    }

    public ArrayList getSupportedBitrates() {
        Object object = this.m;
        if (object != null) {
            return object.getSupportedBitrates();
        }
        object = new Object();
        return object;
    }

    public IMediaPlayer getUnwrappedMediaPlayer() {
        IMediaPlayer iMediaPlayer = this.m;
        boolean bl2 = iMediaPlayer instanceof TextureMediaPlayer;
        if (bl2) {
            iMediaPlayer = ((TextureMediaPlayer)iMediaPlayer).getBackEndMediaPlayer();
        }
        return iMediaPlayer;
    }

    public String getUrlPathExtention() {
        Object object = this.i;
        if (object != null && (object = object.getPath()) != null) {
            object = this.i.getPath();
            int n10 = ((String)object).lastIndexOf(".") + 1;
            int n11 = ((String)object).length();
            return ((String)object).substring(n10, n11);
        }
        return "";
    }

    public int getVideoHeight() {
        return this.o;
    }

    public int getVideoRotationDegree() {
        return this.r;
    }

    public int getVideoWidth() {
        return this.n;
    }

    public void setAudioPlayoutVolume(int n10) {
        IMediaPlayer iMediaPlayer = this.m;
        if (iMediaPlayer != null) {
            iMediaPlayer.setAudioVolume(n10);
        }
    }

    public void setAutoPlay(boolean bl2) {
        this.c = bl2;
    }

    public void setAutoRotate(boolean bl2) {
        this.a = bl2;
    }

    public void setBitrateIndex(int n10) {
        Object object = this.h;
        Object object2 = new StringBuilder();
        String string2 = "setBitrateIndex ";
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(n10);
        object2 = ((StringBuilder)object2).toString();
        TXCLog.i((String)object, (String)object2);
        int n11 = this.L;
        if (n11 == n10) {
            return;
        }
        this.L = n10;
        object = this.m;
        if (object != null) {
            object2 = this.x;
            boolean bl2 = ((d)object2).j;
            if (bl2) {
                object.setBitrateIndex(n10);
            } else {
                this.g();
            }
        }
    }

    public void setConfig(d object) {
        if (object != null) {
            this.x = object;
            com.tencent.liteav.txcvodplayer.a.b b10 = this.E;
            object = ((d)object).k;
            b10.a((String)object);
        }
    }

    public void setListener(e e10) {
        this.ae = e10;
    }

    public void setMute(boolean bl2) {
        this.K = bl2;
        IMediaPlayer iMediaPlayer = this.m;
        if (iMediaPlayer == null) {
            return;
        }
        if (bl2) {
            bl2 = false;
            float f10 = 0.0f;
            iMediaPlayer.setVolume(0.0f, 0.0f);
        } else {
            float f11 = this.I;
            float f12 = this.J;
            iMediaPlayer.setVolume(f11, f12);
        }
    }

    public void setPlayerType(int n10) {
    }

    public void setRate(float f10) {
        Object object = this.h;
        CharSequence charSequence = new StringBuilder();
        String string2 = "setRate ";
        charSequence.append(string2);
        charSequence.append(f10);
        charSequence = charSequence.toString();
        TXCLog.i((String)object, (String)charSequence);
        object = this.m;
        if (object != null) {
            object.setRate(f10);
        }
        this.C = f10;
    }

    public void setRender(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                int n12 = 2;
                if (n10 != n12) {
                    Object object;
                    String string2 = this.h;
                    Locale locale = Locale.getDefault();
                    Object[] objectArray = new Object[n11];
                    objectArray[0] = object = Integer.valueOf(n10);
                    object = String.format(locale, "invalid render %d\n", objectArray);
                    TXCLog.e(string2, (String)object);
                } else {
                    Object object = this.w;
                    TextureRenderView textureRenderView = new TextureRenderView((Context)object);
                    object = this.m;
                    if (object != null) {
                        object = textureRenderView.getSurfaceHolder();
                        IMediaPlayer iMediaPlayer = this.m;
                        object.a(iMediaPlayer);
                        n11 = this.m.getVideoWidth();
                        n12 = this.m.getVideoHeight();
                        textureRenderView.setVideoSize(n11, n12);
                        object = this.m;
                        n11 = object.getVideoSarNum();
                        iMediaPlayer = this.m;
                        n12 = iMediaPlayer.getVideoSarDen();
                        textureRenderView.setVideoSampleAspectRatio(n11, n12);
                        n11 = this.ad;
                        textureRenderView.setAspectRatio(n11);
                    }
                    this.setRenderView(textureRenderView);
                }
            } else {
                Context context = this.w;
                SurfaceRenderView surfaceRenderView = new SurfaceRenderView(context);
                this.setRenderView(surfaceRenderView);
            }
        } else {
            n10 = 0;
            Object var7_13 = null;
            this.setRenderView(null);
        }
    }

    public void setRenderMode(int n10) {
        a a10;
        this.ad = n10;
        a a11 = this.y;
        if (a11 != null) {
            a11.setAspectRatio(n10);
        }
        if ((a10 = this.y) != null) {
            int n11 = this.r;
            a10.setVideoRotation(n11);
        }
    }

    public void setRenderSurface(Surface object) {
        TXCVodVideoView$1 tXCVodVideoView$1 = new TXCVodVideoView$1(this, (Surface)object);
        this.l = tXCVodVideoView$1;
        object = this.m;
        if (object != null) {
            this.a((IMediaPlayer)object, tXCVodVideoView$1);
        }
    }

    public void setRenderView(a a10) {
        int n10;
        Object object = this.h;
        CharSequence charSequence = new StringBuilder();
        Object object2 = "setRenderView ";
        charSequence.append((String)object2);
        charSequence.append(a10);
        charSequence = charSequence.toString();
        TXCLog.i((String)object, (String)charSequence);
        object = this.y;
        if (object != null) {
            object = this.m;
            n10 = 0;
            charSequence = null;
            if (object != null) {
                object.setDisplay(null);
            }
            object = this.y.getView();
            object2 = this.y;
            a$a a$a = this.g;
            object2.removeRenderCallback(a$a);
            this.y = null;
            charSequence = object.getParent();
            if (charSequence == this) {
                this.removeView((View)object);
            }
        }
        if (a10 == null) {
            return;
        }
        this.y = a10;
        int n11 = this.ad;
        a10.setAspectRatio(n11);
        n11 = this.n;
        if (n11 > 0 && (n10 = this.o) > 0) {
            a10.setVideoSize(n11, n10);
        }
        if ((n11 = this.z) > 0 && (n10 = this.A) > 0) {
            a10.setVideoSampleAspectRatio(n11, n10);
        }
        a10 = this.y.getView();
        n10 = 17;
        int n12 = -2;
        object = new FrameLayout.LayoutParams(n12, n12, n10);
        a10.setLayoutParams((ViewGroup.LayoutParams)object);
        object = a10.getParent();
        if (object == null) {
            this.addView((View)a10);
        }
        a10 = this.y;
        object = this.g;
        a10.addRenderCallback((a$a)object);
        a10 = this.y;
        n11 = this.r;
        a10.setVideoRotation(n11);
    }

    public void setStartTime(float f10) {
        int n10;
        this.u = n10 = (int)(f10 * 1000.0f);
    }

    public void setTextureRenderView(TextureRenderView textureRenderView) {
        Object object = this.h;
        Object object2 = new StringBuilder();
        String string2 = "setTextureRenderView ";
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(textureRenderView);
        object2 = ((StringBuilder)object2).toString();
        TXCLog.i((String)object, (String)object2);
        object = this.m;
        if (object != null) {
            object = textureRenderView.getSurfaceHolder();
            object2 = this.m;
            object.a((IMediaPlayer)object2);
            int n10 = this.m.getVideoWidth();
            int n11 = this.m.getVideoHeight();
            textureRenderView.setVideoSize(n10, n11);
            object = this.m;
            n10 = object.getVideoSarNum();
            object2 = this.m;
            n11 = object2.getVideoSarDen();
            textureRenderView.setVideoSampleAspectRatio(n10, n11);
            n10 = this.ad;
            textureRenderView.setAspectRatio(n10);
        }
        this.setRenderView(textureRenderView);
    }

    public void setVideoPath(String string2) {
        string2 = Uri.parse((String)string2);
        this.setVideoURI((Uri)string2);
    }

    public void setVideoRotationDegree(int n10) {
        a a10;
        int n11;
        if (n10 != 0 && n10 != (n11 = 90) && n10 != (n11 = 180) && n10 != (n11 = 270)) {
            n11 = 360;
            if (n10 != n11) {
                String string2 = this.h;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("not support degree ");
                stringBuilder.append(n10);
                String string3 = stringBuilder.toString();
                TXCLog.e(string2, string3);
                return;
            }
            n10 = 0;
            a10 = null;
        }
        this.r = n10;
        a a11 = this.y;
        if (a11 != null) {
            a11.setVideoRotation(n10);
        }
        if ((a10 = this.y) != null) {
            n11 = this.ad;
            a10.setAspectRatio(n11);
        }
    }

    public void setVideoURI(Uri object) {
        this.i = object;
        this.v = 0;
        this.R = 0;
        this.B = null;
        String string2 = this.h;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setVideoURI ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        TXCLog.i(string2, (String)object);
        this.f();
        this.requestLayout();
        this.invalidate();
    }

    public void setVolume(int n10) {
        float f10 = n10;
        float f11 = 100.0f;
        this.I = f10 /= f11;
        this.J = f10;
        IMediaPlayer iMediaPlayer = this.m;
        if (iMediaPlayer != null) {
            iMediaPlayer.setVolume(f10, f10);
        }
    }
}

