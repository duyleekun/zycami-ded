/*
 * Decompiled with CFR 0.151.
 */
package i.d;

import i.d.l;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SocketChannel;

public class b
implements l {
    private final ByteChannel a;

    public b(l l10) {
        this.a = l10;
    }

    public b(ByteChannel byteChannel) {
        this.a = byteChannel;
    }

    public int A(ByteBuffer byteBuffer) {
        int n10;
        ByteChannel byteChannel = this.a;
        boolean bl2 = byteChannel instanceof l;
        if (bl2) {
            byteChannel = (l)byteChannel;
            n10 = byteChannel.A(byteBuffer);
        } else {
            n10 = 0;
            byteBuffer = null;
        }
        return n10;
    }

    public boolean F() {
        boolean bl2;
        ByteChannel byteChannel = this.a;
        boolean bl3 = byteChannel instanceof l;
        if (bl3 && (bl2 = (byteChannel = (l)byteChannel).F())) {
            bl2 = true;
        } else {
            bl2 = false;
            byteChannel = null;
        }
        return bl2;
    }

    public boolean H() {
        boolean bl2;
        ByteChannel byteChannel = this.a;
        boolean bl3 = byteChannel instanceof l;
        if (bl3 && (bl2 = (byteChannel = (l)byteChannel).H())) {
            bl2 = true;
        } else {
            bl2 = false;
            byteChannel = null;
        }
        return bl2;
    }

    public void close() {
        this.a.close();
    }

    public boolean f() {
        ByteChannel byteChannel = this.a;
        boolean bl2 = byteChannel instanceof SocketChannel;
        if (bl2) {
            return ((SocketChannel)byteChannel).isBlocking();
        }
        bl2 = byteChannel instanceof l;
        if (bl2) {
            return ((l)byteChannel).f();
        }
        return false;
    }

    public boolean isOpen() {
        return this.a.isOpen();
    }

    public int read(ByteBuffer byteBuffer) {
        return this.a.read(byteBuffer);
    }

    public int write(ByteBuffer byteBuffer) {
        return this.a.write(byteBuffer);
    }

    public void y() {
        ByteChannel byteChannel = this.a;
        boolean bl2 = byteChannel instanceof l;
        if (bl2) {
            byteChannel = (l)byteChannel;
            byteChannel.y();
        }
    }
}

