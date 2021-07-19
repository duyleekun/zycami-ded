/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.ColorStateList
 *  android.util.StateSet
 */
package cn.sharesdk.sina.weibo.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.util.StateSet;
import com.mob.tools.utils.Data;

public class a {
    public static ColorStateList a(int n10, int n11) {
        int n12 = 4;
        int[] nArray = new int[n12];
        nArray[0] = n11;
        int n13 = 1;
        nArray[n13] = n11;
        int n14 = 2;
        nArray[n14] = n11;
        n11 = 3;
        nArray[n11] = n10;
        int[][] nArrayArray = new int[n12][];
        int[] nArray2 = new int[n13];
        nArray2[0] = 16842919;
        nArrayArray[0] = nArray2;
        nArray2 = new int[n13];
        nArray2[0] = 0x10100A1;
        nArrayArray[n13] = nArray2;
        nArray2 = new int[n13];
        nArray2[0] = 16842908;
        nArrayArray[n14] = nArray2;
        nArray2 = StateSet.WILD_CARD;
        nArrayArray[n11] = nArray2;
        ColorStateList colorStateList = new ColorStateList((int[][])nArrayArray, nArray);
        return colorStateList;
    }

    public static String a(Context context, String string2) {
        Object[] objectArray;
        int n10;
        context = context.getPackageManager();
        int n11 = 64;
        try {
            context = context.getPackageInfo(string2, n11);
            string2 = null;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {}
        for (int i10 = 0; i10 < (n10 = (objectArray = context.signatures).length); ++i10) {
            if ((objectArray = (Object[])objectArray[i10].toByteArray()) == null) continue;
            return Data.MD5((byte[])objectArray);
        }
        return null;
    }

    public static byte[] a(byte[] byArray) {
        int n10;
        char[] cArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
        int n11 = (byArray.length + 2) / 3 * 4;
        byte[] byArray2 = new byte[n11];
        int n12 = 0;
        int n13 = 0;
        while (n12 < (n10 = byArray.length)) {
            n10 = (byArray[n12] & 0xFF) << 8;
            int n14 = n12 + 1;
            int n15 = byArray.length;
            int n16 = 1;
            if (n14 < n15) {
                n14 = byArray[n14] & 0xFF;
                n10 |= n14;
                n14 = n16;
            } else {
                n14 = 0;
            }
            n10 <<= 8;
            n15 = n12 + 2;
            int n17 = byArray.length;
            if (n15 < n17) {
                n15 = byArray[n15] & 0xFF;
                n10 |= n15;
            } else {
                n16 = 0;
            }
            n15 = n13 + 3;
            n17 = 64;
            float f10 = 9.0E-44f;
            n16 = n16 != 0 ? n10 & 0x3F : n17;
            byArray2[n15] = n16 = (int)((byte)cArray[n16]);
            n10 >>= 6;
            n15 = n13 + 2;
            if (n14 != 0) {
                n17 = n10 & 0x3F;
            }
            byArray2[n15] = n14 = (int)((byte)cArray[n17]);
            n14 = n13 + 1;
            n15 = (n10 >>= 6) & 0x3F;
            byArray2[n14] = n15 = (int)((byte)cArray[n15]);
            n10 >>= 6;
            n14 = n13 + 0;
            n10 &= 0x3F;
            byArray2[n14] = n10 = (int)((byte)cArray[n10]);
            n12 += 3;
            n13 += 4;
        }
        return byArray2;
    }
}

