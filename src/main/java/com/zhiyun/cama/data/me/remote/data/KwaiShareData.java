/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.me.remote.data;

import com.zhiyun.cama.data.me.remote.data.KwaiShareData$KuaishouBean;
import com.zhiyun.cama.data.me.remote.data.KwaiShareData$OssBean;

public class KwaiShareData {
    private String access_token;
    private String appid;
    private String device_platform;
    private String file_url;
    private KwaiShareData$KuaishouBean kuaishou;
    private KwaiShareData$OssBean oss;
    private String platform;
    private long ts;
    private int userid;

    public String getAccess_token() {
        return this.access_token;
    }

    public String getAppid() {
        return this.appid;
    }

    public String getDevice_platform() {
        return this.device_platform;
    }

    public String getFile_url() {
        return this.file_url;
    }

    public KwaiShareData$KuaishouBean getKuaishou() {
        return this.kuaishou;
    }

    public KwaiShareData$OssBean getOss() {
        return this.oss;
    }

    public String getPlatform() {
        return this.platform;
    }

    public long getTs() {
        return this.ts;
    }

    public int getUserid() {
        return this.userid;
    }

    public void setAccess_token(String string2) {
        this.access_token = string2;
    }

    public void setAppid(String string2) {
        this.appid = string2;
    }

    public void setDevice_platform(String string2) {
        this.device_platform = string2;
    }

    public void setFile_url(String string2) {
        this.file_url = string2;
    }

    public void setKuaishou(KwaiShareData$KuaishouBean kwaiShareData$KuaishouBean) {
        this.kuaishou = kwaiShareData$KuaishouBean;
    }

    public void setOss(KwaiShareData$OssBean kwaiShareData$OssBean) {
        this.oss = kwaiShareData$OssBean;
    }

    public void setPlatform(String string2) {
        this.platform = string2;
    }

    public void setTs(long l10) {
        this.ts = l10;
    }

    public void setUserid(int n10) {
        this.userid = n10;
    }
}

