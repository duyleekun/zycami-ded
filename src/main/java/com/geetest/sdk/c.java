/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.geetest.sdk;

import android.content.Context;
import com.geetest.sdk.a0;
import com.geetest.sdk.a1;
import com.geetest.sdk.a2;
import com.geetest.sdk.a3;
import com.geetest.sdk.aw;
import com.geetest.sdk.ax;
import com.geetest.sdk.ay;
import com.geetest.sdk.model.beans.b;

public class c {
    public static ax a(Context object, b object2, ay ay2) {
        ax ax2 = ax.c();
        object = a1.a(object, (b)object2);
        object2 = a0.a(ay2);
        ax2.a((aw)object, (ay)object2);
        return ax2;
    }

    public static ax b(Context object, b b10, ay ay2) {
        ax ax2 = ax.c();
        object = a2.a(object, b10);
        ax2.a((aw)object, ay2);
        return ax2;
    }

    public static ax c(Context object, b b10, ay ay2) {
        ax ax2 = ax.c();
        object = a3.a(object, b10);
        ax2.a((aw)object, ay2);
        return ax2;
    }
}

