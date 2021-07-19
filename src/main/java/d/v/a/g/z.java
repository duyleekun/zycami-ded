/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.CheckBox
 *  android.widget.EditText
 *  android.widget.LinearLayout
 */
package d.v.a.g;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.account.R$id;
import d.v.a.g.y;

public class z
extends y {
    private static final ViewDataBinding$IncludedLayouts e;
    private static final SparseIntArray f;
    private final LinearLayout c;
    private long d;

    static {
        SparseIntArray sparseIntArray;
        f = sparseIntArray = new SparseIntArray();
        int n10 = R$id.et_pass;
        sparseIntArray.put(n10, 1);
        n10 = R$id.cb_see;
        sparseIntArray.put(n10, 2);
    }

    public z(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = e;
        SparseIntArray sparseIntArray = f;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 3, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private z(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[2];
        object2 = (CheckBox)object;
        Object object3 = object = objectArray[1];
        object3 = (EditText)object;
        super(dataBindingComponent, view, 0, (CheckBox)object2, (EditText)object3);
        this.d = -1;
        dataBindingComponent = (LinearLayout)objectArray[0];
        this.c = dataBindingComponent;
        dataBindingComponent.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        synchronized (this) {
            long l10;
            this.d = l10 = 0L;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.d;
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
            this.d = l10 = 1L;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        return true;
    }
}

