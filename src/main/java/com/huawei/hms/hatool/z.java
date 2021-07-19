/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.huawei.hms.hatool;

import android.util.Log;
import com.huawei.hms.hatool.i1;

public class z {
    public boolean a = false;
    public int b = 4;

    public static String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HiAnalyticsSDK_2.2.0.308");
        String string2 = i1.a();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public void a(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append('\n');
        charSequence.append("=======================================\n ");
        String string2 = z.a();
        charSequence.append(string2);
        charSequence.append("");
        charSequence.append("\n=======================================");
        charSequence = charSequence.toString();
        Log.i((String)"HiAnalyticsSDK", (String)charSequence);
        this.b = n10;
        this.a = true;
    }

    public void a(int n10, String string2, String string3) {
        int n11 = 3;
        if (n10 != n11) {
            n11 = 5;
            if (n10 != n11) {
                n11 = 6;
                if (n10 != n11) {
                    Log.i((String)string2, (String)string3);
                } else {
                    Log.e((String)string2, (String)string3);
                }
            } else {
                Log.w((String)string2, (String)string3);
            }
        } else {
            Log.d((String)string2, (String)string3);
        }
    }

    public void b(int n10, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("=> ");
        stringBuilder.append(string3);
        string2 = stringBuilder.toString();
        this.a(n10, "HiAnalyticsSDK", string2);
    }

    public boolean b(int n10) {
        int n11 = this.a;
        n10 = n11 != 0 && n10 >= (n11 = this.b) ? 1 : 0;
        return n10 != 0;
    }
}

