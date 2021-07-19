/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1;

import com.zhiyun.common.exception.ValueException;
import com.zhiyun.pay.data.PayFlowResult;
import d.v.c.l1.d0;
import d.v.q.e;
import d.v.w.c0.c;
import e.a.l0;
import e.a.s0.b;

public class d0$a
implements l0 {
    public final /* synthetic */ d0 a;

    public d0$a(d0 d02) {
        this.a = d02;
    }

    public void a(c c10) {
        this.a.a.setValue(c10);
    }

    public void onError(Throwable object) {
        Object object2;
        boolean bl2 = object instanceof ValueException;
        int n10 = 41001;
        if (bl2) {
            object = (ValueException)object;
            object2 = PayFlowResult.class;
            if ((object = (PayFlowResult)((Object)((ValueException)object).getValue((Class)object2))) != null) {
                d0.c(this.a, (PayFlowResult)((Object)object));
                object = ((Enum)object).toString();
                e.h(n10, (String)object);
                return;
            }
        }
        object = this.a;
        object2 = PayFlowResult.PAY_FLOW_FAIL;
        d0.c((d0)object, object2);
        e.h(n10, "\u8c03\u8d77\u652f\u4ed8\u5931\u8d25,\u672a\u77e5\u9519\u8bef");
    }

    public void onSubscribe(b b10) {
        d0.b(this.a).b(b10);
    }
}

