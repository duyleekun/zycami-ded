/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.clientreport.data;

import android.content.Context;
import com.xiaomi.clientreport.data.Config;

public class Config$Builder {
    private String mAESKey;
    private int mEventEncrypted;
    private long mEventUploadFrequency;
    private int mEventUploadSwitchOpen;
    private long mMaxFileLength;
    private long mPerfUploadFrequency;
    private int mPerfUploadSwitchOpen;

    public Config$Builder() {
        long l10;
        int n10;
        this.mEventEncrypted = n10 = -1;
        this.mEventUploadSwitchOpen = n10;
        this.mPerfUploadSwitchOpen = n10;
        this.mAESKey = null;
        this.mMaxFileLength = l10 = (long)-1;
        this.mEventUploadFrequency = l10;
        this.mPerfUploadFrequency = l10;
    }

    public static /* synthetic */ int access$000(Config$Builder config$Builder) {
        return config$Builder.mEventEncrypted;
    }

    public static /* synthetic */ String access$100(Config$Builder config$Builder) {
        return config$Builder.mAESKey;
    }

    public static /* synthetic */ long access$200(Config$Builder config$Builder) {
        return config$Builder.mMaxFileLength;
    }

    public static /* synthetic */ long access$300(Config$Builder config$Builder) {
        return config$Builder.mEventUploadFrequency;
    }

    public static /* synthetic */ long access$400(Config$Builder config$Builder) {
        return config$Builder.mPerfUploadFrequency;
    }

    public static /* synthetic */ int access$500(Config$Builder config$Builder) {
        return config$Builder.mEventUploadSwitchOpen;
    }

    public static /* synthetic */ int access$600(Config$Builder config$Builder) {
        return config$Builder.mPerfUploadSwitchOpen;
    }

    public Config build(Context context) {
        Config config = new Config(context, this, null);
        return config;
    }

    public Config$Builder setAESKey(String string2) {
        this.mAESKey = string2;
        return this;
    }

    public Config$Builder setEventEncrypted(boolean bl2) {
        this.mEventEncrypted = (int)(bl2 ? 1 : 0);
        return this;
    }

    public Config$Builder setEventUploadFrequency(long l10) {
        this.mEventUploadFrequency = l10;
        return this;
    }

    public Config$Builder setEventUploadSwitchOpen(boolean bl2) {
        this.mEventUploadSwitchOpen = (int)(bl2 ? 1 : 0);
        return this;
    }

    public Config$Builder setMaxFileLength(long l10) {
        this.mMaxFileLength = l10;
        return this;
    }

    public Config$Builder setPerfUploadFrequency(long l10) {
        this.mPerfUploadFrequency = l10;
        return this;
    }

    public Config$Builder setPerfUploadSwitchOpen(boolean bl2) {
        this.mPerfUploadSwitchOpen = (int)(bl2 ? 1 : 0);
        return this;
    }
}

