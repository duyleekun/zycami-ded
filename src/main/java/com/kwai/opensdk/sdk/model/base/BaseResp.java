/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.kwai.opensdk.sdk.model.base;

import android.os.Bundle;
import com.kwai.opensdk.sdk.constants.KwaiOpenSdkCmdEnum;
import com.kwai.opensdk.sdk.utils.BundleUtil;

public abstract class BaseResp {
    public int errorCode;
    public String errorMsg;
    public String platform;
    public String sessionId;
    public String transaction;

    public abstract boolean checkArgs();

    public void fromBundle(Bundle object) {
        String string2;
        int n10;
        this.errorCode = n10 = BundleUtil.getIntExtra(object, "kwai_bundle_error_code", 1);
        this.errorMsg = string2 = BundleUtil.getStringExtra(object, "kwai_bundle_error_msg");
        this.transaction = string2 = BundleUtil.getStringExtra(object, "kwai_bundle_transaction");
        this.sessionId = string2 = BundleUtil.getStringExtra(object, "kwai_bundle_session_id");
        object = BundleUtil.getStringExtra(object, "kwai_bundle_platform");
        this.platform = object;
    }

    public abstract KwaiOpenSdkCmdEnum getCommand();

    public void toBundle(Bundle bundle) {
        String string2 = this.getCommand().getCmdString();
        bundle.putString("kwai_bundle_command", string2);
        string2 = this.transaction;
        bundle.putString("kwai_bundle_transaction", string2);
        string2 = this.sessionId;
        bundle.putString("kwai_bundle_session_id", string2);
        int n10 = this.errorCode;
        bundle.putInt("kwai_bundle_error_code", n10);
        string2 = this.errorMsg;
        bundle.putString("kwai_bundle_error_msg", string2);
        string2 = this.platform;
        bundle.putString("kwai_bundle_platform", string2);
    }
}

