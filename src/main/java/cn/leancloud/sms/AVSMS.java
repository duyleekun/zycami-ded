/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.sms;

import cn.leancloud.core.PaasClient;
import cn.leancloud.sms.AVSMSOption;
import cn.leancloud.utils.StringUtil;
import e.a.z;
import java.util.Map;
import java.util.regex.Pattern;

public class AVSMS {
    public static Pattern phoneNumPattern = Pattern.compile("^[1+]\\d+$");

    public static boolean checkMobilePhoneNumber(String string2) {
        return phoneNumPattern.matcher(string2).find();
    }

    public static z requestSMSCodeInBackground(String object, AVSMSOption object2) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2 && (bl2 = AVSMS.checkMobilePhoneNumber((String)object))) {
            if (object2 == null) {
                object = new IllegalArgumentException("smsOption is null");
                return z.m2((Throwable)object);
            }
            object2 = ((AVSMSOption)object2).getOptionMap();
            return PaasClient.getStorageClient().requestSMSCode((String)object, (Map)object2);
        }
        object = new IllegalArgumentException("mobile phone number is empty or invalid");
        return z.m2((Throwable)object);
    }

    public static z verifySMSCodeInBackground(String object, String string2) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2 && !(bl2 = StringUtil.isEmpty(string2))) {
            return PaasClient.getStorageClient().verifySMSCode((String)object, string2);
        }
        object = new IllegalArgumentException("code or mobilePhone is empty");
        return z.m2((Throwable)object);
    }
}

