/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.zhiyun.cama.decoration.text.EditorTextMainFragment$a;
import d.v.c.w0.j4;
import d.v.c.w0.j8;
import d.v.c.x0.c.b;

public class k8
extends j8 {
    private static final ViewDataBinding$IncludedLayouts h;
    private static final SparseIntArray i;
    private final ConstraintLayout f;
    private long g;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        h = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(4);
        String[] stringArray = new String[]{"editor_bottom_choice_layout"};
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = n10;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558529;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        i = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131363708, 2);
        viewDataBinding$IncludedLayouts.put(2131363278, 3);
    }

    public k8(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = h;
        SparseIntArray sparseIntArray = i;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private k8(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[1];
        object3 = (j4)object2;
        Object object4 = object2 = objectArray[3];
        object4 = (TabLayout)((Object)object2);
        Object object5 = object2 = objectArray[2];
        object5 = (ViewPager)((Object)object2);
        super(object, view, 1, (j4)object3, (TabLayout)((Object)object4), (ViewPager)((Object)object5));
        this.g = -1;
        object = this.a;
        this.setContainedBinding((ViewDataBinding)object);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.f = object;
        object.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(j4 j42, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.g;
                long l11 = 1L;
                this.g = l10 |= l11;
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
    public void A(EditorTextMainFragment$a editorTextMainFragment$a) {
        this.e = editorTextMainFragment$a;
        synchronized (this) {
            long l10 = this.g;
            long l11 = 4;
            this.g = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    public void B(b b10) {
        this.d = b10;
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
        EditorTextMainFragment$a editorTextMainFragment$a = this.e;
        long l12 = 12;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            j4 j42 = this.a;
            j42.z(editorTextMainFragment$a);
        }
        ViewDataBinding.executeBindingsOn(this.a);
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
            boolean bl2 = true;
            if (l12 != false) {
                return bl2;
            }
            j4 j42 = this.a;
            l12 = (long)j42.hasPendingBindings();
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
            this.g = l10 = (long)8;
        }
        this.a.invalidateAll();
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (j4)object;
        return this.C((j4)object, n11);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.a.setLifecycleOwner(lifecycleOwner);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 138;
        if (n11 == n10) {
            object = (b)object;
            this.B((b)object);
            return 1 != 0;
        } else {
            n11 = 25;
            if (n11 != n10) return 0 != 0;
            object = (EditorTextMainFragment$a)object;
            this.A((EditorTextMainFragment$a)object);
        }
        return 1 != 0;
    }
}

