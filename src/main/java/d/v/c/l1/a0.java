/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1;

import com.zhiyun.common.exception.ValueException;
import com.zhiyun.net.RetrofitService;
import com.zhiyun.pay.data.PurchaseResult;
import d.v.c.l1.f;
import d.v.c.l1.g;
import d.v.c.l1.y;
import d.v.c.l1.z;
import d.v.c.v0.l.c;
import d.v.w.c0.a;
import d.v.w.c0.d;
import d.v.w.d0.k.j;
import e.a.i0;
import e.a.k0;
import e.a.o0;

public interface a0
extends c,
d.v.c.v0.l.f {
    public static final a0 c = (a0)RetrofitService.create(a0.class);

    public static /* synthetic */ void k(a0 object, d object2, String object3, k0 k02) {
        boolean bl2 = object2.isSuccessful();
        if (bl2) {
            bl2 = object2 instanceof j;
            if (bl2) {
                Object object4 = object2;
                object4 = (j)object2;
                boolean bl3 = ((j)object4).h();
                if (bl3) {
                    String string2 = ((d)object2).a();
                    String string3 = ((j)object4).f();
                    String string4 = ((j)object4).g();
                    String string5 = ((j)object4).e();
                    a0 a02 = c;
                    object2 = a02.l(string2, string3, string4, string5, (String)object3);
                    object3 = new y((a0)object, k02);
                    object2.h((k.f)object3);
                } else {
                    object = PurchaseResult.PURCHASE_OK;
                    object2 = "\u8c37\u6b4c\u652f\u4ed8\u6210\u529f,\u4f46\u6ca1\u6709\u8fd4\u56de\u8ba2\u5355\u6570\u636e,\u53ef\u80fd\u662f\u5347\u964d\u7ea7\u672a\u751f\u6548\u7684\u539f\u56e0";
                    object = ValueException.create((String)object2, object);
                    k02.onError((Throwable)object);
                }
            } else {
                object = new StringBuilder();
                object3 = "\u6821\u9a8c\u7684\u53c2\u6570\u5f02\u5e38, purchase:";
                ((StringBuilder)object).append((String)object3);
                ((StringBuilder)object).append(object2);
                object = ((StringBuilder)object).toString();
                object2 = PurchaseResult.PURCHASE_FAIL;
                object = ValueException.create((String)object, object2);
                k02.onError((Throwable)object);
            }
        } else {
            object = PurchaseResult.PURCHASE_FAIL;
            object2 = "\u4ea4\u6613\u5931\u8d25";
            object = ValueException.create((String)object2, object);
            k02.onError((Throwable)object);
        }
    }

    public static /* synthetic */ void p(a0 object, a object2, k0 k02) {
        boolean bl2 = object2 instanceof d.v.w.d0.k.g;
        if (bl2) {
            object2 = (d.v.w.d0.k.g)object2;
            Object object3 = ((d.v.w.d0.k.g)object2).c();
            boolean bl3 = object2.a();
            object3 = c.j((String)object3);
            z z10 = new z((a0)object, k02, bl3);
            object3.h(z10);
        } else {
            boolean bl4 = false;
            object = object.f(false);
            object2 = "\u6d88\u8d39\u901a\u77e5\u670d\u52a1\u5668\u5931\u8d25,\u56e0\u4e3a\u53c2\u6570\u4e0d\u8db3";
            object = ValueException.create((String)object2, object);
            k02.onError((Throwable)object);
        }
    }

    default public o0 a(d d10, String string2) {
        f f10 = new f(this, d10, string2);
        return i0.H(f10);
    }

    default public o0 b(a a10) {
        g g10 = new g(this, a10);
        return i0.H(g10);
    }

    default public PurchaseResult f(boolean bl2) {
        return PurchaseResult.PURCHASE_OK;
    }
}

