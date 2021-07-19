/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.f;

import com.baidu.location.f.i;

public final class e {
    public static String a(int n10) {
        i i10 = i.a();
        boolean bl2 = i10.j();
        if (bl2) {
            return "WIFI";
        }
        switch (n10) {
            default: {
                return "unknown";
            }
            case 13: {
                return "4G";
            }
            case 3: 
            case 5: 
            case 6: 
            case 8: 
            case 9: 
            case 10: 
            case 12: 
            case 14: 
            case 15: {
                return "3G";
            }
            case 1: 
            case 2: 
            case 4: 
            case 7: 
            case 11: 
        }
        return "2G";
    }
}

