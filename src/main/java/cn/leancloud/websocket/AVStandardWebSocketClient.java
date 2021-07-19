/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.websocket;

import cn.leancloud.AVLogger;
import cn.leancloud.command.CommandPacket;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import cn.leancloud.websocket.AVStandardWebSocketClient$1;
import cn.leancloud.websocket.AVStandardWebSocketClient$2;
import cn.leancloud.websocket.AVStandardWebSocketClient$WebSocketClientMonitor;
import cn.leancloud.websocket.HeartBeatPolicy;
import com.google.protobuf.AbstractMessageLite;
import i.d.f;
import i.d.p.h;
import i.d.s.b;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.net.SocketFactory;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class AVStandardWebSocketClient
extends i.d.m.b {
    private static final String HEADER_SUB_PROTOCOL = "Sec-WebSocket-Protocol";
    private static final int PING_TIMEOUT_CODE = 3000;
    public static final String SUB_PROTOCOL_2_1 = "lc.protobuf2.1";
    public static final String SUB_PROTOCOL_2_3 = "lc.protobuf2.3";
    private static final AVLogger gLogger;
    private static ArrayList protocols;
    private HeartBeatPolicy heartBeatPolicy;
    private AVStandardWebSocketClient$WebSocketClientMonitor socketClientMonitor;
    private SSLSocketFactory socketFactory;

    static {
        ArrayList<b> arrayList;
        gLogger = LogUtil.getLogger(AVStandardWebSocketClient.class);
        protocols = arrayList = new ArrayList<b>();
        b b10 = new b(SUB_PROTOCOL_2_3);
        arrayList.add(b10);
    }

    public AVStandardWebSocketClient(URI object, String string2, boolean bl2, boolean bl3, SSLSocketFactory sSLSocketFactory, int n10, AVStandardWebSocketClient$WebSocketClientMonitor aVStandardWebSocketClient$WebSocketClientMonitor) {
        Object object2 = Collections.emptyList();
        ArrayList arrayList = protocols;
        i.d.n.b b10 = new i.d.n.b((List)object2, arrayList);
        object2 = new AVStandardWebSocketClient$1(string2);
        super((URI)object, b10, (Map)object2, n10);
        this.socketFactory = sSLSocketFactory;
        this.heartBeatPolicy = object = new AVStandardWebSocketClient$2(this);
        this.socketClientMonitor = aVStandardWebSocketClient$WebSocketClientMonitor;
        if (bl2) {
            this.setSocket(bl3);
        }
    }

    /*
     * Unable to fully structure code
     */
    private void setSocket(boolean var1_1) {
        block30: {
            block31: {
                var2_2 = this.getURI();
                var2_2 = var2_2.toString();
                var3_3 = StringUtil.isEmpty((String)var2_2);
                if (var3_3) break block30;
                var4_4 = "wss";
                var5_5 = var2_2.startsWith((String)var4_4);
                if (!var5_5) ** GOTO lbl70
                var2_2 = this.socketFactory;
                if (var2_2 == null) ** GOTO lbl70
                var2_2 = var2_2.createSocket();
                if (!var1_1) break block31;
                var6_6 = "javax.net.ssl.SNIHostName";
                var6_6 = Class.forName((String)var6_6);
                var4_4 = "javax.net.ssl.SSLSocket";
                var4_4 = Class.forName((String)var4_4);
                if (var6_6 == null || var4_4 == null || !(var1_1 = var2_2 instanceof SSLSocket)) break block31;
                var4_4 = this.getURI();
                var4_4 = var4_4.getHost();
                var6_6 = new SNIHostName((String)var4_4);
                var7_9 = 1;
                var4_4 = new ArrayList(var7_9);
                var4_4.add(var6_6);
                var6_6 = var2_2;
                var6_6 = (SSLSocket)var2_2;
                var6_6 = var6_6.getSSLParameters();
                var6_6.setServerNames((List<SNIServerName>)var4_4);
                var4_4 = var2_2;
                var4_4 = (SSLSocket)var2_2;
                try {
                    var4_4.setSSLParameters((SSLParameters)var6_6);
                }
                catch (Exception var6_7) {
                    var4_4 = AVStandardWebSocketClient.gLogger;
                    var8_10 = new StringBuilder();
                    var9_11 = "failed to init SSLSocket. cause: ";
                    var8_10.append(var9_11);
                    var6_6 = var6_7.getMessage();
                    var8_10.append((String)var6_6);
                    var6_6 = var8_10.toString();
                    var4_4.w((String)var6_6);
                }
            }
            this.setSocket((Socket)var2_2);
            break block30;
lbl70:
            // 2 sources

            var6_6 = SocketFactory.getDefault();
            var6_6 = var6_6.createSocket();
            this.setSocket((Socket)var6_6);
            {
                catch (Exception var6_8) {
                    var2_2 = AVStandardWebSocketClient.gLogger;
                    var4_4 = "Socket Initializer Error";
                    var2_2.e((String)var4_4, var6_8);
                }
            }
        }
    }

    public void close() {
        this.socketClientMonitor = null;
        this.heartBeatPolicy.stop();
        super.close();
    }

    public void onClose(int n10, String string2, boolean bl2) {
        Object object = gLogger;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("onClose socket=");
        charSequence.append(this);
        charSequence.append(", code=");
        charSequence.append(n10);
        String string3 = ", message=";
        charSequence.append(string3);
        charSequence.append(string2);
        charSequence = charSequence.toString();
        ((AVLogger)object).d((String)charSequence);
        this.heartBeatPolicy.stop();
        object = this.socketClientMonitor;
        if (object != null) {
            object.onClose(this, n10, string2, bl2);
        }
    }

    public void onError(Exception exception) {
        Object object = gLogger;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("onError socket=");
        charSequence.append(this);
        charSequence.append(", exception=");
        String string2 = exception.getMessage();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        ((AVLogger)object).w((String)charSequence);
        object = this.socketClientMonitor;
        if (object != null) {
            object.onError(this, exception);
        }
    }

    public void onMessage(String object) {
        AVStandardWebSocketClient$WebSocketClientMonitor aVStandardWebSocketClient$WebSocketClientMonitor = this.socketClientMonitor;
        if (aVStandardWebSocketClient$WebSocketClientMonitor != null) {
            object = ByteBuffer.wrap(((String)object).getBytes());
            aVStandardWebSocketClient$WebSocketClientMonitor.onMessage(this, (ByteBuffer)object);
        }
    }

    public void onMessage(ByteBuffer byteBuffer) {
        AVStandardWebSocketClient$WebSocketClientMonitor aVStandardWebSocketClient$WebSocketClientMonitor = this.socketClientMonitor;
        if (aVStandardWebSocketClient$WebSocketClientMonitor != null) {
            aVStandardWebSocketClient$WebSocketClientMonitor.onMessage(this, byteBuffer);
        }
    }

    public void onOpen(i.d.q.h object) {
        AVLogger aVLogger = gLogger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onOpen socket=");
        stringBuilder.append(this);
        stringBuilder.append(", status=");
        short s10 = object.b();
        stringBuilder.append(s10);
        String string2 = ", statusMsg=";
        stringBuilder.append(string2);
        object = object.c();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        aVLogger.d((String)object);
        this.heartBeatPolicy.start();
        object = this.socketClientMonitor;
        if (object != null) {
            object.onOpen(this);
        }
    }

    public void onWebsocketPong(f f10, i.d.p.f f11) {
        super.onWebsocketPong(f10, f11);
        this.heartBeatPolicy.onPong();
        gLogger.d("onWebsocketPong()");
    }

    public void ping() {
        gLogger.d("send ping packet");
        h h10 = new h();
        this.sendFrame(h10);
    }

    public void send(CommandPacket object) {
        AVLogger aVLogger = gLogger;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("client(");
        charSequence.append(this);
        charSequence.append(") uplink : ");
        String string2 = ((CommandPacket)object).getGenericCommand().toString();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        aVLogger.d((String)charSequence);
        object = ((CommandPacket)object).getGenericCommand();
        object = ((AbstractMessageLite)object).toByteArray();
        try {
            this.send((byte[])object);
        }
        catch (Exception exception) {
            aVLogger = gLogger;
            String string3 = exception.getMessage();
            aVLogger.e(string3);
        }
    }
}

