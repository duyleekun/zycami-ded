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
import com.heytap.mcssdk.d;
import d.i.a.a.c.a;
import java.util.ArrayList;
import java.util.List;

public abstract class c
implements com.heytap.mcssdk.d.d {
    public static List a(Context context, Intent intent) {
        boolean bl2;
        Object object;
        Object object2;
        if (intent == null) {
            return null;
        }
        int n10 = 4096;
        ArrayList<Object> arrayList = "type";
        arrayList = intent.getStringExtra((String)((Object)arrayList));
        arrayList = com.heytap.mcssdk.f.a.b((String)((Object)arrayList));
        try {
            n10 = Integer.parseInt((String)((Object)arrayList));
        }
        catch (Exception exception) {
            object2 = new StringBuilder();
            object = "MessageParser--getMessageByIntent--Exception:";
            ((StringBuilder)object2).append((String)object);
            arrayList = exception.getMessage();
            ((StringBuilder)object2).append((String)((Object)arrayList));
            arrayList = ((StringBuilder)object2).toString();
            com.heytap.mcssdk.f.c.e((String)((Object)arrayList));
        }
        arrayList = new ArrayList<Object>();
        ((StringBuilder)((Object)arrayList)).append("MessageParser--getMessageByIntent--type:");
        ((StringBuilder)((Object)arrayList)).append(n10);
        com.heytap.mcssdk.f.c.b(((StringBuilder)((Object)arrayList)).toString());
        arrayList = new ArrayList<Object>();
        object2 = d.k().o().iterator();
        while (bl2 = object2.hasNext()) {
            object = (com.heytap.mcssdk.d.d)object2.next();
            if (object == null || (object = object.a(context, n10, intent)) == null) continue;
            arrayList.add(object);
        }
        return arrayList;
    }

    public abstract a a(Intent var1);
}

