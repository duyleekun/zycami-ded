/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package b.a.a.d;

import android.util.Size;
import androidx.camera.camera2.internal.MeteringRepeatingSession;
import java.util.Comparator;

public final class x0
implements Comparator {
    public static final /* synthetic */ x0 a;

    static {
        x0 x02;
        a = x02 = new x0();
    }

    public final int compare(Object object, Object object2) {
        object = (Size)object;
        object2 = (Size)object2;
        return MeteringRepeatingSession.a((Size)object, (Size)object2);
    }
}

