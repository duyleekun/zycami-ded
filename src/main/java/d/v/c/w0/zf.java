/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import d.v.c.n1.j2;
import d.v.c.w0.yf;

public class zf
extends yf {
    private static final ViewDataBinding$IncludedLayouts g;
    private static final SparseIntArray h;
    private final FrameLayout e;
    private long f;

    static {
        SparseIntArray sparseIntArray;
        h = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363378, 2);
        sparseIntArray.put(2131362759, 3);
    }

    public zf(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = g;
        SparseIntArray sparseIntArray = h;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private zf(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[1];
        object2 = (CheckBox)object;
        Object object3 = object = objectArray[3];
        object3 = (ImageView)object;
        Object object4 = object = objectArray[2];
        object4 = (TextView)object;
        super(dataBindingComponent, view, 1, (CheckBox)object2, (ImageView)object3, (TextView)object4);
        this.f = -1;
        this.a.setTag(null);
        dataBindingComponent = (FrameLayout)objectArray[0];
        this.e = dataBindingComponent;
        dataBindingComponent.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean A(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.f;
                long l11 = 1L;
                this.f = l10 |= l11;
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
    public void executeBindings() {
        long l10;
        synchronized (this) {
            long l11 = this.f;
            this.f = l10 = 0L;
        }
        j2 j22 = this.d;
        long l12 = 7;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        boolean bl2 = false;
        Object object = null;
        if (l14 != false) {
            Object object2 = null;
            MutableLiveData mutableLiveData = j22 != null ? j22.K() : null;
            this.updateLiveDataRegistration(0, mutableLiveData);
            if (mutableLiveData != null) {
                object2 = object = mutableLiveData.getValue();
                object2 = (Boolean)object;
            }
            bl2 = ViewDataBinding.safeUnbox(object2);
        }
        if (l14 != false) {
            CheckBox checkBox = this.a;
            CompoundButtonBindingAdapter.setChecked((CompoundButton)checkBox, bl2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.f;
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
            this.f = l10 = (long)4;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (MutableLiveData)object;
        return this.A((MutableLiveData)object, n11);
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 152;
        if (n11 == n10) {
            object = (j2)object;
            this.z((j2)object);
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
    public void z(j2 j22) {
        this.d = j22;
        synchronized (this) {
            long l10 = this.f;
            long l11 = 2;
            this.f = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }
}

