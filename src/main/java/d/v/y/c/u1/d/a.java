/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.u1.d;

import com.zhiyun.protocol.message.usb.media.MediaType;

public abstract class a
extends d.v.y.c.u1.a {
    public MediaType b;

    public a() {
        MediaType mediaType;
        this.b = mediaType = MediaType.VIDEO_RMP;
    }

    public MediaType d() {
        return this.b;
    }

    public void e(MediaType mediaType) {
        this.b = mediaType;
    }
}

