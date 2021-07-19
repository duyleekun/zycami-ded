/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.TextureView
 */
package com.tencent.liteav.renderer;

import android.graphics.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.view.TextureView;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.renderer.d$1;
import com.tencent.liteav.renderer.d$2;
import com.tencent.liteav.renderer.d$3;
import com.tencent.liteav.renderer.d$4;

public class d {
    private TextureView a;
    private Handler b;
    private int c = 0;
    private int d = 0;
    private int e = 640;
    private int f = 480;
    private int g = 0;
    private int h = 0;
    private int i = 1;
    private int j = 0;
    private float k = 1.0f;
    private int l = 0;

    public d(TextureView textureView) {
        Handler handler;
        int n10;
        this.a = textureView;
        this.c = n10 = textureView.getWidth();
        this.d = n10 = textureView.getHeight();
        textureView = textureView.getContext().getMainLooper();
        this.b = handler = new Handler((Looper)textureView);
    }

    public static /* synthetic */ float a(d d10, float f10) {
        d10.k = f10;
        return f10;
    }

    public static /* synthetic */ int a(d d10) {
        return d10.e;
    }

    private void a() {
        d$3 d$3 = new d$3(this);
        try {
            this.a(d$3);
        }
        catch (Exception exception) {
            String string2 = "TXCTextureViewWrapper";
            String string3 = "adjust video size failed.";
            TXCLog.e(string2, string3, exception);
        }
    }

    public static /* synthetic */ void a(d d10, int n10, int n11) {
        d10.c(n10, n11);
    }

    private void a(Runnable runnable) {
        Looper looper;
        Looper looper2 = Looper.getMainLooper();
        if (looper2 == (looper = Looper.myLooper())) {
            runnable.run();
        } else {
            looper2 = this.b;
            looper2.post(runnable);
        }
    }

    public static /* synthetic */ int b(d d10) {
        return d10.f;
    }

    public static /* synthetic */ int c(d d10) {
        return d10.i;
    }

    private void c(int n10, int n11) {
        int n12;
        int n13;
        TextureView textureView = this.a;
        if (textureView != null && n10 != 0 && n11 != 0 && (n13 = this.c) != 0 && (n12 = this.d) != 0) {
            double d10 = n11;
            double d11 = n10;
            n10 = (int)(d11 = (double)n13 * (d10 /= d11));
            if (n12 > n10) {
                this.g = n13;
                d11 = (double)n13 * d10;
                this.h = n10 = (int)d11;
            } else {
                d11 = (double)n12 / d10;
                this.g = n10 = (int)d11;
                this.h = n12;
            }
            n10 = this.g;
            n11 = n13 - n10;
            float f10 = n11;
            float f11 = 2.0f;
            int n14 = this.h;
            int n15 = n12 - n14;
            float f12 = (float)n15 / f11;
            float f13 = n10;
            float f14 = n13;
            f13 /= f14;
            f14 = n14;
            float f15 = n12;
            Matrix matrix = new Matrix();
            TextureView textureView2 = this.a;
            textureView2.getTransform(matrix);
            matrix.setScale(f13, f14 /= f15);
            matrix.postTranslate(f10 /= f11, f12);
            this.a.setTransform(matrix);
            TextureView textureView3 = this.a;
            textureView3.requestLayout();
        }
    }

    public static /* synthetic */ int d(d d10) {
        return d10.j;
    }

    public static /* synthetic */ TextureView e(d d10) {
        return d10.a;
    }

    public static /* synthetic */ float f(d d10) {
        return d10.k;
    }

    public void a(int n10) {
        Object object = this.b;
        Object object2 = new d$1(this, n10);
        try {
            object.post((Runnable)object2);
        }
        catch (Exception exception) {
            object = "TXCTextureViewWrapper";
            object2 = "set render mode failed";
            TXCLog.e((String)object, (String)object2, exception);
        }
    }

    public void a(int n10, int n11) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("vrender: set view size:");
        charSequence.append(n10);
        charSequence.append(",");
        charSequence.append(n11);
        charSequence = charSequence.toString();
        TXCLog.w("TXCTextureViewWrapper", (String)charSequence);
        this.c = n10;
        this.d = n11;
        this.a();
    }

    public void a(boolean bl2) {
        Object object = this.b;
        Object object2 = new d$4(this, bl2);
        try {
            object.post((Runnable)object2);
        }
        catch (Exception exception) {
            object = "TXCTextureViewWrapper";
            object2 = "set mirror failed.";
            TXCLog.e((String)object, (String)object2, exception);
        }
    }

    /*
     * Unable to fully structure code
     */
    public void b(int var1_1) {
        block7: {
            block6: {
                block9: {
                    block10: {
                        block8: {
                            this.i = var1_1;
                            var2_2 = this.a;
                            if (var2_2 == null) break block7;
                            var3_3 = 1;
                            var4_4 = 1.4E-45f;
                            var5_5 = 90;
                            var6_6 = 1.26E-43f;
                            var7_7 = 270;
                            var8_8 = 180;
                            var9_9 = 1.0f;
                            if (var1_1 != var3_3) break block8;
                            var1_1 = this.j;
                            if (var1_1 != 0 && var1_1 != var8_8 && (var1_1 == var7_7 || var1_1 == var5_5)) {
                                var1_1 = this.g;
                                if (var1_1 != 0 && (var3_3 = this.h) != 0) {
                                    var5_5 = this.d;
                                    var6_6 = var5_5;
                                    var10_10 = var1_1;
                                    var6_6 /= var10_10;
                                    var1_1 = this.c;
                                    var10_10 = var1_1;
                                    var4_4 = var3_3;
                                    cfr_temp_0 = var6_6 - (var10_10 /= var4_4);
                                    if ((var3_3 = (int)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1))) > 0) lbl-1000:
                                    // 2 sources

                                    {
                                        while (true) {
                                            var9_9 = var10_10;
                                            break block6;
                                            break;
                                        }
                                    }
lbl28:
                                    // 4 sources

                                    while (true) {
                                        var9_9 = var6_6;
                                        break block6;
                                        break;
                                    }
                                }
                                return;
                            }
                            break block6;
                        }
                        if (var1_1 != 0) break block6;
                        var1_1 = this.g;
                        if (var1_1 == 0 || (var3_3 = this.h) == 0) break block9;
                        var11_11 = this.j;
                        if (var11_11 == 0 || var11_11 == var8_8) break block10;
                        if (var11_11 != var7_7 && var11_11 != var5_5) break block6;
                        var5_5 = this.d;
                        var6_6 = var5_5;
                        var10_10 = var1_1;
                        var6_6 /= var10_10;
                        var1_1 = this.c;
                        var10_10 = var1_1;
                        var4_4 = var3_3;
                        cfr_temp_1 = var6_6 - (var10_10 /= var4_4);
                        if ((var3_3 = (int)(cfr_temp_1 == 0.0f ? 0 : (cfr_temp_1 < 0.0f ? -1 : 1))) >= 0) ** GOTO lbl28
                        ** while (true)
                    }
                    var5_5 = this.d;
                    var6_6 = var5_5;
                    var4_4 = var3_3;
                    var6_6 /= var4_4;
                    var3_3 = this.c;
                    var4_4 = var3_3;
                    var10_10 = var1_1;
                    cfr_temp_2 = var6_6 - (var4_4 /= var10_10);
                    if ((var1_1 = (int)(cfr_temp_2 == 0.0f ? 0 : (cfr_temp_2 < 0.0f ? -1 : 1))) < 0) ** break;
                    ** while (true)
                    var9_9 = var4_4;
                    break block6;
                }
                return;
            }
            var10_10 = this.k;
            var3_3 = 0;
            var4_4 = 0.0f;
            cfr_temp_3 = var10_10 - 0.0f;
            var1_1 = (int)(cfr_temp_3 == 0.0f ? 0 : (cfr_temp_3 < 0.0f ? -1 : 1));
            if (var1_1 < 0) {
                var9_9 = -var9_9;
            }
            var2_2.setScaleX(var9_9);
            var12_12 = this.a;
            var13_13 = Math.abs(var9_9);
            var12_12.setScaleY(var13_13);
            this.k = var9_9;
        }
    }

    public void b(int n10, int n11) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("vrender: set video size:");
        charSequence.append(n10);
        charSequence.append(",");
        charSequence.append(n11);
        charSequence = charSequence.toString();
        TXCLog.w("TXCTextureViewWrapper", (String)charSequence);
        this.e = n10;
        this.f = n11;
        this.a();
    }

    public void c(int n10) {
        Object object = this.b;
        Object object2 = new d$2(this, n10);
        try {
            object.post((Runnable)object2);
        }
        catch (Exception exception) {
            object = "TXCTextureViewWrapper";
            object2 = "set render rotation failed.";
            TXCLog.e((String)object, (String)object2, exception);
        }
    }

    /*
     * Unable to fully structure code
     */
    public void d(int var1_1) {
        block9: {
            block8: {
                block10: {
                    block12: {
                        block11: {
                            this.j = var1_1 %= 360;
                            var2_2 = this.a;
                            if (var2_2 == null) break block9;
                            var3_3 = 1;
                            var4_4 = 1.4E-45f;
                            var5_5 = 1.0f;
                            if (var1_1 == 0) break block10;
                            var6_6 = 180;
                            var7_7 = 2.52E-43f;
                            if (var1_1 == var6_6) break block10;
                            var6_6 = 270;
                            var7_7 = 3.78E-43f;
                            if (var1_1 == var6_6) break block11;
                            var6_6 = 90;
                            var7_7 = 1.26E-43f;
                            if (var1_1 != var6_6) break block8;
                        }
                        if ((var6_6 = this.g) == 0 || (var6_6 = this.h) == 0) break block12;
                        var8_8 = 360 - var1_1;
                        var2_2.setRotation(var8_8);
                        var1_1 = this.d;
                        var8_8 = var1_1;
                        var9_9 = this.g;
                        var8_8 /= var9_9;
                        var10_10 = this.c;
                        var9_9 = var10_10;
                        var7_7 = this.h;
                        var9_9 /= var7_7;
                        var6_6 = this.i;
                        if (var6_6 == var3_3) {
                            var3_3 = (int)(var8_8 == var9_9 ? 0 : (var8_8 > var9_9 ? 1 : -1));
                            if (var3_3 > 0) lbl-1000:
                            // 3 sources

                            {
                                while (true) {
                                    var5_5 = var9_9;
                                    break block8;
                                    break;
                                }
                            }
lbl36:
                            // 3 sources

                            while (true) {
                                var5_5 = var8_8;
                                break block8;
                                break;
                            }
                        }
                        if (var6_6 != 0) break block8;
                        ** while ((var3_3 = (int)(var8_8 == var9_9 ? 0 : (var8_8 < var9_9 ? -1 : 1))) >= 0)
lbl41:
                        // 1 sources

                        ** GOTO lbl-1000
                    }
                    return;
                }
                var8_8 = 360 - var1_1;
                var2_2.setRotation(var8_8);
                var1_1 = this.i;
                if (var1_1 != var3_3 && var1_1 == 0) {
                    var1_1 = this.g;
                    if (var1_1 != 0 && (var10_10 = this.h) != 0) {
                        var3_3 = this.d;
                        var4_4 = var3_3;
                        var9_9 = var10_10;
                        var4_4 /= var9_9;
                        var10_10 = this.c;
                        var9_9 = var10_10;
                        var8_8 = var1_1;
                        cfr_temp_0 = var4_4 - (var9_9 /= var8_8);
                        if ((var1_1 = (int)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 < 0.0f ? -1 : 1))) >= 0) ** break;
                        ** continue;
                        var5_5 = var4_4;
                    } else {
                        return;
                    }
                }
            }
            var8_8 = this.k;
            var10_10 = 0;
            var9_9 = 0.0f;
            var2_2 = null;
            cfr_temp_1 = var8_8 - 0.0f;
            var1_1 = (int)(cfr_temp_1 == 0.0f ? 0 : (cfr_temp_1 < 0.0f ? -1 : 1));
            if (var1_1 < 0) {
                var5_5 = -var5_5;
            }
            this.a.setScaleX(var5_5);
            var11_11 = this.a;
            var9_9 = Math.abs(var5_5);
            var11_11.setScaleY(var9_9);
            this.k = var5_5;
        }
    }
}

