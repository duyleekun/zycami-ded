/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 */
package d.c.a.o.m.f;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import d.c.a.o.k.o;
import d.c.a.o.k.s;
import d.c.a.o.m.h.c;
import d.c.a.u.k;

public abstract class b
implements s,
o {
    public final Drawable a;

    public b(Drawable drawable2) {
        this.a = drawable2 = (Drawable)k.d(drawable2);
    }

    public void a() {
        Drawable drawable2 = this.a;
        boolean bl2 = drawable2 instanceof BitmapDrawable;
        if (bl2) {
            drawable2 = ((BitmapDrawable)drawable2).getBitmap();
            drawable2.prepareToDraw();
        } else {
            bl2 = drawable2 instanceof c;
            if (bl2) {
                drawable2 = ((c)drawable2).e();
                drawable2.prepareToDraw();
            }
        }
    }

    public final Drawable c() {
        Drawable.ConstantState constantState = this.a.getConstantState();
        if (constantState == null) {
            return this.a;
        }
        return constantState.newDrawable();
    }
}

