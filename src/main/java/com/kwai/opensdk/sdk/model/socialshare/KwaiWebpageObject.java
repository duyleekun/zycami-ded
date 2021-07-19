/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.kwai.opensdk.sdk.model.socialshare;

import android.os.Bundle;
import com.kwai.opensdk.sdk.model.socialshare.KwaiMediaMessage$IMediaObject;
import com.kwai.opensdk.sdk.utils.BundleUtil;
import com.kwai.opensdk.sdk.utils.LogUtil;

public class KwaiWebpageObject
implements KwaiMediaMessage$IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    public String webpageUrl;

    public boolean checkArgs() {
        int n10;
        int n11;
        String string2 = this.webpageUrl;
        if (string2 != null && (n11 = string2.length()) != 0 && (n11 = (string2 = this.webpageUrl).length()) <= (n10 = 10240)) {
            return true;
        }
        LogUtil.e("KwaiOpenSdk", "KwaiWebpageObject checkArgs fail, webpageUrl is invalid");
        return false;
    }

    public void serialize(Bundle bundle) {
        String string2 = this.webpageUrl;
        bundle.putString("kwai_media_msg_webpageobject_url", string2);
    }

    public int type() {
        return 1;
    }

    public void unserialize(Bundle object) {
        object = BundleUtil.getStringExtra(object, "kwai_media_msg_webpageobject_url");
        this.webpageUrl = object;
    }
}

