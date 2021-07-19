/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.api;

import com.huawei.hms.api.BindingFailedResolution;
import com.huawei.hms.common.internal.BindResolveClients;
import com.huawei.hms.ui.AbstractDialog;
import com.huawei.hms.ui.AbstractDialog$Callback;

public class BindingFailedResolution$c
implements AbstractDialog$Callback {
    public final /* synthetic */ BindingFailedResolution a;

    public BindingFailedResolution$c(BindingFailedResolution bindingFailedResolution) {
        this.a = bindingFailedResolution;
    }

    public void onCancel(AbstractDialog abstractDialog) {
        BindingFailedResolution.a(this.a, null);
        BindResolveClients.getInstance().unRegisterAll();
        BindingFailedResolution.a(this.a, 8);
    }

    public void onDoWork(AbstractDialog abstractDialog) {
        BindingFailedResolution.a(this.a, null);
        BindResolveClients.getInstance().unRegisterAll();
        BindingFailedResolution.a(this.a, 8);
    }
}

