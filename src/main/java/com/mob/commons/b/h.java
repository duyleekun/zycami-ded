/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.IBinder
 */
package com.mob.commons.b;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.mob.commons.b.f;
import com.mob.commons.b.f$c;
import com.mob.commons.k;

public class h
extends f {
    public h(Context context) {
        super(context);
    }

    public Intent a() {
        Intent intent = new Intent();
        String string2 = k.a(84);
        String string3 = k.a(85);
        intent.setClassName(string2, string3);
        return intent;
    }

    public f$c a(IBinder iBinder) {
        int n10;
        int n11 = 86;
        String string2 = k.a(n11);
        f$c f$c = new f$c();
        String string3 = k.a(69);
        int n12 = 0;
        String[] stringArray = new String[]{};
        Object object = this;
        f$c.b = object = this.a(string3, iBinder, string2, 1, stringArray);
        string3 = k.a(70);
        int n13 = 1;
        stringArray = new String[n13];
        stringArray[0] = object = this.b;
        object = this;
        f$c.e = object = this.a(string3, iBinder, string2, 4, stringArray);
        string3 = k.a(71);
        stringArray = new String[]{};
        object = this;
        f$c.d = object = this.a(string3, iBinder, string2, 2, stringArray);
        string3 = k.a(75);
        stringArray = new String[n13];
        stringArray[0] = object = this.b;
        int n14 = 5;
        object = this;
        f$c.c = object = this.a(string3, iBinder, string2, n14, stringArray);
        int n15 = 74;
        object = k.a(n15);
        int n16 = this.a((String)object, iBinder, string2, n10 = 3);
        if (n16 != 0) {
            n12 = n13;
        }
        f$c.a = n12;
        return f$c;
    }

    public long d() {
        return 3000L;
    }
}

