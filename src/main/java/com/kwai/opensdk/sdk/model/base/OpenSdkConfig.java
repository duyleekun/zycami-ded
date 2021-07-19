/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.kwai.opensdk.sdk.model.base;

import android.os.Bundle;
import com.kwai.opensdk.sdk.model.base.OpenSdkConfig$1;
import com.kwai.opensdk.sdk.model.base.OpenSdkConfig$Builder;
import com.kwai.opensdk.sdk.utils.BundleUtil;
import java.io.Serializable;

public class OpenSdkConfig
implements Serializable {
    private static final long serialVersionUID = 5705896069743590223L;
    private boolean isGoToMargetAppNotInstall = false;
    private boolean isGoToMargetAppVersionNotSupport = false;
    private boolean isSetClearTaskFlag = false;
    private boolean isSetNewTaskFlag = false;
    private boolean isShowDefaultLoading = false;

    private OpenSdkConfig(OpenSdkConfig$Builder openSdkConfig$Builder) {
        boolean bl2;
        boolean bl3;
        this.isSetNewTaskFlag = bl3 = OpenSdkConfig$Builder.access$000(openSdkConfig$Builder);
        this.isSetClearTaskFlag = bl3 = OpenSdkConfig$Builder.access$100(openSdkConfig$Builder);
        this.isGoToMargetAppNotInstall = bl3 = OpenSdkConfig$Builder.access$200(openSdkConfig$Builder);
        this.isGoToMargetAppVersionNotSupport = bl3 = OpenSdkConfig$Builder.access$300(openSdkConfig$Builder);
        this.isShowDefaultLoading = bl2 = OpenSdkConfig$Builder.access$400(openSdkConfig$Builder);
    }

    public /* synthetic */ OpenSdkConfig(OpenSdkConfig$Builder openSdkConfig$Builder, OpenSdkConfig$1 openSdkConfig$1) {
        this(openSdkConfig$Builder);
    }

    public void fromBundle(Bundle bundle) {
        boolean bl2;
        boolean bl3;
        this.isSetNewTaskFlag = bl3 = BundleUtil.getBooleanExtra(bundle, "kwai_bundle_is_set_new_task_flag");
        this.isSetClearTaskFlag = bl3 = BundleUtil.getBooleanExtra(bundle, "kwai_bundle_is_set_clear_task_flag");
        this.isGoToMargetAppNotInstall = bl3 = BundleUtil.getBooleanExtra(bundle, "kwai_bundle_is_goto_market_app_not_install");
        this.isGoToMargetAppVersionNotSupport = bl3 = BundleUtil.getBooleanExtra(bundle, "kwai_bundle_is_goto_market_app_version_not_support");
        this.isShowDefaultLoading = bl2 = BundleUtil.getBooleanExtra(bundle, "kwai_bundle_is_show_default_loading");
    }

    public boolean isGoToMargetAppNotInstall() {
        return this.isGoToMargetAppNotInstall;
    }

    public boolean isGoToMargetAppVersionNotSupport() {
        return this.isGoToMargetAppVersionNotSupport;
    }

    public boolean isSetClearTaskFlag() {
        return this.isSetClearTaskFlag;
    }

    public boolean isSetNewTaskFlag() {
        return this.isSetNewTaskFlag;
    }

    public boolean isShowDefaultLoading() {
        return this.isShowDefaultLoading;
    }

    public void toBundle(Bundle bundle) {
        boolean bl2 = this.isSetNewTaskFlag;
        bundle.putBoolean("kwai_bundle_is_set_new_task_flag", bl2);
        bl2 = this.isSetClearTaskFlag;
        bundle.putBoolean("kwai_bundle_is_set_clear_task_flag", bl2);
        bl2 = this.isGoToMargetAppNotInstall;
        bundle.putBoolean("kwai_bundle_is_goto_market_app_not_install", bl2);
        bl2 = this.isGoToMargetAppVersionNotSupport;
        bundle.putBoolean("kwai_bundle_is_goto_market_app_version_not_support", bl2);
        bl2 = this.isShowDefaultLoading;
        bundle.putBoolean("kwai_bundle_is_show_default_loading", bl2);
    }
}

