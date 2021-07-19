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
import com.kwai.opensdk.sdk.model.socialshare.KwaiMediaMessage;
import com.kwai.opensdk.sdk.model.socialshare.KwaiMediaMessage$Builder;
import com.kwai.opensdk.sdk.utils.BundleUtil;

public class ShareMessageToBuddy$Req
extends BaseReq {
    public KwaiMediaMessage message;
    public String openId;
    public String targetOpenId;

    public ShareMessageToBuddy$Req() {
    }

    public ShareMessageToBuddy$Req(Bundle bundle) {
        this.fromBundle(bundle);
    }

    public boolean checkArgs() {
        String string2;
        boolean bl2;
        Object object = this.message;
        if (object != null && (bl2 = ((KwaiMediaMessage)object).checkArgs()) && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.targetOpenId))) && !(bl2 = ((String)(object = this.targetOpenId)).equals(string2 = this.openId))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public void fromBundle(Bundle object) {
        super.fromBundle((Bundle)object);
        Object object2 = KwaiMediaMessage$Builder.fromBundle(object);
        this.message = object2;
        this.targetOpenId = object2 = BundleUtil.getStringExtra(object, "kwai_bundle_target_open_id");
        object = BundleUtil.getStringExtra(object, "kwai_bundle_open_id");
        this.openId = object;
    }

    public String getBundleKey() {
        return this.getCommand().getBundleKey();
    }

    public KwaiOpenSdkCmdEnum getCommand() {
        return KwaiOpenSdkCmdEnum.CMD_SHARE_MESSAGE_TO_BUDDY;
    }

    public void toBundle(Bundle bundle) {
        Object object = KwaiMediaMessage$Builder.toBundle(this.message);
        super.toBundle((Bundle)object);
        bundle.putAll(object);
        object = this.targetOpenId;
        bundle.putString("kwai_bundle_target_open_id", (String)object);
        object = this.openId;
        bundle.putString("kwai_bundle_open_id", (String)object);
    }
}

