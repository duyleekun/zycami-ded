/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.heytap.mcssdk.e;

import android.content.Context;
import com.heytap.mcssdk.d;
import com.heytap.mcssdk.e.a$1;
import com.heytap.mcssdk.e.c;
import com.heytap.mcssdk.f.f;
import com.heytap.mcssdk.f.g;
import d.i.a.a.b.b;

public class a
implements c {
    /*
     * Enabled aggressive block sorting
     */
    private void a(com.heytap.mcssdk.c.a object, d object2) {
        int n10;
        Object object3;
        block12: {
            block10: {
                block11: {
                    block9: {
                        if (object != null) break block9;
                        object = "message is null , please check param of parseCommandMessage(2)";
                        break block10;
                    }
                    if (object2 != null) break block11;
                    object = "pushService is null , please check param of parseCommandMessage(2)";
                    break block10;
                }
                object3 = ((d)object2).q();
                if (object3 != null) break block12;
                object = "pushService.getPushCallback() is null , please check param of parseCommandMessage(2)";
            }
            com.heytap.mcssdk.f.c.e((String)object);
            return;
        }
        int n11 = ((com.heytap.mcssdk.c.a)object).e();
        if (n11 != (n10 = 12289)) {
            n10 = 12290;
            if (n11 == n10) {
                object2 = ((d)object2).q();
                int n12 = ((com.heytap.mcssdk.c.a)object).g();
                object2.onUnRegister(n12);
                return;
            }
            n10 = 12298;
            if (n11 == n10) {
                object2 = ((d)object2).q();
                n11 = ((com.heytap.mcssdk.c.a)object).g();
                object = ((com.heytap.mcssdk.c.a)object).f();
                object2.onSetPushTime(n11, (String)object);
                return;
            }
            n10 = 12306;
            if (n11 == n10) {
                object2 = ((d)object2).q();
                n11 = ((com.heytap.mcssdk.c.a)object).g();
                object = ((com.heytap.mcssdk.c.a)object).f();
                int n13 = g.a((String)object);
                object2.onGetPushStatus(n11, n13);
                return;
            }
            n10 = 12309;
            if (n11 != n10) {
                return;
            }
            object2 = ((d)object2).q();
            n11 = ((com.heytap.mcssdk.c.a)object).g();
            object = ((com.heytap.mcssdk.c.a)object).f();
            int n14 = g.a((String)object);
            object2.onGetNotificationStatus(n11, n14);
            return;
        }
        n11 = ((com.heytap.mcssdk.c.a)object).g();
        if (n11 == 0) {
            object3 = ((com.heytap.mcssdk.c.a)object).f();
            ((d)object2).a((String)object3);
        }
        object2 = ((d)object2).q();
        n11 = ((com.heytap.mcssdk.c.a)object).g();
        object = ((com.heytap.mcssdk.c.a)object).f();
        object2.onRegister(n11, (String)object);
    }

    public static /* synthetic */ void a(a a10, com.heytap.mcssdk.c.a a11, d d10) {
        a10.a(a11, d10);
    }

    public void a(Context object, d.i.a.a.c.a a10, b object2) {
        int n10;
        if (a10 == null) {
            return;
        }
        int n11 = a10.getType();
        if (n11 == (n10 = 4105)) {
            a10 = (com.heytap.mcssdk.c.a)a10;
            object = new StringBuilder();
            ((StringBuilder)object).append("mcssdk-CallBackResultProcessor:");
            object2 = ((com.heytap.mcssdk.c.a)a10).toString();
            ((StringBuilder)object).append((String)object2);
            com.heytap.mcssdk.f.c.b(((StringBuilder)object).toString());
            object = new a$1(this, (com.heytap.mcssdk.c.a)a10);
            f.b((Runnable)object);
        }
    }
}

