/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.sms;

import cn.leancloud.core.PaasClient;
import cn.leancloud.core.StorageClient;
import cn.leancloud.sms.AVCaptchaDigest;
import cn.leancloud.sms.AVCaptchaOption;
import cn.leancloud.utils.StringUtil;
import e.a.z;

public class AVCaptcha {
    public static z requestCaptchaInBackground(AVCaptchaOption object) {
        if (object != null) {
            return PaasClient.getStorageClient().requestCaptcha((AVCaptchaOption)object);
        }
        object = new IllegalArgumentException("option is null");
        throw object;
    }

    public static z verifyCaptchaCodeInBackground(String object, AVCaptchaDigest object2) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2) {
            if (object2 != null) {
                StorageClient storageClient = PaasClient.getStorageClient();
                object2 = ((AVCaptchaDigest)object2).getCaptchaToken();
                return storageClient.verifyCaptcha((String)object, (String)object2);
            }
            object = new IllegalArgumentException("captcha digest is null");
            throw object;
        }
        object = new IllegalArgumentException("captcha code is empty");
        throw object;
    }
}

