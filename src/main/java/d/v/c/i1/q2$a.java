/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Outline
 *  android.view.View
 *  android.view.ViewOutlineProvider
 */
package d.v.c.i1;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import d.v.c.i1.q2;

public class q2$a
extends ViewOutlineProvider {
    public final /* synthetic */ q2 a;

    public q2$a(q2 q22) {
        this.a = q22;
    }

    public void getOutline(View view, Outline outline) {
        int n10 = view.getWidth();
        int n11 = view.getHeight();
        outline.setOval(0, 0, n10, n11);
    }
}

