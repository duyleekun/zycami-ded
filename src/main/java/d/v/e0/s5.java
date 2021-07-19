/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.stabilizer.Stabilizer;
import e.a.v0.o;

public final class s5
implements o {
    public final /* synthetic */ Stabilizer a;
    public final /* synthetic */ String[] b;

    public /* synthetic */ s5(Stabilizer stabilizer, String[] stringArray) {
        this.a = stabilizer;
        this.b = stringArray;
    }

    public final Object apply(Object object) {
        Stabilizer stabilizer = this.a;
        String[] stringArray = this.b;
        object = (Integer)object;
        return stabilizer.X4(stringArray, (Integer)object);
    }
}

