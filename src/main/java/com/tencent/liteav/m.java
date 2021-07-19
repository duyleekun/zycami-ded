/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.view.Surface
 *  android.view.TextureView
 */
package com.tencent.liteav;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.ijk.media.player.IjkBitrateItem;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.o;
import com.tencent.liteav.h;
import com.tencent.liteav.k;
import com.tencent.liteav.m$1;
import com.tencent.liteav.q;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView;
import com.tencent.liteav.txcvodplayer.TextureRenderView;
import com.tencent.liteav.txcvodplayer.d;
import com.tencent.liteav.txcvodplayer.e;
import com.tencent.rtmp.TXBitrateItem;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.ArrayList;
import java.util.Map;

public class m
extends q {
    public boolean a;
    private TXCVodVideoView f;
    private d g;
    private k h = null;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private float m;
    private Surface n;
    private e o;

    public m(Context object) {
        super((Context)object);
        boolean bl2;
        this.j = bl2 = true;
        this.k = bl2;
        this.l = bl2;
        this.m = 1.0f;
        Object object2 = new m$1(this);
        this.o = object2;
        super((Context)object);
        this.f = object2;
        object = this.o;
        ((TXCVodVideoView)((Object)object2)).setListener((e)object);
    }

    public static /* synthetic */ k a(m m10) {
        return m10.h;
    }

    public static /* synthetic */ boolean a(m m10, boolean bl2) {
        m10.i = bl2;
        return bl2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private String b(String var1_1) {
        block15: {
            block9: {
                block14: {
                    block13: {
                        block10: {
                            var2_2 = this;
                            var3_3 /* !! */  = Uri.parse((String)var1_1);
                            var4_4 = var3_3 /* !! */ .getQuery();
                            var5_5 = "TXVodPlayer";
                            var6_6 = "";
                            if (var4_4 == null || (var7_7 = var4_4.isEmpty())) break block9;
                            var8_8 = "&";
                            var4_4 = var4_4.split(var8_8);
                            var9_9 = ((String[])var4_4).length;
                            var10_10 = "0";
                            if (var9_9 <= 0) break block10;
                            var9_9 = ((Object)var4_4).length;
                            var11_11 = var6_6;
                            var12_12 = var6_6;
                            var13_13 /* !! */  = var6_6;
                            var15_15 = 0;
                            for (var14_14 = 0; var14_14 < var9_9; ++var14_14) {
                                block8: {
                                    block11: {
                                        block12: {
                                            var16_16 = var4_4[var14_14];
                                            var17_17 = var16_16.split("=");
                                            var18_18 = var17_17.length;
                                            var19_19 = var4_4;
                                            var20_20 = 2;
                                            if (var18_18 != var20_20) break block11;
                                            var4_4 = "spfileid";
                                            var21_21 = var17_17[0];
                                            var20_20 = (int)var4_4.equalsIgnoreCase((String)var21_21);
                                            if (var20_20 != 0) {
                                                var20_20 = 1;
                                                var6_6 = var17_17[var20_20];
lbl30:
                                                // 3 sources

                                                while (true) {
                                                    ++var15_15;
                                                    break block8;
                                                    break;
                                                }
                                            }
                                            var18_18 = 0;
                                            var21_21 = "spdrmtype";
                                            var4_4 = var17_17[0];
                                            var20_20 = (int)var21_21.equalsIgnoreCase((String)var4_4);
                                            if (var20_20 == 0) break block12;
                                            var20_20 = 1;
                                            var11_11 = var17_17[var20_20];
                                            ** GOTO lbl30
                                        }
                                        var18_18 = 0;
                                        var21_21 = "spappid";
                                        var4_4 = var17_17[0];
                                        var20_20 = (int)var21_21.equalsIgnoreCase((String)var4_4);
                                        if (var20_20 != 0) {
                                            var20_20 = 1;
                                            var12_12 = var17_17[var20_20];
                                            ** continue;
                                        }
                                        var20_20 = 1;
                                        var18_18 = (int)var13_13 /* !! */ .isEmpty();
                                        if (var18_18 == 0) {
                                            var21_21 = new StringBuilder();
                                            var21_21.append(var13_13 /* !! */ );
                                            var21_21.append(var8_8);
                                            var13_13 /* !! */  = var21_21.toString();
                                        }
                                        var21_21 = new StringBuilder();
                                        var21_21.append(var13_13 /* !! */ );
                                        var21_21.append((String)var16_16);
                                        var21_21 = var21_21.toString();
                                        var13_13 /* !! */  = var21_21;
                                        break block8;
                                    }
                                    var20_20 = 1;
                                    var21_21 = "fieldIds.length != 2";
                                    TXCLog.e(var5_5, (String)var21_21);
                                }
                                var4_4 = var19_19;
                            }
                            var20_20 = 1;
                            var18_18 = 3;
                            if (var15_15 != var18_18) break block13;
                            var10_10 = "1";
                            var18_18 = var20_20;
                            break block14;
                        }
                        var11_11 = var6_6;
                        var12_12 = var6_6;
                        var13_13 /* !! */  = var6_6;
                    }
                    var18_18 = 0;
                    var21_21 = null;
                }
                if (var18_18 != 0) {
                    var4_4 = new StringBuilder();
                    var4_4.append("spfileid, ");
                    var4_4.append(var6_6);
                    var4_4.append(", spdrmtype= ");
                    var4_4.append(var11_11);
                    var8_8 = ", spappid=";
                    var4_4.append(var8_8);
                    var4_4.append(var12_12);
                    var4_4 = var4_4.toString();
                    TXCLog.d(var5_5, (String)var4_4);
                    var2_2.h.d(var6_6);
                    var2_2.h.c(var11_11);
                    var2_2.h.f(var12_12);
                    var4_4 = var2_2.h;
                    var4_4.b(var10_10);
                }
                var6_6 = var13_13 /* !! */ ;
                break block15;
            }
            var18_18 = 0;
            var21_22 = null;
        }
        if (var18_18 != 0) {
            var4_4 = var3_3 /* !! */ .buildUpon().clearQuery().build().toString();
            var18_18 = var6_6.isEmpty();
            var3_3 /* !! */  = var18_18 == 0 ? var3_3 /* !! */ .buildUpon().clearQuery().query(var6_6).build().toString() : var4_4;
        } else {
            var3_3 /* !! */  = var1_1;
        }
        var4_4 = new StringBuilder();
        var4_4.append("parsePlayUrl url: ");
        var4_4.append((String)var3_3 /* !! */ );
        var4_4 = var4_4.toString();
        TXCLog.i(var5_5, (String)var4_4);
        return var3_3 /* !! */ ;
    }

    public static /* synthetic */ boolean b(m m10) {
        return m10.i;
    }

    public static /* synthetic */ TXCVodVideoView c(m m10) {
        return m10.f;
    }

    public static /* synthetic */ d d(m m10) {
        return m10.g;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int a(String object, int n10) {
        block10: {
            k k10;
            TXCloudVideoView tXCloudVideoView = this.d;
            if (tXCloudVideoView != null) {
                tXCloudVideoView.setVisibility(0);
                TextureView textureView = this.d.getVideoView();
                if (textureView == null) {
                    Context context = this.d.getContext();
                    TextureRenderView textureRenderView = new TextureRenderView(context);
                    this.d.addVideoView(textureRenderView);
                    TXCVodVideoView tXCVodVideoView = this.f;
                    tXCVodVideoView.setTextureRenderView(textureRenderView);
                }
                TextureView textureView2 = this.d.getVideoView();
                textureView2.setVisibility(0);
            } else {
                Surface surface = this.n;
                if (surface != null) {
                    TXCVodVideoView tXCVodVideoView = this.f;
                    tXCVodVideoView.setRenderSurface(surface);
                }
            }
            Context context = this.c;
            this.h = k10 = new k(context);
            object = this.b((String)object);
            this.h.a((String)object);
            k k11 = this.h;
            int n11 = this.k;
            k11.a(n11 != 0);
            this.i = false;
            TXCVodVideoView tXCVodVideoView = this.f;
            n11 = this.g.b();
            tXCVodVideoView.setPlayerType(n11);
            TXCVodVideoView tXCVodVideoView2 = this.f;
            n11 = (int)(this.j ? 1 : 0);
            tXCVodVideoView2.b(n11 != 0);
            this.f.setVideoPath((String)object);
            TXCVodVideoView tXCVodVideoView3 = this.f;
            n11 = this.k;
            tXCVodVideoView3.setAutoPlay(n11 != 0);
            TXCVodVideoView tXCVodVideoView4 = this.f;
            float f10 = this.m;
            tXCVodVideoView4.setRate(f10);
            TXCVodVideoView tXCVodVideoView5 = this.f;
            n11 = this.l;
            tXCVodVideoView5.setAutoRotate(n11 != 0);
            this.f.b();
            k k12 = this.h;
            n11 = 1;
            f10 = Float.MIN_VALUE;
            k12.a(n11);
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "startPlay ";
            stringBuilder.append(string2);
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            String string3 = "TXVodPlayer";
            TXCLog.d(string3, (String)object);
            object = this.c;
            n10 = com.tencent.liteav.basic.datareport.a.bt;
            TXCDRApi.txReportDAU(object, n10);
            object = "com.tencent.liteav.demo.play.SuperPlayerView";
            try {
                object = Class.forName((String)object);
                if (object == null) break block10;
            }
            catch (Exception exception) {
                return 0;
            }
            object = this.c;
            n10 = com.tencent.liteav.basic.datareport.a.bE;
            TXCDRApi.txReportDAU(object, n10);
        }
        return 0;
    }

    public int a(boolean bl2) {
        k k10;
        this.f.c();
        TXCloudVideoView tXCloudVideoView = this.d;
        if (tXCloudVideoView != null && (tXCloudVideoView = tXCloudVideoView.getVideoView()) != null && bl2) {
            k10 = this.d.getVideoView();
            int n10 = 8;
            k10.setVisibility(n10);
        }
        if ((k10 = this.h) != null) {
            k10.b();
        }
        return 0;
    }

    public void a() {
        this.f.d();
        k k10 = this.h;
        if (k10 != null) {
            k10.c();
        }
    }

    public void a(float f10) {
        k k10;
        TXCVodVideoView tXCVodVideoView = this.f;
        float f11 = 1000.0f;
        int n10 = (int)(f10 *= f11);
        tXCVodVideoView.a(n10);
        n10 = (int)(this.i ? 1 : 0);
        if (n10 != 0 && (k10 = this.h) != null) {
            k10.k();
        }
    }

    public void a(int n10) {
        int n11 = 1;
        if (n10 == n11) {
            TXCVodVideoView tXCVodVideoView = this.f;
            n11 = 0;
            tXCVodVideoView.setRenderMode(0);
        } else {
            TXCVodVideoView tXCVodVideoView = this.f;
            tXCVodVideoView.setRenderMode(n11);
        }
    }

    public void a(Surface surface) {
        this.n = surface;
        TXCVodVideoView tXCVodVideoView = this.f;
        if (tXCVodVideoView != null) {
            tXCVodVideoView.setRenderSurface(surface);
        }
    }

    public void a(o o10) {
    }

    public void a(h h10) {
        boolean bl2;
        super.a(h10);
        Object object = this.g;
        if (object == null) {
            object = new d();
            this.g = object;
        }
        object = this.g;
        float f10 = this.b.e;
        ((d)object).a(f10);
        object = this.g;
        f10 = this.b.f;
        ((d)object).b(f10);
        object = this.g;
        f10 = this.b.r;
        ((d)object).c(f10);
        object = this.g;
        int n10 = this.b.h;
        ((d)object).a(n10 != 0);
        object = this.g;
        Object object2 = this.b.n;
        ((d)object).a((String)object2);
        object = this.g;
        n10 = this.b.o;
        ((d)object).a(n10);
        object = this.g;
        n10 = this.b.p;
        ((d)object).b(n10);
        object = this.g;
        object2 = this.b.q;
        ((d)object).a((Map)object2);
        object = this.g;
        n10 = (int)(this.b.s ? 1 : 0);
        ((d)object).b(n10 != 0);
        object = this.g;
        n10 = this.b.u;
        ((d)object).c(n10 != 0);
        object = this.g;
        object2 = this.b.v;
        ((d)object).b((String)object2);
        object = this.g;
        n10 = this.b.w;
        ((d)object).c(n10);
        object = this.g;
        n10 = this.b.x;
        ((d)object).d(n10);
        object = this.f;
        object2 = this.g;
        ((TXCVodVideoView)((Object)object)).setConfig((d)object2);
        this.l = bl2 = h10.t;
    }

    public void a(TextureRenderView textureRenderView) {
        TXCVodVideoView tXCVodVideoView = this.f;
        if (tXCVodVideoView != null) {
            tXCVodVideoView.setRenderView(textureRenderView);
        }
    }

    public void a(TXCloudVideoView tXCloudVideoView) {
        TXCloudVideoView tXCloudVideoView2 = this.d;
        if (tXCloudVideoView != tXCloudVideoView2) {
            if (tXCloudVideoView2 != null) {
                tXCloudVideoView2.removeVideoView();
            }
            if (tXCloudVideoView != null) {
                tXCloudVideoView.removeVideoView();
            }
        }
        if (tXCloudVideoView != null) {
            tXCloudVideoView2 = null;
            tXCloudVideoView.setVisibility(0);
            TextureView textureView = tXCloudVideoView.getVideoView();
            if (textureView == null) {
                Object object = tXCloudVideoView.getContext();
                textureView = new TextureRenderView((Context)object);
                tXCloudVideoView.addVideoView(textureView);
                object = this.f;
                ((TXCVodVideoView)((Object)object)).setTextureRenderView((TextureRenderView)textureView);
            }
            textureView = tXCloudVideoView.getVideoView();
            textureView.setVisibility(0);
        }
        super.a(tXCloudVideoView);
    }

    public void a(boolean bl2, int n10) {
    }

    public void b() {
        this.f.b();
        k k10 = this.h;
        if (k10 != null) {
            k10.d();
        }
    }

    public void b(float f10) {
        this.m = f10;
        Object object = this.f;
        if (object != null) {
            object.setRate(f10);
        }
        if ((object = this.h) != null) {
            ((k)object).a(f10);
        }
    }

    public void b(int n10) {
        TXCVodVideoView tXCVodVideoView = this.f;
        n10 = 360 - n10;
        tXCVodVideoView.setVideoRotationDegree(n10);
    }

    public void b(boolean bl2) {
        this.f.setMute(bl2);
    }

    public void c(float f10) {
        TXCVodVideoView tXCVodVideoView = this.f;
        if (tXCVodVideoView != null) {
            tXCVodVideoView.setStartTime(f10);
        }
    }

    public void c(int n10) {
        this.f.setVolume(n10);
    }

    public void c(boolean bl2) {
    }

    public boolean c() {
        return this.f.e();
    }

    public int d(int n10) {
        return 0;
    }

    public TextureView d() {
        TXCloudVideoView tXCloudVideoView = this.d;
        if (tXCloudVideoView != null) {
            return tXCloudVideoView.getVideoView();
        }
        return null;
    }

    public boolean d(boolean bl2) {
        this.j = bl2;
        TXCVodVideoView tXCVodVideoView = this.f;
        if (tXCVodVideoView != null) {
            return tXCVodVideoView.b(bl2);
        }
        return true;
    }

    public int e() {
        return 0;
    }

    public void e(int n10) {
        k k10;
        TXCVodVideoView tXCVodVideoView = this.f;
        tXCVodVideoView.a(n10 *= 1000);
        n10 = (int)(this.i ? 1 : 0);
        if (n10 != 0 && (k10 = this.h) != null) {
            k10.k();
        }
    }

    public void e(boolean bl2) {
        this.k = bl2;
        TXCVodVideoView tXCVodVideoView = this.f;
        if (tXCVodVideoView != null) {
            tXCVodVideoView.setAutoPlay(bl2);
        }
    }

    public void f(int n10) {
        this.f.setAudioPlayoutVolume(n10);
    }

    public void f(boolean bl2) {
        this.a = bl2;
    }

    public void g(int n10) {
        k k10;
        TXCVodVideoView tXCVodVideoView = this.f;
        if (tXCVodVideoView != null) {
            tXCVodVideoView.setBitrateIndex(n10);
        }
        if ((n10 = (int)(this.i ? 1 : 0)) != 0 && (k10 = this.h) != null) {
            k10.l();
        }
    }

    public void g(boolean bl2) {
        Object object = this.d();
        if (object != null) {
            int n10;
            Object object2 = this.b;
            int n11 = ((h)object2).t;
            float f10 = -1.0f;
            float f11 = 1.0f;
            if (n11 != 0 && ((n11 = ((TXCVodVideoView)((Object)(object2 = this.f))).getMetaRotationDegree()) == (n10 = 90) || (n11 = ((TXCVodVideoView)((Object)(object2 = this.f))).getMetaRotationDegree()) == (n10 = 270))) {
                if (!bl2) {
                    f10 = f11;
                }
                object.setScaleY(f10);
            } else {
                if (!bl2) {
                    f10 = f11;
                }
                object.setScaleX(f10);
            }
        }
        if ((object = this.h) != null) {
            ((k)object).b(bl2);
        }
    }

    public float h() {
        TXCVodVideoView tXCVodVideoView = this.f;
        if (tXCVodVideoView != null) {
            return (float)tXCVodVideoView.getCurrentPosition() / 1000.0f;
        }
        return 0.0f;
    }

    public int i() {
        return 0;
    }

    public float j() {
        TXCVodVideoView tXCVodVideoView = this.f;
        if (tXCVodVideoView != null) {
            return (float)tXCVodVideoView.getBufferDuration() / 1000.0f;
        }
        return 0.0f;
    }

    public float k() {
        TXCVodVideoView tXCVodVideoView = this.f;
        if (tXCVodVideoView != null) {
            return (float)tXCVodVideoView.getDuration() / 1000.0f;
        }
        return 0.0f;
    }

    public float l() {
        TXCVodVideoView tXCVodVideoView = this.f;
        if (tXCVodVideoView != null) {
            return (float)tXCVodVideoView.getBufferDuration() / 1000.0f;
        }
        return 0.0f;
    }

    public int m() {
        TXCVodVideoView tXCVodVideoView = this.f;
        if (tXCVodVideoView != null) {
            return tXCVodVideoView.getVideoWidth();
        }
        return 0;
    }

    public int n() {
        TXCVodVideoView tXCVodVideoView = this.f;
        if (tXCVodVideoView != null) {
            return tXCVodVideoView.getVideoHeight();
        }
        return 0;
    }

    public int o() {
        TXCVodVideoView tXCVodVideoView = this.f;
        if (tXCVodVideoView != null) {
            return tXCVodVideoView.getBitrateIndex();
        }
        return 0;
    }

    public ArrayList p() {
        ArrayList<TXBitrateItem> arrayList = new ArrayList<TXBitrateItem>();
        Object object = this.f;
        if (object != null && (object = object.getSupportedBitrates()) != null) {
            int n10;
            object = ((ArrayList)object).iterator();
            while ((n10 = object.hasNext()) != 0) {
                int n11;
                IjkBitrateItem ijkBitrateItem = (IjkBitrateItem)object.next();
                TXBitrateItem tXBitrateItem = new TXBitrateItem();
                tXBitrateItem.index = n11 = ijkBitrateItem.index;
                tXBitrateItem.width = n11 = ijkBitrateItem.width;
                tXBitrateItem.height = n11 = ijkBitrateItem.height;
                tXBitrateItem.bitrate = n10 = ijkBitrateItem.bitrate;
                arrayList.add(tXBitrateItem);
            }
        }
        return arrayList;
    }
}

