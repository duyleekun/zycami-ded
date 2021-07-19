/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.sms;

import cn.leancloud.sms.AVSMS$TYPE;
import cn.leancloud.utils.StringUtil;
import java.util.HashMap;
import java.util.Map;

public class AVSMSOption {
    private String applicationName;
    private String captchaValidateToken;
    private Map envMap;
    private String operation;
    private String signatureName;
    private String templateName;
    private int ttl;
    private AVSMS$TYPE type;

    public AVSMSOption() {
        AVSMS$TYPE aVSMS$TYPE;
        this.type = aVSMS$TYPE = AVSMS$TYPE.TEXT_SMS;
        this.ttl = 0;
    }

    private static Map fillMap(String string2, int n10, Map map) {
        if (n10 > 0) {
            Integer n11 = n10;
            map.put(string2, n11);
        }
        return map;
    }

    private static Map fillMap(String string2, String string3, Map map) {
        boolean bl2 = StringUtil.isEmpty(string3);
        if (!bl2) {
            map.put(string2, string3);
        }
        return map;
    }

    public Map getOptionMap() {
        HashMap hashMap = new HashMap();
        Object object = this.applicationName;
        AVSMSOption.fillMap("name", (String)object, hashMap);
        object = this.operation;
        AVSMSOption.fillMap("op", (String)object, hashMap);
        object = this.templateName;
        AVSMSOption.fillMap("template", (String)object, hashMap);
        object = this.signatureName;
        AVSMSOption.fillMap("sign", (String)object, hashMap);
        int n10 = this.ttl;
        AVSMSOption.fillMap("ttl", n10, hashMap);
        object = this.captchaValidateToken;
        String string2 = "validate_token";
        AVSMSOption.fillMap(string2, (String)object, hashMap);
        object = this.type;
        if (object != null) {
            object = ((AVSMS$TYPE)((Object)object)).toString();
            string2 = "smsType";
            AVSMSOption.fillMap(string2, (String)object, hashMap);
        }
        if ((object = this.envMap) != null && (n10 = (int)(object.isEmpty() ? 1 : 0)) == 0) {
            object = this.envMap;
            hashMap.putAll(object);
        }
        return hashMap;
    }

    public void setApplicationName(String string2) {
        this.applicationName = string2;
    }

    public void setCaptchaValidateToken(String string2) {
        this.captchaValidateToken = string2;
    }

    public void setEnvMap(Map map) {
        this.envMap = map;
    }

    public void setOperation(String string2) {
        this.operation = string2;
    }

    public void setSignatureName(String string2) {
        this.signatureName = string2;
    }

    public void setTemplateName(String string2) {
        this.templateName = string2;
    }

    public void setTtl(int n10) {
        this.ttl = n10;
    }

    public void setType(AVSMS$TYPE aVSMS$TYPE) {
        this.type = aVSMS$TYPE;
    }
}

