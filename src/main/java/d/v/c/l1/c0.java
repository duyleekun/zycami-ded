/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1;

import com.zhiyun.cama.data.api.entity.OrderBean;
import d.v.c.v0.l.c;
import d.v.w.c0.b;
import d.v.w.d0.k.h;

public class c0 {
    public static b a(OrderBean orderBean, String string2, boolean bl2) {
        String string3 = orderBean.getThirdProductType();
        boolean bl3 = c.n(string3);
        boolean bl4 = c.h(string3);
        String string4 = orderBean.getThirdProductId();
        String string5 = orderBean.getOrderSN();
        return h.f(string4, string5, string2, bl3, bl4, bl2);
    }
}

