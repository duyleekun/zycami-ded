/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations.remote;

import com.google.firebase.installations.Utils;
import java.util.concurrent.TimeUnit;

public class RequestLimiter {
    private static final long MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS = TimeUnit.HOURS.toMillis(24);
    private static final long MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS = TimeUnit.MINUTES.toMillis(30);
    private int attemptCount;
    private long nextRequestTime;
    private final Utils utils;

    public RequestLimiter() {
        Utils utils;
        this.utils = utils = Utils.getInstance();
    }

    public RequestLimiter(Utils utils) {
        this.utils = utils;
    }

    private long getBackoffDuration(int n10) {
        synchronized (this) {
            block11: {
                n10 = (int)(RequestLimiter.isRetryableError(n10) ? 1 : 0);
                if (n10 != 0) break block11;
                long l10 = MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS;
                return l10;
            }
            long l11 = 0x4000000000000000L;
            double d10 = 2.0;
            n10 = this.attemptCount;
            double d11 = n10;
            d10 = Math.pow(d10, d11);
            Utils utils = this.utils;
            long l12 = utils.getRandomDelayForSyncPrevention();
            d11 = l12;
            d10 += d11;
            l12 = MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS;
            d11 = l12;
            l11 = (long)Math.min(d10, d11);
            return l11;
            finally {
            }
        }
    }

    private static boolean isRetryableError(int n10) {
        int n11 = 429;
        n10 = n10 != n11 && (n10 < (n11 = 500) || n10 >= (n11 = 600)) ? 0 : 1;
        return n10 != 0;
    }

    private static boolean isSuccessfulOrRequiresNewFidCreation(int n10) {
        int n11 = 200;
        n10 = (n10 < n11 || n10 >= (n11 = 300)) && n10 != (n11 = 401) && n10 != (n11 = 404) ? 0 : 1;
        return n10 != 0;
    }

    private void resetBackoffStrategy() {
        synchronized (this) {
            Object var1_1 = null;
            this.attemptCount = 0;
            return;
        }
    }

    public boolean isRequestAllowed() {
        synchronized (this) {
            int n10;
            block7: {
                block6: {
                    n10 = this.attemptCount;
                    if (n10 == 0) break block6;
                    Utils utils = this.utils;
                    long l10 = utils.currentTimeInMillis();
                    long l11 = this.nextRequestTime;
                    n10 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                    if (n10 > 0) break block6;
                    n10 = 0;
                    utils = null;
                    break block7;
                }
                n10 = 1;
            }
            return n10 != 0;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setNextRequestTime(int n10) {
        synchronized (this) {
            long l10;
            int n11 = RequestLimiter.isSuccessfulOrRequiresNewFidCreation(n10);
            if (n11 != 0) {
                this.resetBackoffStrategy();
                return;
            }
            this.attemptCount = n11 = this.attemptCount + 1;
            long l11 = this.getBackoffDuration(n10);
            Utils utils = this.utils;
            this.nextRequestTime = l10 = utils.currentTimeInMillis() + l11;
            return;
        }
    }
}

