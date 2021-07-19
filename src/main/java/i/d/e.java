/*
 * Decompiled with CFR 0.151.
 */
package i.d;

import i.d.i;
import i.d.l;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import org.java_websocket.enums.Role;

public class e {
    private e() {
        IllegalStateException illegalStateException = new IllegalStateException("Utility class");
        throw illegalStateException;
    }

    public static boolean a(i i10, ByteChannel byteChannel) {
        boolean bl2;
        Role role;
        int n10;
        boolean bl3 = false;
        if (i10 == null) {
            return false;
        }
        Object object = (ByteBuffer)i10.b.peek();
        ByteChannel byteChannel2 = null;
        if (object == null) {
            n10 = byteChannel instanceof l;
            if (n10 != 0) {
                byteChannel2 = byteChannel;
                byteChannel2 = (l)byteChannel;
                n10 = (int)(byteChannel2.F() ? 1 : 0);
                if (n10 != 0) {
                    byteChannel2.y();
                }
            }
        } else {
            do {
                byteChannel.write((ByteBuffer)object);
                n10 = ((Buffer)object).remaining();
                if (n10 > 0) {
                    return false;
                }
                i10.b.poll();
            } while ((object = (ByteBuffer)i10.b.peek()) != null);
        }
        if ((n10 = (int)((object = i10.b).isEmpty() ? 1 : 0)) != 0 && (n10 = (int)(i10.isFlushAndClose() ? 1 : 0)) != 0 && (object = i10.getDraft()) != null && (object = i10.getDraft().o()) != null && (object = i10.getDraft().o()) == (role = Role.SERVER)) {
            i10.c();
        }
        if (byteChannel2 == null || !(bl2 = (byteChannel = (l)byteChannel).F())) {
            bl3 = true;
        }
        return bl3;
    }

    public static boolean b(ByteBuffer byteBuffer, i i10, ByteChannel byteChannel) {
        byteBuffer.clear();
        int n10 = byteChannel.read(byteBuffer);
        byteBuffer.flip();
        boolean bl2 = false;
        byteBuffer = null;
        int n11 = -1;
        if (n10 == n11) {
            i10.k();
            return false;
        }
        if (n10 != 0) {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean c(ByteBuffer byteBuffer, i i10, l l10) {
        byteBuffer.clear();
        int n10 = l10.A(byteBuffer);
        byteBuffer.flip();
        int n11 = -1;
        if (n10 == n11) {
            i10.k();
            return false;
        }
        return l10.H();
    }
}

