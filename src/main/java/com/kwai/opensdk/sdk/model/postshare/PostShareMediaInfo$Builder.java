/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.kwai.opensdk.sdk.model.postshare;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kwai.opensdk.sdk.model.postshare.PostShareMediaInfo;
import com.kwai.opensdk.sdk.utils.BundleUtil;
import java.util.ArrayList;
import java.util.Map;

public class PostShareMediaInfo$Builder {
    public static PostShareMediaInfo fromBundle(Bundle object) {
        PostShareMediaInfo postShareMediaInfo;
        block8: {
            boolean bl2;
            postShareMediaInfo = new PostShareMediaInfo();
            Object object2 = BundleUtil.getStringArrayListExtra(object, "multiMediaPaths");
            postShareMediaInfo.mMultiMediaAssets = object2;
            postShareMediaInfo.mTag = object2 = BundleUtil.getStringExtra(object, "tag");
            postShareMediaInfo.mDisableFallback = bl2 = BundleUtil.getBooleanExtra(object, "forceTarget");
            postShareMediaInfo.mM2uExtraInfo = object2 = BundleUtil.getStringExtra(object, "m2uExtraInfo");
            postShareMediaInfo.mExtraInfo = object2 = BundleUtil.getStringExtra(object, "extraInfo");
            object2 = "additionMediaInfo";
            object = BundleUtil.getStringExtra(object, (String)object2);
            bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) break block8;
            object2 = new GsonBuilder();
            object2 = ((GsonBuilder)object2).create();
            Class<Map> clazz = Map.class;
            object = ((Gson)object2).fromJson((String)object, clazz);
            object = (Map)object;
            try {
                postShareMediaInfo.mMediaInfoMap = object;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return postShareMediaInfo;
    }

    public static Bundle toBundle(PostShareMediaInfo object) {
        Bundle bundle = new Bundle();
        Object object2 = ((PostShareMediaInfo)object).mMultiMediaAssets;
        bundle.putStringArrayList("multiMediaPaths", (ArrayList)object2);
        object2 = ((PostShareMediaInfo)object).mTag;
        bundle.putString("tag", (String)object2);
        boolean bl2 = ((PostShareMediaInfo)object).mDisableFallback;
        bundle.putBoolean("forceTarget", bl2);
        object2 = ((PostShareMediaInfo)object).mM2uExtraInfo;
        bundle.putString("m2uExtraInfo", (String)object2);
        object2 = ((PostShareMediaInfo)object).mExtraInfo;
        String string2 = "extraInfo";
        bundle.putString(string2, (String)object2);
        object2 = ((PostShareMediaInfo)object).mMediaInfoMap;
        if (object2 != null && !(bl2 = object2.isEmpty())) {
            object2 = new GsonBuilder();
            object2 = ((GsonBuilder)object2).create();
            object = ((PostShareMediaInfo)object).mMediaInfoMap;
            object = ((Gson)object2).toJson(object);
            object2 = "additionMediaInfo";
            try {
                bundle.putString((String)object2, (String)object);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return bundle;
    }
}

