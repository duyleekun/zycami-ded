/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.pay;

import com.zhiyun.common.exception.ValueException;
import com.zhiyun.pay.PayClientLifecycle;
import com.zhiyun.pay.data.PayFlowResult;
import d.b.a.b.d;
import d.b.a.b.f;
import d.b.a.b.h;
import e.a.k0;

public class PayClientLifecycle$a
implements f {
    public final /* synthetic */ k0 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PayClientLifecycle c;

    public PayClientLifecycle$a(PayClientLifecycle payClientLifecycle, k0 k02, String string2) {
        this.c = payClientLifecycle;
        this.a = k02;
        this.b = string2;
    }

    public void a(h object) {
        Object object2 = PayClientLifecycle.c0(this.c);
        boolean bl2 = ((d)object2).e();
        if (bl2) {
            object = this.a;
            object2 = this.b;
            object.onSuccess(object2);
        } else {
            object2 = this.a;
            Object object3 = new StringBuilder();
            object3.append("Google Play \u521d\u59cb\u5316\u4e0d\u6210\u529f, \u9519\u8bef\u7801:");
            int n10 = ((h)object).b();
            object3.append(n10);
            String string2 = ", \u9519\u8bef\u4fe1\u606f:";
            object3.append(string2);
            object = ((h)object).a();
            object3.append((String)object);
            object = object3.toString();
            object3 = PayFlowResult.PAY_FLOW_GOOGLE_NOT_SUPPORTED;
            object = ValueException.create((String)object, object3);
            object2.tryOnError((Throwable)object);
        }
    }

    public void b() {
        k0 k02 = this.a;
        Object object = PayFlowResult.PAY_FLOW_GOOGLE_NOT_SUPPORTED;
        object = ValueException.create("Google Play \u65ad\u5f00\u8fde\u63a5", object);
        k02.tryOnError((Throwable)object);
    }
}

