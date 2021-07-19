/*
 * Decompiled with CFR 0.151.
 */
package i.d;

import i.d.f;
import i.d.p.h;
import i.d.q.a;
import i.d.q.i;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

public interface j {
    public InetSocketAddress getLocalSocketAddress(f var1);

    public InetSocketAddress getRemoteSocketAddress(f var1);

    public h onPreparePing(f var1);

    public void onWebsocketClose(f var1, int var2, String var3, boolean var4);

    public void onWebsocketCloseInitiated(f var1, int var2, String var3);

    public void onWebsocketClosing(f var1, int var2, String var3, boolean var4);

    public void onWebsocketError(f var1, Exception var2);

    public void onWebsocketHandshakeReceivedAsClient(f var1, a var2, i.d.q.h var3);

    public i onWebsocketHandshakeReceivedAsServer(f var1, i.d.n.a var2, a var3);

    public void onWebsocketHandshakeSentAsClient(f var1, a var2);

    public void onWebsocketMessage(f var1, String var2);

    public void onWebsocketMessage(f var1, ByteBuffer var2);

    public void onWebsocketOpen(f var1, i.d.q.f var2);

    public void onWebsocketPing(f var1, i.d.p.f var2);

    public void onWebsocketPong(f var1, i.d.p.f var2);

    public void onWriteDemand(f var1);
}

