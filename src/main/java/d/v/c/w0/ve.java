/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.ScrollView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.data.api.entity.ProductEntity;
import com.zhiyun.cama.data.api.entity.ProductVersionEntity;
import com.zhiyun.cama.data.database.model.Feedback;
import com.zhiyun.cama.me.help.FeedbackEditFragment$c;
import com.zhiyun.cama.me.help.data.FeedbackSet$AdviceType;
import com.zhiyun.cama.me.help.data.FeedbackSet$Rate;
import com.zhiyun.cama.me.help.data.FeedbackSet$Type;
import com.zhiyun.cama.me.help.view.AddImageRecyclerView;
import com.zhiyun.cama.me.help.view.ScrollEditText;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.j1.a.o0;
import d.v.c.w0.ue;
import d.v.c.w0.ve$a;
import d.v.c.w0.ve$b;
import d.v.c.w0.ve$c;
import d.v.c.w0.ve$d;
import d.v.f.i.g;
import l.a.q.g0.u;

public class ve
extends ue
implements b$a {
    private static final ViewDataBinding$IncludedLayouts L;
    private static final SparseIntArray M;
    private final LinearLayout A;
    private final TextView B;
    private final TextView C;
    private final TextView D;
    private final View.OnClickListener E;
    private final View.OnClickListener F;
    private ve$d G;
    private ve$a H;
    private ve$b I;
    private ve$c J;
    private long K;
    private final LinearLayout r;
    private final LinearLayout s;
    private final TextView t;
    private final LinearLayout u;
    private final TextView v;
    private final TextView w;
    private final TextView x;
    private final TextView y;
    private final LinearLayout z;

    static {
        SparseIntArray sparseIntArray;
        M = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362498, 23);
        sparseIntArray.put(2131363615, 24);
        sparseIntArray.put(2131363272, 25);
        sparseIntArray.put(2131363144, 26);
        sparseIntArray.put(2131362368, 27);
    }

    public ve(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = L;
        SparseIntArray sparseIntArray = M;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 28, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private ve(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        ve ve2 = this;
        ve ve3 = this;
        Object object = dataBindingComponent;
        EditText editText = (EditText)objectArray[27];
        ScrollEditText scrollEditText = (ScrollEditText)objectArray[8];
        ScrollEditText scrollEditText2 = (ScrollEditText)objectArray[18];
        EditText editText2 = (EditText)objectArray[6];
        EditText editText3 = (EditText)objectArray[16];
        FrameLayout frameLayout = (FrameLayout)objectArray[23];
        ImageView imageView = (ImageView)objectArray[1];
        AddImageRecyclerView addImageRecyclerView = (AddImageRecyclerView)objectArray[26];
        ScrollView scrollView = (ScrollView)objectArray[25];
        TextView textView = (TextView)objectArray[4];
        TextView textView2 = (TextView)objectArray[21];
        TextView textView3 = (TextView)objectArray[22];
        TextView textView4 = (TextView)objectArray[11];
        TextView textView5 = (TextView)objectArray[14];
        TextView textView6 = (TextView)objectArray[24];
        int n10 = 5;
        super(dataBindingComponent, view, n10, editText, scrollEditText, scrollEditText2, editText2, editText3, frameLayout, imageView, addImageRecyclerView, scrollView, textView, textView2, textView3, textView4, textView5, textView6);
        this.K = -1;
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.g.setTag(null);
        ve3 = (LinearLayout)objectArray[0];
        this.r = ve3;
        ve3.setTag(null);
        ve3 = (LinearLayout)objectArray[10];
        this.s = ve3;
        ve3.setTag(null);
        ve3 = (TextView)objectArray[12];
        this.t = ve3;
        ve3.setTag(null);
        ve3 = (LinearLayout)objectArray[13];
        this.u = ve3;
        ve3.setTag(null);
        ve3 = (TextView)objectArray[15];
        this.v = ve3;
        ve3.setTag(null);
        ve3 = (TextView)objectArray[17];
        this.w = ve3;
        ve3.setTag(null);
        ve3 = (TextView)objectArray[19];
        this.x = ve3;
        ve3.setTag(null);
        int n11 = 2;
        ve2 = (TextView)objectArray[n11];
        this.y = ve2;
        ve2.setTag(null);
        ve2 = (LinearLayout)objectArray[20];
        this.z = ve2;
        ve2.setTag(null);
        ve2 = (LinearLayout)objectArray[3];
        this.A = ve2;
        ve2.setTag(null);
        ve2 = (TextView)objectArray[5];
        this.B = ve2;
        ve2.setTag(null);
        ve2 = (TextView)objectArray[7];
        this.C = ve2;
        ve2.setTag(null);
        ve2 = (TextView)objectArray[9];
        this.D = ve2;
        ve2.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        this.n.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, 1);
        this.E = object;
        object = new b(this, n11);
        this.F = object;
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
                long l10 = this.K;
                long l11 = 16;
                this.K = l10 |= l11;
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
                long l10 = this.K;
                long l11 = 4;
                this.K = l10 |= l11;
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
                long l10 = this.K;
                long l11 = 1L;
                this.K = l10 |= l11;
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
                long l10 = this.K;
                long l11 = 8;
                this.K = l10 |= l11;
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
                long l10 = this.K;
                long l11 = 2;
                this.K = l10 |= l11;
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
    public void A(FeedbackEditFragment$c feedbackEditFragment$c) {
        this.p = feedbackEditFragment$c;
        synchronized (this) {
            long l10 = this.K;
            long l11 = 32;
            this.K = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(o0 o02) {
        this.q = o02;
        synchronized (this) {
            long l10 = this.K;
            long l11 = 64;
            this.K = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        Feedback feedback = null;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 == n13) {
                FeedbackEditFragment$c feedbackEditFragment$c = this.p;
                Object object = this.q;
                int n14 = feedbackEditFragment$c != null ? n12 : 0;
                if (n14 != 0 && (n14 = object != null ? n12 : 0) != 0) {
                    object = ((o0)object).q;
                    if (object != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        feedback = (Feedback)((LiveData)object).getValue();
                        feedbackEditFragment$c.a(view, feedback);
                    }
                }
            }
        } else {
            FeedbackEditFragment$c feedbackEditFragment$c = this.p;
            if (feedbackEditFragment$c != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                feedbackEditFragment$c.b(view);
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
        Object object;
        long l12;
        long l13;
        Object object2;
        Object object3;
        ve$b ve$b;
        Object object4;
        int n10;
        int n11;
        Object object5;
        Object object6;
        boolean bl2;
        int n12;
        int n13;
        int n14;
        int n15;
        long l14;
        Object object7;
        FeedbackSet$Type feedbackSet$Type;
        float f10;
        int n16;
        int n17;
        Object object8;
        int n18;
        Object object9;
        Object object10;
        float f11;
        int n19;
        int n20;
        Object object11;
        int n21;
        int n22;
        Object object12;
        float f12;
        int n23;
        long l15;
        float f13;
        int n24;
        long l16;
        long l17;
        long l18;
        long l19;
        long l20;
        long l21;
        long l22;
        long l23;
        long l24;
        boolean bl3;
        Object object13;
        Object object14;
        ve$a ve$a;
        ve$d ve$d;
        long l25;
        Object object15;
        Object object16;
        long l26;
        long l27;
        ve ve2;
        block112: {
            block111: {
                block110: {
                    long l28;
                    block109: {
                        block105: {
                            Object object17;
                            String string2;
                            Object object18;
                            int n25;
                            block108: {
                                block107: {
                                    block106: {
                                        long l29;
                                        long l30;
                                        long l31;
                                        long l32;
                                        ve2 = this;
                                        synchronized (this) {
                                            l27 = this.K;
                                            this.K = l26 = 0L;
                                        }
                                        object16 = this.p;
                                        object15 = this.q;
                                        l25 = 160L;
                                        long l33 = l27 & l25;
                                        long l34 = l33 == l26 ? 0 : (l33 < l26 ? -1 : 1);
                                        if (l34 != false && object16 != null) {
                                            ve$d = this.G;
                                            if (ve$d == null) {
                                                this.G = ve$d = new ve$d();
                                            }
                                            ve$d = ve$d.b((FeedbackEditFragment$c)object16);
                                            ve$a = ve2.H;
                                            if (ve$a == null) {
                                                ve2.H = ve$a = new ve$a();
                                            }
                                            ve$a = ve$a.b((FeedbackEditFragment$c)object16);
                                            object14 = ve2.I;
                                            if (object14 == null) {
                                                object14 = new ve$b();
                                                ve2.I = object14;
                                            }
                                            object14 = ((ve$b)object14).b((FeedbackEditFragment$c)object16);
                                            object13 = ve2.J;
                                            if (object13 == null) {
                                                ve2.J = object13 = new ve$c();
                                            }
                                            object16 = object13.b((FeedbackEditFragment$c)object16);
                                        } else {
                                            bl3 = false;
                                            object16 = null;
                                            l34 = 0;
                                            ve$d = null;
                                            ve$a = null;
                                            object14 = null;
                                        }
                                        long l35 = 0xDFL & l27;
                                        l24 = l35 == l26 ? 0 : (l35 < l26 ? -1 : 1);
                                        l23 = 208L;
                                        l22 = 0x1000000000L;
                                        l21 = 0x4000000L;
                                        l20 = 196L;
                                        l19 = 65536L;
                                        l28 = 0x1000000L;
                                        l18 = 0x400000L;
                                        l17 = 194L;
                                        l16 = 193L;
                                        n24 = 8;
                                        f13 = 1.1E-44f;
                                        l15 = 200L;
                                        n23 = 1;
                                        f12 = Float.MIN_VALUE;
                                        object12 = null;
                                        if (l24 == false) break block105;
                                        long l36 = l27 & l16;
                                        l24 = l36 == l26 ? 0 : (l36 < l26 ? -1 : 1);
                                        n22 = 2131099737;
                                        n21 = 2131099739;
                                        if (l24 != false) {
                                            if (object15 != null) {
                                                object11 = ((o0)object15).s;
                                            } else {
                                                n20 = 0;
                                                object11 = null;
                                            }
                                            ve2.updateLiveDataRegistration(0, (LiveData)object11);
                                            if (object11 != null) {
                                                object11 = (ProductVersionEntity)((LiveData)object11).getValue();
                                            } else {
                                                n20 = 0;
                                                object11 = null;
                                            }
                                            n19 = object11 == null ? n23 : 0;
                                            if (l24 != false) {
                                                if (n19 != 0) {
                                                    l27 |= 0x200L;
                                                    l32 = 0x800000L;
                                                    l27 |= l32;
                                                } else {
                                                    l32 = 256L;
                                                    l27 = l27 | l32 | l18;
                                                }
                                            }
                                            object13 = ve2.n;
                                            l24 = n19 != 0 ? (long)ViewDataBinding.getColorFromResource((View)object13, n22) : (long)ViewDataBinding.getColorFromResource((View)object13, n21);
                                        } else {
                                            l24 = 0;
                                            object13 = null;
                                            f11 = 0.0f;
                                            n19 = 0;
                                            n20 = 0;
                                            object11 = null;
                                        }
                                        l32 = l27 & l17;
                                        long l37 = l32 == l26 ? 0 : (l32 < l26 ? -1 : 1);
                                        if (l37 != false) {
                                            object12 = object15 != null ? ((o0)object15).t : null;
                                            ve2.updateLiveDataRegistration(n23, (LiveData)object12);
                                            object12 = object12 != null ? (FeedbackSet$Rate)((Object)object12.getValue()) : null;
                                            if (object12 == null) {
                                                n25 = n23;
                                            } else {
                                                n25 = 0;
                                                object10 = null;
                                            }
                                            if (l37 != false) {
                                                if (n25 != 0) {
                                                    l27 |= 0x20000L;
                                                    l31 = 0x200000L;
                                                } else {
                                                    l27 |= l19;
                                                    l31 = 0x100000L;
                                                }
                                                l27 |= l31;
                                            }
                                            object9 = ve2.k;
                                            n23 = n25 != 0 ? ViewDataBinding.getColorFromResource((View)object9, n22) : ViewDataBinding.getColorFromResource((View)object9, n21);
                                        } else {
                                            n23 = 0;
                                            f12 = 0.0f;
                                            object9 = null;
                                            object12 = null;
                                            n25 = 0;
                                            object10 = null;
                                        }
                                        l31 = l27 & l20;
                                        n18 = l31 == l26 ? 0 : (l31 < l26 ? -1 : 1);
                                        if (n18 != 0) {
                                            if (object15 != null) {
                                                object8 = ((o0)object15).r;
                                            } else {
                                                n17 = 0;
                                                object8 = null;
                                            }
                                            n16 = 2;
                                            f10 = 2.8E-45f;
                                            ve2.updateLiveDataRegistration(n16, (LiveData)object8);
                                            if (object8 != null) {
                                                object8 = (ProductEntity)((LiveData)object8).getValue();
                                            } else {
                                                n17 = 0;
                                                object8 = null;
                                            }
                                            if (object8 == null) {
                                                n16 = 1;
                                                f10 = Float.MIN_VALUE;
                                            } else {
                                                n16 = 0;
                                                f10 = 0.0f;
                                                feedbackSet$Type = null;
                                            }
                                            if (n18 != 0) {
                                                long l38;
                                                if (n16 != 0) {
                                                    l27 |= 0x8000000L;
                                                    l38 = 0x800000000L;
                                                } else {
                                                    l27 |= l21;
                                                    l38 = 0x400000000L;
                                                }
                                                l27 |= l38;
                                            }
                                            object7 = ve2.m;
                                            if (n16 == 0) {
                                                n22 = 2131099739;
                                            }
                                            n21 = ViewDataBinding.getColorFromResource((View)object7, n22);
                                        } else {
                                            n17 = 0;
                                            object8 = null;
                                            n16 = 0;
                                            f10 = 0.0f;
                                            feedbackSet$Type = null;
                                            n21 = 0;
                                            object7 = null;
                                        }
                                        long l39 = l27 & l15;
                                        l14 = 0L;
                                        n22 = (int)(l39 == l14 ? 0 : (l39 < l14 ? -1 : 1));
                                        object18 = object8;
                                        if (n22 == 0) break block106;
                                        if (object15 != null) {
                                            object8 = ((o0)object15).p;
                                            n15 = n16;
                                        } else {
                                            n15 = n16;
                                            n17 = 0;
                                            object8 = null;
                                        }
                                        n16 = 3;
                                        f10 = 4.2E-45f;
                                        ve2.updateLiveDataRegistration(n16, (LiveData)object8);
                                        if (object8 != null) {
                                            object8 = (FeedbackSet$Type)((Object)((LiveData)object8).getValue());
                                        } else {
                                            n17 = 0;
                                            object8 = null;
                                        }
                                        feedbackSet$Type = FeedbackSet$Type.FIRMWARE;
                                        n14 = n23;
                                        if (feedbackSet$Type == object8) {
                                            n16 = 1;
                                            f10 = Float.MIN_VALUE;
                                        } else {
                                            n16 = 0;
                                            f10 = 0.0f;
                                            feedbackSet$Type = null;
                                        }
                                        object9 = FeedbackSet$Type.ADVICE;
                                        if (object9 == object8) {
                                            n23 = 1;
                                            f12 = Float.MIN_VALUE;
                                        } else {
                                            n23 = 0;
                                            f12 = 0.0f;
                                            object9 = null;
                                        }
                                        if (n22 != 0) {
                                            if (n16 != 0) {
                                                l27 |= 0x800L;
                                                l30 = 0x200000000L;
                                                l27 |= l30;
                                            } else {
                                                l30 = 1024L;
                                                l27 |= l30;
                                                long l40 = 0x100000000L;
                                                l27 |= l40;
                                            }
                                        }
                                        if ((n22 = (int)((l29 = (l30 = l27 & l15) - (l14 = 0L)) == 0L ? 0 : (l29 < 0L ? -1 : 1))) != 0) {
                                            if (n23 != 0) {
                                                l27 = l27 | 0x8000L | 0x2000000L;
                                                l30 = 0x80000000L;
                                            } else {
                                                l27 = l27 | 0x4000L | l28;
                                                l30 = 0x40000000L;
                                            }
                                            l27 |= l30;
                                        }
                                        n22 = n16 != 0 ? 0 : n24;
                                        string2 = n23 != 0 ? "@string/help_title_hint" : "@string/help_title_other_hint";
                                        if (n23 != 0) break block107;
                                        n13 = n24;
                                        break block108;
                                    }
                                    n15 = n16;
                                    n14 = n23;
                                    n17 = 0;
                                    object8 = null;
                                    n16 = 0;
                                    f10 = 0.0f;
                                    feedbackSet$Type = null;
                                    n23 = 0;
                                    f12 = 0.0f;
                                    object9 = null;
                                    n22 = 0;
                                    n12 = 0;
                                    string2 = null;
                                }
                                n13 = 0;
                            }
                            long l41 = l27 & l23;
                            l14 = 0L;
                            long l42 = l41 == l14 ? 0 : (l41 < l14 ? -1 : 1);
                            if (l42 != false) {
                                long l43;
                                if (object15 != null) {
                                    object15 = ((o0)object15).u;
                                    object17 = object8;
                                } else {
                                    object17 = object8;
                                    bl2 = false;
                                    object15 = null;
                                }
                                n17 = 4;
                                ve2.updateLiveDataRegistration(n17, (LiveData)object15);
                                if (object15 != null) {
                                    object8 = (FeedbackSet$AdviceType)((Object)((LiveData)object15).getValue());
                                } else {
                                    n17 = 0;
                                    object8 = null;
                                }
                                if (object8 == null) {
                                    bl2 = true;
                                } else {
                                    bl2 = false;
                                    object15 = null;
                                }
                                if (l42 != false) {
                                    if (bl2) {
                                        l27 |= 0x80000L;
                                        l43 = 0x2000000000L;
                                        l27 |= l43;
                                    } else {
                                        l43 = 262144L;
                                        l27 = l27 | l43 | l22;
                                    }
                                }
                                l43 = l27;
                                object6 = ve2.j;
                                int n26 = bl2 ? 2131099737 : 2131099739;
                                int n27 = ViewDataBinding.getColorFromResource((View)object6, n26);
                                object5 = object8;
                                n18 = n21;
                                object7 = object18;
                                n11 = n14;
                                n17 = n13;
                                n13 = n27;
                                n14 = n19;
                                l27 = l43;
                            } else {
                                object17 = object8;
                                n18 = n21;
                                object7 = object18;
                                n11 = n14;
                                n17 = n13;
                                bl2 = false;
                                object15 = null;
                                object5 = null;
                                n13 = 0;
                                n14 = n19;
                            }
                            n19 = (int)l24;
                            object13 = object17;
                            n10 = n25;
                            object10 = object12;
                            object12 = string2;
                            n12 = n25;
                            break block109;
                        }
                        n17 = 0;
                        object8 = null;
                        n16 = 0;
                        f10 = 0.0f;
                        feedbackSet$Type = null;
                        bl2 = false;
                        object15 = null;
                        n23 = 0;
                        f12 = 0.0f;
                        object9 = null;
                        object12 = null;
                        n22 = 0;
                        l24 = 0;
                        f11 = 0.0f;
                        object13 = null;
                        n21 = 0;
                        object7 = null;
                        n20 = 0;
                        object11 = null;
                        n19 = 0;
                        boolean bl4 = false;
                        object10 = null;
                        n18 = 0;
                        object5 = null;
                        n11 = 0;
                        Object var75_56 = null;
                        n15 = 0;
                        n14 = 0;
                        n12 = 0;
                        Object var82_62 = null;
                        n13 = 0;
                    }
                    l18 = l27 & l18;
                    l14 = 0L;
                    long l44 = l18 == l14 ? 0 : (l18 < l14 ? -1 : 1);
                    if (l44 != false && object11 != null) {
                        object11 = ((ProductVersionEntity)object11).version;
                    } else {
                        n20 = 0;
                        object11 = null;
                    }
                    l28 = l27 & l28;
                    long l45 = l28 == l14 ? 0 : (l28 < l14 ? -1 : 1);
                    if (l45 == false) break block110;
                    object4 = object11;
                    object11 = FeedbackSet$Type.OTHER;
                    if (object11 != object13) break block111;
                    n20 = 1;
                    break block112;
                }
                object4 = object11;
            }
            n20 = 0;
            object11 = null;
        }
        l19 = l27 & l19;
        long l46 = l19 == l14 ? 0 : (l19 < l14 ? -1 : 1);
        if (l46 != false) {
            if (object10 != null) {
                n10 = object10.getStringRes();
                l46 = n20;
                n20 = n10;
            } else {
                l46 = n20;
                n20 = 0;
                object11 = null;
            }
            View view = this.getRoot();
            ve$b = object14;
            object14 = d.v.f.i.g.m(view.getContext(), n20);
        } else {
            ve$b = object14;
            l46 = n20;
            object14 = null;
        }
        l21 = l27 & l21;
        l18 = 0L;
        n20 = (int)(l21 == l18 ? 0 : (l21 < l18 ? -1 : 1));
        if (n20 != 0 && object7 != null) {
            object7 = object7.title;
        } else {
            n21 = 0;
            object7 = null;
        }
        l22 = l27 & l22;
        n20 = (int)(l22 == l18 ? 0 : (l22 < l18 ? -1 : 1));
        if (n20 != 0) {
            if (object5 != null) {
                n20 = object5.getStringRes();
            } else {
                n20 = 0;
                object11 = null;
            }
            object3 = this.getRoot();
            object2 = object14;
            object14 = d.v.f.i.g.m(object3.getContext(), n20);
        } else {
            object2 = object14;
            object14 = null;
        }
        l21 = l27 & 0x100000000L;
        l18 = 0L;
        n20 = (int)(l21 == l18 ? 0 : (l21 < l18 ? -1 : 1));
        if (n20 != 0 && (object11 = FeedbackSet$Type.SOFTWARE) == object13) {
            l24 = 1;
            f11 = Float.MIN_VALUE;
        } else {
            l24 = 0;
            f11 = 0.0f;
            object13 = null;
        }
        l21 = l27 & l17;
        n20 = (int)(l21 == l18 ? 0 : (l21 < l18 ? -1 : 1));
        if (n20 != 0) {
            object11 = n12 != 0 ? "@string/help_appear_rate_hint" : object2;
        } else {
            n20 = 0;
            object11 = null;
        }
        l22 = l27 & l16;
        long l47 = l22 == l18 ? 0 : (l22 < l18 ? -1 : 1);
        if (l47 != false) {
            object3 = n14 != 0 ? "@string/help_fireware_version_hint" : object4;
            Object object19 = object3;
            object3 = object14;
            object14 = object19;
        } else {
            object3 = object14;
            object14 = null;
        }
        long l48 = l27 & l15;
        long l49 = l48 == l18 ? 0 : (l48 < l18 ? -1 : 1);
        if (l49 != false) {
            long l50;
            long l51;
            if (n23 != 0) {
                l46 = 1;
            }
            if (n16 != 0) {
                n23 = 1;
                f12 = Float.MIN_VALUE;
            } else {
                n23 = (int)l24;
                f12 = f11;
            }
            if (l49 != false) {
                l48 = l46 != false ? 0x20000000L : 0x10000000L;
                l27 |= l48;
            }
            if ((n16 = (int)((l51 = (l48 = l27 & l15) - (l50 = 0L)) == 0L ? 0 : (l51 < 0L ? -1 : 1))) != 0) {
                l48 = n23 != 0 ? 8192L : 4096L;
                l27 |= l48;
            }
            if (l46 != false) {
                n16 = 0;
                f10 = 0.0f;
                feedbackSet$Type = null;
            } else {
                n16 = n24;
                f10 = f13;
            }
            if (n23 != 0) {
                n24 = 0;
                f13 = 0.0f;
            }
            n23 = n16;
            f12 = f10;
            n16 = n24;
            f10 = f13;
        } else {
            n16 = 0;
            f10 = 0.0f;
            feedbackSet$Type = null;
            n23 = 0;
            f12 = 0.0f;
            object9 = null;
        }
        l48 = l27 & l20;
        long l52 = 0L;
        l24 = l48 == l52 ? 0 : (l48 < l52 ? -1 : 1);
        if (l24 != false) {
            if (n15 != 0) {
                object7 = "@string/help_device_model_hint";
            }
        } else {
            n21 = 0;
            object7 = null;
        }
        if ((l13 = (l12 = (l23 = l27 & l23) - l52) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            if (bl2) {
                object15 = "@string/help_advice_type_hint";
                object3 = object15;
            }
            object15 = object3;
        } else {
            bl2 = false;
            object15 = null;
        }
        long l53 = l27 & l15;
        long l54 = l53 == l52 ? 0 : (l53 < l52 ? -1 : 1);
        if (l54 != false) {
            object = object14;
            ve2.b.setVisibility(n23);
            ve2.c.setVisibility(n16);
            ve2.d.setVisibility(n23);
            object14 = ve2.d;
            object3 = object7;
            n21 = 0;
            object7 = null;
            l.a.q.g0.u.g((TextView)object14, (String)object12, null, null);
            ve2.e.setVisibility(n16);
            ve2.s.setVisibility(n22);
            ve2.t.setVisibility(n22);
            ve2.u.setVisibility(n22);
            ve2.v.setVisibility(n16);
            ve2.w.setVisibility(n16);
            ve2.x.setVisibility(n16);
            ve2.y.setVisibility(n17);
            object12 = ve2.z;
            object12.setVisibility(n16);
            feedbackSet$Type = ve2.A;
            feedbackSet$Type.setVisibility(n17);
            ve2.B.setVisibility(n23);
            ve2.C.setVisibility(n23);
            object8 = ve2.D;
            object8.setVisibility(n22);
        } else {
            object = object14;
            object3 = object7;
        }
        l26 = 0x80L & l27;
        l25 = 0L;
        n17 = (int)(l26 == l25 ? 0 : (l26 < l25 ? -1 : 1));
        if (n17 != 0) {
            object8 = ve2.g;
            feedbackSet$Type = ve2.E;
            object8.setOnClickListener((View.OnClickListener)feedbackSet$Type);
            object8 = ve2.l;
            feedbackSet$Type = ve2.F;
            object8.setOnClickListener((View.OnClickListener)feedbackSet$Type);
        }
        if ((n17 = (int)((l11 = (l26 = 0xA0L & l27) - l25) == 0L ? 0 : (l11 < 0L ? -1 : 1))) != 0) {
            ve2.s.setOnClickListener((View.OnClickListener)ve$d);
            ve2.u.setOnClickListener((View.OnClickListener)ve$a);
            object8 = ve2.z;
            object8.setOnClickListener((View.OnClickListener)object16);
            object16 = ve2.A;
            object16.setOnClickListener((View.OnClickListener)ve$b);
        }
        if (l13 != false) {
            object16 = ve2.j;
            n17 = n13;
            object16.setTextColor(n13);
            object16 = ve2.j;
            n17 = 0;
            object8 = null;
            l.a.q.g0.u.n((TextView)object16, (String)object15, null, null);
        } else {
            n17 = 0;
            object8 = null;
        }
        long l55 = l27 & l17;
        l25 = 0L;
        bl3 = l55 == l25 ? 0 : (l55 < l25 ? -1 : 1);
        if (bl3) {
            object16 = ve2.k;
            n16 = n11;
            object16.setTextColor(n11);
            object16 = ve2.k;
            l.a.q.g0.u.n((TextView)object16, (String)object11, null, null);
        }
        if (l24 != false) {
            object16 = ve2.m;
            n21 = n18;
            object16.setTextColor(n18);
            object16 = ve2.m;
            object7 = object3;
            l.a.q.g0.u.n((TextView)object16, (String)object3, null, null);
        }
        if (bl3 = (l10 = (l27 &= l16) - (l55 = 0L)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) {
            object16 = ve2.n;
            l24 = n19;
            object16.setTextColor(n19);
            object16 = ve2.n;
            object6 = object;
            l.a.q.g0.u.n((TextView)object16, (String)object, null, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.K;
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
            this.K = l10 = 128L;
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
                        n12 = 4;
                        if (n10 != n12) {
                            return false;
                        }
                        object = (MutableLiveData)object;
                        return this.C((MutableLiveData)object, n11);
                    }
                    object = (MutableLiveData)object;
                    return this.F((MutableLiveData)object, n11);
                }
                object = (MutableLiveData)object;
                return this.D((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.G((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.E((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (FeedbackEditFragment$c)object;
            this.A((FeedbackEditFragment$c)object);
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

