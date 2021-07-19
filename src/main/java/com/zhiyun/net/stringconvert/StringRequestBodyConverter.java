/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.stringconvert;

import g.b0;
import g.v;
import h.m;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import k.h;
import okio.ByteString;

public class StringRequestBodyConverter
implements h {
    private static final v MEDIA_TYPE = v.j("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    public b0 convert(String object) {
        Object object2 = new m();
        OutputStream outputStream = ((m)object2).j0();
        Charset charset = UTF_8;
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        outputStreamWriter.write((String)object);
        ((Writer)outputStreamWriter).close();
        object = MEDIA_TYPE;
        object2 = ((m)object2).b0();
        return b0.create((v)object, (ByteString)object2);
    }
}

