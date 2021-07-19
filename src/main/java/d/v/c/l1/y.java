/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1;

import com.zhiyun.cama.data.api.entity.GooglePlayVerifyResultEntity;
import com.zhiyun.cama.data.api.entity.GooglePlayVerifyResultEntity$Result;
import com.zhiyun.common.exception.ValueException;
import com.zhiyun.net.BaseEntity;
import com.zhiyun.pay.data.PurchaseResult;
import d.v.c.l1.a0;
import d.v.c.v0.l.c;
import d.v.w.d0.k.l;
import e.a.k0;
import k.d;
import k.f;
import k.r;

public class y
implements f {
    public final /* synthetic */ k0 a;
    public final /* synthetic */ a0 b;

    public y(a0 a02, k0 k02) {
        this.b = a02;
        this.a = k02;
    }

    public void onFailure(d object, Throwable throwable) {
        throwable.printStackTrace();
        object = this.a;
        PurchaseResult purchaseResult = PurchaseResult.PURCHASE_FAIL_SERVER_FAIL;
        throwable = ValueException.create("\u670d\u52a1\u7aef\u9a8c\u8bc1\u4ea4\u6613\u5931\u8d25", throwable, (Object)purchaseResult);
        object.onError(throwable);
    }

    public void onResponse(d object, r object2) {
        boolean bl2;
        Object object3;
        boolean bl3;
        object = (GooglePlayVerifyResultEntity)((r)object2).a();
        if (object != null && !(bl3 = ((BaseEntity)object).errcode) && (object3 = ((GooglePlayVerifyResultEntity)object).getResult()) != null && (bl2 = ((r)object2).g())) {
            object = ((GooglePlayVerifyResultEntity)object).getResult();
            object2 = ((GooglePlayVerifyResultEntity$Result)object).getThirdProductType();
            bl3 = c.n((String)object2);
            bl2 = c.h((String)object2);
            k0 k02 = this.a;
            boolean bl4 = ((GooglePlayVerifyResultEntity$Result)object).isHasNewGrant();
            String string2 = ((GooglePlayVerifyResultEntity$Result)object).getThirdProductId();
            object = ((GooglePlayVerifyResultEntity$Result)object).getGooglePlayOrderId();
            object = l.b(bl4, string2, (String)object, bl3, bl2);
            k02.onSuccess(object);
            return;
        }
        object2 = this.a;
        object = c.q("\u670d\u52a1\u7aef\u9a8c\u8bc1\u4ea4\u6613\u5931\u8d25", (BaseEntity)object);
        object3 = PurchaseResult.PURCHASE_FAIL_SERVER_FAIL;
        object = ValueException.create((String)object, object3);
        object2.onError((Throwable)object);
    }
}

