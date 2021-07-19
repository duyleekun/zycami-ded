/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.PushConfiguration$PushConfigurationBuilder;
import com.xiaomi.mipush.sdk.ai;
import com.xiaomi.push.service.module.PushChannelRegion;

public class PushConfiguration {
    private boolean mGeoEnable;
    private boolean mOpenCOSPush;
    private boolean mOpenFCMPush;
    private boolean mOpenFTOSPush;
    private boolean mOpenHmsPush;
    private PushChannelRegion mRegion;

    public PushConfiguration() {
        PushChannelRegion pushChannelRegion;
        this.mRegion = pushChannelRegion = PushChannelRegion.China;
        this.mOpenHmsPush = false;
        this.mOpenFCMPush = false;
        this.mOpenCOSPush = false;
        this.mOpenFTOSPush = false;
    }

    private PushConfiguration(PushConfiguration$PushConfigurationBuilder pushConfiguration$PushConfigurationBuilder) {
        boolean bl2;
        boolean bl3;
        PushChannelRegion pushChannelRegion = PushConfiguration$PushConfigurationBuilder.access$000(pushConfiguration$PushConfigurationBuilder);
        pushChannelRegion = pushChannelRegion == null ? PushChannelRegion.China : PushConfiguration$PushConfigurationBuilder.access$000(pushConfiguration$PushConfigurationBuilder);
        this.mRegion = pushChannelRegion;
        this.mOpenHmsPush = bl3 = PushConfiguration$PushConfigurationBuilder.access$100(pushConfiguration$PushConfigurationBuilder);
        this.mOpenFCMPush = bl3 = PushConfiguration$PushConfigurationBuilder.access$200(pushConfiguration$PushConfigurationBuilder);
        this.mOpenCOSPush = bl3 = PushConfiguration$PushConfigurationBuilder.access$300(pushConfiguration$PushConfigurationBuilder);
        this.mOpenFTOSPush = bl2 = PushConfiguration$PushConfigurationBuilder.access$400(pushConfiguration$PushConfigurationBuilder);
    }

    public /* synthetic */ PushConfiguration(PushConfiguration$PushConfigurationBuilder pushConfiguration$PushConfigurationBuilder, ai ai2) {
        this(pushConfiguration$PushConfigurationBuilder);
    }

    public boolean getOpenCOSPush() {
        return this.mOpenCOSPush;
    }

    public boolean getOpenFCMPush() {
        return this.mOpenFCMPush;
    }

    public boolean getOpenFTOSPush() {
        return this.mOpenFTOSPush;
    }

    public boolean getOpenHmsPush() {
        return this.mOpenHmsPush;
    }

    public PushChannelRegion getRegion() {
        return this.mRegion;
    }

    public void setOpenCOSPush(boolean bl2) {
        this.mOpenCOSPush = bl2;
    }

    public void setOpenFCMPush(boolean bl2) {
        this.mOpenFCMPush = bl2;
    }

    public void setOpenFTOSPush(boolean bl2) {
        this.mOpenFTOSPush = bl2;
    }

    public void setOpenHmsPush(boolean bl2) {
        this.mOpenHmsPush = bl2;
    }

    public void setRegion(PushChannelRegion pushChannelRegion) {
        this.mRegion = pushChannelRegion;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("PushConfiguration{");
        stringBuffer.append("Region:");
        Object object = this.mRegion;
        object = object == null ? "null" : ((Enum)object).name();
        stringBuffer.append((String)object);
        object = new StringBuilder();
        ((StringBuilder)object).append(",mOpenHmsPush:");
        boolean bl2 = this.mOpenHmsPush;
        ((StringBuilder)object).append(bl2);
        object = ((StringBuilder)object).toString();
        stringBuffer.append((String)object);
        object = new StringBuilder();
        ((StringBuilder)object).append(",mOpenFCMPush:");
        bl2 = this.mOpenFCMPush;
        ((StringBuilder)object).append(bl2);
        object = ((StringBuilder)object).toString();
        stringBuffer.append((String)object);
        object = new StringBuilder();
        ((StringBuilder)object).append(",mOpenCOSPush:");
        bl2 = this.mOpenCOSPush;
        ((StringBuilder)object).append(bl2);
        object = ((StringBuilder)object).toString();
        stringBuffer.append((String)object);
        object = new StringBuilder();
        ((StringBuilder)object).append(",mOpenFTOSPush:");
        bl2 = this.mOpenFTOSPush;
        ((StringBuilder)object).append(bl2);
        object = ((StringBuilder)object).toString();
        stringBuffer.append((String)object);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}

