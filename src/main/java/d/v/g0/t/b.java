/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.g0.t;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.Converters;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.zhiyun.ui.R$color;
import com.zhiyun.ui.R$id;
import d.v.g0.h;
import d.v.g0.t.a;

public class b
extends a {
    private static final ViewDataBinding$IncludedLayouts i;
    private static final SparseIntArray j;
    private long h;

    static {
        SparseIntArray sparseIntArray;
        j = sparseIntArray = new SparseIntArray();
        int n10 = R$id.iv_left;
        sparseIntArray.put(n10, 2);
        n10 = R$id.iv_right;
        sparseIntArray.put(n10, 3);
        n10 = R$id.iv_right_2;
        sparseIntArray.put(n10, 4);
        n10 = R$id.tv_right;
        sparseIntArray.put(n10, 5);
    }

    public b(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = i;
        SparseIntArray sparseIntArray = j;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private b(DataBindingComponent dataBindingComponent, View view, Object[] object) {
        Object object2;
        Object object3 = object2 = object[2];
        object3 = (ImageView)object2;
        Object object4 = object2 = object[3];
        object4 = (ImageView)object2;
        Object object5 = object2 = object[4];
        object5 = (ImageView)object2;
        Object object6 = object2 = object[0];
        object6 = (LinearLayout)object2;
        Object object7 = object2 = object[5];
        object7 = (TextView)object2;
        object = object[1];
        TextView textView = object;
        textView = (TextView)object;
        super(dataBindingComponent, view, 0, (ImageView)object3, (ImageView)object4, (ImageView)object5, (LinearLayout)object6, (TextView)object7, textView);
        this.h = -1;
        this.d.setTag(null);
        this.f.setTag(null);
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
        long l12;
        synchronized (this) {
            l12 = this.h;
            this.h = l11 = 0L;
        }
        int n10 = this.g;
        long l13 = 3;
        long l14 = l12 & l13;
        long l15 = l14 == l11 ? 0 : (l14 < l11 ? -1 : 1);
        int n11 = 0;
        if (l15 != false) {
            TextView textView;
            if (l15 != false) {
                if (n10 != 0) {
                    l12 |= (long)8;
                    l14 = 32;
                } else {
                    l12 |= (long)4;
                    l14 = 16;
                }
                l12 |= l14;
            }
            LinearLayout linearLayout = this.d;
            n11 = n10 != 0 ? R$color.zyui_bg_1 : R$color.zyui_bg_5;
            l15 = ViewDataBinding.getColorFromResource((View)linearLayout, n11);
            n11 = (int)l15;
            if (n10 != 0) {
                textView = this.f;
                l15 = R$color.zyui_text_6;
            } else {
                textView = this.f;
                l15 = R$color.zyui_text_1;
            }
            n10 = ViewDataBinding.getColorFromResource((View)textView, (int)l15);
        } else {
            n10 = 0;
            Object var13_10 = null;
        }
        long l16 = (l10 = (l12 &= l13) - l11) == 0L ? 0 : (l10 < 0L ? -1 : 1);
        if (l16 != false) {
            LinearLayout linearLayout = this.d;
            ColorDrawable colorDrawable = Converters.convertColorToDrawable(n11);
            ViewBindingAdapter.setBackground((View)linearLayout, (Drawable)colorDrawable);
            linearLayout = this.f;
            linearLayout.setTextColor(n10);
        }
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
            this.h = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = d.v.g0.h.t0;
        if (n11 == n10) {
            object = (Boolean)object;
            n10 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
            this.z(n10 != 0);
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
    public void z(boolean bl2) {
        this.g = bl2;
        synchronized (this) {
            long l10 = this.h;
            long l11 = 1L;
            this.h = l10 |= l11;
        }
        bl2 = d.v.g0.h.t0;
        this.notifyPropertyChanged((int)(bl2 ? 1 : 0));
        super.requestRebind();
    }
}

