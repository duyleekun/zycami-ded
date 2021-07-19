/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.animation.Animation
 */
package d.c.a.s.k;

import android.content.Context;
import android.view.animation.Animation;
import d.c.a.s.k.f;
import d.c.a.s.k.f$a;
import d.c.a.s.k.k$a;

public class k
implements f {
    private final k$a a;

    public k(k$a k$a) {
        this.a = k$a;
    }

    public boolean a(Object object, f$a object2) {
        object = object2.getView();
        if (object != null) {
            object.clearAnimation();
            object2 = this.a;
            Context context = object.getContext();
            object2 = object2.a(context);
            object.startAnimation((Animation)object2);
        }
        return false;
    }
}

