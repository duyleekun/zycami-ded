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
import com.mob.commons.b.c;
import com.mob.commons.b.f;
import com.mob.commons.b.f$c;
import com.mob.commons.k;

public class n
extends f {
    public n(Context context) {
        super(context);
    }

    private void j() {
        Intent intent = new Intent();
        int n10 = 138;
        Object object = k.a(n10);
        int bl2 = 139;
        String string2 = k.a(bl2);
        intent.setClassName((String)object, string2);
        n10 = 141;
        object = k.a(n10);
        intent.setAction((String)object);
        n10 = 142;
        object = k.a(n10);
        string2 = this.b;
        intent.putExtra((String)object, string2);
        n10 = 143;
        object = k.a(n10);
        boolean bl3 = true;
        intent.putExtra((String)object, bl3);
        object = this.a;
        try {
            intent = object.startService(intent);
            if (intent != null) {
                return;
            }
        }
        catch (Throwable throwable) {
            object = c.a();
            ((c)object).a(throwable);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean k() {
        Context context;
        boolean bl2 = false;
        try {
            context = this.a;
        }
        catch (Exception exception) {
            return bl2;
        }
        context = context.getPackageManager();
        int n10 = 138;
        String string2 = k.a(n10);
        context.getPackageInfo(string2, 0);
        return true;
    }

    public Intent a() {
        this.j();
        Intent intent = new Intent();
        String string2 = k.a(138);
        String string3 = k.a(140);
        intent.setClassName(string2, string3);
        string2 = k.a(144);
        intent.setAction(string2);
        string2 = k.a(142);
        string3 = this.b;
        intent.putExtra(string2, string3);
        return intent;
    }

    public f$c a(IBinder object) {
        boolean bl2;
        f$c f$c = new f$c();
        String string2 = k.a(69);
        String string3 = k.a(145);
        String[] stringArray = new String[]{};
        object = this.a(string2, (IBinder)object, string3, 3, stringArray);
        f$c.b = object;
        f$c.a = bl2 = this.k();
        return f$c;
    }
}

