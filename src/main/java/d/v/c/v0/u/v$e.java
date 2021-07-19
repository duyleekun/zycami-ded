/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u;

import com.zhiyun.cama.data.MessagePageType;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.c.v0.u.b;
import d.v.c.v0.u.v;

public class v$e
extends a {
    public final /* synthetic */ MessagePageType a;
    public final /* synthetic */ int b;
    public final /* synthetic */ a c;
    public final /* synthetic */ v d;

    public v$e(v v10, MessagePageType messagePageType, int n10, a a10) {
        this.d = v10;
        this.a = messagePageType;
        this.b = n10;
        this.c = a10;
    }

    private /* synthetic */ void a(MessagePageType messagePageType, int n10) {
        v.L(this.d).d(messagePageType, n10);
    }

    public /* synthetic */ void b(MessagePageType messagePageType, int n10) {
        this.a(messagePageType, n10);
    }

    public void onError(Throwable throwable, int n10, String string2) {
        a a10 = this.c;
        if (a10 != null) {
            a10.onError(throwable, n10, string2);
        }
    }

    public void onSuccess(BaseEntity baseEntity) {
        Object object = v.J(this.d).a();
        MessagePageType messagePageType = this.a;
        int n10 = this.b;
        b b10 = new b(this, messagePageType, n10);
        object.execute(b10);
        object = this.c;
        if (object != null) {
            object.onSuccess(baseEntity);
        }
    }
}

