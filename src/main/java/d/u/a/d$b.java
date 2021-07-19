/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 */
package d.u.a;

import android.os.AsyncTask;
import com.zhishen.imagetool.Helper;
import d.u.a.d;
import d.u.a.d$a;
import java.util.Iterator;
import java.util.List;
import org.opencv.core.Mat;

public class d$b
extends AsyncTask {
    public final /* synthetic */ d a;

    private d$b(d d10) {
        this.a = d10;
    }

    public /* synthetic */ d$b(d d10, d$a d$a) {
        this(d10);
    }

    public Integer a(Object ... object) {
        boolean bl2;
        int n10;
        Iterator iterator2 = null;
        Object object2 = (List)object[0];
        object = (String)object[1];
        int n11 = object2.size();
        long[] lArray = new long[n11];
        for (int i10 = 0; i10 < (n10 = object2.size()); ++i10) {
            long l10;
            Mat mat = (Mat)object2.get(i10);
            lArray[i10] = l10 = mat.V();
        }
        double d10 = this.a.b;
        int n12 = Helper.Pano(lArray, (String)object, d10);
        iterator2 = object2.iterator();
        while (bl2 = iterator2.hasNext()) {
            object2 = (Mat)iterator2.next();
            ((Mat)object2).u0();
        }
        return n12;
    }

    public void b(Integer n10) {
        super.onPostExecute((Object)n10);
        this.a.c.a(n10);
    }
}

