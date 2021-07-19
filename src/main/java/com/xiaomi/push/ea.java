/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.xiaomi.push.bc;
import com.xiaomi.push.ed;
import com.xiaomi.push.ho;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ea
extends ed {
    private String a;

    public ea(Context context, int n10, String string2) {
        super(context, n10);
        this.a = string2;
    }

    private String[] a() {
        int n10;
        String[] stringArray = this.a;
        boolean bl2 = TextUtils.isEmpty((CharSequence)stringArray);
        if (!bl2 && (n10 = TextUtils.isEmpty((CharSequence)(stringArray = bc.b(this.a)))) == 0) {
            String[] stringArray2 = ",";
            boolean bl3 = stringArray.contains((CharSequence)stringArray2);
            if (bl3) {
                stringArray = stringArray.split((String)stringArray2);
            } else {
                n10 = 1;
                stringArray2 = new String[n10];
                bl3 = false;
                stringArray2[0] = stringArray;
                stringArray = stringArray2;
            }
            return stringArray;
        }
        return null;
    }

    public int a() {
        return 24;
    }

    public ho a() {
        return ho.x;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public String a() {
        String string2 = ",";
        String[] stringArray = this.a();
        String string3 = null;
        if (stringArray == null) return string3;
        int n10 = stringArray.length;
        if (n10 <= 0) return string3;
        PackageManager packageManager = ((ed)this).a.getPackageManager();
        StringBuilder stringBuilder = new StringBuilder();
        int n11 = stringArray.length;
        int n12 = 0;
        while (true) {
            if (n12 >= n11) {
                int n14 = stringBuilder.length();
                if (n14 <= 0) return string3;
                return stringBuilder.toString();
            }
            String string4 = stringArray[n12];
            int n13 = 16384;
            try {
                string4 = packageManager.getPackageInfo(string4, n13);
                if (string4 != null) {
                    CharSequence charSequence;
                    n13 = stringBuilder.length();
                    if (n13 > 0) {
                        charSequence = ";";
                        stringBuilder.append((String)charSequence);
                    }
                    charSequence = ((PackageInfo)string4).applicationInfo;
                    charSequence = charSequence.loadLabel(packageManager);
                    charSequence = charSequence.toString();
                    stringBuilder.append((String)charSequence);
                    stringBuilder.append(string2);
                    charSequence = ((PackageInfo)string4).packageName;
                    stringBuilder.append((String)charSequence);
                    stringBuilder.append(string2);
                    charSequence = ((PackageInfo)string4).versionName;
                    stringBuilder.append((String)charSequence);
                    stringBuilder.append(string2);
                    n13 = ((PackageInfo)string4).versionCode;
                    stringBuilder.append(n13);
                    stringBuilder.append(string2);
                    long l10 = ((PackageInfo)string4).firstInstallTime;
                    stringBuilder.append(l10);
                }
            }
            catch (Exception exception) {}
            ++n12;
        }
    }
}

