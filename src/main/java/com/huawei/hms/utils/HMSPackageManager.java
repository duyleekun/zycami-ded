/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ResolveInfo
 *  android.content.pm.ServiceInfo
 *  android.text.TextUtils
 *  android.util.Pair
 */
package com.huawei.hms.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.device.a;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.PackageManagerHelper$PackageStates;
import java.security.cert.X509Certificate;
import java.util.List;

public class HMSPackageManager {
    public static HMSPackageManager f;
    public static final Object g;
    public static final Object h;
    public final Context a;
    public final PackageManagerHelper b;
    public String c;
    public String d;
    public int e;

    static {
        Object object;
        g = object = new Object();
        h = object = new Object();
    }

    public HMSPackageManager(Context context) {
        PackageManagerHelper packageManagerHelper;
        this.a = context;
        this.b = packageManagerHelper = new PackageManagerHelper(context);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static HMSPackageManager getInstance(Context object) {
        Object object2 = g;
        synchronized (object2) {
            HMSPackageManager hMSPackageManager = f;
            if (hMSPackageManager == null) {
                hMSPackageManager = object.getApplicationContext();
                if (hMSPackageManager != null) {
                    object = object.getApplicationContext();
                    f = hMSPackageManager = new HMSPackageManager((Context)object);
                } else {
                    f = hMSPackageManager = new HMSPackageManager((Context)object);
                }
                object = f;
                ((HMSPackageManager)object).b();
            }
            return f;
        }
    }

    public final Pair a() {
        Object object = this.a.getPackageManager();
        Object object2 = new Intent("com.huawei.hms.core.aidlservice");
        int n10 = (object = object.queryIntentServices((Intent)object2, 128)).size();
        if (n10 == 0) {
            return null;
        }
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object2 = ((ResolveInfo)object.next()).serviceInfo;
            String string2 = object2.applicationInfo.packageName;
            object2 = ((ServiceInfo)object2).metaData;
            String string3 = "skip package ";
            String string4 = "HMSPackageManager";
            if (object2 == null) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(string3);
                ((StringBuilder)object2).append(string2);
                string2 = " for metadata is null";
                ((StringBuilder)object2).append(string2);
                object2 = ((StringBuilder)object2).toString();
                HMSLog.e(string4, (String)object2);
                continue;
            }
            String string5 = "hms_app_signer";
            boolean bl2 = object2.containsKey(string5);
            if (!bl2) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(string3);
                ((StringBuilder)object2).append(string2);
                string2 = " for no signer";
                ((StringBuilder)object2).append(string2);
                object2 = ((StringBuilder)object2).toString();
                HMSLog.e(string4, (String)object2);
                continue;
            }
            String string6 = "hms_app_cert_chain";
            boolean bl3 = object2.containsKey(string6);
            if (!bl3) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(string3);
                ((StringBuilder)object2).append(string2);
                string2 = " for no cert chain";
                ((StringBuilder)object2).append(string2);
                object2 = ((StringBuilder)object2).toString();
                HMSLog.e(string4, (String)object2);
                continue;
            }
            string3 = this.b.getPackageSignature(string2);
            CharSequence charSequence = new StringBuilder();
            charSequence.append(string2);
            String string7 = "&";
            charSequence.append(string7);
            charSequence.append(string3);
            charSequence = charSequence.toString();
            string5 = object2.getString(string5);
            object2 = object2.getString(string6);
            n10 = (int)(this.a((String)charSequence, string5, (String)object2) ? 1 : 0);
            if (n10 == 0) {
                object2 = "checkSinger failed";
                HMSLog.e(string4, (String)object2);
                continue;
            }
            object = new Pair((Object)string2, (Object)string3);
            return object;
        }
        return null;
    }

    public final boolean a(String string2, String charSequence, String object) {
        int n10 = TextUtils.isEmpty((CharSequence)charSequence);
        String string3 = "HMSPackageManager";
        if (n10 == 0 && (n10 = TextUtils.isEmpty((CharSequence)object)) == 0) {
            n10 = (object = com.huawei.hms.device.a.b((String)object)).size();
            if (n10 == 0) {
                HMSLog.e(string3, "certChain is empty");
                return false;
            }
            Object object2 = com.huawei.hms.device.a.a(this.a);
            n10 = (int)(com.huawei.hms.device.a.a((X509Certificate)object2, (List)object) ? 1 : 0);
            if (n10 == 0) {
                HMSLog.e(string3, "failed to verify cert chain");
                return false;
            }
            n10 = object.size();
            int n11 = 1;
            n10 -= n11;
            if ((n10 = (int)(com.huawei.hms.device.a.a((X509Certificate)(object = (X509Certificate)object.get(n10)), (String)(object2 = "Huawei CBG HMS")) ? 1 : 0)) == 0) {
                HMSLog.e(string3, "CN is invalid");
                return false;
            }
            object2 = "Huawei CBG Cloud Security Signer";
            n10 = (int)(com.huawei.hms.device.a.b((X509Certificate)object, (String)object2) ? 1 : 0);
            if (n10 == 0) {
                HMSLog.e(string3, "OU is invalid");
                return false;
            }
            boolean bl2 = com.huawei.hms.device.a.a((X509Certificate)object, string2, (String)charSequence);
            if (!bl2) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("signature is invalid: ");
                ((StringBuilder)charSequence).append(string2);
                string2 = ((StringBuilder)charSequence).toString();
                HMSLog.e(string3, string2);
                return false;
            }
            return n11 != 0;
        }
        HMSLog.e(string3, "args is invalid");
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void b() {
        Object object = h;
        synchronized (object) {
            int n10;
            Object object2 = this.a();
            if (object2 == null) {
                object2 = "HMSPackageManager";
                String string2 = "Failed to find HMS apk";
                HMSLog.e((String)object2, string2);
                boolean bl2 = false;
                object2 = null;
                this.c = null;
                this.d = null;
                bl2 = false;
                object2 = null;
                this.e = 0;
                return;
            }
            Object object3 = ((Pair)object2).first;
            this.c = object3 = (String)object3;
            object2 = ((Pair)object2).second;
            object2 = (String)object2;
            this.d = object2;
            object2 = this.b;
            object3 = this.getHMSPackageName();
            this.e = n10 = ((PackageManagerHelper)object2).getPackageVersionCode((String)object3);
            object2 = "HMSPackageManager";
            object3 = new StringBuilder();
            String string3 = "Succeed to find HMS apk: ";
            ((StringBuilder)object3).append(string3);
            string3 = this.c;
            ((StringBuilder)object3).append(string3);
            string3 = " version: ";
            ((StringBuilder)object3).append(string3);
            int n11 = this.e;
            ((StringBuilder)object3).append(n11);
            object3 = ((StringBuilder)object3).toString();
            HMSLog.i((String)object2, (String)object3);
            return;
        }
    }

    public final boolean c() {
        boolean bl2;
        block10: {
            String string2;
            Object object;
            block11: {
                object = this.a.getPackageManager();
                bl2 = true;
                string2 = "HMSPackageManager";
                if (object == null) {
                    HMSLog.e(string2, "In isMinApkVersionEffective, Failed to get 'PackageManager' instance.");
                    return bl2;
                }
                String string3 = this.getHMSPackageName();
                int n10 = 128;
                object = object.getPackageInfo(string3, n10);
                object = object.applicationInfo;
                if (object == null) break block10;
                object = object.metaData;
                if (object == null) break block10;
                string3 = "com.huawei.hms.kit.api_level:hmscore";
                int n11 = object.containsKey(string3);
                if (n11 == 0) break block10;
                n11 = this.getHmsVersionCode();
                int n12 = 50000000;
                if (n11 >= n12) break block11;
                n11 = this.getHmsVersionCode();
                n12 = 19999999;
                if (n11 > n12) break block10;
            }
            object = "MinApkVersion is disabled.";
            try {
                HMSLog.i(string2, (String)object);
                return false;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                object = "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.";
                HMSLog.e(string2, (String)object);
            }
        }
        return bl2;
    }

    public String getHMSFingerprint() {
        String string2 = this.d;
        if (string2 == null) {
            string2 = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";
        }
        return string2;
    }

    public String getHMSPackageName() {
        boolean bl2;
        Object object;
        this.refresh();
        Object object2 = this.c;
        if (object2 != null) {
            object = PackageManagerHelper$PackageStates.NOT_INSTALLED;
            bl2 = ((Enum)object).equals(object2 = this.b.getPackageStates((String)object2));
            if (bl2) {
                object2 = "HMSPackageManager";
                object = "The package name is not installed and needs to be refreshed again";
                HMSLog.i((String)object2, object);
                this.b();
            }
            if ((object2 = this.c) != null) {
                return object2;
            }
        }
        object2 = this.b;
        Object object3 = PackageManagerHelper$PackageStates.NOT_INSTALLED;
        object = "com.huawei.hwid";
        bl2 = object3.equals(object2 = ((PackageManagerHelper)object2).getPackageStates((String)object));
        if (bl2 || (bl2 = ((String)(object2 = this.b.getPackageSignature((String)object))).equalsIgnoreCase((String)(object3 = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05")))) {
            // empty if block
        }
        return object;
    }

    public PackageManagerHelper$PackageStates getHMSPackageStates() {
        Object object = this.c;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.d)))) {
            object = this.b;
            Object object2 = this.c;
            if ((object = ((PackageManagerHelper)object).getPackageStates((String)object2)) == (object2 = PackageManagerHelper$PackageStates.ENABLED)) {
                object2 = this.d;
                Object object3 = this.b;
                String string2 = this.c;
                boolean bl3 = ((String)object2).equals(object3 = ((PackageManagerHelper)object3).getPackageSignature(string2));
                if (!bl3) {
                    object = PackageManagerHelper$PackageStates.NOT_INSTALLED;
                }
            }
            return object;
        }
        this.b();
        object = this.b;
        String string3 = this.c;
        return ((PackageManagerHelper)object).getPackageStates(string3);
    }

    public int getHmsVersionCode() {
        PackageManagerHelper packageManagerHelper = this.b;
        String string2 = this.getHMSPackageName();
        return packageManagerHelper.getPackageVersionCode(string2);
    }

    public boolean hmsVerHigherThan(int n10) {
        int n11 = this.e;
        boolean bl2 = true;
        if (n11 < n10 && (n11 = (int)(this.c() ? 1 : 0)) != 0) {
            PackageManagerHelper packageManagerHelper = this.b;
            String string2 = this.getHMSPackageName();
            this.e = n11 = packageManagerHelper.getPackageVersionCode(string2);
            if (n11 < n10) {
                bl2 = false;
            }
        }
        return bl2;
    }

    public boolean isApkUpdateNecessary(int n10) {
        int n11 = this.getHmsVersionCode();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("current versionCode:");
        charSequence.append(n11);
        charSequence.append(", minimum version requirements: ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        String string2 = "HMSPackageManager";
        HMSLog.i(string2, (String)charSequence);
        boolean bl2 = this.c();
        n10 = bl2 && n11 < n10 ? 1 : 0;
        return n10 != 0;
    }

    public void refresh() {
        String string2 = this.c;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2 || (bl2 = TextUtils.isEmpty((CharSequence)(string2 = this.d)))) {
            this.b();
        }
    }
}

