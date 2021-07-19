/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.geetest.sdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.geetest.sdk.utils.l$b;
import com.geetest.sdk.utils.l$b$b;
import java.text.SimpleDateFormat;

public class l$b$a
extends Handler {
    public final /* synthetic */ l$b a;

    public l$b$a(l$b b10, Looper looper) {
        this.a = b10;
        super(looper);
    }

    public void handleMessage(Message object) {
        super.handleMessage(object);
        int n10 = Thread.interrupted();
        if (n10 != 0) {
            return;
        }
        n10 = object.what;
        if (n10 == 0) {
            object = (l$b$b)object.obj;
            l$b l$b = this.a;
            SimpleDateFormat simpleDateFormat = l$b.a(l$b);
            long l10 = object.a;
            String string2 = object.b;
            object = object.c;
            object = l$b.a(simpleDateFormat, l10, string2, (String)object);
            l$b.a(l$b, (String)object);
        } else {
            int n11 = 1;
            if (n10 == n11) {
                l$b.c();
            }
        }
    }
}

