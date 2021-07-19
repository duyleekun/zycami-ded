/*
 * Decompiled with CFR 0.151.
 */
package i.d.p;

import i.d.p.e;
import i.d.u.c;
import java.nio.ByteBuffer;
import org.java_websocket.enums.Opcode;
import org.java_websocket.exceptions.InvalidDataException;

public class j
extends e {
    public j() {
        Opcode opcode = Opcode.TEXT;
        super(opcode);
    }

    public void j() {
        super.j();
        Object object = this.g();
        boolean bl2 = c.b((ByteBuffer)object);
        if (bl2) {
            return;
        }
        object = new InvalidDataException(1007, "Received text is no valid utf8 string!");
        throw object;
    }
}

