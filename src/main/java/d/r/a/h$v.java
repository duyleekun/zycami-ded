/*
 * Decompiled with CFR 0.151.
 */
package d.r.a;

import d.r.a.g;
import d.r.a.h$w;

public final class h$v
extends h$w {
    public long g = -1;
    private int h;

    public h$v() {
        super(20);
    }

    public final void d(g g10) {
        super.d(g10);
        long l10 = this.g;
        g10.d("undo_msg_v1", l10);
        int n10 = this.h;
        g10.c("undo_msg_type_v1", n10);
    }

    public final void e(g g10) {
        int n10;
        super.e(g10);
        long l10 = this.g;
        this.g = l10 = g10.i("undo_msg_v1", l10);
        this.h = n10 = g10.h("undo_msg_type_v1", 0);
    }

    public final String toString() {
        return "OnUndoMsgCommand";
    }
}

