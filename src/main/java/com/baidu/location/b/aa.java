/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.b;

import com.baidu.location.b.aa$1;
import com.baidu.location.b.aa$a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class aa {
    private ExecutorService a;
    private ExecutorService b;

    private aa() {
    }

    public /* synthetic */ aa(aa$1 aa$1) {
        this();
    }

    public static aa a() {
        return aa$a.a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ExecutorService b() {
        synchronized (this) {
            boolean bl2;
            ExecutorService executorService = this.a;
            if (executorService != null) {
                bl2 = executorService.isShutdown();
                if (!bl2) return this.a;
            }
            bl2 = false;
            executorService = null;
            this.a = null;
            this.a = executorService = Executors.newSingleThreadExecutor();
            return this.a;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ExecutorService c() {
        synchronized (this) {
            int n10;
            ExecutorService executorService = this.b;
            if (executorService != null) {
                n10 = executorService.isShutdown();
                if (n10 == 0) return this.b;
            }
            n10 = 0;
            executorService = null;
            this.b = null;
            n10 = 2;
            this.b = executorService = Executors.newFixedThreadPool(n10);
            return this.b;
        }
    }

    public void d() {
        ExecutorService executorService = this.a;
        if (executorService != null) {
            executorService.shutdown();
        }
        if ((executorService = this.b) != null) {
            executorService.shutdown();
        }
    }
}

