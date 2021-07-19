/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.framework.common;

import com.huawei.hms.framework.common.ExecutorsEnhance$DelegatedExecutorService;
import java.util.concurrent.ExecutorService;

public class ExecutorsEnhance$FinalizableDelegatedExecutorService
extends ExecutorsEnhance$DelegatedExecutorService {
    public ExecutorsEnhance$FinalizableDelegatedExecutorService(ExecutorService executorService) {
        super(executorService);
    }

    public void finalize() {
        super.shutdown();
    }
}

