/*
 * Decompiled with CFR 0.151.
 */
package com.polidea.rxandroidble2.internal.serialization;

import com.polidea.rxandroidble2.internal.serialization.RxBleThreadFactory$a;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class RxBleThreadFactory
extends AtomicLong
implements ThreadFactory {
    public Thread newThread(Runnable runnable) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("RxBleThread-");
        long l10 = this.incrementAndGet();
        charSequence.append(l10);
        charSequence = charSequence.toString();
        RxBleThreadFactory$a rxBleThreadFactory$a = new RxBleThreadFactory$a(runnable, (String)charSequence);
        rxBleThreadFactory$a.setPriority(5);
        rxBleThreadFactory$a.setDaemon(true);
        return rxBleThreadFactory$a;
    }
}

