/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.ui;

import android.content.Context;
import com.huawei.hms.ui.AbstractDialog;
import com.huawei.hms.utils.ResourceLoaderUtil;

public abstract class AbstractPromptDialog
extends AbstractDialog {
    public String onGetNegativeButtonString(Context context) {
        return null;
    }

    public String onGetTitleString(Context context) {
        Context context2 = ResourceLoaderUtil.getmContext();
        if (context2 == null) {
            ResourceLoaderUtil.setmContext(context);
        }
        return ResourceLoaderUtil.getString("hms_bindfaildlg_title");
    }
}

