/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.SpannableString
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.a.g;

import android.content.Context;
import android.text.SpannableString;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
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
import com.zhiyun.account.me.account.LoginFragment$a;
import com.zhiyun.account.me.account.widget.MeNameView;
import com.zhiyun.account.me.account.widget.MePassView;
import d.v.a.c;
import d.v.a.d;
import d.v.a.g.e;
import d.v.a.g.f$a;
import d.v.a.g.f$b;
import d.v.a.g.f$c;
import d.v.a.g.f$d;
import d.v.a.i.a.m0;
import l.a.q.g0.u;

public class f
extends e {
    private static final ViewDataBinding$IncludedLayouts s;
    private static final SparseIntArray t;
    private final ConstraintLayout m;
    private f$d n;
    private f$a o;
    private f$b p;
    private f$c q;
    private long r;

    static {
        SparseIntArray sparseIntArray;
        t = sparseIntArray = new SparseIntArray();
        int n10 = R$id.iv_title;
        sparseIntArray.put(n10, 7);
        n10 = R$id.tv_title_content;
        sparseIntArray.put(n10, 8);
        n10 = R$id.mnv_name;
        sparseIntArray.put(n10, 9);
        n10 = R$id.mpv_pass;
        sparseIntArray.put(n10, 10);
    }

    public f(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = s;
        SparseIntArray sparseIntArray = t;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 11, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private f(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[6];
        object2 = (CheckBox)object;
        Object object3 = object = objectArray[4];
        object3 = (CheckBox)object;
        Object object4 = object = objectArray[1];
        object4 = (ImageView)object;
        Object object5 = object = objectArray[7];
        object5 = (ImageView)object;
        Object object6 = object = objectArray[9];
        object6 = (MeNameView)((Object)object);
        Object object7 = object = objectArray[10];
        object7 = (MePassView)((Object)object);
        Object object8 = object = objectArray[3];
        object8 = (TextView)object;
        Object object9 = object = objectArray[5];
        object9 = (TextView)object;
        Object object10 = object = objectArray[8];
        object10 = (TextView)object;
        Object object11 = object = objectArray[2];
        object11 = (TextView)object;
        object = this;
        super(dataBindingComponent, view, 2, (CheckBox)object2, (CheckBox)object3, (ImageView)object4, (ImageView)object5, (MeNameView)((Object)object6), (MePassView)((Object)object7), (TextView)object8, (TextView)object9, (TextView)object10, (TextView)object11);
        this.r = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.m = object;
        object.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.j.setTag(null);
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
        int n11 = d.v.a.d.c;
        if (n10 == n11) {
            synchronized (this) {
                long l10 = this.r;
                long l11 = 2;
                this.r = l10 |= l11;
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
                long l10 = this.r;
                long l11 = 1L;
                this.r = l10 |= l11;
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
    public void A(LoginFragment$a loginFragment$a) {
        this.k = loginFragment$a;
        synchronized (this) {
            long l10 = this.r;
            long l11 = 8;
            this.r = l10 |= l11;
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
    public void B(m0 m02) {
        this.l = m02;
        synchronized (this) {
            long l10 = this.r;
            long l11 = 4;
            this.r = l10 |= l11;
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
        int n10;
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        SpannableString spannableString;
        Object object;
        f$b f$b;
        f$a f$a;
        f$d f$d;
        long l15;
        long l16;
        float f10;
        boolean bl2;
        long l17;
        Object object2;
        Object object3;
        Object object4;
        long l18;
        long l19;
        f f11;
        block31: {
            block32: {
                block29: {
                    block30: {
                        long l20;
                        block28: {
                            block24: {
                                float f12;
                                long l21;
                                long l22;
                                block27: {
                                    block26: {
                                        block25: {
                                            long l23;
                                            Object object5;
                                            f11 = this;
                                            synchronized (this) {
                                                l19 = this.r;
                                                this.r = l18 = 0L;
                                            }
                                            object4 = this.l;
                                            object3 = this.k;
                                            long l24 = (long)31 & l19;
                                            object2 = l24 == l18 ? 0 : (l24 < l18 ? -1 : 1);
                                            l17 = 22;
                                            long l25 = 29;
                                            long l26 = 21;
                                            bl2 = false;
                                            if (object2 == false) break block24;
                                            l22 = l19 & l25;
                                            long l27 = l22 - l18;
                                            object2 = l27 == 0L ? 0 : (l27 < 0L ? -1 : 1);
                                            if (object2 == false) break block25;
                                            if (object4 != null) {
                                                object5 = ((m0)object4).c;
                                            } else {
                                                object2 = 0;
                                                object5 = null;
                                            }
                                            f11.updateLiveDataRegistration(0, (LiveData)object5);
                                            if (object5 != null) {
                                                object5 = (Boolean)((LiveData)object5).getValue();
                                            } else {
                                                object2 = 0;
                                                object5 = null;
                                            }
                                            object2 = ViewDataBinding.safeUnbox((Boolean)object5);
                                            l22 = l19 & l26;
                                            l21 = l22 == l18 ? 0 : (l22 < l18 ? -1 : 1);
                                            if (l21 != false) {
                                                l22 = object2 != false ? (long)64 : (long)32;
                                                l19 |= l22;
                                            }
                                            if ((l21 = (l23 = (l22 = l19 & l26) - l18) == 0L ? 0 : (l23 < 0L ? -1 : 1)) == false) break block26;
                                            f12 = object2 != false ? 1.0f : 0.4f;
                                            break block27;
                                        }
                                        object2 = 0;
                                        Object var20_14 = null;
                                    }
                                    f12 = 0.0f;
                                }
                                l22 = l19 & l17;
                                l21 = l22 == l18 ? 0 : (l22 < l18 ? -1 : 1);
                                if (l21 != false) {
                                    if (object4 != null) {
                                        object4 = ((m0)object4).e;
                                    } else {
                                        f10 = 0.0f;
                                        object4 = null;
                                    }
                                    bl2 = true;
                                    f11.updateLiveDataRegistration((int)(bl2 ? 1 : 0), (LiveData)object4);
                                    if (object4 != null) {
                                        object4 = (Integer)((LiveData)object4).getValue();
                                    } else {
                                        f10 = 0.0f;
                                        object4 = null;
                                    }
                                    bl2 = ViewDataBinding.safeUnbox((Integer)object4);
                                }
                                f10 = f12;
                                boolean bl3 = bl2;
                                bl2 = object2;
                                object2 = bl3;
                                break block28;
                            }
                            object2 = 0;
                            Object var20_15 = null;
                            f10 = 0.0f;
                            object4 = null;
                        }
                        l16 = (l20 = (l25 &= l19) - l18) == 0L ? 0 : (l20 < 0L ? -1 : 1);
                        l15 = 24;
                        if (l16 == false) break block29;
                        if (object3 != null) {
                            f$d = f11.n;
                            if (f$d == null) {
                                f11.n = f$d = new f$d();
                            }
                            f$d = f$d.b((LoginFragment$a)object3);
                        } else {
                            f$d = null;
                        }
                        long l28 = l19 & l15;
                        long l29 = l28 == l18 ? 0 : (l28 < l18 ? -1 : 1);
                        if (l29 == false || object3 == null) break block30;
                        f$a = f11.o;
                        if (f$a == null) {
                            f11.o = f$a = new f$a();
                        }
                        f$a = f$a.b((LoginFragment$a)object3);
                        f$b = f11.p;
                        if (f$b == null) {
                            f11.p = f$b = new f$b();
                        }
                        f$b = f$b.b((LoginFragment$a)object3);
                        object = f11.q;
                        if (object == null) {
                            object = new f$c();
                            f11.q = object;
                        }
                        object3 = object.b((LoginFragment$a)object3);
                        break block31;
                    }
                    object3 = null;
                    break block32;
                }
                object3 = null;
                f$d = null;
            }
            f$a = null;
            f$b = null;
        }
        long l30 = l19 & (long)16;
        long l31 = l30 == l18 ? 0 : (l30 < l18 ? -1 : 1);
        if (l31 != false) {
            object = f11.a;
            Context context = this.getRoot().getContext();
            spannableString = d.v.a.c.b(context);
            object.setText((CharSequence)spannableString);
        }
        if ((l14 = (l13 = (l18 = l19 & l17) - (l17 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
            spannableString = f11.b;
            u.k((TextView)spannableString, (int)object2, null, null);
        }
        if ((l14 = (l12 = (l18 = l19 & l15) - l17) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            f11.c.setOnClickListener((View.OnClickListener)f$b);
            f11.h.setOnClickListener((View.OnClickListener)f$a);
            spannableString = f11.j;
            spannableString.setOnClickListener((View.OnClickListener)object3);
        }
        if ((l11 = (l10 = (l19 &= (l18 = (long)21)) - l17) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false && (l11 = (long)ViewDataBinding.getBuildSdkInt()) >= (n10 = 11)) {
            TextView textView = f11.g;
            textView.setAlpha(f10);
        }
        if (l16 != false) {
            object4 = f11.g;
            ViewBindingAdapter.setOnClick((View)object4, f$d, bl2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.r;
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
            this.r = l10 = (long)16;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                return false;
            }
            object = (MutableLiveData)object;
            return this.C((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.D((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = d.v.a.d.N0;
        if (n11 == n10) {
            object = (m0)object;
            this.B((m0)object);
            return 1 != 0;
        } else {
            n11 = d.v.a.d.x;
            if (n11 != n10) return 0 != 0;
            object = (LoginFragment$a)object;
            this.A((LoginFragment$a)object);
        }
        return 1 != 0;
    }
}

