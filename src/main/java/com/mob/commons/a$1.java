/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons;

import com.mob.commons.a;
import com.mob.commons.b;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;

public final class a$1
implements Runnable {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object[] objectArray = null;
        try {
            a.l();
            int n10 = a.c();
            NLog nLog = MobLog.getInstance();
            Object object = new StringBuilder();
            Object[] objectArray2 = "====> ppNece: ";
            ((StringBuilder)object).append((String)objectArray2);
            ((StringBuilder)object).append(n10 != 0);
            object = ((StringBuilder)object).toString();
            objectArray2 = new Object[]{};
            nLog.d(object, objectArray2);
            nLog = null;
            if (n10 == 0) {
                NLog nLog2 = MobLog.getInstance();
                object = "====> Entr 1";
                objectArray2 = new Object[]{};
                nLog2.d(object, objectArray2);
                a.a(null);
                a.b(null);
                n10 = a.m();
                a.b(n10);
                a.n();
                return;
            }
            n10 = a.d();
            object = MobLog.getInstance();
            objectArray2 = new StringBuilder();
            Object[] objectArray3 = "====> isAgrPp: ";
            objectArray2.append((String)objectArray3);
            objectArray2.append(n10 != 0);
            objectArray2 = objectArray2.toString();
            objectArray3 = new Object[]{};
            ((NLog)object).d(objectArray2, objectArray3);
            if (n10 != 0) {
                Object object2 = MobLog.getInstance();
                object = "====> Entr 2";
                objectArray2 = new Object[]{};
                ((NLog)object2).d(object, objectArray2);
                object2 = Boolean.TRUE;
                a.b((Boolean)object2);
                a.a(null);
                n10 = a.m();
                a.b(n10);
                a.n();
                return;
            }
            n10 = (int)(a.j() ? 1 : 0);
            object = MobLog.getInstance();
            objectArray2 = new StringBuilder();
            objectArray3 = "====> cltStch: ";
            objectArray2.append((String)objectArray3);
            objectArray2.append(n10 != 0);
            objectArray2 = objectArray2.toString();
            objectArray3 = new Object[]{};
            ((NLog)object).d(objectArray2, objectArray3);
            if (n10 != 0) {
                Object object3 = MobLog.getInstance();
                object = "====> Entr 3";
                objectArray2 = new Object[]{};
                ((NLog)object3).d(object, objectArray2);
                object3 = a.k();
                a.b((Boolean)object3);
                a.a(null);
                n10 = a.m();
                a.b(n10);
                a.n();
            } else {
                NLog nLog3 = MobLog.getInstance();
                object = "====> Entr cltSwth=false";
                objectArray2 = new Object[]{};
                nLog3.d(object, objectArray2);
                b.am();
                b.a(null);
                n10 = 1;
                a.a(n10);
            }
            a.o();
            return;
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            objectArray = new Object[]{};
            String string2 = "Clt init error";
            nLog.e(throwable, (Object)string2, objectArray);
        }
    }
}

