/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.os.IBinder
 */
package com.mob.commons.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.mob.commons.b.f;
import com.mob.commons.b.f$c;
import com.mob.commons.k;

public class a
extends f {
    public a(Context context) {
        super(context);
    }

    public Intent a() {
        String string2 = k.a(76);
        Intent intent = new Intent(string2);
        String string3 = k.a(77);
        String string4 = k.a(78);
        string2 = new ComponentName(string3, string4);
        intent.setComponent((ComponentName)string2);
        return intent;
    }

    public f$c a(IBinder iBinder) {
        f$c f$c = new f$c();
        String string2 = k.a(71);
        int n10 = 79;
        String string3 = k.a(n10);
        int n11 = 0;
        String[] stringArray = new String[]{};
        int n12 = 2;
        Object object = this;
        f$c.d = object = this.a(string2, iBinder, string3, n12, stringArray);
        String string4 = k.a(69);
        String string5 = k.a(n10);
        String[] stringArray2 = new String[]{};
        f$c.b = object = this.a(string4, iBinder, string5, 3, stringArray2);
        string4 = k.a(70);
        string5 = k.a(n10);
        stringArray2 = new String[]{};
        f$c.e = object = this.a(string4, iBinder, string5, 4, stringArray2);
        int n13 = 75;
        string4 = k.a(n13);
        string5 = k.a(n10);
        stringArray2 = new String[]{};
        int n14 = 5;
        f$c.c = object = this.a(string4, iBinder, string5, n14, stringArray2);
        String string6 = k.a(n10);
        object = "isSupported";
        int n15 = 1;
        string3 = iBinder;
        n10 = this.a((String)object, iBinder, string6, n15);
        if (n10 != 0) {
            n11 = n15;
        }
        f$c.a = n11;
        return f$c;
    }
}

