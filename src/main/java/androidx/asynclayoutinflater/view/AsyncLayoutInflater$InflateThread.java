/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 *  android.util.Log
 *  android.view.ViewGroup
 */
package androidx.asynclayoutinflater.view;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.ViewGroup;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater$InflateRequest;
import androidx.core.util.Pools$SynchronizedPool;
import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;

public class AsyncLayoutInflater$InflateThread
extends Thread {
    private static final AsyncLayoutInflater$InflateThread sInstance;
    private ArrayBlockingQueue mQueue;
    private Pools$SynchronizedPool mRequestPool;

    static {
        AsyncLayoutInflater$InflateThread asyncLayoutInflater$InflateThread;
        sInstance = asyncLayoutInflater$InflateThread = new AsyncLayoutInflater$InflateThread();
        asyncLayoutInflater$InflateThread.start();
    }

    private AsyncLayoutInflater$InflateThread() {
        int n10 = 10;
        Object object = new ArrayBlockingQueue(n10);
        this.mQueue = object;
        this.mRequestPool = object = new Pools$SynchronizedPool(n10);
    }

    public static AsyncLayoutInflater$InflateThread getInstance() {
        return sInstance;
    }

    public void enqueue(AsyncLayoutInflater$InflateRequest asyncLayoutInflater$InflateRequest) {
        Serializable serializable;
        try {
            serializable = this.mQueue;
        }
        catch (InterruptedException interruptedException) {
            serializable = new RuntimeException("Failed to enqueue async inflate request", interruptedException);
            throw serializable;
        }
        serializable.put(asyncLayoutInflater$InflateRequest);
    }

    public AsyncLayoutInflater$InflateRequest obtainRequest() {
        AsyncLayoutInflater$InflateRequest asyncLayoutInflater$InflateRequest = (AsyncLayoutInflater$InflateRequest)this.mRequestPool.acquire();
        if (asyncLayoutInflater$InflateRequest == null) {
            asyncLayoutInflater$InflateRequest = new AsyncLayoutInflater$InflateRequest();
        }
        return asyncLayoutInflater$InflateRequest;
    }

    public void releaseRequest(AsyncLayoutInflater$InflateRequest asyncLayoutInflater$InflateRequest) {
        asyncLayoutInflater$InflateRequest.callback = null;
        asyncLayoutInflater$InflateRequest.inflater = null;
        asyncLayoutInflater$InflateRequest.parent = null;
        asyncLayoutInflater$InflateRequest.resid = 0;
        asyncLayoutInflater$InflateRequest.view = null;
        this.mRequestPool.release(asyncLayoutInflater$InflateRequest);
    }

    public void run() {
        while (true) {
            this.runInner();
        }
    }

    public void runInner() {
        Object object;
        String string2 = "AsyncLayoutInflater";
        try {
            object = this.mQueue;
        }
        catch (InterruptedException interruptedException) {
            Log.w((String)string2, (Throwable)interruptedException);
            return;
        }
        object = ((ArrayBlockingQueue)object).take();
        object = (AsyncLayoutInflater$InflateRequest)object;
        AsyncLayoutInflater asyncLayoutInflater = ((AsyncLayoutInflater$InflateRequest)object).inflater;
        asyncLayoutInflater = asyncLayoutInflater.mInflater;
        int n10 = ((AsyncLayoutInflater$InflateRequest)object).resid;
        ViewGroup viewGroup = ((AsyncLayoutInflater$InflateRequest)object).parent;
        asyncLayoutInflater = asyncLayoutInflater.inflate(n10, viewGroup, false);
        try {
            ((AsyncLayoutInflater$InflateRequest)object).view = asyncLayoutInflater;
        }
        catch (RuntimeException runtimeException) {
            String string3 = "Failed to inflate resource in the background! Retrying on the UI thread";
            Log.w((String)string2, (String)string3, (Throwable)runtimeException);
        }
        Message.obtain((Handler)object.inflater.mHandler, (int)0, (Object)object).sendToTarget();
    }
}

