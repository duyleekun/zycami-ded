/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package cn.leancloud.im;

import android.os.Build;
import cn.leancloud.im.SystemReporter;
import cn.leancloud.im.SystemReporter$SystemInfo;

public class AndroidInitializer$AndroidSystemReporter
implements SystemReporter {
    public SystemReporter$SystemInfo getInfo() {
        String string2;
        boolean bl2;
        String string3;
        boolean bl3;
        String string4 = Build.FINGERPRINT;
        Object object = "generic";
        int n10 = string4.startsWith((String)object);
        if (!(n10 != 0 || (bl3 = string4.startsWith(string3 = "unknown")) || (bl2 = (string4 = Build.MODEL).contains(string3 = "google_sdk")) || (bl2 = string4.contains(string2 = "Emulator")) || (bl3 = string4.contains(string2 = "Android SDK built for x86")) || (string4 = Build.BOARD) == (string2 = "QC_Reference_Phone") || (bl3 = (string4 = Build.MANUFACTURER).contains(string2 = "Genymotion")) || (bl3 = (string4 = Build.HOST).startsWith(string2 = "Build")) || (bl3 = (string4 = Build.BRAND).startsWith((String)object)) && (bl3 = (string4 = Build.DEVICE).startsWith((String)object)) || string3 == (string4 = Build.PRODUCT))) {
            bl3 = false;
            string4 = null;
        } else {
            bl3 = true;
        }
        object = new SystemReporter$SystemInfo();
        string3 = Build.BRAND;
        ((SystemReporter$SystemInfo)object).setBrand(string3);
        string3 = Build.MANUFACTURER;
        ((SystemReporter$SystemInfo)object).setManufacturer(string3);
        string3 = Build.MODEL;
        ((SystemReporter$SystemInfo)object).setModel(string3);
        n10 = Build.VERSION.SDK_INT;
        ((SystemReporter$SystemInfo)object).setOsAPILevel(n10);
        string3 = Build.VERSION.CODENAME;
        ((SystemReporter$SystemInfo)object).setOsCodeName(string3);
        ((SystemReporter$SystemInfo)object).setRunOnEmulator(bl3);
        return object;
    }
}

