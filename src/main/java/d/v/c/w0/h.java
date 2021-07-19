/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.FrameLayout
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LifecycleOwner;
import com.zhiyun.cama.mediacontent.media.EditorAddVideoActivity$b;
import d.v.c.w0.g;
import d.v.c.w0.wi;

public class h
extends g {
    private static final ViewDataBinding$IncludedLayouts g;
    private static final SparseIntArray h;
    private final ConstraintLayout e;
    private long f;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        g = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(3);
        String[] stringArray = new String[]{"widget_titlebar_no_button"};
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = n10;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558817;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        h = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131362795, 2);
    }

    public h(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = g;
        SparseIntArray sparseIntArray = h;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 3, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private h(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[2];
        object3 = (FrameLayout)object2;
        Object object4 = object2 = objectArray[1];
        object4 = (wi)object2;
        super(object, view, 1, (FrameLayout)object3, (wi)object4);
        this.f = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.e = object;
        object.setTag(null);
        object = this.b;
        this.setContainedBinding((ViewDataBinding)object);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(wi wi2, int n10) {
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
    public void A(EditorAddVideoActivity$b editorAddVideoActivity$b) {
        this.c = editorAddVideoActivity$b;
        synchronized (this) {
            long l10 = this.f;
            long l11 = 4;
            this.f = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(Boolean bl2) {
        this.d = bl2;
        synchronized (this) {
            long l10 = this.f;
            long l11 = 2;
            this.f = l10 |= l11;
        }
        this.notifyPropertyChanged(66);
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
        int n10;
        long l11;
        long l12;
        synchronized (this) {
            l12 = this.f;
            this.f = l11 = 0L;
        }
        Boolean bl2 = this.d;
        EditorAddVideoActivity$b editorAddVideoActivity$b = this.c;
        long l13 = 10;
        long l14 = l12 & l13;
        long l15 = l14 == l11 ? 0 : (l14 < l11 ? -1 : 1);
        int n11 = 0;
        if (l15 != false) {
            n10 = ViewDataBinding.safeUnbox(bl2);
            if (l15 != false) {
                l10 = n10 != 0 ? (long)32 : (long)16;
                l12 |= l10;
            }
            if (n10 != 0) {
                n11 = n10 = 8;
            }
        }
        l10 = (long)12 & l12;
        n10 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
        long l16 = (l12 &= l13) - l11;
        Object object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object2 != false) {
            object = this.b.getRoot();
            object.setVisibility(n11);
        }
        if (n10 != 0) {
            object = this.b;
            ((wi)object).z(editorAddVideoActivity$b);
        }
        ViewDataBinding.executeBindingsOn(this.b);
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
            boolean bl2 = true;
            if (l12 != false) {
                return bl2;
            }
            wi wi2 = this.b;
            l12 = (long)wi2.hasPendingBindings();
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
            this.f = l10 = (long)8;
        }
        this.b.invalidateAll();
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (wi)object;
        return this.C((wi)object, n11);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.b.setLifecycleOwner(lifecycleOwner);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 66;
        if (n11 == n10) {
            object = (Boolean)object;
            this.B((Boolean)object);
            return 1 != 0;
        } else {
            n11 = 25;
            if (n11 != n10) return 0 != 0;
            object = (EditorAddVideoActivity$b)object;
            this.A((EditorAddVideoActivity$b)object);
        }
        return 1 != 0;
    }
}

