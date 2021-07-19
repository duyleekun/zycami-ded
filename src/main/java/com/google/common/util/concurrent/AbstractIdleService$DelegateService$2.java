/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractIdleService;
import com.google.common.util.concurrent.AbstractIdleService$DelegateService;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.Service;

public class AbstractIdleService$DelegateService$2
implements Runnable {
    public final /* synthetic */ AbstractIdleService$DelegateService this$1;

    public AbstractIdleService$DelegateService$2(AbstractIdleService$DelegateService abstractIdleService$DelegateService) {
        this.this$1 = abstractIdleService$DelegateService;
    }

    public void run() {
        Service service = this.this$1;
        service = ((AbstractIdleService$DelegateService)service).this$0;
        ((AbstractIdleService)service).shutDown();
        service = this.this$1;
        try {
            ((AbstractService)service).notifyStopped();
        }
        catch (Throwable throwable) {
            AbstractIdleService$DelegateService abstractIdleService$DelegateService = this.this$1;
            abstractIdleService$DelegateService.notifyFailed(throwable);
        }
    }
}

