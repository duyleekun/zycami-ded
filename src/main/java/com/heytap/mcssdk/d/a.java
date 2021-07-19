/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package com.heytap.mcssdk.d;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.d.c;

public class a
extends c {
    public d.i.a.a.c.a a(Context context, int n10, Intent intent) {
        int n11 = 4105;
        if (n11 == n10) {
            return this.a(intent);
        }
        return null;
    }

    public d.i.a.a.c.a a(Intent object) {
        String string2;
        Object object2;
        try {
            object2 = new com.heytap.mcssdk.c.a();
            string2 = "command";
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
        int n10 = Integer.parseInt(string2);
        ((com.heytap.mcssdk.c.a)object2).a(n10);
        string2 = "code";
        string2 = object.getStringExtra(string2);
        string2 = com.heytap.mcssdk.f.a.b(string2);
        n10 = Integer.parseInt(string2);
        ((com.heytap.mcssdk.c.a)object2).b(n10);
        string2 = "content";
        string2 = object.getStringExtra(string2);
        string2 = com.heytap.mcssdk.f.a.b(string2);
        ((com.heytap.mcssdk.c.a)object2).e(string2);
        string2 = "appKey";
        string2 = object.getStringExtra(string2);
        string2 = com.heytap.mcssdk.f.a.b(string2);
        ((com.heytap.mcssdk.c.a)object2).a(string2);
        string2 = "appSecret";
        string2 = object.getStringExtra(string2);
        string2 = com.heytap.mcssdk.f.a.b(string2);
        ((com.heytap.mcssdk.c.a)object2).b(string2);
        string2 = "appPackage";
        object = object.getStringExtra(string2);
        object = com.heytap.mcssdk.f.a.b((String)object);
        ((com.heytap.mcssdk.c.a)object2).f((String)object);
        object = new StringBuilder();
        string2 = "OnHandleIntent-message:";
        ((StringBuilder)object).append(string2);
        string2 = ((com.heytap.mcssdk.c.a)object2).toString();
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        com.heytap.mcssdk.f.c.b((String)object);
        return object2;
    }
}

