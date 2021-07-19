/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.geetest.sdk;

import com.geetest.sdk.ay;
import com.geetest.sdk.az;
import com.geetest.sdk.model.beans.a;
import com.geetest.sdk.w;
import com.geetest.sdk.w$a;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

public class w$a$b
implements ay {
    public final /* synthetic */ boolean[] a;
    public final /* synthetic */ a[] b;
    public final /* synthetic */ CountDownLatch c;
    public final /* synthetic */ w$a d;

    public w$a$b(w$a w$a, boolean[] blArray, a[] aArray, CountDownLatch countDownLatch) {
        this.d = w$a;
        this.a = blArray;
        this.b = aArray;
        this.c = countDownLatch;
    }

    public void a(int n10, String aArray, JSONObject jSONObject) {
        Object object = w.b(this.d.b, n10, (String)aArray, jSONObject);
        aArray = (a[])this.a;
        boolean bl2 = (Boolean)((az)object).a;
        int n11 = 1;
        aArray[n11] = bl2;
        aArray = this.b;
        aArray[n11] = object = (a)((az)object).b;
        this.c.countDown();
    }
}

