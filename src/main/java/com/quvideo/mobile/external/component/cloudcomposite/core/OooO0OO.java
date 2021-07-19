/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.component.cloudcomposite.core;

import com.quvideo.mobile.external.component.cloudcomposite.core.OooO0OO$OooO00o;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.MediaType;
import com.quvideo.mobile.external.platform.api.cloudengine.model.CloudCompositeMakeRequest;
import com.quvideo.mobile.external.platform.api.cloudengine.model.CloudCompositeMakeRequest$DataList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OooO0OO {
    private boolean OooO00o;
    private MediaType OooO0O0;
    private String OooO0OO;
    private String OooO0Oo;
    private List OooO0o;
    private long OooO0o0;
    private int OooO0oO;

    public OooO0OO(boolean bl2, MediaType mediaType, String string2, String string3, long l10, int n10, List list) {
        this.OooO00o = bl2;
        this.OooO0O0 = mediaType;
        this.OooO0OO = string2;
        this.OooO0Oo = string3;
        this.OooO0o0 = l10;
        this.OooO0oO = n10;
        this.OooO0o = list;
    }

    public CloudCompositeMakeRequest OooO00o(boolean bl2) {
        boolean bl3;
        boolean bl4;
        CloudCompositeMakeRequest cloudCompositeMakeRequest = new CloudCompositeMakeRequest();
        if (!bl2) {
            bl4 = this.OooO00o;
        }
        cloudCompositeMakeRequest.setForceMake(bl4);
        long l10 = this.OooO0O0.value();
        cloudCompositeMakeRequest.setFileType(l10);
        ArrayList<Object> arrayList = this.OooO0OO;
        cloudCompositeMakeRequest.setCountry((String)((Object)arrayList));
        arrayList = this.OooO0Oo;
        cloudCompositeMakeRequest.setLang((String)((Object)arrayList));
        l10 = this.OooO0o0;
        cloudCompositeMakeRequest.setTemplateId(l10);
        int n10 = this.OooO0oO;
        cloudCompositeMakeRequest.setResolution(n10);
        arrayList = new ArrayList<Object>();
        Iterator iterator2 = this.OooO0o.iterator();
        while (bl3 = iterator2.hasNext()) {
            Object object = (OooO0OO$OooO00o)iterator2.next();
            Object object2 = OooO0OO$OooO00o.OooO00o((OooO0OO$OooO00o)object);
            if (object2 == null) continue;
            String string2 = OooO0OO$OooO00o.OooO00o((OooO0OO$OooO00o)object);
            object = OooO0OO$OooO00o.OooO0O0((OooO0OO$OooO00o)object);
            object2 = new CloudCompositeMakeRequest$DataList(cloudCompositeMakeRequest, string2, (List)object);
            arrayList.add(object2);
        }
        cloudCompositeMakeRequest.setDataList(arrayList);
        return cloudCompositeMakeRequest;
    }

    public List OooO00o() {
        return this.OooO0o;
    }

    public boolean OooO0O0() {
        boolean bl2;
        Iterator iterator2 = this.OooO0o.iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2 = OooO0OO$OooO00o.OooO00o((OooO0OO$OooO00o)iterator2.next());
            if (string2 != null) continue;
            return false;
        }
        return true;
    }
}

