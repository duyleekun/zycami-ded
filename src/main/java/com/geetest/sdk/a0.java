/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package com.geetest.sdk;

import android.os.Handler;
import android.os.Looper;
import com.geetest.sdk.a0$a;
import com.geetest.sdk.a0$b;
import com.geetest.sdk.ay;

public class a0
implements ay {
    private final Handler a;
    private ay b;

    public a0(ay ay2) {
        this.b = ay2;
        Looper looper = Looper.getMainLooper();
        super(looper);
        this.a = ay2;
    }

    public static a0 a(ay ay2) {
        a0 a02 = new a0(ay2);
        return a02;
    }

    public static /* synthetic */ ay a(a0 a02) {
        return a02.b;
    }

    private void b(int n10, String string2, Object object) {
        Handler handler = this.a;
        if (handler != null) {
            a0$a a0$a = new a0$a(this, n10, string2, object);
            handler.post((Runnable)a0$a);
        } else {
            Object object2 = Looper.getMainLooper();
            handler = new Handler(object2);
            object2 = new a0$b(this, n10, string2, object);
            handler.post((Runnable)object2);
        }
    }

    public void a(int n10, String string2, Object object) {
        Looper looper;
        ay ay2 = this.b;
        if (ay2 == null) {
            return;
        }
        ay2 = Looper.myLooper();
        if (ay2 != (looper = Looper.getMainLooper())) {
            this.b(n10, string2, object);
        } else {
            ay2 = this.b;
            try {
                ay2.a(n10, string2, object);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}

