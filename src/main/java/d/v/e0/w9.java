/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.constants.Model;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.ce;
import e.a.v0.r;

public final class w9
implements r {
    public final /* synthetic */ ce a;
    public final /* synthetic */ Model[] b;

    public /* synthetic */ w9(ce ce2, Model[] modelArray) {
        this.a = ce2;
        this.b = modelArray;
    }

    public final boolean test(Object object) {
        ce ce2 = this.a;
        Model[] modelArray = this.b;
        object = (Stabilizer)object;
        return ce2.B4(modelArray, (Stabilizer)object);
    }
}

