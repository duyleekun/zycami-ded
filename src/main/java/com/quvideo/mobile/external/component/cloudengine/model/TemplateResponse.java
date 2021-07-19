/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.component.cloudengine.model;

import com.quvideo.mobile.external.component.cloudengine.model.TemplateResponse$Data;
import com.quvideo.mobile.external.platform.api.template.model.TemplateInfoListV3Response;
import com.quvideo.mobile.external.platform.api.template.model.TemplateInfoListV3Response$Data;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TemplateResponse {
    private List OooO00o;
    private boolean OooO0O0;

    public TemplateResponse(TemplateInfoListV3Response templateInfoListV3Response) {
        boolean bl2;
        boolean bl3;
        ArrayList<TemplateResponse$Data> arrayList = new ArrayList<TemplateResponse$Data>();
        Iterator iterator2 = templateInfoListV3Response.data.iterator();
        while (bl3 = iterator2.hasNext()) {
            TemplateInfoListV3Response$Data templateInfoListV3Response$Data = (TemplateInfoListV3Response$Data)iterator2.next();
            TemplateResponse$Data templateResponse$Data = new TemplateResponse$Data(templateInfoListV3Response$Data);
            arrayList.add(templateResponse$Data);
        }
        this.OooO00o = arrayList;
        this.OooO0O0 = bl2 = templateInfoListV3Response.hasMore;
    }

    public List getData() {
        return this.OooO00o;
    }

    public boolean isHasMore() {
        return this.OooO0O0;
    }
}

