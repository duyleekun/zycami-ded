/*
 * Decompiled with CFR 0.151.
 */
package i.d.p;

import i.d.p.d;
import i.d.u.c;
import java.nio.ByteBuffer;
import org.java_websocket.enums.Opcode;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;

public class b
extends d {
    public static final int A = 253;
    public static final int j = 1000;
    public static final int k = 1001;
    public static final int l = 1002;
    public static final int m = 1003;
    public static final int n = 1005;
    public static final int o = 1006;
    public static final int p = 1007;
    public static final int q = 1008;
    public static final int r = 1009;
    public static final int s = 1010;
    public static final int t = 1011;
    public static final int u = 1012;
    public static final int v = 1013;
    public static final int w = 1014;
    public static final int x = 1015;
    public static final int y = 255;
    public static final int z = 254;
    private int h;
    private String i;

    public b() {
        Opcode opcode = Opcode.CLOSING;
        super(opcode);
        this.t("");
        this.s(1000);
    }

    private void u() {
        byte[] byArray = c.h(this.i);
        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
        int n10 = this.h;
        byteBuffer.putInt(n10);
        n10 = 2;
        byteBuffer.position(n10);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(byArray.length + n10);
        byteBuffer2.put(byteBuffer);
        byteBuffer2.put(byArray);
        byteBuffer2.rewind();
        super.l(byteBuffer2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void v(ByteBuffer byteBuffer, int n10) {
        Throwable throwable2222222;
        block4: {
            String string2;
            int n11 = byteBuffer.position() + 2;
            byteBuffer.position(n11);
            this.i = string2 = c.f(byteBuffer);
            {
                catch (Throwable throwable2222222) {
                    break block4;
                }
                catch (IllegalArgumentException illegalArgumentException) {}
                {
                    int n12 = 1007;
                    InvalidDataException invalidDataException = new InvalidDataException(n12);
                    throw invalidDataException;
                }
            }
            byteBuffer.position(n10);
            return;
        }
        byteBuffer.position(n10);
        throw throwable2222222;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Object object2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object2 = this.getClass()) == (clazz = object.getClass())) {
            int n10 = super.equals(object);
            if (n10 == 0) {
                return false;
            }
            object = (b)object;
            n10 = this.h;
            int n11 = ((b)object).h;
            if (n10 != n11) {
                return false;
            }
            object2 = this.i;
            object = ((b)object).i;
            if (object2 != null) {
                bl2 = ((String)object2).equals(object);
            } else if (object != null) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public ByteBuffer g() {
        int n10 = this.h;
        int n11 = 1005;
        if (n10 == n11) {
            return i.d.u.b.a();
        }
        return super.g();
    }

    public int hashCode() {
        int n10 = super.hashCode() * 31;
        int n11 = this.h;
        n10 = (n10 + n11) * 31;
        String string2 = this.i;
        if (string2 != null) {
            n11 = string2.hashCode();
        } else {
            n11 = 0;
            string2 = null;
        }
        return n10 + n11;
    }

    public void j() {
        int n10;
        Object object;
        super.j();
        int n11 = this.h;
        int n12 = 1007;
        if (n11 == n12 && (n11 = (int)(((String)(object = this.i)).isEmpty() ? 1 : 0)) != 0) {
            object = new InvalidDataException(n12, "Received text is no valid utf8 string!");
            throw object;
        }
        n11 = this.h;
        n12 = 1002;
        int n13 = 1005;
        if (n11 == n13 && (n11 = ((String)(object = this.i)).length()) > 0) {
            object = new InvalidDataException(n12, "A close frame must have a closecode if it has a reason");
            throw object;
        }
        n11 = this.h;
        int n14 = 1015;
        if (n11 > n14 && n11 < (n10 = 3000)) {
            object = new InvalidDataException(n12, "Trying to send an illegal close code!");
            throw object;
        }
        n12 = 1006;
        if (n11 != n12 && n11 != n14 && n11 != n13 && n11 <= (n12 = 4999) && n11 >= (n12 = 1000) && n11 != (n12 = 1004)) {
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("closecode must not be sent over the wire: ");
        n13 = this.h;
        charSequence.append(n13);
        charSequence = charSequence.toString();
        object = new InvalidFrameException((String)charSequence);
        throw object;
    }

    public void l(ByteBuffer byteBuffer) {
        this.h = 1005;
        Object object = "";
        this.i = object;
        byteBuffer.mark();
        int n10 = byteBuffer.remaining();
        if (n10 == 0) {
            int n11;
            this.h = n11 = 1000;
        } else {
            int n12;
            n10 = byteBuffer.remaining();
            if (n10 == (n12 = 1)) {
                int n13;
                this.h = n13 = 1002;
            } else {
                n10 = byteBuffer.remaining();
                if (n10 >= (n12 = 2)) {
                    object = ByteBuffer.allocate(4);
                    ((ByteBuffer)object).position(n12);
                    n12 = byteBuffer.getShort();
                    ((ByteBuffer)object).putShort((short)n12);
                    n12 = 0;
                    ((ByteBuffer)object).position(0);
                    this.h = n10 = ((ByteBuffer)object).getInt();
                }
                byteBuffer.reset();
                n10 = byteBuffer.position();
                try {
                    this.v(byteBuffer, n10);
                }
                catch (InvalidDataException invalidDataException) {
                    this.h = 1007;
                    boolean bl2 = false;
                    byteBuffer = null;
                    this.i = null;
                }
            }
        }
    }

    public int q() {
        return this.h;
    }

    public String r() {
        return this.i;
    }

    public void s(int n10) {
        this.h = n10;
        int n11 = 1015;
        if (n10 == n11) {
            String string2;
            this.h = n10 = 1005;
            this.i = string2 = "";
        }
        this.u();
    }

    public void t(String string2) {
        if (string2 == null) {
            string2 = "";
        }
        this.i = string2;
        this.u();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = super.toString();
        stringBuilder.append(string2);
        stringBuilder.append("code: ");
        int n10 = this.h;
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }
}

