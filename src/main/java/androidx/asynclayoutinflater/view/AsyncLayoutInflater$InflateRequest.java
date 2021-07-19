/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.asynclayoutinflater.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater$OnInflateFinishedListener;

public class AsyncLayoutInflater$InflateRequest {
    public AsyncLayoutInflater$OnInflateFinishedListener callback;
    public AsyncLayoutInflater inflater;
    public ViewGroup parent;
    public int resid;
    public View view;
}

