/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.view.View
 *  android.widget.Button
 */
package d.v.g0;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.zhiyun.ui.R$color;
import d.v.e.l.o1;
import d.v.f.g.b;
import d.v.g0.k;
import d.v.g0.l;

public final class k$c {
    public final /* synthetic */ k a;

    public k$c(k k10) {
        this.a = k10;
    }

    public void a() {
        Button button;
        int n10;
        String string2 = this.a.G();
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        Object object = k.F((k)this.a).k;
        if (n11 != 0) {
            n10 = 8;
        } else {
            n10 = 0;
            button = null;
        }
        object.setVisibility(n10);
        n11 = n11 != 0 ? R$color.dialog_color_positive_unable : R$color.dialog_color_positive;
        object = k.F((k)this.a).g;
        button = k.F((k)this.a).g;
        n11 = o1.e((View)button, n11);
        object.setTextColor(n11);
        Object object2 = k.E(this.a);
        n11 = (int)(((l)object2).d() ? 1 : 0);
        if (n11 != 0) {
            object2 = k.F((k)this.a).i;
            object = new StringBuilder();
            int n12 = string2.length();
            ((StringBuilder)object).append(n12);
            ((StringBuilder)object).append("/");
            n12 = k.E((k)this.a).u;
            ((StringBuilder)object).append(n12);
            string2 = ((StringBuilder)object).toString();
            object2.setText((CharSequence)string2);
        } else {
            string2 = k.F((k)this.a).i;
            object2 = "";
            string2.setText((CharSequence)object2);
        }
    }

    public void b() {
        k.F((k)this.a).b.setText((CharSequence)"");
    }

    public void c() {
        Object object = k.E(this.a);
        boolean bl2 = ((l)object).g;
        if (!bl2) {
            object = this.a;
            ((b)object).i();
        }
        if ((object = k.E((k)this.a).j) != null) {
            object = k.E((k)this.a).j;
            k k10 = this.a;
            object.a(k10);
        }
    }

    public void d() {
        Object object = k.E(this.a);
        boolean bl2 = ((l)object).c;
        if (!bl2) {
            object = k.E(this.a);
            bl2 = ((l)object).g;
            if (!bl2) {
                object = this.a;
                ((b)object).i();
            }
        }
        if ((object = k.E((k)this.a).l) != null) {
            object = k.E((k)this.a).l;
            k k10 = this.a;
            object.a(k10);
        }
    }
}

