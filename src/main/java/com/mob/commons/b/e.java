/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.IBinder
 *  android.text.TextUtils
 */
package com.mob.commons.b;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.mob.commons.b.f;
import com.mob.commons.b.f$c;
import com.mob.commons.k;

public class e
extends f {
    public e(Context context) {
        super(context);
    }

    public Intent a() {
        String string2 = k.a(80);
        Intent intent = new Intent(string2);
        string2 = k.a(81);
        intent.setPackage(string2);
        return intent;
    }

    public f$c a(IBinder iBinder) {
        boolean bl2;
        String string2 = k.a(82);
        f$c f$c = new f$c();
        String string3 = k.a(69);
        String[] stringArray = new String[]{};
        Object object = this;
        f$c.b = object = this.a(string3, iBinder, string2, 1, stringArray);
        object = k.a(83);
        this.a((String)object, iBinder, string2, 2);
        f$c.a = bl2 = TextUtils.isEmpty((CharSequence)f$c.b) ^ true;
        return f$c;
    }

    public String b() {
        synchronized (this) {
            String string2 = this.i();
            return string2;
        }
    }
}

