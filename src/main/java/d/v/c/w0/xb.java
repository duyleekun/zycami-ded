/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckedTextView
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckedTextView;
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
import com.zhiyun.cama.voice.music.MusicPlayVieModel;
import com.zhiyun.cama.voice.music.mine.MusicLocalImportViewModel;
import com.zhiyun.cama.widget.RoundImageView;
import com.zhiyun.cama.widget.ZYTextView;
import d.v.c.f1.a.b$a;
import d.v.c.k1.b.a;
import d.v.c.w0.wb;
import d.v.c.y1.f.q;
import d.v.e.l.c2;
import d.v.e.l.l2;
import l.a.q.g0.u;

public class xb
extends wb
implements b$a {
    private static final ViewDataBinding$IncludedLayouts n;
    private static final SparseIntArray o;
    private final ConstraintLayout h;
    private final ImageView i;
    private final CheckedTextView j;
    private final View.OnClickListener k;
    private final View.OnClickListener l;
    private long m;

    public xb(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = n;
        SparseIntArray sparseIntArray = o;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 7, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private xb(DataBindingComponent object, View object2, Object[] checkedTextView) {
        Object object3;
        int n10 = 1;
        Object object4 = object3 = checkedTextView[n10];
        object4 = (RoundImageView)object3;
        Object object5 = object3 = checkedTextView[5];
        object5 = (TextView)object3;
        Object object6 = object3 = checkedTextView[3];
        object6 = (TextView)object3;
        Object object7 = object3 = checkedTextView[4];
        object7 = (ZYTextView)object3;
        xb xb2 = this;
        super(object, (View)object2, 3, (RoundImageView)object4, (TextView)object5, (TextView)object6, (ZYTextView)object7);
        this.m = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)checkedTextView[0]);
        this.h = object;
        object.setTag(null);
        int n11 = 2;
        xb2 = (ImageView)checkedTextView[n11];
        this.i = xb2;
        xb2.setTag(null);
        this.j = checkedTextView = (CheckedTextView)checkedTextView[6];
        checkedTextView.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.setRootTag((View)object2);
        super(this, n10);
        this.k = object2;
        super(this, n11);
        this.l = object2;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean E(MutableLiveData mutableLiveData, int n10) {
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
    private boolean F(MutableLiveData mutableLiveData, int n10) {
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
    private boolean G(q q10, int n10) {
        boolean bl2 = true;
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.m;
                long l11 = 1L;
                this.m = l10 |= l11;
                return bl2;
            }
        }
        int n11 = 93;
        if (n10 == n11) {
            synchronized (this) {
                long l12 = this.m;
                long l13 = 32;
                this.m = l12 |= l13;
                return bl2;
            }
        }
        n11 = 92;
        if (n10 == n11) {
            synchronized (this) {
                long l14 = this.m;
                long l15 = 64;
                this.m = l14 |= l15;
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
    public void B(MusicLocalImportViewModel musicLocalImportViewModel) {
        this.g = musicLocalImportViewModel;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 16;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(82);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(q q10) {
        this.updateRegistration(0, q10);
        this.e = q10;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 1L;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(94);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(Integer n10) {
        this.f = n10;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 8;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(101);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        view = null;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 == n13) {
                q q10 = this.e;
                MusicLocalImportViewModel musicLocalImportViewModel = this.g;
                if (musicLocalImportViewModel != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    musicLocalImportViewModel.Y(q10);
                }
            }
        } else {
            q q11 = this.e;
            Integer n14 = this.f;
            MusicLocalImportViewModel musicLocalImportViewModel = this.g;
            if (musicLocalImportViewModel != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                view = this.getRoot().getContext();
                n12 = n14;
                musicLocalImportViewModel.k((Context)view, q11, n12);
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
        Object object;
        long l13;
        int n10;
        int n11;
        Object object2;
        MutableLiveData mutableLiveData;
        String string2;
        boolean bl2;
        Context context;
        Object object3;
        boolean bl3;
        CharSequence charSequence;
        Object object4;
        long l14;
        double d10;
        long l15;
        long l16;
        xb xb2 = this;
        synchronized (this) {
            l16 = this.m;
            l15 = 0L;
            d10 = 0.0;
            this.m = l15;
        }
        Object object5 = this.e;
        Integer n12 = this.f;
        Object object6 = this.g;
        long l17 = 0xE1L & l16;
        Object object7 = l17 == l15 ? 0 : (l17 < l15 ? -1 : 1);
        long l18 = 193L;
        long l19 = 129L;
        int n13 = 1;
        if (object7 != false) {
            String string3;
            long l20;
            String string4;
            l14 = l16 & l19;
            long l21 = l14 - l15;
            object7 = l21 == 0L ? 0 : (l21 < 0L ? -1 : 1);
            if (object7 != false) {
                double d11;
                long l22;
                String string5;
                if (object5 != null) {
                    object4 = ((q)object5).G();
                } else {
                    object7 = 0;
                    object4 = null;
                }
                if (object4 != null) {
                    charSequence = ((a)object4).i();
                    string4 = ((a)object4).e();
                    l20 = ((a)object4).c();
                    long l23 = ((a)object4).h();
                    string5 = charSequence;
                    l22 = l23;
                } else {
                    l22 = l15;
                    d11 = d10;
                    l20 = l15;
                    string4 = null;
                    string5 = null;
                }
                object4 = l2.d(l20);
                d11 = l22;
                string3 = c2.b(d11, n13);
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)object4);
                ((StringBuilder)charSequence).append("/");
                object4 = ((StringBuilder)charSequence).toString();
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)object4);
                ((StringBuilder)charSequence).append(string3);
                object4 = String.valueOf(((StringBuilder)charSequence).toString());
                charSequence = string5;
            } else {
                object7 = 0;
                object4 = null;
                charSequence = null;
                string4 = null;
            }
            l20 = l16 & l18;
            bl3 = l20 == l15 ? 0 : (l20 < l15 ? -1 : 1);
            if (bl3 && object5 != null) {
                bl3 = ((q)object5).H();
            } else {
                bl3 = false;
                string3 = null;
            }
            long l24 = 161L;
            l20 = l16 & l24;
            long l25 = l20 == l15 ? 0 : (l20 < l15 ? -1 : 1);
            if (l25 != false) {
                if (object5 != null) {
                    object3 = ((q)object5).I();
                } else {
                    object3 = 0;
                    object5 = null;
                }
                if (l25 != false) {
                    if (object3 != 0) {
                        l16 |= 0x800L;
                        l20 = 8192L;
                    } else {
                        l16 |= 0x400L;
                        l20 = 4096L;
                    }
                    l16 |= l20;
                }
                l25 = object3 ^ 1;
                if (object3 != 0) {
                    context = null;
                } else {
                    context = xb2.j.getContext();
                    bl2 = 2131231933 != 0;
                    context = AppCompatResources.getDrawable(context, (int)(bl2 ? 1 : 0));
                }
                object5 = object3 != 0 ? "@string/edit_import" : "";
                string2 = string4;
                bl2 = (boolean)l25;
            } else {
                bl2 = false;
                string2 = string4;
                object3 = 0;
                object5 = null;
                context = null;
            }
        } else {
            bl3 = false;
            Object var33_23 = null;
            bl2 = false;
            object3 = 0;
            object5 = null;
            object7 = 0;
            object4 = null;
            charSequence = null;
            context = null;
            string2 = null;
        }
        l14 = 158L;
        long l26 = l16 & l14;
        long l27 = l26 == l15 ? 0 : (l26 < l15 ? -1 : 1);
        if (l27 != false) {
            if (object6 != null) {
                mutableLiveData = ((MusicPlayVieModel)object6).b();
                object2 = ((MusicPlayVieModel)object6).c();
                object6 = mutableLiveData;
            } else {
                n11 = 0;
                object2 = null;
                n10 = 0;
                object6 = null;
            }
            xb2.updateLiveDataRegistration(n13, (LiveData)object6);
            l13 = 2;
            xb2.updateLiveDataRegistration((int)l13, (LiveData)object2);
            if (object6 != null) {
                object = (Boolean)((LiveData)object6).getValue();
            } else {
                l13 = 0;
                object = null;
            }
            if (object2 != null) {
                object2 = (Integer)((LiveData)object2).getValue();
            } else {
                n11 = 0;
                object2 = null;
            }
            l13 = (long)ViewDataBinding.safeUnbox((Boolean)object);
            if (n12 != object2) {
                n13 = 0;
            }
            n11 = n13 & l13;
            if (l27 != false) {
                l12 = n11 != 0 ? 512L : 256L;
                l16 |= l12;
            }
            if (n11 != 0) {
                object2 = xb2.i.getContext();
                l13 = 2131231061;
            } else {
                object2 = xb2.i.getContext();
                l13 = 2131231060;
            }
            object2 = AppCompatResources.getDrawable((Context)object2, (int)l13);
        } else {
            n11 = 0;
            object2 = null;
        }
        l12 = l16 & l19;
        l19 = 0L;
        l13 = l12 == l19 ? 0 : (l12 < l19 ? -1 : 1);
        if (l13 != false) {
            object = xb2.a;
            mutableLiveData = null;
            n12 = object.getContext();
            n10 = 2131231800;
            Drawable drawable2 = AppCompatResources.getDrawable((Context)n12, n10);
            boolean bl4 = true;
            d.v.l.g.a.b((ImageView)object, string2, null, drawable2, 0, bl4, false, null, null, null);
            object = xb2.c;
            n12 = null;
            u.n((TextView)object, (String)charSequence, null, null);
            object = xb2.d;
            u.n((TextView)object, (String)object4, null, null);
        }
        if ((l13 = (l11 = (l12 = 0x80L & l16) - (l19 = 0L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            object = xb2.i;
            n12 = xb2.k;
            object.setOnClickListener((View.OnClickListener)n12);
        }
        if ((l13 = (l10 = (l12 = l16 & l14) - l19) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            object = xb2.i;
            ImageViewBindingAdapter.setImageDrawable((ImageView)object, (Drawable)object2);
        }
        d10 = 7.95E-322;
        l15 = 0xA1L & l16;
        long l28 = l15 - l19;
        n11 = (int)(l28 == 0L ? 0 : (l28 < 0L ? -1 : 1));
        if (n11 != 0) {
            ViewBindingAdapter.setBackground((View)xb2.j, (Drawable)context);
            object2 = xb2.j;
            object = xb2.l;
            ViewBindingAdapter.setOnClick((View)object2, (View.OnClickListener)object, bl2);
            object2 = xb2.b;
            l13 = 0;
            object = null;
            u.n((TextView)object2, (String)object5, null, null);
        }
        l15 = 0L;
        d10 = 0.0;
        long l29 = (l16 &= 0xC1L) - l15;
        object3 = l29 == 0L ? 0 : (l29 < 0L ? -1 : 1);
        if (object3 == 0) return;
        object5 = xb2.j;
        object5.setChecked(bl3);
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
            this.m = l10 = 128L;
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
                return this.F((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.E((MutableLiveData)object, n11);
        }
        object = (q)object;
        return this.G((q)object, n11);
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
                this.D((Integer)object);
                return 1 != 0;
            } else {
                n11 = 82;
                if (n11 != n10) return 0 != 0;
                object = (MusicLocalImportViewModel)object;
                this.B((MusicLocalImportViewModel)object);
            }
        }
        return 1 != 0;
    }
}

