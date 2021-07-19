/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.template.edit.EditorTemplateEndingFragment$b;
import d.v.c.d1.h;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.j4;
import d.v.c.w0.x8;

public class y8
extends x8
implements b$a {
    private static final ViewDataBinding$IncludedLayouts i;
    private static final SparseIntArray j;
    private final ConstraintLayout f;
    private final View.OnClickListener g;
    private long h;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        i = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(4);
        String[] stringArray = new String[]{"editor_bottom_choice_layout"};
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = 2;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558529;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        j = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131363072, 3);
    }

    public y8(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = i;
        SparseIntArray sparseIntArray = j;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private y8(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        Object object4 = object3 = objectArray[2];
        object4 = (j4)object3;
        Object object5 = object3 = objectArray[3];
        object5 = (RecyclerView)object3;
        int n10 = 1;
        Object object6 = object2 = objectArray[n10];
        object6 = (StatusView)((Object)object2);
        object2 = this;
        super(object, view, 1, (j4)object4, (RecyclerView)object5, (StatusView)((Object)object6));
        this.h = -1;
        object = this.a;
        this.setContainedBinding((ViewDataBinding)object);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.f = object;
        object.setTag(null);
        this.c.setTag(null);
        this.setRootTag(view);
        object = new b(this, n10);
        this.g = object;
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
                long l10 = this.h;
                long l11 = 1L;
                this.h = l10 |= l11;
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
    public void A(EditorTemplateEndingFragment$b editorTemplateEndingFragment$b) {
        this.e = editorTemplateEndingFragment$b;
        synchronized (this) {
            long l10 = this.h;
            long l11 = 2;
            this.h = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    public void B(h h10) {
        this.d = h10;
    }

    public final void a(int n10, View view) {
        EditorTemplateEndingFragment$b editorTemplateEndingFragment$b = this.e;
        boolean bl2 = editorTemplateEndingFragment$b != null;
        if (bl2) {
            editorTemplateEndingFragment$b.g();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        synchronized (this) {
            l14 = this.h;
            this.h = l13 = 0L;
        }
        EditorTemplateEndingFragment$b editorTemplateEndingFragment$b = this.e;
        long l15 = (long)10 & l14;
        long l16 = l15 == l13 ? 0 : (l15 < l13 ? -1 : 1);
        if (l16 != false) {
            j4 j42 = this.a;
            j42.z(editorTemplateEndingFragment$b);
        }
        if ((l12 = (l11 = (l14 &= (l10 = (long)8)) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            StatusView statusView = this.c;
            int n10 = ViewDataBinding.getColorFromResource((View)statusView, 2131099860);
            statusView.setBackgroundColor(n10);
            statusView = this.c;
            Context context = statusView.getContext();
            int n11 = 2131231805;
            context = AppCompatResources.getDrawable(context, n11);
            statusView.setErrorImage((Drawable)context);
            this.c.setErrorText("@string/request_error");
            statusView = this.c;
            context = this.g;
            statusView.setOnClickErrorListener((View.OnClickListener)context);
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
            long l10 = this.h;
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
            this.h = l10 = (long)8;
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
        int n11 = 25;
        if (n11 == n10) {
            object = (EditorTemplateEndingFragment$b)object;
            this.A((EditorTemplateEndingFragment$b)object);
            return 1 != 0;
        } else {
            n11 = 53;
            if (n11 != n10) return 0 != 0;
            object = (h)object;
            this.B((h)object);
        }
        return 1 != 0;
    }
}

