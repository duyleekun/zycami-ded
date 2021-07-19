/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.ads.identifier;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class AdvertisingIdClient$zza
extends Thread {
    private WeakReference zzm;
    private long zzn;
    public CountDownLatch zzo;
    public boolean zzp;

    public AdvertisingIdClient$zza(AdvertisingIdClient object, long l10) {
        WeakReference<AdvertisingIdClient> weakReference;
        this.zzm = weakReference = new WeakReference<AdvertisingIdClient>((AdvertisingIdClient)object);
        this.zzn = l10;
        this.zzo = object = new CountDownLatch(1);
        this.zzp = false;
        this.start();
    }

    private final void disconnect() {
        AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient)this.zzm.get();
        if (advertisingIdClient != null) {
            boolean bl2;
            advertisingIdClient.finish();
            this.zzp = bl2 = true;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void run() {
        CountDownLatch countDownLatch;
        try {
            countDownLatch = this.zzo;
        }
        catch (InterruptedException interruptedException) {
            this.disconnect();
            return;
        }
        long l10 = this.zzn;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        boolean bl2 = countDownLatch.await(l10, timeUnit);
        if (bl2) return;
        this.disconnect();
    }
}

