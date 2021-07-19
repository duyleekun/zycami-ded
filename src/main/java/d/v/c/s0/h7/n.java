/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7;

import com.zhiyun.cama.camera.story.StoryZoom;
import d.v.c.s0.h7.k0;
import d.v.c.s0.h7.k0$d;
import e.a.v0.o;

public final class n
implements o {
    public final /* synthetic */ k0 a;
    public final /* synthetic */ k0$d b;

    public /* synthetic */ n(k0 k02, k0$d k0$d) {
        this.a = k02;
        this.b = k0$d;
    }

    public final Object apply(Object object) {
        k0 k02 = this.a;
        k0$d k0$d = this.b;
        object = (StoryZoom)object;
        return k02.Y(k0$d, (StoryZoom)object);
    }
}

