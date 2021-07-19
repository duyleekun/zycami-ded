/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.util.SparseArray
 */
package d.o.a.a.a.a.b;

import android.net.Uri;
import android.util.SparseArray;
import com.quvideo.mobile.external.component.cloudcomposite.core.OooO00o;
import com.quvideo.mobile.external.component.cloudcomposite.core.OooO0OO$OooO00o;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.ICompositeTask;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.OooO00o$OooO00o;
import d.o.a.a.a.a.b.b;
import d.o.a.a.a.a.b.b$d$a;
import e.a.b0;

public class b$d$a$a
implements OooO00o$OooO00o {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ OooO0OO$OooO00o b;
    public final /* synthetic */ SparseArray c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int[] f;
    public final /* synthetic */ b$d$a g;

    public b$d$a$a(b$d$a a10, b0 b02, OooO0OO$OooO00o oooO0OO$OooO00o, SparseArray sparseArray, int n10, int n11, int[] nArray) {
        this.g = a10;
        this.a = b02;
        this.b = oooO0OO$OooO00o;
        this.c = sparseArray;
        this.d = n10;
        this.e = n11;
        this.f = nArray;
    }

    public void OooO00o(Uri object, int n10) {
        object = d.o.a.a.a.a.b.b.v(this.g.b.a);
        if (object != null) {
            Object object2;
            int n11;
            object = this.c;
            int n12 = this.d;
            Integer n13 = n10;
            object.put(n12, (Object)n13);
            object = null;
            n13 = null;
            n12 = 0;
            Object object3 = null;
            for (n10 = 0; n10 < (n11 = this.e); ++n10) {
                object2 = this.c;
                Integer n14 = 0;
                object2 = (Integer)object2.get(n10, (Object)n14);
                n11 = (Integer)object2;
                n12 += n11;
            }
            n10 = Math.min(100, n12 /= n11);
            if ((n10 = Math.max(0, n10)) < (n11 = (object3 = this.f)[0])) {
                n10 = object3[0];
            }
            object3 = d.o.a.a.a.a.b.b.v(this.g.b.a);
            object2 = this.g.b.a;
            object3.onUploadProgress((ICompositeTask)object2, n10);
            object3 = this.f;
            object3[0] = n10;
        }
    }

    public void OooO00o(Uri object, String object2) {
        object = this.a;
        boolean bl2 = object.isDisposed();
        if (!bl2) {
            this.b.OooO00o((String)object2);
            object = this.a;
            object2 = Boolean.TRUE;
            object.onNext(object2);
        }
    }

    public void OooO00o(String object, int n10) {
        b0 b02 = this.a;
        boolean bl2 = b02.isDisposed();
        if (!bl2) {
            b02 = this.a;
            OooO00o oooO00o = new OooO00o(n10, (String)object);
            b02.onError(oooO00o);
            object = this.a;
            object.onComplete();
        }
    }
}

