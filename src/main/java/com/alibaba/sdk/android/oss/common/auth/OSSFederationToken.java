/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.common.auth;

import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.DateUtil;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class OSSFederationToken {
    private long expiration;
    private String securityToken;
    private String tempAk;
    private String tempSk;

    public OSSFederationToken(String string2, String string3, String string4, long l10) {
        this.setTempAk(string2);
        this.setTempSk(string3);
        this.setSecurityToken(string4);
        this.setExpiration(l10);
    }

    public OSSFederationToken(String string2, String string3, String string4, String string5) {
        this.setTempAk(string2);
        this.setTempSk(string3);
        this.setSecurityToken(string4);
        this.setExpirationInGMTFormat(string5);
    }

    public long getExpiration() {
        return this.expiration;
    }

    public String getSecurityToken() {
        return this.securityToken;
    }

    public String getTempAK() {
        return this.tempAk;
    }

    public String getTempSK() {
        return this.tempSk;
    }

    public void setExpiration(long l10) {
        this.expiration = l10;
    }

    public void setExpirationInGMTFormat(String object) {
        long l10 = 1000L;
        Object object2 = "yyyy-MM-dd'T'HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat((String)object2);
        object2 = "UTC";
        object2 = DesugarTimeZone.getTimeZone((String)object2);
        simpleDateFormat.setTimeZone((TimeZone)object2);
        object = simpleDateFormat.parse((String)object);
        long l11 = ((Date)object).getTime();
        l11 /= l10;
        try {
            this.expiration = l11;
        }
        catch (ParseException parseException) {
            boolean bl2 = OSSLog.isEnableLog();
            if (bl2) {
                parseException.printStackTrace();
            }
            l11 = DateUtil.getFixedSkewedTimeMillis() / l10;
            l10 = 30;
            this.expiration = l11 += l10;
        }
    }

    public void setSecurityToken(String string2) {
        this.securityToken = string2;
    }

    public void setTempAk(String string2) {
        this.tempAk = string2;
    }

    public void setTempSk(String string2) {
        this.tempSk = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OSSFederationToken [tempAk=");
        String string2 = this.tempAk;
        stringBuilder.append(string2);
        stringBuilder.append(", tempSk=");
        string2 = this.tempSk;
        stringBuilder.append(string2);
        stringBuilder.append(", securityToken=");
        string2 = this.securityToken;
        stringBuilder.append(string2);
        stringBuilder.append(", expiration=");
        long l10 = this.expiration;
        stringBuilder.append(l10);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

