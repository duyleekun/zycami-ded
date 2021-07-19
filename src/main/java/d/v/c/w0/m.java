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
 *  android.widget.SeekBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter$OnProgressChanged;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.main.EditorMainActivity$b;
import com.zhiyun.cama.widget.ZYTextView;
import com.zhiyun.editorsdk.fundation.PlayerWrapperView;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.f1.a.g;
import d.v.c.f1.a.g$a;
import d.v.c.i1.i2;
import d.v.c.w0.k;
import d.v.c.w0.ui;
import d.v.e.l.l2;
import l.a.q.g0.u;

public class m
extends k
implements g$a,
b$a {
    private static final ViewDataBinding$IncludedLayouts x;
    private static final SparseIntArray y;
    private final SeekBarBindingAdapter$OnProgressChanged s;
    private final View.OnClickListener t;
    private final View.OnClickListener u;
    private final View.OnClickListener v;
    private long w;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        x = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(9);
        String[] stringArray = new String[]{"widget_titlebar"};
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = 7;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558815;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        y = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131362995, 8);
    }

    public m(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = x;
        SparseIntArray sparseIntArray = y;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 9, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private m(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = this;
        Object object3 = object = objectArray[2];
        object3 = (ImageView)object;
        Object object4 = object = objectArray[3];
        object4 = (ZYTextView)object;
        Object object5 = object = objectArray[8];
        object5 = (PlayerWrapperView)((Object)object);
        Object object6 = object = objectArray[5];
        object6 = (ZYTextView)object;
        Object object7 = object = objectArray[0];
        object7 = (ConstraintLayout)((Object)object);
        Object object8 = object = objectArray[4];
        object8 = (AppCompatSeekBar)((Object)object);
        Object object9 = object = objectArray[7];
        object9 = (ui)object;
        Object object10 = object = objectArray[1];
        object10 = (ImageView)object;
        Object object11 = object = objectArray[6];
        object11 = (ImageView)object;
        super(dataBindingComponent, view, 5, null, null, null, null, null, null, (ImageView)object3, (ZYTextView)object4, (PlayerWrapperView)((Object)object5), (ZYTextView)object6, (ConstraintLayout)((Object)object7), null, (AppCompatSeekBar)((Object)object8), (ui)object9, (ImageView)object10, (ImageView)object11);
        this.w = -1;
        this.g.setTag(null);
        this.h.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.m.setTag(null);
        object2 = this.n;
        this.setContainedBinding((ViewDataBinding)object2);
        this.o.setTag(null);
        this.p.setTag(null);
        object2 = view;
        this.setRootTag(view);
        this.s = object2 = new g(this, 3);
        object2 = new b(this, 4);
        this.t = object2;
        object2 = new b(this, 1);
        this.u = object2;
        object2 = new b(this, 2);
        this.v = object2;
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
                long l10 = this.w;
                long l11 = 1L;
                this.w = l10 |= l11;
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
                long l10 = this.w;
                long l11 = 8;
                this.w = l10 |= l11;
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
                long l10 = this.w;
                long l11 = 2;
                this.w = l10 |= l11;
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
                long l10 = this.w;
                long l11 = 16;
                this.w = l10 |= l11;
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
    private boolean G(ui ui2, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.w;
                long l11 = 4;
                this.w = l10 |= l11;
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
    public void A(EditorMainActivity$b editorMainActivity$b) {
        this.r = editorMainActivity$b;
        synchronized (this) {
            long l10 = this.w;
            long l11 = 64;
            this.w = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(i2 i22) {
        this.q = i22;
        synchronized (this) {
            long l10 = this.w;
            long l11 = 32;
            this.w = l10 |= l11;
        }
        this.notifyPropertyChanged(50);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 4;
                if (n10 == n13) {
                    EditorMainActivity$b editorMainActivity$b = this.r;
                    if (editorMainActivity$b != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        editorMainActivity$b.i();
                    }
                }
            } else {
                i2 i22 = this.q;
                if (i22 != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    i22.K3();
                }
            }
        } else {
            i2 i23 = this.q;
            if (i23 != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                i23.K3();
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
        long l14;
        Object object;
        boolean bl2;
        long l15;
        long l16;
        Object object2;
        int n10;
        Object object3;
        long l17;
        long l18;
        m m10 = this;
        synchronized (this) {
            l18 = this.w;
            this.w = l17 = 0L;
        }
        Object object4 = this.q;
        EditorMainActivity$b editorMainActivity$b = this.r;
        long l19 = 0xBBL & l18;
        Object object5 = l19 == l17 ? 0 : (l19 < l17 ? -1 : 1);
        long l20 = 168L;
        long l21 = 162L;
        long l22 = 161L;
        int n11 = 0;
        float f10 = 0.0f;
        Object object6 = null;
        if (object5 != false) {
            long l23;
            float f11;
            Context context;
            float f12;
            int n12;
            float f13;
            MutableLiveData mutableLiveData;
            long l24 = l18 & l22;
            long l25 = l24 - l17;
            object5 = l25 == 0L ? 0 : (l25 < 0L ? -1 : 1);
            if (object5 != false) {
                if (object4 != null) {
                    object3 = ((i2)object4).T0();
                } else {
                    object5 = 0;
                    object3 = null;
                }
                m10.updateLiveDataRegistration(0, (LiveData)object3);
                if (object3 != null) {
                    object3 = (Long)((LiveData)object3).getValue();
                } else {
                    object5 = 0;
                    object3 = null;
                }
                l24 = ViewDataBinding.safeUnbox((Long)object3);
                object3 = l2.d(l24);
            } else {
                object5 = 0;
                object3 = null;
            }
            l24 = l18 & l21;
            long l26 = l24 == l17 ? 0 : (l24 < l17 ? -1 : 1);
            if (l26 != false) {
                if (object4 != null) {
                    mutableLiveData = ((i2)object4).L1();
                    object6 = mutableLiveData;
                } else {
                    n11 = 0;
                    object6 = null;
                    f10 = 0.0f;
                }
                n10 = 1;
                f13 = Float.MIN_VALUE;
                m10.updateLiveDataRegistration(n10, (LiveData)object6);
                if (object6 != null) {
                    object6 = (Float)((LiveData)object6).getValue();
                } else {
                    n11 = 0;
                    object6 = null;
                    f10 = 0.0f;
                }
                f10 = ViewDataBinding.safeUnbox((Float)object6);
                n10 = 1120403456;
                f13 = 100.0f;
                n11 = (int)(f10 *= f13);
            } else {
                n11 = 0;
                f10 = 0.0f;
                object6 = null;
            }
            l21 = l18 & l20;
            n10 = l21 == l17 ? 0 : (l21 < l17 ? -1 : 1);
            if (n10 != 0) {
                if (object4 != null) {
                    object2 = ((i2)object4).x1();
                } else {
                    n12 = 0;
                    object2 = null;
                    f12 = 0.0f;
                }
                l16 = 3;
                m10.updateLiveDataRegistration((int)l16, (LiveData)object2);
                if (object2 != null) {
                    object2 = (Boolean)((LiveData)object2).getValue();
                } else {
                    n12 = 0;
                    object2 = null;
                    f12 = 0.0f;
                }
                n12 = ViewDataBinding.safeUnbox((Boolean)object2);
                if (n10 != 0) {
                    if (n12 != 0) {
                        l18 |= 0x200L;
                        l22 = 2048L;
                    } else {
                        l18 |= 0x100L;
                        l22 = 1024L;
                    }
                    l18 |= l22;
                }
                context = m10.g.getContext();
                l16 = n12 != 0 ? (long)2131231061 : (long)2131231060;
                context = AppCompatResources.getDrawable(context, (int)l16);
                if (n12 != 0) {
                    n12 = 8;
                    f12 = 1.1E-44f;
                    l26 = n12;
                    f11 = f12;
                } else {
                    l26 = 0;
                    f11 = 0.0f;
                    mutableLiveData = null;
                }
                l23 = 176L;
            } else {
                n10 = 0;
                context = null;
                f13 = 0.0f;
                l23 = 176L;
                l26 = 0;
                f11 = 0.0f;
                mutableLiveData = null;
            }
            l15 = l18 & l23;
            n12 = l15 == l17 ? 0 : (l15 < l17 ? -1 : 1);
            if (n12 != 0) {
                if (object4 != null) {
                    object4 = ((i2)object4).c2();
                } else {
                    bl2 = false;
                    object4 = null;
                }
                n12 = 4;
                f12 = 5.6E-45f;
                m10.updateLiveDataRegistration(n12, (LiveData)object4);
                if (object4 != null) {
                    object4 = (Long)((LiveData)object4).getValue();
                } else {
                    bl2 = false;
                    object4 = null;
                }
                l23 = ViewDataBinding.safeUnbox((Long)object4);
                object4 = l2.d(l23);
            } else {
                bl2 = false;
                object4 = null;
            }
            object2 = context;
            n10 = n11;
            n11 = (int)l26;
            f10 = f11;
        } else {
            bl2 = false;
            object4 = null;
            object5 = 0;
            object3 = null;
            boolean bl3 = false;
            object2 = null;
            float f14 = 0.0f;
            n11 = 0;
            f10 = 0.0f;
            object6 = null;
            n10 = 0;
            float f15 = 0.0f;
            Object var31_28 = null;
        }
        l22 = 0xC0L & l18;
        l16 = l22 == l17 ? 0 : (l22 < l17 ? -1 : 1);
        l15 = l18 & 0x80L;
        long l27 = l15 == l17 ? 0 : (l15 < l17 ? -1 : 1);
        if (l27 != false) {
            ImageView imageView = m10.g;
            object = m10.v;
            imageView.setOnClickListener(object);
            object = m10.m;
            SeekBarBindingAdapter$OnProgressChanged seekBarBindingAdapter$OnProgressChanged = m10.s;
            SeekBarBindingAdapter.setOnSeekBarChangeListener((SeekBar)object, null, null, seekBarBindingAdapter$OnProgressChanged, null);
            object = m10.o;
            seekBarBindingAdapter$OnProgressChanged = m10.u;
            object.setOnClickListener((View.OnClickListener)seekBarBindingAdapter$OnProgressChanged);
            object = m10.p;
            seekBarBindingAdapter$OnProgressChanged = m10.t;
            object.setOnClickListener((View.OnClickListener)seekBarBindingAdapter$OnProgressChanged);
        }
        if ((l14 = (l13 = (l17 = l18 & l20) - (l20 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
            ImageViewBindingAdapter.setImageDrawable(m10.g, (Drawable)object2);
            object = m10.o;
            object.setVisibility(n11);
        }
        if ((l14 = (l12 = (l17 = 0xA1L & l18) - l20) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            object = m10.h;
            l.a.q.g0.u.n((TextView)object, (String)object3, null, null);
        }
        if ((l14 = (l11 = (l17 = 0xB0L & l18) - l20) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            object = m10.j;
            l.a.q.g0.u.n((TextView)object, (String)object4, null, null);
        }
        if (bl2 = (l10 = (l18 &= (l17 = 162L)) - l20) == 0L ? 0 : (l10 < 0L ? -1 : 1)) {
            object4 = m10.m;
            SeekBarBindingAdapter.setProgress((SeekBar)object4, n10);
        }
        if (l16 != false) {
            object4 = m10.n;
            ((ui)object4).z(editorMainActivity$b);
        }
        ViewDataBinding.executeBindingsOn(m10.n);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.w;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            boolean bl2 = true;
            if (l12 != false) {
                return bl2;
            }
            ui ui2 = this.n;
            l12 = (long)ui2.hasPendingBindings();
            if (l12 != false) {
                return bl2;
            }
            return false;
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
            this.w = l10 = 128L;
        }
        this.n.invalidateAll();
        this.requestRebind();
    }

    public final void n(int n10, SeekBar seekBar, int n11, boolean bl2) {
        EditorMainActivity$b editorMainActivity$b = this.r;
        boolean bl3 = editorMainActivity$b != null;
        if (bl3) {
            editorMainActivity$b.h(seekBar, n11, bl2);
        }
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                n12 = 2;
                if (n10 != n12) {
                    n12 = 3;
                    if (n10 != n12) {
                        n12 = 4;
                        if (n10 != n12) {
                            return false;
                        }
                        object = (MutableLiveData)object;
                        return this.F((MutableLiveData)object, n11);
                    }
                    object = (MutableLiveData)object;
                    return this.D((MutableLiveData)object, n11);
                }
                object = (ui)object;
                return this.G((ui)object, n11);
            }
            object = (MutableLiveData)object;
            return this.E((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.C((MutableLiveData)object, n11);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.n.setLifecycleOwner(lifecycleOwner);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 50;
        if (n11 == n10) {
            object = (i2)object;
            this.B((i2)object);
            return 1 != 0;
        } else {
            n11 = 25;
            if (n11 != n10) return 0 != 0;
            object = (EditorMainActivity$b)object;
            this.A((EditorMainActivity$b)object);
        }
        return 1 != 0;
    }
}

