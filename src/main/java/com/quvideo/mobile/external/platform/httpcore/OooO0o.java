/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.platform.httpcore;

import com.quvideo.mobile.external.platform.httpcore.OooO0o$a;
import com.quvideo.mobile.external.platform.httpcore.country.OooO;
import com.quvideo.mobile.external.platform.httpcore.country.OooOO0O;

public class OooO0o {
    private String OooO00o;

    public OooO0o() {
        Object object = OooO.OooO00o().OooO0OO();
        object = this.OooO00o((OooOO0O)((Object)object));
        this.OooO00o = object;
    }

    private String OooO00o(OooOO0O oooOO0O) {
        int[] nArray = OooO0o$a.a;
        int n10 = oooOO0O.ordinal();
        int n11 = 2;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 3;
            if (n10 != n11) {
                n11 = 4;
                if (n10 != n11) {
                    return "https://cloudservice-gateway.rthdo.com";
                }
                return "https://cloudservice-gateway-flkf.intsvs.com";
            }
            return "https://cloudservice-gateway-asia1.intsvs.com";
        }
        return "https://cloudservice-gateway-us.intsvs.com";
    }

    public String OooO00o() {
        return this.OooO00o;
    }
}

