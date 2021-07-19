/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewStub
 *  android.view.ViewStub$OnInflateListener
 */
package androidx.databinding;

import android.view.View;
import android.view.ViewStub;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewStubProxy$1;

public class ViewStubProxy {
    private ViewDataBinding mContainingBinding;
    private ViewStub.OnInflateListener mOnInflateListener;
    private ViewStub.OnInflateListener mProxyListener;
    private View mRoot;
    private ViewDataBinding mViewDataBinding;
    private ViewStub mViewStub;

    public ViewStubProxy(ViewStub viewStub) {
        ViewStubProxy$1 viewStubProxy$1 = new ViewStubProxy$1(this);
        this.mProxyListener = viewStubProxy$1;
        this.mViewStub = viewStub;
        viewStub.setOnInflateListener((ViewStub.OnInflateListener)viewStubProxy$1);
    }

    public static /* synthetic */ View access$002(ViewStubProxy viewStubProxy, View view) {
        viewStubProxy.mRoot = view;
        return view;
    }

    public static /* synthetic */ ViewDataBinding access$102(ViewStubProxy viewStubProxy, ViewDataBinding viewDataBinding) {
        viewStubProxy.mViewDataBinding = viewDataBinding;
        return viewDataBinding;
    }

    public static /* synthetic */ ViewDataBinding access$200(ViewStubProxy viewStubProxy) {
        return viewStubProxy.mContainingBinding;
    }

    public static /* synthetic */ ViewStub access$302(ViewStubProxy viewStubProxy, ViewStub viewStub) {
        viewStubProxy.mViewStub = viewStub;
        return viewStub;
    }

    public static /* synthetic */ ViewStub.OnInflateListener access$400(ViewStubProxy viewStubProxy) {
        return viewStubProxy.mOnInflateListener;
    }

    public static /* synthetic */ ViewStub.OnInflateListener access$402(ViewStubProxy viewStubProxy, ViewStub.OnInflateListener onInflateListener) {
        viewStubProxy.mOnInflateListener = onInflateListener;
        return onInflateListener;
    }

    public ViewDataBinding getBinding() {
        return this.mViewDataBinding;
    }

    public View getRoot() {
        return this.mRoot;
    }

    public ViewStub getViewStub() {
        return this.mViewStub;
    }

    public boolean isInflated() {
        boolean bl2;
        View view = this.mRoot;
        if (view != null) {
            bl2 = true;
        } else {
            bl2 = false;
            view = null;
        }
        return bl2;
    }

    public void setContainingBinding(ViewDataBinding viewDataBinding) {
        this.mContainingBinding = viewDataBinding;
    }

    public void setOnInflateListener(ViewStub.OnInflateListener onInflateListener) {
        ViewStub viewStub = this.mViewStub;
        if (viewStub != null) {
            this.mOnInflateListener = onInflateListener;
        }
    }
}

