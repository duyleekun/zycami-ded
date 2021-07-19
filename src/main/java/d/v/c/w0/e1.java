/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.DynamicZoomViewModel;
import com.zhiyun.cama.camera.DynamicZoomViewModel$TargetModel;
import com.zhiyun.cama.me.help.view.MaxHeightScrollView;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.s0.b7.k$a;
import d.v.c.w0.d1;
import l.a.q.g0.u;

public class e1
extends d1
implements b$a {
    private static final SparseIntArray A;
    private static final ViewDataBinding$IncludedLayouts z;
    private final ImageView p;
    private final View q;
    private final ImageView r;
    private final ImageView s;
    private final View t;
    private final ImageView u;
    private final View.OnClickListener v;
    private final View.OnClickListener w;
    private final View.OnClickListener x;
    private long y;

    static {
        SparseIntArray sparseIntArray;
        A = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362175, 14);
        sparseIntArray.put(2131363467, 15);
        sparseIntArray.put(2131362424, 16);
        sparseIntArray.put(2131363274, 17);
    }

    public e1(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = z;
        SparseIntArray sparseIntArray = A;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 18, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private e1(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[14];
        object2 = (ConstraintLayout)((Object)object);
        Object object3 = object = objectArray[1];
        object3 = (FrameLayout)object;
        Object object4 = object = objectArray[3];
        object4 = (TextView)object;
        Object object5 = object = objectArray[4];
        object5 = (TextView)object;
        Object object6 = object = objectArray[5];
        object6 = (Button)object;
        Object object7 = object = objectArray[16];
        object7 = (ExoVideoView)object;
        Object object8 = object = objectArray[2];
        object8 = (ImageView)object;
        Object object9 = object = objectArray[10];
        object9 = (FrameLayout)object;
        Object object10 = object = objectArray[6];
        object10 = (FrameLayout)object;
        Object object11 = object = objectArray[0];
        object11 = (ConstraintLayout)((Object)object);
        Object object12 = object = objectArray[17];
        object12 = (MaxHeightScrollView)((Object)object);
        Object object13 = object = objectArray[15];
        object13 = (TextView)object;
        object = this;
        super(dataBindingComponent, view, 1, (ConstraintLayout)((Object)object2), (FrameLayout)object3, (TextView)object4, (TextView)object5, (Button)object6, (ExoVideoView)object7, (ImageView)object8, (FrameLayout)object9, (FrameLayout)object10, (ConstraintLayout)((Object)object11), (MaxHeightScrollView)((Object)object12), (TextView)object13);
        this.y = -1;
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        object = (ImageView)objectArray[11];
        this.p = object;
        object.setTag(null);
        object = (View)objectArray[12];
        this.q = object;
        object.setTag(null);
        object = (ImageView)objectArray[13];
        this.r = object;
        object.setTag(null);
        object = (ImageView)objectArray[7];
        this.s = object;
        object.setTag(null);
        object = (View)objectArray[8];
        this.t = object;
        object.setTag(null);
        object = (ImageView)objectArray[9];
        this.u = object;
        object.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, 2);
        this.v = object;
        object = new b(this, 3);
        this.w = object;
        object = new b(this, 1);
        this.x = object;
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
                long l10 = this.y;
                long l11 = 1L;
                this.y = l10 |= l11;
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
    public void B(k$a k$a) {
        this.m = k$a;
        synchronized (this) {
            long l10 = this.y;
            long l11 = 8;
            this.y = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    public void C(DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel) {
        this.o = dynamicZoomViewModel$TargetModel;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(DynamicZoomViewModel dynamicZoomViewModel) {
        this.n = dynamicZoomViewModel;
        synchronized (this) {
            long l10 = this.y;
            long l11 = 2;
            this.y = l10 |= l11;
        }
        this.notifyPropertyChanged(46);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 == n13) {
                    k$a k$a = this.m;
                    if (k$a != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        k$a.d();
                    }
                }
            } else {
                k$a k$a = this.m;
                if (k$a != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    k$a.b();
                }
            }
        } else {
            k$a k$a = this.m;
            if (k$a != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                k$a.a();
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
        Context context;
        Context context2;
        Context context3;
        int n10;
        int n11;
        Button button;
        String string2;
        Object object;
        long l12;
        long l13;
        e1 e12 = this;
        synchronized (this) {
            l13 = this.y;
            this.y = l12 = 0L;
        }
        Object object2 = this.n;
        long l14 = 19;
        long l15 = l13 & l14;
        long l16 = l15 == l12 ? 0 : (l15 < l12 ? -1 : 1);
        boolean bl2 = true;
        int n12 = 0;
        if (l16 != false) {
            long l17;
            long l18;
            boolean bl3;
            boolean bl4;
            if (object2 != null) {
                object2 = ((DynamicZoomViewModel)object2).o();
            } else {
                bl4 = false;
                object2 = null;
            }
            e12.updateLiveDataRegistration(0, (LiveData)object2);
            if (object2 != null) {
                object2 = (DynamicZoomViewModel$TargetModel)((Object)((LiveData)object2).getValue());
            } else {
                bl4 = false;
                object2 = null;
            }
            object = DynamicZoomViewModel$TargetModel.FAR;
            if (object2 == object) {
                bl3 = bl2;
            } else {
                bl3 = false;
                string2 = null;
            }
            if (l16 != false) {
                if (bl3) {
                    l13 |= 0x400L;
                    l18 = 65536L;
                } else {
                    l13 |= 0x200L;
                    l18 = 32768L;
                }
                l13 |= l18;
            }
            if (object2 != null) {
                l16 = (long)((Enum)object2).equals(object);
                object = DynamicZoomViewModel$TargetModel.NEAR;
                bl4 = ((Enum)object2).equals(object);
            } else {
                bl4 = false;
                object2 = null;
                l16 = 0;
                button = null;
            }
            l18 = l13 & l14;
            long l19 = l18 == l12 ? 0 : (l18 < l12 ? -1 : 1);
            if (l19 != false) {
                if (l16 != false) {
                    l13 = l13 | (long)64 | 0x4000L | 0x40000L;
                    l18 = 0x100000L;
                } else {
                    l13 = l13 | (long)32 | 0x2000L | 0x20000L;
                    l18 = 524288L;
                }
                l13 |= l18;
            }
            if ((l19 = (l17 = (l18 = l13 & l14) - l12) == 0L ? 0 : (l17 < 0L ? -1 : 1)) != false) {
                if (bl4) {
                    l13 |= 0x100L;
                    l18 = 4096L;
                } else {
                    l13 |= 0x80L;
                    l18 = 2048L;
                }
                l13 |= l18;
            }
            object = bl3 ? "@string/hitchcock_target_far" : "@string/hitchcock_target_near";
            string2 = bl3 ? "@string/hitchcock_device_far_away_target" : "@string/hitchcock_device_near_to_target";
            n11 = l16 != false ? 4 : 0;
            n12 = 2131232088;
            n10 = 2131232089;
            context3 = e12.t.getContext();
            context3 = l16 != false ? AppCompatResources.getDrawable(context3, n12) : AppCompatResources.getDrawable(context3, n10);
            context2 = e12.i.getContext();
            context2 = l16 != false ? AppCompatResources.getDrawable(context2, n12) : AppCompatResources.getDrawable(context2, n10);
            int n13 = l16 != false ? 0 : 4;
            context = e12.h.getContext();
            context = bl4 ? AppCompatResources.getDrawable(context, n12) : AppCompatResources.getDrawable(context, n10);
            object2 = bl4 ? AppCompatResources.getDrawable(e12.q.getContext(), n12) : AppCompatResources.getDrawable(e12.q.getContext(), n10);
            n12 = n13;
        } else {
            boolean bl5 = false;
            object2 = null;
            context2 = null;
            context = null;
            n12 = 0;
            context3 = null;
            boolean bl6 = false;
            object = null;
            boolean bl7 = false;
            string2 = null;
            n11 = 0;
        }
        long l20 = l13 & (long)16;
        l16 = l20 == l12 ? 0 : (l20 < l12 ? -1 : 1);
        if (l16 != false) {
            l16 = ViewDataBinding.getBuildSdkInt();
            if (l16 >= (n10 = 21)) {
                e12.b.setClipToOutline(bl2);
                e12.g.setClipToOutline(bl2);
                e12.h.setClipToOutline(bl2);
                button = e12.i;
                button.setClipToOutline(bl2);
            }
            button = e12.e;
            View.OnClickListener onClickListener = e12.x;
            button.setOnClickListener(onClickListener);
            button = e12.p;
            onClickListener = e12.w;
            button.setOnClickListener(onClickListener);
            button = e12.s;
            onClickListener = e12.v;
            button.setOnClickListener(onClickListener);
        }
        if ((l11 = (l10 = (l13 &= (l15 = (long)19)) - l12) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            l.a.q.g0.u.n(e12.c, (String)object, null, null);
            l.a.q.g0.u.n(e12.d, string2, null, null);
            ViewBindingAdapter.setBackground((View)e12.h, context);
            ViewBindingAdapter.setBackground((View)e12.i, context2);
            View view = e12.q;
            ViewBindingAdapter.setBackground(view, (Drawable)object2);
            e12.r.setVisibility(n11);
            ViewBindingAdapter.setBackground(e12.t, (Drawable)context3);
            object2 = e12.u;
            object2.setVisibility(n12);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.y;
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
            this.y = l10 = (long)16;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (MutableLiveData)object;
        return this.E((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 46;
        if (n11 == n10) {
            DynamicZoomViewModel dynamicZoomViewModel = (DynamicZoomViewModel)object;
            this.D(dynamicZoomViewModel);
            return 1 != 0;
        } else {
            n11 = 45;
            if (n11 == n10) {
                DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel = (DynamicZoomViewModel$TargetModel)((Object)object);
                this.C(dynamicZoomViewModel$TargetModel);
                return 1 != 0;
            } else {
                n11 = 23;
                if (n11 != n10) return 0 != 0;
                k$a k$a = (k$a)object;
                this.B(k$a);
            }
        }
        return 1 != 0;
    }
}

