/*
 * Decompiled with CFR 0.151.
 */
package i.d;

import i.d.n.a;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.Collection;
import javax.net.ssl.SSLSession;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.ReadyState;

public interface f {
    public void close();

    public void close(int var1);

    public void close(int var1, String var2);

    public void closeConnection(int var1, String var2);

    public Object getAttachment();

    public a getDraft();

    public InetSocketAddress getLocalSocketAddress();

    public ReadyState getReadyState();

    public InetSocketAddress getRemoteSocketAddress();

    public String getResourceDescriptor();

    public SSLSession getSSLSession();

    public boolean hasBufferedData();

    public boolean hasSSLSupport();

    public boolean isClosed();

    public boolean isClosing();

    public boolean isFlushAndClose();

    public boolean isOpen();

    public void send(String var1);

    public void send(ByteBuffer var1);

    public void send(byte[] var1);

    public void sendFragmentedFrame(Opcode var1, ByteBuffer var2, boolean var3);

    public void sendFrame(i.d.p.f var1);

    public void sendFrame(Collection var1);

    public void sendPing();

    public void setAttachment(Object var1);
}

