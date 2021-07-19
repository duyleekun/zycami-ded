/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.kwai.opensdk.sdk.model.socialshare;

import android.os.Bundle;
import com.kwai.opensdk.sdk.model.socialshare.KwaiMediaMessage;
import com.kwai.opensdk.sdk.model.socialshare.KwaiWebpageObject;
import com.kwai.opensdk.sdk.utils.BundleUtil;

public class KwaiMediaMessage$Builder {
    public static KwaiMediaMessage fromBundle(Bundle bundle) {
        int n10;
        KwaiMediaMessage kwaiMediaMessage = new KwaiMediaMessage();
        Object object = BundleUtil.getStringExtra(bundle, "kwai_media_msg_title");
        kwaiMediaMessage.title = object;
        object = BundleUtil.getStringExtra(bundle, "kwai_media_msg_description");
        kwaiMediaMessage.description = object;
        object = BundleUtil.getByteArrayExtra(bundle, "kwai_media_msg_thumbdata");
        kwaiMediaMessage.thumbData = (byte[])object;
        object = "kwai_media_msg_type";
        int n11 = BundleUtil.getIntExtra(bundle, (String)object, 0);
        if (n11 == (n10 = 1)) {
            kwaiMediaMessage.mediaObject = object = new KwaiWebpageObject();
        }
        object = kwaiMediaMessage.mediaObject;
        if (object != null) {
            object.unserialize(bundle);
        }
        return kwaiMediaMessage;
    }

    public static Bundle toBundle(KwaiMediaMessage object) {
        Bundle bundle = new Bundle();
        Object object2 = ((KwaiMediaMessage)object).title;
        bundle.putString("kwai_media_msg_title", (String)object2);
        object2 = ((KwaiMediaMessage)object).description;
        bundle.putString("kwai_media_msg_description", (String)object2);
        object2 = ((KwaiMediaMessage)object).thumbData;
        bundle.putByteArray("kwai_media_msg_thumbdata", (byte[])object2);
        int n10 = ((KwaiMediaMessage)object).getType();
        String string2 = "kwai_media_msg_type";
        bundle.putInt(string2, n10);
        object = ((KwaiMediaMessage)object).mediaObject;
        if (object != null) {
            object.serialize(bundle);
        }
        return bundle;
    }
}

