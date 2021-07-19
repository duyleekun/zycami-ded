/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.a.g;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.zhiyun.account.R$id;
import d.v.a.d;
import d.v.a.g.a;

public class b
extends a {
    private static final ViewDataBinding$IncludedLayouts j;
    private static final SparseIntArray k;
    private long i;

    static {
        SparseIntArray sparseIntArray;
        k = sparseIntArray = new SparseIntArray();
        int n10 = R$id.ll_error;
        sparseIntArray.put(n10, 3);
        n10 = R$id.bt_error;
        sparseIntArray.put(n10, 4);
        n10 = R$id.pb_loading;
        sparseIntArray.put(n10, 5);
    }

    public b(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = j;
        SparseIntArray sparseIntArray = k;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private b(DataBindingComponent dataBindingComponent, View view, Object[] object) {
        Object object2;
        Object object3 = object2 = object[4];
        object3 = (TextView)object2;
        Object object4 = object2 = object[0];
        object4 = (FrameLayout)object2;
        Object object5 = object2 = object[3];
        object5 = (LinearLayout)object2;
        Object object6 = object2 = object[5];
        object6 = (ProgressBar)object2;
        Object object7 = object2 = object[2];
        object7 = (TextView)object2;
        object = object[1];
        TextView textView = object;
        textView = (TextView)object;
        super(dataBindingComponent, view, 2, (TextView)object3, (FrameLayout)object4, (LinearLayout)object5, (ProgressBar)object6, (TextView)object7, textView);
        this.i = -1;
        this.b.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(ObservableField observableField, int n10) {
        int n11 = d.v.a.d.c;
        if (n10 == n11) {
            synchronized (this) {
                long l10 = this.i;
                long l11 = 1L;
                this.i = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean D(ObservableField observableField, int n10) {
        int n11 = d.v.a.d.c;
        if (n10 == n11) {
            synchronized (this) {
                long l10 = this.i;
                long l11 = 2;
                this.i = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void A(ObservableField observableField) {
        this.updateRegistration(0, observableField);
        this.h = observableField;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 1L;
            this.i = l10 |= l11;
        }
        int n10 = d.v.a.d.Z;
        this.notifyPropertyChanged(n10);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(ObservableField observableField) {
        int n10 = 1;
        this.updateRegistration(n10, observableField);
        this.g = observableField;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 2;
            this.i = l10 |= l11;
        }
        int n11 = d.v.a.d.c0;
        this.notifyPropertyChanged(n11);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        Object object;
        long l10;
        long l11;
        synchronized (this) {
            l11 = this.i;
            this.i = l10 = 0L;
        }
        ObservableField observableField = this.h;
        ObservableField observableField2 = this.g;
        long l12 = (long)5 & l11;
        long l13 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
        Object object2 = null;
        observableField = l13 != false && observableField != null ? (Drawable)observableField.get() : null;
        long l14 = 6;
        long l15 = (l11 &= l14) - l10;
        long l16 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (l16 != false && observableField2 != null) {
            object2 = object = observableField2.get();
            object2 = (Drawable)object;
        }
        if (l13 != false) {
            object = this.e;
            TextViewBindingAdapter.setDrawableTop((TextView)object, (Drawable)observableField);
        }
        if (l16 != false) {
            TextView textView = this.f;
            TextViewBindingAdapter.setDrawableTop(textView, (Drawable)object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.i;
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
            this.i = l10 = (long)4;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                return false;
            }
            object = (ObservableField)object;
            return this.D((ObservableField)object, n11);
        }
        object = (ObservableField)object;
        return this.C((ObservableField)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = d.v.a.d.Z;
        if (n11 == n10) {
            object = (ObservableField)object;
            this.A((ObservableField)object);
            return 1 != 0;
        } else {
            n11 = d.v.a.d.c0;
            if (n11 != n10) return 0 != 0;
            object = (ObservableField)object;
            this.B((ObservableField)object);
        }
        return 1 != 0;
    }
}

