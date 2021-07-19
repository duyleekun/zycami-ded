/*
 * Decompiled with CFR 0.151.
 */
package i.d.p;

import i.d.p.a;
import i.d.p.b;
import i.d.p.c;
import i.d.p.f;
import i.d.p.g$a;
import i.d.p.h;
import i.d.p.i;
import i.d.p.j;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.java_websocket.enums.Opcode;

public abstract class g
implements f {
    private boolean a;
    private Opcode b;
    private ByteBuffer c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;

    public g(Opcode object) {
        this.b = object;
        object = i.d.u.b.a();
        this.c = object;
        this.a = true;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
    }

    public static g i(Opcode object) {
        if (object != null) {
            int[] nArray = g$a.a;
            int n10 = ((Enum)object).ordinal();
            n10 = nArray[n10];
            switch (n10) {
                default: {
                    object = new IllegalArgumentException("Supplied opcode is invalid");
                    throw object;
                }
                case 6: {
                    object = new c();
                    return object;
                }
                case 5: {
                    object = new b();
                    return object;
                }
                case 4: {
                    object = new a();
                    return object;
                }
                case 3: {
                    object = new j();
                    return object;
                }
                case 2: {
                    object = new i();
                    return object;
                }
                case 1: 
            }
            object = new h();
            return object;
        }
        object = new IllegalArgumentException("Supplied opcode cannot be null");
        throw object;
    }

    public boolean a() {
        return this.d;
    }

    public boolean b() {
        return this.e;
    }

    public boolean c() {
        return this.f;
    }

    public Opcode d() {
        return this.b;
    }

    public boolean e() {
        return this.g;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            object = (g)object;
            boolean bl3 = this.a;
            boolean bl4 = ((g)object).a;
            if (bl3 != bl4) {
                return false;
            }
            bl3 = this.d;
            bl4 = ((g)object).d;
            if (bl3 != bl4) {
                return false;
            }
            bl3 = this.e;
            bl4 = ((g)object).e;
            if (bl3 != bl4) {
                return false;
            }
            bl3 = this.f;
            bl4 = ((g)object).f;
            if (bl3 != bl4) {
                return false;
            }
            bl3 = this.g;
            bl4 = ((g)object).g;
            if (bl3 != bl4) {
                return false;
            }
            object3 = this.b;
            object2 = ((g)object).b;
            if (object3 != object2) {
                return false;
            }
            object3 = this.c;
            object = ((g)object).c;
            if (object3 != null) {
                bl2 = ((ByteBuffer)object3).equals(object);
            } else if (object != null) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public boolean f() {
        return this.a;
    }

    public ByteBuffer g() {
        return this.c;
    }

    public void h(f f10) {
        boolean bl2;
        ByteBuffer byteBuffer = f10.g();
        ByteBuffer byteBuffer2 = this.c;
        if (byteBuffer2 == null) {
            int n10 = byteBuffer.remaining();
            this.c = byteBuffer2 = ByteBuffer.allocate(n10);
            byteBuffer.mark();
            byteBuffer2 = this.c;
            byteBuffer2.put(byteBuffer);
            byteBuffer.reset();
        } else {
            byteBuffer.mark();
            byteBuffer2 = this.c;
            int n11 = byteBuffer2.limit();
            byteBuffer2.position(n11);
            byteBuffer2 = this.c;
            n11 = byteBuffer2.capacity();
            byteBuffer2.limit(n11);
            int n12 = byteBuffer.remaining();
            ByteBuffer byteBuffer3 = this.c;
            n11 = byteBuffer3.remaining();
            if (n12 > n11) {
                n12 = byteBuffer.remaining();
                n11 = this.c.capacity();
                byteBuffer2 = ByteBuffer.allocate(n12 += n11);
                this.c.flip();
                byteBuffer3 = this.c;
                byteBuffer2.put(byteBuffer3);
                byteBuffer2.put(byteBuffer);
                this.c = byteBuffer2;
            } else {
                byteBuffer2 = this.c;
                byteBuffer2.put(byteBuffer);
            }
            byteBuffer2 = this.c;
            byteBuffer2.rewind();
            byteBuffer.reset();
        }
        this.a = bl2 = f10.f();
    }

    public int hashCode() {
        int n10 = this.a * 31;
        int n11 = this.b.hashCode();
        n10 = (n10 + n11) * 31;
        ByteBuffer byteBuffer = this.c;
        if (byteBuffer != null) {
            n11 = byteBuffer.hashCode();
        } else {
            n11 = 0;
            byteBuffer = null;
        }
        n10 = (n10 + n11) * 31;
        n11 = (int)(this.d ? 1 : 0);
        n10 = (n10 + n11) * 31;
        n11 = (int)(this.e ? 1 : 0);
        n10 = (n10 + n11) * 31;
        n11 = (int)(this.f ? 1 : 0);
        n10 = (n10 + n11) * 31;
        n11 = (int)(this.g ? 1 : 0);
        return n10 + n11;
    }

    public abstract void j();

    public void k(boolean bl2) {
        this.a = bl2;
    }

    public void l(ByteBuffer byteBuffer) {
        this.c = byteBuffer;
    }

    public void m(boolean bl2) {
        this.e = bl2;
    }

    public void n(boolean bl2) {
        this.f = bl2;
    }

    public void o(boolean bl2) {
        this.g = bl2;
    }

    public void p(boolean bl2) {
        this.d = bl2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Framedata{ optcode:");
        Object object = this.d();
        stringBuilder.append(object);
        stringBuilder.append(", fin:");
        int n10 = this.f();
        stringBuilder.append(n10 != 0);
        stringBuilder.append(", rsv1:");
        n10 = this.b();
        stringBuilder.append(n10 != 0);
        stringBuilder.append(", rsv2:");
        n10 = this.c();
        stringBuilder.append(n10 != 0);
        stringBuilder.append(", rsv3:");
        n10 = this.e();
        stringBuilder.append(n10 != 0);
        stringBuilder.append(", payloadlength:[pos:");
        n10 = this.c.position();
        stringBuilder.append(n10);
        stringBuilder.append(", len:");
        n10 = this.c.remaining();
        stringBuilder.append(n10);
        stringBuilder.append("], payload:");
        object = this.c;
        n10 = ((Buffer)object).remaining();
        int n11 = 1000;
        if (n10 > n11) {
            object = "(too big to display)";
        } else {
            byte[] byArray = this.c.array();
            object = new String(byArray);
        }
        stringBuilder.append((String)object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

