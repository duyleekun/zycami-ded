/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package com.baidu.location.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.location.c.b;
import com.baidu.location.c.c;

public class b$a
extends BroadcastReceiver {
    public final /* synthetic */ b a;

    private b$a(b b10) {
        this.a = b10;
    }

    public /* synthetic */ b$a(b b10, c c10) {
        this(b10);
    }

    public void onReceive(Context object, Intent object2) {
        object = this.a;
        boolean bl2 = b.c((b)object);
        if (!bl2) {
            return;
        }
        object = object2.getAction();
        bl2 = ((String)object).equals(object2 = "com.baidu.location.autonotifyloc_8.4.0");
        if (bl2 && (object = b.d(this.a)) != null) {
            object = this.a;
            object2 = null;
            b.a((b)object, null);
            object = b.d(this.a);
            int n10 = 1;
            object.sendEmptyMessage(n10);
        }
    }
}

