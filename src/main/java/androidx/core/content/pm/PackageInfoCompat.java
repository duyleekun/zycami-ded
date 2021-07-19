/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.Signature
 *  android.os.Build$VERSION
 */
package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import androidx.core.content.pm.PackageInfoCompat$Api28Impl;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class PackageInfoCompat {
    private PackageInfoCompat() {
    }

    private static boolean byteArrayContains(byte[][] byArray, byte[] byArray2) {
        for (byte[] byArray3 : byArray) {
            boolean bl2 = Arrays.equals(byArray2, byArray3);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    private static byte[] computeSHA256Digest(byte[] byArray) {
        Object object = "SHA256";
        try {
            object = MessageDigest.getInstance((String)object);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object = new RuntimeException("Device doesn't support SHA256 cert checking", noSuchAlgorithmException);
            throw object;
        }
        return ((MessageDigest)object).digest(byArray);
    }

    public static long getLongVersionCode(PackageInfo packageInfo) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return packageInfo.getLongVersionCode();
        }
        return packageInfo.versionCode;
    }

    public static List getSignatures(PackageManager signingInfo, String string2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            n10 = 0x8000000;
            signingInfo = signingInfo.getPackageInfo((String)string2, (int)n10).signingInfo;
            boolean bl2 = PackageInfoCompat$Api28Impl.hasMultipleSigners(signingInfo);
            signingInfo = bl2 ? PackageInfoCompat$Api28Impl.getApkContentsSigners(signingInfo) : PackageInfoCompat$Api28Impl.getSigningCertificateHistory(signingInfo);
        } else {
            n10 = 64;
            signingInfo = signingInfo.getPackageInfo((String)string2, (int)n10).signatures;
        }
        if (signingInfo == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(signingInfo);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean hasSignatures(PackageManager object, String object2, Map object3, boolean n10) {
        Iterator iterator2;
        int n11;
        int n12;
        Object object4;
        String string2;
        int n13;
        int n14;
        int n15;
        Object object5;
        Object object6;
        boolean bl2;
        Comparable<StringBuilder> comparable;
        block8: {
            block9: {
                block10: {
                    Integer n16;
                    bl2 = comparable.isEmpty();
                    if (bl2) {
                        return false;
                    }
                    object6 = comparable.keySet();
                    object5 = object6.iterator();
                    do {
                        n13 = object5.hasNext();
                        string2 = "Unsupported certificate type ";
                        n14 = 1;
                        if (!n13) break block8;
                        byte[] byArray = (byte[])object5.next();
                        if (byArray == null) break block9;
                        n16 = (Integer)comparable.get(byArray);
                        if (n16 == null) break block10;
                    } while (!(n15 = n16.intValue()) || n15 == n14);
                    comparable = new Comparable<StringBuilder>();
                    ((StringBuilder)comparable).append(string2);
                    ((StringBuilder)comparable).append(n16);
                    ((StringBuilder)comparable).append(" when verifying ");
                    ((StringBuilder)comparable).append((String)object4);
                    object4 = ((StringBuilder)comparable).toString();
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object4);
                    throw illegalArgumentException;
                }
                comparable = new Comparable<StringBuilder>();
                ((StringBuilder)comparable).append("Type must be specified for cert when verifying ");
                ((StringBuilder)comparable).append((String)object4);
                object4 = ((StringBuilder)comparable).toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object4);
                throw illegalArgumentException;
            }
            comparable = new Comparable<StringBuilder>();
            ((StringBuilder)comparable).append("Cert byte array cannot be null when verifying ");
            ((StringBuilder)comparable).append((String)object4);
            object4 = ((StringBuilder)comparable).toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object4);
            throw illegalArgumentException;
        }
        object5 = PackageInfoCompat.getSignatures(object, (String)object4);
        if (n12 == 0 && (n13 = Build.VERSION.SDK_INT) >= (n15 = 28)) {
            Iterator iterator3 = object6.iterator();
            while (bl2 = iterator3.hasNext()) {
                int n17;
                object6 = (byte[])iterator3.next();
                bl2 = PackageInfoCompat$Api28Impl.hasSigningCertificate(object, (String)object4, (byte[])object6, n17 = ((Integer)(object5 = (Integer)comparable.get(object6))).intValue());
                if (bl2) continue;
                return false;
            }
            return n14;
        }
        int n18 = object5.size();
        if (n18 == 0 || (n18 = comparable.size()) > (n11 = object5.size()) || n12 != 0 && (n18 = comparable.size()) != (n11 = object5.size())) return false;
        Integer n19 = n14;
        n18 = (int)(comparable.containsValue(n19) ? 1 : 0);
        n11 = 0;
        object4 = null;
        if (n18 != 0) {
            object4 = new byte[object5.size()][];
            Object var0_5 = null;
            for (n18 = 0; n18 < (n12 = object5.size()); ++n18) {
                byte[] byArray = PackageInfoCompat.computeSHA256Digest(((Signature)object5.get(n18)).toByteArray());
                object4[n18] = byArray;
            }
        }
        if ((n12 = (iterator2 = object6.iterator()).hasNext()) == 0) return false;
        byte[] byArray = (byte[])iterator2.next();
        n12 = (Integer)(comparable = (Integer)comparable.get(byArray));
        if (n12 != 0) {
            if (n12 == n14) {
                n18 = (int)(PackageInfoCompat.byteArrayContains((byte[][])object4, byArray) ? 1 : 0);
                if (n18 != 0) return n14;
                return false;
            }
            object4 = new StringBuilder();
            ((StringBuilder)object4).append(string2);
            ((StringBuilder)object4).append(comparable);
            object4 = ((StringBuilder)object4).toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object4);
            throw illegalArgumentException;
        }
        object4 = new Signature(byArray);
        n18 = (int)(object5.contains(object4) ? 1 : 0);
        if (n18 != 0) return n14;
        return false;
    }
}

