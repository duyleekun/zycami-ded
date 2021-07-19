/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 */
package com.heytap.mcssdk.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.heytap.mcssdk.d;
import com.heytap.mcssdk.d.c;
import d.i.a.a.c.a;

public class b
extends c {
    public a a(Context object, int n10, Intent object2) {
        int n11 = 4103;
        if (n11 != n10 && (n11 = 4098) != n10) {
            return null;
        }
        object = this.a((Intent)object2);
        object2 = d.k();
        Object object3 = object;
        object3 = (d.i.a.a.c.b)object;
        ((d)object2).a((d.i.a.a.c.b)object3, "push_transmit", n10);
        return object;
    }

    public a a(Intent object) {
        int n10;
        Object object2;
        block27: {
            block26: {
                String string2;
                try {
                    object2 = new d.i.a.a.c.b();
                    string2 = "messageID";
                }
                catch (Exception exception) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("OnHandleIntent--");
                    String string3 = exception.getMessage();
                    ((StringBuilder)object2).append(string3);
                    com.heytap.mcssdk.f.c.b(((StringBuilder)object2).toString());
                    return null;
                }
                string2 = object.getStringExtra(string2);
                string2 = com.heytap.mcssdk.f.a.b(string2);
                ((d.i.a.a.c.b)object2).s(string2);
                string2 = "taskID";
                string2 = object.getStringExtra(string2);
                string2 = com.heytap.mcssdk.f.a.b(string2);
                ((d.i.a.a.c.b)object2).v(string2);
                string2 = "appPackage";
                string2 = object.getStringExtra(string2);
                string2 = com.heytap.mcssdk.f.a.b(string2);
                ((d.i.a.a.c.b)object2).p(string2);
                string2 = "title";
                string2 = object.getStringExtra(string2);
                string2 = com.heytap.mcssdk.f.a.b(string2);
                ((d.i.a.a.c.b)object2).w(string2);
                string2 = "content";
                string2 = object.getStringExtra(string2);
                string2 = com.heytap.mcssdk.f.a.b(string2);
                ((d.i.a.a.c.b)object2).q(string2);
                string2 = "description";
                string2 = object.getStringExtra(string2);
                string2 = com.heytap.mcssdk.f.a.b(string2);
                ((d.i.a.a.c.b)object2).r(string2);
                string2 = "notifyID";
                object = object.getStringExtra(string2);
                object = com.heytap.mcssdk.f.a.b((String)object);
                boolean bl2 = TextUtils.isEmpty((CharSequence)object);
                if (!bl2) break block26;
                n10 = 0;
                object = null;
                break block27;
            }
            n10 = Integer.parseInt((String)object);
        }
        ((d.i.a.a.c.b)object2).t(n10);
        return object2;
    }
}

