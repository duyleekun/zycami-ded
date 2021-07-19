/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.alibaba.sdk.android.oss.network;

import android.content.Context;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.callback.OSSRetryCallback;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.network.CancellationHandler;
import g.z;

public class ExecutionContext {
    private Context applicationContext;
    private CancellationHandler cancellationHandler;
    private z client;
    private OSSCompletedCallback completedCallback;
    private OSSProgressCallback progressCallback;
    private OSSRequest request;
    private OSSRetryCallback retryCallback;

    public ExecutionContext(z z10, OSSRequest oSSRequest) {
        this(z10, oSSRequest, null);
    }

    public ExecutionContext(z z10, OSSRequest oSSRequest, Context context) {
        CancellationHandler cancellationHandler;
        this.cancellationHandler = cancellationHandler = new CancellationHandler();
        this.setClient(z10);
        this.setRequest(oSSRequest);
        this.applicationContext = context;
    }

    public Context getApplicationContext() {
        return this.applicationContext;
    }

    public CancellationHandler getCancellationHandler() {
        return this.cancellationHandler;
    }

    public z getClient() {
        return this.client;
    }

    public OSSCompletedCallback getCompletedCallback() {
        return this.completedCallback;
    }

    public OSSProgressCallback getProgressCallback() {
        return this.progressCallback;
    }

    public OSSRequest getRequest() {
        return this.request;
    }

    public OSSRetryCallback getRetryCallback() {
        return this.retryCallback;
    }

    public void setClient(z z10) {
        this.client = z10;
    }

    public void setCompletedCallback(OSSCompletedCallback oSSCompletedCallback) {
        this.completedCallback = oSSCompletedCallback;
    }

    public void setProgressCallback(OSSProgressCallback oSSProgressCallback) {
        this.progressCallback = oSSProgressCallback;
    }

    public void setRequest(OSSRequest oSSRequest) {
        this.request = oSSRequest;
    }

    public void setRetryCallback(OSSRetryCallback oSSRetryCallback) {
        this.retryCallback = oSSRetryCallback;
    }
}

