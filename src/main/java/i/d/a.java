/*
 * Decompiled with CFR 0.151.
 */
package i.d;

import i.d.a$a;
import i.d.f;
import i.d.g;
import i.d.i;
import i.h.c;
import i.h.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public abstract class a
extends g {
    private ScheduledFuture connectionLostCheckerFuture;
    private ScheduledExecutorService connectionLostCheckerService;
    private long connectionLostTimeout;
    private final c log;
    private boolean reuseAddr;
    private final Object syncConnectionLost;
    private boolean tcpNoDelay;
    private boolean websocketRunning;

    public a() {
        long l10;
        Object object = d.i(a.class);
        this.log = object;
        this.connectionLostTimeout = l10 = TimeUnit.SECONDS.toNanos(60);
        this.websocketRunning = false;
        this.syncConnectionLost = object = new Object();
    }

    public static /* synthetic */ long access$000(a a10) {
        return a10.connectionLostTimeout;
    }

    public static /* synthetic */ void access$100(a a10, f f10, long l10) {
        a10.executeConnectionLostDetection(f10, l10);
    }

    private void cancelConnectionLostTimer() {
        Object object = this.connectionLostCheckerService;
        if (object != null) {
            object.shutdownNow();
            this.connectionLostCheckerService = null;
        }
        if ((object = this.connectionLostCheckerFuture) != null) {
            object.cancel(false);
            this.connectionLostCheckerFuture = null;
        }
    }

    private void executeConnectionLostDetection(f f10, long l10) {
        boolean bl2 = f10 instanceof i;
        if (!bl2) {
            return;
        }
        long l11 = ((i)(f10 = (i)f10)).o();
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object < 0) {
            c c10 = this.log;
            c10.trace("Closing connection due to no pong received: {}", (Object)f10);
            object = 1006;
            String string2 = "The connection was closed because the other endpoint did not respond with a pong in time. For more information check: https://github.com/TooTallNate/Java-WebSocket/wiki/Lost-connection-detection";
            ((i)f10).closeConnection((int)object, string2);
        } else {
            object = ((i)f10).isOpen();
            if (object != false) {
                ((i)f10).sendPing();
            } else {
                c c11 = this.log;
                String string3 = "Trying to ping a non open connection: {}";
                c11.trace(string3, (Object)f10);
            }
        }
    }

    private void restartConnectionLostTimer() {
        this.cancelConnectionLostTimer();
        ScheduledFuture scheduledFuture = new ScheduledFuture("connectionLostChecker");
        scheduledFuture = Executors.newSingleThreadScheduledExecutor((ThreadFactory)((Object)scheduledFuture));
        this.connectionLostCheckerService = scheduledFuture;
        a$a a$a = new a$a(this);
        ScheduledExecutorService scheduledExecutorService = this.connectionLostCheckerService;
        long l10 = this.connectionLostTimeout;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        this.connectionLostCheckerFuture = scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(a$a, l10, l10, timeUnit);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getConnectionLostTimeout() {
        Object object = this.syncConnectionLost;
        synchronized (object) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            long l10 = this.connectionLostTimeout;
            long l11 = timeUnit.toSeconds(l10);
            return (int)l11;
        }
    }

    public abstract Collection getConnections();

    public boolean isReuseAddr() {
        return this.reuseAddr;
    }

    public boolean isTcpNoDelay() {
        return this.tcpNoDelay;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setConnectionLostTimeout(int var1_1) {
        var2_2 = this.syncConnectionLost;
        synchronized (var2_2) {
            block10: {
                block9: {
                    block8: {
                        var3_3 = TimeUnit.SECONDS;
                        var4_4 = var1_1;
                        this.connectionLostTimeout = var6_5 = var3_3.toNanos(var4_4);
                        var8_6 = 0L;
                        var1_1 = (int)(var6_5 == var8_6 ? 0 : (var6_5 < var8_6 ? -1 : 1));
                        if (var1_1 <= 0) {
                            var10_7 = this.log;
                            var3_3 = "Connection lost timer stopped";
                            var10_7.trace((String)var3_3);
                            this.cancelConnectionLostTimer();
                            return;
                        }
                        var1_1 = (int)this.websocketRunning;
                        if (var1_1 == 0) break block10;
                        var10_8 = this.log;
                        var3_3 = "Connection lost timer restarted";
                        var10_8.trace((String)var3_3);
                        try {
                            var3_3 = this.getConnections();
                            var10_8 = new ArrayList(var3_3);
                            var10_8 = var10_8.iterator();
lbl23:
                            // 3 sources

                            while (var11_10 = var10_8.hasNext()) {
                                var3_3 = var10_8.next();
                                break block8;
                            }
                            break block9;
                        }
                        catch (Exception var10_9) {
                            var3_3 = this.log;
                            var13_12 = "Exception during connection lost restart";
                            var3_3.error(var13_12, var10_9);
                            break block9;
                        }
                    }
                    var12_11 = (var3_3 = (f)var3_3) instanceof i;
                    if (!var12_11) ** GOTO lbl23
                    {
                        var3_3 = (i)var3_3;
                        var3_3.y();
                        ** GOTO lbl23
                    }
                }
                this.restartConnectionLostTimer();
            }
            return;
        }
    }

    public void setReuseAddr(boolean bl2) {
        this.reuseAddr = bl2;
    }

    public void setTcpNoDelay(boolean bl2) {
        this.tcpNoDelay = bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void startConnectionLostTimer() {
        Object object = this.syncConnectionLost;
        synchronized (object) {
            long l10 = this.connectionLostTimeout;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 <= 0) {
                c c10 = this.log;
                String string2 = "Connection lost timer deactivated";
                c10.trace(string2);
                return;
            }
            c c11 = this.log;
            String string3 = "Connection lost timer started";
            c11.trace(string3);
            l12 = 1;
            this.websocketRunning = l12;
            this.restartConnectionLostTimer();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void stopConnectionLostTimer() {
        Object object = this.syncConnectionLost;
        synchronized (object) {
            Object object2 = this.connectionLostCheckerService;
            if (object2 != null || (object2 = this.connectionLostCheckerFuture) != null) {
                object2 = null;
                this.websocketRunning = false;
                object2 = this.log;
                String string2 = "Connection lost timer stopped";
                object2.trace(string2);
                this.cancelConnectionLostTimer();
            }
            return;
        }
    }
}

