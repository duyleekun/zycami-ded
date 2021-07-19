/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.le;

import com.zhiyun.net.BaseEntity;
import com.zhiyun.stabilizer.net.entities.FileList;
import d.v.e0.le.b;
import d.v.e0.le.b$d;
import java.util.List;
import k.d;
import k.f;
import k.r;

public final class b$b
implements f {
    public final /* synthetic */ b$d a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;

    public b$b(b$d b$d, int n10, String string2, int n11) {
        this.a = b$d;
        this.b = n10;
        this.c = string2;
        this.d = n11;
    }

    public void onFailure(d object, Throwable object2) {
        d.v.e0.le.b.a(null);
        boolean bl2 = object.isCanceled();
        if (!bl2) {
            object = this.a;
            object2 = ((Throwable)object2).toString();
            object.a((String)object2);
        }
    }

    public void onResponse(d object, r object2) {
        int n10;
        int n11 = 0;
        d.v.e0.le.b.a(null);
        object = (FileList)((r)object2).a();
        if (object == null) {
            this.a.a("");
            return;
        }
        n11 = ((BaseEntity)object).errcode;
        if (n11 != 0) {
            object = this.a;
            object2 = ((r)object2).h();
            object.a((String)object2);
            return;
        }
        object = ((FileList)((r)object2).a()).getList();
        if (object != null && (n10 = object.size()) != 0) {
            object2 = this.a;
            int n12 = this.b;
            int n13 = object.size();
            object2.c(n12 += n13);
            object2 = d.v.e0.le.b.b(this.c, (List)object);
            n12 = object2.size();
            if (n12 == 0) {
                n11 = object.size();
                if (n11 == (n10 = this.d)) {
                    object = this.a;
                    n12 = this.b + n10;
                    object.c(n12);
                    n11 = this.b;
                    n10 = this.d;
                    String string2 = this.c;
                    b$d b$d = this.a;
                    d.v.e0.le.b.d(n11 += n10, n10, string2, b$d);
                } else {
                    object = this.a;
                    object.b();
                }
            } else {
                object = this.a;
                object.d((List)object2);
            }
            return;
        }
        this.a.b();
    }
}

