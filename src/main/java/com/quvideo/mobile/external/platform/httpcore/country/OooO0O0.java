/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.quvideo.mobile.external.platform.httpcore.country;

import android.text.TextUtils;
import com.quvideo.mobile.external.platform.httpcore.country.OooO0O0$OooO00o;
import com.quvideo.mobile.external.platform.httpcore.country.OooOO0O;

public class OooO0O0 {
    private String OooO00o;
    private OooOO0O OooO0O0;

    public String OooO00o() {
        return this.OooO00o;
    }

    public void OooO00o(OooO0O0$OooO00o oooO0O0$OooO00o) {
    }

    public void OooO00o(OooOO0O oooOO0O) {
        if (oooOO0O == null) {
            return;
        }
        this.OooO0O0 = oooOO0O;
    }

    public void OooO00o(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return;
        }
        this.OooO00o = string2;
    }

    public OooOO0O OooO0O0() {
        return this.OooO0O0;
    }
}

