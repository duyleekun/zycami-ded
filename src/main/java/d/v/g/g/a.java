/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package d.v.g.g;

import android.util.SparseArray;
import com.zhiyun.device.data.local.entity.FirmwareInfo;
import java.util.function.IntFunction;

public final class a
implements IntFunction {
    public final /* synthetic */ SparseArray a;

    public /* synthetic */ a(SparseArray sparseArray) {
        this.a = sparseArray;
    }

    public final Object apply(int n10) {
        return (FirmwareInfo)this.a.valueAt(n10);
    }
}

