/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Intent
 */
package com.huawei.hms.adapter;

import android.app.PendingIntent;
import android.content.Intent;
import com.huawei.hms.core.aidl.IMessageEntity;

public class CoreBaseResponse
implements IMessageEntity {
    public Intent intent;
    private String jsonBody;
    private String jsonHeader;
    public PendingIntent pendingIntent;

    public Intent getIntent() {
        return this.intent;
    }

    public String getJsonBody() {
        return this.jsonBody;
    }

    public String getJsonHeader() {
        return this.jsonHeader;
    }

    public PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public void setJsonBody(String string2) {
        this.jsonBody = string2;
    }

    public void setJsonHeader(String string2) {
        this.jsonHeader = string2;
    }

    public void setPendingIntent(PendingIntent pendingIntent) {
        this.pendingIntent = pendingIntent;
    }
}

