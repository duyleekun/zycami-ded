/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.util.Pair
 */
package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.gd;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.w;
import java.util.ArrayList;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class o {
    private static ArrayList a;
    private static final Map a;

    static {
        Cloneable cloneable;
        a = cloneable = new Cloneable();
        cloneable = new Cloneable();
        a = cloneable;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Context object, int n10, String string2) {
        Map map = a;
        synchronized (map) {
            Object object2 = map.keySet();
            object2 = object2.iterator();
            while (true) {
                boolean bl2;
                if (!(bl2 = object2.hasNext())) {
                    object = a;
                    object.clear();
                    return;
                }
                Object object3 = object2.next();
                object3 = (String)object3;
                Object object4 = a;
                object4 = object4.get(object3);
                object4 = (byte[])object4;
                o.a((Context)object, object3, (byte[])object4, n10, string2);
            }
        }
    }

    public static void a(Context context, String string2, byte[] byArray, int n10, String string3) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(string2);
        intent.putExtra("mipush_payload", byArray);
        intent.putExtra("mipush_error_code", n10);
        intent.putExtra("mipush_error_msg", string3);
        string2 = w.a(string2);
        context.sendBroadcast(intent, string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(XMPushService xMPushService) {
        Object object;
        try {
            Map map = a;
            synchronized (map) {
                object = map.keySet();
                object = object.iterator();
            }
        }
        catch (gd gd2) {
            b.a(gd2);
            int n10 = 10;
            xMPushService.a(n10, (Exception)gd2);
            return;
        }
        {
            while (true) {
                boolean bl2;
                if (!(bl2 = object.hasNext())) {
                    object = a;
                    object.clear();
                    return;
                }
                Object object2 = object.next();
                object2 = (String)object2;
                Object object3 = a;
                object3 = object3.get(object2);
                object3 = (byte[])object3;
                w.a(xMPushService, object2, (byte[])object3);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(String string2, byte[] byArray) {
        Map map = a;
        synchronized (map) {
            map.put(string2, byArray);
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void b(XMPushService xMPushService) {
        Object object;
        Object object2;
        Object object3;
        try {
            object3 = a;
            synchronized (object3) {
                object2 = a;
                object = new ArrayList();
                a = object;
            }
        }
        catch (gd gd2) {
            b.a(gd2);
            int n10 = 10;
            xMPushService.a(n10, (Exception)gd2);
            return;
        }
        {
            boolean bl2;
            object3 = ((ArrayList)object2).iterator();
            while (bl2 = object3.hasNext()) {
                object2 = object3.next();
                object2 = (Pair)object2;
                object = ((Pair)object2).first;
                object = (String)object;
                object2 = ((Pair)object2).second;
                object2 = (byte[])object2;
                w.a(xMPushService, (String)object, (byte[])object2);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void b(String object, byte[] byArray) {
        ArrayList arrayList = a;
        synchronized (arrayList) {
            ArrayList arrayList2 = a;
            Pair pair = new Pair(object, (Object)byArray);
            arrayList2.add(pair);
            object = a;
            int n10 = ((ArrayList)object).size();
            int n11 = 50;
            if (n10 > n11) {
                object = a;
                n11 = 0;
                byArray = null;
                ((ArrayList)object).remove(0);
            }
            return;
        }
    }
}

