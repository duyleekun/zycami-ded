/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.api;

import android.content.Context;
import com.huawei.hms.api.BindingFailedResolution$a;
import com.huawei.hms.ui.AbstractPromptDialog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.Util;

public class BindingFailedResolution$d
extends AbstractPromptDialog {
    private BindingFailedResolution$d() {
    }

    public /* synthetic */ BindingFailedResolution$d(BindingFailedResolution$a bindingFailedResolution$a) {
        this();
    }

    public String onGetMessageString(Context object) {
        String string2 = Util.getAppName(object, null);
        Object[] objectArray = HMSPackageManager.getInstance(object).getHMSPackageName();
        object = Util.getAppName(object, (String)objectArray);
        objectArray = new Object[]{string2, object};
        return ResourceLoaderUtil.getString("hms_bindfaildlg_message", objectArray);
    }

    public String onGetPositiveButtonString(Context context) {
        return ResourceLoaderUtil.getString("hms_confirm");
    }
}

