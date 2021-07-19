/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.network;

import com.alibaba.sdk.android.oss.network.ExecutionContext;
import com.alibaba.sdk.android.oss.network.NetworkProgressHelper$1;
import com.alibaba.sdk.android.oss.network.ProgressTouchableRequestBody;
import g.z;
import g.z$a;
import java.io.InputStream;

public class NetworkProgressHelper {
    public static ProgressTouchableRequestBody addProgressRequestBody(InputStream inputStream, long l10, String string2, ExecutionContext executionContext) {
        ProgressTouchableRequestBody progressTouchableRequestBody = new ProgressTouchableRequestBody(inputStream, l10, string2, executionContext);
        return progressTouchableRequestBody;
    }

    public static z addProgressResponseListener(z object, ExecutionContext executionContext) {
        object = ((z)object).c0();
        NetworkProgressHelper$1 networkProgressHelper$1 = new NetworkProgressHelper$1(executionContext);
        return ((z$a)object).d(networkProgressHelper$1).f();
    }
}

