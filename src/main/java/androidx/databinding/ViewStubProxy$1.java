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
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewStubProxy;

public class ViewStubProxy$1
implements ViewStub.OnInflateListener {
    public final /* synthetic */ ViewStubProxy this$0;

    public ViewStubProxy$1(ViewStubProxy viewStubProxy) {
        this.this$0 = viewStubProxy;
    }

    public void onInflate(ViewStub object, View view) {
        ViewStubProxy.access$002(this.this$0, view);
        ViewStubProxy viewStubProxy = this.this$0;
        Object object2 = ViewStubProxy.access$200((ViewStubProxy)viewStubProxy).mBindingComponent;
        int n10 = object.getLayoutResource();
        object2 = DataBindingUtil.bind((DataBindingComponent)object2, view, n10);
        ViewStubProxy.access$102(viewStubProxy, (ViewDataBinding)object2);
        viewStubProxy = this.this$0;
        object2 = null;
        ViewStubProxy.access$302(viewStubProxy, null);
        viewStubProxy = ViewStubProxy.access$400(this.this$0);
        if (viewStubProxy != null) {
            viewStubProxy = ViewStubProxy.access$400(this.this$0);
            viewStubProxy.onInflate((ViewStub)object, view);
            object = this.this$0;
            ViewStubProxy.access$402((ViewStubProxy)object, null);
        }
        ViewStubProxy.access$200(this.this$0).invalidateAll();
        ViewStubProxy.access$200(this.this$0).forceExecuteBindings();
    }
}

