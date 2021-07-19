/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.t0;

import androidx.activity.OnBackPressedCallback;
import d.v.c.s0.h7.t0.b;

public class b$a
extends OnBackPressedCallback {
    public final /* synthetic */ b a;

    public b$a(b b10, boolean bl2) {
        this.a = b10;
        super(bl2);
    }

    public void handleOnBackPressed() {
        b.j(this.a).a();
    }
}

