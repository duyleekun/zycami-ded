/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  android.util.Log
 */
package com.cdv.io;

import android.os.SystemClock;
import android.util.Log;

public class NvSyncEvent {
    private boolean m_manualReset = false;
    private volatile boolean m_signaled = false;

    public NvSyncEvent(boolean bl2) {
        this.m_manualReset = bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean waitEventWithTimeout(long l10) {
        boolean bl2;
        int n10;
        try {
            synchronized (this) {
                n10 = this.m_signaled;
                bl2 = true;
                if (n10 == 0) break block11;
                boolean bl3 = this.m_manualReset;
                if (!bl3) {
                    this.m_signaled = false;
                }
            }
        }
        catch (Exception exception) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("");
            String string2 = exception.getMessage();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            Log.e((String)"SyncEvent", (String)charSequence);
            exception.printStackTrace();
            return false;
        }
        {
            block11: {
                return bl2;
            }
            long l11 = SystemClock.elapsedRealtime();
            while ((n10 = this.m_signaled) == 0) {
                this.wait(l10);
                long l12 = SystemClock.elapsedRealtime();
                l11 = l12 - l11;
                n10 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
                if (n10 >= 0) {
                    return false;
                }
                l10 -= l11;
                l11 = l12;
            }
            boolean bl4 = this.m_manualReset;
            if (!bl4) {
                this.m_signaled = false;
            }
            return bl2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void resetEvent() {
        synchronized (this) {
            Object var1_1 = null;
            this.m_signaled = false;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setEvent() {
        synchronized (this) {
            boolean bl2 = this.m_signaled;
            if (!bl2) {
                this.m_signaled = bl2 = true;
                this.notifyAll();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean waitEvent(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            synchronized (this) {
                return this.m_signaled;
            }
        }
        if (object > 0) {
            return this.waitEventWithTimeout(l10);
        }
        boolean bl2 = false;
        Object var7_6 = null;
        try {
            synchronized (this) {
            }
        }
        catch (Exception exception) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("");
            String string2 = exception.getMessage();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            Log.e((String)"SyncEvent", (String)charSequence);
            exception.printStackTrace();
            return false;
        }
        {
            boolean bl3;
            while (!(bl3 = this.m_signaled)) {
                this.wait();
            }
            bl3 = this.m_manualReset;
            if (bl3) return true;
            this.m_signaled = false;
            return true;
        }
    }
}

