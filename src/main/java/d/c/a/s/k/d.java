/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.TransitionDrawable
 */
package d.c.a.s.k;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import d.c.a.s.k.f;
import d.c.a.s.k.f$a;

public class d
implements f {
    private final int a;
    private final boolean b;

    public d(int n10, boolean bl2) {
        this.a = n10;
        this.b = bl2;
    }

    public boolean b(Drawable drawable2, f$a f$a) {
        Drawable drawable3 = f$a.c();
        if (drawable3 == null) {
            drawable3 = new ColorDrawable(0);
        }
        Drawable[] drawableArray = new Drawable[2];
        drawableArray[0] = drawable3;
        boolean bl2 = true;
        drawableArray[bl2] = drawable2;
        TransitionDrawable transitionDrawable = new TransitionDrawable(drawableArray);
        int n10 = this.b;
        transitionDrawable.setCrossFadeEnabled(n10 != 0);
        n10 = this.a;
        transitionDrawable.startTransition(n10);
        f$a.b((Drawable)transitionDrawable);
        return bl2;
    }
}

