/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.clientreport.data;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.Config$Builder;
import com.xiaomi.clientreport.data.b;
import com.xiaomi.push.bj;

public class Config {
    public static final boolean DEFAULT_EVENT_ENCRYPTED = true;
    public static final long DEFAULT_EVENT_UPLOAD_FREQUENCY = 86400L;
    public static final boolean DEFAULT_EVENT_UPLOAD_SWITCH_OPEN = false;
    public static final long DEFAULT_MAX_FILE_LENGTH = 0x100000L;
    public static final long DEFAULT_PERF_UPLOAD_FREQUENCY = 86400L;
    public static final boolean DEFAULT_PERF_UPLOAD_SWITCH_OPEN = false;
    private String mAESKey;
    private boolean mEventEncrypted;
    private long mEventUploadFrequency;
    private boolean mEventUploadSwitchOpen;
    private long mMaxFileLength;
    private long mPerfUploadFrequency;
    private boolean mPerfUploadSwitchOpen;

    private Config() {
        long l10;
        this.mEventEncrypted = true;
        this.mEventUploadSwitchOpen = false;
        this.mPerfUploadSwitchOpen = false;
        this.mMaxFileLength = 0x100000L;
        this.mEventUploadFrequency = l10 = 86400L;
        this.mPerfUploadFrequency = l10;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private Config(Context object, Config$Builder config$Builder) {
        int n10;
        int n11;
        void var1_4;
        void var2_5;
        long l10;
        long l11;
        int n12;
        this.mEventEncrypted = n12 = 1;
        this.mEventUploadSwitchOpen = false;
        this.mPerfUploadSwitchOpen = false;
        this.mMaxFileLength = l11 = 0x100000L;
        this.mEventUploadFrequency = l10 = 86400L;
        this.mPerfUploadFrequency = l10;
        int n13 = Config$Builder.access$000((Config$Builder)var2_5);
        if (n13 == 0) {
            this.mEventEncrypted = false;
        } else {
            n13 = Config$Builder.access$000((Config$Builder)var2_5);
            this.mEventEncrypted = n12;
        }
        String string2 = Config$Builder.access$100((Config$Builder)var2_5);
        n13 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
        if (n13 == 0) {
            String string3 = Config$Builder.access$100((Config$Builder)var2_5);
        } else {
            String string4 = bj.a(object);
        }
        this.mAESKey = var1_4;
        long l12 = Config$Builder.access$200((Config$Builder)var2_5);
        long l13 = -1;
        long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (l14 > 0) {
            l11 = Config$Builder.access$200((Config$Builder)var2_5);
        }
        this.mMaxFileLength = l11;
        l11 = Config$Builder.access$300((Config$Builder)var2_5);
        long l15 = l11 - l13;
        Object object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        this.mEventUploadFrequency = object2 > 0 ? (l11 = Config$Builder.access$300((Config$Builder)var2_5)) : l10;
        l11 = Config$Builder.access$400((Config$Builder)var2_5);
        long l16 = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1);
        this.mPerfUploadFrequency = l16 > 0 ? (l11 = Config$Builder.access$400((Config$Builder)var2_5)) : l10;
        int n14 = Config$Builder.access$500((Config$Builder)var2_5);
        this.mEventUploadSwitchOpen = n14 != 0 && (n11 = Config$Builder.access$500((Config$Builder)var2_5)) == n12 ? n12 : false;
        int n15 = Config$Builder.access$600((Config$Builder)var2_5);
        if (n15 == 0 || (n10 = Config$Builder.access$600((Config$Builder)var2_5)) != n12) {
            this.mPerfUploadSwitchOpen = false;
            return;
        }
        this.mPerfUploadSwitchOpen = n12;
    }

    public /* synthetic */ Config(Context context, Config$Builder config$Builder, b b10) {
        this(context, config$Builder);
    }

    public static Config defaultConfig(Context context) {
        Config$Builder config$Builder = Config.getBuilder().setEventEncrypted(true);
        String string2 = bj.a(context);
        config$Builder = config$Builder.setAESKey(string2).setMaxFileLength(0x100000L).setEventUploadSwitchOpen(false);
        long l10 = 86400L;
        return config$Builder.setEventUploadFrequency(l10).setPerfUploadSwitchOpen(false).setPerfUploadFrequency(l10).build(context);
    }

    public static Config$Builder getBuilder() {
        Config$Builder config$Builder = new Config$Builder();
        return config$Builder;
    }

    public long getEventUploadFrequency() {
        return this.mEventUploadFrequency;
    }

    public long getMaxFileLength() {
        return this.mMaxFileLength;
    }

    public long getPerfUploadFrequency() {
        return this.mPerfUploadFrequency;
    }

    public boolean isEventEncrypted() {
        return this.mEventEncrypted;
    }

    public boolean isEventUploadSwitchOpen() {
        return this.mEventUploadSwitchOpen;
    }

    public boolean isPerfUploadSwitchOpen() {
        return this.mPerfUploadSwitchOpen;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Config{mEventEncrypted=");
        boolean bl2 = this.mEventEncrypted;
        stringBuilder.append(bl2);
        stringBuilder.append(", mAESKey='");
        String string2 = this.mAESKey;
        stringBuilder.append(string2);
        stringBuilder.append('\'');
        stringBuilder.append(", mMaxFileLength=");
        long l10 = this.mMaxFileLength;
        stringBuilder.append(l10);
        stringBuilder.append(", mEventUploadSwitchOpen=");
        bl2 = this.mEventUploadSwitchOpen;
        stringBuilder.append(bl2);
        stringBuilder.append(", mPerfUploadSwitchOpen=");
        bl2 = this.mPerfUploadSwitchOpen;
        stringBuilder.append(bl2);
        stringBuilder.append(", mEventUploadFrequency=");
        l10 = this.mEventUploadFrequency;
        stringBuilder.append(l10);
        stringBuilder.append(", mPerfUploadFrequency=");
        l10 = this.mPerfUploadFrequency;
        stringBuilder.append(l10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

