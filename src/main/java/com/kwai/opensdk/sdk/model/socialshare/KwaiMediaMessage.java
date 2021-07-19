/*
 * Decompiled with CFR 0.151.
 */
package com.kwai.opensdk.sdk.model.socialshare;

import com.kwai.opensdk.sdk.model.socialshare.KwaiMediaMessage$IMediaObject;
import com.kwai.opensdk.sdk.utils.LogUtil;

public final class KwaiMediaMessage {
    public static final int DESCRIPTION_LENGTH_LIMIT = 1024;
    public static final int THUMB_LENGTH_LIMIT = 65536;
    public static final int TITLE_LENGTH_LIMIT = 512;
    public String description;
    public KwaiMediaMessage$IMediaObject mediaObject;
    public byte[] thumbData;
    public String title;

    public final boolean checkArgs() {
        int n10;
        int n11;
        Object object = this.thumbData;
        String string2 = "KwaiOpenSdk";
        if (object != null && (n11 = ((byte[])object).length) <= (n10 = 65536)) {
            object = this.title;
            if (object != null && (n11 = ((String)object).length()) > (n10 = 512)) {
                LogUtil.e(string2, "KwaiMediaMessage checkArgs fail, title is invalid");
                return false;
            }
            object = this.description;
            if (object != null && (n11 = ((String)object).length()) > (n10 = 1024)) {
                LogUtil.e(string2, "KwaiMediaMessage checkArgs fail, description is invalid");
                return false;
            }
            object = this.mediaObject;
            if (object == null) {
                LogUtil.e(string2, "KwaiMediaMessage checkArgs fail, mediaObject is null");
                return false;
            }
            return object.checkArgs();
        }
        LogUtil.e(string2, "KwaiMediaMessage checkArgs fail, thumbData should not be null or exceed 64K");
        return false;
    }

    public final int getType() {
        int n10;
        KwaiMediaMessage$IMediaObject kwaiMediaMessage$IMediaObject = this.mediaObject;
        if (kwaiMediaMessage$IMediaObject == null) {
            n10 = 0;
            kwaiMediaMessage$IMediaObject = null;
        } else {
            n10 = kwaiMediaMessage$IMediaObject.type();
        }
        return n10;
    }
}

