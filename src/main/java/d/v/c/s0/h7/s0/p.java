/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.watermark.WaterMarkBean$WaterMarkDataInfo;
import d.v.c.s0.h7.s0.y;

public final class p
implements Observer {
    public final /* synthetic */ y a;

    public /* synthetic */ p(y y10) {
        this.a = y10;
    }

    public final void onChanged(Object object) {
        y y10 = this.a;
        object = (WaterMarkBean$WaterMarkDataInfo)object;
        y10.E((WaterMarkBean$WaterMarkDataInfo)object);
    }
}

