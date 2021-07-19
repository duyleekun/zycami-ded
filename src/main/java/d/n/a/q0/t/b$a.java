/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.t;

import d.n.a.q0.t.b;
import java.util.UUID;

public class b$a {
    private final UUID a;
    private final byte[] b;
    private final boolean c;

    public b$a(UUID uUID, byte[] byArray, boolean bl2) {
        this.a = uUID;
        this.b = byArray;
        this.c = bl2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[uuid='");
        CharSequence charSequence = d.n.a.q0.t.b.h(this.a);
        stringBuilder.append((String)charSequence);
        boolean bl2 = this.c;
        if (bl2) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("', hexValue=");
            String string2 = d.n.a.q0.t.b.a(this.b);
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
        } else {
            charSequence = "'";
        }
        stringBuilder.append((String)charSequence);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

