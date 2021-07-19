/*
 * Decompiled with CFR 0.151.
 */
package i.d.q;

import i.d.q.b;
import i.d.q.g;

public class d
extends g
implements b {
    private String c = "*";

    public void g(String object) {
        if (object != null) {
            this.c = object;
            return;
        }
        object = new IllegalArgumentException("http resource descriptor must not be null");
        throw object;
    }

    public String getResourceDescriptor() {
        return this.c;
    }
}

