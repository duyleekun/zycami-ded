/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.animation.Animation
 *  android.view.animation.AnimationUtils
 */
package d.c.a.s.k;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import d.c.a.s.k.k$a;

public class h$b
implements k$a {
    private final int a;

    public h$b(int n10) {
        this.a = n10;
    }

    public Animation a(Context context) {
        int n10 = this.a;
        return AnimationUtils.loadAnimation((Context)context, (int)n10);
    }
}

