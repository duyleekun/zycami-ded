/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.ServiceManager$1;

public final class ServiceManager$NoOpService
extends AbstractService {
    private ServiceManager$NoOpService() {
    }

    public /* synthetic */ ServiceManager$NoOpService(ServiceManager$1 serviceManager$1) {
        this();
    }

    public void doStart() {
        this.notifyStarted();
    }

    public void doStop() {
        this.notifyStopped();
    }
}

