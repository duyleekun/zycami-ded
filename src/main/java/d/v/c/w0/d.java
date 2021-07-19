/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.LinearLayout
 *  android.widget.ScrollView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import d.v.c.p0.m;
import d.v.c.w0.c;
import d.v.c.w0.v2;

public class d
extends c {
    private static final ViewDataBinding$IncludedLayouts m;
    private static final SparseIntArray n;
    private final LinearLayout k;
    private long l;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        m = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(10);
        String[] stringArray = new String[]{"community_titlebar"};
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = n10;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558491;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        n = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131362023, 2);
        viewDataBinding$IncludedLayouts.put(2131362028, 3);
        viewDataBinding$IncludedLayouts.put(2131362029, 4);
        viewDataBinding$IncludedLayouts.put(2131362021, 5);
        viewDataBinding$IncludedLayouts.put(2131362025, 6);
        viewDataBinding$IncludedLayouts.put(2131362033, 7);
        viewDataBinding$IncludedLayouts.put(2131362022, 8);
        viewDataBinding$IncludedLayouts.put(2131362020, 9);
    }

    public d(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = m;
        SparseIntArray sparseIntArray = n;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 10, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private d(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[9];
        object2 = (Button)object;
        Object object3 = object = objectArray[5];
        object3 = (EditText)object;
        Object object4 = object = objectArray[8];
        object4 = (RecyclerView)object;
        Object object5 = object = objectArray[2];
        object5 = (ScrollView)object;
        Object object6 = object = objectArray[6];
        object6 = (TextView)object;
        Object object7 = object = objectArray[3];
        object7 = (TextView)object;
        Object object8 = object = objectArray[4];
        object8 = (TextView)object;
        Object object9 = object = objectArray[7];
        object9 = (TextView)object;
        Object object10 = object = objectArray[1];
        object10 = (v2)object;
        object = this;
        super(dataBindingComponent, view, 1, (Button)object2, (EditText)object3, (RecyclerView)object4, (ScrollView)object5, (TextView)object6, (TextView)object7, (TextView)object8, (TextView)object9, (v2)object10);
        this.l = -1;
        object = (LinearLayout)objectArray[0];
        this.k = object;
        object.setTag(null);
        object = this.i;
        this.setContainedBinding((ViewDataBinding)object);
        object = view;
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean A(v2 v22, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.l;
                long l11 = 1L;
                this.l = l10 |= l11;
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
        synchronized (this) {
            long l10;
            this.l = l10 = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.i);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.l;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            boolean bl2 = true;
            if (l12 != false) {
                return bl2;
            }
            v2 v22 = this.i;
            l12 = (long)v22.hasPendingBindings();
            if (l12 != false) {
                return bl2;
            }
            return false;
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
            this.l = l10 = (long)4;
        }
        this.i.invalidateAll();
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (v2)object;
        return this.A((v2)object, n11);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.i.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 152;
        if (n11 == n10) {
            object = (m)object;
            this.z((m)object);
            n10 = 1;
        } else {
            n10 = 0;
        }
        return n10 != 0;
    }

    public void z(m m10) {
        this.j = m10;
    }
}

