/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 */
package com.google.android.gms.internal.vision;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.vision.zzdg;
import com.google.android.gms.internal.vision.zzr;

public final class zzq {
    public static boolean zza(Context object, String string2, String string3) {
        object = zzdg.zzl(string3);
        string3 = "face";
        int n10 = string3.equals(string2);
        int n11 = 1;
        String string4 = "NativeLibraryLoader";
        if (!(n10 || (n10 = (string3 = "ica").equals(string2)) || (n10 = (int)((string3 = "ocr").equals(string2) ? 1 : 0)) || (n10 = (int)((string3 = "barcode").equals(string2) ? 1 : 0)))) {
            object = new Object[n11];
            object[0] = string2;
            object = String.format("Unrecognized engine: %s", (Object[])object);
            Log.e((String)string4, (String)object);
            return false;
        }
        string3 = ".so";
        n10 = ((String)object).lastIndexOf(string3);
        int n12 = ((String)object).length();
        int n13 = 3;
        if (n10 == (n12 -= n13)) {
            object = ((String)object).substring(0, n10);
        }
        if (!(n10 = ((String)object).indexOf(string3 = "lib"))) {
            object = ((String)object).substring(n13);
        }
        if (!(n10 = (int)(zzr.zza(string2, (String)object) ? 1 : 0))) {
            n12 = 2;
            Object[] objectArray = new Object[n12];
            objectArray[0] = string2;
            objectArray[n11] = object;
            object = String.format("%s engine not loaded with %s.", objectArray);
            Log.d((String)string4, (String)object);
        }
        return n10;
    }
}

