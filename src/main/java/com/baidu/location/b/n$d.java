/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Message
 */
package com.baidu.location.b;

import android.os.Message;
import com.baidu.location.b.n;
import com.baidu.location.b.n$1;
import com.baidu.location.b.n$b;

public class n$d {
    public final /* synthetic */ n a;

    private n$d(n n10) {
        this.a = n10;
    }

    public /* synthetic */ n$d(n n10, n$1 n$1) {
        this(n10);
    }

    public void sendMessage(String object) {
        boolean bl2;
        Object object2;
        Object object3;
        boolean bl3;
        if (object != null && (bl3 = n.a((n)(object3 = this.a))) && (object = ((n$b)(object3 = new n$b((n)(object2 = this.a), (String)object))).a()) != null && (bl2 = (object = ((n$b)object3).a()).equals(object2 = "requestLoc")) && (object = n.b(this.a)) != null) {
            object = n.b(this.a);
            int n10 = 1;
            object = object.obtainMessage(n10);
            ((Message)object).obj = object3;
            object.sendToTarget();
        }
    }

    public void showLog(String string2) {
    }
}

