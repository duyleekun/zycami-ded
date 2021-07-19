/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.module;

import com.tencent.liteav.basic.module.TXCStatus;

public class a {
    private String mID = "";

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clearID() {
        synchronized (this) {
            String string2 = this.mID;
            int n10 = string2.length();
            if (n10 != 0) {
                string2 = this.mID;
                TXCStatus.b(string2);
                this.mID = string2 = "";
            }
            return;
        }
    }

    public void finalize() {
        this.clearID();
        super.finalize();
    }

    public double getDoubleValue(int n10) {
        return TXCStatus.d(this.mID, n10);
    }

    public double getDoubleValue(int n10, int n11) {
        return TXCStatus.d(this.mID, n10, n11);
    }

    public String getID() {
        return this.mID;
    }

    public int getIntValue(int n10) {
        return TXCStatus.c(this.mID, n10);
    }

    public int getIntValue(int n10, int n11) {
        return TXCStatus.c(this.mID, n10, n11);
    }

    public long getLongValue(int n10) {
        return TXCStatus.a(this.mID, n10);
    }

    public long getLongValue(int n10, int n11) {
        return TXCStatus.a(this.mID, n10, n11);
    }

    public String getStringValue(int n10) {
        return TXCStatus.b(this.mID, n10);
    }

    public String getStringValue(int n10, int n11) {
        return TXCStatus.b(this.mID, n10, n11);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setID(String string2) {
        this.clearID();
        synchronized (this) {
            int n10 = string2.length();
            if (n10 != 0) {
                this.mID = string2;
                TXCStatus.a(string2);
            }
            return;
        }
    }

    public boolean setStatusValue(int n10, int n11, Object object) {
        return TXCStatus.a(this.mID, n10, n11, object);
    }

    public boolean setStatusValue(int n10, Object object) {
        return TXCStatus.a(this.mID, n10, object);
    }
}

