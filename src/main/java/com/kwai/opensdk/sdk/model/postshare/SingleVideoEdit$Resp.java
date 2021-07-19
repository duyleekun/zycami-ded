/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.kwai.opensdk.sdk.model.postshare;

import android.os.Bundle;
import com.kwai.opensdk.sdk.constants.KwaiOpenSdkCmdEnum;
import com.kwai.opensdk.sdk.model.base.BaseResp;

public class SingleVideoEdit$Resp
extends BaseResp {
    public SingleVideoEdit$Resp() {
    }

    public SingleVideoEdit$Resp(Bundle bundle) {
        this.fromBundle(bundle);
    }

    public boolean checkArgs() {
        return true;
    }

    public KwaiOpenSdkCmdEnum getCommand() {
        return KwaiOpenSdkCmdEnum.CMD_SINGLE_VIDEO_EDIT;
    }
}

