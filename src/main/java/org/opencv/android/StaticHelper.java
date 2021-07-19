/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package org.opencv.android;

import android.util.Log;
import java.util.StringTokenizer;
import org.opencv.core.Core;

public class StaticHelper {
    private static final String a = "OpenCV/StaticHelper";

    public static boolean a(boolean bl2) {
        int n10;
        String string2;
        if (bl2) {
            StaticHelper.c("cudart");
            StaticHelper.c("nppc");
            StaticHelper.c("nppi");
            StaticHelper.c("npps");
            StaticHelper.c("cufft");
            string2 = "cublas";
            StaticHelper.c(string2);
        }
        string2 = a;
        Log.d((String)string2, (String)"Trying to get library list");
        String[] stringArray = "opencv_info";
        try {
            System.loadLibrary((String)stringArray);
            stringArray = StaticHelper.getLibraryList();
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            Log.e((String)string2, (String)"OpenCV error: Cannot load info library for OpenCV");
            stringArray = "";
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Library list: \"");
        charSequence.append((String)stringArray);
        String string3 = "\"";
        charSequence.append(string3);
        charSequence = charSequence.toString();
        Log.d((String)string2, (String)charSequence);
        Log.d((String)string2, (String)"First attempt to load libs");
        boolean bl3 = StaticHelper.b((String)stringArray);
        charSequence = null;
        if (bl3) {
            Log.d((String)string2, (String)"First attempt to load libs is OK");
            stringArray = System.getProperty("line.separator");
            string3 = Core.O0();
            for (String string4 : string3.split((String)stringArray)) {
                Log.i((String)string2, (String)string4);
            }
            n10 = 1;
        } else {
            stringArray = "First attempt to load libs fails";
            Log.d((String)string2, (String)stringArray);
        }
        return n10 != 0;
    }

    /*
     * WARNING - void declaration
     */
    private static boolean b(String string2) {
        void var4_7;
        int n11;
        Object object = a;
        String string3 = "Trying to init OpenCV libs";
        Log.d((String)object, (String)string3);
        if (string2 != null && (n11 = string2.length()) != 0) {
            Log.d((String)object, (String)"Trying to load libs by dependency list");
            string3 = ";";
            object = new StringTokenizer(string2, string3);
            boolean n10 = true;
            while ((n11 = (int)(((StringTokenizer)object).hasMoreTokens() ? 1 : 0)) != 0) {
                string3 = ((StringTokenizer)object).nextToken();
                n11 = (int)(StaticHelper.c(string3) ? 1 : 0);
                var4_5 &= n11;
            }
        } else {
            string2 = "opencv_java4";
            boolean bl2 = StaticHelper.c(string2);
        }
        return (boolean)var4_7;
    }

    private static boolean c(String string2) {
        boolean bl2;
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Trying to load library ");
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        String string3 = a;
        Log.d((String)string3, (String)charSequence);
        System.loadLibrary(string2);
        charSequence = new StringBuilder();
        CharSequence charSequence2 = "Library ";
        ((StringBuilder)charSequence).append((String)charSequence2);
        ((StringBuilder)charSequence).append(string2);
        charSequence2 = " loaded";
        ((StringBuilder)charSequence).append((String)charSequence2);
        charSequence = ((StringBuilder)charSequence).toString();
        try {
            Log.d((String)string3, (String)charSequence);
            bl2 = true;
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            charSequence2 = new StringBuilder();
            String string4 = "Cannot load library \"";
            ((StringBuilder)charSequence2).append(string4);
            ((StringBuilder)charSequence2).append(string2);
            ((StringBuilder)charSequence2).append("\"");
            string2 = ((StringBuilder)charSequence2).toString();
            Log.d((String)string3, (String)string2);
            unsatisfiedLinkError.printStackTrace();
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    private static native String getLibraryList();
}

