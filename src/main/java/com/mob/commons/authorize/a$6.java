/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.authorize;

import com.mob.commons.LockAction;
import com.mob.commons.authorize.a;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.FileLocker;
import java.util.HashMap;

public class a$6
implements LockAction {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String[] c;
    public final /* synthetic */ a d;

    public a$6(a a10, boolean bl2, boolean bl3, String[] stringArray) {
        this.d = a10;
        this.a = bl2;
        this.b = bl3;
        this.c = stringArray;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean run(FileLocker object) {
        String string2 = "duid";
        try {
            void var4_14;
            boolean bl2;
            Object v10;
            String string3;
            HashMap<String, String> hashMap;
            boolean bl3 = this.a;
            if (!bl3) {
                hashMap = this.d;
                com.mob.commons.authorize.a.a((a)((Object)hashMap));
            }
            hashMap = this.d;
            if ((hashMap = com.mob.commons.authorize.a.c((a)((Object)hashMap))) == null) {
                hashMap = new HashMap<String, String>();
            }
            if ((string3 = (String)(v10 = hashMap.get(string2))) == null && (bl2 = this.b)) {
                a a10 = this.d;
                bl2 = this.a;
                bl2 = !bl2;
                String string4 = com.mob.commons.authorize.a.a(a10, bl2);
                bl2 = this.a;
                if (!bl2) {
                    hashMap.put(string2, string4);
                    a a11 = this.d;
                    com.mob.commons.authorize.a.a(a11, hashMap, false);
                }
            }
            String[] stringArray = this.c;
            stringArray[0] = var4_14;
            return false;
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.w(throwable);
        }
        return false;
    }
}

