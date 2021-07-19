/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.n.a;

import android.content.Context;
import c.a.l.l;
import d.n.a.a0;
import d.n.a.a0$a;
import d.n.a.b;
import d.n.a.b$b;

public final class a0$b
implements b$b {
    private Context a;

    private a0$b() {
    }

    public /* synthetic */ a0$b(a0$a a0$a) {
        this();
    }

    public static /* synthetic */ Context b(a0$b a0$b) {
        return a0$b.a;
    }

    public b build() {
        Object object = this.a;
        if (object != null) {
            object = new a0(this, null);
            return object;
        }
        CharSequence charSequence = new StringBuilder();
        String string2 = Context.class.getCanonicalName();
        charSequence.append(string2);
        charSequence.append(" must be set");
        charSequence = charSequence.toString();
        object = new IllegalStateException((String)charSequence);
        throw object;
    }

    public a0$b c(Context context) {
        this.a = context = (Context)l.a(context);
        return this;
    }
}

