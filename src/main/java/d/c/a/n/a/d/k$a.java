/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 */
package d.c.a.n.a.d;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import d.c.a.n.a.d.k;
import d.c.a.n.a.d.o;
import d.c.a.o.k.x.e;

public class k$a
extends Drawable.ConstantState {
    public final e a;
    public final o b;

    public k$a(e e10, o o10) {
        this.a = e10;
        this.b = o10;
    }

    public int getChangingConfigurations() {
        return 0;
    }

    public Drawable newDrawable() {
        k k10 = new k(this);
        return k10;
    }

    public Drawable newDrawable(Resources resources) {
        return this.newDrawable();
    }
}

