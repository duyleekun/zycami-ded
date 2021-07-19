/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.authorize;

import com.mob.commons.MobProduct;
import com.mob.commons.authorize.a;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import java.util.HashMap;

public class a$5
extends Thread {
    public final /* synthetic */ String a;
    public final /* synthetic */ MobProduct b;
    public final /* synthetic */ a c;

    public a$5(a a10, String string2, MobProduct mobProduct) {
        this.c = a10;
        this.a = string2;
        this.b = mobProduct;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        String string2 = com.mob.commons.authorize.a.b();
        synchronized (string2) {
            try {
                HashMap<String, String> hashMap = new HashMap<String, String>();
                Object object = "duid";
                Object object2 = this.a;
                hashMap.put((String)object, (String)object2);
                object = this.c;
                object2 = this.a;
                com.mob.commons.authorize.a.a((a)object, hashMap, (String)object2);
                object = this.c;
                object2 = this.b;
                com.mob.commons.authorize.a.a((a)object, hashMap, (MobProduct)object2);
                object = this.c;
                com.mob.commons.authorize.a.b((a)object, hashMap);
            }
            catch (Throwable throwable) {
                NLog nLog = MobLog.getInstance();
                nLog.d(throwable);
            }
            return;
        }
    }
}

