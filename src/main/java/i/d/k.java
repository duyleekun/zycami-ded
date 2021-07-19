/*
 * Decompiled with CFR 0.151.
 */
package i.d;

import i.d.g;
import i.d.h;
import i.d.i;
import i.d.n.a;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.List;

public interface k
extends h {
    public i a(g var1, List var2);

    public i b(g var1, a var2);

    public ByteChannel c(SocketChannel var1, SelectionKey var2);

    public void close();
}

