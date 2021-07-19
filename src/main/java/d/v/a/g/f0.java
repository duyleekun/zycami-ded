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
package d.v.a.g;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.account.R$id;
import com.zhiyun.account.data.api.entity.BindThirdEntity;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.account.set.privacy.BindThirdFragment$b;
import com.zhiyun.account.widget.StatusView;
import d.v.a.d;
import d.v.a.g.e0;
import d.v.a.g.f0$a;
import d.v.a.h.a.a$a;
import d.v.a.j.c.y;

public class f0
extends e0
implements a$a {
    private static final ViewDataBinding$IncludedLayouts v;
    private static final SparseIntArray w;
    private final ConstraintLayout g;
    private final FrameLayout h;
    private final TextView i;
    private final FrameLayout j;
    private final TextView k;
    private final FrameLayout l;
    private final TextView m;
    private final FrameLayout n;
    private final TextView o;
    private final View.OnClickListener p;
    private final View.OnClickListener q;
    private final View.OnClickListener r;
    private final View.OnClickListener s;
    private f0$a t;
    private long u;

    static {
        SparseIntArray sparseIntArray;
        w = sparseIntArray = new SparseIntArray();
        int n10 = R$id.fl_titlebar;
        sparseIntArray.put(n10, 11);
        n10 = R$id.tv_title_center;
        sparseIntArray.put(n10, 12);
    }

    public f0(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = v;
        SparseIntArray sparseIntArray = w;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 13, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private f0(DataBindingComponent object, View object2, Object[] textView) {
        FrameLayout frameLayout;
        Object object3;
        Object object4;
        Object object5 = object4 = textView[11];
        object5 = (FrameLayout)object4;
        int n10 = 1;
        Object object6 = object3 = textView[n10];
        object6 = (ImageView)object3;
        Object object7 = object3 = textView[10];
        object7 = (StatusView)((Object)object3);
        Object object8 = object3 = textView[12];
        object8 = (TextView)object3;
        object3 = this;
        DataBindingComponent dataBindingComponent = object;
        View view = object2;
        super(object, (View)object2, 4, (FrameLayout)object5, (ImageView)object6, (StatusView)((Object)object7), (TextView)object8);
        this.u = -1;
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)textView[0]);
        this.g = object;
        object.setTag(null);
        int n11 = 2;
        dataBindingComponent = (FrameLayout)textView[n11];
        this.h = dataBindingComponent;
        dataBindingComponent.setTag(null);
        int n12 = 3;
        view = (TextView)textView[n12];
        this.i = view;
        view.setTag(null);
        int n13 = 4;
        this.j = frameLayout = (FrameLayout)textView[n13];
        frameLayout.setTag(null);
        frameLayout = (TextView)textView[5];
        this.k = frameLayout;
        frameLayout.setTag(null);
        this.l = frameLayout = (FrameLayout)textView[6];
        frameLayout.setTag(null);
        frameLayout = (TextView)textView[7];
        this.m = frameLayout;
        frameLayout.setTag(null);
        this.n = frameLayout = (FrameLayout)textView[8];
        frameLayout.setTag(null);
        this.o = textView = (TextView)textView[9];
        textView.setTag(null);
        this.c.setTag(null);
        this.setRootTag((View)object2);
        super(this, n13);
        this.p = object2;
        super(this, n11);
        this.q = object2;
        super(this, n12);
        this.r = object;
        super(this, n10);
        this.s = object;
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
                long l10 = this.u;
                long l11 = 4;
                this.u = l10 |= l11;
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
                long l10 = this.u;
                long l11 = 2;
                this.u = l10 |= l11;
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
        int n11 = d.v.a.d.c;
        if (n10 == n11) {
            synchronized (this) {
                long l10 = this.u;
                long l11 = 8;
                this.u = l10 |= l11;
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
        int n11 = d.v.a.d.c;
        if (n10 == n11) {
            synchronized (this) {
                long l10 = this.u;
                long l11 = 1L;
                this.u = l10 |= l11;
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
    public void A(BindThirdFragment$b bindThirdFragment$b) {
        this.f = bindThirdFragment$b;
        synchronized (this) {
            long l10 = this.u;
            long l11 = 16;
            this.u = l10 |= l11;
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
    public void B(y y10) {
        this.e = y10;
        synchronized (this) {
            long l10 = this.u;
            long l11 = 32;
            this.u = l10 |= l11;
        }
        int n10 = d.v.a.d.W1;
        this.notifyPropertyChanged(n10);
        super.requestRebind();
    }

    public final void a(int n10, View object) {
        int n11 = 0;
        object = null;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 != n13) {
                    n13 = 4;
                    if (n10 == n13) {
                        BindThirdFragment$b bindThirdFragment$b = this.f;
                        Object object2 = this.e;
                        int n14 = bindThirdFragment$b != null ? n12 : 0;
                        if (n14 != 0 && (n14 = object2 != null ? n12 : 0) != 0) {
                            object2 = ((y)object2).n;
                            if (object2 != null) {
                                n11 = n12;
                            }
                            if (n11 != 0) {
                                object = (BindThirdEntity)((LiveData)object2).getValue();
                                ThirdPlatform thirdPlatform = ThirdPlatform.FACEBOOK;
                                bindThirdFragment$b.a(thirdPlatform, (BindThirdEntity)object);
                            }
                        }
                    }
                } else {
                    BindThirdFragment$b bindThirdFragment$b = this.f;
                    Object object3 = this.e;
                    int n15 = bindThirdFragment$b != null ? n12 : 0;
                    if (n15 != 0 && (n15 = object3 != null ? n12 : 0) != 0) {
                        object3 = ((y)object3).m;
                        if (object3 != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            object = (BindThirdEntity)((LiveData)object3).getValue();
                            ThirdPlatform thirdPlatform = ThirdPlatform.QQ;
                            bindThirdFragment$b.a(thirdPlatform, (BindThirdEntity)object);
                        }
                    }
                }
            } else {
                BindThirdFragment$b bindThirdFragment$b = this.f;
                Object object4 = this.e;
                int n16 = bindThirdFragment$b != null ? n12 : 0;
                if (n16 != 0 && (n16 = object4 != null ? n12 : 0) != 0) {
                    object4 = ((y)object4).l;
                    if (object4 != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        object = (BindThirdEntity)((LiveData)object4).getValue();
                        ThirdPlatform thirdPlatform = ThirdPlatform.WEIBO;
                        bindThirdFragment$b.a(thirdPlatform, (BindThirdEntity)object);
                    }
                }
            }
        } else {
            BindThirdFragment$b bindThirdFragment$b = this.f;
            Object object5 = this.e;
            int n17 = bindThirdFragment$b != null ? n12 : 0;
            if (n17 != 0 && (n17 = object5 != null ? n12 : 0) != 0) {
                object5 = ((y)object5).k;
                if (object5 != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    object = (BindThirdEntity)((LiveData)object5).getValue();
                    ThirdPlatform thirdPlatform = ThirdPlatform.WE_CHAT;
                    bindThirdFragment$b.a(thirdPlatform, (BindThirdEntity)object);
                }
            }
        }
    }

    /*
     * Exception decompiling
     */
    public void executeBindings() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [3 : 933->935)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.u;
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
            this.u = l10 = (long)64;
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
                        return false;
                    }
                    object = (MutableLiveData)object;
                    return this.E((MutableLiveData)object, n11);
                }
                object = (MutableLiveData)object;
                return this.C((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.D((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.F((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = d.v.a.d.x;
        if (n11 == n10) {
            object = (BindThirdFragment$b)object;
            this.A((BindThirdFragment$b)object);
            return 1 != 0;
        } else {
            n11 = d.v.a.d.W1;
            if (n11 != n10) return 0 != 0;
            object = (y)object;
            this.B((y)object);
        }
        return 1 != 0;
    }
}

