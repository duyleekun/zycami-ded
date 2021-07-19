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
import d.v.e0.q7;
import d.v.y.d.k;
import e.a.b0;
import e.a.c0;
import java.util.List;

public class ce$f2
implements c0 {
    public final /* synthetic */ List a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ce c;

    public ce$f2(ce ce2, List list, String string2) {
        this.c = ce2;
        this.a = list;
        this.b = string2;
    }

    public static /* synthetic */ void a(b0 b02, Integer object) {
        int n10 = (Integer)object;
        if (n10 > 0) {
            b02.onComplete();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "Stitching failed ";
            stringBuilder.append(string2);
            stringBuilder.append(object);
            object = stringBuilder.toString();
            PanoException panoException = new PanoException((String)object);
            b02.onError(panoException);
        }
    }

    public void subscribe(b0 b02) {
        boolean bl2;
        Object object = this.a;
        if (object != null && !(bl2 = object.isEmpty())) {
            object = this.b;
            bl2 = k.a((String)object);
            if (!bl2) {
                object = new NullPointerException("Panoramic save path is null");
                b02.onError((Throwable)object);
                return;
            }
            object = new Bitmap[this.a.size()];
            this.a.toArray((T[])object);
            this.a.clear();
            d d10 = new d();
            String string2 = this.b;
            q7 q72 = new q7(b02);
            d10.a((Bitmap[])object, string2, q72);
            return;
        }
        b02.onComplete();
    }
}

