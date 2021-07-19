/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.authorize;

import com.mob.commons.MobProduct;
import com.mob.commons.authorize.a;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import java.util.HashMap;

public class a$2
extends Thread {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ HashMap b;
    public final /* synthetic */ MobProduct c;
    public final /* synthetic */ a d;

    public a$2(a a10, boolean bl2, HashMap hashMap, MobProduct mobProduct) {
        this.d = a10;
        this.a = bl2;
        this.b = hashMap;
        this.c = mobProduct;
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
                MobProduct mobProduct;
                Object object;
                a a10;
                boolean bl2 = this.a;
                Object object2 = this.d;
                HashMap hashMap = this.b;
                boolean bl3 = com.mob.commons.authorize.a.a((a)object2, hashMap);
                boolean bl4 = true;
                if (bl3 || (bl3 = com.mob.commons.authorize.a.b((a)(object2 = this.d)))) {
                    a10 = this.d;
                    object2 = this.b;
                    object = "duid";
                    object = ((HashMap)object2).get(object);
                    com.mob.commons.authorize.a.a(a10, (HashMap)object2, (String)object);
                    bl2 = bl4;
                }
                if (!(bl3 = com.mob.commons.authorize.a.a((a)(object2 = this.d), (HashMap)(object = this.b), mobProduct = this.c))) {
                    bl4 = bl2;
                }
                if (bl4) {
                    a10 = this.d;
                    object2 = this.b;
                    com.mob.commons.authorize.a.b(a10, (HashMap)object2);
                }
            }
            catch (Throwable throwable) {
                NLog nLog = MobLog.getInstance();
                nLog.d(throwable);
            }
            return;
        }
    }
}

