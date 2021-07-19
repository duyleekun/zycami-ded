/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.s0.a7;

import android.content.Context;
import com.zhiyun.cama.camera.ble.BleViewModel;
import d.v.c.s0.a7.y0;
import d.v.c.s0.u6;
import d.v.e.h.a;
import d.v.f.i.g;

public class y0$a {
    public final /* synthetic */ y0 a;

    public y0$a(y0 y02) {
        this.a = y02;
    }

    public void a() {
        Object object = (Boolean)y0.w((y0)this.a).L.getValue();
        boolean bl2 = d.v.e.h.a.c((Boolean)object);
        if (!bl2) {
            object = y0.x(this.a);
            Object object2 = this.a.getResources();
            int n10 = 2131951950;
            object2 = g.o(object2, n10);
            ((u6)object).o2((String)object2);
        } else {
            object = y0.w(this.a);
            Context context = this.a.requireContext();
            ((BleViewModel)object).d(context);
        }
    }
}

