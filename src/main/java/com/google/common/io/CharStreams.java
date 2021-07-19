/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.AppendableWriter;
import com.google.common.io.CharStreams$NullWriter;
import com.google.common.io.LineProcessor;
import com.google.common.io.LineReader;
import java.io.EOFException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

public final class CharStreams {
    private static final int DEFAULT_BUF_SIZE = 2048;

    private CharStreams() {
    }

    public static Writer asWriter(Appendable appendable) {
        boolean bl2 = appendable instanceof Writer;
        if (bl2) {
            return (Writer)appendable;
        }
        AppendableWriter appendableWriter = new AppendableWriter(appendable);
        return appendableWriter;
    }

    public static long copy(Readable readable, Appendable appendable) {
        int n10;
        int n11;
        boolean bl2 = readable instanceof Reader;
        if (bl2) {
            bl2 = appendable instanceof StringBuilder;
            if (bl2) {
                readable = (Reader)readable;
                appendable = (StringBuilder)appendable;
                return CharStreams.copyReaderToBuilder((Reader)readable, (StringBuilder)appendable);
            }
            readable = (Reader)readable;
            appendable = CharStreams.asWriter(appendable);
            return CharStreams.copyReaderToWriter((Reader)readable, (Writer)appendable);
        }
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(appendable);
        long l10 = 0L;
        CharBuffer charBuffer = CharStreams.createBuffer();
        while ((n11 = readable.read(charBuffer)) != (n10 = -1)) {
            charBuffer.flip();
            appendable.append(charBuffer);
            n11 = charBuffer.remaining();
            long l11 = n11;
            l10 += l11;
            charBuffer.clear();
        }
        return l10;
    }

    public static long copyReaderToBuilder(Reader reader, StringBuilder stringBuilder) {
        int n10;
        int n11;
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(stringBuilder);
        int n12 = 2048;
        char[] cArray = new char[n12];
        long l10 = 0L;
        while ((n11 = reader.read(cArray)) != (n10 = -1)) {
            n10 = 0;
            stringBuilder.append(cArray, 0, n11);
            long l11 = n11;
            l10 += l11;
        }
        return l10;
    }

    public static long copyReaderToWriter(Reader reader, Writer writer) {
        int n10;
        int n11;
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(writer);
        int n12 = 2048;
        char[] cArray = new char[n12];
        long l10 = 0L;
        while ((n11 = reader.read(cArray)) != (n10 = -1)) {
            n10 = 0;
            writer.write(cArray, 0, n11);
            long l11 = n11;
            l10 += l11;
        }
        return l10;
    }

    public static CharBuffer createBuffer() {
        return CharBuffer.allocate(2048);
    }

    public static long exhaust(Readable readable) {
        long l10;
        int n10;
        long l11;
        long l12;
        long l13;
        CharBuffer charBuffer = CharStreams.createBuffer();
        long l14 = 0L;
        while ((l13 = (l12 = (l11 = (long)(n10 = readable.read(charBuffer))) - (l10 = (long)-1)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            l14 += l11;
            charBuffer.clear();
        }
        return l14;
    }

    public static Writer nullWriter() {
        return CharStreams$NullWriter.access$000();
    }

    public static Object readLines(Readable object, LineProcessor lineProcessor) {
        boolean bl2;
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(lineProcessor);
        LineReader lineReader = new LineReader((Readable)object);
        while ((object = lineReader.readLine()) != null && (bl2 = lineProcessor.processLine((String)object))) {
        }
        return lineProcessor.getResult();
    }

    public static List readLines(Readable object) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        LineReader lineReader = new LineReader((Readable)object);
        while ((object = lineReader.readLine()) != null) {
            arrayList.add(object);
        }
        return arrayList;
    }

    public static void skipFully(Reader object, long l10) {
        long l11;
        long l12;
        long l13;
        Preconditions.checkNotNull(object);
        while ((l13 = (l12 = l10 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            long l14 = ((Reader)object).skip(l10);
            long l15 = l14 - l11;
            Object object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object2 != false) {
                l10 -= l14;
                continue;
            }
            object = new EOFException();
            throw object;
        }
    }

    public static String toString(Readable readable) {
        return CharStreams.toStringBuilder(readable).toString();
    }

    private static StringBuilder toStringBuilder(Readable readable) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl2 = readable instanceof Reader;
        if (bl2) {
            readable = (Reader)readable;
            CharStreams.copyReaderToBuilder((Reader)readable, stringBuilder);
        } else {
            CharStreams.copy(readable, stringBuilder);
        }
        return stringBuilder;
    }
}

