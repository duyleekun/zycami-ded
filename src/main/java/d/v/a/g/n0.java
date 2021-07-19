/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.a.g;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.account.R$id;
import com.zhiyun.account.SimpleWebViewActivity$c;
import com.zhiyun.component.widget.JSWebView;
import d.v.a.d;
import d.v.a.g.m0;
import d.v.a.g.n0$a;

public class n0
extends m0 {
    private static final ViewDataBinding$IncludedLayouts h;
    private static final SparseIntArray i;
    private final ConstraintLayout e;
    private n0$a f;
    private long g;

    static {
        SparseIntArray sparseIntArray;
        i = sparseIntArray = new SparseIntArray();
        int n10 = R$id.tv_title;
        sparseIntArray.put(n10, 2);
        n10 = R$id.web;
        sparseIntArray.put(n10, 3);
    }

    public n0(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = h;
        SparseIntArray sparseIntArray = i;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private n0(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[1];
        object3 = (ImageView)object2;
        Object object4 = object2 = objectArray[2];
        object4 = (TextView)object2;
        Object object5 = object2 = objectArray[3];
        object5 = (JSWebView)((Object)object2);
        super(object, view, 0, (ImageView)object3, (TextView)object4, (JSWebView)((Object)object5));
        this.g = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.e = object;
        object.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        long l10;
        synchronized (this) {
            long l11 = this.g;
            this.g = l10 = 0L;
        }
        SimpleWebViewActivity$c simpleWebViewActivity$c = this.d;
        n0$a n0$a = null;
        long l12 = 3;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false && simpleWebViewActivity$c != null) {
            n0$a n0$a2 = this.f;
            if (n0$a2 == null) {
                this.f = n0$a2 = new n0$a();
            }
            n0$a = n0$a2.b(simpleWebViewActivity$c);
        }
        if (l14 != false) {
            ImageView imageView = this.a;
            imageView.setOnClickListener(n0$a);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.g;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 == false) return false;
            return (boolean)((long)1);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void invalidateAll() {
        synchronized (this) {
            long l10;
            this.g = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = d.v.a.d.x;
        if (n11 == n10) {
            object = (SimpleWebViewActivity$c)object;
            this.z((SimpleWebViewActivity$c)object);
            n10 = 1;
        } else {
            n10 = 0;
        }
        return n10 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void z(SimpleWebViewActivity$c simpleWebViewActivity$c) {
        this.d = simpleWebViewActivity$c;
        synchronized (this) {
            long l10 = this.g;
            long l11 = 1L;
            this.g = l10 |= l11;
        }
        int n10 = d.v.a.d.x;
        this.notifyPropertyChanged(n10);
        super.requestRebind();
    }
}

