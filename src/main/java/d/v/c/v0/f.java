/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0;

import com.zhiyun.cama.data.database.AppDatabase;
import com.zhiyun.cama.data.database.DatabaseHelper;
import com.zhiyun.cama.data.me.remote.CommunityManager;
import d.v.c.v0.u.b0.b;
import d.v.c.v0.u.b0.d;
import d.v.c.v0.u.v;
import d.v.c.v0.w.b.h;
import d.v.c.v0.w.c.a;
import d.v.e.l.c1;

public class f {
    public static v a() {
        c1 c12 = c1.b();
        CommunityManager communityManager = CommunityManager.getInstance();
        b b10 = b.g();
        d d10 = d.a();
        return v.M(c12, communityManager, b10, d10);
    }

    public static d.v.c.v0.w.a b() {
        Object object = DatabaseHelper.getInstance().getDataBase();
        Object object2 = c1.b();
        object = h.c((AppDatabase)object, (c1)object2);
        object2 = a.a();
        return d.v.c.v0.w.a.b((h)object, (a)object2);
    }
}

