/*
 * Decompiled with CFR 0.151.
 */
package d.p.a.a.a.c;

import com.google.gson.FieldNamingPolicy;

public class a$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        FieldNamingPolicy fieldNamingPolicy;
        int n12 = FieldNamingPolicy.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            fieldNamingPolicy = FieldNamingPolicy.UPPER_CAMEL_CASE;
            n11 = fieldNamingPolicy.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            fieldNamingPolicy = FieldNamingPolicy.UPPER_CAMEL_CASE_WITH_SPACES;
            n11 = fieldNamingPolicy.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            fieldNamingPolicy = FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;
            n11 = fieldNamingPolicy.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            fieldNamingPolicy = FieldNamingPolicy.LOWER_CASE_WITH_DASHES;
            n11 = fieldNamingPolicy.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            fieldNamingPolicy = FieldNamingPolicy.LOWER_CASE_WITH_DOTS;
            n11 = fieldNamingPolicy.ordinal();
            nArray[n11] = n10 = 5;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

