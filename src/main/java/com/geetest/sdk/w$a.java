/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 */
package com.geetest.sdk;

import android.app.Activity;
import android.content.Context;
import com.geetest.sdk.bb;
import com.geetest.sdk.c;
import com.geetest.sdk.model.beans.a;
import com.geetest.sdk.model.beans.b;
import com.geetest.sdk.u;
import com.geetest.sdk.utils.l;
import com.geetest.sdk.w;
import com.geetest.sdk.w$a$a;
import com.geetest.sdk.w$a$b;
import com.geetest.sdk.w$a$c;
import com.geetest.sdk.w$a$d;
import java.util.concurrent.CountDownLatch;

public class w$a
implements Runnable {
    public final /* synthetic */ bb a;
    public final /* synthetic */ w b;

    public w$a(w w10, bb bb2) {
        this.b = w10;
        this.a = bb2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        int n10 = 2;
        Object object = new CountDownLatch(n10);
        Object object2 = new boolean[n10];
        object2[0] = false;
        object2[1] = false;
        Object object3 = new a[n10];
        String string2 = null;
        object3[0] = null;
        int n11 = 1;
        object3[n11] = null;
        Context context = this.a.c();
        b b10 = this.a.d();
        w$a$a w$a$a = new w$a$a(this, (boolean[])object2, (a[])object3, (CountDownLatch)object);
        c.c(context, b10, w$a$a);
        context = this.a.c();
        b10 = this.a.d();
        w$a$b w$a$b = new w$a$b(this, (boolean[])object2, (a[])object3, (CountDownLatch)object);
        c.b(context, b10, w$a$b);
        try {
            ((CountDownLatch)object).await();
            boolean bl2 = object2[0];
            if (bl2 && (bl2 = object2[n11])) {
                object = this.b;
                object = ((u)object).a;
                object3 = this.a;
                ((u)object).c((bb)object3);
                return;
            }
            bl2 = object2[0];
            if (!bl2) {
                object = this.a;
                object3 = object3[0];
                ((bb)object).a((a)object3);
            } else {
                object = this.a;
                object3 = object3[n11];
                ((bb)object).a((a)object3);
            }
            object = this.b;
            object = ((u)object).c;
            object = (Activity)object;
            object3 = new w$a$c(this);
            object.runOnUiThread((Runnable)object3);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            this.a.i().i("0");
            object3 = w.b();
            object2 = new StringBuilder;
            ((StringBuilder)object2)();
            ((StringBuilder)object2).append("GetTypeAndGetHandler InterruptedException: 206-->");
            string2 = exception.getMessage();
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            l.b((String)object3, (String)object2);
            object3 = new a();
            object2 = new StringBuilder();
            string2 = "GetTypeAndGetHandler InterruptedException: ";
            ((StringBuilder)object2).append(string2);
            String string3 = exception.getMessage();
            ((StringBuilder)object2).append(string3);
            string3 = ((StringBuilder)object2).toString();
            ((a)object3).c(string3);
            ((a)object3).b("206");
            long l10 = System.currentTimeMillis();
            long l11 = this.a.j();
            ((a)object3).a(l10 -= l11);
            string3 = this.a.d().c();
            ((a)object3).a(string3);
            this.a.a((a)object3);
            string3 = (Activity)this.b.c;
            object3 = new w$a$d(this);
            string3.runOnUiThread((Runnable)object3);
        }
    }
}

