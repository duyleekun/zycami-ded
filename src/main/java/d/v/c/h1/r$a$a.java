/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.h1;

import androidx.recyclerview.widget.DiffUtil$Callback;
import d.v.c.h1.r$a;

public class r$a$a
extends DiffUtil$Callback {
    public final /* synthetic */ r$a a;

    public r$a$a(r$a r$a) {
        this.a = r$a;
    }

    public boolean areContentsTheSame(int n10, int n11) {
        Object e10 = this.a.a.get(n10);
        Object e11 = this.a.b.get(n11);
        return this.a.d.b(e10, e11);
    }

    public boolean areItemsTheSame(int n10, int n11) {
        Object e10 = this.a.a.get(n10);
        Object e11 = this.a.b.get(n11);
        return this.a.d.c(e10, e11);
    }

    public int getNewListSize() {
        return this.a.b.size();
    }

    public int getOldListSize() {
        return this.a.a.size();
    }
}

