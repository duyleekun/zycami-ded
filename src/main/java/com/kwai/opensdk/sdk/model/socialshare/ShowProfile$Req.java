/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.kwai.opensdk.sdk.model.socialshare;

import android.os.Bundle;
import android.text.TextUtils;
import com.kwai.opensdk.sdk.constants.KwaiOpenSdkCmdEnum;
import com.kwai.opensdk.sdk.model.base.BaseReq;
import com.kwai.opensdk.sdk.utils.BundleUtil;

public class ShowProfile$Req
extends BaseReq {
    public String targetOpenId;

    public ShowProfile$Req() {
    }

    public ShowProfile$Req(Bundle bundle) {
        this.fromBundle(bundle);
    }

    public boolean checkArgs() {
        return TextUtils.isEmpty((CharSequence)this.targetOpenId) ^ true;
    }

    public void fromBundle(Bundle object) {
        super.fromBundle((Bundle)object);
        object = BundleUtil.getStringExtra(object, "kwai_bundle_target_open_id");
        this.targetOpenId = object;
    }

    public String getBundleKey() {
        return this.getCommand().getBundleKey();
    }

    public KwaiOpenSdkCmdEnum getCommand() {
        return KwaiOpenSdkCmdEnum.CMD_SHOW_PROFILE;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        String string2 = this.targetOpenId;
        bundle.putString("kwai_bundle_target_open_id", string2);
    }
}

