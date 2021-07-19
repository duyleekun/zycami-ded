/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.model.OSSResult;
import com.alibaba.sdk.android.oss.network.CancellationHandler;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class OSSAsyncTask {
    private volatile boolean canceled;
    private ExecutionContext context;
    private Future future;

    public static OSSAsyncTask wrapRequestTask(Future future, ExecutionContext executionContext) {
        OSSAsyncTask oSSAsyncTask = new OSSAsyncTask();
        oSSAsyncTask.future = future;
        oSSAsyncTask.context = executionContext;
        return oSSAsyncTask;
    }

    public void cancel() {
        boolean bl2;
        this.canceled = bl2 = true;
        Object object = this.context;
        if (object != null) {
            object = ((ExecutionContext)object).getCancellationHandler();
            ((CancellationHandler)object).cancel();
        }
    }

    public OSSResult getResult() {
        Object object = this.future;
        object = object.get();
        try {
            return (OSSResult)object;
        }
        catch (ExecutionException executionException) {
            object = executionException.getCause();
            boolean bl2 = object instanceof ClientException;
            if (!bl2) {
                bl2 = object instanceof ServiceException;
                if (bl2) {
                    throw (ServiceException)object;
                }
                ((Throwable)object).printStackTrace();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected exception!");
                object = ((Throwable)object).getMessage();
                stringBuilder.append((String)object);
                object = stringBuilder.toString();
                ClientException clientException = new ClientException((String)object);
                throw clientException;
            }
            throw (ClientException)object;
        }
        catch (InterruptedException interruptedException) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append(" InterruptedException and message : ");
            String string2 = interruptedException.getMessage();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            ClientException clientException = new ClientException((String)charSequence, interruptedException);
            throw clientException;
        }
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public boolean isCompleted() {
        return this.future.isDone();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void waitUntilFinished() {
        Future future;
        try {
            future = this.future;
        }
        catch (Exception exception) {
            return;
        }
        future.get();
    }
}

