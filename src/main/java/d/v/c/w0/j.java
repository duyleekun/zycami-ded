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
import androidx.fragment.app.FragmentContainerView;
import androidx.lifecycle.LifecycleOwner;
import com.zhiyun.cama.help.EditorHelpActivity$a;
import d.v.c.w0.i;
import d.v.c.w0.ui;

public class j
extends i {
    private static final ViewDataBinding$IncludedLayouts f;
    private static final SparseIntArray g;
    private final ConstraintLayout d;
    private long e;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        f = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(3);
        String[] stringArray = new String[]{"widget_titlebar"};
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = n10;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558815;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        g = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131362512, 2);
    }

    public j(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = f;
        SparseIntArray sparseIntArray = g;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 3, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private j(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[2];
        object3 = (FragmentContainerView)((Object)object2);
        Object object4 = object2 = objectArray[1];
        object4 = (ui)object2;
        super(object, view, 1, (FragmentContainerView)((Object)object3), (ui)object4);
        this.e = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.d = object;
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
    private boolean A(ui ui2, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.e;
                long l11 = 1L;
                this.e = l10 |= l11;
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
            long l11 = this.e;
            this.e = l10 = 0L;
        }
        EditorHelpActivity$a editorHelpActivity$a = this.c;
        long l12 = 6;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            ui ui2 = this.b;
            ui2.z(editorHelpActivity$a);
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
            long l10 = this.e;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            boolean bl2 = true;
            if (l12 != false) {
                return bl2;
            }
            ui ui2 = this.b;
            l12 = (long)ui2.hasPendingBindings();
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
            this.e = l10 = (long)4;
        }
        this.b.invalidateAll();
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (ui)object;
        return this.A((ui)object, n11);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.b.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (EditorHelpActivity$a)object;
            this.z((EditorHelpActivity$a)object);
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
    public void z(EditorHelpActivity$a editorHelpActivity$a) {
        this.c = editorHelpActivity$a;
        synchronized (this) {
            long l10 = this.e;
            long l11 = 2;
            this.e = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }
}

