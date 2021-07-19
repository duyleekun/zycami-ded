/*
 * Decompiled with CFR 0.151.
 */
package i.d.o;

import i.d.o.c;
import i.d.p.f;
import org.java_websocket.exceptions.InvalidFrameException;

public class b
implements c {
    public c a() {
        b b10 = new b();
        return b10;
    }

    public boolean b(String string2) {
        return true;
    }

    public void c(f f10) {
    }

    public String d() {
        return "";
    }

    public boolean e(String string2) {
        return true;
    }

    public boolean equals(Object clazz) {
        boolean bl2;
        Class<?> clazz2;
        if (this != clazz && (clazz == null || (clazz2 = this.getClass()) != (clazz = clazz.getClass()))) {
            bl2 = false;
            clazz = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public void f(f f10) {
    }

    public void g(f object) {
        boolean bl2 = object.b();
        if (!(bl2 || (bl2 = object.c()) || (bl2 = object.e()))) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bad rsv RSV1: ");
        boolean bl3 = object.b();
        stringBuilder.append(bl3);
        stringBuilder.append(" RSV2: ");
        bl3 = object.c();
        stringBuilder.append(bl3);
        stringBuilder.append(" RSV3: ");
        boolean bl4 = object.e();
        stringBuilder.append(bl4);
        object = stringBuilder.toString();
        InvalidFrameException invalidFrameException = new InvalidFrameException((String)object);
        throw invalidFrameException;
    }

    public String h() {
        return "";
    }

    public int hashCode() {
        return this.getClass().hashCode();
    }

    public void reset() {
    }

    public String toString() {
        return this.getClass().getSimpleName();
    }
}

