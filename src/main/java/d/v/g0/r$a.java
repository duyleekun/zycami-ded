/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Outline
 *  android.view.View
 *  android.view.ViewOutlineProvider
 */
package d.v.g0;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import d.v.g0.r;

public class r$a
extends ViewOutlineProvider {
    public final /* synthetic */ float a;
    public final /* synthetic */ r b;

    public r$a(r r10, float f10) {
        this.b = r10;
        this.a = f10;
    }

    public void getOutline(View view, Outline outline) {
        int n10 = view.getWidth();
        int n11 = view.getHeight();
        float f10 = this.a;
        outline.setRoundRect(0, 0, n10, n11, f10);
    }
}

