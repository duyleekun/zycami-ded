/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.HorizontalScrollView
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.voice.record.EditorRecordFragment$b;
import com.zhiyun.cama.voice.record.widget.RecorderView;
import com.zhiyun.cama.voice.record.widget.RecordingThumbView;
import com.zhiyun.cama.widget.ZYTextView;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.i1.i2;
import d.v.c.q0.f.a;
import d.v.c.w0.j4;
import d.v.c.w0.l7;
import d.v.c.y1.g.l;
import d.v.e.l.l2;
import l.a.q.g0.u;

public class m7
extends l7
implements b$a {
    private static final ViewDataBinding$IncludedLayouts r;
    private static final SparseIntArray s;
    private final ConstraintLayout n;
    private final ZYTextView o;
    private final View.OnClickListener p;
    private long q;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        r = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(12);
        String[] stringArray = new String[]{"editor_bottom_choice_layout"};
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = 5;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558529;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        s = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131363316, 6);
        viewDataBinding$IncludedLayouts.put(2131362843, 7);
        viewDataBinding$IncludedLayouts.put(2131362840, 8);
        viewDataBinding$IncludedLayouts.put(2131363089, 9);
        viewDataBinding$IncludedLayouts.put(2131363147, 10);
        viewDataBinding$IncludedLayouts.put(2131363695, 11);
    }

    public m7(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = r;
        SparseIntArray sparseIntArray = s;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 12, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private m7(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[5];
        object2 = (j4)object;
        Object object3 = object = objectArray[3];
        object3 = (ImageView)object;
        Object object4 = object = objectArray[8];
        object4 = (LinearLayout)object;
        Object object5 = object = objectArray[7];
        object5 = (HorizontalScrollView)object;
        Object object6 = object = objectArray[9];
        object6 = (RecorderView)((Object)object);
        Object object7 = object = objectArray[10];
        object7 = (RecyclerView)object;
        Object object8 = object = objectArray[6];
        object8 = (RecordingThumbView)object;
        int n10 = 1;
        Object object9 = object = objectArray[n10];
        object9 = (ZYTextView)object;
        Object object10 = object = objectArray[2];
        object10 = (ZYTextView)object;
        Object object11 = object = objectArray[11];
        object11 = (View)object;
        object = this;
        super(dataBindingComponent, view, 5, (j4)object2, (ImageView)object3, (LinearLayout)object4, (HorizontalScrollView)object5, (RecorderView)((Object)object6), (RecyclerView)object7, (RecordingThumbView)object8, (ZYTextView)object9, (ZYTextView)object10, (View)object11);
        this.q = -1;
        object = this.a;
        this.setContainedBinding((ViewDataBinding)object);
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.n = object;
        object.setTag(null);
        object = (ZYTextView)objectArray[4];
        this.o = object;
        object.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, n10);
        this.p = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean E(j4 j42, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.q;
                long l11 = 4;
                this.q = l10 |= l11;
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
                long l10 = this.q;
                long l11 = 2;
                this.q = l10 |= l11;
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
    private boolean G(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.q;
                long l11 = 8;
                this.q = l10 |= l11;
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
    private boolean H(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.q;
                long l11 = 16;
                this.q = l10 |= l11;
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
                long l10 = this.q;
                long l11 = 1L;
                this.q = l10 |= l11;
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
    public void B(EditorRecordFragment$b editorRecordFragment$b) {
        this.m = editorRecordFragment$b;
        synchronized (this) {
            long l10 = this.q;
            long l11 = 64;
            this.q = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(i2 i22) {
        this.l = i22;
        synchronized (this) {
            long l10 = this.q;
            long l11 = 128L;
            this.q = l10 |= l11;
        }
        this.notifyPropertyChanged(49);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(l l10) {
        this.k = l10;
        synchronized (this) {
            long l11 = this.q;
            long l12 = 32;
            this.q = l11 |= l12;
        }
        this.notifyPropertyChanged(108);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        EditorRecordFragment$b editorRecordFragment$b = this.m;
        boolean bl2 = editorRecordFragment$b != null;
        if (bl2) {
            editorRecordFragment$b.h();
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
        Object object2;
        int n10;
        MutableLiveData mutableLiveData;
        int n11;
        long l15;
        int n12;
        int n13;
        long l16;
        long l17;
        m7 m72 = this;
        synchronized (this) {
            l17 = this.q;
            this.q = l16 = 0L;
        }
        Object object3 = this.k;
        Object object4 = this.m;
        Object object5 = this.l;
        long l18 = 0x131L & l17;
        Object object6 = l18 == l16 ? 0 : (l18 < l16 ? -1 : 1);
        long l19 = 304L;
        long l20 = 289L;
        int n14 = 1;
        float f10 = Float.MIN_VALUE;
        int n15 = 0;
        float f11 = 0.0f;
        if (object6 != false) {
            long l21 = l17 & l20;
            long l22 = l21 - l16;
            object6 = l22 == 0L ? 0 : (l22 < 0L ? -1 : 1);
            if (object6 != false) {
                Object object7;
                if (object3 != null) {
                    MutableLiveData mutableLiveData2 = ((l)object3).d();
                    object7 = mutableLiveData2;
                } else {
                    n13 = 0;
                    object7 = null;
                }
                m72.updateLiveDataRegistration(0, (LiveData)object7);
                if (object7 != null) {
                    object7 = (Integer)((LiveData)object7).getValue();
                } else {
                    n13 = 0;
                    object7 = null;
                }
                n13 = ViewDataBinding.safeUnbox((Integer)object7);
                n12 = n13 != 0 ? n14 : 0;
                n15 = 2;
                f11 = 2.8E-45f;
                if (n13 == n15) {
                    n15 = n14;
                    f11 = f10;
                } else {
                    n15 = 0;
                    f11 = 0.0f;
                }
                if (object6 != false) {
                    l15 = n15 != 0 ? 1024L : 512L;
                    l17 |= l15;
                }
                if (n15 != 0) {
                    n15 = 0;
                    f11 = 0.0f;
                } else {
                    n15 = 8;
                    f11 = 1.1E-44f;
                }
                n11 = n15;
                n15 = n13;
            } else {
                n15 = 0;
                f11 = 0.0f;
                n12 = 0;
                n11 = 0;
                mutableLiveData = null;
            }
            l15 = l17 & l19;
            object6 = l15 == l16 ? 0 : (l15 < l16 ? -1 : 1);
            if (object6 != false) {
                if (object3 != null) {
                    object3 = ((l)object3).c();
                } else {
                    n10 = 0;
                    object3 = null;
                }
                object6 = 4;
                m72.updateLiveDataRegistration((int)object6, (LiveData)object3);
                if (object3 != null) {
                    object3 = (Integer)((LiveData)object3).getValue();
                } else {
                    n10 = 0;
                    object3 = null;
                }
                n10 = ViewDataBinding.safeUnbox((Integer)object3);
                object3 = String.valueOf(n10);
                object6 = n12;
                n13 = n11;
            } else {
                object6 = n12;
                n13 = n11;
                n10 = 0;
                object3 = null;
            }
        } else {
            n10 = 0;
            object3 = null;
            object6 = 0;
            n15 = 0;
            f11 = 0.0f;
            n13 = 0;
            Object var23_18 = null;
        }
        long l23 = l17 & 0x140L;
        n12 = l23 == l16 ? 0 : (l23 < l16 ? -1 : 1);
        long l24 = l17 & 0x18AL;
        n11 = l24 == l16 ? 0 : (l24 < l16 ? -1 : 1);
        l15 = 392L;
        long l25 = 386L;
        if (n11 != 0) {
            long l26 = l17 & l25;
            long l27 = l26 - l16;
            n11 = (int)(l27 == 0L ? 0 : (l27 < 0L ? -1 : 1));
            if (n11 != 0) {
                if (object5 != null) {
                    mutableLiveData = ((i2)object5).T0();
                    object2 = mutableLiveData;
                } else {
                    object2 = null;
                }
                m72.updateLiveDataRegistration(n14, (LiveData)object2);
                object2 = object2 != null ? (Long)((LiveData)object2).getValue() : null;
                l19 = ViewDataBinding.safeUnbox((Long)object2);
                object2 = l2.e(l19);
                object = new StringBuilder();
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append(" / ");
                object2 = ((StringBuilder)object).toString();
            } else {
                object2 = null;
            }
            long l28 = l17 & l15;
            long l29 = l28 == l16 ? 0 : (l28 < l16 ? -1 : 1);
            if (l29 != false) {
                object5 = object5 != null ? ((i2)object5).c2() : null;
                l29 = 3;
                m72.updateLiveDataRegistration((int)l29, (LiveData)object5);
                object5 = object5 != null ? (Long)((LiveData)object5).getValue() : null;
                l28 = ViewDataBinding.safeUnbox((Long)object5);
                object5 = l2.e(l28);
            } else {
                object5 = null;
            }
        } else {
            object5 = null;
            object2 = null;
        }
        if (n12 != 0) {
            object = m72.a;
            ((j4)object).z((a)object4);
        }
        if ((l14 = (l13 = (l12 = l17 & l20) - l16) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
            m72.b.setImageLevel(n15);
            object4 = m72.b;
            object = m72.p;
            ViewBindingAdapter.setOnClick((View)object4, (View.OnClickListener)object, (boolean)object6);
            object4 = m72.o;
            object4.setVisibility(n13);
        }
        if ((l14 = (l11 = (l12 = 0x130L & l17) - l16) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            object4 = m72.o;
            object6 = 0;
            u.n((TextView)object4, (String)object3, null, null);
        } else {
            object6 = 0;
        }
        l12 = l17 & l25;
        n10 = (int)(l12 == l16 ? 0 : (l12 < l16 ? -1 : 1));
        if (n10 != 0) {
            object3 = m72.h;
            u.n((TextView)object3, (String)object2, null, null);
        }
        if ((n10 = (int)((l10 = (l17 &= l15) - l16) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0) {
            object3 = m72.i;
            u.n((TextView)object3, (String)object5, null, null);
        }
        ViewDataBinding.executeBindingsOn(m72.a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.q;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            boolean bl2 = true;
            if (l12 != false) {
                return bl2;
            }
            j4 j42 = this.a;
            l12 = (long)j42.hasPendingBindings();
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
            this.q = l10 = 256L;
        }
        this.a.invalidateAll();
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
                        n12 = 4;
                        if (n10 != n12) {
                            return false;
                        }
                        object = (MutableLiveData)object;
                        return this.H((MutableLiveData)object, n11);
                    }
                    object = (MutableLiveData)object;
                    return this.G((MutableLiveData)object, n11);
                }
                object = (j4)object;
                return this.E((j4)object, n11);
            }
            object = (MutableLiveData)object;
            return this.F((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.I((MutableLiveData)object, n11);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.a.setLifecycleOwner(lifecycleOwner);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 108;
        if (n11 == n10) {
            object = (l)object;
            this.D((l)object);
            return 1 != 0;
        } else {
            n11 = 25;
            if (n11 == n10) {
                object = (EditorRecordFragment$b)object;
                this.B((EditorRecordFragment$b)object);
                return 1 != 0;
            } else {
                n11 = 49;
                if (n11 != n10) return 0 != 0;
                object = (i2)object;
                this.C((i2)object);
            }
        }
        return 1 != 0;
    }
}

