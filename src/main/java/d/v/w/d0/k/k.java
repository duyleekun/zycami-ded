/*
 * Decompiled with CFR 0.151.
 */
package d.v.w.d0.k;

import com.android.billingclient.api.SkuDetails;
import d.v.w.d0.k.e;

public abstract class k
implements d.v.w.c0.e {
    public static e i(String string2, String string3, String string4, long l10, String string5, long l11, String string6, SkuDetails skuDetails) {
        return k.j(string2, string3, string4, l10, string5, l11, string6, "", skuDetails);
    }

    public static e j(String string2, String string3, String string4, long l10, String string5, long l11, String string6, String string7, SkuDetails skuDetails) {
        e e10 = new e(string2, string3, string4, l10, string5, l11, string6, string7, skuDetails);
        return e10;
    }

    public abstract SkuDetails k();
}

