/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiPushMessage;
import java.util.List;

public abstract class MiPushClient$MiPushClientCallback {
    private String category;

    public String getCategory() {
        return this.category;
    }

    public void onCommandResult(String string2, long l10, String string3, List list) {
    }

    public void onInitializeResult(long l10, String string2, String string3) {
    }

    public void onReceiveMessage(MiPushMessage miPushMessage) {
    }

    public void onReceiveMessage(String string2, String string3, String string4, boolean bl2) {
    }

    public void onSubscribeResult(long l10, String string2, String string3) {
    }

    public void onUnsubscribeResult(long l10, String string2, String string3) {
    }

    public void setCategory(String string2) {
        this.category = string2;
    }
}

