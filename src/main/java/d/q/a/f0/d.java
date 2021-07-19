/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.q.a.f0;

import android.view.View;
import d.q.a.b0;
import d.q.a.f0.b;
import e.a.g;
import java.util.Objects;

public final class d
implements b0 {
    private final View b;

    private d(View view) {
        this.b = view;
    }

    public static b0 e(View view) {
        Objects.requireNonNull(view, "view == null");
        d d10 = new d(view);
        return d10;
    }

    public g a() {
        View view = this.b;
        b b10 = new b(view);
        return b10;
    }
}

