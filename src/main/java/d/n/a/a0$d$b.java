/*
 * Decompiled with CFR 0.151.
 */
package d.n.a;

import c.a.l.l;
import d.n.a.a0$a;
import d.n.a.a0$d;
import d.n.a.a0$d$c;
import d.n.a.n0;
import d.n.a.q0.s.c;
import d.n.a.q0.s.c$a;

public final class a0$d$b
implements c$a {
    private Boolean a;
    private Boolean b;
    private n0 c;
    public final /* synthetic */ a0$d d;

    private a0$d$b(a0$d a0$d) {
        this.d = a0$d;
    }

    public /* synthetic */ a0$d$b(a0$d a0$d, a0$a a0$a) {
        this(a0$d);
    }

    public static /* synthetic */ Boolean d(a0$d$b a0$d$b) {
        return a0$d$b.a;
    }

    public static /* synthetic */ n0 e(a0$d$b a0$d$b) {
        return a0$d$b.c;
    }

    public static /* synthetic */ Boolean f(a0$d$b a0$d$b) {
        return a0$d$b.b;
    }

    public c build() {
        Object object = Boolean.class;
        Object object2 = this.a;
        String string2 = " must be set";
        if (object2 != null) {
            object2 = this.b;
            if (object2 != null) {
                object = this.c;
                if (object != null) {
                    object2 = this.d;
                    object = new a0$d$c((a0$d)object2, this, null);
                    return object;
                }
                object2 = new StringBuilder();
                String string3 = n0.class.getCanonicalName();
                ((StringBuilder)object2).append(string3);
                ((StringBuilder)object2).append(string2);
                object2 = ((StringBuilder)object2).toString();
                object = new IllegalStateException((String)object2);
                throw object;
            }
            StringBuilder stringBuilder = new StringBuilder();
            object = ((Class)object).getCanonicalName();
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
            object = stringBuilder.toString();
            object2 = new IllegalStateException((String)object);
            throw object2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        object = ((Class)object).getCanonicalName();
        stringBuilder.append((String)object);
        stringBuilder.append(string2);
        object = stringBuilder.toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    public a0$d$b g(boolean bl2) {
        Boolean bl3;
        this.a = bl3 = (Boolean)l.a(bl2);
        return this;
    }

    public a0$d$b h(n0 n02) {
        this.c = n02 = (n0)l.a(n02);
        return this;
    }

    public a0$d$b i(boolean bl2) {
        Boolean bl3;
        this.b = bl3 = (Boolean)l.a(bl2);
        return this;
    }
}

