/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1;

import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.cama.data.api.entity.SubscribeStateEntity;
import com.zhiyun.cama.data.api.entity.SubscribeStateEntity$SubScribeState;
import com.zhiyun.common.exception.ValueException;
import com.zhiyun.net.BaseEntity;
import com.zhiyun.pay.data.PayFlowResult;
import d.v.c.l1.d0;
import d.v.c.v0.l.c;
import e.a.k0;
import java.util.concurrent.atomic.AtomicBoolean;
import k.d;
import k.f;
import k.r;

public class d0$b
implements f {
    public final /* synthetic */ String a;
    public final /* synthetic */ AtomicBoolean b;
    public final /* synthetic */ AtomicBoolean c;
    public final /* synthetic */ k0 d;
    public final /* synthetic */ UserInfo e;
    public final /* synthetic */ d0 f;

    public d0$b(d0 d02, String string2, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, k0 k02, UserInfo userInfo) {
        this.f = d02;
        this.a = string2;
        this.b = atomicBoolean;
        this.c = atomicBoolean2;
        this.d = k02;
        this.e = userInfo;
    }

    public void onFailure(d object, Throwable throwable) {
        object = this.d;
        PayFlowResult payFlowResult = PayFlowResult.PAY_FLOW_SUB_STATE_QUERY_FAIL;
        throwable = ValueException.create("\u83b7\u53d6\u7528\u6237\u5f53\u524d\u8ba2\u9605\u72b6\u6001\u5931\u8d25!", throwable, (Object)payFlowResult);
        object.onError(throwable);
    }

    public void onResponse(d object, r object2) {
        boolean bl2;
        int bl3;
        object = (SubscribeStateEntity)((r)object2).a();
        if (object != null && (bl3 = ((BaseEntity)object).errcode) == 0 && (bl2 = ((r)object2).g())) {
            if ((object = ((SubscribeStateEntity)object).getData()) != null) {
                object = object.iterator();
                while (bl2 = object.hasNext()) {
                    int n10;
                    object2 = (SubscribeStateEntity$SubScribeState)object.next();
                    int n11 = ((SubscribeStateEntity$SubScribeState)object2).getAutoRenewing();
                    if (n11 != (n10 = 1)) continue;
                    String payFlowResult = this.a;
                    bl2 = payFlowResult.equals(object2 = ((SubscribeStateEntity$SubScribeState)object2).getPlatform());
                    if (bl2) {
                        object2 = this.b;
                        ((AtomicBoolean)object2).set(n10 != 0);
                        continue;
                    }
                    object2 = this.c;
                    ((AtomicBoolean)object2).set(n10 != 0);
                }
            }
            object = this.d;
            object2 = this.e;
            object.onSuccess(object2);
        } else {
            object2 = this.d;
            object = d.v.c.v0.l.c.q("\u83b7\u53d6\u7528\u6237\u5f53\u524d\u8ba2\u9605\u72b6\u6001\u5931\u8d25!", (BaseEntity)object);
            PayFlowResult payFlowResult = PayFlowResult.PAY_FLOW_SUB_STATE_QUERY_FAIL;
            object = ValueException.create((String)object, (Object)payFlowResult);
            object2.onError((Throwable)object);
        }
    }
}

