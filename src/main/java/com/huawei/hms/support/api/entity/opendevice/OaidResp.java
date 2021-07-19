/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 */
package com.huawei.hms.support.api.entity.opendevice;

import android.app.PendingIntent;
import com.huawei.hms.core.aidl.AbstractMessageEntity;

public class OaidResp
extends AbstractMessageEntity {
    public String id;
    public boolean isTrackLimited;
    public PendingIntent settingIntent;

    public String getId() {
        return this.id;
    }

    public PendingIntent getSettingIntent() {
        return this.settingIntent;
    }

    public boolean isTrackLimited() {
        return this.isTrackLimited;
    }

    public void setId(String string2) {
        this.id = string2;
    }

    public void setSettingIntent(PendingIntent pendingIntent) {
        this.settingIntent = pendingIntent;
    }

    public void setTrackLimited(boolean bl2) {
        this.isTrackLimited = bl2;
    }
}

