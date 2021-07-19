/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.stabilizer;

import com.zhiyun.stabilizer.Stabilizer;
import com.zhiyun.stabilizer.Stabilizer$i;
import d.v.e0.sd;

public class Stabilizer$c
extends sd {
    public final /* synthetic */ Stabilizer d;

    public Stabilizer$c(Stabilizer stabilizer, Stabilizer stabilizer2) {
        this.d = stabilizer;
        super(stabilizer2);
    }

    public void s() {
        Stabilizer$i stabilizer$i = Stabilizer.J1(this.d);
        if (stabilizer$i != null) {
            stabilizer$i = Stabilizer.J1(this.d);
            stabilizer$i.onConnected();
        }
    }

    public void t(Throwable throwable) {
        Object object = this.d;
        boolean bl2 = ((Stabilizer)object).t3();
        if (bl2) {
            object = this.d;
            ((Stabilizer)object).Y1();
        }
        if ((object = Stabilizer.J1(this.d)) != null) {
            object = Stabilizer.J1(this.d);
            object.onFailed(throwable);
        }
    }

    public void u() {
        Stabilizer$i stabilizer$i = Stabilizer.J1(this.d);
        if (stabilizer$i != null) {
            stabilizer$i = Stabilizer.J1(this.d);
            stabilizer$i.a();
        }
    }
}

