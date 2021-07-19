/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Size
 */
package d.v.c.u1;

import android.content.Context;
import android.util.Size;
import com.zhiyun.common.util.Windows;
import com.zhiyun.editorinterface.EditConfig$a;
import d.v.e.l.h2;
import d.v.j.g.b0;

public class j {
    public static Size a(Context context, int n10, String string2) {
        context = Windows.o(context);
        int n11 = context.getWidth();
        int n12 = b0.l(string2);
        float[] fArray = EditConfig$a.k;
        float f10 = fArray[n12];
        if (n12 != 0) {
            float f11 = (float)n11 / f10;
            n10 = (int)f11;
        } else {
            float f12 = (float)n10 * f10;
            n11 = (int)f12;
        }
        string2 = new Size(n11, n10);
        return string2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static Size b(Context var0, int var1_1, String var2_2) {
        block2: {
            block3: {
                var0 /* !! */  = Windows.o(var0 /* !! */ );
                var3_3 = var0 /* !! */ .getWidth();
                var4_4 = var3_3;
                var6_5 = 0.75 * var4_4;
                var8_6 = 28.0f;
                var9_7 = h2.b(var8_6);
                var6_5 -= var9_7;
                var11_8 = h2.b(var8_6);
                var9_7 = var11_8;
                var12_9 = (int)(var6_5 -= var9_7);
                var4_4 *= 0.94;
                var9_7 = h2.b(var8_6);
                var4_4 -= var9_7;
                var13_10 = h2.b(var8_6);
                var14_11 = var13_10;
                var16_12 = (int)(var4_4 -= var14_11);
                var17_13 = b0.l(var2_2);
                var18_14 = -1;
                var19_15 = 0.0f / 0.0f;
                if (var17_13 == var18_14) break block2;
                var0 /* !! */  = (Context)EditConfig$a.k;
                var20_16 = var0 /* !! */ [var17_13];
                if (var17_13 == 0) break block3;
                var21_17 = var1_1;
                var23_18 = 0.37;
                var1_1 = (int)(var21_17 *= var23_18);
                var25_19 = (float)var1_1 * 16.0f;
                var18_14 = 0x41100000;
                var19_15 = 9.0f;
                var17_13 = (int)(var25_19 /= var19_15);
                if (var17_13 <= var16_12) ** GOTO lbl-1000
                var26_21 = (float)var16_12 / var20_16;
                var1_1 = (int)var26_21;
                var3_3 = var16_12;
                break block2;
            }
            var25_20 = (float)var1_1 * var20_16;
            var17_13 = (int)var25_20;
            if (var17_13 > var12_9) {
                var26_22 = (float)var12_9 / var20_16;
                var1_1 = (int)var26_22;
                var3_3 = var12_9;
            } else lbl-1000:
            // 2 sources

            {
                var3_3 = var17_13;
            }
        }
        var2_2 = new Size(var3_3, var1_1);
        return var2_2;
    }
}

