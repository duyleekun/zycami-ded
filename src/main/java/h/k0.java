/*
 * Decompiled with CFR 0.151.
 */
package h;

import h.m;
import h.o0;
import java.io.Closeable;
import java.io.Flushable;

public interface k0
extends Closeable,
Flushable {
    public void close();

    public void flush();

    public void t(m var1, long var2);

    public o0 timeout();
}

