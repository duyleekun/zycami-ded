/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.CharStreams;
import com.google.common.io.LineBuffer;
import com.google.common.io.LineReader$1;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.LinkedList;
import java.util.Queue;

public final class LineReader {
    private final char[] buf;
    private final CharBuffer cbuf;
    private final LineBuffer lineBuf;
    private final Queue lines;
    private final Readable readable;
    private final Reader reader;

    public LineReader(Readable readable) {
        Object object = CharStreams.createBuffer();
        this.cbuf = object;
        object = ((CharBuffer)object).array();
        this.buf = (char[])object;
        object = new LinkedList();
        this.lines = object;
        this.lineBuf = object = new LineReader$1(this);
        this.readable = object = (Readable)Preconditions.checkNotNull(readable);
        boolean bl2 = readable instanceof Reader;
        readable = bl2 ? (Reader)readable : null;
        this.reader = readable;
    }

    public static /* synthetic */ Queue access$000(LineReader lineReader) {
        return lineReader.lines;
    }

    public String readLine() {
        Object object;
        while ((object = this.lines.peek()) == null) {
            int n10;
            Object object2;
            this.cbuf.clear();
            object = this.reader;
            if (object != null) {
                object2 = this.buf;
                int n11 = ((char[])object2).length;
                n10 = ((Reader)object).read((char[])object2, 0, n11);
            } else {
                object = this.readable;
                object2 = this.cbuf;
                n10 = object.read((CharBuffer)object2);
            }
            int n12 = -1;
            if (n10 == n12) {
                object = this.lineBuf;
                ((LineBuffer)object).finish();
                break;
            }
            object2 = this.lineBuf;
            char[] cArray = this.buf;
            ((LineBuffer)object2).add(cArray, 0, n10);
        }
        return (String)this.lines.poll();
    }
}

