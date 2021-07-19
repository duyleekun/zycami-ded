/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.view.View
 */
package d.v.c.s0.h7.t0;

import android.text.TextUtils;
import android.view.View;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.c.s0.h7.t0.b;
import d.v.c.s0.h7.u0.l;

public class b$c {
    public final /* synthetic */ b a;

    public b$c(b b10) {
        this.a = b10;
    }

    public void a() {
        Object object = b.l(this.a);
        boolean bl2 = ((l)object).r();
        if (bl2) {
            object = this.a;
            b.m((b)object);
        } else {
            object = this.a;
            b.n((b)object);
        }
    }

    public void b(View object) {
        object = b.k((b)this.a).b.getHint().toString();
        String string2 = b.k((b)this.a).b.getText().toString().trim();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        Object object2 = b.l(this.a);
        boolean bl3 = ((l)object2).r();
        if (bl3 && bl2) {
            object2 = b.l(this.a);
            ((l)object2).z();
        }
        if (!bl2) {
            object = b.k((b)this.a).b.getText().toString().trim();
        }
        string2 = b.k((b)this.a).a.getText().toString().trim();
        object2 = b.p(this.a).o();
        l l10 = b.l(this.a);
        boolean bl4 = l10.r();
        if (bl4) {
            l10 = b.l(this.a);
            l10.A((TemplatePOJO)object2, (String)object, string2);
            object = this.a;
            b.o((b)object);
        } else {
            l10 = b.l(this.a);
            l10.x((TemplatePOJO)object2, (String)object, string2);
            object = this.a;
            b.n((b)object);
        }
    }

    public void c() {
        b.o(this.a);
    }
}

