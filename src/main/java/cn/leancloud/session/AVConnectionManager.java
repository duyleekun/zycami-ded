/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.AVException;
import cn.leancloud.AVInstallation;
import cn.leancloud.AVLogger;
import cn.leancloud.Messages$CommandType;
import cn.leancloud.Messages$GenericCommand;
import cn.leancloud.Messages$LoggedinCommand;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.command.CommandPacket;
import cn.leancloud.command.LoginPacket;
import cn.leancloud.core.AVOSCloud;
import cn.leancloud.core.AVOSService;
import cn.leancloud.core.AppRouter;
import cn.leancloud.im.AVIMOptions;
import cn.leancloud.im.SystemReporter$SystemInfo;
import cn.leancloud.im.WindTalker;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.push.AVPushMessageListener;
import cn.leancloud.service.RTMConnectionServerResponse;
import cn.leancloud.session.AVConnectionListener;
import cn.leancloud.session.AVConnectionManager$1;
import cn.leancloud.session.AVConnectionManager$2;
import cn.leancloud.session.AVConnectionManager$3;
import cn.leancloud.session.AVConnectionManager$ConnectionPolicy;
import cn.leancloud.session.AVConnectionManager$ConnectionStatus;
import cn.leancloud.session.AVDefaultConnectionListener;
import cn.leancloud.session.AVSession;
import cn.leancloud.session.AVSession$Status;
import cn.leancloud.session.AVSessionCacheHelper;
import cn.leancloud.session.AVSessionManager;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import cn.leancloud.websocket.AVStandardWebSocketClient;
import cn.leancloud.websocket.AVStandardWebSocketClient$WebSocketClientMonitor;
import com.google.protobuf.AbstractMessage;
import e.a.g0;
import e.a.z;
import i.d.m.b;
import java.net.URI;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class AVConnectionManager
implements AVStandardWebSocketClient$WebSocketClientMonitor {
    private static final AVLogger LOGGER = LogUtil.getLogger(AVConnectionManager.class);
    private static AVConnectionManager instance = null;
    private final Map connectionListeners;
    private volatile AVConnectionManager$ConnectionPolicy connectionPolicy;
    private final AVInstallation currentInstallation;
    private String currentRTMConnectionServer;
    private volatile AVConnectionManager$ConnectionStatus currentStatus;
    private final Map defaultConnectionListeners;
    private volatile AVCallback pendingCallback;
    private int retryConnectionCount;
    private AVStandardWebSocketClient webSocketClient = null;
    private final Object webSocketClientWatcher;

    private AVConnectionManager(AVInstallation object, boolean bl2) {
        Object object2;
        this.webSocketClientWatcher = object2 = new Object();
        this.currentRTMConnectionServer = null;
        this.retryConnectionCount = 0;
        object2 = AVConnectionManager$ConnectionStatus.Offline;
        this.currentStatus = object2;
        object2 = AVConnectionManager$ConnectionPolicy.Keep;
        this.connectionPolicy = object2;
        this.pendingCallback = null;
        Object object3 = new ConcurrentHashMap(1);
        this.connectionListeners = object3;
        int n10 = 2;
        super(n10);
        this.defaultConnectionListeners = object3;
        this.currentInstallation = object;
        object = AVPushMessageListener.getInstance();
        object3 = "leancloud_push_default_id";
        this.subscribeDefaultConnectionListener((String)object3, (AVConnectionListener)object);
        if (bl2) {
            object = new AVConnectionManager$1(this);
            this.startConnection((AVCallback)object);
        }
    }

    public static /* synthetic */ int access$000(AVConnectionManager aVConnectionManager) {
        return aVConnectionManager.retryConnectionCount;
    }

    public static /* synthetic */ AVLogger access$100() {
        return LOGGER;
    }

    public static /* synthetic */ void access$200(AVConnectionManager aVConnectionManager) {
        aVConnectionManager.startConnectionInternal();
    }

    public static /* synthetic */ void access$300(AVConnectionManager aVConnectionManager) {
        aVConnectionManager.reConnectionRTMServer();
    }

    public static /* synthetic */ String access$400(AVConnectionManager aVConnectionManager, RTMConnectionServerResponse rTMConnectionServerResponse) {
        return aVConnectionManager.updateTargetServer(rTMConnectionServerResponse);
    }

    public static /* synthetic */ void access$500(AVConnectionManager aVConnectionManager, String string2) {
        aVConnectionManager.initWebSocketClient(string2);
    }

    public static AVConnectionManager createInstance(AVInstallation aVInstallation) {
        AVConnectionManager aVConnectionManager = new AVConnectionManager(aVInstallation, false);
        return aVConnectionManager;
    }

    public static AVConnectionManager getInstance() {
        Class<AVConnectionManager> clazz = AVConnectionManager.class;
        synchronized (clazz) {
            AVConnectionManager aVConnectionManager = instance;
            if (aVConnectionManager == null) {
                AVInstallation aVInstallation = AVInstallation.getCurrentInstallation();
                instance = aVConnectionManager = new AVConnectionManager(aVInstallation, false);
            }
            aVConnectionManager = instance;
            return aVConnectionManager;
        }
    }

    private void initSessionsIfExists() {
        boolean bl2;
        Iterator iterator2 = AVSessionCacheHelper.getTagCacheInstance().getAllSession().entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = iterator2.next();
            Object object2 = AVSessionManager.getInstance();
            Object object3 = (String)object.getKey();
            String string2 = this.currentInstallation.getInstallationId();
            object2 = ((AVSessionManager)object2).getOrCreateSession((String)object3, string2, this);
            object3 = (String)object.getValue();
            ((AVSession)object2).setTag((String)object3);
            object3 = AVSession$Status.Closed;
            ((AVSession)object2).setSessionStatus((AVSession$Status)((Object)object3));
            object3 = new AVDefaultConnectionListener((AVSession)object2);
            object = (String)object.getKey();
            this.subscribeConnectionListener((String)object, (AVConnectionListener)object3);
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void initWebSocketClient(String var1_1) {
        var2_2 = AVConnectionManager.LOGGER;
        var3_3 = new StringBuilder();
        var4_8 = "try to connect server: ";
        var3_3.append((String)var4_8);
        var3_3.append((String)var1_1);
        var3_3 = var3_3.toString();
        var2_2.d((String)var3_3);
        var5_9 = 0;
        var2_2 = null;
        try {
            var3_3 = SSLContext.getDefault();
            var6_10 = var3_3 = var3_3.getSocketFactory();
        }
        catch (NoSuchAlgorithmException var3_4) {
            var4_8 = AVConnectionManager.LOGGER;
            var7_11 = new StringBuilder();
            var8_12 = "failed to get SSLContext, cause: ";
            var7_11.append((String)var8_12);
            var3_3 = var3_4.getMessage();
            var7_11.append((String)var3_3);
            var3_3 = var7_11.toString();
            var4_8.e((String)var3_3);
            var6_10 = null;
        }
        try {
            var8_12 = var1_1 = URI.create((String)var1_1);
        }
        catch (Exception var3_5) {
            var4_8 = AVConnectionManager.LOGGER;
            var7_11 = new StringBuilder();
            var7_11.append("failed to parse targetServer:");
            var7_11.append((String)var1_1);
            var7_11.append(", cause:");
            var1_1 = var3_5.getMessage();
            var7_11.append((String)var1_1);
            var1_1 = var7_11.toString();
            var4_8.e((String)var1_1);
            return;
        }
        if (var8_12 == null) {
            return;
        }
        var1_1 = this.webSocketClientWatcher;
        synchronized (var1_1) {
            block18: {
                var3_3 = this.webSocketClient;
                if (var3_3 != null) {
                    var3_3.close();
lbl54:
                    // 2 sources

                    while (true) {
                        this.webSocketClient = null;
                        break block18;
                        break;
                    }
                    {
                        catch (Throwable var3_6) {
                        }
                        catch (Exception var3_7) {}
                        {
                            var4_8 = AVConnectionManager.LOGGER;
                            var7_11 = "failed to close websocket client.";
                            var4_8.e((String)var7_11, var3_7);
                            ** continue;
                        }
                    }
                    this.webSocketClient = null;
                    throw var3_6;
                }
            }
            var2_2 = AVIMOptions.getGlobalOptions();
            var5_9 = var2_2.getTimeoutInSecs();
            var9_13 = var5_9 * 1000;
            var2_2 = AVIMOptions.getGlobalOptions();
            var5_9 = (int)var2_2.isOnlyPushCount();
            if (var5_9 != 0) {
                var10_14 = "lc.protobuf2.3";
                var11_16 = true;
                var12_18 = true;
                var7_11 = var2_2;
                this.webSocketClient = var2_2 = new AVStandardWebSocketClient((URI)var8_12, var10_14, var11_16, var12_18, (SSLSocketFactory)var6_10, var9_13, this);
            } else {
                var10_15 = "lc.protobuf2.1";
                var11_17 = true;
                var12_19 = true;
                var7_11 = var2_2;
                this.webSocketClient = var2_2 = new AVStandardWebSocketClient((URI)var8_12, var10_15, var11_17, var12_19, (SSLSocketFactory)var6_10, var9_13, this);
            }
            var2_2 = this.webSocketClient;
            var2_2.connect();
            return;
        }
    }

    private void reConnectionRTMServer() {
        int n10;
        this.retryConnectionCount = n10 = this.retryConnectionCount + 1;
        int n11 = 3;
        if (n10 <= n11) {
            AVConnectionManager$2 aVConnectionManager$2 = new AVConnectionManager$2(this);
            Thread thread = new Thread(aVConnectionManager$2);
            thread.start();
        } else {
            AVLogger aVLogger = LOGGER;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("have tried ");
            int n12 = this.retryConnectionCount + -1;
            charSequence.append(n12);
            String string2 = " times, stop connecting...";
            charSequence.append(string2);
            charSequence = charSequence.toString();
            aVLogger.e((String)charSequence);
            n10 = 0;
            aVLogger = null;
            this.resetConnectingStatus(false);
        }
    }

    private void resetConnectingStatus(boolean bl2) {
        Object object = bl2 ? AVConnectionManager$ConnectionStatus.Connected : AVConnectionManager$ConnectionStatus.Offline;
        this.currentStatus = object;
        object = this.pendingCallback;
        if (object != null) {
            if (bl2) {
                AVCallback aVCallback = this.pendingCallback;
                aVCallback.internalDone(null);
            } else {
                AVCallback aVCallback = this.pendingCallback;
                int n10 = 124;
                String string2 = "network timeout.";
                object = new AVException(n10, string2);
                aVCallback.internalDone((AVException)object);
            }
        }
        this.pendingCallback = null;
    }

    private void startConnection(AVCallback object, boolean bl2) {
        Object object2 = AVConnectionManager$ConnectionStatus.Connected;
        Object object3 = this.currentStatus;
        if (object2 == object3) {
            AVLogger aVLogger = LOGGER;
            object2 = "connection is established, directly response callback...";
            aVLogger.d((String)object2);
            if (object != null) {
                bl2 = false;
                aVLogger = null;
                ((AVCallback)object).internalDone(null);
            }
        } else {
            Object object4;
            object2 = AVConnectionManager$ConnectionStatus.Connecting;
            object3 = this.currentStatus;
            if (object2 == object3) {
                AVLogger aVLogger = LOGGER;
                object2 = "on starting connection, save callback...";
                aVLogger.d((String)object2);
                if (object != null) {
                    this.pendingCallback = object;
                }
            } else if (bl2 && (object4 = AVConnectionManager$ConnectionPolicy.LetItGone) == (object3 = this.connectionPolicy)) {
                object = LOGGER;
                object4 = "ignore auto establish connection for policy:ConnectionPolicy.LetItGone...";
                ((AVLogger)object).d((String)object4);
            } else {
                object4 = LOGGER;
                object3 = "start connection with callback...";
                ((AVLogger)object4).d((String)object3);
                this.currentStatus = object2;
                this.pendingCallback = object;
                this.startConnectionInternal();
            }
        }
    }

    private void startConnectionInternal() {
        Object object = AVIMOptions.getGlobalOptions().getRtmServer();
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2) {
            this.initWebSocketClient((String)object);
            return;
        }
        object = AppRouter.getInstance();
        String string2 = this.currentInstallation.getInstallationId();
        Object object2 = AVOSCloud.getApplicationId();
        Object object3 = AVOSService.RTM;
        object2 = ((AppRouter)object).getEndpoint((String)object2, (AVOSService)((Object)object3));
        object3 = new AVConnectionManager$3(this, (AppRouter)object, string2);
        ((z)object2).subscribe((g0)object3);
    }

    private String updateTargetServer(RTMConnectionServerResponse object) {
        String string2 = ((RTMConnectionServerResponse)object).getServer();
        object = ((RTMConnectionServerResponse)object).getSecondary();
        String string3 = this.currentRTMConnectionServer;
        boolean bl2 = StringUtil.isEmpty(string3);
        this.currentRTMConnectionServer = !bl2 && !(bl2 = (string3 = this.currentRTMConnectionServer).equalsIgnoreCase((String)object)) ? object : string2;
        return this.currentRTMConnectionServer;
    }

    public void autoConnection() {
        this.startConnection(null, true);
    }

    public void cleanup() {
        this.resetConnection();
        this.connectionListeners.clear();
        this.pendingCallback = null;
    }

    public boolean isConnectionEstablished() {
        boolean bl2;
        AVConnectionManager$ConnectionStatus aVConnectionManager$ConnectionStatus = AVConnectionManager$ConnectionStatus.Connected;
        AVConnectionManager$ConnectionStatus aVConnectionManager$ConnectionStatus2 = this.currentStatus;
        if (aVConnectionManager$ConnectionStatus == aVConnectionManager$ConnectionStatus2) {
            bl2 = true;
        } else {
            bl2 = false;
            aVConnectionManager$ConnectionStatus = null;
        }
        return bl2;
    }

    public void onClose(b iterator2, int n10, String charSequence, boolean bl2) {
        Object object = LOGGER;
        charSequence = new StringBuilder();
        String string2 = "client(";
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(iterator2);
        ((StringBuilder)charSequence).append(") closed...");
        iterator2 = ((StringBuilder)charSequence).toString();
        ((AVLogger)object).d((String)((Object)iterator2));
        iterator2 = AVConnectionManager$ConnectionStatus.Offline;
        this.currentStatus = iterator2;
        iterator2 = this.connectionListeners.values().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (AVConnectionListener)iterator2.next();
            object.onWebSocketClose();
        }
        iterator2 = this.defaultConnectionListeners.values().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (AVConnectionListener)iterator2.next();
            object.onWebSocketClose();
        }
    }

    public void onError(b object, Exception object2) {
        boolean bl2;
        AVLogger aVLogger = LOGGER;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "AVConnectionManager onError. client:";
        stringBuilder.append(string2);
        stringBuilder.append(object);
        object = ", exception:";
        stringBuilder.append((String)object);
        object = object2 != null ? ((Throwable)object2).getMessage() : "null";
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        aVLogger.d((String)object);
        object = AVConnectionManager$ConnectionStatus.Offline;
        this.currentStatus = object;
        this.reConnectionRTMServer();
        object = this.connectionListeners.values().iterator();
        while (true) {
            bl2 = object.hasNext();
            aVLogger = null;
            if (!bl2) break;
            object2 = (AVConnectionListener)object.next();
            object2.onError(null, null);
        }
        object = this.defaultConnectionListeners.values().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (AVConnectionListener)object.next();
            object2.onError(null, null);
        }
    }

    public void onMessage(b object, ByteBuffer object2) {
        int n10;
        int n11;
        int n12;
        int n13;
        object2 = WindTalker.getInstance().disassemblePacket((ByteBuffer)object2);
        Object object3 = "client(";
        if (object2 == null) {
            object2 = LOGGER;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object3);
            stringBuilder.append(object);
            stringBuilder.append(") downlink: invalid command.");
            object = stringBuilder.toString();
            ((AVLogger)object2).w((String)object);
            return;
        }
        AVLogger aVLogger = LOGGER;
        Object object4 = new StringBuilder();
        ((StringBuilder)object4).append((String)object3);
        ((StringBuilder)object4).append(object);
        ((StringBuilder)object4).append(") downlink: ");
        object = ((AbstractMessage)object2).toString();
        ((StringBuilder)object4).append((String)object);
        object = ((StringBuilder)object4).toString();
        aVLogger.d((String)object);
        object = ((Messages$GenericCommand)object2).getPeerId();
        boolean n112 = ((Messages$GenericCommand)object2).hasI();
        if (n112) {
            int n14 = ((Messages$GenericCommand)object2).getI();
            object3 = n14;
        } else {
            boolean bl2 = false;
            object3 = null;
        }
        boolean bl3 = ((Messages$GenericCommand)object2).hasService();
        if (bl3 && (n13 = ((Messages$GenericCommand)object2).getService()) == (n12 = 1)) {
            object = "leancloud_livequery_default_id";
        } else {
            object4 = ((Messages$GenericCommand)object2).getCmd();
            int n15 = ((Messages$CommandType)object4).getNumber();
            if (n15 == (n12 = 9)) {
                object = "leancloud_push_default_id";
            } else {
                boolean bl4 = StringUtil.isEmpty((String)object);
                if (bl4) {
                    object = AVIMClient.getDefaultClient();
                }
            }
        }
        boolean bl5 = ((Messages$GenericCommand)object2).hasService();
        if (bl5 && (n11 = ((Messages$GenericCommand)object2).getService()) == 0 && (n10 = ((Messages$CommandType)(object4 = ((Messages$GenericCommand)object2).getCmd())).getNumber()) == (n12 = 15)) {
            boolean bl6;
            boolean bl7;
            object = ((Messages$GenericCommand)object2).getLoggedinMessage();
            if (object != null && (bl7 = ((Messages$LoggedinCommand)object).hasPushDisabled()) && (bl6 = ((Messages$LoggedinCommand)object).getPushDisabled())) {
                aVLogger.i("received close connection instruction from server.");
                object = AVConnectionManager$ConnectionPolicy.ForceKeep;
                object2 = this.connectionPolicy;
                if (object != object2) {
                    object = AVConnectionManager$ConnectionPolicy.LetItGone;
                    this.connectionPolicy = object;
                }
            }
            return;
        }
        object4 = (AVConnectionListener)this.connectionListeners.get(object);
        if (object4 == null) {
            object4 = (AVConnectionListener)this.defaultConnectionListeners.get(object);
        }
        if (object4 != null) {
            object4.onMessageArriving((String)object, (Integer)object3, (Messages$GenericCommand)object2);
        } else {
            object2 = new StringBuilder();
            object4 = "no peer subscribed message, ignore it. peerId=";
            ((StringBuilder)object2).append((String)object4);
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(", requestKey=");
            ((StringBuilder)object2).append(object3);
            object = ((StringBuilder)object2).toString();
            aVLogger.w((String)object);
        }
    }

    public void onOpen(b object) {
        boolean bl2;
        Object object2 = LOGGER;
        Object object3 = new StringBuilder();
        String string2 = "webSocket(client=";
        ((StringBuilder)object3).append(string2);
        ((StringBuilder)object3).append(object);
        ((StringBuilder)object3).append(") established...");
        object = ((StringBuilder)object3).toString();
        ((AVLogger)object2).d((String)object);
        object = AVConnectionManager$ConnectionStatus.Connected;
        this.currentStatus = object;
        this.retryConnectionCount = 0;
        object = AVIMOptions.getGlobalOptions();
        boolean bl3 = ((AVIMOptions)object).isDisableAutoLogin4Push();
        if (!bl3) {
            object = AVIMOptions.getGlobalOptions();
            object2 = new LoginPacket();
            object3 = AVOSCloud.getApplicationId();
            ((CommandPacket)object2).setAppId((String)object3);
            object3 = this.currentInstallation.getInstallationId();
            ((CommandPacket)object2).setInstallationId((String)object3);
            object3 = ((AVIMOptions)object).getSystemReporter();
            if (object3 != null) {
                object = ((AVIMOptions)object).getSystemReporter().getInfo();
                ((LoginPacket)object2).setSystemInfo((SystemReporter$SystemInfo)object);
            }
            this.sendPacket((CommandPacket)object2);
        }
        this.initSessionsIfExists();
        bl3 = true;
        this.resetConnectingStatus(bl3);
        object = this.connectionListeners.values().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (AVConnectionListener)object.next();
            object2.onWebSocketOpen();
        }
        object = this.defaultConnectionListeners.values().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (AVConnectionListener)object.next();
            object2.onWebSocketOpen();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void resetConnection() {
        block11: {
            this.currentStatus = var1_1 /* !! */  = AVConnectionManager$ConnectionStatus.Offline;
            var1_1 /* !! */  = this.webSocketClientWatcher;
            synchronized (var1_1 /* !! */ ) {
                var2_2 = this.webSocketClient;
                if (var2_2 != null) {
                    var3_5 = 1006;
                    var4_6 = "Connectivity broken";
                    var2_2.closeConnection(var3_5, var4_6);
lbl10:
                    // 2 sources

                    while (true) {
                        this.webSocketClient = null;
                        break block11;
                        break;
                    }
                    {
                        catch (Throwable var2_3) {
                        }
                        catch (Exception var2_4) {}
                        {
                            var5_7 = AVConnectionManager.LOGGER;
                            var4_6 = "failed to close websocket client.";
                            var5_7.e(var4_6, var2_4);
                            ** continue;
                        }
                    }
                    this.webSocketClient = null;
                    throw var2_3;
                }
            }
        }
        this.retryConnectionCount = 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void sendPacket(CommandPacket object) {
        Object object2 = this.webSocketClientWatcher;
        synchronized (object2) {
            Object object3 = this.webSocketClient;
            if (object3 != null) {
                object3 = "session";
                String string2 = ((CommandPacket)object).getCmd();
                boolean bl2 = ((String)object3).equals(string2);
                if (bl2) {
                    object3 = AVConnectionManager$ConnectionPolicy.ForceKeep;
                    this.connectionPolicy = object3;
                }
                object3 = this.webSocketClient;
                ((AVStandardWebSocketClient)object3).send((CommandPacket)object);
            } else {
                object3 = LOGGER;
                StringBuilder stringBuilder = new StringBuilder();
                String string3 = "StateException: web socket client is null, drop CommandPacket: ";
                stringBuilder.append(string3);
                stringBuilder.append(object);
                object = stringBuilder.toString();
                ((AVLogger)object3).w((String)object);
            }
            return;
        }
    }

    public void startConnection(AVCallback aVCallback) {
        this.startConnection(aVCallback, false);
    }

    public void subscribeConnectionListener(String string2, AVConnectionListener aVConnectionListener) {
        if (aVConnectionListener != null) {
            Map map = this.connectionListeners;
            map.put(string2, aVConnectionListener);
        }
    }

    public void subscribeDefaultConnectionListener(String string2, AVConnectionListener aVConnectionListener) {
        if (aVConnectionListener != null) {
            Map map = this.defaultConnectionListeners;
            map.put(string2, aVConnectionListener);
        }
    }

    public void unsubscribeConnectionListener(String string2) {
        this.connectionListeners.remove(string2);
    }
}

