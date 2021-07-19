/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
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
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import d.v.c.f1.a.b$a;
import d.v.c.s0.a7.n1.a$b;
import d.v.c.s0.a7.n1.b;
import d.v.c.w0.n3;
import l.a.q.g0.u;

public class o3
extends n3
implements b$a {
    private static final ViewDataBinding$IncludedLayouts m;
    private static final SparseIntArray n;
    private final ConstraintLayout h;
    private final View i;
    private final View.OnClickListener j;
    private final View.OnClickListener k;
    private long l;

    static {
        SparseIntArray sparseIntArray;
        n = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363695, 6);
    }

    public o3(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = m;
        SparseIntArray sparseIntArray = n;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 7, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private o3(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        Object object4 = object3 = objectArray[3];
        object4 = (TextView)object3;
        Object object5 = object3 = objectArray[5];
        object5 = (TextView)object3;
        int n10 = 2;
        Object object6 = object2 = objectArray[n10];
        object6 = (TextView)object2;
        int n11 = 1;
        Object object7 = object2 = objectArray[n11];
        object7 = (TextView)object2;
        Object object8 = object2 = objectArray[6];
        object8 = (View)object2;
        object2 = this;
        super(object, view, 4, (TextView)object4, (TextView)object5, (TextView)object6, (TextView)object7, (View)object8);
        this.l = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.h = object;
        object.setTag(null);
        object = (View)objectArray[4];
        this.i = object;
        object.setTag(null);
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.setRootTag(view);
        super(this, n11);
        this.j = object;
        super(this, n10);
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
                long l11 = 8;
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
    private boolean D(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.l;
                long l11 = 4;
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
    private boolean E(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.l;
                long l11 = 2;
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
    private boolean F(MutableLiveData mutableLiveData, int n10) {
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
    public void A(a$b a$b) {
        this.f = a$b;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 16;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(b b10) {
        this.g = b10;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 32;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 == n13) {
                a$b a$b = this.f;
                if (a$b != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    a$b.b();
                }
            }
        } else {
            a$b a$b = this.f;
            if (a$b != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                a$b.a();
            }
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
        View.OnClickListener onClickListener;
        long l13;
        View view;
        long l14;
        long l15;
        long l16;
        long l17;
        long l18;
        long l19;
        int n10;
        int n11;
        int n12;
        Object object;
        int n13;
        Object object2;
        long l20;
        int n14;
        Object object3;
        float f10;
        int n15;
        Object object4;
        int n16;
        Object object5;
        MutableLiveData mutableLiveData;
        int n17;
        float f11;
        int n18;
        float f12;
        int n19;
        long l21;
        long l22;
        long l23;
        long l24;
        long l25;
        long l26;
        Object object6;
        Object object7;
        long l27;
        long l28;
        o3 o32;
        block76: {
            block77: {
                block71: {
                    int n20;
                    long l29;
                    block75: {
                        block74: {
                            block73: {
                                block72: {
                                    long l30;
                                    long l31;
                                    long l32;
                                    o32 = this;
                                    synchronized (this) {
                                        l28 = this.l;
                                        this.l = l27 = 0L;
                                    }
                                    object7 = this.g;
                                    long l33 = (long)111 & l28;
                                    object6 = l33 == l27 ? 0 : (l33 < l27 ? -1 : 1);
                                    long l34 = 65536L;
                                    l26 = 16384L;
                                    long l35 = 8192L;
                                    l25 = 104;
                                    l24 = 98;
                                    l23 = 97;
                                    l22 = 102;
                                    l21 = 100;
                                    n19 = 8;
                                    f12 = 1.1E-44f;
                                    n18 = 1;
                                    f11 = Float.MIN_VALUE;
                                    n17 = 0;
                                    mutableLiveData = null;
                                    if (object6 == false) break block71;
                                    long l36 = l28 & l23;
                                    long l37 = l36 - l27;
                                    object6 = l37 == 0L ? 0 : (l37 < 0L ? -1 : 1);
                                    if (object6 != false) {
                                        if (object7 != null) {
                                            MutableLiveData mutableLiveData2 = ((b)object7).e();
                                            object5 = mutableLiveData2;
                                        } else {
                                            object5 = null;
                                        }
                                        o32.updateLiveDataRegistration(0, (LiveData)object5);
                                        object5 = object5 != null ? (String)((LiveData)object5).getValue() : null;
                                        n16 = object5 == null ? n18 : 0;
                                        if (object6 != false) {
                                            if (n16 != 0) {
                                                l28 |= 0x100L;
                                                l32 = 0x400000L;
                                            } else {
                                                l28 |= 0x80L;
                                                l32 = 0x200000L;
                                            }
                                            l28 |= l32;
                                        }
                                        object6 = n16 != 0 ? (Object)n19 : (Object)0;
                                    } else {
                                        object6 = 0;
                                        n16 = 0;
                                        object5 = null;
                                    }
                                    l32 = l28 & l24;
                                    l29 = l32 == l27 ? 0 : (l32 < l27 ? -1 : 1);
                                    if (l29 != false) {
                                        if (object7 != null) {
                                            MutableLiveData mutableLiveData3;
                                            mutableLiveData = mutableLiveData3 = ((b)object7).d();
                                        } else {
                                            n17 = 0;
                                            mutableLiveData = null;
                                        }
                                        o32.updateLiveDataRegistration(n18, mutableLiveData);
                                        object4 = mutableLiveData != null ? (String)mutableLiveData.getValue() : null;
                                        if (object4 == null) {
                                            n15 = n18;
                                            f10 = f11;
                                        } else {
                                            n15 = 0;
                                            f10 = 0.0f;
                                        }
                                        if (l29 != false) {
                                            if (n15 != 0) {
                                                l28 = l28 | l26 | l34;
                                            } else {
                                                l28 |= l35;
                                                long l38 = 32768L;
                                                l28 |= l38;
                                            }
                                        }
                                        if (n15 != 0) {
                                            l29 = n19;
                                            float f13 = f12;
                                        } else {
                                            l29 = 0;
                                            float f14 = 0.0f;
                                        }
                                    } else {
                                        n17 = 0;
                                        mutableLiveData = null;
                                        l29 = 0;
                                        float f15 = 0.0f;
                                        object4 = null;
                                        n15 = 0;
                                        f10 = 0.0f;
                                    }
                                    long l39 = l28 & l22;
                                    long l40 = l39 == l27 ? 0 : (l39 < l27 ? -1 : 1);
                                    if (l40 == false) break block72;
                                    if (object7 != null) {
                                        MutableLiveData mutableLiveData4 = ((b)object7).c();
                                        object3 = mutableLiveData4;
                                    } else {
                                        object3 = null;
                                    }
                                    n14 = 2;
                                    o32.updateLiveDataRegistration(n14, (LiveData)object3);
                                    object3 = object3 != null ? (String)((LiveData)object3).getValue() : null;
                                    n14 = object3 == null ? n18 : 0;
                                    long l41 = l28 & l21;
                                    n20 = l41 == l27 ? 0 : (l41 < l27 ? -1 : 1);
                                    if (n20 != 0) {
                                        if (n14 != 0) {
                                            l28 |= 0x400L;
                                            l41 = 262144L;
                                        } else {
                                            l28 |= 0x200L;
                                            l41 = 131072L;
                                        }
                                        l28 |= l41;
                                    }
                                    if ((n20 = (l31 = (l41 = l28 & l22) - l27) == 0L ? 0 : (l31 < 0L ? -1 : 1)) != 0) {
                                        if (n14 != 0) {
                                            l41 = 0x100000L;
                                            l28 |= l41;
                                        } else {
                                            l20 = 524288L;
                                            l28 |= l20;
                                        }
                                    }
                                    if ((n20 = (l30 = (l41 = l28 & l21) - l27) == 0L ? 0 : (l30 < 0L ? -1 : 1)) == 0 || n14 == 0) break block73;
                                    n20 = n19;
                                    float f16 = f12;
                                    break block74;
                                }
                                object3 = null;
                                n14 = 0;
                            }
                            n20 = 0;
                            float f17 = 0.0f;
                        }
                        long l42 = l28 & l25;
                        long l43 = l42 == l27 ? 0 : (l42 < l27 ? -1 : 1);
                        if (l43 == false) break block75;
                        if (object7 != null) {
                            MutableLiveData mutableLiveData5 = ((b)object7).b();
                            object2 = mutableLiveData5;
                        } else {
                            object2 = null;
                        }
                        n13 = 3;
                        o32.updateLiveDataRegistration(n13, (LiveData)object2);
                        object2 = object2 != null ? (String)((LiveData)object2).getValue() : null;
                        if (object2 == null) {
                            n13 = n18;
                        } else {
                            n13 = 0;
                            object = null;
                        }
                        if (l43 != false) {
                            long l44;
                            if (n13 != 0) {
                                l28 |= 0x1000000L;
                                l44 = 0x4000000L;
                            } else {
                                l28 |= 0x800000L;
                                l44 = 0x2000000L;
                            }
                            l28 |= l44;
                        }
                        if (n13 != 0) {
                            l43 = n19;
                            float f18 = f12;
                        } else {
                            l43 = 0;
                            float f19 = 0.0f;
                        }
                        n12 = l29;
                        n11 = n20;
                        n10 = l43;
                        l20 = 524288L;
                        break block76;
                    }
                    n12 = l29;
                    n11 = n20;
                    object2 = null;
                    n13 = 0;
                    object = null;
                    l20 = 524288L;
                    break block77;
                }
                object6 = 0;
                object2 = null;
                n13 = 0;
                object = null;
                n17 = 0;
                mutableLiveData = null;
                object5 = null;
                object3 = null;
                n14 = 0;
                l20 = 524288L;
                n16 = 0;
                object4 = null;
                n15 = 0;
                f10 = 0.0f;
                n12 = 0;
                n11 = 0;
            }
            n10 = 0;
        }
        l20 = l28 & l20;
        long l45 = l20 == l27 ? 0 : (l20 < l27 ? -1 : 1);
        if (l45 != false) {
            if (object7 != null) {
                mutableLiveData = ((b)object7).d();
            }
            o32.updateLiveDataRegistration(n18, mutableLiveData);
            if (mutableLiveData != null) {
                object4 = object7 = mutableLiveData.getValue();
                object4 = (String)object7;
            }
            if (object4 == null) {
                n15 = n18;
                f10 = f11;
            } else {
                n15 = 0;
                f10 = 0.0f;
            }
            l20 = l28 & l24;
            l19 = l20 == l27 ? 0 : (l20 < l27 ? -1 : 1);
            if (l19 != false) {
                if (n15 != 0) {
                    l28 |= l26;
                    l26 = 65536L;
                } else {
                    l28 |= 0x2000L;
                    l26 = 32768L;
                }
                l28 |= l26;
            }
        }
        if ((l19 = (l18 = (l26 = l28 & l21) - l27) == 0L ? 0 : (l18 < 0L ? -1 : 1)) != false) {
            if (n14 != 0) {
                object3 = "";
            }
        } else {
            object3 = null;
        }
        if ((l19 = (l17 = (l26 = l28 & l23) - l27) == 0L ? 0 : (l17 < 0L ? -1 : 1)) != false) {
            if (n16 != 0) {
                object5 = "";
            }
        } else {
            object5 = null;
        }
        if ((l19 = (l16 = (l26 = l28 & l25) - l27) == 0L ? 0 : (l16 < 0L ? -1 : 1)) != false) {
            if (n13 != 0) {
                object2 = "";
            }
        } else {
            object2 = null;
        }
        if ((l19 = (l15 = (l14 = l28 & l22) - l27) == 0L ? 0 : (l15 < 0L ? -1 : 1)) != false) {
            if (n14 == 0) {
                n18 = n15;
                f11 = f10;
            }
            if (l19 != false) {
                l14 = n18 != 0 ? 4096L : 2048L;
                l28 |= l14;
            }
            if (n18 == 0) {
                n19 = 0;
                f12 = 0.0f;
            }
            n17 = n19;
        } else {
            n17 = 0;
            mutableLiveData = null;
        }
        l14 = l28 & l24;
        l19 = l14 == l27 ? 0 : (l14 < l27 ? -1 : 1);
        if (l19 != false) {
            if (n15 != 0) {
                object4 = "";
            }
            object = object4;
        } else {
            n13 = 0;
            object = null;
        }
        l26 = l28 & l22;
        long l46 = l26 == l27 ? 0 : (l26 < l27 ? -1 : 1);
        if (l46 != false) {
            view = o32.i;
            view.setVisibility(n17);
        }
        if ((l46 = (l13 = (l26 = (long)64 & l28) - l27) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
            view = o32.a;
            onClickListener = o32.j;
            view.setOnClickListener(onClickListener);
            view = o32.b;
            onClickListener = o32.k;
            view.setOnClickListener(onClickListener);
        }
        if ((l46 = (l12 = (l26 = l28 & l21) - l27) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            o32.a.setVisibility(n11);
            view = o32.a;
            onClickListener = null;
            u.n((TextView)view, (String)object3, null, null);
        } else {
            onClickListener = null;
        }
        if (l19 != false) {
            object7 = o32.b;
            l46 = n12;
            object7.setVisibility(n12);
            object7 = o32.b;
            u.n((TextView)object7, (String)object, null, null);
        }
        if ((l19 = (l11 = (l14 = l28 & l25) - l27) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            object7 = o32.c;
            n13 = n10;
            object7.setVisibility(n10);
            object7 = o32.c;
            u.n((TextView)object7, (String)object2, null, null);
        }
        if ((l19 = (l10 = (l28 &= l23) - l27) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            o32.d.setVisibility((int)object6);
            object7 = o32.d;
            u.n((TextView)object7, (String)object5, null, null);
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
            this.l = l10 = (long)64;
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
                    return this.C((MutableLiveData)object, n11);
                }
                object = (MutableLiveData)object;
                return this.D((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.E((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.F((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (a$b)object;
            this.A((a$b)object);
            return 1 != 0;
        } else {
            n11 = 152;
            if (n11 != n10) return 0 != 0;
            object = (b)object;
            this.B((b)object);
        }
        return 1 != 0;
    }
}

