/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 */
package cn.sharesdk.framework.loopshare.watermark;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import cn.sharesdk.framework.loopshare.watermark.g;
import cn.sharesdk.framework.utils.SSDKLog;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class a {
    private static int[] a;
    private static int b = 15;
    private static int c = 270;
    private static float[] d;
    private static int e;
    private static int f;
    private static int g;

    static {
        float[] fArray;
        int n10 = 3;
        a = new int[n10];
        float[] fArray2 = fArray = new float[n10];
        fArray[0] = 60.0f;
        fArray2[1] = 30.0f;
        fArray2[2] = 10.0f;
        d = fArray;
        e = -1;
        f = 0;
        g = 100;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static boolean a(String var0, String[] var1_3) {
        var2_4 = "ShareSDK";
        var3_5 = true;
        var4_6 = new Paint((int)var3_5);
        var5_7 = cn.sharesdk.framework.loopshare.watermark.a.e;
        var4_6.setColor(var5_7);
        cn.sharesdk.framework.loopshare.watermark.a.c = 0;
        cn.sharesdk.framework.loopshare.watermark.a.b = 0;
        var5_7 = 0;
        var6_8 /* !! */  = null;
        while (true) {
            var7_9 = ((String[])var1_3).length;
            if (var5_7 >= var7_9) break;
            var8_10 = cn.sharesdk.framework.loopshare.watermark.a.d;
            var9_11 = var8_10[var5_7];
            var4_6.setTextSize((float)var9_11);
            var8_10 = new Rect();
            var10_12 /* !! */  = var1_3[var5_7];
            var11_13 = var1_3[var5_7];
            var12_14 = var11_13.length();
            var4_6.getTextBounds((String)var10_12 /* !! */ , 0, var12_14, (Rect)var8_10);
            var13_15 = cn.sharesdk.framework.loopshare.watermark.a.c;
            var12_14 = var8_10.width();
            if (var13_15 >= var12_14) ** GOTO lbl40
            var13_15 = var8_10.width();
            cn.sharesdk.framework.loopshare.watermark.a.c = var13_15;
lbl40:
            // 2 sources

            var10_12 /* !! */  = (Bitmap.Config)cn.sharesdk.framework.loopshare.watermark.a.a;
            var12_14 = var8_10.height();
            var10_12 /* !! */ [var5_7] = (Bitmap.Config)var12_14;
            var13_15 = cn.sharesdk.framework.loopshare.watermark.a.b;
            var7_9 = var8_10.height() * 2;
            var13_15 += var7_9;
            cn.sharesdk.framework.loopshare.watermark.a.b = var13_15;
            ++var5_7;
            continue;
            break;
        }
        var5_7 = cn.sharesdk.framework.loopshare.watermark.a.c;
        var7_9 = cn.sharesdk.framework.loopshare.watermark.a.b;
        var10_12 /* !! */  = Bitmap.Config.ARGB_8888;
        var6_8 /* !! */  = Bitmap.createBitmap((int)var5_7, (int)var7_9, (Bitmap.Config)var10_12 /* !! */ );
        var8_10 = new Canvas((Bitmap)var6_8 /* !! */ );
        var13_15 = cn.sharesdk.framework.loopshare.watermark.a.f;
        var8_10.drawColor(var13_15);
        var13_15 = 0;
        var10_12 /* !! */  = null;
        var12_14 = 0;
        var11_13 = null;
        while (true) {
            block50: {
                var14_16 = ((Object)var1_3).length;
                if (var13_15 >= var14_16) break;
                var15_17 /* !! */  = cn.sharesdk.framework.loopshare.watermark.a.d;
                var16_18 = var15_17 /* !! */ [var13_15];
                var4_6.setTextSize(var16_18);
                var15_17 /* !! */  = cn.sharesdk.framework.loopshare.watermark.a.a;
                var17_19 = var15_17 /* !! */ [var13_15];
                var12_14 += var17_19;
                if (var13_15 <= 0) break block50;
                var17_19 = var13_15 + -1;
                var14_16 = (int)var15_17 /* !! */ [var17_19];
                var12_14 += var14_16;
            }
            var15_17 /* !! */  = (float[])var1_3[var13_15];
            var17_19 = (float)false;
            var18_20 = var12_14;
            var8_10.drawText((String)var15_17 /* !! */ , 0.0f, var18_20, (Paint)var4_6);
            ++var13_15;
            continue;
            break;
        }
        try {
            var1_3 = SSDKLog.b();
        }
        catch (Throwable var0_1) {
            var1_3 = SSDKLog.b();
            var4_6 = new Object[var3_5];
            var6_8 /* !! */  = new StringBuilder();
            var6_8 /* !! */ .append("e:");
            var8_10 = var0_1.toString();
            var6_8 /* !! */ .append((String)var8_10);
            var6_8 /* !! */  = var6_8 /* !! */ .toString();
            var4_6[0] = var6_8 /* !! */ ;
            var1_3.d(var2_4, (Object[])var4_6);
            var1_3 = SSDKLog.b();
            var21_23 = new Object[var3_5];
            var4_6 = new StringBuilder();
            var4_6.append("writeImage catch: ");
            var4_6.append(var0_1);
            var0_2 = var4_6.toString();
            var21_23[0] = var0_2;
            var1_3.d(var2_4, var21_23);
            return false;
        }
        var4_6 = new Object[var3_5];
        var8_10 = new StringBuilder();
        var10_12 /* !! */  = "path:";
        var8_10.append((String)var10_12 /* !! */ );
        var8_10.append(var0);
        var8_10 = var8_10.toString();
        var4_6[0] = var8_10;
        var1_3.d(var2_4, (Object[])var4_6);
        var1_3 = new FileOutputStream(var0);
        var0 = Bitmap.CompressFormat.JPEG;
        var19_21 = cn.sharesdk.framework.loopshare.watermark.a.g;
        var6_8 /* !! */ .compress((Bitmap.CompressFormat)var0, var19_21, (OutputStream)var1_3);
        var20_22 = cn.sharesdk.framework.loopshare.watermark.a.c;
        cn.sharesdk.framework.loopshare.watermark.g.a = var20_22;
        var20_22 = cn.sharesdk.framework.loopshare.watermark.a.b;
        cn.sharesdk.framework.loopshare.watermark.g.b = var20_22;
        return var3_5;
    }
}

