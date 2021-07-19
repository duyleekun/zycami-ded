/*
 * Decompiled with CFR 0.151.
 */
package org.slf4j.helpers;

import i.h.c;
import i.h.d;
import java.io.Serializable;

public abstract class NamedLoggerBase
implements c,
Serializable {
    private static final long serialVersionUID = 7535258609338176893L;
    public String name;

    public String getName() {
        return this.name;
    }

    public Object readResolve() {
        return d.j(this.getName());
    }
}

