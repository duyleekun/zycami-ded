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
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.effect.EditorFrameFragment$a;
import com.zhiyun.cama.widget.DoubleSeekBar;
import com.zhiyun.cama.widget.DoubleSeekBar$a;
import d.v.c.c1.d;
import d.v.c.f1.a.b$a;
import d.v.c.f1.a.j$a;
import d.v.c.q0.f.a;
import d.v.c.w0.b5;
import d.v.c.w0.j4;
import d.v.c.w0.r6;

public class s6
extends r6
implements b$a,
j$a {
    private static final ViewDataBinding$IncludedLayouts x;
    private static final SparseIntArray y;
    private final ConstraintLayout p;
    private final View.OnClickListener q;
    private final DoubleSeekBar$a r;
    private final View.OnClickListener s;
    private final View.OnClickListener t;
    private final View.OnClickListener u;
    private final View.OnClickListener v;
    private long w;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        x = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(14);
        String[] stringArray = new String[]{"editor_reset_global_layout", "editor_bottom_choice_layout"};
        int n10 = 2;
        int[] nArray = new int[n10];
        nArray[0] = 7;
        nArray[1] = 8;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558538;
        nArray2[1] = 2131558529;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        y = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131363434, 9);
        viewDataBinding$IncludedLayouts.put(2131363390, 10);
        viewDataBinding$IncludedLayouts.put(2131363563, 11);
        viewDataBinding$IncludedLayouts.put(2131363382, 12);
        viewDataBinding$IncludedLayouts.put(2131363470, 13);
    }

    public s6(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = x;
        SparseIntArray sparseIntArray = y;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 14, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private s6(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object = this;
        j4 j42 = (j4)objectArray[8];
        b5 b52 = (b5)objectArray[7];
        ImageView imageView = (ImageView)objectArray[4];
        ImageView imageView2 = (ImageView)objectArray[2];
        ImageView imageView3 = (ImageView)objectArray[1];
        ImageView imageView4 = (ImageView)objectArray[5];
        ImageView imageView5 = (ImageView)objectArray[3];
        DoubleSeekBar doubleSeekBar = (DoubleSeekBar)((Object)objectArray[6]);
        TextView textView = (TextView)objectArray[12];
        TextView textView2 = (TextView)objectArray[10];
        TextView textView3 = (TextView)objectArray[9];
        TextView textView4 = (TextView)objectArray[13];
        TextView textView5 = (TextView)objectArray[11];
        int n10 = 4;
        super(dataBindingComponent, view, n10, j42, b52, imageView, imageView2, imageView3, imageView4, imageView5, doubleSeekBar, textView, textView2, textView3, textView4, textView5);
        this.w = -1;
        object = this.a;
        this.setContainedBinding((ViewDataBinding)object);
        object = this.b;
        this.setContainedBinding((ViewDataBinding)object);
        this.c.setTag((Object)"3");
        this.d.setTag((Object)"1");
        this.e.setTag((Object)"0");
        this.f.setTag((Object)"4");
        this.g.setTag((Object)"2");
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.p = object;
        object.setTag(null);
        this.h.setTag(null);
        object = view;
        this.setRootTag(view);
        super(this, 2);
        this.q = object;
        super(this, 6);
        this.r = object;
        super(this, 3);
        this.s = object;
        super(this, 4);
        this.t = object;
        super(this, 1);
        this.u = object;
        super(this, 5);
        this.v = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(j4 j42, int n10) {
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
    private boolean D(b5 b52, int n10) {
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
    private boolean E(MutableLiveData mutableLiveData, int n10) {
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
    private boolean F(MutableLiveData mutableLiveData, int n10) {
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
    public void A(EditorFrameFragment$a editorFrameFragment$a) {
        this.o = editorFrameFragment$a;
        synchronized (this) {
            long l10 = this.w;
            long l11 = 32;
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
    public void B(d d10) {
        this.n = d10;
        synchronized (this) {
            long l10 = this.w;
            long l11 = 16;
            this.w = l10 |= l11;
        }
        this.notifyPropertyChanged(61);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                int n14 = 3;
                if (n10 != n14) {
                    n13 = 4;
                    n14 = 5;
                    if (n10 != n13) {
                        if (n10 == n14) {
                            EditorFrameFragment$a editorFrameFragment$a = this.o;
                            if (editorFrameFragment$a != null) {
                                n11 = n12;
                            }
                            if (n11 != 0) {
                                n11 = 6;
                                editorFrameFragment$a.i(view, n11);
                            }
                        }
                    } else {
                        EditorFrameFragment$a editorFrameFragment$a = this.o;
                        if (editorFrameFragment$a != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            editorFrameFragment$a.i(view, n14);
                        }
                    }
                } else {
                    EditorFrameFragment$a editorFrameFragment$a = this.o;
                    if (editorFrameFragment$a != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        editorFrameFragment$a.i(view, n13);
                    }
                }
            } else {
                EditorFrameFragment$a editorFrameFragment$a = this.o;
                if (editorFrameFragment$a != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    editorFrameFragment$a.i(view, n12);
                }
            }
        } else {
            EditorFrameFragment$a editorFrameFragment$a = this.o;
            if (editorFrameFragment$a == null) {
                n12 = 0;
            }
            if (n12 != 0) {
                editorFrameFragment$a.i(view, 0);
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
        int n10;
        Context context;
        Context context2;
        Context context3;
        Context context4;
        int n11;
        long l15;
        long l16;
        long l17;
        s6 s62 = this;
        synchronized (this) {
            l17 = this.w;
            this.w = l16 = 0L;
        }
        Object object = this.n;
        Object object2 = this.o;
        long l18 = (long)85 & l17;
        long l19 = l18 == l16 ? 0 : (l18 < l16 ? -1 : 1);
        long l20 = 84;
        long l21 = 81;
        int n12 = 0;
        Context context5 = null;
        if (l19 != false) {
            int n13;
            l15 = l17 & l21;
            l19 = l15 == l16 ? 0 : (l15 < l16 ? -1 : 1);
            n11 = 2;
            if (l19 != false) {
                long l22;
                long l23;
                long l24;
                long l25;
                long l26;
                Object object3;
                if (object != null) {
                    object3 = ((d)object).e();
                } else {
                    n13 = 0;
                    object3 = null;
                }
                s62.updateLiveDataRegistration(0, (LiveData)object3);
                if (object3 != null) {
                    object3 = (Integer)((LiveData)object3).getValue();
                } else {
                    n13 = 0;
                    object3 = null;
                }
                n13 = ViewDataBinding.safeUnbox((Integer)object3);
                n12 = 1;
                int n14 = n13 == 0 ? n12 : 0;
                int n15 = 5;
                if (n13 == n15) {
                    n15 = n12;
                } else {
                    n15 = 0;
                    context4 = null;
                }
                int n16 = n13 == n12 ? n12 : 0;
                n12 = 6;
                if (n13 == n12) {
                    n12 = 1;
                } else {
                    n12 = 0;
                    context5 = null;
                }
                boolean bl2 = n13 == n11;
                if (l19 != false) {
                    l26 = n14 != 0 ? 16384L : 8192L;
                    l17 |= l26;
                }
                if ((l19 = (l25 = (l26 = l17 & l21) - l16) == 0L ? 0 : (l25 < 0L ? -1 : 1)) != false) {
                    l26 = n15 != 0 ? 4096L : 2048L;
                    l17 |= l26;
                }
                if ((l19 = (l24 = (l26 = l17 & l21) - l16) == 0L ? 0 : (l24 < 0L ? -1 : 1)) != false) {
                    l26 = n16 != 0 ? 1024L : 512L;
                    l17 |= l26;
                }
                if ((l19 = (l23 = (l26 = l17 & l21) - l16) == 0L ? 0 : (l23 < 0L ? -1 : 1)) != false) {
                    l26 = n12 != 0 ? 256L : 128L;
                    l17 |= l26;
                }
                if ((l19 = (l22 = (l26 = l17 & l21) - l16) == 0L ? 0 : (l22 < 0L ? -1 : 1)) != false) {
                    l26 = bl2 ? 65536L : 32768L;
                    l17 |= l26;
                }
                l19 = 2131232057;
                n13 = 2131232059;
                context3 = s62.e.getContext();
                context3 = n14 != 0 ? AppCompatResources.getDrawable(context3, (int)l19) : AppCompatResources.getDrawable(context3, n13);
                context2 = s62.c.getContext();
                context2 = n15 != 0 ? AppCompatResources.getDrawable(context2, (int)l19) : AppCompatResources.getDrawable(context2, n13);
                context4 = s62.d.getContext();
                context4 = n16 != 0 ? AppCompatResources.getDrawable(context4, (int)l19) : AppCompatResources.getDrawable(context4, n13);
                context5 = n12 != 0 ? AppCompatResources.getDrawable(s62.f.getContext(), (int)l19) : AppCompatResources.getDrawable(s62.f.getContext(), n13);
                if (bl2) {
                    object3 = s62.g.getContext();
                    context = AppCompatResources.getDrawable((Context)object3, (int)l19);
                } else {
                    context = AppCompatResources.getDrawable(s62.g.getContext(), n13);
                }
            } else {
                l19 = 0;
                context = null;
                context3 = null;
                context2 = null;
                n12 = 0;
                context5 = null;
                boolean bl3 = false;
                context4 = null;
            }
            long l27 = l17 & l20;
            n13 = (int)(l27 == l16 ? 0 : (l27 < l16 ? -1 : 1));
            if (n13 != 0) {
                if (object != null) {
                    object = ((d)object).d();
                } else {
                    n10 = 0;
                    object = null;
                }
                s62.updateLiveDataRegistration(n11, (LiveData)object);
                if (object != null) {
                    object = (Integer)((LiveData)object).getValue();
                } else {
                    n10 = 0;
                    object = null;
                }
                n12 = n10 = ViewDataBinding.safeUnbox((Integer)object);
                object = context4;
                context4 = context2;
                context2 = context;
                context = context5;
            } else {
                object = context4;
                context4 = context2;
                context2 = context;
                context = context5;
                n12 = 0;
                context5 = null;
            }
        } else {
            n10 = 0;
            object = null;
            l19 = 0;
            context = null;
            context3 = null;
            context2 = null;
            n12 = 0;
            context5 = null;
            boolean bl4 = false;
            context4 = null;
        }
        l15 = (long)96 & l17;
        n11 = (int)(l15 == l16 ? 0 : (l15 < l16 ? -1 : 1));
        if (n11 != 0) {
            s62.a.z((a)object2);
            b5 b52 = s62.b;
            b52.z((a)object2);
        }
        if ((l14 = (l13 = (l15 = (long)81 & l17) - l16) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
            ViewBindingAdapter.setBackground((View)s62.c, context4);
            object2 = s62.d;
            ViewBindingAdapter.setBackground((View)object2, (Drawable)object);
            ViewBindingAdapter.setBackground((View)s62.e, context3);
            ViewBindingAdapter.setBackground((View)s62.f, context);
            object = s62.g;
            ViewBindingAdapter.setBackground((View)object, context2);
        }
        if ((n10 = (l12 = (l11 = (long)64 & l17) - l16) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != 0) {
            object = s62.c;
            object2 = s62.t;
            object.setOnClickListener((View.OnClickListener)object2);
            object = s62.d;
            object2 = s62.q;
            object.setOnClickListener((View.OnClickListener)object2);
            object = s62.e;
            object2 = s62.u;
            object.setOnClickListener((View.OnClickListener)object2);
            object = s62.f;
            object2 = s62.v;
            object.setOnClickListener((View.OnClickListener)object2);
            object = s62.g;
            object2 = s62.s;
            object.setOnClickListener((View.OnClickListener)object2);
            object = s62.h;
            object2 = s62.r;
            ((DoubleSeekBar)((Object)object)).setSeekChangeListener((DoubleSeekBar$a)object2);
        }
        if ((n10 = (int)((l10 = (l17 &= l20) - l16) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0) {
            object = s62.h;
            ((DoubleSeekBar)((Object)object)).setProgress(n12);
        }
        ViewDataBinding.executeBindingsOn(s62.b);
        ViewDataBinding.executeBindingsOn(s62.a);
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
            ViewDataBinding viewDataBinding = this.b;
            l12 = (long)viewDataBinding.hasPendingBindings();
            if (l12 != false) {
                return bl2;
            }
            viewDataBinding = this.a;
            l12 = (long)viewDataBinding.hasPendingBindings();
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
            this.w = l10 = (long)64;
        }
        this.b.invalidateAll();
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
                        return false;
                    }
                    object = (j4)object;
                    return this.C((j4)object, n11);
                }
                object = (MutableLiveData)object;
                return this.E((MutableLiveData)object, n11);
            }
            object = (b5)object;
            return this.D((b5)object, n11);
        }
        object = (MutableLiveData)object;
        return this.F((MutableLiveData)object, n11);
    }

    public final void q(int n10, int n11) {
        EditorFrameFragment$a editorFrameFragment$a = this.o;
        boolean bl2 = editorFrameFragment$a != null;
        if (bl2) {
            editorFrameFragment$a.h(n11);
        }
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.b.setLifecycleOwner(lifecycleOwner);
        this.a.setLifecycleOwner(lifecycleOwner);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 61;
        if (n11 == n10) {
            object = (d)object;
            this.B((d)object);
            return 1 != 0;
        } else {
            n11 = 25;
            if (n11 != n10) return 0 != 0;
            object = (EditorFrameFragment$a)object;
            this.A((EditorFrameFragment$a)object);
        }
        return 1 != 0;
    }
}

