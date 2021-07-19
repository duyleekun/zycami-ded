/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 */
package com.xiaomi.push;

import android.content.Context;
import android.net.Uri;
import com.xiaomi.push.ay;
import com.xiaomi.push.az;
import com.xiaomi.push.dc;
import java.net.URL;
import java.util.List;

public class dd$a
extends dc {
    public dd$a() {
        super(1);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String a(Context context, String string2, List object) {
        boolean bl2;
        if (object == null) {
            object = new URL(string2);
            return az.a(context, object);
        }
        string2 = Uri.parse((String)string2).buildUpon();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (ay)object.next();
            String string3 = object2.a();
            object2 = object2.b();
            string2.appendQueryParameter(string3, (String)object2);
        }
        string2 = string2.toString();
        object = new URL(string2);
        return az.a(context, object);
    }
}

