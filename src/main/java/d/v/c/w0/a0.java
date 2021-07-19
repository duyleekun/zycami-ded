/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.account.widget.StatusView$Status;
import com.zhiyun.component.widget.JSWebView;
import d.v.c.f1.a.b$a;
import d.v.c.i1.t2.f0$c;
import d.v.c.i1.t2.o0;
import d.v.c.w0.z;

public class a0
extends z
implements b$a {
    private static final ViewDataBinding$IncludedLayouts k;
    private static final SparseIntArray l;
    private final ConstraintLayout g;
    private final View.OnClickListener h;
    private final View.OnClickListener i;
    private long j;

    static {
        SparseIntArray sparseIntArray;
        l = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362514, 4);
    }

    public a0(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = k;
        SparseIntArray sparseIntArray = l;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 5, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private a0(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        Object object4 = object3 = objectArray[3];
        object4 = (ImageView)object3;
        Object object5 = object3 = objectArray[4];
        object5 = (FrameLayout)object3;
        int n10 = 2;
        Object object6 = object2 = objectArray[n10];
        object6 = (StatusView)((Object)object2);
        int n11 = 1;
        Object object7 = object2 = objectArray[n11];
        object7 = (JSWebView)((Object)object2);
        object2 = this;
        super(object, view, 4, (ImageView)object4, (FrameLayout)object5, (StatusView)((Object)object6), (JSWebView)((Object)object7));
        this.j = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.g = object;
        object.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.setRootTag(view);
        super(this, n11);
        this.h = object;
        super(this, n10);
        this.i = object;
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
                long l10 = this.j;
                long l11 = 4;
                this.j = l10 |= l11;
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
                long l10 = this.j;
                long l11 = 8;
                this.j = l10 |= l11;
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
                long l10 = this.j;
                long l11 = 1L;
                this.j = l10 |= l11;
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
                long l10 = this.j;
                long l11 = 2;
                this.j = l10 |= l11;
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
    public void A(f0$c f0$c) {
        this.e = f0$c;
        synchronized (this) {
            long l10 = this.j;
            long l11 = 16;
            this.j = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(o0 o02) {
        this.f = o02;
        synchronized (this) {
            long l10 = this.j;
            long l11 = 32;
            this.j = l10 |= l11;
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
                f0$c f0$c = this.e;
                if (f0$c != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    f0$c.a();
                }
            }
        } else {
            f0$c f0$c = this.e;
            if (f0$c != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                f0$c.b();
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
        long l13;
        boolean bl2;
        long l14;
        long l15;
        Context context;
        Context context2;
        long l16;
        int n10;
        int n11;
        Object object;
        int n12;
        Object object2;
        Object object3;
        int n13;
        Object object4;
        int n14;
        long l17;
        long l18;
        Object object5;
        Object object6;
        long l19;
        long l20;
        a0 a02;
        block60: {
            block59: {
                block58: {
                    block56: {
                        Object object7;
                        block57: {
                            block51: {
                                block55: {
                                    StatusView statusView;
                                    int n15;
                                    Object object8;
                                    long l21;
                                    block54: {
                                        block53: {
                                            block52: {
                                                StatusView$Status statusView$Status;
                                                long l22;
                                                a02 = this;
                                                synchronized (this) {
                                                    l20 = this.j;
                                                    this.j = l19 = 0L;
                                                }
                                                object6 = this.f;
                                                long l23 = (long)111 & l20;
                                                object5 = l23 == l19 ? 0 : (l23 < l19 ? -1 : 1);
                                                long l24 = 98;
                                                l18 = 131072L;
                                                l17 = 107;
                                                n14 = 1;
                                                object4 = null;
                                                n13 = 0;
                                                object3 = null;
                                                if (object5 == false) break block51;
                                                long l25 = l20 & l17;
                                                long l26 = l25 - l19;
                                                object5 = l26 == 0L ? 0 : (l26 < 0L ? -1 : 1);
                                                if (object5 != false) {
                                                    if (object6 != null) {
                                                        object2 = ((o0)object6).d();
                                                    } else {
                                                        n12 = 0;
                                                        object2 = null;
                                                    }
                                                    a02.updateLiveDataRegistration(0, (LiveData)object2);
                                                    if (object2 != null) {
                                                        object2 = (Boolean)((LiveData)object2).getValue();
                                                    } else {
                                                        n12 = 0;
                                                        object2 = null;
                                                    }
                                                    n12 = ViewDataBinding.safeUnbox((Boolean)object2);
                                                    if (object5 != false) {
                                                        if (n12 != 0) {
                                                            l25 = 262144L;
                                                            l20 |= l25;
                                                        } else {
                                                            l20 |= l18;
                                                        }
                                                    }
                                                } else {
                                                    n12 = 0;
                                                    object2 = null;
                                                }
                                                if ((object5 = (l22 = (l25 = l20 & l24) - l19) == 0L ? 0 : (l22 < 0L ? -1 : 1)) == false) break block52;
                                                if (object6 != null) {
                                                    MutableLiveData mutableLiveData;
                                                    object3 = mutableLiveData = ((o0)object6).f();
                                                } else {
                                                    n13 = 0;
                                                    object3 = null;
                                                }
                                                a02.updateLiveDataRegistration(n14, (LiveData)object3);
                                                object = object3 != null ? (statusView$Status = (StatusView$Status)((Object)object3.getValue())) : null;
                                                object7 = StatusView$Status.STATUS_NONE;
                                                if (object == object7) {
                                                    n11 = n14;
                                                } else {
                                                    n11 = 0;
                                                    object7 = null;
                                                }
                                                if (object5 != false) {
                                                    l21 = n11 != 0 ? 256L : 128L;
                                                    l20 |= l21;
                                                }
                                                if (n11 != 0) break block53;
                                                object5 = 8;
                                                break block54;
                                            }
                                            n13 = 0;
                                            object3 = null;
                                            object = null;
                                        }
                                        object5 = 0;
                                    }
                                    long l27 = 100;
                                    l21 = l20 & l27;
                                    n11 = l21 == l19 ? 0 : (l21 < l19 ? -1 : 1);
                                    if (n11 == 0) break block55;
                                    if (object6 != null) {
                                        MutableLiveData mutableLiveData = ((o0)object6).b();
                                        object8 = mutableLiveData;
                                    } else {
                                        n15 = 0;
                                        object8 = null;
                                    }
                                    n10 = 2;
                                    a02.updateLiveDataRegistration(n10, (LiveData)object8);
                                    if (object8 != null) {
                                        object8 = (Boolean)((LiveData)object8).getValue();
                                    } else {
                                        n15 = 0;
                                        object8 = null;
                                    }
                                    n15 = ViewDataBinding.safeUnbox((Boolean)object8);
                                    if (n11 != 0) {
                                        if (n15 != 0) {
                                            l20 = l20 | 0x400L | 0x1000L | 0x10000L;
                                            l16 = 0x100000L;
                                        } else {
                                            l20 = l20 | 0x200L | 0x800L | 0x8000L;
                                            l16 = 524288L;
                                        }
                                        l20 |= l16;
                                    }
                                    object7 = a02.c;
                                    n10 = n15 != 0 ? 2131099739 : 2131099772;
                                    n11 = ViewDataBinding.getColorFromResource((View)object7, n10);
                                    if (n15 != 0) {
                                        statusView = a02.c;
                                        n14 = ViewDataBinding.getColorFromResource((View)statusView, 2131099776);
                                    } else {
                                        StatusView statusView2 = a02.c;
                                        n10 = 2131099737;
                                        n14 = ViewDataBinding.getColorFromResource((View)statusView2, n10);
                                    }
                                    if (n15 != 0) {
                                        statusView = a02.a.getContext();
                                        int n16 = 2131231362;
                                        context2 = AppCompatResources.getDrawable((Context)statusView, n16);
                                    } else {
                                        context2 = a02.a.getContext();
                                        int n17 = 2131231287;
                                        context2 = AppCompatResources.getDrawable(context2, n17);
                                    }
                                    context = a02.c.getContext();
                                    n15 = n15 != 0 ? 2131231805 : 2131231806;
                                    context = AppCompatResources.getDrawable(context, n15);
                                    break block56;
                                }
                                boolean bl3 = false;
                                context2 = null;
                                boolean bl4 = false;
                                context = null;
                                n14 = 0;
                                Object var40_31 = null;
                                break block57;
                            }
                            boolean bl5 = false;
                            context2 = null;
                            boolean bl6 = false;
                            context = null;
                            n13 = 0;
                            object3 = null;
                            object = null;
                            object5 = 0;
                            n14 = 0;
                            Object var40_32 = null;
                            n12 = 0;
                            object2 = null;
                        }
                        n11 = 0;
                        object7 = null;
                    }
                    l17 = 0L;
                    long l28 = (l18 &= l20) - l17;
                    l15 = l28 == 0L ? 0 : (l28 < 0L ? -1 : 1);
                    if (l15 == false) break block58;
                    if (object6 != null) {
                        object3 = ((o0)object6).f();
                    }
                    l15 = 1;
                    a02.updateLiveDataRegistration((int)l15, (LiveData)object3);
                    if (object3 != null) {
                        object3 = object3.getValue();
                        object = object3;
                        object = (StatusView$Status)((Object)object3);
                    }
                    if (object == (object3 = StatusView$Status.STATUS_ERROR)) break block59;
                    n13 = l15;
                    break block60;
                }
                l15 = 1;
            }
            n13 = 0;
            object3 = null;
        }
        long l29 = l20 & (long)107;
        long l30 = l29 - 0L;
        n10 = (int)(l30 == 0L ? 0 : (l30 < 0L ? -1 : 1));
        long l31 = 8192L;
        if (n10 != 0) {
            if (n12 != 0) {
                n13 = l15;
            }
            if (n10 != 0) {
                if (n13 != 0) {
                    l29 = 16384L;
                    l20 |= l29;
                } else {
                    l20 |= l31;
                }
            }
        } else {
            n13 = 0;
            object3 = null;
        }
        if ((n12 = (l14 = (l31 &= l20) - (l16 = 0L)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != 0) {
            if (object6 != null) {
                object6 = ((o0)object6).c();
            } else {
                bl2 = false;
                object6 = null;
            }
            n12 = 3;
            a02.updateLiveDataRegistration(n12, (LiveData)object6);
            if (object6 != null) {
                object4 = object6 = ((LiveData)object6).getValue();
                object4 = (Boolean)object6;
            }
            bl2 = ViewDataBinding.safeUnbox(object4);
        } else {
            bl2 = false;
            object6 = null;
        }
        l29 = l20 & (long)107;
        l31 = 0L;
        n12 = (int)(l29 == l31 ? 0 : (l29 < l31 ? -1 : 1));
        if (n12 != 0) {
            if (n13 != 0) {
                bl2 = l15;
            }
            if (n12 != 0) {
                long l32 = bl2 ? 0x400000L : 0x200000L;
                l20 |= l32;
            }
            int n18 = bl2 ? 8 : 0;
            n13 = n18;
        } else {
            n13 = 0;
            object3 = null;
        }
        l18 = (long)64 & l20;
        l17 = 0L;
        bl2 = l18 == l17 ? 0 : (l18 < l17 ? -1 : 1);
        if (bl2) {
            object6 = a02.a;
            object2 = a02.i;
            object6.setOnClickListener((View.OnClickListener)object2);
            a02.c.setErrorText("@string/web_net_error");
            object6 = a02.c;
            object2 = a02.h;
            ((StatusView)((Object)object6)).setOnClickErrorListener((View.OnClickListener)object2);
        }
        if (bl2 = (l13 = (l18 = (long)100 & l20) - (l17 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) {
            ImageViewBindingAdapter.setImageDrawable(a02.a, (Drawable)context2);
            a02.c.setBackgroundColor(n11);
            a02.c.setErrorImage((Drawable)context);
            object6 = a02.c;
            ((StatusView)((Object)object6)).setTextColor(n14);
        }
        if (bl2 = (l12 = (l19 = (long)107 & l20) - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) {
            object6 = a02.a;
            object6.setVisibility(n13);
        }
        if (bl2 = (l10 = (l20 &= (l19 = (long)98)) - l11) == 0L ? 0 : (l10 < 0L ? -1 : 1)) {
            a02.c.setStatus((StatusView$Status)((Object)object));
            object6 = a02.d;
            object6.setVisibility((int)object5);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.j;
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
            this.j = l10 = (long)64;
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
                    return this.D((MutableLiveData)object, n11);
                }
                object = (MutableLiveData)object;
                return this.C((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.F((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.E((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (f0$c)object;
            this.A((f0$c)object);
            return 1 != 0;
        } else {
            n11 = 152;
            if (n11 != n10) return 0 != 0;
            object = (o0)object;
            this.B((o0)object);
        }
        return 1 != 0;
    }
}

