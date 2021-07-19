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
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.widget.ZYTextView;
import d.v.c.q0.f.a;
import d.v.c.w0.sf;
import d.v.c.w0.tf$a;
import d.v.c.w0.tf$b;
import d.v.e.l.l2;
import l.a.q.g0.u;

public class tf
extends sf {
    private static final ViewDataBinding$IncludedLayouts n;
    private static final SparseIntArray o;
    private final ConstraintLayout j;
    private tf$b k;
    private tf$a l;
    private long m;

    public tf(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = n;
        SparseIntArray sparseIntArray = o;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 5, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private tf(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[2];
        object3 = (ImageView)object2;
        Object object4 = object2 = objectArray[1];
        object4 = (ImageView)object2;
        Object object5 = object2 = objectArray[3];
        object5 = (ZYTextView)object2;
        Object object6 = object2 = objectArray[4];
        object6 = (ZYTextView)object2;
        super(object, view, 4, (ImageView)object3, (ImageView)object4, (ZYTextView)object5, (ZYTextView)object6);
        this.m = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.j = object;
        object.setTag(null);
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
    private boolean I(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.m;
                long l11 = 4;
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
    private boolean J(MutableLiveData mutableLiveData, int n10) {
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
    private boolean K(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.m;
                long l11 = 2;
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
    private boolean L(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.m;
                long l11 = 8;
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
    public void D(MutableLiveData mutableLiveData) {
        int n10 = 2;
        this.updateLiveDataRegistration(n10, mutableLiveData);
        this.h = mutableLiveData;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 4;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(19);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void E(MutableLiveData mutableLiveData) {
        this.updateLiveDataRegistration(0, mutableLiveData);
        this.g = mutableLiveData;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 1L;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(20);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void F(a a10) {
        this.i = a10;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 16;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void G(MutableLiveData mutableLiveData) {
        int n10 = 1;
        this.updateLiveDataRegistration(n10, mutableLiveData);
        this.e = mutableLiveData;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 2;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(31);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void H(MutableLiveData mutableLiveData) {
        int n10 = 3;
        this.updateLiveDataRegistration(n10, mutableLiveData);
        this.f = mutableLiveData;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 8;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(44);
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
        long l13;
        long l14;
        long l15;
        long l16;
        tf$b tf$b;
        Object object;
        boolean bl2;
        StringBuilder stringBuilder;
        long l17;
        Context context;
        boolean bl3;
        long l18;
        long l19;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        Object object6;
        long l20;
        long l21;
        tf tf2;
        block35: {
            long l22;
            block34: {
                block33: {
                    long l23;
                    tf2 = this;
                    synchronized (this) {
                        l21 = this.m;
                        this.m = l20 = 0L;
                    }
                    object6 = this.g;
                    object5 = this.e;
                    object4 = this.h;
                    object3 = this.i;
                    object2 = this.f;
                    l19 = 49;
                    long l24 = l21 & l19;
                    l22 = l24 == l20 ? 0 : (l24 < l20 ? -1 : 1);
                    l18 = 33;
                    if (l22 == false) break block33;
                    if (object6 != null) {
                        object6 = (Boolean)((LiveData)object6).getValue();
                    } else {
                        bl3 = false;
                        object6 = null;
                    }
                    bl3 = ViewDataBinding.safeUnbox((Boolean)object6);
                    long l25 = l21 & l18;
                    l22 = l25 == l20 ? 0 : (l25 < l20 ? -1 : 1);
                    if (l22 != false) {
                        l25 = bl3 ? 512L : 256L;
                        l21 |= l25;
                    }
                    if ((l22 = (l23 = (l25 = l21 & l18) - l20) == 0L ? 0 : (l23 < 0L ? -1 : 1)) == false) break block34;
                    context = tf2.b.getContext();
                    l17 = bl3 ? (long)2131231071 : (long)2131231038;
                    context = AppCompatResources.getDrawable(context, (int)l17);
                    break block35;
                }
                bl3 = false;
                object6 = null;
            }
            l22 = 0;
            context = null;
        }
        long l26 = 34;
        long l27 = l21 & l26;
        l17 = l27 == l20 ? 0 : (l27 < l20 ? -1 : 1);
        if (l17 != false) {
            object5 = object5 != null ? (Long)((LiveData)object5).getValue() : null;
            l27 = ViewDataBinding.safeUnbox((Long)object5);
            object5 = l2.e(l27);
            stringBuilder = new StringBuilder();
            stringBuilder.append((String)object5);
            stringBuilder.append(" / ");
            object5 = stringBuilder.toString();
        } else {
            object5 = null;
        }
        l27 = 52;
        long l28 = (l21 & l27) - l20;
        l17 = l28 == 0L ? 0 : (l28 < 0L ? -1 : 1);
        long l29 = 36;
        if (l17 != false) {
            long l30;
            if (object4 != null) {
                object4 = (Boolean)((LiveData)object4).getValue();
            } else {
                bl2 = false;
                object4 = null;
            }
            l17 = (long)ViewDataBinding.safeUnbox((Boolean)object4);
            long l31 = l21 & l29;
            bl2 = l31 == l20 ? 0 : (l31 < l20 ? -1 : 1);
            if (bl2) {
                l31 = l17 != false ? 128L : (long)64;
                l21 |= l31;
            }
            if (bl2 = (l30 = (l31 = l21 & l29) - l20) == 0L ? 0 : (l30 < 0L ? -1 : 1)) {
                object4 = tf2.a.getContext();
                object = l17 != false ? (Object)2131231044 : (Object)2131231037;
                object4 = AppCompatResources.getDrawable((Context)object4, (int)object);
            } else {
                bl2 = false;
                object4 = null;
            }
        } else {
            bl2 = false;
            object4 = null;
            l17 = 0;
            stringBuilder = null;
        }
        l18 = (long)53 & l21;
        object = l18 == l20 ? 0 : (l18 < l20 ? -1 : 1);
        if (object != false) {
            l18 = l21 & l19;
            long l32 = l18 - l20;
            object = l32 == 0L ? 0 : (l32 < 0L ? -1 : 1);
            if (object != false && object3 != null) {
                tf$b = tf2.k;
                if (tf$b == null) {
                    tf2.k = tf$b = new tf$b();
                }
                tf$b = tf$b.b((a)object3);
            } else {
                object = 0;
                tf$b = null;
            }
            l16 = l21 & l27;
            l15 = l16 == l20 ? 0 : (l16 < l20 ? -1 : 1);
            if (l15 != false && object3 != null) {
                tf$a tf$a = tf2.l;
                if (tf$a == null) {
                    tf2.l = tf$a = new tf$a();
                }
                object3 = tf$a.b((a)object3);
            } else {
                object3 = null;
            }
        } else {
            object3 = null;
            object = 0;
            tf$b = null;
        }
        l16 = (long)40 & l21;
        l15 = l16 == l20 ? 0 : (l16 < l20 ? -1 : 1);
        if (l15 != false) {
            object2 = object2 != null ? (Long)((LiveData)object2).getValue() : null;
            long l33 = ViewDataBinding.safeUnbox((Long)object2);
            object2 = l2.e(l33);
        } else {
            object2 = null;
        }
        l29 = l21 & l29;
        long l34 = l29 == l20 ? 0 : (l29 < l20 ? -1 : 1);
        if (l34 != false) {
            ImageView imageView = tf2.a;
            ImageViewBindingAdapter.setImageDrawable(imageView, (Drawable)object4);
        }
        if (bl2 = (l14 = (l19 = l21 & l27) - l20) == 0L ? 0 : (l14 < 0L ? -1 : 1)) {
            object4 = tf2.a;
            ViewBindingAdapter.setOnClick((View)object4, (View.OnClickListener)object3, (boolean)l17);
        }
        if (bl2 = (l13 = (l12 = (long)33 & l21) - l20) == 0L ? 0 : (l13 < 0L ? -1 : 1)) {
            object4 = tf2.b;
            ImageViewBindingAdapter.setImageDrawable((ImageView)object4, (Drawable)context);
        }
        if (bl2 = (l11 = (l12 = (long)49 & l21) - l20) == 0L ? 0 : (l11 < 0L ? -1 : 1)) {
            object4 = tf2.b;
            ViewBindingAdapter.setOnClick((View)object4, tf$b, bl3);
        }
        if (bl3 = (l10 = (l21 &= l26) - l20) == 0L ? 0 : (l10 < 0L ? -1 : 1)) {
            object6 = tf2.c;
            u.n((TextView)object6, (String)object5, null, null);
        }
        if (l15 != false) {
            object6 = tf2.d;
            u.n((TextView)object6, (String)object2, null, null);
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
            this.m = l10 = (long)32;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                n12 = 2;
                if (n10 != n12) {
                    n12 = 3;
                    if (n10 != n12) {
                        return false;
                    }
                    object = (MutableLiveData)object;
                    return this.L((MutableLiveData)object, n11);
                }
                object = (MutableLiveData)object;
                return this.I((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.K((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.J((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 20;
        if (n11 == n10) {
            object = (MutableLiveData)object;
            this.E((MutableLiveData)object);
            return 1 != 0;
        } else {
            n11 = 31;
            if (n11 == n10) {
                object = (MutableLiveData)object;
                this.G((MutableLiveData)object);
                return 1 != 0;
            } else {
                n11 = 19;
                if (n11 == n10) {
                    object = (MutableLiveData)object;
                    this.D((MutableLiveData)object);
                    return 1 != 0;
                } else {
                    n11 = 25;
                    if (n11 == n10) {
                        object = (a)object;
                        this.F((a)object);
                        return 1 != 0;
                    } else {
                        n11 = 44;
                        if (n11 != n10) return 0 != 0;
                        object = (MutableLiveData)object;
                        this.H((MutableLiveData)object);
                    }
                }
            }
        }
        return 1 != 0;
    }
}

