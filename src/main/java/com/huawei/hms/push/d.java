/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.support.log.HMSLog;

public class d {
    public static ErrorEnum a(Context context) {
        String string2 = BaseUtils.getLocalToken(context, null);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            bl2 = AutoInitHelper.isAutoInitEnabled(context);
            String string3 = "TokenUtil";
            if (bl2) {
                HMSLog.e(string3, "Token not exist, try auto init");
                AutoInitHelper.doAutoInit(context);
                return ErrorEnum.ERROR_AUTO_INITIALIZING;
            }
            HMSLog.e(string3, "Token not exist");
            return ErrorEnum.ERROR_NO_TOKEN;
        }
        return ErrorEnum.SUCCESS;
    }
}

