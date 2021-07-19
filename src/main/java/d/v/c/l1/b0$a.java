/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1;

import com.zhiyun.pay.data.PurchaseResult;
import d.v.c.l1.b0;
import d.v.w.c0.a;
import e.a.l0;
import e.a.s0.b;

public class b0$a
implements l0 {
    public final /* synthetic */ a a;
    public final /* synthetic */ b0 b;

    public b0$a(b0 b02, a a10) {
        this.b = b02;
        this.a = a10;
    }

    public void a(PurchaseResult object) {
        object = new StringBuilder();
        ((StringBuilder)object).append("\u901a\u77e5\u670d\u52a1\u5668\u6d88\u8d39\u6210\u529f");
        Object[] objectArray = this.a;
        ((StringBuilder)object).append(objectArray);
        object = ((StringBuilder)object).toString();
        objectArray = new Object[]{};
        m.a.a.b((String)object, objectArray);
    }

    public void onError(Throwable throwable) {
        if (throwable != null) {
            throwable.printStackTrace();
        }
    }

    public void onSubscribe(b b10) {
    }
}

