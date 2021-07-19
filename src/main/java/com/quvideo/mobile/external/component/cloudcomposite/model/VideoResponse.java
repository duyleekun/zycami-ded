/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.component.cloudcomposite.model;

import com.quvideo.mobile.external.component.cloudcomposite.model.VideoResponse$Data;
import com.quvideo.mobile.external.platform.api.cloudengine.model.CloudCompositeQueryListResponse;
import com.quvideo.mobile.external.platform.api.cloudengine.model.CloudCompositeQueryListResponse$Data;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoResponse {
    private List OooO00o;
    private boolean OooO0O0;

    public VideoResponse(CloudCompositeQueryListResponse cloudCompositeQueryListResponse) {
        boolean bl2;
        boolean bl3;
        ArrayList<VideoResponse$Data> arrayList = new ArrayList<VideoResponse$Data>();
        Iterator iterator2 = cloudCompositeQueryListResponse.data.iterator();
        while (bl3 = iterator2.hasNext()) {
            CloudCompositeQueryListResponse$Data cloudCompositeQueryListResponse$Data = (CloudCompositeQueryListResponse$Data)iterator2.next();
            String string2 = cloudCompositeQueryListResponse$Data.fileId;
            String string3 = cloudCompositeQueryListResponse$Data.fileUrl;
            String string4 = cloudCompositeQueryListResponse$Data.coverImageUrl;
            String string5 = cloudCompositeQueryListResponse$Data.duration;
            String string6 = cloudCompositeQueryListResponse$Data.businessId;
            VideoResponse$Data videoResponse$Data = new VideoResponse$Data(this, string2, string3, string4, string5, string6);
            arrayList.add(videoResponse$Data);
        }
        this.OooO00o = arrayList;
        this.OooO0O0 = bl2 = cloudCompositeQueryListResponse.hasMore;
    }

    public List getData() {
        return this.OooO00o;
    }

    public List getFileIds() {
        boolean bl2;
        ArrayList<String> arrayList = new ArrayList<String>();
        Iterator iterator2 = this.getData().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2 = ((VideoResponse$Data)iterator2.next()).getFileId();
            arrayList.add(string2);
        }
        return arrayList;
    }

    public boolean isHasMore() {
        return this.OooO0O0;
    }
}

