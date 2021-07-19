/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.Signature
 *  android.text.TextUtils
 */
package com.huawei.hms.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HEX;
import com.huawei.hms.utils.PackageManagerHelper$PackageStates;
import com.huawei.hms.utils.SHA256;

public class PackageManagerHelper {
    public final PackageManager a;

    public PackageManagerHelper(Context context) {
        context = context.getPackageManager();
        this.a = context;
    }

    public final byte[] a(String signature) {
        String string2;
        String string3;
        block7: {
            string3 = "PackageManagerHelper";
            string2 = "Failed to get application signature certificate fingerprint.";
            Object object = this.a;
            int n10 = 64;
            signature = object.getPackageInfo((String)signature, n10);
            if (signature == null) break block7;
            signature = signature.signatures;
            if (signature == null) break block7;
            int n11 = ((Signature[])signature).length;
            if (n11 <= 0) break block7;
            signature = signature[0];
            try {
                return signature.toByteArray();
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                object = new StringBuilder();
                ((StringBuilder)object).append(string2);
                String string4 = nameNotFoundException.getMessage();
                ((StringBuilder)object).append(string4);
                string4 = ((StringBuilder)object).toString();
                HMSLog.e(string3, string4);
            }
        }
        HMSLog.e(string3, string2);
        return new byte[0];
    }

    public String getPackageSignature(String object) {
        int n10;
        if ((object = (Object)this.a((String)object)) != null && (n10 = ((Object)object).length) != 0) {
            return HEX.encodeHexString(SHA256.digest((byte[])object), true);
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public PackageManagerHelper$PackageStates getPackageStates(String string2) {
        PackageManager packageManager;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return PackageManagerHelper$PackageStates.NOT_INSTALLED;
        }
        try {
            packageManager = this.a;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return PackageManagerHelper$PackageStates.NOT_INSTALLED;
        }
        string2 = packageManager.getApplicationInfo(string2, 0);
        boolean bl3 = ((ApplicationInfo)string2).enabled;
        if (!bl3) return PackageManagerHelper$PackageStates.DISABLED;
        return PackageManagerHelper$PackageStates.ENABLED;
    }

    public int getPackageVersionCode(String string2) {
        block4: {
            int n10;
            PackageManager packageManager;
            try {
                packageManager = this.a;
                n10 = 16;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {}
            string2 = packageManager.getPackageInfo(string2, n10);
            if (string2 == null) break block4;
            return ((PackageInfo)string2).versionCode;
        }
        return 0;
    }

    public String getPackageVersionName(String string2) {
        String string3;
        block5: {
            int n10;
            PackageManager packageManager;
            string3 = "";
            try {
                packageManager = this.a;
                n10 = 16;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {}
            string2 = packageManager.getPackageInfo(string2, n10);
            if (string2 == null) break block5;
            string2 = ((PackageInfo)string2).versionName;
            if (string2 != null) {
                return string2;
            }
        }
        return string3;
    }

    public boolean hasProvider(String providerInfoArray, String string2) {
        block9: {
            PackageManager packageManager = this.a;
            int n10 = 8;
            providerInfoArray = packageManager.getPackageInfo((String)providerInfoArray, n10);
            if (providerInfoArray == null) break block9;
            providerInfoArray = providerInfoArray.providers;
            if (providerInfoArray == null) break block9;
            int n11 = providerInfoArray.length;
            for (n10 = 0; n10 < n11; ++n10) {
                Object object;
                try {
                    object = providerInfoArray[n10];
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {}
                object = object.authority;
                boolean bl2 = string2.equals(object);
                if (!bl2) continue;
                return true;
                break;
            }
        }
        return false;
    }

    /*
     * Exception decompiling
     */
    public boolean verifyPackageArchive(String var1_1, String var2_5, String var3_6) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 10[TRYBLOCK] [30 : 147->150)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }
}

