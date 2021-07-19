/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcelable
 */
package com.huawei.hms.common.internal;

import android.os.Parcelable;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.log.HMSLog;
import d.j.d.a.b;
import d.j.d.a.l;

public abstract class TaskApiCall {
    private static final String TAG = "TaskApiCall";
    private int apiLevel = 1;
    private final String mRequestJson;
    private final String mUri;
    private Parcelable parcelable;
    private b token;
    private String transactionId;

    public TaskApiCall(String string2, String string3) {
        this.mUri = string2;
        this.mRequestJson = string3;
        this.parcelable = null;
        this.transactionId = null;
    }

    public TaskApiCall(String string2, String string3, String string4) {
        this.mUri = string2;
        this.mRequestJson = string3;
        this.parcelable = null;
        this.transactionId = string4;
    }

    public TaskApiCall(String string2, String string3, String string4, int n10) {
        this.mUri = string2;
        this.mRequestJson = string3;
        this.parcelable = null;
        this.transactionId = string4;
        this.apiLevel = n10;
    }

    public abstract void doExecute(AnyClient var1, ResponseErrorCode var2, String var3, l var4);

    public int getApiLevel() {
        return this.apiLevel;
    }

    public int getMinApkVersion() {
        return 30000000;
    }

    public Parcelable getParcelable() {
        return this.parcelable;
    }

    public String getRequestJson() {
        return this.mRequestJson;
    }

    public b getToken() {
        return this.token;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public String getUri() {
        return this.mUri;
    }

    public final void onResponse(AnyClient object, ResponseErrorCode object2, String string2, l l10) {
        boolean bl2;
        b b10 = this.token;
        if (b10 != null && (bl2 = b10.a())) {
            object = new StringBuilder();
            ((StringBuilder)object).append("This Task has been canceled, uri:");
            object2 = this.mUri;
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(", transactionId:");
            object2 = this.transactionId;
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
            HMSLog.i("TaskApiCall", (String)object);
            return;
        }
        this.doExecute((AnyClient)object, (ResponseErrorCode)object2, string2, l10);
    }

    public void setApiLevel(int n10) {
        this.apiLevel = n10;
    }

    public void setParcelable(Parcelable parcelable) {
        this.parcelable = parcelable;
    }

    public void setToken(b b10) {
        this.token = b10;
    }

    public void setTransactionId(String string2) {
        this.transactionId = string2;
    }
}

