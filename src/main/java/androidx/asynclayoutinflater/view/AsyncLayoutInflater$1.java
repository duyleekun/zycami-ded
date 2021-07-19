/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.asynclayoutinflater.view;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater$InflateRequest;

public class AsyncLayoutInflater$1
implements Handler.Callback {
    public final /* synthetic */ AsyncLayoutInflater this$0;

    public AsyncLayoutInflater$1(AsyncLayoutInflater asyncLayoutInflater) {
        this.this$0 = asyncLayoutInflater;
    }

    public boolean handleMessage(Message object) {
        ViewGroup viewGroup;
        object = (AsyncLayoutInflater$InflateRequest)object.obj;
        Object object2 = object.view;
        if (object2 == null) {
            object2 = this.this$0.mInflater;
            int n10 = object.resid;
            ViewGroup viewGroup2 = object.parent;
            viewGroup = null;
            object2 = object2.inflate(n10, viewGroup2, false);
            object.view = object2;
        }
        object2 = object.callback;
        View view = object.view;
        int n11 = object.resid;
        viewGroup = object.parent;
        object2.onInflateFinished(view, n11, viewGroup);
        this.this$0.mInflateThread.releaseRequest((AsyncLayoutInflater$InflateRequest)object);
        return true;
    }
}

