/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.ScrollView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.camera.CameraFragment$j;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.s0.d7.z;
import d.v.c.w0.ud;
import d.v.c.w0.vd$a;
import d.v.c.w0.vd$b;
import d.v.c.w0.vd$c;

public class vd
extends ud
implements b$a {
    private static final ViewDataBinding$IncludedLayouts O;
    private static final SparseIntArray P;
    private final TextView A;
    private final TextView B;
    private final RelativeLayout C;
    private final View.OnClickListener D;
    private final View.OnClickListener E;
    private final View.OnClickListener F;
    private final View.OnClickListener G;
    private final View.OnClickListener H;
    private final View.OnClickListener I;
    private final View.OnClickListener J;
    private InverseBindingListener K;
    private InverseBindingListener L;
    private InverseBindingListener M;
    private long N;
    private final RelativeLayout z;

    static {
        SparseIntArray sparseIntArray;
        P = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363213, 18);
        sparseIntArray.put(2131363489, 19);
        sparseIntArray.put(2131362686, 20);
        sparseIntArray.put(2131362687, 21);
        sparseIntArray.put(2131362688, 22);
        sparseIntArray.put(2131363564, 23);
        sparseIntArray.put(2131362689, 24);
        sparseIntArray.put(2131362873, 25);
        sparseIntArray.put(2131363694, 26);
    }

    public vd(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = O;
        SparseIntArray sparseIntArray = P;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 27, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private vd(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        vd vd2 = this;
        Object object = this;
        Object object2 = view;
        CheckBox checkBox = (CheckBox)objectArray[8];
        ImageView imageView = (ImageView)objectArray[16];
        CheckBox checkBox2 = (CheckBox)objectArray[9];
        CheckBox checkBox3 = (CheckBox)objectArray[10];
        ImageView imageView2 = (ImageView)objectArray[20];
        ImageView imageView3 = (ImageView)objectArray[21];
        ImageView imageView4 = (ImageView)objectArray[22];
        ImageView imageView5 = (ImageView)objectArray[24];
        RecyclerView recyclerView = (RecyclerView)objectArray[25];
        RecyclerView recyclerView2 = (RecyclerView)objectArray[14];
        RelativeLayout relativeLayout = (RelativeLayout)objectArray[5];
        RelativeLayout relativeLayout2 = (RelativeLayout)objectArray[3];
        RelativeLayout relativeLayout3 = (RelativeLayout)objectArray[12];
        RelativeLayout relativeLayout4 = (RelativeLayout)objectArray[1];
        RelativeLayout relativeLayout5 = (RelativeLayout)objectArray[15];
        ScrollView scrollView = (ScrollView)objectArray[18];
        TextView textView = (TextView)objectArray[4];
        TextView textView2 = (TextView)objectArray[6];
        TextView textView3 = (TextView)objectArray[19];
        TextView textView4 = (TextView)objectArray[2];
        TextView textView5 = (TextView)objectArray[13];
        TextView textView6 = (TextView)objectArray[23];
        View view2 = (View)objectArray[26];
        int n10 = 7;
        super(dataBindingComponent, view, n10, checkBox, imageView, checkBox2, checkBox3, imageView2, imageView3, imageView4, imageView5, recyclerView, recyclerView2, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, scrollView, textView, textView2, textView3, textView4, textView5, textView6, view2);
        this.K = object = new vd$a(this);
        this.L = object = new vd$b(this);
        this.M = object = new vd$c(this);
        this.N = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.j.setTag(null);
        object = (RelativeLayout)objectArray[0];
        this.z = object;
        object.setTag(null);
        object = (TextView)objectArray[11];
        this.A = object;
        object.setTag(null);
        object = (TextView)objectArray[17];
        this.B = object;
        object.setTag(null);
        int n11 = 7;
        vd2 = (RelativeLayout)objectArray[n11];
        this.C = vd2;
        vd2.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        this.n.setTag(null);
        this.o.setTag(null);
        this.q.setTag(null);
        this.r.setTag(null);
        this.t.setTag(null);
        this.u.setTag(null);
        this.setRootTag(view);
        super(this, 3);
        this.D = object2;
        super(this, n11);
        this.E = object2;
        object = new b(this, 4);
        this.F = object;
        object = new b(this, 5);
        this.G = object;
        object = new b(this, 1);
        this.H = object;
        object = new b(this, 6);
        this.I = object;
        object = new b(this, 2);
        this.J = object;
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
                long l10 = this.N;
                long l11 = 64;
                this.N = l10 |= l11;
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
                long l10 = this.N;
                long l11 = 8;
                this.N = l10 |= l11;
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
                long l10 = this.N;
                long l11 = 16;
                this.N = l10 |= l11;
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
                long l10 = this.N;
                long l11 = 2;
                this.N = l10 |= l11;
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
                long l10 = this.N;
                long l11 = 32;
                this.N = l10 |= l11;
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
                long l10 = this.N;
                long l11 = 4;
                this.N = l10 |= l11;
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
    private boolean I(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.N;
                long l11 = 1L;
                this.N = l10 |= l11;
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
    public void A(CameraFragment$j cameraFragment$j) {
        this.x = cameraFragment$j;
        synchronized (this) {
            long l10 = this.N;
            long l11 = 128L;
            this.N = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(z z10) {
        this.y = z10;
        synchronized (this) {
            long l10 = this.N;
            long l11 = 256L;
            this.N = l10 |= l11;
        }
        this.notifyPropertyChanged(80);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        boolean bl2 = true;
        switch (n10) {
            default: {
                break;
            }
            case 7: {
                CameraFragment$j cameraFragment$j = this.x;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.o0();
                break;
            }
            case 6: {
                z z10 = this.y;
                if (z10 == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                z10.z0();
                break;
            }
            case 5: {
                CameraFragment$j cameraFragment$j = this.x;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.f();
                break;
            }
            case 4: {
                CameraFragment$j cameraFragment$j = this.x;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.k0(view);
                break;
            }
            case 3: {
                CameraFragment$j cameraFragment$j = this.x;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.k0(view);
                break;
            }
            case 2: {
                CameraFragment$j cameraFragment$j = this.x;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.k0(view);
                break;
            }
            case 1: {
                CameraFragment$j cameraFragment$j = this.x;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.k0(view);
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
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [3 : 1681->1683)] java.lang.Throwable
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
            long l10 = this.N;
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
            this.N = l10 = 512L;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        switch (n10) {
            default: {
                return false;
            }
            case 6: {
                object = (MutableLiveData)object;
                return this.C((MutableLiveData)object, n11);
            }
            case 5: {
                object = (MutableLiveData)object;
                return this.G((MutableLiveData)object, n11);
            }
            case 4: {
                object = (MutableLiveData)object;
                return this.E((MutableLiveData)object, n11);
            }
            case 3: {
                object = (MutableLiveData)object;
                return this.D((MutableLiveData)object, n11);
            }
            case 2: {
                object = (MutableLiveData)object;
                return this.H((MutableLiveData)object, n11);
            }
            case 1: {
                object = (MutableLiveData)object;
                return this.F((MutableLiveData)object, n11);
            }
            case 0: 
        }
        object = (LiveData)object;
        return this.I((LiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (CameraFragment$j)object;
            this.A((CameraFragment$j)object);
            return 1 != 0;
        } else {
            n11 = 80;
            if (n11 != n10) return 0 != 0;
            object = (z)object;
            this.B((z)object);
        }
        return 1 != 0;
    }
}

