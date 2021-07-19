/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.Editable
 *  android.text.TextUtils
 *  android.view.View
 */
package d.v.c.x0.c.e;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import com.zhiyun.cama.widget.BackEditText;
import d.v.c.i1.i2;
import d.v.c.x0.c.e.b;
import d.v.e.l.v1;
import d.v.f.i.g;

public class b$a {
    public final /* synthetic */ b a;

    public b$a(b b10) {
        this.a = b10;
    }

    public void a(Editable object) {
        Object object2;
        object = object.toString().trim();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        int n10 = 2131952109;
        if (bl2) {
            object = g.o(this.a.getResources(), n10);
        }
        if ((object2 = b.z(this.a).X0()) == null) {
            object2 = b.A(this.a);
            Context context = this.a.requireContext();
            ((i2)object2).w(context);
            object2 = g.o(this.a.getResources(), n10);
        } else {
            object2 = b.B(this.a).X0().y();
        }
        bl2 = ((String)object2).equals(object);
        if (bl2) {
            return;
        }
        b.C(this.a).f4((String)object);
    }

    public void b() {
        b.x(this.a).f(1);
        Context context = this.a.requireContext();
        BackEditText backEditText = b.y((b)this.a).a;
        v1.d(context, (View)backEditText);
    }
}

