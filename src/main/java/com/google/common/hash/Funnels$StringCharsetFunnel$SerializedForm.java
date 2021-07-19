/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.Funnels;
import java.io.Serializable;
import java.nio.charset.Charset;

public class Funnels$StringCharsetFunnel$SerializedForm
implements Serializable {
    private static final long serialVersionUID;
    private final String charsetCanonicalName;

    public Funnels$StringCharsetFunnel$SerializedForm(Charset object) {
        this.charsetCanonicalName = object = ((Charset)object).name();
    }

    private Object readResolve() {
        return Funnels.stringFunnel(Charset.forName(this.charsetCanonicalName));
    }
}

