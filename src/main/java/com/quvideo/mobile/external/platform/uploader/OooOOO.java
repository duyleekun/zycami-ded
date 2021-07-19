/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.quvideo.mobile.external.platform.uploader;

import android.content.Context;
import android.text.TextUtils;
import com.quvideo.mobile.external.platform.uploader.OooO;
import com.quvideo.mobile.external.platform.uploader.OooO00o;
import com.quvideo.mobile.external.platform.uploader.OooO0O0;
import com.quvideo.mobile.external.platform.uploader.OooOOO$a;
import com.quvideo.mobile.external.platform.uploader.OooOOO$b;
import com.quvideo.mobile.external.platform.uploader.OooOo00;
import d.o.a.a.b.c.d;

public class OooOOO {
    private static volatile boolean OooO00o = false;

    public static void OooO00o(Context context, com.quvideo.mobile.external.platform.uploader.listener.OooO00o oooO00o) {
        OooOo00.a().d(context, oooO00o);
    }

    public static void OooO00o(String string2) {
        OooOo00.a().m(string2);
    }

    public static /* synthetic */ void OooO00o(String string2, OooO oooO) {
        OooOOO.OooO0OO(string2, oooO);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static OooOOO$b OooO0O0(String string2, OooO object) {
        int n10;
        OooOOO$b oooOOO$b;
        block9: {
            boolean bl2;
            block7: {
                block8: {
                    oooOOO$b = new OooOOO$b(null);
                    n10 = ((OooO)object).OooO00o();
                    OooOOO$b.b(oooOOO$b, n10);
                    n10 = OooOOO$b.a(oooOOO$b);
                    if (n10 != 0) {
                        return oooOOO$b;
                    }
                    object = object.OooO0oO.OooO00o;
                    n10 = 2007;
                    if (object == null) {
                        OooOOO$b.b(oooOOO$b, n10);
                        return oooOOO$b;
                    }
                    String string3 = "ali";
                    boolean bl3 = ((String)object).equals(string3);
                    if (!bl3) break block8;
                    bl2 = OooO00o;
                    if (bl2) break block7;
                    object = OooO0O0.class;
                    try {
                        object = ((Class)object).getSimpleName();
                        bl2 = TextUtils.isEmpty((CharSequence)object) ^ true;
                        OooO00o = bl2;
                        break block7;
                    }
                    catch (Throwable throwable) {}
                }
                string2 = "aws";
                boolean bl4 = ((String)object).equals(string2);
                if (bl4) {
                    return oooOOO$b;
                }
                break block9;
            }
            if (bl2 = OooO00o) {
                object = new OooO0O0(string2);
                OooOOO$b.c(oooOOO$b, (OooO00o)object);
                return oooOOO$b;
            }
        }
        OooOOO$b.b(oooOOO$b, n10);
        return oooOOO$b;
    }

    private static void OooO0OO(String string2, OooO object) {
        Object object2 = OooOOO.OooO0O0(string2, (OooO)object);
        int n10 = OooOOO$b.a((OooOOO$b)object2);
        if (n10 != 0) {
            object = ((OooO)object).OooO0oo;
            if (object != null) {
                int n11 = OooOOO$b.a((OooOOO$b)object2);
                String string3 = "create upload fail";
                object.OooO00o(string2, n11, string3);
            }
            return;
        }
        OooOo00 oooOo00 = OooOo00.a();
        object2 = OooOOO$b.d((OooOOO$b)object2);
        oooOo00.h(string2, (OooO)object, (OooO00o)object2);
    }

    public static void OooO0Oo(String string2, OooO object) {
        Object object2 = OooOo00.a();
        int n10 = ((OooOo00)object2).c;
        if (n10 == 0) {
            object = ((OooO)object).OooO0oo;
            if (object != null) {
                n10 = 2013;
                String string3 = "upload not init fail";
                object.OooO00o(string2, n10, string3);
            }
            return;
        }
        d.e(string2, (OooO)object);
        object2 = ((OooO)object).OooO0oO;
        if (object2 == null) {
            object2 = OooOo00.a();
            ((OooOo00)object2).f(string2, (OooO)object);
        }
        if ((object2 = ((OooO)object).OooO0oO) != null) {
            OooOOO.OooO0OO(string2, (OooO)object);
            return;
        }
        object2 = ((OooO)object).OooO00o;
        boolean bl2 = ((OooO)object).OooO0Oo;
        boolean bl3 = ((OooO)object).OooO0o0;
        String string4 = ((OooO)object).OooO0o;
        OooOOO$a oooOOO$a = new OooOOO$a((OooO)object, string2);
        OooOo00.i((String)object2, bl2, bl3, string4, oooOOO$a);
    }
}

