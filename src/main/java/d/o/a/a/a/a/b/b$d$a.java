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
import com.quvideo.mobile.external.component.cloudcomposite.core.OooO0O0;
import com.quvideo.mobile.external.component.cloudcomposite.core.OooO0OO$OooO00o;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.MediaType;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.OooO00o;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.OooO00o$OooO00o;
import d.o.a.a.a.a.b.b;
import d.o.a.a.a.a.b.b$d;
import d.o.a.a.a.a.b.b$d$a$a;
import e.a.b0;
import e.a.c0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b$d$a
implements c0 {
    public final /* synthetic */ List a;
    public final /* synthetic */ b$d b;

    public b$d$a(b$d b$d, List list) {
        this.b = b$d;
        this.a = list;
    }

    public void subscribe(b0 b02) {
        int n10;
        b$d$a b$d$a = this;
        int n11 = this.a.size();
        int n12 = 1;
        int[] nArray = new int[n12];
        nArray[0] = 0;
        Object object = new SparseArray();
        Object object2 = this.a;
        Iterator iterator2 = object2.iterator();
        int n13 = 0;
        while ((n10 = iterator2.hasNext()) != 0) {
            Object object3 = object2 = iterator2.next();
            object3 = (OooO0OO$OooO00o)object2;
            object2 = (object2 = ((OooO0OO$OooO00o)object3).OooO00o()) == null ? ((OooO0OO$OooO00o)object3).OooO0OO() : ((OooO0OO$OooO00o)object3).OooO00o();
            Object object4 = object2;
            object2 = 0;
            object.put(n13, object2);
            OooO00o oooO00o = OooO0O0.OooO0O0().OooO0OO();
            MediaType mediaType = ((OooO0OO$OooO00o)object3).OooO0O0();
            Object object5 = this;
            SparseArray sparseArray = object;
            object = oooO00o;
            List list = object4;
            object4 = nArray;
            object2 = new b$d$a$a(this, b02, (OooO0OO$OooO00o)object3, sparseArray, n13, n11, nArray);
            object2 = oooO00o.OooO00o((Uri)list, mediaType, (OooO00o$OooO00o)object2);
            object5 = d.o.a.a.a.a.b.b.x(b$d$a.b.a);
            ((ArrayList)object5).add(object2);
            n10 = 1;
            n13 += n10;
            n12 = n10;
            object = sparseArray;
        }
    }
}

