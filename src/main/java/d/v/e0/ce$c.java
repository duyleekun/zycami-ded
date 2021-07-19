/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package d.v.e0;

import android.graphics.Bitmap;
import com.zhiyun.stabilizer.exception.PanoException;
import d.u.a.d;
import d.v.e0.ce;
import d.v.e0.ie.e;
import d.v.e0.ie.g;
import d.v.e0.y6;
import java.util.List;

public class ce$c
implements e {
    public final /* synthetic */ g a;
    public final /* synthetic */ int[] b;
    public final /* synthetic */ List c;
    public final /* synthetic */ List d;
    public final /* synthetic */ String e;
    public final /* synthetic */ ce f;

    public ce$c(ce ce2, g g10, int[] nArray, List list, List list2, String string2) {
        this.f = ce2;
        this.a = g10;
        this.b = nArray;
        this.c = list;
        this.d = list2;
        this.e = string2;
    }

    private /* synthetic */ void s(g object, Integer object2) {
        int n10 = (Integer)object2;
        if (n10 > 0) {
            object.a();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "Stitching failed ";
            stringBuilder.append(string2);
            stringBuilder.append(object2);
            object2 = stringBuilder.toString();
            object = new PanoException((String)object2);
            this.onFailed((Throwable)object);
        }
    }

    public void e() {
        int n10;
        Object object = this.a.b();
        Object object2 = this.b;
        int n11 = 0;
        String string2 = null;
        object2[0] = n10 = object2[0] + 1;
        if (object == null) {
            this.f.A7();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Pano frame ");
            int[] nArray = this.b;
            n11 = nArray[0];
            ((StringBuilder)object2).append(n11);
            string2 = "is null!";
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            object = new IllegalArgumentException((String)object2);
            this.onFailed((Throwable)object);
        } else {
            object2 = this.c;
            object2.add(object);
        }
    }

    public void k() {
        this.a.onStart();
    }

    public void l() {
        this.a.onCancel();
    }

    public void o() {
        Object object;
        int n10;
        Object object2 = this.d;
        int n11 = object2.size();
        if (n11 != (n10 = (object = this.c).size())) {
            object2 = this.a;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Missing panorama frame! points=");
            int n12 = this.d.size();
            charSequence.append(n12);
            charSequence.append(" frames=");
            n12 = this.c.size();
            charSequence.append(n12);
            charSequence = charSequence.toString();
            object = new IllegalArgumentException((String)charSequence);
            object2.onFailed((Throwable)object);
            return;
        }
        this.a.d();
        object2 = new Bitmap[this.c.size()];
        this.c.toArray((T[])object2);
        this.c.clear();
        object = new d();
        String string2 = this.e;
        g g10 = this.a;
        y6 y62 = new y6(this, g10);
        ((d)object).a((Bitmap[])object2, string2, y62);
    }

    public void onFailed(Throwable throwable) {
        this.a.onFailed(throwable);
    }

    public /* synthetic */ void t(g g10, Integer n10) {
        this.s(g10, n10);
    }
}

