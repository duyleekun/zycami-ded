/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package d.u.a;

import android.graphics.Bitmap;
import com.zhishen.imagetool.Helper;
import d.u.a.d$b;
import d.u.a.d$c;
import java.util.ArrayList;
import org.opencv.android.Utils;
import org.opencv.core.Mat;

public class d {
    public boolean a;
    public double b = -1.0;
    public d$c c;

    public int a(Bitmap[] object, String object2, d$c objectArray) {
        Helper helper = new Helper();
        int n10 = ((Bitmap[])object).length;
        int n11 = 0;
        if (n10 <= 0) {
            return 0;
        }
        ArrayList<Mat> arrayList = new ArrayList<Mat>();
        int n12 = ((Bitmap[])object).length;
        long[] lArray = new long[n12];
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10;
            Mat mat = new Mat();
            Bitmap bitmap = object[i10];
            Utils.a(bitmap, mat);
            arrayList.add(mat);
            lArray[i10] = l10 = mat.V();
        }
        this.c = objectArray;
        if (objectArray != null) {
            object = new d$b(this, null);
            int n13 = 2;
            objectArray = new Object[n13];
            objectArray[0] = arrayList;
            n10 = 1;
            objectArray[n10] = object2;
            object.execute(objectArray);
        } else {
            boolean bl2;
            double d10 = this.b;
            n11 = Helper.Pano(lArray, (String)object2, d10);
            object = arrayList.iterator();
            while (bl2 = object.hasNext()) {
                object2 = (Mat)object.next();
                ((Mat)object2).u0();
            }
        }
        return n11;
    }
}

