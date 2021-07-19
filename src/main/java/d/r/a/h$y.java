/*
 * Decompiled with CFR 0.151.
 */
package d.r.a;

import d.r.a.g;
import d.r.a.o;
import java.util.HashMap;

public final class h$y
extends o {
    public HashMap c;
    public long d;

    public h$y() {
        super(2012);
    }

    public h$y(long l10) {
        this();
        this.d = l10;
    }

    public final void d(g g10) {
        HashMap hashMap = this.c;
        g10.e("ReporterCommand.EXTRA_PARAMS", hashMap);
        long l10 = this.d;
        g10.d("ReporterCommand.EXTRA_REPORTER_TYPE", l10);
    }

    public final void e(g g10) {
        Object object = g10.a;
        if (object == null) {
            object = null;
        } else {
            String string2 = "ReporterCommand.EXTRA_PARAMS";
            object = object.getSerializable(string2);
        }
        object = (HashMap)object;
        this.c = object;
        long l10 = this.d;
        this.d = l10 = g10.i("ReporterCommand.EXTRA_REPORTER_TYPE", l10);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ReporterCommand\uff08");
        long l10 = this.d;
        stringBuilder.append(l10);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

