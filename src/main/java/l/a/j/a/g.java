/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package l.a.j.a;

import android.content.Context;
import androidx.appcompat.R$attr;
import l.a.j.a.e;

public class g {
    private static final int[] a;
    private static final int[] b;
    private static final int[] c;

    static {
        int n10;
        int n11;
        int n12 = 1;
        int[] nArray = new int[n12];
        nArray[0] = n11 = R$attr.colorPrimary;
        a = nArray;
        nArray = new int[n12];
        nArray[0] = n11 = R$attr.colorPrimaryDark;
        b = nArray;
        int[] nArray2 = new int[n12];
        nArray2[0] = n10 = R$attr.colorAccent;
        c = nArray2;
    }

    public static int a(Context context) {
        int[] nArray = c;
        return e.b(context, nArray);
    }

    public static int b(Context context) {
        int[] nArray = b;
        return e.b(context, nArray);
    }

    public static int c(Context context) {
        int[] nArray = a;
        return e.b(context, nArray);
    }
}

