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
import d.v.c.w0.gi;
import d.v.f.e.c;
import d.v.f.f.d;

public class hi
extends gi {
    private static final ViewDataBinding$IncludedLayouts g;
    private static final SparseIntArray h;
    private long f;

    public hi(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = g;
        SparseIntArray sparseIntArray = h;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private hi(DataBindingComponent dataBindingComponent, View view, Object[] object) {
        Object object2;
        Object object3 = object2 = object[0];
        object3 = (ConstraintLayout)((Object)object2);
        Object object4 = object2 = object[1];
        object4 = (TextView)object2;
        Object object5 = object2 = object[3];
        object5 = (TextView)object2;
        object = object[2];
        TextView textView = object;
        textView = (TextView)object;
        super(dataBindingComponent, view, 0, (ConstraintLayout)((Object)object3), (TextView)object4, (TextView)object5, textView);
        this.f = -1;
        this.a.setTag(null);
        this.b.setTag(null);
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
        d d10;
        d d11;
        long l10;
        synchronized (this) {
            long l11 = this.f;
            this.f = l10 = 0L;
        }
        EditorTemplateEditActivity$e editorTemplateEditActivity$e = this.e;
        long l12 = 3;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        int n10 = 0;
        d d12 = null;
        if (l14 != false && editorTemplateEditActivity$e != null) {
            n10 = 1;
            d12 = editorTemplateEditActivity$e.e(n10);
            d11 = editorTemplateEditActivity$e.e(0);
            int n11 = 2;
            d10 = editorTemplateEditActivity$e.e(n11);
            d d13 = d11;
            d11 = d12;
            d12 = d13;
        } else {
            d11 = null;
            boolean bl2 = false;
            d10 = null;
        }
        if (l14 != false) {
            d.v.f.e.c.f((View)this.b, d12);
            d.v.f.e.c.f((View)this.c, d10);
            TextView textView = this.d;
            d.v.f.e.c.f((View)textView, d11);
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
            this.f = l10 = (long)2;
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
        this.e = editorTemplateEditActivity$e;
        synchronized (this) {
            long l10 = this.f;
            long l11 = 1L;
            this.f = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }
}

