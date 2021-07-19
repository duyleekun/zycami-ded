/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.pm.PackageManager
 *  android.content.pm.Signature
 *  android.content.pm.SigningInfo
 */
package androidx.core.content.pm;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;

public class PackageInfoCompat$Api28Impl {
    private PackageInfoCompat$Api28Impl() {
    }

    public static Signature[] getApkContentsSigners(SigningInfo signingInfo) {
        return signingInfo.getApkContentsSigners();
    }

    public static Signature[] getSigningCertificateHistory(SigningInfo signingInfo) {
        return signingInfo.getSigningCertificateHistory();
    }

    public static boolean hasMultipleSigners(SigningInfo signingInfo) {
        return signingInfo.hasMultipleSigners();
    }

    public static boolean hasSigningCertificate(PackageManager packageManager, String string2, byte[] byArray, int n10) {
        return packageManager.hasSigningCertificate(string2, byArray, n10);
    }
}

