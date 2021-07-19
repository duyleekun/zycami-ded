/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.d;
import com.heytap.mcssdk.d.c;
import d.i.a.a.b.b;
import d.i.a.a.c.a;
import java.util.Iterator;

public final class c$1
implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Intent b;
    public final /* synthetic */ b c;

    public c$1(Context context, Intent intent, b b10) {
        this.a = context;
        this.b = intent;
        this.c = b10;
    }

    public void run() {
        boolean bl2;
        Object object = this.a;
        Object object2 = this.b;
        if ((object = com.heytap.mcssdk.d.c.a((Context)object, object2)) == null) {
            return;
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            boolean bl3;
            object2 = (a)object.next();
            if (object2 == null) continue;
            Iterator iterator2 = d.k().p().iterator();
            while (bl3 = iterator2.hasNext()) {
                com.heytap.mcssdk.e.c c10 = (com.heytap.mcssdk.e.c)iterator2.next();
                if (c10 == null) continue;
                Context context = this.a;
                b b10 = this.c;
                c10.a(context, (a)object2, b10);
            }
        }
    }
}

