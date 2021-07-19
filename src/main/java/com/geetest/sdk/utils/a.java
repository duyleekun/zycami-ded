/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Build
 */
package com.geetest.sdk.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.geetest.sdk.utils.c;
import com.geetest.sdk.utils.s;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class a {
    private static final String[] a = new String[]{"goldfish"};
    private static final String[] b = new String[]{"/dev/socket/qemud", "/dev/qemu_pipe"};

    public static int a(Context context) {
        int n10;
        int n11;
        int n12;
        boolean bl2;
        boolean bl3;
        int n13;
        block13: {
            block12: {
                block11: {
                    block10: {
                        String string2;
                        n13 = 0;
                        try {
                            bl3 = com.geetest.sdk.utils.a.c();
                            string2 = "com.example.android.apis";
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                            return 0;
                        }
                        bl2 = com.geetest.sdk.utils.a.a(context, string2);
                        n12 = 1;
                        if (!bl2) break block10;
                        string2 = "com.android.development";
                        n11 = com.geetest.sdk.utils.a.a(context, string2);
                        if (n11 == 0) break block10;
                        n11 = n12;
                        break block11;
                    }
                    n11 = 0;
                    context = null;
                }
                bl2 = com.geetest.sdk.utils.a.a();
                String string3 = "/proc/tty/drivers";
                n10 = com.geetest.sdk.utils.a.a(string3);
                if (n10 != 0) break block12;
                string3 = "/proc/cpuinfo";
                n10 = com.geetest.sdk.utils.a.a(string3);
                if (n10 != 0) break block12;
                n10 = 0;
                string3 = null;
                break block13;
            }
            n10 = n12;
        }
        boolean bl4 = com.geetest.sdk.utils.a.d();
        boolean bl5 = com.geetest.sdk.utils.a.b();
        if (bl5 || bl3 || n11 != 0 || bl2 || n10 != 0 || bl4) {
            n13 = n12;
        }
        return n13;
    }

    private static boolean a() {
        for (String string2 : b) {
            File file = new File(string2);
            boolean bl2 = file.exists();
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    private static boolean a(Context context, String string2) {
        boolean bl2 = false;
        context = context.getPackageManager();
        try {
            context = context.getPackageInfo(string2, 0);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            context = null;
        }
        if (context != null) {
            bl2 = true;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean a(String objectArray) {
        Object object = new File((String)objectArray);
        int n10 = ((File)object).exists();
        if (n10 != 0 && (n10 = ((File)object).canRead()) != 0) {
            n10 = 1024;
            objectArray = new byte[n10];
            try {
                FileInputStream fileInputStream = new FileInputStream((File)object);
                ((InputStream)fileInputStream).read((byte[])objectArray);
                ((InputStream)fileInputStream).close();
            }
            catch (Exception exception) {}
            object = new String((byte[])objectArray);
            for (String string2 : a) {
                boolean bl2 = ((String)object).contains(string2);
                if (!bl2) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean b() {
        String string2 = s.a("ro.product.cpu.abi");
        String string3 = "x86";
        boolean bl2 = string2.contains(string3);
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        string2 = s.a("ro.product.cpu.abilist");
        bl2 = string2.contains(string3);
        if (bl2) {
            return bl3;
        }
        string2 = c.a().a("uname -m");
        bl2 = string2.contains(string3 = "i686");
        if (bl2) {
            return bl3;
        }
        return false;
    }

    private static boolean c() {
        String string2;
        boolean bl2;
        String string3;
        boolean bl3;
        String string4;
        boolean bl4;
        String string5;
        boolean bl5;
        boolean bl6;
        String string6 = Build.PRODUCT;
        String string7 = "sdk";
        boolean bl7 = string6.contains(string7);
        boolean bl8 = true;
        if (!(bl7 || (bl7 = string6.contains(string7 = "sdk_x86")) || (bl7 = string6.contains(string7 = "sdk_google")) || (bl6 = string6.contains(string7 = "Andy")) || (bl5 = string6.contains(string5 = "Droid4X")) || (bl4 = string6.contains(string4 = "nox")) || (bl3 = string6.contains(string3 = "vbox86p")) || (bl2 = (string6 = Build.MANUFACTURER).contains(string2 = "Genymotion")) || (bl2 = string6.contains(string7)) || (bl2 = string6.contains(string4)) || (bl3 = string6.contains(string2 = "TiantianVM")))) {
            String string8;
            string6 = Build.BRAND;
            bl3 = string6.contains(string7);
            if (bl3) {
                return bl8;
            }
            string6 = Build.DEVICE;
            boolean bl9 = string6.contains(string7);
            if (!(bl9 || (bl9 = string6.contains(string5)) || (bl9 = string6.contains(string4)) || (bl3 = string6.contains(string3)) || (bl9 = (string6 = Build.MODEL).contains(string8 = "Emulator")) || (bl9 = string6.contains(string8 = "google_sdk")) || (bl6 = string6.contains(string5)) || (bl6 = string6.contains(string2)) || (bl6 = string6.contains(string7)) || (bl6 = string6.contains(string5 = "Android SDK built for x86_64")) || (bl3 = string6.contains(string5 = "Android SDK built for x86")) || (bl6 = (string6 = Build.HARDWARE).contains(string5 = "vbox86")) || (bl6 = string6.contains(string4)) || (bl3 = string6.contains(string5 = "ttVM_x86")) || (bl6 = (string6 = Build.FINGERPRINT).contains(string5 = "generic/sdk/generic")) || (bl6 = string6.contains(string5 = "generic_x86/sdk_x86/generic_x86")) || (bl7 = string6.contains(string7)) || (bl7 = string6.contains(string7 = "ttVM_Hdragon")) || (bl7 = string6.contains(string7 = "generic/google_sdk/generic")) || (bl7 = string6.contains(string3)) || (bl3 = string6.contains(string7 = "generic/vbox86p/vbox86p")))) {
                bl8 = false;
            }
        }
        return bl8;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean d() {
        Object object = "/system/bin/cat";
        Object object2 = "/proc/cpuinfo";
        try {
            object = new String[]{object, object2};
            object2 = new ProcessBuilder((String[])object);
            object = ((ProcessBuilder)object2).start();
            object2 = new StringBuilder();
            object = ((Process)object).getInputStream();
            String string2 = "utf-8";
            InputStreamReader inputStreamReader = new InputStreamReader((InputStream)object, string2);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while ((object = bufferedReader.readLine()) != null) {
                ((StringBuilder)object2).append((String)object);
            }
            bufferedReader.close();
            object = ((StringBuilder)object2).toString();
            object = ((String)object).toLowerCase();
        }
        catch (Exception exception) {
            object = "$unknown";
        }
        object2 = "intel";
        boolean bl2 = ((String)object).contains((CharSequence)object2);
        if (bl2) return true;
        object2 = "amd";
        boolean bl3 = ((String)object).contains((CharSequence)object2);
        if (bl3) return true;
        return false;
    }
}

