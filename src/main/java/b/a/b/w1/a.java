/*
 * Decompiled with CFR 0.151.
 */
package b.a.b.w1;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.impl.CameraFilters;
import java.util.List;

public final class a
implements CameraFilter {
    public static final /* synthetic */ a a;

    static {
        a a10;
        a = a10 = new a();
    }

    public final List filter(List list) {
        CameraFilters.a(list);
        return list;
    }
}

