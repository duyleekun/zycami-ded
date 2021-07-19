/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.huawei.hms.support.api.entity.core;

import android.content.Intent;
import com.huawei.hms.support.api.entity.core.JosBaseResp;

public class JosGetNoticeResp
extends JosBaseResp {
    private Intent noticeIntent;

    private static Object get(Object object) {
        return object;
    }

    public Intent getNoticeIntent() {
        return (Intent)JosGetNoticeResp.get(this.noticeIntent);
    }

    public void setNoticeIntent(Intent intent) {
        this.noticeIntent = intent;
    }
}

