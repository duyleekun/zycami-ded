/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson;

import com.google.gson.FieldNamingPolicy$1;
import com.google.gson.FieldNamingPolicy$2;
import com.google.gson.FieldNamingPolicy$3;
import com.google.gson.FieldNamingPolicy$4;
import com.google.gson.FieldNamingPolicy$5;
import com.google.gson.FieldNamingPolicy$6;
import com.google.gson.FieldNamingStrategy;

public abstract class FieldNamingPolicy
extends Enum
implements FieldNamingStrategy {
    private static final /* synthetic */ FieldNamingPolicy[] $VALUES;
    public static final /* enum */ FieldNamingPolicy IDENTITY;
    public static final /* enum */ FieldNamingPolicy LOWER_CASE_WITH_DASHES;
    public static final /* enum */ FieldNamingPolicy LOWER_CASE_WITH_DOTS;
    public static final /* enum */ FieldNamingPolicy LOWER_CASE_WITH_UNDERSCORES;
    public static final /* enum */ FieldNamingPolicy UPPER_CAMEL_CASE;
    public static final /* enum */ FieldNamingPolicy UPPER_CAMEL_CASE_WITH_SPACES;

    static {
        FieldNamingPolicy$1 fieldNamingPolicy$1 = new FieldNamingPolicy$1();
        IDENTITY = fieldNamingPolicy$1;
        int n10 = 1;
        FieldNamingPolicy$2 fieldNamingPolicy$2 = new FieldNamingPolicy$2();
        UPPER_CAMEL_CASE = fieldNamingPolicy$2;
        int n11 = 2;
        FieldNamingPolicy$3 fieldNamingPolicy$3 = new FieldNamingPolicy$3();
        UPPER_CAMEL_CASE_WITH_SPACES = fieldNamingPolicy$3;
        int n12 = 3;
        FieldNamingPolicy$4 fieldNamingPolicy$4 = new FieldNamingPolicy$4();
        LOWER_CASE_WITH_UNDERSCORES = fieldNamingPolicy$4;
        int n13 = 4;
        FieldNamingPolicy$5 fieldNamingPolicy$5 = new FieldNamingPolicy$5();
        LOWER_CASE_WITH_DASHES = fieldNamingPolicy$5;
        int n14 = 5;
        FieldNamingPolicy$6 fieldNamingPolicy$6 = new FieldNamingPolicy$6();
        LOWER_CASE_WITH_DOTS = fieldNamingPolicy$6;
        FieldNamingPolicy[] fieldNamingPolicyArray = new FieldNamingPolicy[6];
        fieldNamingPolicyArray[0] = fieldNamingPolicy$1;
        fieldNamingPolicyArray[n10] = fieldNamingPolicy$2;
        fieldNamingPolicyArray[n11] = fieldNamingPolicy$3;
        fieldNamingPolicyArray[n12] = fieldNamingPolicy$4;
        fieldNamingPolicyArray[n13] = fieldNamingPolicy$5;
        fieldNamingPolicyArray[n14] = fieldNamingPolicy$6;
        $VALUES = fieldNamingPolicyArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private FieldNamingPolicy() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ FieldNamingPolicy(FieldNamingPolicy$1 varnull) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    public static String separateCamelCase(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = string2.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = string2.charAt(i10);
            int n11 = Character.isUpperCase(c10);
            if (n11 != 0 && (n11 = stringBuilder.length()) != 0) {
                stringBuilder.append(string3);
            }
            stringBuilder.append(c10);
        }
        return stringBuilder.toString();
    }

    public static String upperCaseFirstLetter(String string2) {
        boolean bl2;
        int n10;
        int n11 = string2.length();
        int n12 = 1;
        CharSequence charSequence = null;
        for (n10 = 0; !(bl2 = Character.isLetter(string2.charAt(n10))) && n10 < (n11 -= n12); ++n10) {
        }
        n11 = string2.charAt(n10);
        bl2 = Character.isUpperCase((char)n11);
        if (bl2) {
            return string2;
        }
        n11 = Character.toUpperCase((char)n11);
        if (n10 == 0) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((char)n11);
            string2 = string2.substring(n12);
            ((StringBuilder)charSequence).append(string2);
            return ((StringBuilder)charSequence).toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        charSequence = string2.substring(0, n10);
        stringBuilder.append((String)charSequence);
        stringBuilder.append((char)n11);
        string2 = string2.substring(n10 += n12);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static FieldNamingPolicy valueOf(String string2) {
        return Enum.valueOf(FieldNamingPolicy.class, string2);
    }

    public static FieldNamingPolicy[] values() {
        return (FieldNamingPolicy[])$VALUES.clone();
    }
}

