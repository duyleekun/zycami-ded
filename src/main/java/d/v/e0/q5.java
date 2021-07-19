/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.constants.Model;
import com.zhiyun.protocol.constants.PhoneControlMode;
import com.zhiyun.stabilizer.Stabilizer;
import e.a.v0.o;

public final class q5
implements o {
    public final /* synthetic */ PhoneControlMode a;

    public /* synthetic */ q5(PhoneControlMode phoneControlMode) {
        this.a = phoneControlMode;
    }

    public final Object apply(Object object) {
        PhoneControlMode phoneControlMode = this.a;
        object = (Model)((Object)object);
        return Stabilizer.H5(phoneControlMode, (Model)((Object)object));
    }
}

