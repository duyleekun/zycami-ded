/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.a.g;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.Converters;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.account.R$color;
import com.zhiyun.account.R$drawable;
import com.zhiyun.account.R$id;
import com.zhiyun.account.me.account.widget.SideBar;
import com.zhiyun.account.me.country.CountryChooseActivity$b;
import d.v.a.d;
import d.v.a.g.o;
import d.v.a.g.p$a;

public class p
extends o {
    private static final ViewDataBinding$IncludedLayouts j;
    private static final SparseIntArray k;
    private final ConstraintLayout g;
    private p$a h;
    private long i;

    static {
        SparseIntArray sparseIntArray;
        k = sparseIntArray = new SparseIntArray();
        int n10 = R$id.rv_country;
        sparseIntArray.put(n10, 3);
        n10 = R$id.sb_indicator;
        sparseIntArray.put(n10, 4);
    }

    public p(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = j;
        SparseIntArray sparseIntArray = k;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 5, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private p(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[1];
        object3 = (ImageView)object2;
        Object object4 = object2 = objectArray[3];
        object4 = (RecyclerView)object2;
        Object object5 = object2 = objectArray[4];
        object5 = (SideBar)((Object)object2);
        Object object6 = object2 = objectArray[2];
        object6 = (TextView)object2;
        super(object, view, 0, (ImageView)object3, (RecyclerView)object4, (SideBar)((Object)object5), (TextView)object6);
        this.i = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.g = object;
        object.setTag(null);
        this.d.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void A(CountryChooseActivity$b countryChooseActivity$b) {
        this.e = countryChooseActivity$b;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 2;
            this.i = l10 |= l11;
        }
        int n10 = d.v.a.d.x;
        this.notifyPropertyChanged(n10);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(boolean bl2) {
        this.f = bl2;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 1L;
            this.i = l10 |= l11;
        }
        bl2 = d.v.a.d.u0;
        this.notifyPropertyChanged((int)(bl2 ? 1 : 0));
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        long l10;
        long l11;
        Context context;
        long l12;
        long l13;
        long l14;
        synchronized (this) {
            l14 = this.i;
            this.i = l13 = 0L;
        }
        boolean bl2 = this.f;
        CountryChooseActivity$b countryChooseActivity$b = this.e;
        long l15 = 5;
        long l16 = l14 & l15;
        long l17 = l16 == l13 ? 0 : (l16 < l13 ? -1 : 1);
        p$a p$a = null;
        int n10 = 0;
        if (l17 != false) {
            if (l17 != false) {
                long l18;
                if (bl2) {
                    l14 = l14 | (long)16 | (long)64;
                    l18 = 256L;
                } else {
                    l14 = l14 | (long)8 | (long)32;
                    l18 = 128L;
                }
                l14 |= l18;
            }
            Object object = this.d;
            n10 = bl2 ? R$color.com_color_white : R$color.com_color_black;
            l17 = ViewDataBinding.getColorFromResource((View)object, n10);
            n10 = (int)l17;
            object = this.g;
            l12 = bl2 ? (long)R$color.com_color_black : (long)R$color.com_color_white;
            l17 = ViewDataBinding.getColorFromResource((View)object, (int)l12);
            if (bl2) {
                context = this.a.getContext();
                l12 = R$drawable.ic_zf_xj_back_white;
            } else {
                context = this.a.getContext();
                l12 = R$drawable.ic_zf_zhxt_return_black;
            }
            context = AppCompatResources.getDrawable(context, (int)l12);
        } else {
            bl2 = false;
            context = null;
            l17 = 0;
            Object var16_12 = null;
        }
        long l19 = (long)6 & l14;
        l12 = l19 == l13 ? 0 : (l19 < l13 ? -1 : 1);
        if (l12 != false && countryChooseActivity$b != null) {
            p$a = this.h;
            if (p$a == null) {
                this.h = p$a = new p$a();
            }
            p$a = p$a.b(countryChooseActivity$b);
        }
        if (l12 != false) {
            countryChooseActivity$b = this.a;
            countryChooseActivity$b.setOnClickListener(p$a);
        }
        if ((l11 = (l10 = (l14 &= l15) - l13) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            ImageViewBindingAdapter.setImageDrawable(this.a, (Drawable)context);
            ConstraintLayout constraintLayout = this.g;
            ColorDrawable colorDrawable = Converters.convertColorToDrawable((int)l17);
            ViewBindingAdapter.setBackground((View)constraintLayout, (Drawable)colorDrawable);
            constraintLayout = this.d;
            constraintLayout.setTextColor(n10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.i;
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
            this.i = l10 = (long)4;
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
        int n11 = d.v.a.d.u0;
        if (n11 == n10) {
            object = (Boolean)object;
            n10 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
            this.B(n10 != 0);
            return 1 != 0;
        } else {
            n11 = d.v.a.d.x;
            if (n11 != n10) return 0 != 0;
            object = (CountryChooseActivity$b)object;
            this.A((CountryChooseActivity$b)object);
        }
        return 1 != 0;
    }
}

