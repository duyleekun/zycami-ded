/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 */
package l.a.e;

import android.app.Activity;
import android.content.Context;
import l.a.e.a;
import l.a.n.b;
import l.a.o.f;
import l.a.q.z;

public class a$a
implements b {
    private final Context a;
    private boolean b = false;
    public final /* synthetic */ a c;

    public a$a(a a10, Context context) {
        this.c = a10;
        this.a = context;
    }

    public void a() {
        Object object;
        Object object2;
        boolean bl2 = f.a;
        if (bl2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Context: ");
            object = this.a;
            ((StringBuilder)object2).append(object);
            ((StringBuilder)object2).append(" updateSkinForce");
            object2 = ((StringBuilder)object2).toString();
            object = "SkinActivityLifecycle";
            f.b((String)object, (String)object2);
        }
        if ((object2 = this.a) == null) {
            return;
        }
        boolean bl3 = object2 instanceof Activity;
        if (bl3 && (bl2 = l.a.e.a.b((a)(object = this.c), (Context)object2))) {
            object2 = this.c;
            object = (Activity)this.a;
            l.a.e.a.c((a)object2, (Activity)object);
        }
        object2 = this.c;
        object = this.a;
        l.a.e.a.d((a)object2, object).a();
        object2 = this.a;
        bl3 = object2 instanceof z;
        if (bl3) {
            object2 = (z)object2;
            object2.e();
        }
        this.b = false;
    }

    public void b(l.a.n.a object, Object object2) {
        boolean bl2;
        object = l.a.e.a.a(this.c);
        if (object != null && (object = this.a) != (object2 = l.a.e.a.a(this.c).get()) && (bl2 = (object = this.a) instanceof Activity)) {
            this.b = bl2 = true;
        } else {
            this.a();
        }
    }

    public void c() {
        boolean bl2 = this.b;
        if (bl2) {
            this.a();
        }
    }
}

