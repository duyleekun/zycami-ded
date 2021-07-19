/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 */
package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater$1;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater$InflateRequest;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater$InflateThread;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater$OnInflateFinishedListener;
import java.util.Objects;

public final class AsyncLayoutInflater {
    private static final String TAG = "AsyncLayoutInflater";
    public Handler mHandler;
    private Handler.Callback mHandlerCallback;
    public AsyncLayoutInflater$InflateThread mInflateThread;
    public LayoutInflater mInflater;

    public AsyncLayoutInflater(Context object) {
        Object object2 = new AsyncLayoutInflater$1(this);
        this.mHandlerCallback = object2;
        super((Context)object);
        this.mInflater = object2;
        object2 = this.mHandlerCallback;
        super((Handler.Callback)object2);
        this.mHandler = object;
        object = AsyncLayoutInflater$InflateThread.getInstance();
        this.mInflateThread = object;
    }

    public void inflate(int n10, ViewGroup viewGroup, AsyncLayoutInflater$OnInflateFinishedListener asyncLayoutInflater$OnInflateFinishedListener) {
        Objects.requireNonNull(asyncLayoutInflater$OnInflateFinishedListener, "callback argument may not be null!");
        AsyncLayoutInflater$InflateRequest asyncLayoutInflater$InflateRequest = this.mInflateThread.obtainRequest();
        asyncLayoutInflater$InflateRequest.inflater = this;
        asyncLayoutInflater$InflateRequest.resid = n10;
        asyncLayoutInflater$InflateRequest.parent = viewGroup;
        asyncLayoutInflater$InflateRequest.callback = asyncLayoutInflater$OnInflateFinishedListener;
        this.mInflateThread.enqueue(asyncLayoutInflater$InflateRequest);
    }
}

