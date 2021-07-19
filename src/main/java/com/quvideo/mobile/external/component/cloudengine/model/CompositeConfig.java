/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.quvideo.mobile.external.component.cloudengine.model;

import android.net.Uri;
import com.quvideo.mobile.external.component.cloudcomposite.core.OooO0OO;
import com.quvideo.mobile.external.component.cloudcomposite.core.OooO0OO$OooO00o;
import com.quvideo.mobile.external.component.cloudcomposite.core.OooO0o;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.MediaType;
import com.quvideo.mobile.external.component.cloudengine.model.CompositeConfig$Media;
import com.quvideo.mobile.external.component.cloudengine.model.CompositeConfig$Resolution;
import java.util.ArrayList;
import java.util.List;

public class CompositeConfig {
    private boolean OooO00o;
    private MediaType OooO0O0;
    private long OooO0OO;
    private List OooO0Oo;
    private CompositeConfig$Resolution OooO0o0;

    public CompositeConfig(long l10, CompositeConfig$Resolution compositeConfig$Resolution, List list) {
        this(l10, compositeConfig$Resolution, list, false);
    }

    public CompositeConfig(long l10, CompositeConfig$Resolution enum_, List list, boolean bl2) {
        this.OooO00o = bl2;
        this.OooO0o0 = enum_;
        this.OooO0O0 = enum_ = MediaType.VIDEO;
        this.OooO0OO = l10;
        this.OooO0Oo = list;
    }

    public MediaType getFileType() {
        return this.OooO0O0;
    }

    public List getLocalMedia() {
        return this.OooO0Oo;
    }

    public long getTemplateId() {
        return this.OooO0OO;
    }

    public boolean isForceMake() {
        return this.OooO00o;
    }

    public OooO0o toCompositeConfig(String object, String string2) {
        OooO0OO oooO0OO;
        Object object2;
        Object object3;
        boolean bl2;
        ArrayList<OooO0OO$OooO00o> arrayList = new ArrayList<OooO0OO$OooO00o>();
        Object object4 = this.OooO0Oo.iterator();
        while (bl2 = object4.hasNext()) {
            CompositeConfig$Media compositeConfig$Media = (CompositeConfig$Media)object4.next();
            object3 = CompositeConfig$Media.OooO00o(compositeConfig$Media);
            compositeConfig$Media = CompositeConfig$Media.OooO0O0(compositeConfig$Media);
            object2 = new OooO0OO$OooO00o((MediaType)((Object)object3), (Uri)compositeConfig$Media);
            arrayList.add((OooO0OO$OooO00o)object2);
        }
        bl2 = this.OooO00o;
        object2 = this.OooO0O0;
        long l10 = this.OooO0OO;
        int n10 = this.OooO0o0.getValue();
        object4 = oooO0OO;
        object3 = object;
        oooO0OO = new OooO0OO(bl2, (MediaType)((Object)object2), (String)object, string2, l10, n10, arrayList);
        object = new OooO0o(3000, 60, -1, oooO0OO);
        return object;
    }
}

