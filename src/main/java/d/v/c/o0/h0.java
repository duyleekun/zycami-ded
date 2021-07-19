/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import com.zhiyun.cama.album.AlbumSection;
import java.util.List;
import java.util.function.IntFunction;

public final class h0
implements IntFunction {
    public final /* synthetic */ List a;

    public /* synthetic */ h0(List list) {
        this.a = list;
    }

    public final Object apply(int n10) {
        return (AlbumSection)this.a.get(n10);
    }
}

