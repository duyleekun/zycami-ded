/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1;

import com.zhiyun.cama.data.api.entity.ProductPlatformListBean;
import com.zhiyun.net.BaseEntity;
import com.zhiyun.pay.data.PayFlowResult;
import d.v.c.l1.d0;
import java.util.List;
import k.d;
import k.f;
import k.r;
import m.a.a;

public class d0$d
implements f {
    public final /* synthetic */ d0 a;

    public d0$d(d0 d02) {
        this.a = d02;
    }

    public void onFailure(d object, Throwable object2) {
        object = new Object[]{};
        m.a.a.e("---primepay \u5546\u54c1\u5e73\u53f0\u5217\u8868\u670d\u52a1\u5668\u8bf7\u6c42\u5931\u8d25", object);
        object = this.a;
        object2 = PayFlowResult.PAY_FLOW_PRODUCT_PLATFORM_COMPLETE;
        d0.c((d0)object, (PayFlowResult)((Object)object2));
    }

    public void onResponse(d object, r object2) {
        int n10;
        object = (ProductPlatformListBean)((r)object2).a();
        boolean n102 = ((r)object2).g();
        if (n102 && object != null && (n10 = ((BaseEntity)object).errcode) == 0) {
            object2 = this.a;
            object = ((ProductPlatformListBean)object).getData();
            d0.d((d0)object2, (List)object);
            return;
        }
        object = new Object[]{};
        m.a.a.e("---primepay \u670d\u52a1\u5668\u8fd4\u56de\u5546\u54c1\u5e73\u53f0\u5217\u8868\u9519\u8bef", (Object[])object);
        object = this.a;
        object2 = PayFlowResult.PAY_FLOW_PRODUCT_PLATFORM_COMPLETE;
        d0.c((d0)object, (PayFlowResult)((Object)object2));
    }
}

