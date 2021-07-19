/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.animation.Animation
 *  android.view.animation.AnimationUtils
 *  android.widget.EditText
 *  android.widget.HorizontalScrollView
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.data.PagingRequestHelper$Status;
import d.v.c.n1.i2$b;
import d.v.c.n1.j2;
import d.v.c.w0.ig;
import d.v.c.w0.jg$a;
import d.v.c.w0.jg$b;
import d.v.f.e.c;

public class jg
extends ig {
    private static final ViewDataBinding$IncludedLayouts p;
    private static final SparseIntArray q;
    private final ConstraintLayout l;
    private jg$b m;
    private jg$a n;
    private long o;

    static {
        SparseIntArray sparseIntArray;
        q = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362369, 6);
        sparseIntArray.put(2131362833, 7);
        sparseIntArray.put(2131363596, 8);
        sparseIntArray.put(2131363469, 9);
    }

    public jg(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = p;
        SparseIntArray sparseIntArray = q;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 10, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private jg(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[6];
        object2 = (EditText)object;
        Object object3 = object = objectArray[4];
        object3 = (ImageView)object;
        Object object4 = object = objectArray[3];
        object4 = (LinearLayout)object;
        Object object5 = object = objectArray[7];
        object5 = (LinearLayout)object;
        Object object6 = object = objectArray[2];
        object6 = (HorizontalScrollView)object;
        Object object7 = object = objectArray[1];
        object7 = (TextView)object;
        Object object8 = object = objectArray[5];
        object8 = (TextView)object;
        Object object9 = object = objectArray[9];
        object9 = (TextView)object;
        Object object10 = object = objectArray[8];
        object10 = (TextView)object;
        object = this;
        super(dataBindingComponent, view, 1, (EditText)object2, (ImageView)object3, (LinearLayout)object4, (LinearLayout)object5, (HorizontalScrollView)object6, (TextView)object7, (TextView)object8, (TextView)object9, (TextView)object10);
        this.o = -1;
        this.b.setTag(null);
        this.c.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.l = object;
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
    private boolean C(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.o;
                long l11 = 1L;
                this.o = l10 |= l11;
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
    public void A(i2$b i2$b) {
        this.j = i2$b;
        synchronized (this) {
            long l10 = this.o;
            long l11 = 2;
            this.o = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(j2 j22) {
        this.k = j22;
        synchronized (this) {
            long l10 = this.o;
            long l11 = 4;
            this.o = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
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
        long l12;
        PagingRequestHelper$Status pagingRequestHelper$Status;
        int n10;
        jg$a jg$a;
        jg$b jg$b;
        long l13;
        long l14;
        jg jg2 = this;
        synchronized (this) {
            l14 = this.o;
            this.o = l13 = 0L;
        }
        Object object = this.j;
        Object object2 = this.k;
        long l15 = 10;
        long l16 = l14 & l15;
        long l17 = l16 == l13 ? 0 : (l16 < l13 ? -1 : 1);
        if (l17 != false && object != null) {
            jg$b = this.m;
            if (jg$b == null) {
                this.m = jg$b = new jg$b();
            }
            jg$b = jg$b.b((i2$b)object);
            jg$a = jg2.n;
            if (jg$a == null) {
                jg2.n = jg$a = new jg$a();
            }
            object = jg$a.b((i2$b)object);
        } else {
            object = null;
            l17 = 0;
            jg$b = null;
        }
        long l18 = 13;
        long l19 = l14 & l18;
        long l20 = l19 == l13 ? 0 : (l19 < l13 ? -1 : 1);
        int n11 = 0;
        PagingRequestHelper$Status pagingRequestHelper$Status2 = null;
        if (l20 != false) {
            PagingRequestHelper$Status pagingRequestHelper$Status3;
            long l21;
            long l22;
            float f10;
            int n12;
            int n13;
            float f11;
            if (object2 != null) {
                object2 = ((j2)object2).w();
            } else {
                n10 = 0;
                f11 = 0.0f;
                object2 = null;
            }
            jg2.updateLiveDataRegistration(0, (LiveData)object2);
            if (object2 != null) {
                object2 = (PagingRequestHelper$Status)((Object)((LiveData)object2).getValue());
            } else {
                n10 = 0;
                f11 = 0.0f;
                object2 = null;
            }
            PagingRequestHelper$Status pagingRequestHelper$Status4 = PagingRequestHelper$Status.FAILED;
            int n14 = 1;
            float f12 = Float.MIN_VALUE;
            if (pagingRequestHelper$Status4 == object2) {
                n13 = n14;
            } else {
                n13 = 0;
                pagingRequestHelper$Status4 = null;
            }
            pagingRequestHelper$Status = PagingRequestHelper$Status.SUCCESS;
            if (pagingRequestHelper$Status == object2) {
                n12 = n14;
                f10 = f12;
            } else {
                n12 = 0;
                pagingRequestHelper$Status = null;
                f10 = 0.0f;
            }
            pagingRequestHelper$Status2 = PagingRequestHelper$Status.RUNNING;
            if (pagingRequestHelper$Status2 != object2) {
                n14 = 0;
                f12 = 0.0f;
            }
            if (l20 != false) {
                l19 = n13 != 0 ? 512L : 256L;
                l14 |= l19;
            }
            if ((n10 = (int)((l22 = (l19 = l14 & l18) - l13) == 0L ? 0 : (l22 < 0L ? -1 : 1))) != 0) {
                l19 = n12 != 0 ? (long)32 : (long)16;
                l14 |= l19;
            }
            if ((n10 = (int)((l21 = (l19 = l14 & l18) - l13) == 0L ? 0 : (l21 < 0L ? -1 : 1))) != 0) {
                if (n14 != 0) {
                    l14 |= 0x80L;
                    l19 = 2048L;
                } else {
                    l14 |= (long)64;
                    l19 = 1024L;
                }
                l14 |= l19;
            }
            n10 = 8;
            f11 = 1.1E-44f;
            l20 = n13 != 0 ? (long)0 : (long)n10;
            if (n12 != 0) {
                n12 = 0;
                f10 = 0.0f;
                pagingRequestHelper$Status = null;
            } else {
                n12 = n10;
                f10 = f11;
            }
            if (n14 != 0) {
                pagingRequestHelper$Status2 = this.getRoot().getContext();
                n13 = 2130771985;
                pagingRequestHelper$Status3 = pagingRequestHelper$Status2 = AnimationUtils.loadAnimation((Context)pagingRequestHelper$Status2, (int)n13);
            } else {
                pagingRequestHelper$Status3 = null;
            }
            if (n14 != 0) {
                n11 = 0;
                pagingRequestHelper$Status2 = null;
            } else {
                n11 = n10;
            }
            n10 = n12;
            f11 = f10;
            pagingRequestHelper$Status = pagingRequestHelper$Status3;
        } else {
            n10 = 0;
            float f13 = 0.0f;
            object2 = null;
            boolean bl2 = false;
            float f14 = 0.0f;
            pagingRequestHelper$Status = null;
            l20 = 0;
            n11 = 0;
            pagingRequestHelper$Status2 = null;
        }
        long l23 = (l12 = (l18 &= l14) - l13) == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (l23 != false) {
            jg$a = jg2.b;
            d.v.f.e.c.b((View)jg$a, (Animation)pagingRequestHelper$Status);
            jg2.c.setVisibility(n11);
            pagingRequestHelper$Status = jg2.e;
            pagingRequestHelper$Status.setVisibility(n10);
            object2 = jg2.g;
            object2.setVisibility((int)l20);
        }
        if ((l11 = (l10 = (l14 &= l15) - l13) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            TextView textView = jg2.f;
            textView.setOnClickListener((View.OnClickListener)object);
            object = jg2.g;
            object.setOnClickListener((View.OnClickListener)jg$b);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.o;
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
            this.o = l10 = (long)8;
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
        int n11 = 23;
        if (n11 == n10) {
            object = (i2$b)object;
            this.A((i2$b)object);
            return 1 != 0;
        } else {
            n11 = 152;
            if (n11 != n10) return 0 != 0;
            object = (j2)object;
            this.B((j2)object);
        }
        return 1 != 0;
    }
}

