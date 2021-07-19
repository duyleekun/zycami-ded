/*
 * Decompiled with CFR 0.151.
 */
package i.d;

import i.d.f;
import i.d.j;
import i.d.p.h;
import i.d.q.a;
import i.d.q.e;
import i.d.q.i;

public abstract class g
implements j {
    private h pingFrame;

    public h onPreparePing(f object) {
        object = this.pingFrame;
        if (object == null) {
            this.pingFrame = object = new h();
        }
        return this.pingFrame;
    }

    public void onWebsocketHandshakeReceivedAsClient(f f10, a a10, i.d.q.h h10) {
    }

    public i onWebsocketHandshakeReceivedAsServer(f object, i.d.n.a a10, a a11) {
        object = new e();
        return object;
    }

    public void onWebsocketHandshakeSentAsClient(f f10, a a10) {
    }

    public void onWebsocketPing(f f10, i.d.p.f f11) {
        f11 = (h)f11;
        i.d.p.i i10 = new i.d.p.i((h)f11);
        f10.sendFrame(i10);
    }

    public void onWebsocketPong(f f10, i.d.p.f f11) {
    }
}

