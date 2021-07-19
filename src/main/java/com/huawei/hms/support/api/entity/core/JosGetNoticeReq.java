/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.support.api.entity.core.JosBaseReq;

public class JosGetNoticeReq
extends JosBaseReq {
    public static final int NOTICE_TYPE_CONN = 0;
    public static final int NOTICE_TYPE_SIGN = 1;
    private int noticeType;

    private static Object get(Object object) {
        return object;
    }

    public int getNoticeType() {
        return (Integer)JosGetNoticeReq.get(this.noticeType);
    }

    public void setNoticeType(int n10) {
        this.noticeType = n10;
    }
}

