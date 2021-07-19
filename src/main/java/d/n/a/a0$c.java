/*
 * Decompiled with CFR 0.151.
 */
package d.n.a;

import c.a.l.l;
import d.n.a.a0;
import d.n.a.a0$a;
import d.n.a.a0$d;
import d.n.a.q0.b;
import d.n.a.q0.b$a;

public final class a0$c
implements b$a {
    private String a;
    public final /* synthetic */ a0 b;

    private a0$c(a0 a02) {
        this.b = a02;
    }

    public /* synthetic */ a0$c(a0 a02, a0$a a0$a) {
        this(a02);
    }

    public static /* synthetic */ String b(a0$c a0$c) {
        return a0$c.a;
    }

    public b build() {
        Object object = this.a;
        if (object != null) {
            a0 a02 = this.b;
            object = new a0$d(a02, this, null);
            return object;
        }
        CharSequence charSequence = new StringBuilder();
        String string2 = String.class.getCanonicalName();
        charSequence.append(string2);
        charSequence.append(" must be set");
        charSequence = charSequence.toString();
        object = new IllegalStateException((String)charSequence);
        throw object;
    }

    public a0$c c(String string2) {
        this.a = string2 = (String)l.a(string2);
        return this;
    }
}

