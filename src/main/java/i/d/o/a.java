/*
 * Decompiled with CFR 0.151.
 */
package i.d.o;

import i.d.o.b;
import i.d.p.d;
import i.d.p.e;
import i.d.p.f;
import org.java_websocket.exceptions.InvalidFrameException;

public abstract class a
extends b {
    public void g(f object) {
        boolean bl2 = object instanceof e;
        String string2 = " RSV3: ";
        String string3 = " RSV2: ";
        String string4 = "bad rsv RSV1: ";
        if (bl2 && ((bl2 = object.c()) || (bl2 = object.e()))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string4);
            boolean bl3 = object.b();
            stringBuilder.append(bl3);
            stringBuilder.append(string3);
            boolean bl4 = object.c();
            stringBuilder.append(bl4);
            stringBuilder.append(string2);
            boolean bl5 = object.e();
            stringBuilder.append(bl5);
            object = stringBuilder.toString();
            InvalidFrameException invalidFrameException = new InvalidFrameException((String)object);
            throw invalidFrameException;
        }
        bl2 = object instanceof d;
        if (bl2 && ((bl2 = object.b()) || (bl2 = object.c()) || (bl2 = object.e()))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string4);
            boolean bl6 = object.b();
            stringBuilder.append(bl6);
            stringBuilder.append(string3);
            boolean bl7 = object.c();
            stringBuilder.append(bl7);
            stringBuilder.append(string2);
            boolean bl8 = object.e();
            stringBuilder.append(bl8);
            object = stringBuilder.toString();
            InvalidFrameException invalidFrameException = new InvalidFrameException((String)object);
            throw invalidFrameException;
        }
    }
}

