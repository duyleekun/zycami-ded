/*
 * Decompiled with CFR 0.151.
 */
package i.d.p;

import i.d.p.d;
import i.d.p.g;
import i.d.p.h;
import java.nio.ByteBuffer;
import org.java_websocket.enums.Opcode;

public class i
extends d {
    public i() {
        Opcode opcode = Opcode.PONG;
        super(opcode);
    }

    public i(h object) {
        Opcode opcode = Opcode.PONG;
        super(opcode);
        object = ((g)object).g();
        this.l((ByteBuffer)object);
    }
}

