/*
 * Decompiled with CFR 0.151.
 */
package i.d.t;

import i.d.g;
import i.d.i;
import i.d.j;
import i.d.k;
import i.d.n.a;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.List;

public class c
implements k {
    public i a(g g10, List list) {
        i i10 = new i((j)g10, list);
        return i10;
    }

    public i b(g g10, a a10) {
        i i10 = new i((j)g10, a10);
        return i10;
    }

    public void close() {
    }

    public SocketChannel d(SocketChannel socketChannel, SelectionKey selectionKey) {
        return socketChannel;
    }
}

