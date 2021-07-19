/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.kwai.opensdk.sdk.model.postshare;

import android.os.Bundle;
import com.kwai.opensdk.sdk.constants.KwaiOpenSdkCmdEnum;
import com.kwai.opensdk.sdk.model.base.BaseReq;
import com.kwai.opensdk.sdk.model.postshare.FileTypeUtil;
import com.kwai.opensdk.sdk.model.postshare.PostShareMediaInfo;
import com.kwai.opensdk.sdk.model.postshare.PostShareMediaInfo$Builder;
import java.io.File;
import java.util.ArrayList;

public class SingleVideoClip$Req
extends BaseReq {
    private int mPage = 1;
    public PostShareMediaInfo mediaInfo;

    public SingleVideoClip$Req() {
    }

    public SingleVideoClip$Req(Bundle bundle) {
        this.fromBundle(bundle);
    }

    private boolean isMediaFile() {
        int n10;
        Object object = this.mediaInfo.mMultiMediaAssets;
        boolean bl2 = false;
        if (object != null && (n10 = ((ArrayList)object).size()) != 0) {
            object = this.mediaInfo.mMultiMediaAssets;
            boolean bl3 = true;
            if (object != null && (n10 = ((ArrayList)object).size()) > 0) {
                boolean bl4;
                object = this.mediaInfo.mMultiMediaAssets.iterator();
                while (bl4 = object.hasNext()) {
                    String string2 = (String)object.next();
                    boolean bl5 = FileTypeUtil.isImageFile(string2);
                    if (bl5 || (bl4 = FileTypeUtil.isVideoFile(string2))) {
                        continue;
                    }
                    break;
                }
            } else {
                bl2 = bl3;
            }
        }
        return bl2;
    }

    private boolean isMediaFileExist() {
        int n10;
        ArrayList arrayList = this.mediaInfo.mMultiMediaAssets;
        int n11 = 0;
        if (arrayList != null && (n10 = arrayList.size()) != 0) {
            int n12;
            n10 = 1;
            Object object = this.mediaInfo.mMultiMediaAssets;
            if (object != null && (n12 = ((ArrayList)object).size()) > 0) {
                boolean bl2;
                object = this.mediaInfo.mMultiMediaAssets.iterator();
                while (bl2 = object.hasNext()) {
                    String string2 = (String)object.next();
                    File file = new File(string2);
                    bl2 = file.exists();
                    if (bl2) continue;
                    break;
                }
            } else {
                n11 = n10;
            }
        }
        return n11 != 0;
    }

    public boolean checkArgs() {
        boolean bl2;
        PostShareMediaInfo postShareMediaInfo = this.mediaInfo;
        if (postShareMediaInfo != null && (bl2 = postShareMediaInfo.checkArgs()) && ((bl2 = (postShareMediaInfo = this.mediaInfo).isUseMediaUri()) || (bl2 = this.isMediaFile()) && (bl2 = this.isMediaFileExist()))) {
            bl2 = true;
        } else {
            bl2 = false;
            postShareMediaInfo = null;
        }
        return bl2;
    }

    public void fromBundle(Bundle object) {
        super.fromBundle((Bundle)object);
        object = PostShareMediaInfo$Builder.fromBundle(object);
        this.mediaInfo = object;
    }

    public String getBundleKey() {
        return this.getCommand().getBundleKey();
    }

    public KwaiOpenSdkCmdEnum getCommand() {
        return KwaiOpenSdkCmdEnum.CMD_SINGLE_VIDEO_CLIP;
    }

    public int getPage() {
        return this.mPage;
    }

    public void toBundle(Bundle bundle) {
        Bundle bundle2 = PostShareMediaInfo$Builder.toBundle(this.mediaInfo);
        super.toBundle(bundle2);
        bundle.putAll(bundle2);
        int n10 = this.mPage;
        bundle.putInt("targetPage", n10);
    }
}

