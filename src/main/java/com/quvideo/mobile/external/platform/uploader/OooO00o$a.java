/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.platform.uploader;

import com.quvideo.mobile.external.platform.uploader.OooO00o;
import com.quvideo.mobile.external.platform.uploader.OooOo00;
import com.quvideo.mobile.external.platform.uploader.listener.OooO0O0;

public class OooO00o$a
implements OooO0O0 {
    public final /* synthetic */ OooO00o a;

    public OooO00o$a(OooO00o oooO00o) {
        this.a = oooO00o;
    }

    public void OooO00o(String string2, int n10) {
        OooO0O0 oooO0O0 = this.a.OooO0OO.OooO0oo;
        if (oooO0O0 != null) {
            oooO0O0 = this.a.OooO0OO.OooO0oo;
            oooO0O0.OooO00o(string2, n10);
        }
    }

    public void OooO00o(String string2, int n10, String object) {
        OooOo00.a().h.OooO00o(string2);
        CharSequence charSequence = new StringBuilder();
        charSequence.append("[");
        String string3 = this.a.OooO0OO();
        charSequence.append(string3);
        string3 = "]";
        charSequence.append(string3);
        charSequence.append((String)object);
        charSequence.append(":");
        charSequence.append("uploadEntity=");
        object = this.a.OooO0OO;
        charSequence.append(object);
        object = this.a.OooO0OO.OooO0oo;
        if (object != null) {
            object = this.a.OooO0OO.OooO0oo;
            string3 = charSequence.toString();
            object.OooO00o(string2, n10, string3);
        }
        OooOo00.a().e(string2);
        object = this.a;
        charSequence = charSequence.toString();
        OooO00o.OooO00o((OooO00o)object, string2, n10, (String)charSequence);
        OooO00o.OooO00o(this.a);
    }

    public void OooO00o(String string2, String string3) {
        OooO00o.OooO00o(this.a, string2);
        OooOo00.a().h.OooO00o(string2);
        OooOo00.a().e(string2);
        OooO0O0 oooO0O0 = this.a.OooO0OO.OooO0oo;
        if (oooO0O0 != null) {
            oooO0O0 = this.a.OooO0OO.OooO0oo;
            oooO0O0.OooO00o(string2, string3);
        }
        OooO00o.OooO00o(this.a);
    }
}

