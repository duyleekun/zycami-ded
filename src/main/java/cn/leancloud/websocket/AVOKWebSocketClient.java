/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.websocket;

import cn.leancloud.AVLogger;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.websocket.AVOKWebSocketClient$1;
import cn.leancloud.websocket.AVOKWebSocketClient$2;
import cn.leancloud.websocket.AVOKWebSocketClient$3;
import cn.leancloud.websocket.AVOKWebSocketClient$Status;
import cn.leancloud.websocket.WsStatusListener;
import g.a0;
import g.a0$a;
import g.f0;
import g.g0;
import g.o;
import g.u;
import g.z;
import g.z$a;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import okio.ByteString;

public class AVOKWebSocketClient {
    private static final int RECONNECT_INTERVAL = 10000;
    private static final long RECONNECT_MAX_TIME = 120000L;
    private static AVLogger gLogger = LogUtil.getLogger(AVOKWebSocketClient.class);
    private z client = null;
    private AVOKWebSocketClient$Status currentStatus;
    private g0 internalSocketListener;
    private boolean isManualClose;
    private boolean isNeedReconnect;
    private Lock lock;
    private int reconnectCount;
    private Timer reconnectTimer;
    private a0 request = null;
    private f0 webSocket = null;
    private WsStatusListener wsStatusListener;

    public AVOKWebSocketClient(WsStatusListener object, boolean bl2) {
        Object object2;
        this.currentStatus = object2 = AVOKWebSocketClient$Status.DISCONNECTED;
        this.reconnectCount = 0;
        this.isManualClose = false;
        this.lock = object2;
        this.wsStatusListener = null;
        boolean bl3 = true;
        Object object3 = new Timer(bl3);
        this.reconnectTimer = object3;
        this.internalSocketListener = object3 = new AVOKWebSocketClient$1(this);
        this.wsStatusListener = object;
        this.isNeedReconnect = bl2;
        object = new z$a();
        Object object4 = TimeUnit.SECONDS;
        object = ((z$a)object).d0(120, (TimeUnit)((Object)object4));
        long l10 = 10;
        object = ((z$a)object).k(l10, (TimeUnit)((Object)object4)).j0(l10, (TimeUnit)((Object)object4)).R0(l10, (TimeUnit)((Object)object4));
        object4 = SSLContext.getDefault();
        object4 = ((SSLContext)object4).getSocketFactory();
        try {
            ((z$a)object).P0((SSLSocketFactory)object4);
        }
        catch (Exception exception) {
            object3 = gLogger;
            ((AVLogger)object3).w(exception);
        }
        object = ((z$a)object).l0(bl3);
        object4 = new AVOKWebSocketClient$2(this);
        this.client = object = ((z$a)object).c((u)object4).f();
    }

    public static /* synthetic */ AVLogger access$000() {
        return gLogger;
    }

    public static /* synthetic */ f0 access$102(AVOKWebSocketClient aVOKWebSocketClient, f0 f02) {
        aVOKWebSocketClient.webSocket = f02;
        return f02;
    }

    public static /* synthetic */ AVOKWebSocketClient$Status access$202(AVOKWebSocketClient aVOKWebSocketClient, AVOKWebSocketClient$Status aVOKWebSocketClient$Status) {
        aVOKWebSocketClient.currentStatus = aVOKWebSocketClient$Status;
        return aVOKWebSocketClient$Status;
    }

    public static /* synthetic */ void access$300(AVOKWebSocketClient aVOKWebSocketClient) {
        aVOKWebSocketClient.connected();
    }

    public static /* synthetic */ WsStatusListener access$400(AVOKWebSocketClient aVOKWebSocketClient) {
        return aVOKWebSocketClient.wsStatusListener;
    }

    public static /* synthetic */ boolean access$500(AVOKWebSocketClient aVOKWebSocketClient) {
        return aVOKWebSocketClient.isManualClose;
    }

    public static /* synthetic */ boolean access$600(AVOKWebSocketClient aVOKWebSocketClient) {
        return aVOKWebSocketClient.tryReconnect();
    }

    public static /* synthetic */ void access$700(AVOKWebSocketClient aVOKWebSocketClient) {
        aVOKWebSocketClient.buildConnect();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void buildConnect() {
        synchronized (this) {
            AVOKWebSocketClient$Status aVOKWebSocketClient$Status = AVOKWebSocketClient$Status.CONNECTED;
            AVOKWebSocketClient$Status aVOKWebSocketClient$Status2 = this.currentStatus;
            if (aVOKWebSocketClient$Status != aVOKWebSocketClient$Status2 && (aVOKWebSocketClient$Status = AVOKWebSocketClient$Status.CONNECTING) != aVOKWebSocketClient$Status2) {
                this.currentStatus = aVOKWebSocketClient$Status;
                this.initWebSocket();
                return;
            }
            return;
        }
    }

    private void cancelReconnect() {
        Timer timer = null;
        this.reconnectCount = 0;
        timer = this.reconnectTimer;
        try {
            timer.cancel();
        }
        catch (Exception exception) {
            AVLogger aVLogger = gLogger;
            aVLogger.w(exception);
        }
    }

    private void connected() {
        this.cancelReconnect();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void initWebSocket() {
        Object object;
        Object object2;
        Object object3;
        try {
            object3 = this.lock;
            object3.lockInterruptibly();
        }
        catch (InterruptedException interruptedException) {
            object2 = gLogger;
            object = "failed to initWebSocket";
            ((AVLogger)object2).w((String)object, interruptedException);
            return;
        }
        try {
            object3 = this.client;
            object3 = ((z)object3).R();
            ((o)object3).b();
            object3 = this.client;
            object2 = this.request;
            object = this.internalSocketListener;
            ((z)object3).b((a0)object2, (g0)object);
            return;
        }
        finally {
            object3 = this.lock;
            object3.unlock();
        }
    }

    private boolean tryReconnect() {
        int n10 = this.isNeedReconnect;
        if (n10 != 0 && (n10 = this.isManualClose) == 0) {
            Object object = AVOKWebSocketClient$Status.RECONNECT;
            this.currentStatus = object;
            n10 = this.reconnectCount;
            int n11 = n10 * 10000;
            long l10 = n11;
            long l11 = 120000L;
            long l12 = l10 - l11;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 > 0) {
                l10 = l11;
            }
            int n12 = 1;
            this.reconnectCount = n10 += n12;
            object = this.reconnectTimer;
            AVOKWebSocketClient$3 aVOKWebSocketClient$3 = new AVOKWebSocketClient$3(this);
            ((Timer)object).schedule((TimerTask)aVOKWebSocketClient$3, l10);
            return n12 != 0;
        }
        return false;
    }

    public void close() {
        int n10;
        this.isManualClose = n10 = 1;
        Object object = AVOKWebSocketClient$Status.CONNECTED;
        Object object2 = this.currentStatus;
        if (object == object2 && (object = this.webSocket) != null) {
            this.cancelReconnect();
            object = this.client;
            if (object != null) {
                object = ((z)object).R();
                ((o)object).b();
            }
            object = this.webSocket;
            int n11 = 1000;
            String string2 = "normal close";
            n10 = object.close(n11, string2);
            Object object3 = gLogger;
            CharSequence charSequence = new StringBuilder();
            String string3 = "manual close. result=";
            charSequence.append(string3);
            charSequence.append(n10 != 0);
            charSequence = charSequence.toString();
            ((AVLogger)object3).d((String)charSequence);
            object3 = this.wsStatusListener;
            if (object3 != null) {
                if (n10 != 0) {
                    object3.onClosed(n11, string2);
                } else {
                    n10 = 1001;
                    object2 = "abnormal close";
                    object3.onClosed(n10, (String)object2);
                }
            }
            this.currentStatus = object = AVOKWebSocketClient$Status.DISCONNECTED;
        } else {
            object = gLogger;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("state is illegal. status=");
            Object object4 = this.currentStatus;
            ((StringBuilder)object2).append(object4);
            ((StringBuilder)object2).append(", websockdet=");
            object4 = this.webSocket;
            ((StringBuilder)object2).append(object4);
            object2 = ((StringBuilder)object2).toString();
            ((AVLogger)object).w((String)object2);
        }
    }

    public void connect(String object) {
        a0$a a0$a = new a0$a();
        this.request = object = a0$a.B((String)object).b();
        this.isManualClose = false;
        this.buildConnect();
    }

    public AVOKWebSocketClient$Status getCurrentStatus() {
        return this.currentStatus;
    }

    public boolean sendMessage(String string2) {
        return this.webSocket.send(string2);
    }

    public boolean sendMessage(ByteString byteString) {
        return this.webSocket.a(byteString);
    }
}

