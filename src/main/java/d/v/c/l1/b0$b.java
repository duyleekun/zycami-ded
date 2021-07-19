/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1;

import com.zhiyun.common.exception.ValueException;
import com.zhiyun.pay.data.PurchaseResult;
import d.v.c.l1.b0;
import d.v.q.e;
import d.v.w.c0.d;
import e.a.l0;
import e.a.s0.b;
import java.util.concurrent.atomic.AtomicBoolean;

public class b0$b
implements l0 {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ b0 c;

    public b0$b(b0 b02, AtomicBoolean atomicBoolean, Object object) {
        this.c = b02;
        this.a = atomicBoolean;
        this.b = object;
    }

    public void a(PurchaseResult purchaseResult) {
        Object object = this.a;
        boolean bl2 = ((AtomicBoolean)object).get();
        if (!bl2) {
            object = this.c;
            b0.a((b0)object, purchaseResult, null);
        }
    }

    public void onError(Throwable object) {
        Object object2 = this.b;
        boolean bl2 = object2 instanceof d;
        object2 = bl2 ? (d)object2 : null;
        Class<PurchaseResult> clazz = this.a;
        bl2 = ((AtomicBoolean)((Object)clazz)).get();
        if (!bl2) {
            bl2 = object instanceof ValueException;
            int n10 = 41002;
            if (bl2) {
                object = (ValueException)object;
                clazz = PurchaseResult.class;
                if ((object = (PurchaseResult)((Object)((ValueException)object).getValue(clazz))) != null) {
                    b0.a(this.c, (PurchaseResult)((Object)object), (d)object2);
                    object = ((Enum)object).toString();
                    e.h(n10, (String)object);
                    return;
                }
            }
            object = this.c;
            clazz = PurchaseResult.PURCHASE_FAIL;
            b0.a((b0)object, (PurchaseResult)((Object)clazz), (d)object2);
            object = "\u652f\u4ed8\u5931\u8d25,\u672a\u77e5\u9519\u8bef";
            e.h(n10, (String)object);
        }
    }

    public void onSubscribe(b b10) {
    }
}

