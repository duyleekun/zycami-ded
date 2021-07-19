/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.codec.MDFive;
import cn.leancloud.core.AVOSCloud;
import cn.leancloud.core.RequestSignature;
import cn.leancloud.utils.AVUtils;
import cn.leancloud.utils.StringUtil;

public class GeneralRequestSignature
implements RequestSignature {
    private static String masterKey;
    private static boolean useMasterKey = false;

    public static boolean isUseMasterKey() {
        return useMasterKey;
    }

    public static String requestSign(long l10, boolean bl2) {
        String string2;
        String string3 = AVOSCloud.getApplicationKey();
        if (bl2) {
            string3 = masterKey;
        }
        if (bl2) {
            string2 = "master";
        } else {
            bl2 = false;
            string2 = null;
        }
        return GeneralRequestSignature.requestSign(string3, l10, string2);
    }

    public static String requestSign(String string2, long l10, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder.append(l10);
        stringBuilder.append(string2);
        string2 = MDFive.computeMD5(stringBuilder.toString()).toLowerCase();
        stringBuilder2.append(string2);
        char c10 = ',';
        stringBuilder2.append(c10);
        stringBuilder2.append(l10);
        if (string3 != null) {
            stringBuilder2.append(c10);
            stringBuilder2.append(string3);
        }
        return stringBuilder2.toString();
    }

    public static void setMasterKey(String string2) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2) {
            boolean bl3;
            masterKey = string2;
            useMasterKey = bl3 = true;
        } else {
            useMasterKey = false;
            boolean bl4 = false;
            string2 = null;
            masterKey = null;
        }
    }

    public String generateSign() {
        long l10 = AVUtils.getCurrentTimestamp();
        boolean bl2 = GeneralRequestSignature.isUseMasterKey();
        return GeneralRequestSignature.requestSign(l10, bl2);
    }
}

