/*
 * Decompiled with CFR 0.151.
 */
package i.d.n;

import i.d.i;
import i.d.p.c;
import i.d.p.e;
import i.d.p.f;
import i.d.p.g;
import i.d.p.j;
import i.d.q.b;
import i.d.q.d;
import i.d.q.h;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.java_websocket.enums.CloseHandshakeType;
import org.java_websocket.enums.HandshakeState;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.Role;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;

public abstract class a {
    public Role a = null;
    public Opcode b = null;

    private static i.d.q.c A(String[] object, String object2) {
        short s10 = 1;
        Object object3 = object[s10];
        Object[] objectArray = "101";
        boolean bl2 = objectArray.equals(object3);
        int n10 = 2;
        if (bl2) {
            String string2 = "HTTP/1.1";
            object3 = object[0];
            bl2 = string2.equalsIgnoreCase((String)object3);
            if (bl2) {
                object2 = new i.d.q.e();
                s10 = Short.parseShort(object[s10]);
                object2.f(s10);
                object = object[n10];
                object2.h((String)object);
                return object2;
            }
            objectArray = new Object[n10];
            objectArray[0] = object = object[0];
            objectArray[s10] = object2;
            object = String.format("Invalid status line received: %s Status line: %s", objectArray);
            object3 = new InvalidHandshakeException((String)object);
            throw object3;
        }
        objectArray = new Object[n10];
        objectArray[0] = object = object[s10];
        objectArray[s10] = object2;
        object = String.format("Invalid status code received: %s Status line: %s", objectArray);
        object3 = new InvalidHandshakeException((String)object);
        throw object3;
    }

    private static i.d.q.c B(String[] object, String object2) {
        Object object3 = object[0];
        String string2 = "GET";
        boolean bl2 = string2.equalsIgnoreCase((String)object3);
        int n10 = 1;
        int n11 = 2;
        if (bl2) {
            Object[] objectArray = "HTTP/1.1";
            object3 = object[n11];
            bl2 = objectArray.equalsIgnoreCase((String)object3);
            if (bl2) {
                object2 = new d();
                object = object[n10];
                object2.g((String)object);
                return object2;
            }
            objectArray = new Object[n11];
            objectArray[0] = object = object[n11];
            objectArray[n10] = object2;
            object = String.format("Invalid status line received: %s Status line: %s", objectArray);
            object3 = new InvalidHandshakeException((String)object);
            throw object3;
        }
        Object[] objectArray = new Object[n11];
        objectArray[0] = object = object[0];
        objectArray[n10] = object2;
        object = String.format("Invalid request method received: %s Status line: %s", objectArray);
        object3 = new InvalidHandshakeException((String)object);
        throw object3;
    }

    public static ByteBuffer s(ByteBuffer byteBuffer) {
        byte by2;
        int n10 = byteBuffer.remaining();
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(n10);
        byte by3 = 48;
        while ((by2 = byteBuffer.hasRemaining()) != 0) {
            by2 = byteBuffer.get();
            byteBuffer2.put(by2);
            byte by4 = 13;
            if (by3 == by4 && by2 == (by3 = 10)) {
                int n11 = byteBuffer2.position() + -2;
                byteBuffer2.limit(n11);
                byteBuffer2.position(0);
                return byteBuffer2;
            }
            by3 = by2;
        }
        by3 = byteBuffer.position();
        n10 = byteBuffer2.position();
        byteBuffer.position(by3 -= n10);
        return null;
    }

    public static String t(ByteBuffer object) {
        if ((object = i.d.n.a.s((ByteBuffer)object)) == null) {
            boolean bl2 = false;
            object = null;
        } else {
            byte[] byArray = ((ByteBuffer)object).array();
            int n10 = ((Buffer)object).limit();
            object = i.d.u.c.e(byArray, 0, n10);
        }
        return object;
    }

    public static i.d.q.c z(ByteBuffer object, Role object2) {
        Object object3 = i.d.n.a.t((ByteBuffer)object);
        if (object3 != null) {
            int n10 = 3;
            Object object4 = object3.split(" ", n10);
            int n11 = ((String[])object4).length;
            if (n11 == n10) {
                int n12;
                Object object5 = Role.CLIENT;
                object2 = object2 == object5 ? i.d.n.a.A(object4, (String)object3) : i.d.n.a.B(object4, (String)object3);
                object3 = i.d.n.a.t((ByteBuffer)object);
                while (object3 != null && (n12 = object3.length()) > 0) {
                    object4 = ":";
                    n10 = 2;
                    n12 = ((String[])(object3 = object3.split((String)object4, n10))).length;
                    if (n12 == n10) {
                        n12 = 0;
                        object4 = null;
                        object5 = object3[0];
                        n10 = (int)(object2.d((String)object5) ? 1 : 0);
                        String string2 = "";
                        String string3 = "^ +";
                        int n13 = 1;
                        if (n10 != 0) {
                            object5 = object3[0];
                            StringBuilder stringBuilder = new StringBuilder();
                            object4 = object3[0];
                            object4 = object2.j((String)object4);
                            stringBuilder.append((String)object4);
                            object4 = "; ";
                            stringBuilder.append((String)object4);
                            object3 = object3[n13].replaceFirst(string3, string2);
                            stringBuilder.append((String)object3);
                            object3 = stringBuilder.toString();
                            object2.a((String)object5, (String)object3);
                        } else {
                            object4 = object3[0];
                            object3 = object3[n13].replaceFirst(string3, string2);
                            object2.a((String)object4, (String)object3);
                        }
                        object3 = i.d.n.a.t((ByteBuffer)object);
                        continue;
                    }
                    object = new InvalidHandshakeException("not an http header");
                    throw object;
                }
                if (object3 != null) {
                    return object2;
                }
                object = new IncompleteHandshakeException();
                throw object;
            }
            object = new InvalidHandshakeException();
            throw object;
        }
        int n14 = ((Buffer)object).capacity() + 128;
        object2 = new IncompleteHandshakeException(n14);
        throw object2;
    }

    public abstract HandshakeState a(i.d.q.a var1, h var2);

    public abstract HandshakeState b(i.d.q.a var1);

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean c(i.d.q.f object) {
        String string2;
        Object object2 = object.j("Upgrade");
        boolean bl2 = ((String)object2).equalsIgnoreCase(string2 = "websocket");
        if (!bl2) return false;
        object = object.j("Connection");
        object2 = Locale.ENGLISH;
        boolean bl3 = ((String)(object = ((String)object).toLowerCase((Locale)object2))).contains((CharSequence)(object2 = "upgrade"));
        if (!bl3) return false;
        return true;
    }

    public int d(int n10) {
        if (n10 >= 0) {
            return n10;
        }
        InvalidDataException invalidDataException = new InvalidDataException(1002, "Negative count");
        throw invalidDataException;
    }

    public List e(Opcode object, ByteBuffer object2, boolean bl2) {
        Opcode opcode;
        Object object3 = Opcode.BINARY;
        if (object != object3 && object != (opcode = Opcode.TEXT)) {
            object = new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
            throw object;
        }
        opcode = this.b;
        if (opcode != null) {
            object3 = new c();
        } else {
            this.b = object;
            object3 = object == object3 ? new i.d.p.a() : (object == (object3 = Opcode.TEXT) ? new j() : null);
        }
        ((g)object3).l((ByteBuffer)object2);
        ((g)object3).k(bl2);
        try {
            ((e)object3).j();
            this.b = bl2 ? null : object;
        }
        catch (InvalidDataException invalidDataException) {
            object2 = new IllegalArgumentException(invalidDataException);
            throw object2;
        }
        return Collections.singletonList(object3);
    }

    public abstract a f();

    public abstract ByteBuffer g(f var1);

    public abstract List h(String var1, boolean var2);

    public abstract List i(ByteBuffer var1, boolean var2);

    public List j(i.d.q.f f10) {
        return this.m(f10, true);
    }

    public List k(i.d.q.f f10, Role role) {
        return this.j(f10);
    }

    public List l(i.d.q.f f10, Role role, boolean bl2) {
        return this.m(f10, bl2);
    }

    /*
     * WARNING - void declaration
     */
    public List m(i.d.q.f object, boolean bl2) {
        block9: {
            void var2_5;
            ByteBuffer byteBuffer;
            boolean bl3;
            Object object2;
            int n10;
            Object object3;
            block8: {
                block7: {
                    object3 = new StringBuilder(100);
                    n10 = object instanceof i.d.q.a;
                    if (n10 == 0) break block7;
                    ((StringBuilder)object3).append("GET ");
                    object2 = object;
                    object2 = ((i.d.q.a)object).getResourceDescriptor();
                    ((StringBuilder)object3).append((String)object2);
                    object2 = " HTTP/1.1";
                    ((StringBuilder)object3).append((String)object2);
                    break block8;
                }
                n10 = object instanceof h;
                if (n10 == 0) break block9;
                ((StringBuilder)object3).append("HTTP/1.1 101 ");
                object2 = object;
                object2 = ((h)object).c();
                ((StringBuilder)object3).append((String)object2);
            }
            object2 = "\r\n";
            ((StringBuilder)object3).append((String)object2);
            Iterator iterator2 = ((i.d.q.f)object).e();
            while (bl3 = iterator2.hasNext()) {
                String string2 = (String)iterator2.next();
                String string3 = ((i.d.q.f)object).j(string2);
                ((StringBuilder)object3).append(string2);
                string2 = ": ";
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append(string3);
                ((StringBuilder)object3).append((String)object2);
            }
            ((StringBuilder)object3).append((String)object2);
            object3 = i.d.u.c.a(((StringBuilder)object3).toString());
            object = bl2 ? (Object)((i.d.q.f)object).getContent() : null;
            if (object == null) {
                boolean bl4 = false;
                byteBuffer = null;
            } else {
                int n11 = ((Object)object).length;
            }
            n10 = ((Object)object3).length;
            void var2_6 = var2_5 + n10;
            byteBuffer = ByteBuffer.allocate((int)var2_6);
            byteBuffer.put((byte[])object3);
            if (object != null) {
                byteBuffer.put((byte[])object);
            }
            byteBuffer.flip();
            return Collections.singletonList(byteBuffer);
        }
        object = new IllegalArgumentException("unknown role");
        throw object;
    }

    public abstract CloseHandshakeType n();

    public Role o() {
        return this.a;
    }

    public abstract b p(b var1);

    public abstract i.d.q.c q(i.d.q.a var1, i.d.q.i var2);

    public abstract void r(i var1, f var2);

    public String toString() {
        return this.getClass().getSimpleName();
    }

    public int u(i.d.q.f object) {
        Object object2 = "Sec-WebSocket-Version";
        object = object.j((String)object2);
        int n10 = ((String)object).length();
        int n11 = -1;
        if (n10 > 0) {
            try {
                object = ((String)object).trim();
            }
            catch (NumberFormatException numberFormatException) {}
            object2 = new Integer((String)object);
            return (Integer)object2;
        }
        return n11;
    }

    public abstract void v();

    public void w(Role role) {
        this.a = role;
    }

    public abstract List x(ByteBuffer var1);

    public i.d.q.f y(ByteBuffer byteBuffer) {
        Role role = this.a;
        return i.d.n.a.z(byteBuffer, role);
    }
}

