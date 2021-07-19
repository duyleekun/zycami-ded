/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
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
import androidx.viewpager2.widget.ViewPager2;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.s0.a7.h1$b;
import d.v.c.s0.s6;
import d.v.c.w0.n1;
import l.a.q.g0.u;

public class o1
extends n1
implements b$a {
    private static final ViewDataBinding$IncludedLayouts m;
    private static final SparseIntArray n;
    private final ConstraintLayout j;
    private final View.OnClickListener k;
    private long l;

    static {
        SparseIntArray sparseIntArray;
        n = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363530, 5);
        sparseIntArray.put(2131363745, 6);
        sparseIntArray.put(2131363744, 7);
    }

    public o1(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = m;
        SparseIntArray sparseIntArray = n;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 8, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private o1(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        int n10 = 1;
        Object object2 = object = objectArray[n10];
        object2 = (ImageView)object;
        Object object3 = object = objectArray[3];
        object3 = (ImageView)object;
        Object object4 = object = objectArray[4];
        object4 = (ImageView)object;
        Object object5 = object = objectArray[2];
        object5 = (TextView)object;
        Object object6 = object = objectArray[5];
        object6 = (TextView)object;
        Object object7 = object = objectArray[7];
        object7 = (ViewPager2)((Object)object);
        Object object8 = object = objectArray[6];
        object8 = (ViewPager2)((Object)object);
        object = this;
        super(dataBindingComponent, view, 1, (ImageView)object2, (ImageView)object3, (ImageView)object4, (TextView)object5, (TextView)object6, (ViewPager2)((Object)object7), (ViewPager2)((Object)object8));
        this.l = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.j = object;
        object.setTag(null);
        this.d.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, n10);
        this.k = object;
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
                long l10 = this.l;
                long l11 = 1L;
                this.l = l10 |= l11;
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
        this.i = s62;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 2;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(14);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(h1$b h1$b) {
        this.h = h1$b;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 4;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        h1$b h1$b = this.h;
        boolean bl2 = h1$b != null;
        if (bl2) {
            h1$b.a();
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
        ImageView imageView;
        Context context;
        long l12;
        String string2;
        View.OnClickListener onClickListener;
        long l13;
        long l14;
        synchronized (this) {
            l14 = this.l;
            this.l = l13 = 0L;
        }
        Object object = this.i;
        long l15 = 11;
        long l16 = l14 & l15;
        long l17 = l16 == l13 ? 0 : (l16 < l13 ? -1 : 1);
        if (l17 != false) {
            long l18;
            int n10;
            int n11;
            if (object != null) {
                object = ((s6)object).j();
            } else {
                n11 = 0;
                object = null;
            }
            int n12 = 0;
            onClickListener = null;
            this.updateLiveDataRegistration(0, (LiveData)object);
            if (object != null) {
                object = (Integer)((LiveData)object).getValue();
            } else {
                n11 = 0;
                object = null;
            }
            n11 = ViewDataBinding.safeUnbox((Integer)object);
            int n13 = 1;
            if (n11 == n13) {
                n10 = n13;
            } else {
                n10 = 0;
                string2 = null;
            }
            if (n11 == 0) {
                n12 = n13;
            }
            if (l17 != false) {
                l12 = n10 != 0 ? 512L : 256L;
                l14 |= l12;
            }
            if ((n11 = (int)((l18 = (l12 = l14 & l15) - l13) == 0L ? 0 : (l18 < 0L ? -1 : 1))) != 0) {
                if (n12 != 0) {
                    l14 |= (long)32;
                    l12 = 128L;
                } else {
                    l14 |= (long)16;
                    l12 = 64;
                }
                l14 |= l12;
            }
            n11 = 2131232197;
            l17 = 2131232068;
            context = this.c.getContext();
            context = n10 != 0 ? AppCompatResources.getDrawable(context, n11) : AppCompatResources.getDrawable(context, (int)l17);
            string2 = n12 != 0 ? "@string/photo_preview" : "@string/how_to_make_panorama_clone_photo";
            if (n12 != 0) {
                imageView = this.b.getContext();
                object = AppCompatResources.getDrawable((Context)imageView, n11);
            } else {
                object = AppCompatResources.getDrawable(this.b.getContext(), (int)l17);
            }
        } else {
            boolean bl2 = false;
            object = null;
            boolean bl3 = false;
            context = null;
            boolean bl4 = false;
            string2 = null;
        }
        l12 = (long)8 & l14;
        l17 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (l17 != false) {
            imageView = this.a;
            onClickListener = this.k;
            imageView.setOnClickListener(onClickListener);
        }
        if ((l11 = (l10 = (l14 &= l15) - l13) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            ImageViewBindingAdapter.setImageDrawable(this.b, (Drawable)object);
            ImageViewBindingAdapter.setImageDrawable(this.c, context);
            TextView textView = this.d;
            u.n(textView, string2, null, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.l;
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
            this.l = l10 = (long)8;
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
            object = (h1$b)object;
            this.B((h1$b)object);
        }
        return 1 != 0;
    }
}

