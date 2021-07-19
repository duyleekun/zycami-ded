/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.g0.t;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.zhiyun.ui.R$color;
import com.zhiyun.ui.R$drawable;
import d.v.g0.h;
import d.v.g0.i$a;
import d.v.g0.t.c;
import d.v.g0.u.a.b$a;

public class d
extends c
implements b$a {
    private static final ViewDataBinding$IncludedLayouts h;
    private static final SparseIntArray i;
    private final ConstraintLayout e;
    private final View.OnClickListener f;
    private long g;

    public d(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = h;
        SparseIntArray sparseIntArray = i;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 3, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private d(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        int n10 = 1;
        Object object3 = object2 = objectArray[n10];
        object3 = (LinearLayout)object2;
        Object object4 = object2 = objectArray[2];
        object4 = (TextView)object2;
        super(object, view, 0, (LinearLayout)object3, (TextView)object4);
        this.g = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.e = object;
        object.setTag(null);
        this.b.setTag(null);
        this.setRootTag(view);
        super(this, n10);
        this.f = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void A(i$a i$a) {
        this.c = i$a;
        synchronized (this) {
            long l10 = this.g;
            long l11 = 1L;
            this.g = l10 |= l11;
        }
        int n10 = d.v.g0.h.z;
        this.notifyPropertyChanged(n10);
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
            long l10 = this.g;
            long l11 = 2;
            this.g = l10 |= l11;
        }
        int n10 = d.v.g0.h.H;
        this.notifyPropertyChanged(n10);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        i$a i$a = this.c;
        boolean bl2 = i$a != null;
        if (bl2) {
            i$a.b();
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
        Context context;
        long l14;
        long l15;
        synchronized (this) {
            l15 = this.g;
            this.g = l14 = 0L;
        }
        int n10 = 0;
        LinearLayout linearLayout = null;
        Boolean bl2 = this.d;
        long l16 = 6;
        long l17 = l15 & l16;
        long l18 = l17 == l14 ? 0 : (l17 < l14 ? -1 : 1);
        int n11 = 0;
        Drawable drawable2 = null;
        if (l18 != false) {
            n10 = ViewDataBinding.safeUnbox(bl2);
            if (l18 != false) {
                if (n10 != 0) {
                    l15 = l15 | (long)16 | (long)64 | 0x100L;
                    l17 = 1024L;
                } else {
                    l15 = l15 | (long)8 | (long)32 | 0x80L;
                    l17 = 512L;
                }
                l15 |= l17;
            }
            bl2 = this.b;
            l18 = n10 != 0 ? (long)R$color.zyui_colour_9 : (long)R$color.zyui_colour_6;
            int n12 = ViewDataBinding.getColorFromResource((View)bl2, (int)l18);
            context = this.a.getContext();
            n11 = n10 != 0 ? R$drawable.shape_dark_divider : R$drawable.shape_divider;
            drawable2 = AppCompatResources.getDrawable(context, n11);
            context = this.b.getContext();
            int n13 = n10 != 0 ? R$drawable.com_bottom_dialog_list_dark_bg : R$drawable.com_bottom_dialog_list_bg;
            context = AppCompatResources.getDrawable(context, n13);
            if (n10 != 0) {
                linearLayout = this.a.getContext();
                n13 = R$drawable.com_bottom_dialog_list_dark_bg;
            } else {
                linearLayout = this.a.getContext();
                n13 = R$drawable.com_bottom_dialog_list_bg;
            }
            linearLayout = AppCompatResources.getDrawable((Context)linearLayout, n13);
            Drawable drawable3 = drawable2;
            drawable2 = linearLayout;
            n10 = n12;
            bl2 = drawable3;
        } else {
            boolean bl3 = false;
            bl2 = null;
            l18 = 0;
            context = null;
        }
        long l19 = (l13 = (l16 &= l15) - l14) == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l19 != false) {
            ViewBindingAdapter.setBackground((View)this.a, drawable2);
            ViewBindingAdapter.setBackground((View)this.b, (Drawable)context);
            TextView textView = this.b;
            textView.setTextColor(n10);
            n10 = ViewDataBinding.getBuildSdkInt();
            l19 = 11;
            if (n10 >= l19) {
                linearLayout = this.a;
                linearLayout.setDividerDrawable((Drawable)bl2);
            }
        }
        if ((l12 = (l11 = (l15 &= (l10 = (long)4)) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            TextView textView = this.b;
            View.OnClickListener onClickListener = this.f;
            textView.setOnClickListener(onClickListener);
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
            this.g = l10 = (long)4;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = d.v.g0.h.z;
        if (n11 == n10) {
            object = (i$a)object;
            this.A((i$a)object);
            return 1 != 0;
        } else {
            n11 = d.v.g0.h.H;
            if (n11 != n10) return 0 != 0;
            object = (Boolean)object;
            this.B((Boolean)object);
        }
        return 1 != 0;
    }
}

