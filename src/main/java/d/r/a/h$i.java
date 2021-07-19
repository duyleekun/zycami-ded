/*
 * Decompiled with CFR 0.151.
 */
package d.r.a;

import d.r.a.g;
import d.r.a.o;

public final class h$i
extends o {
    private String c;

    public h$i() {
        super(2013);
    }

    public h$i(String string2) {
        this();
        this.c = string2;
    }

    public final void d(g g10) {
        String string2 = this.c;
        g10.f("MsgArriveCommand.MSG_TAG", string2);
    }

    public final void e(g object) {
        this.c = object = ((g)object).b("MsgArriveCommand.MSG_TAG");
    }
}

