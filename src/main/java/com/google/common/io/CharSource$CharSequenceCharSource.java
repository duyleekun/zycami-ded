/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.io.CharSequenceReader;
import com.google.common.io.CharSource;
import com.google.common.io.CharSource$CharSequenceCharSource$1;
import com.google.common.io.LineProcessor;
import java.io.Reader;
import java.util.Iterator;

public class CharSource$CharSequenceCharSource
extends CharSource {
    private static final Splitter LINE_SPLITTER = Splitter.onPattern("\r\n|\n|\r");
    public final CharSequence seq;

    public CharSource$CharSequenceCharSource(CharSequence charSequence) {
        this.seq = charSequence = (CharSequence)Preconditions.checkNotNull(charSequence);
    }

    public static /* synthetic */ Splitter access$100() {
        return LINE_SPLITTER;
    }

    private Iterator linesIterator() {
        CharSource$CharSequenceCharSource$1 charSource$CharSequenceCharSource$1 = new CharSource$CharSequenceCharSource$1(this);
        return charSource$CharSequenceCharSource$1;
    }

    public boolean isEmpty() {
        CharSequence charSequence = this.seq;
        int n10 = charSequence.length();
        if (!n10) {
            n10 = 1;
        } else {
            n10 = 0;
            charSequence = null;
        }
        return n10 != 0;
    }

    public long length() {
        return this.seq.length();
    }

    public Optional lengthIfKnown() {
        return Optional.of(this.seq.length());
    }

    public Reader openStream() {
        CharSequence charSequence = this.seq;
        CharSequenceReader charSequenceReader = new CharSequenceReader(charSequence);
        return charSequenceReader;
    }

    public String read() {
        return this.seq.toString();
    }

    public String readFirstLine() {
        Object object = this.linesIterator();
        boolean bl2 = object.hasNext();
        object = bl2 ? (String)object.next() : null;
        return object;
    }

    public ImmutableList readLines() {
        return ImmutableList.copyOf(this.linesIterator());
    }

    public Object readLines(LineProcessor lineProcessor) {
        String string2;
        boolean bl2;
        Iterator iterator2 = this.linesIterator();
        while ((bl2 = iterator2.hasNext()) && (bl2 = lineProcessor.processLine(string2 = (String)iterator2.next()))) {
        }
        return lineProcessor.getResult();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CharSource.wrap(");
        String string2 = Ascii.truncate(this.seq, 30, "...");
        stringBuilder.append(string2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

