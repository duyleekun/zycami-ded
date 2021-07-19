/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ah;
import com.xiaomi.push.g;
import com.xiaomi.push.g$a;
import com.xiaomi.push.ii;
import com.xiaomi.push.ix;
import com.xiaomi.push.jb;
import com.xiaomi.push.jc;
import com.xiaomi.push.jd;
import com.xiaomi.push.je$a;
import com.xiaomi.push.jo$a;

public class iw {
    public static short a(Context context, ii object) {
        object = ((ii)object).b;
        object = g.a(context, (String)object);
        int n10 = ((g$a)((Object)object)).a();
        int n11 = 0;
        n10 += 0;
        int n12 = ah.b(context);
        n12 = n12 != 0 ? 4 : 0;
        n10 += n12;
        boolean bl2 = ah.a(context);
        if (bl2) {
            n11 = 8;
        }
        return (short)(n10 + n11);
    }

    public static void a(ix serializable, byte[] byArray) {
        if (byArray != null) {
            int n10 = byArray.length;
            boolean bl2 = true;
            jo$a jo$a = new jo$a(bl2, bl2, n10);
            jb jb2 = new jb(jo$a);
            jb2.a((ix)serializable, byArray);
            return;
        }
        serializable = new jc("the message byte is empty.");
        throw serializable;
    }

    public static byte[] a(ix ix2) {
        je$a je$a;
        if (ix2 == null) {
            return null;
        }
        try {
            je$a = new je$a();
        }
        catch (jc jc2) {
            b.a("convertThriftObjectToBytes catch TException.", (Throwable)jc2);
            return null;
        }
        jd jd2 = new jd(je$a);
        return jd2.a(ix2);
    }
}

