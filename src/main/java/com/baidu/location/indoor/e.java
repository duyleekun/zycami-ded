/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.indoor;

import com.baidu.location.indoor.d;
import java.util.HashMap;

public class e
implements Runnable {
    public final /* synthetic */ d a;

    public e(d d10) {
        this.a = d10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        boolean bl2;
        HashMap hashMap;
        d d10;
        try {
            d10 = this.a;
            hashMap = d.a(d10);
            d.a(d10, hashMap);
        }
        catch (Exception exception) {}
        if ((d10 = d.b(this.a)) != null && (bl2 = (d10 = d.b(this.a)).isEnabled())) {
            d10 = this.a;
            hashMap = null;
            d10.a(false);
        }
        d.a(this.a).clear();
    }
}

