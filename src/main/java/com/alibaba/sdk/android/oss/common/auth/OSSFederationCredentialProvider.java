/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.common.auth;

import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationToken;
import com.alibaba.sdk.android.oss.common.utils.DateUtil;

public abstract class OSSFederationCredentialProvider
implements OSSCredentialProvider {
    private volatile OSSFederationToken cachedToken;

    public OSSFederationToken getCachedToken() {
        return this.cachedToken;
    }

    public abstract OSSFederationToken getFederationToken();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public OSSFederationToken getValidFederationToken() {
        synchronized (this) {
            long l10;
            Object object = this.cachedToken;
            long l11 = 1000L;
            if (object != null) {
                l10 = DateUtil.getFixedSkewedTimeMillis();
                object = this.cachedToken;
                long l12 = ((OSSFederationToken)object).getExpiration();
                long l13 = 300L;
                long l14 = (l10 /= l11) - (l12 -= l13);
                Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object2 <= 0) return this.cachedToken;
            }
            if ((object = this.cachedToken) != null) {
                object = new StringBuilder();
                String string2 = "token expired! current time: ";
                ((StringBuilder)object).append(string2);
                l10 = DateUtil.getFixedSkewedTimeMillis();
                ((StringBuilder)object).append(l10 /= l11);
                Object object3 = " token expired: ";
                ((StringBuilder)object).append((String)object3);
                object3 = this.cachedToken;
                l11 = ((OSSFederationToken)object3).getExpiration();
                ((StringBuilder)object).append(l11);
                object = ((StringBuilder)object).toString();
                OSSLog.logDebug((String)object);
            }
            this.cachedToken = object = this.getFederationToken();
            return this.cachedToken;
        }
    }
}

