/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.platform.uploader;

import com.quvideo.mobile.external.platform.uploader.OooOo00;
import com.quvideo.mobile.external.platform.uploader.OooOo00$OooO0OO;
import java.util.concurrent.ConcurrentHashMap;

public class OooOo00$a
implements OooOo00$OooO0OO {
    public final /* synthetic */ OooOo00 a;

    public OooOo00$a(OooOo00 oooOo00) {
        this.a = oooOo00;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void OooO00o(String string2) {
        Object object;
        try {
            object = this.a;
        }
        catch (Exception exception) {
            return;
        }
        object = OooOo00.b((OooOo00)object);
        ((ConcurrentHashMap)object).remove(string2);
    }
}

