/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.d;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.d.a;
import java.util.ArrayList;

public class a$b
implements BDLocationListener {
    public final /* synthetic */ a a;

    public a$b(a a10) {
        this.a = a10;
    }

    public void onReceiveLocation(BDLocation bDLocation) {
        int n10;
        Object object = com.baidu.location.d.a.a(this.a);
        if (object != null && (n10 = ((ArrayList)(object = com.baidu.location.d.a.a(this.a))).size()) > 0) {
            object = this.a;
            com.baidu.location.d.a.a((a)object, bDLocation);
        }
    }
}

