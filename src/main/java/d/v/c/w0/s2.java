/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.zhiyun.cama.cloud_engine.CETemplateModel;
import com.zhiyun.cama.cloud_engine.CETemplatePreviewDialog$a;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.r2;
import d.v.f.e.c;
import l.a.q.g0.u;

public class s2
extends r2
implements b$a {
    private static final ViewDataBinding$IncludedLayouts t;
    private static final SparseIntArray u;
    private final ConstraintLayout l;
    private final ImageView m;
    private final View.OnClickListener n;
    private final View.OnClickListener o;
    private final View.OnClickListener p;
    private final View.OnClickListener q;
    private final View.OnClickListener r;
    private long s;

    public s2(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = t;
        SparseIntArray sparseIntArray = u;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 10, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private s2(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[1];
        object2 = (ImageView)object;
        Object object3 = object = objectArray[8];
        object3 = (TextView)object;
        Object object4 = object = objectArray[6];
        object4 = (TextView)object;
        int n10 = 4;
        Object object5 = object = objectArray[n10];
        object5 = (ImageView)object;
        Object object6 = object = objectArray[9];
        object6 = (TextView)object;
        Object object7 = object = objectArray[7];
        object7 = (TextView)object;
        int n11 = 3;
        Object object8 = object = objectArray[n11];
        object8 = (ExoVideoView)object;
        int n12 = 2;
        Object object9 = object = objectArray[n12];
        object9 = (FrameLayout)object;
        object = this;
        Object object10 = dataBindingComponent;
        View view2 = view;
        super(dataBindingComponent, view, 1, (ImageView)object2, (TextView)object3, (TextView)object4, (ImageView)object5, (TextView)object6, (TextView)object7, (ExoVideoView)object8, (FrameLayout)object9);
        this.s = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.l = object;
        object.setTag(null);
        int n13 = 5;
        view2 = (ImageView)objectArray[n13];
        this.m = view2;
        view2.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        object10 = view;
        this.setRootTag(view);
        object10 = new b(this, n10);
        this.n = object10;
        object10 = new b(this, n12);
        this.o = object10;
        object10 = new b(this, n13);
        this.p = object10;
        object = new b(this, n11);
        this.q = object;
        object = new b(this, 1);
        this.r = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean E(ObservableBoolean observableBoolean, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.s;
                long l11 = 1L;
                this.s = l10 |= l11;
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
    public void B(CETemplatePreviewDialog$a cETemplatePreviewDialog$a) {
        this.k = cETemplatePreviewDialog$a;
        synchronized (this) {
            long l10 = this.s;
            long l11 = 4;
            this.s = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(CETemplateModel cETemplateModel) {
        this.i = cETemplateModel;
        synchronized (this) {
            long l10 = this.s;
            long l11 = 2;
            this.s = l10 |= l11;
        }
        this.notifyPropertyChanged(75);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(ObservableBoolean observableBoolean) {
        this.updateRegistration(0, observableBoolean);
        this.j = observableBoolean;
        synchronized (this) {
            long l10 = this.s;
            long l11 = 1L;
            this.s = l10 |= l11;
        }
        this.notifyPropertyChanged(98);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 != n13) {
                    n13 = 4;
                    if (n10 != n13) {
                        n13 = 5;
                        if (n10 == n13) {
                            CETemplatePreviewDialog$a cETemplatePreviewDialog$a = this.k;
                            if (cETemplatePreviewDialog$a != null) {
                                n11 = n12;
                            }
                            if (n11 != 0) {
                                cETemplatePreviewDialog$a.b();
                            }
                        }
                    } else {
                        CETemplateModel cETemplateModel = this.i;
                        CETemplatePreviewDialog$a cETemplatePreviewDialog$a = this.k;
                        if (cETemplatePreviewDialog$a != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            cETemplatePreviewDialog$a.h(cETemplateModel);
                        }
                    }
                } else {
                    CETemplatePreviewDialog$a cETemplatePreviewDialog$a = this.k;
                    if (cETemplatePreviewDialog$a != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        cETemplatePreviewDialog$a.g();
                    }
                }
            } else {
                CETemplatePreviewDialog$a cETemplatePreviewDialog$a = this.k;
                if (cETemplatePreviewDialog$a != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    cETemplatePreviewDialog$a.e();
                }
            }
        } else {
            CETemplatePreviewDialog$a cETemplatePreviewDialog$a = this.k;
            if (cETemplatePreviewDialog$a != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                cETemplatePreviewDialog$a.a();
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
        ImageView imageView;
        int n10;
        int n11;
        CharSequence charSequence;
        long l15;
        int n12;
        boolean bl2;
        int n13;
        String string2;
        long l16;
        long l17;
        s2 s22 = this;
        synchronized (this) {
            l17 = this.s;
            this.s = l16 = 0L;
        }
        CETemplateModel cETemplateModel = this.i;
        ObservableBoolean observableBoolean = this.j;
        long l18 = 10;
        long l19 = l17 & l18;
        long l20 = l19 == l16 ? 0 : (l19 < l16 ? -1 : 1);
        boolean bl3 = true;
        if (l20 != false) {
            String string3;
            int n14;
            if (cETemplateModel != null) {
                n14 = cETemplateModel.getHeight();
                string2 = cETemplateModel.getTitle();
                n13 = cETemplateModel.getWidth();
                bl2 = cETemplateModel.getPreviewtype();
                n12 = n13;
            } else {
                bl2 = false;
                cETemplateModel = null;
                n12 = 0;
                string3 = null;
                n14 = 0;
                string2 = null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(n12);
            stringBuilder.append(":");
            string3 = stringBuilder.toString();
            boolean bl4 = 3 != 0;
            if (bl2 == bl4) {
                bl2 = bl3;
            } else {
                bl2 = false;
                cETemplateModel = null;
            }
            if (l20 != false) {
                l15 = bl2 ? (long)32 : (long)16;
                l17 |= l15;
            }
            charSequence = new StringBuilder();
            charSequence.append(string3);
            charSequence.append(n14);
            charSequence = charSequence.toString();
            if (bl2) {
                n12 = 0;
                string3 = null;
            } else {
                n12 = 8;
            }
        } else {
            bl2 = false;
            cETemplateModel = null;
            l20 = 0;
            charSequence = null;
            n12 = 0;
            Object var19_16 = null;
            string2 = null;
        }
        long l21 = 9;
        l15 = l17 & l21;
        long l22 = l15 == l16 ? 0 : (l15 < l16 ? -1 : 1);
        if (l22 != false) {
            if (observableBoolean != null) {
                n11 = observableBoolean.get();
            } else {
                n11 = 0;
                observableBoolean = null;
            }
            if (l22 != false) {
                if (n11 != 0) {
                    l17 |= 0x80L;
                    l15 = 512L;
                } else {
                    l17 |= (long)64;
                    l15 = 256L;
                }
                l17 |= l15;
            }
            l22 = n11 != 0 ? (long)0 : (long)8;
            n13 = n11 != 0 ? 8 : 0;
            n10 = n13;
            n11 = l22;
        } else {
            n11 = 0;
            observableBoolean = null;
            n10 = 0;
        }
        long l23 = l17 & (long)8;
        long l24 = l23 == l16 ? 0 : (l23 < l16 ? -1 : 1);
        if (l24 != false) {
            imageView = s22.a;
            View.OnClickListener onClickListener = s22.r;
            imageView.setOnClickListener(onClickListener);
            imageView = s22.d;
            onClickListener = s22.q;
            imageView.setOnClickListener(onClickListener);
            imageView = s22.e;
            onClickListener = s22.p;
            imageView.setOnClickListener(onClickListener);
            imageView = s22.f;
            onClickListener = s22.n;
            imageView.setOnClickListener(onClickListener);
            l14 = ViewDataBinding.getBuildSdkInt();
            int n15 = 21;
            if (l14 >= n15) {
                imageView = s22.h;
                imageView.setClipToOutline(bl3);
            }
        }
        if ((l14 = (l13 = (l18 = l17 & l21) - l16) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
            s22.b.setVisibility(n11);
            s22.m.setVisibility(n10);
            s22.c.setVisibility(n10);
            imageView = s22.e;
            imageView.setVisibility(n11);
            s22.f.setVisibility(n10);
            observableBoolean = s22.h;
            observableBoolean.setVisibility(n10);
        }
        if ((l12 = (l11 = (l17 &= (l10 = (long)10)) - l16) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            l.a.q.g0.u.n(s22.c, string2, null, null);
            s22.g.setVisibility(n12);
            d.v.f.e.c.d((View)s22.h, (String)charSequence);
            FrameLayout frameLayout = s22.h;
            View.OnClickListener onClickListener = s22.o;
            ViewBindingAdapter.setOnClick((View)frameLayout, onClickListener, bl2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.s;
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
            this.s = l10 = (long)8;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (ObservableBoolean)object;
        return this.E((ObservableBoolean)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 75;
        if (n11 == n10) {
            object = (CETemplateModel)object;
            this.C((CETemplateModel)object);
            return 1 != 0;
        } else {
            n11 = 98;
            if (n11 == n10) {
                object = (ObservableBoolean)object;
                this.D((ObservableBoolean)object);
                return 1 != 0;
            } else {
                n11 = 23;
                if (n11 != n10) return 0 != 0;
                object = (CETemplatePreviewDialog$a)object;
                this.B((CETemplatePreviewDialog$a)object);
            }
        }
        return 1 != 0;
    }
}

