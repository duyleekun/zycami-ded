/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.me.remote.data;

import com.zhiyun.cama.data.me.remote.data.KwaiShareData$OssBean;

public class KwaiShareData$KuaishouBean {
    private String caption;
    private String cover;
    private KwaiShareData.OssBean oss;
    private String stereo_type;

    public String getCaption() {
        return this.caption;
    }

    public String getCover() {
        return this.cover;
    }

    public KwaiShareData.OssBean getOss() {
        return this.oss;
    }

    public String getStereo_type() {
        return this.stereo_type;
    }

    public void setCaption(String string2) {
        this.caption = string2;
    }

    public void setCover(String string2) {
        this.cover = string2;
    }

    public void setOss(KwaiShareData.OssBean ossBean) {
        this.oss = ossBean;
    }

    public void setStereo_type(String string2) {
        this.stereo_type = string2;
    }
}

