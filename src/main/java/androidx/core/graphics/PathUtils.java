/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.graphics.PointF
 */
package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.core.graphics.PathSegment;
import java.util.ArrayList;
import java.util.Collection;

public final class PathUtils {
    private PathUtils() {
    }

    public static Collection flatten(Path path) {
        return PathUtils.flatten(path, 0.5f);
    }

    public static Collection flatten(Path object, float f10) {
        object = object.approximate(f10);
        int n10 = ((Path)object).length / 3;
        ArrayList<PathSegment> arrayList = new ArrayList<PathSegment>(n10);
        for (int i10 = 1; i10 < n10; ++i10) {
            int n11 = i10 * 3;
            int n12 = (i10 + -1) * 3;
            Path path = object[n11];
            int n13 = n11 + 1;
            Path path2 = object[n13];
            Path path3 = object[n11 += 2];
            Path path4 = object[n12];
            int n14 = n12 + 1;
            Path path5 = object[n14];
            Path path6 = object[n12 += 2];
            Object object2 = path == path4 ? 0 : (path > path4 ? 1 : -1);
            if (object2 == false || (object2 = path2 == path5 ? 0 : (path2 > path5 ? 1 : -1)) == false && (object2 = path3 == path6 ? 0 : (path3 > path6 ? 1 : -1)) == false) continue;
            PointF pointF = new PointF((float)path5, (float)path6);
            PointF pointF2 = new PointF((float)path2, (float)path3);
            PathSegment pathSegment = new PathSegment(pointF, (float)path4, pointF2, (float)path);
            arrayList.add(pathSegment);
        }
        return arrayList;
    }
}

