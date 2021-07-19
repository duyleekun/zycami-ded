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
import com.zhiyun.cama.zoom.EditorZoomFragment$a;
import d.v.c.c2.c;
import d.v.c.f1.a.b$a;
import d.v.c.w0.b5;
import d.v.c.w0.j4;
import d.v.c.w0.v8;

public class w8
extends v8
implements b$a {
    private static final ViewDataBinding$IncludedLayouts B;
    private static final SparseIntArray C;
    private long A;
    private final ConstraintLayout s;
    private final View.OnClickListener t;
    private final View.OnClickListener u;
    private final View.OnClickListener v;
    private final View.OnClickListener w;
    private final View.OnClickListener x;
    private final View.OnClickListener y;
    private final View.OnClickListener z;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        B = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(17);
        String[] stringArray = new String[]{"editor_reset_global_layout", "editor_bottom_choice_layout"};
        int n10 = 2;
        int[] nArray = new int[n10];
        nArray[0] = 8;
        nArray[1] = 9;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558538;
        nArray2[1] = 2131558529;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        C = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131363516, 10);
        viewDataBinding$IncludedLayouts.put(2131363637, 11);
        viewDataBinding$IncludedLayouts.put(2131363636, 12);
        viewDataBinding$IncludedLayouts.put(2131363560, 13);
        viewDataBinding$IncludedLayouts.put(2131363482, 14);
        viewDataBinding$IncludedLayouts.put(2131363421, 15);
        viewDataBinding$IncludedLayouts.put(2131363621, 16);
    }

    public w8(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = B;
        SparseIntArray sparseIntArray = C;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 17, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private w8(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object = this;
        j4 j42 = (j4)objectArray[9];
        b5 b52 = (b5)objectArray[8];
        ImageView imageView = (ImageView)objectArray[6];
        ImageView imageView2 = (ImageView)objectArray[5];
        ImageView imageView3 = (ImageView)objectArray[1];
        ImageView imageView4 = (ImageView)objectArray[4];
        ImageView imageView5 = (ImageView)objectArray[7];
        ImageView imageView6 = (ImageView)objectArray[3];
        ImageView imageView7 = (ImageView)objectArray[2];
        TextView textView = (TextView)objectArray[15];
        TextView textView2 = (TextView)objectArray[14];
        TextView textView3 = (TextView)objectArray[10];
        TextView textView4 = (TextView)objectArray[13];
        TextView textView5 = (TextView)objectArray[16];
        TextView textView6 = (TextView)objectArray[12];
        TextView textView7 = (TextView)objectArray[11];
        int n10 = 3;
        super(dataBindingComponent, view, n10, j42, b52, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, textView, textView2, textView3, textView4, textView5, textView6, textView7);
        this.A = -1;
        object = this.a;
        this.setContainedBinding((ViewDataBinding)object);
        object = this.b;
        this.setContainedBinding((ViewDataBinding)object);
        this.c.setTag((Object)"5");
        this.d.setTag((Object)"4");
        this.e.setTag((Object)"0");
        this.f.setTag((Object)"3");
        this.g.setTag((Object)"6");
        this.h.setTag((Object)"2");
        this.i.setTag((Object)"1");
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.s = object;
        object.setTag(null);
        object = view;
        this.setRootTag(view);
        super(this, 7);
        this.t = object;
        super(this, 3);
        this.u = object;
        super(this, 4);
        this.v = object;
        super(this, 5);
        this.w = object;
        super(this, 6);
        this.x = object;
        super(this, 2);
        this.y = object;
        super(this, 1);
        this.z = object;
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
                long l10 = this.A;
                long l11 = 4;
                this.A = l10 |= l11;
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
                long l10 = this.A;
                long l11 = 1L;
                this.A = l10 |= l11;
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
                long l10 = this.A;
                long l11 = 2;
                this.A = l10 |= l11;
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
    public void A(EditorZoomFragment$a editorZoomFragment$a) {
        this.q = editorZoomFragment$a;
        synchronized (this) {
            long l10 = this.A;
            long l11 = 16;
            this.A = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(c c10) {
        this.r = c10;
        synchronized (this) {
            long l10 = this.A;
            long l11 = 8;
            this.A = l10 |= l11;
        }
        this.notifyPropertyChanged(159);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 1;
        int n12 = 0;
        switch (n10) {
            default: {
                break;
            }
            case 7: {
                EditorZoomFragment$a editorZoomFragment$a = this.q;
                if (editorZoomFragment$a == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                n11 = 5;
                editorZoomFragment$a.h(view, n11);
                break;
            }
            case 6: {
                EditorZoomFragment$a editorZoomFragment$a = this.q;
                if (editorZoomFragment$a == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                n11 = 6;
                editorZoomFragment$a.h(view, n11);
                break;
            }
            case 5: {
                EditorZoomFragment$a editorZoomFragment$a = this.q;
                if (editorZoomFragment$a == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                n11 = 3;
                editorZoomFragment$a.h(view, n11);
                break;
            }
            case 4: {
                EditorZoomFragment$a editorZoomFragment$a = this.q;
                if (editorZoomFragment$a == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                n11 = 4;
                editorZoomFragment$a.h(view, n11);
                break;
            }
            case 3: {
                EditorZoomFragment$a editorZoomFragment$a = this.q;
                if (editorZoomFragment$a != null) {
                    n12 = n11;
                }
                if (n12 == 0) break;
                editorZoomFragment$a.h(view, n11);
                break;
            }
            case 2: {
                EditorZoomFragment$a editorZoomFragment$a = this.q;
                if (editorZoomFragment$a == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                n11 = 2;
                editorZoomFragment$a.h(view, n11);
                break;
            }
            case 1: {
                EditorZoomFragment$a editorZoomFragment$a = this.q;
                if (editorZoomFragment$a == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                editorZoomFragment$a.h(view, 0);
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
        Object object;
        Context context;
        Drawable drawable2;
        Context context2;
        b5 b52;
        long l14;
        Context context3;
        int n10;
        long l15;
        long l16;
        w8 w82 = this;
        synchronized (this) {
            l16 = this.A;
            this.A = l15 = 0L;
        }
        Object object2 = this.r;
        EditorZoomFragment$a editorZoomFragment$a = this.q;
        long l17 = 42;
        long l18 = l16 & l17;
        long l19 = l18 == l15 ? 0 : (l18 < l15 ? -1 : 1);
        int n11 = 0;
        Object object3 = null;
        if (l19 != false) {
            long l20;
            long l21;
            long l22;
            long l23;
            long l24;
            long l25;
            long l26;
            if (object2 != null) {
                object2 = ((c)object2).b();
            } else {
                n10 = 0;
                object2 = null;
            }
            int n12 = 1;
            w82.updateLiveDataRegistration(n12, (LiveData)object2);
            if (object2 != null) {
                object3 = object2 = ((LiveData)object2).getValue();
                object3 = (Integer)object2;
            }
            if ((n10 = ViewDataBinding.safeUnbox(object3)) == (n11 = 4)) {
                n11 = n12;
            } else {
                n11 = 0;
                object3 = null;
            }
            int n13 = 5;
            if (n10 == n13) {
                n13 = n12;
            } else {
                n13 = 0;
                context3 = null;
            }
            if (n10 == n12) {
                l14 = n12;
            } else {
                l14 = 0;
                b52 = null;
            }
            int n14 = 6;
            if (n10 == n14) {
                n14 = n12;
            } else {
                n14 = 0;
                context2 = null;
            }
            int n15 = n10 == 0 ? n12 : 0;
            n12 = 2;
            if (n10 == n12) {
                n12 = 1;
            } else {
                n12 = 0;
                drawable2 = null;
            }
            int n16 = 3;
            boolean bl2 = n10 == n16;
            if (l19 != false) {
                l26 = n11 != 0 ? 8192L : 4096L;
                l16 |= l26;
            }
            if ((n10 = (int)((l25 = (l26 = l16 & l17) - l15) == 0L ? 0 : (l25 < 0L ? -1 : 1))) != 0) {
                l26 = n13 != 0 ? 524288L : 262144L;
                l16 |= l26;
            }
            if ((n10 = (int)((l24 = (l26 = l16 & l17) - l15) == 0L ? 0 : (l24 < 0L ? -1 : 1))) != 0) {
                l26 = l14 != false ? 128L : (long)64;
                l16 |= l26;
            }
            if ((n10 = (int)((l23 = (l26 = l16 & l17) - l15) == 0L ? 0 : (l23 < 0L ? -1 : 1))) != 0) {
                l26 = n14 != 0 ? 131072L : 65536L;
                l16 |= l26;
            }
            if ((n10 = (int)((l22 = (l26 = l16 & l17) - l15) == 0L ? 0 : (l22 < 0L ? -1 : 1))) != 0) {
                l26 = n15 != 0 ? 2048L : 1024L;
                l16 |= l26;
            }
            if ((n10 = (int)((l21 = (l26 = l16 & l17) - l15) == 0L ? 0 : (l21 < 0L ? -1 : 1))) != 0) {
                l26 = n12 != 0 ? 32768L : 16384L;
                l16 |= l26;
            }
            if ((n10 = (int)((l20 = (l26 = l16 & l17) - l15) == 0L ? 0 : (l20 < 0L ? -1 : 1))) != 0) {
                l26 = bl2 ? 512L : 256L;
                l16 |= l26;
            }
            n10 = 2131232057;
            l19 = 2131232059;
            object3 = n11 != 0 ? AppCompatResources.getDrawable(w82.f.getContext(), n10) : AppCompatResources.getDrawable(w82.f.getContext(), (int)l19);
            context = w82.g.getContext();
            context = n13 != 0 ? AppCompatResources.getDrawable(context, n10) : AppCompatResources.getDrawable(context, (int)l19);
            context3 = w82.h.getContext();
            context3 = l14 != false ? AppCompatResources.getDrawable(context3, n10) : AppCompatResources.getDrawable(context3, (int)l19);
            b52 = w82.c.getContext();
            b52 = n14 != 0 ? AppCompatResources.getDrawable((Context)b52, n10) : AppCompatResources.getDrawable((Context)b52, (int)l19);
            context2 = w82.e.getContext();
            context2 = n15 != 0 ? AppCompatResources.getDrawable(context2, n10) : AppCompatResources.getDrawable(context2, (int)l19);
            drawable2 = n12 != 0 ? AppCompatResources.getDrawable(w82.i.getContext(), n10) : AppCompatResources.getDrawable(w82.i.getContext(), (int)l19);
            if (bl2) {
                object = w82.d.getContext();
                object2 = AppCompatResources.getDrawable(object, n10);
            } else {
                object2 = AppCompatResources.getDrawable(w82.d.getContext(), (int)l19);
            }
            object = object3;
            object3 = b52;
        } else {
            n10 = 0;
            object2 = null;
            l19 = 0;
            object = null;
            boolean bl3 = false;
            drawable2 = null;
            boolean bl4 = false;
            context = null;
            boolean bl5 = false;
            context3 = null;
            boolean bl6 = false;
            context2 = null;
        }
        long l27 = l16 & (long)48;
        l14 = l27 == l15 ? 0 : (l27 < l15 ? -1 : 1);
        if (l14 != false) {
            w82.a.z(editorZoomFragment$a);
            b52 = w82.b;
            b52.z(editorZoomFragment$a);
        }
        if ((l13 = (l12 = (l11 = l16 & l17) - l15) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            ViewBindingAdapter.setBackground((View)w82.c, (Drawable)object3);
            editorZoomFragment$a = w82.d;
            ViewBindingAdapter.setBackground((View)editorZoomFragment$a, (Drawable)object2);
            ViewBindingAdapter.setBackground((View)w82.e, context2);
            ViewBindingAdapter.setBackground((View)w82.f, object);
            ViewBindingAdapter.setBackground((View)w82.g, context);
            ViewBindingAdapter.setBackground((View)w82.h, context3);
            object2 = w82.i;
            ViewBindingAdapter.setBackground((View)object2, drawable2);
        }
        if ((n10 = (int)((l10 = (l16 &= (l11 = (long)32)) - l15) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0) {
            object2 = w82.c;
            View.OnClickListener onClickListener = w82.x;
            object2.setOnClickListener(onClickListener);
            object2 = w82.d;
            onClickListener = w82.w;
            object2.setOnClickListener(onClickListener);
            object2 = w82.e;
            onClickListener = w82.z;
            object2.setOnClickListener(onClickListener);
            object2 = w82.f;
            onClickListener = w82.v;
            object2.setOnClickListener(onClickListener);
            object2 = w82.g;
            onClickListener = w82.t;
            object2.setOnClickListener(onClickListener);
            object2 = w82.h;
            onClickListener = w82.u;
            object2.setOnClickListener(onClickListener);
            object2 = w82.i;
            onClickListener = w82.y;
            object2.setOnClickListener(onClickListener);
        }
        ViewDataBinding.executeBindingsOn(w82.b);
        ViewDataBinding.executeBindingsOn(w82.a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.A;
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
            this.A = l10 = (long)32;
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
        int n11 = 159;
        if (n11 == n10) {
            object = (c)object;
            this.B((c)object);
            return 1 != 0;
        } else {
            n11 = 25;
            if (n11 != n10) return 0 != 0;
            object = (EditorZoomFragment$a)object;
            this.A((EditorZoomFragment$a)object);
        }
        return 1 != 0;
    }
}

