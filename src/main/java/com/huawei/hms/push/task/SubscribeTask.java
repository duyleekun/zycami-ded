/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.push.task;

import com.huawei.hms.push.task.BaseVoidTask;

public class SubscribeTask
extends BaseVoidTask {
    public SubscribeTask(String string2, String string3, String string4) {
        super(string2, string3, string4);
    }

    public int getMinApkVersion() {
        return 40003000;
    }
}

