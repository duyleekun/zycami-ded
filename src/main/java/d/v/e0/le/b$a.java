/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.le;

import com.zhiyun.net.BaseEntity;
import d.v.e0.le.b$c;
import d.v.e0.le.c.a;
import k.d;
import k.f;
import k.r;

public final class b$a
implements f {
    public final /* synthetic */ b$c a;

    public b$a(b$c b$c) {
        this.a = b$c;
    }

    public void onFailure(d object, Throwable throwable) {
        object = this.a;
        if (object != null) {
            object.a(throwable);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onResponse(d object, r object2) {
        int n10 = ((r)object2).g();
        if (n10 != 0) {
            object = (a)((r)object2).a();
            n10 = ((BaseEntity)object).errcode;
            if (n10 == 0) {
                object = this.a;
                if (object == null) return;
                object2 = (a)((r)object2).a();
                object.b((a)object2);
                return;
            }
        }
        if ((object = this.a) == null) return;
        object2 = null;
        object.a(null);
    }
}

