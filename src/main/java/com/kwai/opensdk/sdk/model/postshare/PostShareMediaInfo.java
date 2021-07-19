/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.kwai.opensdk.sdk.model.postshare;

import android.net.Uri;
import com.kwai.opensdk.sdk.utils.UriUtil;
import java.util.ArrayList;
import java.util.Map;

public class PostShareMediaInfo {
    public boolean mDisableFallback;
    public String mExtraInfo;
    public String mM2uExtraInfo;
    public Map mMediaInfoMap;
    public ArrayList mMultiMediaAssets;
    public String mTag;

    public final boolean checkArgs() {
        return true;
    }

    public final boolean isUseMediaUri() {
        boolean bl2;
        block3: {
            int n10;
            Object object = this.mMultiMediaAssets;
            bl2 = false;
            if (object != null && (n10 = ((ArrayList)object).size()) != 0) {
                boolean bl3;
                object = this.mMultiMediaAssets.iterator();
                boolean bl4 = false;
                Uri uri = null;
                while (bl3 = object.hasNext()) {
                    uri = Uri.parse((String)((String)object.next()));
                    bl4 = UriUtil.isUriString(uri);
                    if (bl4) {
                        bl4 = true;
                        continue;
                    }
                    break block3;
                }
                bl2 = bl4;
            }
        }
        return bl2;
    }
}

