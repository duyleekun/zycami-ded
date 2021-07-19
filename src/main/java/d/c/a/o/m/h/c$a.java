/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 */
package d.c.a.o.m.h;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import d.c.a.o.m.h.c;
import d.c.a.o.m.h.g;

public final class c$a
extends Drawable.ConstantState {
    public final g a;

    public c$a(g g10) {
        this.a = g10;
    }

    public int getChangingConfigurations() {
        return 0;
    }

    public Drawable newDrawable() {
        c c10 = new c(this);
        return c10;
    }

    public Drawable newDrawable(Resources resources) {
        return this.newDrawable();
    }
}

