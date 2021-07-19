/*
 * Decompiled with CFR 0.151.
 */
package k;

import h.m;
import h.m0;
import h.r;
import java.io.IOException;
import k.l$b;

public class l$b$a
extends r {
    public final /* synthetic */ l$b a;

    public l$b$a(l$b l$b, m0 m02) {
        this.a = l$b;
        super(m02);
    }

    public long read(m m10, long l10) {
        try {
            return super.read(m10, l10);
        }
        catch (IOException iOException) {
            this.a.c = iOException;
            throw iOException;
        }
    }
}

