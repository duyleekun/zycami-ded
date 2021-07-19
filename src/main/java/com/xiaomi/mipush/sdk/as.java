/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.ContentObserver
 *  android.os.Handler
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.mipush.sdk.aq;
import com.xiaomi.push.az;
import com.xiaomi.push.service.aw;

public class as
extends ContentObserver {
    public final /* synthetic */ aq a;

    public as(aq aq2, Handler handler) {
        this.a = aq2;
        super(handler);
    }

    public void onChange(boolean bl2) {
        Object object = this.a;
        int n10 = aw.a(aq.a((aq)object)).a();
        Integer n11 = n10;
        aq.a((aq)object, n11);
        object = aq.a(this.a);
        int n12 = (Integer)object;
        if (n12 != 0) {
            aq.a(this.a).getContentResolver().unregisterContentObserver((ContentObserver)this);
            object = aq.a(this.a);
            boolean bl3 = az.b((Context)object);
            if (bl3) {
                object = this.a;
                ((aq)object).c();
            }
        }
    }
}

