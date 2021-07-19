/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.vision.L;
import java.util.HashMap;

public final class zzr {
    private static final Object sLock;
    private static final HashMap zzcf;

    static {
        HashMap hashMap = new HashMap();
        sLock = hashMap;
        zzcf = hashMap = new HashMap();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean zza(String string2, String object) {
        Object object2 = sLock;
        synchronized (object2) {
            string2 = String.valueOf(string2);
            Object object3 = String.valueOf(object);
            int n10 = ((String)object3).length();
            if (n10 != 0) {
                string2 = string2.concat((String)object3);
            } else {
                object3 = new String(string2);
                string2 = object3;
            }
            object3 = zzcf;
            n10 = (int)(((HashMap)object3).containsKey(string2) ? 1 : 0);
            if (n10 != 0) {
                Object object4 = ((HashMap)object3).get(string2);
                object4 = (Integer)object4;
                n10 = (Integer)object4;
            } else {
                n10 = 0;
                Object var5_8 = null;
            }
            int n11 = n10 & 1;
            boolean bl2 = true;
            if (n11 != 0) {
                return bl2;
            }
            try {
                System.loadLibrary((String)object);
                n11 = n10 | 1;
                Integer n12 = n11;
                ((HashMap)object3).put(string2, n12);
                return bl2;
            }
            catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                n11 = n10 & 4;
                if (n11 == 0) {
                    String string3 = "System.loadLibrary failed: %s";
                    Object[] objectArray = new Object[bl2];
                    objectArray[0] = object;
                    L.e(unsatisfiedLinkError, string3, objectArray);
                    object = zzcf;
                    int n13 = n10 | 4;
                    Integer n14 = n13;
                    ((HashMap)object).put(string2, n14);
                }
                return false;
            }
        }
    }
}

