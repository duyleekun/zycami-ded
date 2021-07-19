/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

public final class AdsMediaSource$AdLoadException
extends IOException {
    public static final int TYPE_AD = 0;
    public static final int TYPE_AD_GROUP = 1;
    public static final int TYPE_ALL_ADS = 2;
    public static final int TYPE_UNEXPECTED = 3;
    public final int type;

    private AdsMediaSource$AdLoadException(int n10, Exception exception) {
        super(exception);
        this.type = n10;
    }

    public static AdsMediaSource$AdLoadException createForAd(Exception exception) {
        AdsMediaSource$AdLoadException adsMediaSource$AdLoadException = new AdsMediaSource$AdLoadException(0, exception);
        return adsMediaSource$AdLoadException;
    }

    public static AdsMediaSource$AdLoadException createForAdGroup(Exception exception, int n10) {
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append("Failed to load ad group ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IOException iOException = new IOException(string2, exception);
        AdsMediaSource$AdLoadException adsMediaSource$AdLoadException = new AdsMediaSource$AdLoadException(1, iOException);
        return adsMediaSource$AdLoadException;
    }

    public static AdsMediaSource$AdLoadException createForAllAds(Exception exception) {
        AdsMediaSource$AdLoadException adsMediaSource$AdLoadException = new AdsMediaSource$AdLoadException(2, exception);
        return adsMediaSource$AdLoadException;
    }

    public static AdsMediaSource$AdLoadException createForUnexpected(RuntimeException runtimeException) {
        AdsMediaSource$AdLoadException adsMediaSource$AdLoadException = new AdsMediaSource$AdLoadException(3, runtimeException);
        return adsMediaSource$AdLoadException;
    }

    public RuntimeException getRuntimeExceptionForUnexpected() {
        int n10 = this.type;
        int n11 = 3;
        n10 = n10 == n11 ? 1 : 0;
        Assertions.checkState(n10 != 0);
        return (RuntimeException)Assertions.checkNotNull(this.getCause());
    }
}

