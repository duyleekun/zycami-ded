/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 */
package com.geetest.sdk.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class b {
    private static final String[] a = new String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
    private static final String[] b = new String[]{"com.noshufou.android.su", "com.noshufou.android.su.elite", "eu.chainfire.supersu", "com.koushikdutta.superuser", "com.thirdparty.superuser", "com.yellowes.su"};
    private static final String[] c = new String[]{"com.koushikdutta.rommanager", "com.dimonvideo.luckypatcher", "com.chelpus.lackypatch", "com.ramdroid.appquarantine"};
    private static final String[] d = new String[]{"com.devadvance.rootcloak", "de.robv.android.xposed.installer", "com.saurik.substrate", "com.devadvance.rootcloakplus", "com.zachspong.temprootremovejb", "com.amphoras.hidemyroot", "com.formyhm.hideroot"};

    private static List a() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string2 : a) {
            File file = new File(string2);
            boolean bl2 = file.exists();
            if (!bl2) continue;
            arrayList.add(string2);
        }
        return arrayList;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static List a(Context context) {
        boolean bl2;
        Object object = new ArrayList();
        ArrayList<String> arrayList = Arrays.asList(b);
        ((ArrayList)object).addAll(arrayList);
        arrayList = Arrays.asList(c);
        ((ArrayList)object).addAll(arrayList);
        arrayList = Arrays.asList(d);
        ((ArrayList)object).addAll(arrayList);
        context = context.getPackageManager();
        arrayList = new ArrayList<String>();
        object = ((ArrayList)object).iterator();
        while (bl2 = object.hasNext()) {
            String string2 = (String)object.next();
            try {
                context.getPackageInfo(string2, 0);
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                continue;
            }
            arrayList.add(string2);
        }
        return arrayList;
    }

    public static int b(Context object) {
        int n10;
        block6: {
            block5: {
                List list;
                n10 = 0;
                try {
                    list = com.geetest.sdk.utils.b.a();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return 0;
                }
                int n11 = list.size();
                if (n11 > 0) break block5;
                object = com.geetest.sdk.utils.b.a((Context)object);
                int n12 = object.size();
                if (n12 <= 0) break block6;
            }
            n10 = 1;
        }
        return n10;
    }
}

