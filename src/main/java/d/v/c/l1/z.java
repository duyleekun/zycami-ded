/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1;

import com.zhiyun.common.exception.ValueException;
import com.zhiyun.net.BaseEntity;
import d.v.c.l1.a0;
import d.v.c.v0.l.c;
import e.a.k0;
import k.d;
import k.f;
import k.r;

public class z
implements f {
    public final /* synthetic */ k0 a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ a0 c;

    public z(a0 a02, k0 k02, boolean bl2) {
        this.c = a02;
        this.a = k02;
        this.b = bl2;
    }

    public void onFailure(d object, Throwable throwable) {
        object = this.a;
        Object object2 = this.c;
        boolean bl2 = this.b;
        object2 = object2.f(bl2);
        throwable = ValueException.create("\u6d88\u8d39\u901a\u77e5\u670d\u52a1\u5668\u5931\u8d25", throwable, object2);
        object.onError(throwable);
    }

    public void onResponse(d object, r object2) {
        boolean bl2;
        boolean bl3;
        object = (BaseEntity)((r)object2).a();
        if (object != null && !(bl3 = ((BaseEntity)object).errcode) && (bl2 = ((r)object2).g())) {
            object = this.a;
            object2 = this.c;
            bl3 = this.b;
            object2 = object2.f(bl3);
            object.onSuccess(object2);
        } else {
            object2 = this.a;
            object = d.v.c.v0.l.c.q("\u6d88\u8d39\u901a\u77e5\u670d\u52a1\u5668\u5931\u8d25", (BaseEntity)object);
            Object object3 = this.c;
            boolean bl4 = this.b;
            object3 = object3.f(bl4);
            object = ValueException.create((String)object, object3);
            object2.onError((Throwable)object);
        }
    }
}

