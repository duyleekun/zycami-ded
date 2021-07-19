/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 */
package d.v.e0;

import android.graphics.Point;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.fe;
import e.a.v0.o;

public final class eb
implements o {
    public final /* synthetic */ Point a;

    public /* synthetic */ eb(Point point) {
        this.a = point;
    }

    public final Object apply(Object object) {
        Point point = this.a;
        object = (Stabilizer)object;
        return fe.m(point, (Stabilizer)object);
    }
}

