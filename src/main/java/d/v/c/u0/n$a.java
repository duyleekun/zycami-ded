/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.widget.ImageView
 */
package d.v.c.u0;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import d.v.c.q0.f.a;
import d.v.c.u0.m;
import d.v.c.u0.n;

public class n$a
implements a {
    private long a;
    public final /* synthetic */ n b;

    public n$a(n n10) {
        this.b = n10;
    }

    public void a(View view) {
        n.x(this.b);
    }

    public void b(View view) {
        m m10 = n.y(this.b);
        view = view.getContext();
        m10.b((Context)view);
        n.x(this.b);
    }

    public void c(RecyclerView object, long l10) {
        long l11;
        long l12 = this.a;
        long l13 = (l12 = Math.abs(l10 - l12)) - (l11 = 1000000L);
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 >= 0) {
            this.a = l10;
            object = n.y(this.b);
            ImageView imageView = n.z((n)this.b).b;
            int n10 = imageView.getHeight();
            ((m)object).s(l10, n10);
        }
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
    }
}

