/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7;

import com.zhiyun.cama.camera.story.StoryZoom;
import com.zhiyun.stabilizer.entities.StoryAxis;
import d.v.c.s0.h7.k0;
import e.a.s0.b;
import e.a.v0.g;

public final class j
implements g {
    public final /* synthetic */ k0 a;
    public final /* synthetic */ StoryAxis b;
    public final /* synthetic */ StoryZoom c;

    public /* synthetic */ j(k0 k02, StoryAxis storyAxis, StoryZoom storyZoom) {
        this.a = k02;
        this.b = storyAxis;
        this.c = storyZoom;
    }

    public final void accept(Object object) {
        k0 k02 = this.a;
        StoryAxis storyAxis = this.b;
        StoryZoom storyZoom = this.c;
        object = (b)object;
        k02.K(storyAxis, storyZoom, (b)object);
    }
}

