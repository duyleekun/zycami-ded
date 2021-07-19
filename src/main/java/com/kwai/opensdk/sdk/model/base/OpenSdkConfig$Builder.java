/*
 * Decompiled with CFR 0.151.
 */
package com.kwai.opensdk.sdk.model.base;

import com.kwai.opensdk.sdk.model.base.OpenSdkConfig;

public final class OpenSdkConfig$Builder {
    private boolean isGoToMargetAppNotInstall = false;
    private boolean isGoToMargetAppVersionNotSupport = false;
    private boolean isSetClearTaskFlag = false;
    private boolean isSetNewTaskFlag = false;
    private boolean isShowDefaultLoading = false;

    public static /* synthetic */ boolean access$000(OpenSdkConfig$Builder openSdkConfig$Builder) {
        return openSdkConfig$Builder.isSetNewTaskFlag;
    }

    public static /* synthetic */ boolean access$100(OpenSdkConfig$Builder openSdkConfig$Builder) {
        return openSdkConfig$Builder.isSetClearTaskFlag;
    }

    public static /* synthetic */ boolean access$200(OpenSdkConfig$Builder openSdkConfig$Builder) {
        return openSdkConfig$Builder.isGoToMargetAppNotInstall;
    }

    public static /* synthetic */ boolean access$300(OpenSdkConfig$Builder openSdkConfig$Builder) {
        return openSdkConfig$Builder.isGoToMargetAppVersionNotSupport;
    }

    public static /* synthetic */ boolean access$400(OpenSdkConfig$Builder openSdkConfig$Builder) {
        return openSdkConfig$Builder.isShowDefaultLoading;
    }

    public OpenSdkConfig build() {
        OpenSdkConfig openSdkConfig = new OpenSdkConfig(this, null);
        return openSdkConfig;
    }

    public OpenSdkConfig$Builder setGoToMargetAppNotInstall(boolean bl2) {
        this.isGoToMargetAppNotInstall = bl2;
        return this;
    }

    public OpenSdkConfig$Builder setGoToMargetAppVersionNotSupport(boolean bl2) {
        this.isGoToMargetAppVersionNotSupport = bl2;
        return this;
    }

    public OpenSdkConfig$Builder setSetClearTaskFlag(boolean bl2) {
        this.isSetClearTaskFlag = bl2;
        return this;
    }

    public OpenSdkConfig$Builder setSetNewTaskFlag(boolean bl2) {
        this.isSetNewTaskFlag = bl2;
        return this;
    }

    public OpenSdkConfig$Builder setShowDefaultLoading(boolean bl2) {
        this.isShowDefaultLoading = bl2;
        return this;
    }
}

