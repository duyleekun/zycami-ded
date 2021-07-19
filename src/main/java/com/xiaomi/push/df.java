/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dg;
import com.xiaomi.push.fa;
import com.xiaomi.push.fb;
import com.xiaomi.push.fg;
import com.xiaomi.push.gx;
import com.xiaomi.push.hm;
import com.xiaomi.push.hw;
import com.xiaomi.push.id;
import com.xiaomi.push.ig;
import com.xiaomi.push.ih;
import com.xiaomi.push.ii;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import com.xiaomi.push.jc;

public class df {
    public static int a(Context context, int n10) {
        int n11 = -1;
        int n12 = gx.a(context);
        if (n11 == n12) {
            return n11;
        }
        n12 = n12 == 0 ? 13 : 11;
        return n10 * n12 / 10;
    }

    public static int a(hm hm2) {
        return fa.a(hm2.a());
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int a(ix object, hm hm2) {
        void var1_13;
        Object object2 = dg.a;
        int n10 = var1_13.ordinal();
        int n11 = object2[n10];
        n10 = -1;
        switch (n11) {
            default: {
                return n10;
            }
            case 12: {
                int n12 = fa.a(var1_13.a());
                if (object == null) return n12;
                n11 = object instanceof ih;
                if (n11 != 0) {
                    try {
                        ih ih2 = (ih)object;
                        String string2 = ih2.a();
                        n11 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
                        if (n11 != 0) return n12;
                        n11 = fg.a(string2);
                        if (n11 == n10) return n12;
                        n12 = fg.a(string2);
                        return n12;
                    }
                    catch (Exception exception) {
                        String string3 = "PERF_ERROR : parse Command type error";
                        b.d(string3);
                    }
                    return n12;
                }
                n11 = object instanceof ig;
                if (n11 == 0) return n12;
                {
                    ig ig2 = (ig)object;
                    String string4 = ig2.a();
                    n11 = (int)(TextUtils.isEmpty((CharSequence)string4) ? 1 : 0);
                    if (n11 != 0) return n12;
                    n11 = fg.a(string4);
                    if (n11 == n10) return n12;
                    int n13 = fg.a(string4);
                    return n13;
                }
            }
            case 11: {
                int n12 = fa.a(var1_13.a());
                if (object == null) return n12;
                n11 = object instanceof id;
                if (n11 != 0) {
                    try {
                        id id2 = (id)object;
                        String string5 = id2.d;
                        n11 = (int)(TextUtils.isEmpty((CharSequence)string5) ? 1 : 0);
                        if (n11 != 0) return n12;
                        object2 = (Object)fa.a(string5);
                        n11 = fa.a((Enum)object2);
                        if (n11 == n10) return n12;
                        hw hw2 = fa.a(string5);
                        n12 = fa.a(hw2);
                        return n12;
                    }
                    catch (Exception exception) {
                        n10 = n12;
                        String string6 = "PERF_ERROR : parse Notification type error";
                        b.d(string6);
                        return n10;
                    }
                }
                n11 = object instanceof il;
                if (n11 == 0) return n12;
                {
                    hw hw3;
                    boolean bl2;
                    il il2 = (il)object;
                    String string7 = il2.d;
                    n11 = (int)(TextUtils.isEmpty((CharSequence)string7) ? 1 : 0);
                    if (n11 != 0) return n12;
                    object2 = (Object)fa.a(string7);
                    n11 = fa.a((Enum)object2);
                    if (n11 != n10) {
                        object2 = (Object)fa.a(string7);
                        n12 = fa.a((Enum)object2);
                    }
                    if (!(bl2 = ((Enum)(object2 = (Object)((Object)hw.B))).equals((Object)(hw3 = fa.a(string7))))) return n12;
                    return n10;
                }
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
        }
        int n14 = var1_13.a();
        return fa.a(n14);
    }

    public static void a(String string2, Context context, int n10, int n11) {
        if (n10 > 0 && n11 > 0) {
            n11 = df.a(context, n11);
            Object object = hw.B;
            int n12 = fa.a(object);
            if (n10 != n12) {
                context = context.getApplicationContext();
                object = fb.a(context);
                long l10 = 1L;
                long l11 = n11;
                ((fb)object).a(string2, n10, l10, l11);
            }
        }
    }

    public static void a(String string2, Context context, ii object, int n10) {
        hm hm2;
        if (context != null && object != null && (hm2 = ((ii)object).a()) != null) {
            int n11 = df.a(hm2);
            if (n10 <= 0) {
                int n12;
                n10 = (object = (Object)iw.a((ix)object)) != null ? (n12 = ((Object)object).length) : 0;
            }
            df.a(string2, context, n11, n10);
        }
    }

    public static void a(String string2, Context context, ix ix2, hm hm2, int n10) {
        int n11 = df.a(ix2, hm2);
        df.a(string2, context, n11, n10);
    }

    public static void a(String string2, Context context, byte[] byArray) {
        int n10;
        if (context != null && byArray != null && (n10 = byArray.length) > 0) {
            ii ii2 = new ii();
            iw.a(ii2, byArray);
            int n11 = byArray.length;
            try {
                df.a(string2, context, ii2, n11);
            }
            catch (jc jc2) {
                string2 = "fail to convert bytes to container";
                b.a(string2);
            }
        }
    }
}

