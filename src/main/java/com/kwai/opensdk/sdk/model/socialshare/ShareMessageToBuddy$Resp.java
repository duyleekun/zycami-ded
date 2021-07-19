/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.kwai.opensdk.sdk.model.socialshare;

import android.os.Bundle;
import com.kwai.opensdk.sdk.constants.KwaiOpenSdkCmdEnum;
import com.kwai.opensdk.sdk.model.base.BaseResp;

public class ShareMessageToBuddy$Resp
extends BaseResp {
    public ShareMessageToBuddy$Resp() {
    }

    public ShareMessageToBuddy$Resp(Bundle bundle) {
        this.fromBundle(bundle);
    }

    public boolean checkArgs() {
        return true;
    }

    public KwaiOpenSdkCmdEnum getCommand() {
        return KwaiOpenSdkCmdEnum.CMD_SHARE_MESSAGE_TO_BUDDY;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
    }
}

