/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.voice.music.MusicListViewModel;
import com.zhiyun.cama.voice.music.MusicPlayVieModel;
import com.zhiyun.cama.widget.RoundImageView;
import com.zhiyun.cama.widget.ZYTextView;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.k1.b.a;
import d.v.c.v0.q.c;
import d.v.c.w0.ub;
import d.v.c.y1.f.q;
import d.v.e.l.c2;
import d.v.e.l.l2;
import l.a.q.g0.u;

public class vb
extends ub
implements b$a {
    private static final ViewDataBinding$IncludedLayouts p;
    private static final SparseIntArray q;
    private final ConstraintLayout m;
    private final View.OnClickListener n;
    private long o;

    public vb(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = p;
        SparseIntArray sparseIntArray = q;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 9, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private vb(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[8];
        object2 = (CheckBox)object;
        Object object3 = object = objectArray[2];
        object3 = (ImageView)object;
        int n10 = 1;
        Object object4 = object = objectArray[n10];
        object4 = (RoundImageView)object;
        Object object5 = object = objectArray[4];
        object5 = (ImageView)object;
        Object object6 = object = objectArray[6];
        object6 = (ProgressBar)object;
        Object object7 = object = objectArray[3];
        object7 = (TextView)object;
        Object object8 = object = objectArray[5];
        object8 = (ZYTextView)object;
        Object object9 = object = objectArray[7];
        object9 = (TextView)object;
        object = this;
        super(dataBindingComponent, view, 3, (CheckBox)object2, (ImageView)object3, (RoundImageView)object4, (ImageView)object5, (ProgressBar)object6, (TextView)object7, (ZYTextView)object8, (TextView)object9);
        this.o = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.m = object;
        object.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, n10);
        this.n = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean G(q q10, int n10) {
        boolean bl2 = true;
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.o;
                long l11 = 2;
                this.o = l10 |= l11;
                return bl2;
            }
        }
        int n11 = 43;
        if (n10 == n11) {
            synchronized (this) {
                long l12 = this.o;
                long l13 = 64;
                this.o = l12 |= l13;
                return bl2;
            }
        }
        n11 = 42;
        if (n10 == n11) {
            synchronized (this) {
                long l14 = this.o;
                long l15 = 128L;
                this.o = l14 |= l15;
                return bl2;
            }
        }
        n11 = 92;
        if (n10 == n11) {
            synchronized (this) {
                long l16 = this.o;
                long l17 = 256L;
                this.o = l16 |= l17;
                return bl2;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean H(MutableLiveData mutableLiveData, int n10) {
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
    private boolean I(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.o;
                long l11 = 4;
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
    public void C(q q10) {
        int n10 = 1;
        this.updateRegistration(n10, q10);
        this.i = q10;
        synchronized (this) {
            long l10 = this.o;
            long l11 = 2;
            this.o = l10 |= l11;
        }
        this.notifyPropertyChanged(94);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(MusicListViewModel musicListViewModel) {
        this.k = musicListViewModel;
        synchronized (this) {
            long l10 = this.o;
            long l11 = 16;
            this.o = l10 |= l11;
        }
        this.notifyPropertyChanged(95);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void E(Integer n10) {
        this.j = n10;
        synchronized (this) {
            long l10 = this.o;
            long l11 = 8;
            this.o = l10 |= l11;
        }
        this.notifyPropertyChanged(101);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void F(Boolean bl2) {
        this.l = bl2;
        synchronized (this) {
            long l10 = this.o;
            long l11 = 32;
            this.o = l10 |= l11;
        }
        this.notifyPropertyChanged(146);
        super.requestRebind();
    }

    public final void a(int n10, View object) {
        Context context;
        boolean bl2;
        MusicListViewModel musicListViewModel = this.k;
        object = this.i;
        Integer n11 = this.j;
        if (musicListViewModel != null) {
            bl2 = true;
        } else {
            bl2 = false;
            context = null;
        }
        if (bl2) {
            context = this.getRoot().getContext();
            int n12 = n11;
            musicListViewModel.k(context, (q)object, n12);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        ProgressBar progressBar;
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        long l15;
        long l16;
        long l17;
        long l18;
        long l19;
        long l20;
        long l21;
        long l22;
        boolean bl2;
        long l23;
        int n10;
        int n11;
        int n12;
        int n13;
        CheckBox checkBox;
        boolean bl3;
        int n14;
        Object object;
        String string2;
        String string3;
        long l24;
        boolean bl4;
        int n15;
        CharSequence charSequence;
        long l25;
        boolean bl5;
        double d10;
        long l26;
        long l27;
        vb vb2 = this;
        synchronized (this) {
            l27 = this.o;
            l26 = 0L;
            d10 = 0.0;
            this.o = l26;
        }
        Object object2 = this.i;
        Object object3 = this.j;
        Object object4 = this.k;
        Boolean bl6 = this.l;
        long l28 = 0x3C2L & l27;
        Object object5 = l28 == l26 ? 0 : (l28 < l26 ? -1 : 1);
        long l29 = 770L;
        long l30 = 514L;
        double d11 = 2.54E-321;
        long l31 = 578L;
        int n16 = 1;
        long l32 = 1024L;
        if (object5 != false) {
            String string4;
            String string5;
            String string6;
            String string7;
            long l33 = l27 & l31;
            long l34 = l33 - l26;
            object5 = l34 == 0L ? 0 : (l34 < 0L ? -1 : 1);
            object5 = object5 != false && object2 != null ? (Object)((c)object2).t() : (Object)0;
            l33 = l27 & l30;
            long l35 = l33 - l26;
            Object object6 = l35 == 0L ? 0 : (l35 < 0L ? -1 : 1);
            if (object6 != false) {
                a a10 = object2 != null ? ((q)object2).G() : null;
                if (a10 != null) {
                    long l36;
                    string7 = a10.i();
                    string6 = a10.e();
                    bl5 = a10.k();
                    l25 = a10.c();
                    l30 = l36 = a10.h();
                } else {
                    l30 = l26;
                    d11 = d10;
                    l25 = l26;
                    string7 = null;
                    string6 = null;
                    bl5 = false;
                }
                if (object6 != false) {
                    l33 = bl5 ? 0x200000L : 0x100000L;
                    l27 |= l33;
                }
                object6 = bl5 ? (Object)0 : (Object)8;
                string5 = l2.d(l25);
                d11 = l30;
                string4 = c2.b(d11, n16);
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string5);
                ((StringBuilder)charSequence).append("/");
                string5 = ((StringBuilder)charSequence).toString();
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string5);
                ((StringBuilder)charSequence).append(string4);
                string5 = String.valueOf(((StringBuilder)charSequence).toString());
            } else {
                n15 = 0;
                string5 = null;
                object6 = 0;
                string7 = null;
                string6 = null;
            }
            l30 = l27 & l29;
            bl4 = l30 == l26 ? 0 : (l30 < l26 ? -1 : 1);
            if (bl4 && object2 != null) {
                bl4 = ((q)object2).H();
            } else {
                bl4 = false;
                string4 = null;
            }
            l24 = 706L;
            long l37 = l27 & l24;
            long l38 = l37 == l26 ? 0 : (l37 < l26 ? -1 : 1);
            if (l38 != false) {
                bl5 = object2 != null ? ((c)object2).z() : false;
                if (l38 != false) {
                    if (bl5) {
                        l25 = 2048L;
                        l27 |= l25;
                    } else {
                        l27 |= l32;
                    }
                }
                string3 = string5;
                n15 = object6;
                charSequence = string7;
                string2 = string6;
            } else {
                string3 = string5;
                n15 = object6;
                charSequence = string7;
                string2 = string6;
                bl5 = false;
            }
        } else {
            object5 = 0;
            n16 = 0;
            string3 = null;
            n15 = 0;
            Object var37_26 = null;
            bl4 = false;
            Object var38_28 = null;
            boolean bl7 = false;
            charSequence = null;
            bl5 = false;
            string2 = null;
        }
        long l39 = 541L;
        l25 = l27 & l39;
        long l40 = l25 == l26 ? 0 : (l25 < l26 ? -1 : 1);
        if (l40 != false) {
            if (object4 != null) {
                MutableLiveData mutableLiveData = ((MusicPlayVieModel)object4).b();
                object = ((MusicPlayVieModel)object4).c();
                object4 = mutableLiveData;
            } else {
                n14 = 0;
                object4 = null;
                bl3 = false;
                object = null;
            }
            checkBox = null;
            vb2.updateLiveDataRegistration(0, (LiveData)object4);
            n13 = 2;
            vb2.updateLiveDataRegistration(n13, (LiveData)object);
            if (object4 != null) {
                object4 = (Boolean)((LiveData)object4).getValue();
            } else {
                n14 = 0;
                object4 = null;
            }
            if (object != null) {
                object = (Integer)((LiveData)object).getValue();
            } else {
                bl3 = false;
                object = null;
            }
            n14 = (int)(ViewDataBinding.safeUnbox((Boolean)object4) ? 1 : 0);
            if (object3 == object) {
                n12 = 1;
            } else {
                n12 = 0;
                object3 = null;
            }
            n12 &= n14;
            if (l40 != false) {
                l29 = n12 != 0 ? 524288L : 262144L;
                l27 |= l29;
            }
            if (n12 != 0) {
                object3 = vb2.b.getContext();
                n14 = 2131231061;
            } else {
                object3 = vb2.b.getContext();
                n14 = 2131231060;
            }
            object3 = AppCompatResources.getDrawable((Context)object3, n14);
        } else {
            n12 = 0;
            object3 = null;
        }
        l29 = 544L;
        l25 = l27 & l29;
        n14 = l25 == l26 ? 0 : (l25 < l26 ? -1 : 1);
        if (n14 != 0) {
            n11 = ViewDataBinding.safeUnbox(bl6);
            if (n14 != 0) {
                if (n11 != 0) {
                    l27 |= 0x2000L;
                    l25 = 32768L;
                } else {
                    l27 |= 0x1000L;
                    l25 = 16384L;
                }
                l27 |= l25;
            }
            if (n11 != 0) {
                n14 = 0;
                object4 = null;
            } else {
                n14 = 8;
            }
            n10 = n11 != 0 ? 8 : 0;
            n11 = n10;
        } else {
            n14 = 0;
            object4 = null;
            n11 = 0;
            bl6 = null;
        }
        n10 = (int)((l23 = (l27 & l32) - l26) == 0L ? 0 : (l23 < 0L ? -1 : 1));
        l25 = 65536L;
        if (n10 != 0) {
            if (object2 != null) {
                object5 = ((c)object2).t();
            }
            bl2 = object5 == false;
            if (n10 != 0) {
                if (bl2) {
                    long l41 = 131072L;
                    l27 |= l41;
                } else {
                    l27 |= l25;
                }
            }
        } else {
            bl2 = false;
        }
        if ((l22 = (l21 = (l25 = l27 & l25) - l26) == 0L ? 0 : (l21 < 0L ? -1 : 1)) != false) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((int)object5);
            object = "%";
            ((StringBuilder)object2).append((String)object);
            object2 = String.valueOf(((StringBuilder)object2).toString());
        } else {
            l22 = 0;
            object2 = null;
        }
        l29 = l27 & l32;
        bl3 = l29 == l26 ? 0 : (l29 < l26 ? -1 : 1);
        if (bl3) {
            if (bl2) {
                object2 = "@string/edit_download";
            }
        } else {
            l22 = 0;
            object2 = null;
        }
        if (bl3 = (l20 = (l29 = 0x2C2L & l27) - l26) == 0L ? 0 : (l20 < 0L ? -1 : 1)) {
            if (bl5) {
                object2 = "@string/comm_apply";
            }
        } else {
            l22 = 0;
            object2 = null;
        }
        if ((n13 = (int)((l19 = (l24 = l27 & 0x302L) - l26) == 0L ? 0 : (l19 < 0L ? -1 : 1))) != 0) {
            checkBox = vb2.a;
            CompoundButtonBindingAdapter.setChecked((CompoundButton)checkBox, bl4);
        }
        if ((n13 = (int)((l18 = (l17 = 0x220L & l27) - l26) == 0L ? 0 : (l18 < 0L ? -1 : 1))) != 0) {
            checkBox = vb2.a;
            checkBox.setVisibility(n14);
            vb2.e.setVisibility(n11);
            object4 = vb2.h;
            object4.setVisibility(n11);
        }
        if ((n14 = (int)((l16 = (l15 = 0x200L & l27) - l26) == 0L ? 0 : (l16 < 0L ? -1 : 1))) != 0) {
            object4 = vb2.b;
            bl6 = vb2.n;
            object4.setOnClickListener((View.OnClickListener)bl6);
        }
        if ((n14 = (int)((l14 = (l15 = l27 & l39) - l26) == 0L ? 0 : (l14 < 0L ? -1 : 1))) != 0) {
            object4 = vb2.b;
            ImageViewBindingAdapter.setImageDrawable((ImageView)object4, (Drawable)object3);
        }
        if ((n12 = (int)((l13 = (l12 = 0x202L & l27) - l26) == 0L ? 0 : (l13 < 0L ? -1 : 1))) != 0) {
            object3 = vb2.c;
            object4 = object3.getContext();
            n11 = 2131231800;
            Drawable drawable2 = AppCompatResources.getDrawable((Context)object4, n11);
            boolean bl8 = true;
            d.v.l.g.a.b((ImageView)object3, string2, null, drawable2, 0, bl8, false, null, null, null);
            vb2.d.setVisibility(n15);
            object3 = vb2.f;
            n14 = 0;
            object4 = null;
            u.n((TextView)object3, (String)charSequence, null, null);
            object3 = vb2.g;
            u.n((TextView)object3, string3, null, null);
        }
        if ((l11 = (l10 = (l27 &= l31) - l26) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            progressBar = vb2.e;
            progressBar.setProgress((int)object5);
        }
        if (bl3) {
            progressBar = vb2.h;
            u.n((TextView)progressBar, (String)object2, null, null);
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
            this.o = l10 = 512L;
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
                return this.I((MutableLiveData)object, n11);
            }
            object = (q)object;
            return this.G((q)object, n11);
        }
        object = (MutableLiveData)object;
        return this.H((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 94;
        if (n11 == n10) {
            object = (q)object;
            this.C((q)object);
            return 1 != 0;
        } else {
            n11 = 101;
            if (n11 == n10) {
                object = (Integer)object;
                this.E((Integer)object);
                return 1 != 0;
            } else {
                n11 = 95;
                if (n11 == n10) {
                    object = (MusicListViewModel)object;
                    this.D((MusicListViewModel)object);
                    return 1 != 0;
                } else {
                    n11 = 146;
                    if (n11 != n10) return 0 != 0;
                    object = (Boolean)object;
                    this.F((Boolean)object);
                }
            }
        }
        return 1 != 0;
    }
}

