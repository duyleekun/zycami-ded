/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.PointF
 */
package d.v.c.s0;

import android.graphics.Matrix;
import android.graphics.PointF;
import d.v.c.s0.w6;
import d.v.d.i.f.h$a;
import java.util.Comparator;

public final class l6
implements Comparator {
    public final /* synthetic */ w6 a;
    public final /* synthetic */ Matrix b;
    public final /* synthetic */ PointF c;

    public /* synthetic */ l6(w6 w62, Matrix matrix, PointF pointF) {
        this.a = w62;
        this.b = matrix;
        this.c = pointF;
    }

    public final int compare(Object object, Object object2) {
        w6 w62 = this.a;
        Matrix matrix = this.b;
        PointF pointF = this.c;
        object = (h$a)object;
        object2 = (h$a)object2;
        return w62.r(matrix, pointF, (h$a)object, (h$a)object2);
    }
}

