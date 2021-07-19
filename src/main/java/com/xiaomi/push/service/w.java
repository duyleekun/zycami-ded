/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Messenger
 *  android.text.TextUtils
 */
package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.df;
import com.xiaomi.push.fl;
import com.xiaomi.push.fs;
import com.xiaomi.push.gd;
import com.xiaomi.push.gj;
import com.xiaomi.push.hm;
import com.xiaomi.push.hz;
import com.xiaomi.push.ib;
import com.xiaomi.push.ii;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import com.xiaomi.push.jc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
import com.xiaomi.push.service.ap$b;
import com.xiaomi.push.service.bg;
import com.xiaomi.push.service.k;
import com.xiaomi.push.service.l;
import com.xiaomi.push.service.o;
import com.xiaomi.push.service.x;
import com.xiaomi.push.service.y;
import com.xiaomi.push.service.z;
import java.nio.ByteBuffer;

public final class w {
    public static fl a(XMPushService xMPushService, byte[] object) {
        ii ii2 = new ii();
        try {
            iw.a(ii2, object);
            object = l.a((Context)xMPushService);
        }
        catch (jc jc2) {
            b.a(jc2);
            return null;
        }
        return w.a((k)object, (Context)xMPushService, ii2);
    }

    public static fl a(k object, Context object2, ii object3) {
        int n10;
        try {
            object2 = new fl();
            n10 = 5;
        }
        catch (NullPointerException nullPointerException) {
            b.a(nullPointerException);
            return null;
        }
        ((fl)object2).a(n10);
        Object object4 = ((k)object).a;
        ((fl)object2).c((String)object4);
        object4 = w.a(object3);
        ((fl)object2).b((String)object4);
        object4 = "SECMSG";
        Object object5 = "message";
        ((fl)object2).a((String)object4, (String)object5);
        object4 = ((k)object).a;
        object5 = object3.a;
        int n11 = 0;
        String string2 = null;
        String string3 = "@";
        int s10 = ((String)object4).indexOf(string3);
        string2 = ((String)object4).substring(0, s10);
        ((ib)object5).a = string2;
        object5 = object3.a;
        string2 = "/";
        n11 = ((String)object4).indexOf(string2);
        short s11 = 1;
        n11 += s11;
        object4 = ((String)object4).substring(n11);
        ((ib)object5).c = object4;
        object4 = iw.a(object3);
        object = ((k)object).c;
        ((fl)object2).a((byte[])object4, (String)object);
        ((fl)object2).a(s11);
        object = new StringBuilder();
        object4 = "try send mi push message. packagename:";
        ((StringBuilder)object).append((String)object4);
        object4 = object3.b;
        ((StringBuilder)object).append((String)object4);
        object4 = " action:";
        ((StringBuilder)object).append((String)object4);
        object3 = object3.a;
        ((StringBuilder)object).append(object3);
        object = ((StringBuilder)object).toString();
        b.a((String)object);
        return object2;
    }

    public static ii a(String string2, String string3) {
        il il2 = new il();
        il2.b(string3);
        il2.c("package uninstalled");
        Object object = gj.i();
        il2.a((String)object);
        il2.a(false);
        object = hm.i;
        return w.a(string2, string3, il2, (hm)((Object)object));
    }

    public static ii a(String string2, String string3, ix object, hm hm2) {
        object = iw.a((ix)object);
        ii ii2 = new ii();
        ib ib2 = new ib();
        ib2.a = 5;
        ib2.a = "fakeid";
        ii2.a(ib2);
        object = ByteBuffer.wrap((byte[])object);
        ii2.a((ByteBuffer)object);
        ii2.a(hm2);
        ii2.b(true);
        ii2.b(string2);
        ii2.a(false);
        ii2.a(string3);
        return ii2;
    }

    private static String a(ii ii2) {
        String string2;
        boolean bl2;
        Object object = ii2.a;
        if (object != null && (object = ((hz)object).b) != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = (String)object.get(string2 = "ext_traffic_source_pkg"))))) {
            return object;
        }
        return ii2.b;
    }

    public static String a(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(".permission.MIPUSH_RECEIVE");
        return stringBuilder.toString();
    }

    public static void a(XMPushService xMPushService) {
        k k10 = l.a(xMPushService.getApplicationContext());
        if (k10 != null) {
            x x10;
            Object object = l.a(xMPushService.getApplicationContext()).a(xMPushService);
            w.a(xMPushService, (ap$b)object);
            ap.a().a((ap$b)object);
            bg bg2 = bg.a((Context)xMPushService);
            long l10 = 172800L;
            String string2 = "GAID";
            object = x10;
            x10 = new x(string2, l10, xMPushService, k10);
            bg2.a(x10);
            int n10 = 172800;
            w.a(xMPushService, k10, n10);
        }
    }

    public static void a(XMPushService object, ii ii2) {
        Object object2 = ii2.b();
        Object object3 = object.getApplicationContext();
        int n10 = -1;
        df.a((String)object2, object3, ii2, n10);
        object2 = ((XMPushService)object).a();
        if (object2 != null) {
            boolean bl2 = ((fs)object2).a();
            if (bl2) {
                object3 = l.a((Context)object);
                if ((object = w.a((k)object3, (Context)object, ii2)) != null) {
                    ((fs)object2).b((fl)object);
                }
                return;
            }
            object = new gd("Don't support XMPP connection.");
            throw object;
        }
        object = new gd("try send msg while connection is null.");
        throw object;
    }

    public static void a(XMPushService xMPushService, ap$b ap$b) {
        ap$b.a((Messenger)null);
        z z10 = new z(xMPushService);
        ap$b.a(z10);
    }

    private static void a(XMPushService xMPushService, k k10, int n10) {
        bg bg2 = bg.a((Context)xMPushService);
        long l10 = n10;
        y y10 = new y("MSAID", l10, xMPushService, k10);
        bg2.a(y10);
    }

    public static void a(XMPushService object, String string2, byte[] byArray) {
        Object object2 = object.getApplicationContext();
        df.a(string2, (Context)object2, byArray);
        object2 = ((XMPushService)object).a();
        if (object2 != null) {
            boolean bl2 = ((fs)object2).a();
            if (bl2) {
                fl fl2 = w.a((XMPushService)object, byArray);
                if (fl2 != null) {
                    ((fs)object2).b(fl2);
                    return;
                }
                o.a((Context)object, string2, byArray, 70000003, "not a valid message");
                return;
            }
            object = new gd("Don't support XMPP connection.");
            throw object;
        }
        object = new gd("try send msg while connection is null.");
        throw object;
    }
}

