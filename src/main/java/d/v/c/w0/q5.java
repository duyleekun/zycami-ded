/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
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
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.device.active.ActivationViewModel;
import d.v.c.w0.p5;

public class q5
extends p5 {
    private static final ViewDataBinding$IncludedLayouts l;
    private static final SparseIntArray m;
    private final ConstraintLayout j;
    private long k;

    static {
        SparseIntArray sparseIntArray;
        m = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363353, 7);
        sparseIntArray.put(2131363348, 8);
    }

    public q5(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = l;
        SparseIntArray sparseIntArray = m;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 9, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private q5(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[1];
        object2 = (ImageView)object;
        Object object3 = object = objectArray[5];
        object3 = (ImageView)object;
        Object object4 = object = objectArray[3];
        object4 = (ImageView)object;
        Object object5 = object = objectArray[8];
        object5 = (TextView)object;
        Object object6 = object = objectArray[2];
        object6 = (TextView)object;
        Object object7 = object = objectArray[6];
        object7 = (TextView)object;
        Object object8 = object = objectArray[4];
        object8 = (TextView)object;
        Object object9 = object = objectArray[7];
        object9 = (TextView)object;
        object = this;
        super(dataBindingComponent, view, 1, (ImageView)object2, (ImageView)object3, (ImageView)object4, (TextView)object5, (TextView)object6, (TextView)object7, (TextView)object8, (TextView)object9);
        this.k = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.j = object;
        object.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        object = view;
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean A(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.k;
                long l11 = 1L;
                this.k = l10 |= l11;
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
        int n10;
        int n11;
        Drawable drawable2;
        long l11;
        long l12;
        synchronized (this) {
            l12 = this.k;
            this.k = l11 = 0L;
        }
        Object object = this.i;
        long l13 = 7;
        long l14 = l12 & l13;
        long l15 = l14 == l11 ? 0 : (l14 < l11 ? -1 : 1);
        int n12 = 0;
        Object object2 = null;
        int n13 = 0;
        if (l15 != false) {
            long l16;
            long l17;
            TextView textView;
            int n14;
            int n15;
            if (object != null) {
                object = ((ActivationViewModel)object).v();
            } else {
                n15 = 0;
                object = null;
            }
            this.updateLiveDataRegistration(0, (LiveData)object);
            if (object != null) {
                object2 = object = ((LiveData)object).getValue();
                object2 = (Integer)object;
            }
            if ((n15 = ViewDataBinding.safeUnbox(object2)) <= (n12 = 1)) {
                n14 = n12;
            } else {
                n14 = 0;
                textView = null;
            }
            int n16 = 3;
            if (n15 <= n16) {
                n16 = n12;
            } else {
                n16 = 0;
                drawable2 = null;
            }
            n11 = 2;
            if (n15 <= n11) {
                n13 = n12;
            }
            if (l15 != false) {
                if (n14 != 0) {
                    l12 |= (long)16;
                    l14 = 4096L;
                } else {
                    l12 |= (long)8;
                    l14 = 2048L;
                }
                l12 |= l14;
            }
            if ((n15 = (int)((l17 = (l14 = l12 & l13) - l11) == 0L ? 0 : (l17 < 0L ? -1 : 1))) != 0) {
                if (n16 != 0) {
                    l12 |= (long)64;
                    l14 = 1024L;
                } else {
                    l12 |= (long)32;
                    l14 = 512L;
                }
                l12 |= l14;
            }
            if ((n15 = (int)((l16 = (l14 = l12 & l13) - l11) == 0L ? 0 : (l16 < 0L ? -1 : 1))) != 0) {
                if (n13 != 0) {
                    l12 |= 0x100L;
                    l14 = 16384L;
                } else {
                    l12 |= 0x80L;
                    l14 = 8192L;
                }
                l12 |= l14;
            }
            n15 = 2131231602;
            l15 = 2131231603;
            object2 = this.a.getContext();
            object2 = n14 != 0 ? AppCompatResources.getDrawable((Context)object2, n15) : AppCompatResources.getDrawable((Context)object2, (int)l15);
            n11 = 2131099743;
            int n17 = 2131099756;
            if (n14 != 0) {
                textView = this.e;
                n14 = ViewDataBinding.getColorFromResource((View)textView, n11);
            } else {
                textView = this.e;
                n14 = ViewDataBinding.getColorFromResource((View)textView, n17);
            }
            TextView textView2 = this.f;
            n10 = n16 != 0 ? ViewDataBinding.getColorFromResource((View)textView2, n11) : ViewDataBinding.getColorFromResource((View)textView2, n17);
            drawable2 = n16 != 0 ? AppCompatResources.getDrawable(this.b.getContext(), n15) : AppCompatResources.getDrawable(this.b.getContext(), (int)l15);
            if (n13 != 0) {
                TextView textView3 = this.g;
                n11 = ViewDataBinding.getColorFromResource((View)textView3, n11);
            } else {
                TextView textView4 = this.g;
                n11 = ViewDataBinding.getColorFromResource((View)textView4, n17);
            }
            if (n13 != 0) {
                Context context = this.c.getContext();
                object = AppCompatResources.getDrawable(context, n15);
            } else {
                object = AppCompatResources.getDrawable(this.c.getContext(), (int)l15);
            }
            n13 = n14;
        } else {
            boolean bl2 = false;
            object = null;
            boolean bl3 = false;
            drawable2 = null;
            n11 = 0;
            Object var24_24 = null;
            n10 = 0;
            Object var21_20 = null;
        }
        long l18 = (l10 = (l12 &= l13) - l11) == 0L ? 0 : (l10 < 0L ? -1 : 1);
        if (l18 != false) {
            ImageViewBindingAdapter.setImageDrawable(this.a, (Drawable)object2);
            ImageViewBindingAdapter.setImageDrawable(this.b, drawable2);
            ImageViewBindingAdapter.setImageDrawable(this.c, (Drawable)object);
            this.e.setTextColor(n13);
            this.f.setTextColor(n10);
            TextView textView = this.g;
            textView.setTextColor(n11);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.k;
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
            this.k = l10 = (long)4;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (MutableLiveData)object;
        return this.A((MutableLiveData)object, n11);
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 152;
        if (n11 == n10) {
            object = (ActivationViewModel)object;
            this.z((ActivationViewModel)object);
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
    public void z(ActivationViewModel activationViewModel) {
        this.i = activationViewModel;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 2;
            this.k = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }
}

