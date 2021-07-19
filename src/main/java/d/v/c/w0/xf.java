/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.data.api.entity.BindDeviceInfo;
import d.v.c.w0.wf;
import l.a.q.g0.u;

public class xf
extends wf {
    private static final ViewDataBinding$IncludedLayouts h;
    private static final SparseIntArray i;
    private final ConstraintLayout f;
    private long g;

    static {
        SparseIntArray sparseIntArray;
        i = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362079, 3);
        sparseIntArray.put(2131362808, 4);
    }

    public xf(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = h;
        SparseIntArray sparseIntArray = i;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 5, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private xf(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[3];
        object3 = (TextView)object2;
        Object object4 = object2 = objectArray[4];
        object4 = (View)object2;
        Object object5 = object2 = objectArray[1];
        object5 = (TextView)object2;
        Object object6 = object2 = objectArray[2];
        object6 = (TextView)object2;
        super(object, view, 0, (TextView)object3, (View)object4, (TextView)object5, (TextView)object6);
        this.g = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.f = object;
        object.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
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
        long l11;
        boolean bl2;
        String string2;
        long l12;
        long l13;
        synchronized (this) {
            l13 = this.g;
            this.g = l12 = 0L;
        }
        Object object = this.e;
        long l14 = 3;
        long l15 = l13 & l14;
        long l16 = l15 == l12 ? 0 : (l15 < l12 ? -1 : 1);
        boolean bl3 = false;
        if (l16 != false) {
            long l17;
            long l18;
            if (object != null) {
                string2 = ((BindDeviceInfo)object).getDeviceName();
                object = ((BindDeviceInfo)object).getDeviceModel();
            } else {
                object = null;
                string2 = null;
            }
            boolean bl4 = true;
            bl2 = string2 == null ? bl4 : false;
            if (object == null) {
                bl3 = bl4;
            }
            if (l16 != false) {
                l18 = bl2 ? (long)32 : (long)16;
                l13 |= l18;
            }
            if ((l16 = (l17 = (l18 = l13 & l14) - l12) == 0L ? 0 : (l17 < 0L ? -1 : 1)) != false) {
                l18 = bl3 ? (long)8 : (long)4;
                l13 |= l18;
            }
        } else {
            bl2 = false;
            object = null;
            string2 = null;
        }
        if ((l11 = (l10 = (l13 &= l14) - l12) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            if (bl3) {
                object = "";
            }
            if (bl2) {
                string2 = "";
            }
        } else {
            object = null;
            string2 = null;
        }
        if (l11 != false) {
            u.n(this.c, "@string/bind_device_model", object, null);
            TextView textView = this.d;
            String string3 = "@string/bind_device_name";
            u.n(textView, string3, string2, null);
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
        int n11 = 10;
        if (n11 == n10) {
            object = (BindDeviceInfo)object;
            this.z((BindDeviceInfo)object);
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
    public void z(BindDeviceInfo bindDeviceInfo) {
        this.e = bindDeviceInfo;
        synchronized (this) {
            long l10 = this.g;
            long l11 = 1L;
            this.g = l10 |= l11;
        }
        this.notifyPropertyChanged(10);
        super.requestRebind();
    }
}

