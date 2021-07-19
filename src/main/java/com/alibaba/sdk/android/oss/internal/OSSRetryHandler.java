/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.internal.OSSRetryHandler$1;
import com.alibaba.sdk.android.oss.internal.OSSRetryType;
import java.io.InterruptedIOException;
import java.io.Serializable;
import java.net.SocketTimeoutException;

public class OSSRetryHandler {
    private int maxRetryCount = 2;

    public OSSRetryHandler(int n10) {
        this.setMaxRetryCount(n10);
    }

    public void setMaxRetryCount(int n10) {
        this.maxRetryCount = n10;
    }

    public OSSRetryType shouldRetry(Exception exception, int n10) {
        int n11 = this.maxRetryCount;
        if (n10 >= n11) {
            return OSSRetryType.OSSRetryTypeShouldNotRetry;
        }
        n10 = exception instanceof ClientException;
        if (n10 != 0) {
            Serializable serializable = exception;
            serializable = ((ClientException)exception).isCanceledException();
            n10 = (int)(((Boolean)serializable).booleanValue() ? 1 : 0);
            if (n10 != 0) {
                return OSSRetryType.OSSRetryTypeShouldNotRetry;
            }
            serializable = (Exception)exception.getCause();
            n11 = serializable instanceof InterruptedIOException;
            if (n11 != 0 && (n11 = serializable instanceof SocketTimeoutException) == 0) {
                OSSLog.logError("[shouldRetry] - is interrupted!");
                return OSSRetryType.OSSRetryTypeShouldNotRetry;
            }
            n10 = serializable instanceof IllegalArgumentException;
            if (n10 != 0) {
                return OSSRetryType.OSSRetryTypeShouldNotRetry;
            }
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("shouldRetry - ");
            String string2 = exception.toString();
            ((StringBuilder)serializable).append(string2);
            OSSLog.logDebug(((StringBuilder)serializable).toString());
            exception.getCause().printStackTrace();
            return OSSRetryType.OSSRetryTypeShouldRetry;
        }
        n10 = exception instanceof ServiceException;
        if (n10 != 0) {
            String string3;
            String string4 = ((ServiceException)(exception = (ServiceException)exception)).getErrorCode();
            if (string4 != null && (n10 = (int)((string4 = ((ServiceException)exception).getErrorCode()).equalsIgnoreCase(string3 = "RequestTimeTooSkewed") ? 1 : 0)) != 0) {
                return OSSRetryType.OSSRetryTypeShouldFixedTimeSkewedAndRetry;
            }
            int n12 = ((ServiceException)exception).getStatusCode();
            if (n12 >= (n10 = 500)) {
                return OSSRetryType.OSSRetryTypeShouldRetry;
            }
            return OSSRetryType.OSSRetryTypeShouldNotRetry;
        }
        return OSSRetryType.OSSRetryTypeShouldNotRetry;
    }

    public long timeInterval(int n10, OSSRetryType oSSRetryType) {
        int[] nArray = OSSRetryHandler$1.$SwitchMap$com$alibaba$sdk$android$oss$internal$OSSRetryType;
        int n11 = oSSRetryType.ordinal();
        int n12 = 1;
        if ((n11 = nArray[n11]) != n12) {
            return 0L;
        }
        double d10 = n10;
        return (long)Math.pow(2.0, d10) * 200L;
    }
}

