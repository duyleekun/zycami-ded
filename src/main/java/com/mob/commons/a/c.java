/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Message
 */
package com.mob.commons.a;

import android.os.Message;
import com.mob.commons.a.d;
import com.mob.commons.b;
import com.mob.commons.e;
import com.mob.commons.i;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class c
extends d {
    private long a;
    private HashMap b;

    private void h() {
        long l10;
        boolean bl2;
        HashMap hashMap = this.b;
        if (hashMap == null) {
            this.b = hashMap = new HashMap();
        }
        hashMap = this.b.entrySet().iterator();
        while (bl2 = hashMap.hasNext()) {
            long l11;
            long l12;
            long l13;
            Object object = (Map.Entry)hashMap.next();
            if (object == null || !(bl2 = (l13 = (l12 = ((Long)(object = (Long)object.getKey())).longValue()) - (l11 = this.a)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) continue;
            this.i();
        }
        long l14 = com.mob.commons.b.a();
        long l15 = this.a;
        Object object = this.b;
        Object object2 = l15;
        Object[] objectArray = Long.valueOf(l14 -= l15);
        ((HashMap)object).put(object2, objectArray);
        i.b(this.b);
        object2 = MobLog.getInstance();
        int n10 = 2;
        objectArray = new Object[n10];
        objectArray[0] = "AtClt";
        object = new StringBuilder();
        ((StringBuilder)object).append("Cache AT: {\"launchAt: ");
        long l16 = this.a;
        ((StringBuilder)object).append(l16);
        ((StringBuilder)object).append(", \"duration\": ");
        ((StringBuilder)object).append(l14);
        String string2 = "}";
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        int n11 = 1;
        objectArray[n11] = object;
        object = "[%s] %s";
        ((NLog)object2).d(object, objectArray);
        l15 = i.s();
        long l17 = com.mob.commons.b.Y();
        long l18 = 1000L;
        long l19 = l14 - (l17 *= l18);
        long l20 = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
        if (l20 >= 0 && (l20 = (l10 = l15 - (l14 = com.mob.commons.b.a())) == 0L ? 0 : (l10 < 0L ? -1 : 1)) <= 0) {
            this.i();
        }
        l14 = com.mob.commons.b.W() * l18;
        this.a(n11, l14);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void i() {
        long l10;
        Object object;
        Object object2;
        String string2 = "AtClt";
        String string3 = "[%s] %s";
        int n10 = 1;
        int n11 = 2;
        try {
            Object[] objectArray;
            Object object3;
            boolean bl2;
            object2 = new HashMap();
            object = this.b;
            object = ((HashMap)object).entrySet();
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                Object object4 = object.next();
                if ((object4 = (Map.Entry)object4) == null) continue;
                object3 = "launchAt";
                objectArray = object4.getKey();
                ((HashMap)object2).put(object3, objectArray);
                object3 = "duration";
                object4 = object4.getValue();
                ((HashMap)object2).put(object3, object4);
            }
            long l11 = com.mob.commons.b.a();
            object3 = new HashMap();
            objectArray = "type";
            Object object5 = "APP_RUNTIMES_STATS";
            ((HashMap)object3).put(objectArray, object5);
            objectArray = "data";
            ((HashMap)object3).put(objectArray, object2);
            objectArray = "datetime";
            object5 = l11;
            ((HashMap)object3).put(objectArray, object5);
            objectArray = com.mob.commons.c.a();
            objectArray.a(l11, (HashMap)object3);
            object3 = MobLog.getInstance();
            objectArray = new Object[n11];
            objectArray[0] = string2;
            object5 = new StringBuilder();
            Object object6 = "Push AT: ";
            ((StringBuilder)object5).append((String)object6);
            object6 = new Hashon();
            object2 = ((Hashon)object6).fromHashMap((HashMap)object2);
            ((StringBuilder)object5).append((String)object2);
            objectArray[n10] = object2 = ((StringBuilder)object5).toString();
            ((NLog)object3).d(string3, objectArray);
            long l12 = com.mob.commons.b.Y();
            l10 = 1000L;
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            Object[] objectArray = new Object[n11];
            objectArray[0] = string2;
            string2 = "Push error";
            objectArray[n10] = string2;
            ((NLog)object).w(throwable, (Object)string3, objectArray);
            return;
        }
        {
            i.h(l11 += (l12 *= l10));
            object2 = this.b;
            if (object2 != null) {
                ((HashMap)object2).clear();
            }
            object2 = null;
            i.b(null);
            return;
        }
    }

    public File a() {
        return e.a("comm/locks/.at_lock");
    }

    public void a(Message message) {
        long l10;
        long l11;
        long l12;
        int n10 = message.what;
        int n11 = 1;
        if (n10 == n11 && (n10 = (int)((l12 = (l11 = com.mob.commons.b.W()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) > 0) {
            this.h();
        }
    }

    public boolean b_() {
        long l10;
        long l11 = com.mob.commons.b.W();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public void d() {
        HashMap hashMap;
        long l10;
        this.a = l10 = com.mob.commons.b.a();
        this.b = hashMap = i.t();
        this.b(1);
    }
}

