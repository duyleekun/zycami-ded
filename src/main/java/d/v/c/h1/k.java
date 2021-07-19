/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLongClickListener
 */
package d.v.c.h1;

import android.view.View;
import d.v.c.h1.s;

public final class k
implements View.OnLongClickListener {
    public final /* synthetic */ s a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ k(s s10, int n10, Object object) {
        this.a = s10;
        this.b = n10;
        this.c = object;
    }

    public final boolean onLongClick(View view) {
        s s10 = this.a;
        int n10 = this.b;
        Object object = this.c;
        return s10.m(n10, object, view);
    }
}

