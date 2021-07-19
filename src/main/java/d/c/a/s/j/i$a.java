/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 */
package d.c.a.s.j;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import d.c.a.s.j.i;

public final class i$a
extends Drawable.ConstantState {
    private final Drawable.ConstantState a;
    public final int b;
    public final int c;

    public i$a(Drawable.ConstantState constantState, int n10, int n11) {
        this.a = constantState;
        this.b = n10;
        this.c = n11;
    }

    public i$a(i$a i$a) {
        Drawable.ConstantState constantState = i$a.a;
        int n10 = i$a.b;
        int n11 = i$a.c;
        this(constantState, n10, n11);
    }

    public int getChangingConfigurations() {
        return 0;
    }

    public Drawable newDrawable() {
        Drawable drawable2 = this.a.newDrawable();
        i i10 = new i(this, drawable2);
        return i10;
    }

    public Drawable newDrawable(Resources resources) {
        resources = this.a.newDrawable(resources);
        i i10 = new i(this, (Drawable)resources);
        return i10;
    }
}

