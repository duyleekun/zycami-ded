/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.kwai.opensdk.sdk.model.socialshare;

import android.os.Bundle;
import com.kwai.opensdk.sdk.constants.KwaiOpenSdkCmdEnum;
import com.kwai.opensdk.sdk.model.base.BaseReq;
import com.kwai.opensdk.sdk.model.socialshare.KwaiMediaMessage;
import com.kwai.opensdk.sdk.model.socialshare.KwaiMediaMessage$Builder;

public class ShareMessage$Req
extends BaseReq {
    public KwaiMediaMessage message;

    public ShareMessage$Req() {
    }

    public ShareMessage$Req(Bundle bundle) {
        this.fromBundle(bundle);
    }

    public boolean checkArgs() {
        boolean bl2;
        KwaiMediaMessage kwaiMediaMessage = this.message;
        if (kwaiMediaMessage == null) {
            bl2 = false;
            kwaiMediaMessage = null;
        } else {
            bl2 = kwaiMediaMessage.checkArgs();
        }
        return bl2;
    }

    public void fromBundle(Bundle object) {
        super.fromBundle((Bundle)object);
        object = KwaiMediaMessage$Builder.fromBundle(object);
        this.message = object;
    }

    public String getBundleKey() {
        return this.getCommand().getBundleKey();
    }

    public KwaiOpenSdkCmdEnum getCommand() {
        return KwaiOpenSdkCmdEnum.CMD_SHARE_MESSAGE;
    }

    public void toBundle(Bundle bundle) {
        Bundle bundle2 = KwaiMediaMessage$Builder.toBundle(this.message);
        super.toBundle(bundle2);
        bundle.putAll(bundle2);
    }
}

