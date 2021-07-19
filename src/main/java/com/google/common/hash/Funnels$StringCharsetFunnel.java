/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels$StringCharsetFunnel$SerializedForm;
import com.google.common.hash.PrimitiveSink;
import java.io.Serializable;
import java.nio.charset.Charset;

public class Funnels$StringCharsetFunnel
implements Funnel,
Serializable {
    private final Charset charset;

    public Funnels$StringCharsetFunnel(Charset charset) {
        this.charset = charset = (Charset)Preconditions.checkNotNull(charset);
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Funnels$StringCharsetFunnel;
        if (bl2) {
            object = (Funnels$StringCharsetFunnel)object;
            Charset charset = this.charset;
            object = ((Funnels$StringCharsetFunnel)object).charset;
            return charset.equals(object);
        }
        return false;
    }

    public void funnel(CharSequence charSequence, PrimitiveSink primitiveSink) {
        Charset charset = this.charset;
        primitiveSink.putString(charSequence, charset);
    }

    public int hashCode() {
        int n10 = Funnels$StringCharsetFunnel.class.hashCode();
        int n11 = this.charset.hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Funnels.stringFunnel(");
        String string2 = this.charset.name();
        stringBuilder.append(string2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public Object writeReplace() {
        Charset charset = this.charset;
        Funnels$StringCharsetFunnel$SerializedForm funnels$StringCharsetFunnel$SerializedForm = new Funnels$StringCharsetFunnel$SerializedForm(charset);
        return funnels$StringCharsetFunnel$SerializedForm;
    }
}

