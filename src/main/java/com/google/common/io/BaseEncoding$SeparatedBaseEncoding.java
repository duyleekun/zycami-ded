/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import com.google.common.math.IntMath;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;

public final class BaseEncoding$SeparatedBaseEncoding
extends BaseEncoding {
    private final int afterEveryChars;
    private final BaseEncoding delegate;
    private final String separator;

    public BaseEncoding$SeparatedBaseEncoding(BaseEncoding object, String string2, int n10) {
        boolean bl2;
        object = (BaseEncoding)Preconditions.checkNotNull(object);
        this.delegate = object;
        this.separator = object = (String)Preconditions.checkNotNull(string2);
        this.afterEveryChars = n10;
        if (n10 > 0) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Preconditions.checkArgument(bl2, "Cannot add a separator after every %s chars", n10);
    }

    public boolean canDecode(CharSequence charSequence) {
        int n10;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            String string2 = this.separator;
            n10 = charSequence.charAt(i10);
            int n11 = string2.indexOf(n10);
            if (n11 >= 0) continue;
            stringBuilder.append((char)n10);
        }
        return this.delegate.canDecode(stringBuilder);
    }

    public int decodeTo(byte[] byArray, CharSequence charSequence) {
        char c10;
        int n10 = charSequence.length();
        StringBuilder stringBuilder = new StringBuilder(n10);
        for (n10 = 0; n10 < (c10 = charSequence.length()); ++n10) {
            String string2 = this.separator;
            c10 = charSequence.charAt(n10);
            int n11 = string2.indexOf(c10);
            if (n11 >= 0) continue;
            stringBuilder.append(c10);
        }
        return this.delegate.decodeTo(byArray, stringBuilder);
    }

    public InputStream decodingStream(Reader reader) {
        BaseEncoding baseEncoding = this.delegate;
        String string2 = this.separator;
        reader = BaseEncoding.ignoringReader(reader, string2);
        return baseEncoding.decodingStream(reader);
    }

    public void encodeTo(Appendable appendable, byte[] byArray, int n10, int n11) {
        BaseEncoding baseEncoding = this.delegate;
        String string2 = this.separator;
        int n12 = this.afterEveryChars;
        appendable = BaseEncoding.separatingAppendable(appendable, string2, n12);
        baseEncoding.encodeTo(appendable, byArray, n10, n11);
    }

    public OutputStream encodingStream(Writer writer) {
        BaseEncoding baseEncoding = this.delegate;
        String string2 = this.separator;
        int n10 = this.afterEveryChars;
        writer = BaseEncoding.separatingWriter(writer, string2, n10);
        return baseEncoding.encodingStream(writer);
    }

    public BaseEncoding lowerCase() {
        BaseEncoding baseEncoding = this.delegate.lowerCase();
        String string2 = this.separator;
        int n10 = this.afterEveryChars;
        return baseEncoding.withSeparator(string2, n10);
    }

    public int maxDecodedSize(int n10) {
        return this.delegate.maxDecodedSize(n10);
    }

    public int maxEncodedSize(int n10) {
        n10 = this.delegate.maxEncodedSize(n10);
        int n11 = this.separator.length();
        int n12 = n10 + -1;
        n12 = Math.max(0, n12);
        int n13 = this.afterEveryChars;
        RoundingMode roundingMode = RoundingMode.FLOOR;
        n12 = IntMath.divide(n12, n13, roundingMode);
        return n10 + (n11 *= n12);
    }

    public BaseEncoding omitPadding() {
        BaseEncoding baseEncoding = this.delegate.omitPadding();
        String string2 = this.separator;
        int n10 = this.afterEveryChars;
        return baseEncoding.withSeparator(string2, n10);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.delegate;
        stringBuilder.append(object);
        stringBuilder.append(".withSeparator(\"");
        object = this.separator;
        stringBuilder.append((String)object);
        stringBuilder.append("\", ");
        int n10 = this.afterEveryChars;
        stringBuilder.append(n10);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public CharSequence trimTrailingPadding(CharSequence charSequence) {
        return this.delegate.trimTrailingPadding(charSequence);
    }

    public BaseEncoding upperCase() {
        BaseEncoding baseEncoding = this.delegate.upperCase();
        String string2 = this.separator;
        int n10 = this.afterEveryChars;
        return baseEncoding.withSeparator(string2, n10);
    }

    public BaseEncoding withPadChar(char c10) {
        BaseEncoding baseEncoding = this.delegate.withPadChar(c10);
        String string2 = this.separator;
        int n10 = this.afterEveryChars;
        return baseEncoding.withSeparator(string2, n10);
    }

    public BaseEncoding withSeparator(String object, int n10) {
        object = new UnsupportedOperationException("Already have a separator");
        throw object;
    }
}

