/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.a.g;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.account.R$id;
import com.zhiyun.account.me.account.widget.MeGetCodeView;
import com.zhiyun.account.me.account.widget.MeNameView;
import d.v.a.d;
import d.v.a.g.i0;
import d.v.a.g.j0$a;
import d.v.a.g.j0$b;
import d.v.a.j.c.y;
import d.v.a.j.c.z.j$b;
import l.a.q.g0.u;

public class j0
extends i0 {
    private static final ViewDataBinding$IncludedLayouts l;
    private static final SparseIntArray m;
    private final ConstraintLayout h;
    private j0$b i;
    private j0$a j;
    private long k;

    static {
        SparseIntArray sparseIntArray;
        m = sparseIntArray = new SparseIntArray();
        int n10 = R$id.mnv_name;
        sparseIntArray.put(n10, 4);
        n10 = R$id.mpv_get_code;
        sparseIntArray.put(n10, 5);
    }

    public j0(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = l;
        SparseIntArray sparseIntArray = m;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private j0(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[1];
        object3 = (ImageView)object2;
        Object object4 = object2 = objectArray[4];
        object4 = (MeNameView)((Object)object2);
        Object object5 = object2 = objectArray[5];
        object5 = (MeGetCodeView)((Object)object2);
        Object object6 = object2 = objectArray[3];
        object6 = (TextView)object2;
        Object object7 = object2 = objectArray[2];
        object7 = (TextView)object2;
        super(object, view, 3, (ImageView)object3, (MeNameView)((Object)object4), (MeGetCodeView)((Object)object5), (TextView)object6, (TextView)object7);
        this.k = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.h = object;
        object.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(MutableLiveData mutableLiveData, int n10) {
        int n11 = d.v.a.d.c;
        if (n10 == n11) {
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
    private boolean D(MutableLiveData mutableLiveData, int n10) {
        int n11 = d.v.a.d.c;
        if (n10 == n11) {
            synchronized (this) {
                long l10 = this.k;
                long l11 = 4;
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
    private boolean E(MutableLiveData mutableLiveData, int n10) {
        int n11 = d.v.a.d.c;
        if (n10 == n11) {
            synchronized (this) {
                long l10 = this.k;
                long l11 = 2;
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
    public void A(j$b j$b) {
        this.f = j$b;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 16;
            this.k = l10 |= l11;
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
    public void B(y y10) {
        this.g = y10;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 8;
            this.k = l10 |= l11;
        }
        int n10 = d.v.a.d.N0;
        this.notifyPropertyChanged(n10);
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
        int n10;
        j0$a j0$a;
        j0$b j0$b;
        long l14;
        int n11;
        int n12;
        float f10;
        long l15;
        int n13;
        long l16;
        long l17;
        Object object;
        Object object2;
        Object object3;
        long l18;
        long l19;
        j0 j02;
        block35: {
            Integer n14;
            block37: {
                float f11;
                long l20;
                block40: {
                    block39: {
                        block38: {
                            long l21;
                            Object object4;
                            j02 = this;
                            synchronized (this) {
                                l19 = this.k;
                                this.k = l18 = 0L;
                            }
                            object3 = this.g;
                            object2 = this.f;
                            long l22 = (long)63 & l19;
                            object = l22 == l18 ? 0 : (l22 < l18 ? -1 : 1);
                            l17 = 42;
                            long l23 = 57;
                            l16 = 41;
                            n13 = 0;
                            n14 = null;
                            if (object == false) break block37;
                            l15 = l19 & l23;
                            long l24 = l15 - l18;
                            object = l24 == 0L ? 0 : (l24 < 0L ? -1 : 1);
                            if (object == false) break block38;
                            if (object3 != null) {
                                object4 = ((y)object3).b;
                            } else {
                                object = 0;
                                object4 = null;
                            }
                            j02.updateLiveDataRegistration(0, (LiveData)object4);
                            if (object4 != null) {
                                object4 = (Boolean)((LiveData)object4).getValue();
                            } else {
                                object = 0;
                                object4 = null;
                            }
                            object = ViewDataBinding.safeUnbox((Boolean)object4);
                            l15 = l19 & l16;
                            l20 = l15 == l18 ? 0 : (l15 < l18 ? -1 : 1);
                            if (l20 != false) {
                                l15 = object != false ? 128L : (long)64;
                                l19 |= l15;
                            }
                            if ((l20 = (l21 = (l15 = l19 & l16) - l18) == 0L ? 0 : (l21 < 0L ? -1 : 1)) == false) break block39;
                            if (object != false) {
                                l20 = 1065353216;
                                f10 = 1.0f;
                            } else {
                                l20 = 1053609165;
                                f10 = 0.4f;
                            }
                            n12 = (int)l20;
                            f11 = f10;
                            break block40;
                        }
                        object = 0;
                        Object var21_15 = null;
                    }
                    n12 = 0;
                    f11 = 0.0f;
                }
                l15 = l19 & l17;
                l20 = l15 == l18 ? 0 : (l15 < l18 ? -1 : 1);
                if (l20 != false) {
                    MutableLiveData mutableLiveData;
                    if (object3 != null) {
                        mutableLiveData = ((y)object3).d;
                    } else {
                        l20 = 0;
                        mutableLiveData = null;
                        f10 = 0.0f;
                    }
                    n13 = 1;
                    j02.updateLiveDataRegistration(n13, mutableLiveData);
                    if (mutableLiveData != null) {
                        n14 = (Integer)mutableLiveData.getValue();
                    } else {
                        n13 = 0;
                        n14 = null;
                    }
                    n13 = ViewDataBinding.safeUnbox(n14);
                } else {
                    n13 = 0;
                    n14 = null;
                }
                long l25 = 44;
                long l26 = l19 & l25;
                l20 = l26 == l18 ? 0 : (l26 < l18 ? -1 : 1);
                if (l20 != false) {
                    if (object3 != null) {
                        object3 = ((y)object3).e;
                    } else {
                        n11 = 0;
                        object3 = null;
                    }
                    l20 = 2;
                    f10 = 2.8E-45f;
                    j02.updateLiveDataRegistration((int)l20, (LiveData)object3);
                    if (object3 != null) {
                        object3 = (Integer)((LiveData)object3).getValue();
                    } else {
                        n11 = 0;
                        object3 = null;
                    }
                    n11 = ViewDataBinding.safeUnbox((Integer)object3);
                    l20 = n12;
                    f10 = f11;
                    break block35;
                } else {
                    l20 = n12;
                    f10 = f11;
                    n11 = 0;
                    object3 = null;
                }
                break block35;
            }
            n11 = 0;
            object3 = null;
            n13 = 0;
            n14 = null;
            object = 0;
            Object var21_16 = null;
            boolean bl2 = false;
            f10 = 0.0f;
            Object var26_23 = null;
        }
        long l27 = (l14 = (l23 &= l19) - l18) == 0L ? 0 : (l14 < 0L ? -1 : 1);
        l15 = 48;
        if (l27 != false) {
            if (object2 != null) {
                j0$b = j02.i;
                if (j0$b == null) {
                    j02.i = j0$b = new j0$b();
                }
                j0$b = j0$b.b((j$b)object2);
            } else {
                j0$b = null;
            }
            long l28 = l19 & l15;
            n12 = l28 == l18 ? 0 : (l28 < l18 ? -1 : 1);
            if (n12 != 0 && object2 != null) {
                j0$a = j02.j;
                if (j0$a == null) {
                    j02.j = j0$a = new j0$a();
                }
                object2 = j0$a.b((j$b)object2);
            } else {
                n10 = 0;
                object2 = null;
            }
        } else {
            n10 = 0;
            object2 = null;
            j0$b = null;
        }
        l17 = l19 & l15;
        long l29 = l17 == l18 ? 0 : (l17 < l18 ? -1 : 1);
        if (l29 != false) {
            j0$a = j02.a;
            j0$a.setOnClickListener((View.OnClickListener)object2);
        }
        if ((n10 = (l13 = (l17 = l19 & l16) - l18) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != 0 && (n10 = ViewDataBinding.getBuildSdkInt()) >= (l29 = (long)11)) {
            object2 = j02.d;
            object2.setAlpha(f10);
        }
        if (l27 != false) {
            object2 = j02.d;
            ViewBindingAdapter.setOnClick((View)object2, j0$b, (boolean)object);
        }
        if ((n10 = (int)((l12 = (l11 = (long)44 & l19) - l18) == 0L ? 0 : (l12 < 0L ? -1 : 1))) != 0) {
            object2 = j02.d;
            u.k((TextView)object2, n11, null, null);
        }
        if ((n11 = (int)((l10 = (l19 &= (l11 = (long)42)) - l18) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0) {
            object3 = j02.e;
            u.k((TextView)object3, n13, null, null);
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
            this.k = l10 = (long)32;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                n12 = 2;
                if (n10 != n12) {
                    return false;
                }
                object = (MutableLiveData)object;
                return this.D((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.E((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.C((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = d.v.a.d.N0;
        if (n11 == n10) {
            object = (y)object;
            this.B((y)object);
            return 1 != 0;
        } else {
            n11 = d.v.a.d.x;
            if (n11 != n10) return 0 != 0;
            object = (j$b)object;
            this.A((j$b)object);
        }
        return 1 != 0;
    }
}

