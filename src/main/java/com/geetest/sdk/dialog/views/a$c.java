/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 */
package com.geetest.sdk.dialog.views;

import android.os.Handler;
import android.os.Message;
import com.geetest.sdk.au;
import com.geetest.sdk.dialog.views.a;
import com.geetest.sdk.utils.l;

public class a$c
extends Handler {
    public final /* synthetic */ a a;

    public a$c(a a10) {
        this.a = a10;
    }

    public void handleMessage(Message object) {
        int n10 = ((Message)object).what;
        int n11 = 1;
        if (n10 == n11 && (object = com.geetest.sdk.dialog.views.a.a(this.a)) != null) {
            Object object2;
            object = com.geetest.sdk.dialog.views.a.e();
            Object object3 = new Object[n11];
            int n12 = com.geetest.sdk.dialog.views.a.c(this.a).q();
            object3[0] = object2 = Integer.valueOf(n12);
            object3 = String.format("handleMessage-->timeout %s !", object3);
            l.b((String)object, (String)object3);
            object = com.geetest.sdk.dialog.views.a.a(this.a);
            object3 = "204";
            object2 = "load static resource timeout !";
            ((au)object).a((String)object3, (String)object2);
        }
    }
}

