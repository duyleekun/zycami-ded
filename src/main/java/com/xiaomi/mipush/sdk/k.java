/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.av;
import com.xiaomi.mipush.sdk.d;
import com.xiaomi.mipush.sdk.k$a;
import com.xiaomi.mipush.sdk.l;
import com.xiaomi.push.hr;
import java.util.HashMap;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class k {
    private static HashMap a;

    static {
        Object object;
        a = object = new Object();
        object = d.a;
        String string2 = "newInstance";
        k$a k$a = new k$a("com.xiaomi.assemble.control.HmsPushManager", string2);
        k.a(object, k$a);
        object = d.b;
        k$a = new k$a("com.xiaomi.assemble.control.FCMPushManager", string2);
        k.a(object, k$a);
        object = d.c;
        k$a = new k$a("com.xiaomi.assemble.control.COSPushManager", string2);
        k.a(object, k$a);
        object = d.d;
        k$a = new k$a("com.xiaomi.assemble.control.FTOSPushManager", string2);
        k.a(object, k$a);
    }

    public static av a(d enum_) {
        int[] nArray = l.a;
        int n10 = enum_.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11) {
                        n10 = 0;
                        enum_ = null;
                    } else {
                        enum_ = av.f;
                    }
                } else {
                    enum_ = av.e;
                }
            } else {
                enum_ = av.d;
            }
        } else {
            enum_ = av.c;
        }
        return enum_;
    }

    public static k$a a(d d10) {
        return (k$a)a.get((Object)d10);
    }

    public static hr a(d d10) {
        return hr.ao;
    }

    private static void a(d d10, k$a k$a) {
        if (k$a != null) {
            HashMap hashMap = a;
            hashMap.put(d10, k$a);
        }
    }
}

