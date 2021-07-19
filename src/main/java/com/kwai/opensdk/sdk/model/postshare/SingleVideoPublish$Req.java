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
import com.kwai.opensdk.sdk.utils.BundleUtil;
import java.io.File;
import java.util.ArrayList;

public class SingleVideoPublish$Req
extends BaseReq {
    public String mCover;
    private int mPage = 3;
    public PostShareMediaInfo mediaInfo;

    public SingleVideoPublish$Req() {
    }

    public SingleVideoPublish$Req(Bundle bundle) {
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
        PostShareMediaInfo postShareMediaInfo;
        super.fromBundle((Bundle)object);
        this.mediaInfo = postShareMediaInfo = PostShareMediaInfo$Builder.fromBundle(object);
        object = BundleUtil.getStringExtra(object, "coverFile");
        this.mCover = object;
    }

    public String getBundleKey() {
        return this.getCommand().getBundleKey();
    }

    public KwaiOpenSdkCmdEnum getCommand() {
        return KwaiOpenSdkCmdEnum.CMD_SINGLE_VIDEO_PUBLISH;
    }

    public int getPage() {
        return this.mPage;
    }

    public void toBundle(Bundle bundle) {
        Object object = PostShareMediaInfo$Builder.toBundle(this.mediaInfo);
        super.toBundle((Bundle)object);
        bundle.putAll(object);
        int n10 = this.mPage;
        bundle.putInt("targetPage", n10);
        object = this.mCover;
        bundle.putString("coverFile", (String)object);
    }
}

