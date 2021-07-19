/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.baidu.lbsapi.auth;

import android.content.Context;
import com.baidu.lbsapi.auth.a;
import com.baidu.lbsapi.auth.c;
import com.baidu.lbsapi.auth.g;
import java.util.HashMap;

public class d
implements Runnable {
    public final /* synthetic */ c a;

    public d(c c10) {
        this.a = c10;
    }

    public void run() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("postWithHttps start Thread id = ");
        Object object2 = String.valueOf(Thread.currentThread().getId());
        ((StringBuilder)object).append((String)object2);
        com.baidu.lbsapi.auth.a.a(((StringBuilder)object).toString());
        object2 = c.a(this.a);
        object = new g((Context)object2);
        object2 = c.b(this.a);
        object = ((g)object).a((HashMap)object2);
        c.a(this.a, (String)object);
    }
}

