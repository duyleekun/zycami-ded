/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 */
package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.material.snackbar.SnackbarManager$1;
import com.google.android.material.snackbar.SnackbarManager$Callback;
import com.google.android.material.snackbar.SnackbarManager$SnackbarRecord;

public class SnackbarManager {
    private static final int LONG_DURATION_MS = 2750;
    public static final int MSG_TIMEOUT = 0;
    private static final int SHORT_DURATION_MS = 1500;
    private static SnackbarManager snackbarManager;
    private SnackbarManager$SnackbarRecord currentSnackbar;
    private final Handler handler;
    private final Object lock;
    private SnackbarManager$SnackbarRecord nextSnackbar;

    private SnackbarManager() {
        Object object;
        this.lock = object = new Object();
        Looper looper = Looper.getMainLooper();
        SnackbarManager$1 snackbarManager$1 = new SnackbarManager$1(this);
        object = new Handler(looper, (Handler.Callback)snackbarManager$1);
        this.handler = object;
    }

    private boolean cancelSnackbarLocked(SnackbarManager$SnackbarRecord snackbarManager$SnackbarRecord, int n10) {
        SnackbarManager$Callback snackbarManager$Callback = (SnackbarManager$Callback)snackbarManager$SnackbarRecord.callback.get();
        if (snackbarManager$Callback != null) {
            this.handler.removeCallbacksAndMessages((Object)snackbarManager$SnackbarRecord);
            snackbarManager$Callback.dismiss(n10);
            return true;
        }
        return false;
    }

    public static SnackbarManager getInstance() {
        SnackbarManager snackbarManager = SnackbarManager.snackbarManager;
        if (snackbarManager == null) {
            SnackbarManager.snackbarManager = snackbarManager = new SnackbarManager();
        }
        return SnackbarManager.snackbarManager;
    }

    private boolean isCurrentSnackbarLocked(SnackbarManager$Callback snackbarManager$Callback) {
        boolean bl2;
        SnackbarManager$SnackbarRecord snackbarManager$SnackbarRecord = this.currentSnackbar;
        if (snackbarManager$SnackbarRecord != null && (bl2 = snackbarManager$SnackbarRecord.isSnackbar(snackbarManager$Callback))) {
            bl2 = true;
        } else {
            bl2 = false;
            snackbarManager$Callback = null;
        }
        return bl2;
    }

    private boolean isNextSnackbarLocked(SnackbarManager$Callback snackbarManager$Callback) {
        boolean bl2;
        SnackbarManager$SnackbarRecord snackbarManager$SnackbarRecord = this.nextSnackbar;
        if (snackbarManager$SnackbarRecord != null && (bl2 = snackbarManager$SnackbarRecord.isSnackbar(snackbarManager$Callback))) {
            bl2 = true;
        } else {
            bl2 = false;
            snackbarManager$Callback = null;
        }
        return bl2;
    }

    private void scheduleTimeoutLocked(SnackbarManager$SnackbarRecord snackbarManager$SnackbarRecord) {
        int n10 = snackbarManager$SnackbarRecord.duration;
        int n11 = -2;
        if (n10 == n11) {
            return;
        }
        n11 = 2750;
        if (n10 <= 0) {
            int n12 = -1;
            n10 = n10 == n12 ? 1500 : n11;
        }
        this.handler.removeCallbacksAndMessages((Object)snackbarManager$SnackbarRecord);
        Handler handler = this.handler;
        snackbarManager$SnackbarRecord = Message.obtain((Handler)handler, (int)0, (Object)snackbarManager$SnackbarRecord);
        long l10 = n10;
        handler.sendMessageDelayed((Message)snackbarManager$SnackbarRecord, l10);
    }

    private void showNextSnackbarLocked() {
        Object object = this.nextSnackbar;
        if (object != null) {
            this.currentSnackbar = object;
            this.nextSnackbar = null;
            object = (SnackbarManager$Callback)((SnackbarManager$SnackbarRecord)object).callback.get();
            if (object != null) {
                object.show();
            } else {
                this.currentSnackbar = null;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void dismiss(SnackbarManager$Callback object, int n10) {
        Object object2 = this.lock;
        synchronized (object2) {
            boolean bl2 = this.isCurrentSnackbarLocked((SnackbarManager$Callback)object);
            if (bl2) {
                object = this.currentSnackbar;
                this.cancelSnackbarLocked((SnackbarManager$SnackbarRecord)object, n10);
            } else {
                boolean bl3 = this.isNextSnackbarLocked((SnackbarManager$Callback)object);
                if (bl3) {
                    object = this.nextSnackbar;
                    this.cancelSnackbarLocked((SnackbarManager$SnackbarRecord)object, n10);
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void handleTimeout(SnackbarManager$SnackbarRecord snackbarManager$SnackbarRecord) {
        Object object = this.lock;
        synchronized (object) {
            SnackbarManager$SnackbarRecord snackbarManager$SnackbarRecord2 = this.currentSnackbar;
            if (snackbarManager$SnackbarRecord2 == snackbarManager$SnackbarRecord || (snackbarManager$SnackbarRecord2 = this.nextSnackbar) == snackbarManager$SnackbarRecord) {
                int n10 = 2;
                this.cancelSnackbarLocked(snackbarManager$SnackbarRecord, n10);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isCurrent(SnackbarManager$Callback snackbarManager$Callback) {
        Object object = this.lock;
        synchronized (object) {
            return this.isCurrentSnackbarLocked(snackbarManager$Callback);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isCurrentOrNext(SnackbarManager$Callback snackbarManager$Callback) {
        Object object = this.lock;
        synchronized (object) {
            boolean bl2 = this.isCurrentSnackbarLocked(snackbarManager$Callback);
            if (bl2) return true;
            boolean bl3 = this.isNextSnackbarLocked(snackbarManager$Callback);
            if (!bl3) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onDismissed(SnackbarManager$Callback object) {
        Object object2 = this.lock;
        synchronized (object2) {
            boolean bl2 = this.isCurrentSnackbarLocked((SnackbarManager$Callback)object);
            if (bl2) {
                bl2 = false;
                object = null;
                this.currentSnackbar = null;
                object = this.nextSnackbar;
                if (object != null) {
                    this.showNextSnackbarLocked();
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onShown(SnackbarManager$Callback object) {
        Object object2 = this.lock;
        synchronized (object2) {
            boolean bl2 = this.isCurrentSnackbarLocked((SnackbarManager$Callback)object);
            if (bl2) {
                object = this.currentSnackbar;
                this.scheduleTimeoutLocked((SnackbarManager$SnackbarRecord)object);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void pauseTimeout(SnackbarManager$Callback object) {
        Object object2 = this.lock;
        synchronized (object2) {
            boolean bl2 = this.isCurrentSnackbarLocked((SnackbarManager$Callback)object);
            if (bl2) {
                object = this.currentSnackbar;
                boolean bl3 = ((SnackbarManager$SnackbarRecord)object).paused;
                if (!bl3) {
                    ((SnackbarManager$SnackbarRecord)object).paused = bl3 = true;
                    Handler handler = this.handler;
                    handler.removeCallbacksAndMessages(object);
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void restoreTimeoutIfPaused(SnackbarManager$Callback object) {
        Object object2 = this.lock;
        synchronized (object2) {
            boolean bl2 = this.isCurrentSnackbarLocked((SnackbarManager$Callback)object);
            if (bl2) {
                object = this.currentSnackbar;
                boolean bl3 = ((SnackbarManager$SnackbarRecord)object).paused;
                if (bl3) {
                    bl3 = false;
                    ((SnackbarManager$SnackbarRecord)object).paused = false;
                    this.scheduleTimeoutLocked((SnackbarManager$SnackbarRecord)object);
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void show(int n10, SnackbarManager$Callback object) {
        Object object2 = this.lock;
        synchronized (object2) {
            int n11;
            boolean bl2 = this.isCurrentSnackbarLocked((SnackbarManager$Callback)object);
            if (bl2) {
                object = this.currentSnackbar;
                ((SnackbarManager$SnackbarRecord)object).duration = n10;
                Object object3 = this.handler;
                object3.removeCallbacksAndMessages(object);
                object3 = this.currentSnackbar;
                this.scheduleTimeoutLocked((SnackbarManager$SnackbarRecord)object3);
                return;
            }
            bl2 = this.isNextSnackbarLocked((SnackbarManager$Callback)object);
            if (bl2) {
                object = this.nextSnackbar;
                ((SnackbarManager$SnackbarRecord)object).duration = n10;
            } else {
                SnackbarManager$SnackbarRecord snackbarManager$SnackbarRecord;
                this.nextSnackbar = snackbarManager$SnackbarRecord = new SnackbarManager$SnackbarRecord(n10, (SnackbarManager$Callback)object);
            }
            SnackbarManager$SnackbarRecord snackbarManager$SnackbarRecord = this.currentSnackbar;
            if (snackbarManager$SnackbarRecord != null && (n10 = (int)(this.cancelSnackbarLocked(snackbarManager$SnackbarRecord, n11 = 4) ? 1 : 0)) != 0) {
                return;
            }
            n10 = 0;
            snackbarManager$SnackbarRecord = null;
            this.currentSnackbar = null;
            this.showNextSnackbarLocked();
            return;
        }
    }
}

