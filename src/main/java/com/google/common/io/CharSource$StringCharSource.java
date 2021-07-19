/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource$CharSequenceCharSource;
import com.google.common.io.Closer;
import java.io.Closeable;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;

public class CharSource$StringCharSource
extends CharSource$CharSequenceCharSource {
    public CharSource$StringCharSource(String string2) {
        super(string2);
    }

    public long copyTo(CharSink object) {
        Preconditions.checkNotNull(object);
        Closer closer = Closer.create();
        try {
            object = ((CharSink)object).openStream();
        }
        catch (Throwable throwable) {
            RuntimeException runtimeException;
            try {
                runtimeException = closer.rethrow(throwable);
            }
            catch (Throwable throwable2) {
                closer.close();
                throw throwable2;
            }
            throw runtimeException;
        }
        object = closer.register((Closeable)object);
        object = (Writer)object;
        CharSequence charSequence = this.seq;
        charSequence = (String)charSequence;
        ((Writer)object).write((String)charSequence);
        object = this.seq;
        long l10 = object.length();
        closer.close();
        return l10;
    }

    public long copyTo(Appendable appendable) {
        CharSequence charSequence = this.seq;
        appendable.append(charSequence);
        return this.seq.length();
    }

    public Reader openStream() {
        String string2 = (String)this.seq;
        StringReader stringReader = new StringReader(string2);
        return stringReader;
    }
}

