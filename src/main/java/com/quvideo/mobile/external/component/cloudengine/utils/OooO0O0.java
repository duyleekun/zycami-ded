/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.component.cloudengine.utils;

import com.quvideo.mobile.external.component.cloudengine.utils.OooO00o;

public class OooO0O0 {
    public static OooO00o OooO00o(String object, String string2, String string3) {
        if (object != null && string2 != null) {
            boolean bl2 = OooO0O0.OooO00o((String)object, string2);
            if (bl2) {
                OooO00o oooO00o = new OooO00o((String)object, string2, string3);
                return oooO00o;
            }
            object = new IllegalArgumentException("appKey & appSecret are't available!");
            throw object;
        }
        object = new IllegalArgumentException("appKey & appSecret can't be null!");
        throw object;
    }

    private static boolean OooO00o(String string2, String string3) {
        return true;
    }
}

