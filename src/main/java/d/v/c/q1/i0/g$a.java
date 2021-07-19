/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.q1.i0;

import com.zhiyun.cama.data.api.entity.ServerEntity;
import com.zhiyun.cama.data.api.entity.ServerEntity$Config;
import com.zhiyun.net.DataListEntity;
import d.v.a.f.b.a;
import d.v.c.q1.i0.g;
import d.v.e.i.j;
import java.util.ArrayList;

public class g$a
extends a {
    public final /* synthetic */ g a;

    public g$a(g g10) {
        this.a = g10;
    }

    public void a(DataListEntity object) {
        boolean bl2;
        Object object2 = this.a.c;
        Object object3 = Boolean.FALSE;
        ((j)object2).setValue(object3);
        if (object != null && (object2 = ((DataListEntity)object).list) != null && !(bl2 = ((ArrayList)object2).isEmpty())) {
            boolean bl3;
            object2 = ((DataListEntity)object).list.iterator();
            while (bl3 = object2.hasNext()) {
                object3 = ((ServerEntity)object2.next()).config;
                if (object3 == null) continue;
                Object object4 = this.a;
                String string2 = ((ServerEntity$Config)object3).api;
                String string3 = "https://api.zhiyun-tech.com/v1/";
                ((ServerEntity$Config)object3).api = object4 = g.b((g)object4, string2, string3);
            }
            object2 = this.a.a;
            ((j)object2).setValue(object);
        } else {
            object = this.a.b;
            object2 = Boolean.TRUE;
            ((j)object).setValue(object2);
        }
    }

    public void onError(Throwable object, int n10, String string2) {
        object = this.a.c;
        Boolean bl2 = Boolean.FALSE;
        ((j)object).setValue(bl2);
        object = this.a.b;
        bl2 = Boolean.TRUE;
        ((j)object).setValue(bl2);
    }
}

