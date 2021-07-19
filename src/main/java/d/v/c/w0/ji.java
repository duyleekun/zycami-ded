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
import com.zhiyun.cama.template.edit.EditorTemplateEditActivity$e;
import d.v.c.w0.ii;
import d.v.f.e.c;
import d.v.f.f.d;

public class ji
extends ii {
    private static final ViewDataBinding$IncludedLayouts f;
    private static final SparseIntArray g;
    private long e;

    public ji(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = f;
        SparseIntArray sparseIntArray = g;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 3, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private ji(DataBindingComponent dataBindingComponent, View view, Object[] object) {
        Object object2;
        Object object3 = object2 = object[0];
        object3 = (ConstraintLayout)((Object)object2);
        Object object4 = object2 = object[2];
        object4 = (TextView)object2;
        object = object[1];
        TextView textView = object;
        textView = (TextView)object;
        super(dataBindingComponent, view, 0, (ConstraintLayout)((Object)object3), (TextView)object4, textView);
        this.e = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        d d10;
        long l10;
        synchronized (this) {
            long l11 = this.e;
            this.e = l10 = 0L;
        }
        EditorTemplateEditActivity$e editorTemplateEditActivity$e = this.d;
        long l12 = 3;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        int n10 = 0;
        d d11 = null;
        if (l14 != false && editorTemplateEditActivity$e != null) {
            n10 = 1;
            d11 = editorTemplateEditActivity$e.e(n10);
            int n11 = 2;
            d d12 = editorTemplateEditActivity$e.e(n11);
            d10 = d11;
            d11 = d12;
        } else {
            boolean bl2 = false;
            d10 = null;
        }
        if (l14 != false) {
            d.v.f.e.c.f((View)this.b, d11);
            TextView textView = this.c;
            d.v.f.e.c.f((View)textView, d10);
        }
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
            this.e = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (EditorTemplateEditActivity$e)object;
            this.z((EditorTemplateEditActivity$e)object);
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
    public void z(EditorTemplateEditActivity$e editorTemplateEditActivity$e) {
        this.d = editorTemplateEditActivity$e;
        synchronized (this) {
            long l10 = this.e;
            long l11 = 1L;
            this.e = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }
}

