/*
 * Decompiled with CFR 0.151.
 */
package kotlin.io;

import f.e2.m;
import java.nio.charset.CharsetDecoder;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

public final class LineReader$readLine$1
extends MutablePropertyReference0Impl {
    public LineReader$readLine$1(m m10) {
        super((Object)m10, m.class, "decoder", "getDecoder()Ljava/nio/charset/CharsetDecoder;", 0);
    }

    public Object get() {
        return m.a((m)this.receiver);
    }

    public void set(Object object) {
        m m10 = (m)this.receiver;
        object = (CharsetDecoder)object;
        m.b(m10, (CharsetDecoder)object);
    }
}

