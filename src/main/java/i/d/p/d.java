/*
 * Decompiled with CFR 0.151.
 */
package i.d.p;

import i.d.p.g;
import org.java_websocket.enums.Opcode;
import org.java_websocket.exceptions.InvalidFrameException;

public abstract class d
extends g {
    public d(Opcode opcode) {
        super(opcode);
    }

    public void j() {
        boolean bl2 = this.f();
        if (bl2) {
            bl2 = this.b();
            if (!bl2) {
                bl2 = this.c();
                if (!bl2) {
                    bl2 = this.e();
                    if (!bl2) {
                        return;
                    }
                    InvalidFrameException invalidFrameException = new InvalidFrameException("Control frame cant have rsv3==true set");
                    throw invalidFrameException;
                }
                InvalidFrameException invalidFrameException = new InvalidFrameException("Control frame cant have rsv2==true set");
                throw invalidFrameException;
            }
            InvalidFrameException invalidFrameException = new InvalidFrameException("Control frame cant have rsv1==true set");
            throw invalidFrameException;
        }
        InvalidFrameException invalidFrameException = new InvalidFrameException("Control frame cant have fin==false set");
        throw invalidFrameException;
    }
}

