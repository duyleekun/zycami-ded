/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.PushConfiguration;
import com.xiaomi.push.service.module.PushChannelRegion;

public class PushConfiguration$PushConfigurationBuilder {
    private boolean mGeoEnable;
    private boolean mOpenCOSPush;
    private boolean mOpenFCMPush;
    private boolean mOpenFTOSPush;
    private boolean mOpenHmsPush;
    private PushChannelRegion mRegion;

    public static /* synthetic */ PushChannelRegion access$000(PushConfiguration$PushConfigurationBuilder pushConfiguration$PushConfigurationBuilder) {
        return pushConfiguration$PushConfigurationBuilder.mRegion;
    }

    public static /* synthetic */ boolean access$100(PushConfiguration$PushConfigurationBuilder pushConfiguration$PushConfigurationBuilder) {
        return pushConfiguration$PushConfigurationBuilder.mOpenHmsPush;
    }

    public static /* synthetic */ boolean access$200(PushConfiguration$PushConfigurationBuilder pushConfiguration$PushConfigurationBuilder) {
        return pushConfiguration$PushConfigurationBuilder.mOpenFCMPush;
    }

    public static /* synthetic */ boolean access$300(PushConfiguration$PushConfigurationBuilder pushConfiguration$PushConfigurationBuilder) {
        return pushConfiguration$PushConfigurationBuilder.mOpenCOSPush;
    }

    public static /* synthetic */ boolean access$400(PushConfiguration$PushConfigurationBuilder pushConfiguration$PushConfigurationBuilder) {
        return pushConfiguration$PushConfigurationBuilder.mOpenFTOSPush;
    }

    public PushConfiguration build() {
        PushConfiguration pushConfiguration = new PushConfiguration(this, null);
        return pushConfiguration;
    }

    public PushConfiguration$PushConfigurationBuilder openCOSPush(boolean bl2) {
        this.mOpenCOSPush = bl2;
        return this;
    }

    public PushConfiguration$PushConfigurationBuilder openFCMPush(boolean bl2) {
        this.mOpenFCMPush = bl2;
        return this;
    }

    public PushConfiguration$PushConfigurationBuilder openFTOSPush(boolean bl2) {
        this.mOpenFTOSPush = bl2;
        return this;
    }

    public PushConfiguration$PushConfigurationBuilder openHmsPush(boolean bl2) {
        this.mOpenHmsPush = bl2;
        return this;
    }

    public PushConfiguration$PushConfigurationBuilder region(PushChannelRegion pushChannelRegion) {
        this.mRegion = pushChannelRegion;
        return this;
    }
}

