/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1;

import com.zhiyun.cama.data.api.entity.OrderBean;
import com.zhiyun.common.exception.ValueException;
import com.zhiyun.net.BaseEntity;
import com.zhiyun.pay.data.PayFlowResult;
import d.v.c.l1.d0;
import d.v.c.v0.l.c;
import e.a.k0;
import k.d;
import k.f;
import k.r;

public class d0$c
implements f {
    public final /* synthetic */ k0 a;
    public final /* synthetic */ d0 b;

    public d0$c(d0 d02, k0 k02) {
        this.b = d02;
        this.a = k02;
    }

    public void onFailure(d object, Throwable throwable) {
        object = this.a;
        PayFlowResult payFlowResult = PayFlowResult.PAY_FLOW_FAIL_CREATE_ORDER;
        throwable = ValueException.create("\u521b\u5efa\u8ba2\u5355\u5931\u8d25", throwable, (Object)payFlowResult);
        object.onError(throwable);
    }

    /*
     * Unable to fully structure code
     */
    public void onResponse(d var1_1, r var2_2) {
        block6: {
            var1_1 = (OrderBean)var2_2.a();
            if (var1_1 != null && (var3_3 = var1_1.errcode) == 0 && (var3_3 = (int)var2_2.g()) != 0) {
                this.a.onSuccess(var1_1);
                return;
            }
            var4_4 = PayFlowResult.PAY_FLOW_FAIL_CREATE_ORDER;
            var5_5 = var2_2.g();
            if (var5_5 == 0 || var1_1 == null) break block6;
            var5_5 = var1_1.errcode;
            var6_6 = 10002;
            if (var5_5 == var6_6 || var5_5 == (var6_6 = 10004)) ** GOTO lbl-1000
            var6_6 = 20034;
            if (var5_5 == var6_6) ** GOTO lbl30
            var6_6 = 20036;
            if (var5_5 == var6_6) ** GOTO lbl28
            var6_6 = 20038;
            if (var5_5 == var6_6) ** GOTO lbl26
            switch (var5_5) {
                default: {
                    break;
                }
                case 20023: {
                    var4_4 = PayFlowResult.PAY_FLOW_USER_SUBSCRIBING;
                    break;
                }
                case 20022: {
                    var4_4 = PayFlowResult.PAY_FLOW_ORDER_CREATE_TOO_FAST;
                    break;
                }
lbl26:
                // 1 sources

                var4_4 = PayFlowResult.PAY_FLOW_USER_SUBSCRIBING_ON_OTHER_PLATFORM;
                break;
lbl28:
                // 1 sources

                var4_4 = PayFlowResult.PAY_FLOW_PRIME_TIME_LIMIT;
                break;
lbl30:
                // 1 sources

                var4_4 = PayFlowResult.PAY_FLOW_PLATFORM_ACCOUNT_SUBSCRIBING_FOR_OTHER_USER;
                break;
                case 20020: 
                case 20021: lbl-1000:
                // 2 sources

                {
                    var4_4 = PayFlowResult.PAY_FLOW_PRODUCT_INFO_ERROR;
                }
            }
        }
        var2_2 = this.a;
        var1_1 = ValueException.create(c.q("\u521b\u5efa\u8ba2\u5355\u5931\u8d25", (BaseEntity)var1_1), (Object)var4_4);
        var2_2.onError((Throwable)var1_1);
    }
}

