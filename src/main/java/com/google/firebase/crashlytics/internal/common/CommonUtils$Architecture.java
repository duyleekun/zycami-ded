/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.text.TextUtils
 */
package com.google.firebase.crashlytics.internal.common;

import android.os.Build;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class CommonUtils$Architecture
extends Enum {
    private static final /* synthetic */ CommonUtils$Architecture[] $VALUES;
    public static final /* enum */ CommonUtils$Architecture ARM64;
    public static final /* enum */ CommonUtils$Architecture ARMV6;
    public static final /* enum */ CommonUtils$Architecture ARMV7;
    public static final /* enum */ CommonUtils$Architecture ARMV7S;
    public static final /* enum */ CommonUtils$Architecture ARM_UNKNOWN;
    public static final /* enum */ CommonUtils$Architecture PPC;
    public static final /* enum */ CommonUtils$Architecture PPC64;
    public static final /* enum */ CommonUtils$Architecture UNKNOWN;
    public static final /* enum */ CommonUtils$Architecture X86_32;
    public static final /* enum */ CommonUtils$Architecture X86_64;
    private static final Map matcher;

    static {
        HashMap<String, CommonUtils$Architecture> hashMap;
        CommonUtils$Architecture commonUtils$Architecture;
        CommonUtils$Architecture commonUtils$Architecture2;
        CommonUtils$Architecture commonUtils$Architecture3;
        CommonUtils$Architecture commonUtils$Architecture4;
        CommonUtils$Architecture commonUtils$Architecture5;
        CommonUtils$Architecture commonUtils$Architecture6;
        CommonUtils$Architecture commonUtils$Architecture7;
        CommonUtils$Architecture commonUtils$Architecture8;
        CommonUtils$Architecture commonUtils$Architecture9;
        CommonUtils$Architecture commonUtils$Architecture10;
        X86_32 = commonUtils$Architecture10 = new CommonUtils$Architecture("X86_32", 0);
        int n10 = 1;
        X86_64 = commonUtils$Architecture9 = new CommonUtils$Architecture("X86_64", n10);
        int n11 = 2;
        ARM_UNKNOWN = commonUtils$Architecture8 = new CommonUtils$Architecture("ARM_UNKNOWN", n11);
        int n12 = 3;
        PPC = commonUtils$Architecture7 = new CommonUtils$Architecture("PPC", n12);
        PPC64 = commonUtils$Architecture6 = new CommonUtils$Architecture("PPC64", 4);
        ARMV6 = commonUtils$Architecture5 = new CommonUtils$Architecture("ARMV6", 5);
        ARMV7 = commonUtils$Architecture4 = new CommonUtils$Architecture("ARMV7", 6);
        UNKNOWN = commonUtils$Architecture3 = new CommonUtils$Architecture("UNKNOWN", 7);
        ARMV7S = commonUtils$Architecture2 = new CommonUtils$Architecture("ARMV7S", 8);
        int n13 = 9;
        ARM64 = commonUtils$Architecture = new CommonUtils$Architecture("ARM64", n13);
        CommonUtils$Architecture[] commonUtils$ArchitectureArray = new CommonUtils$Architecture[10];
        commonUtils$ArchitectureArray[0] = commonUtils$Architecture10;
        commonUtils$ArchitectureArray[n10] = commonUtils$Architecture9;
        commonUtils$ArchitectureArray[n11] = commonUtils$Architecture8;
        commonUtils$ArchitectureArray[n12] = commonUtils$Architecture7;
        int n14 = 4;
        commonUtils$ArchitectureArray[n14] = commonUtils$Architecture6;
        commonUtils$ArchitectureArray[5] = commonUtils$Architecture5;
        commonUtils$ArchitectureArray[6] = commonUtils$Architecture4;
        commonUtils$ArchitectureArray[7] = commonUtils$Architecture3;
        commonUtils$ArchitectureArray[8] = commonUtils$Architecture2;
        commonUtils$ArchitectureArray[n13] = commonUtils$Architecture;
        $VALUES = commonUtils$ArchitectureArray;
        matcher = hashMap = new HashMap<String, CommonUtils$Architecture>(n14);
        hashMap.put("armeabi-v7a", commonUtils$Architecture4);
        hashMap.put("armeabi", commonUtils$Architecture5);
        hashMap.put("arm64-v8a", commonUtils$Architecture);
        hashMap.put("x86", commonUtils$Architecture10);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CommonUtils$Architecture() {
        void var2_-1;
        void var1_-1;
    }

    public static CommonUtils$Architecture getValue() {
        Object object = Build.CPU_ABI;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            Logger.getLogger().v("Architecture#getValue()::Build.CPU_ABI returned null or empty");
            return UNKNOWN;
        }
        Object object2 = Locale.US;
        object = object.toLowerCase((Locale)object2);
        object2 = matcher;
        if ((object = (CommonUtils$Architecture)((Object)object2.get(object))) == null) {
            object = UNKNOWN;
        }
        return object;
    }

    public static CommonUtils$Architecture valueOf(String string2) {
        return Enum.valueOf(CommonUtils$Architecture.class, string2);
    }

    public static CommonUtils$Architecture[] values() {
        return (CommonUtils$Architecture[])$VALUES.clone();
    }
}

