/*
 * Decompiled with CFR 0.151.
 */
package b.a.b.w1;

import androidx.camera.core.impl.DeferrableSurface;

public final class f
implements Runnable {
    public final /* synthetic */ DeferrableSurface a;
    public final /* synthetic */ String b;

    public /* synthetic */ f(DeferrableSurface deferrableSurface, String string2) {
        this.a = deferrableSurface;
        this.b = string2;
    }

    public final void run() {
        DeferrableSurface deferrableSurface = this.a;
        String string2 = this.b;
        deferrableSurface.d(string2);
    }
}

