/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

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
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.s0.a7.c1$b;
import d.v.c.s0.s6;
import d.v.c.w0.b1;
import l.a.q.g0.u;

public class c1
extends b1
implements b$a {
    private static final ViewDataBinding$IncludedLayouts n;
    private static final SparseIntArray o;
    private final ConstraintLayout k;
    private final View.OnClickListener l;
    private long m;

    static {
        SparseIntArray sparseIntArray;
        o = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363466, 6);
        sparseIntArray.put(2131363742, 7);
        sparseIntArray.put(2131363741, 8);
    }

    public c1(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = n;
        SparseIntArray sparseIntArray = o;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 9, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private c1(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        int n10 = 1;
        Object object2 = object = objectArray[n10];
        object2 = (ImageView)object;
        Object object3 = object = objectArray[4];
        object3 = (ImageView)object;
        Object object4 = object = objectArray[5];
        object4 = (ImageView)object;
        Object object5 = object = objectArray[3];
        object5 = (TextView)object;
        Object object6 = object = objectArray[2];
        object6 = (TextView)object;
        Object object7 = object = objectArray[6];
        object7 = (TextView)object;
        Object object8 = object = objectArray[8];
        object8 = (ViewPager2)((Object)object);
        Object object9 = object = objectArray[7];
        object9 = (ViewPager2)((Object)object);
        object = this;
        super(dataBindingComponent, view, 1, (ImageView)object2, (ImageView)object3, (ImageView)object4, (TextView)object5, (TextView)object6, (TextView)object7, (ViewPager2)((Object)object8), (ViewPager2)((Object)object9));
        this.m = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.k = object;
        object.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, n10);
        this.l = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.m;
                long l11 = 1L;
                this.m = l10 |= l11;
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
    public void A(s6 s62) {
        this.j = s62;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 2;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(14);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(c1$b c1$b) {
        this.i = c1$b;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 4;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        c1$b c1$b = this.i;
        boolean bl2 = c1$b != null;
        if (bl2) {
            c1$b.a();
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
        String string2;
        long l12;
        Drawable drawable2;
        long l13;
        Drawable drawable3;
        long l14;
        long l15;
        synchronized (this) {
            l15 = this.m;
            this.m = l14 = 0L;
        }
        Object object = this.j;
        long l16 = 11;
        long l17 = l15 & l16;
        long l18 = l17 == l14 ? 0 : (l17 < l14 ? -1 : 1);
        if (l18 != false) {
            long l19;
            long l20;
            int n10;
            if (object != null) {
                object = ((s6)object).l();
            } else {
                n10 = 0;
                object = null;
            }
            boolean bl2 = false;
            drawable3 = null;
            this.updateLiveDataRegistration(0, (LiveData)object);
            if (object != null) {
                object = (Integer)((LiveData)object).getValue();
            } else {
                n10 = 0;
                object = null;
            }
            n10 = ViewDataBinding.safeUnbox((Integer)object);
            l13 = 1;
            if (n10 == 0) {
                l20 = l13;
            } else {
                l20 = 0;
                drawable2 = null;
            }
            if (n10 == l13) {
                bl2 = l13;
            }
            if (l18 != false) {
                if (l20 != false) {
                    l15 = l15 | (long)32 | 0x80L;
                    l12 = 512L;
                } else {
                    l15 = l15 | (long)16 | (long)64;
                    l12 = 256L;
                }
                l15 |= l12;
            }
            if ((n10 = (int)((l19 = (l12 = l15 & l16) - l14) == 0L ? 0 : (l19 < 0L ? -1 : 1))) != 0) {
                l12 = bl2 ? 2048L : 1024L;
                l15 |= l12;
            }
            object = l20 != false ? "@string/hitchcock_stay_away_preview" : "@string/hitchcock_stay_away_help";
            string2 = l20 != false ? "@string/hitchcock_close_to_preview" : "@string/hitchcock_close_to_help_video";
            l13 = 2131232197;
            int n11 = 2131232068;
            drawable2 = l20 != false ? AppCompatResources.getDrawable(this.b.getContext(), (int)l13) : AppCompatResources.getDrawable(this.b.getContext(), n11);
            drawable3 = bl2 ? AppCompatResources.getDrawable(this.c.getContext(), (int)l13) : AppCompatResources.getDrawable(this.c.getContext(), n11);
        } else {
            boolean bl3 = false;
            object = null;
            l18 = 0;
            string2 = null;
            boolean bl4 = false;
            drawable3 = null;
            boolean bl5 = false;
            drawable2 = null;
        }
        l12 = (long)8 & l15;
        l13 = l12 == l14 ? 0 : (l12 < l14 ? -1 : 1);
        if (l13 != false) {
            ImageView imageView = this.a;
            View.OnClickListener onClickListener = this.l;
            imageView.setOnClickListener(onClickListener);
        }
        if ((l11 = (l10 = (l15 &= l16) - l14) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            ImageViewBindingAdapter.setImageDrawable(this.b, drawable2);
            ViewBindingAdapter.setBackground((View)this.c, drawable3);
            u.n(this.d, string2, null, null);
            TextView textView = this.e;
            u.n(textView, (String)object, null, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.m;
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
            this.m = l10 = (long)8;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (MutableLiveData)object;
        return this.C((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 14;
        if (n11 == n10) {
            object = (s6)object;
            this.A((s6)object);
            return 1 != 0;
        } else {
            n11 = 23;
            if (n11 != n10) return 0 != 0;
            object = (c1$b)object;
            this.B((c1$b)object);
        }
        return 1 != 0;
    }
}

