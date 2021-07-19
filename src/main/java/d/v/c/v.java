/*
 * Decompiled with CFR 0.151.
 */
package d.v.c;

import com.zhiyun.cama.data.api.entity.sticker.AssetsStickerListBean$AssetsStickerBean;
import d.v.c.m0;
import java.util.function.Predicate;

public final class v
implements Predicate {
    public static final /* synthetic */ v a;

    static {
        v v10;
        a = v10 = new v();
    }

    public final boolean test(Object object) {
        return m0.r((AssetsStickerListBean$AssetsStickerBean)object);
    }
}

