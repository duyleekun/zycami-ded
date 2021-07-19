/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.TextFormat$1;
import java.io.Serializable;

public final class TextFormat$TextGenerator {
    private boolean atStartOfLine;
    private final StringBuilder indent;
    private final Appendable output;
    private final boolean singleLineMode;

    private TextFormat$TextGenerator(Appendable appendable, boolean bl2) {
        StringBuilder stringBuilder;
        this.indent = stringBuilder = new StringBuilder();
        this.atStartOfLine = false;
        this.output = appendable;
        this.singleLineMode = bl2;
    }

    public /* synthetic */ TextFormat$TextGenerator(Appendable appendable, boolean bl2, TextFormat$1 textFormat$1) {
        this(appendable, bl2);
    }

    public void eol() {
        boolean bl2 = this.singleLineMode;
        if (!bl2) {
            Appendable appendable = this.output;
            String string2 = "\n";
            appendable.append(string2);
        }
        this.atStartOfLine = true;
    }

    public void indent() {
        this.indent.append("  ");
    }

    public void outdent() {
        Serializable serializable = this.indent;
        int n10 = serializable.length();
        if (n10 != 0) {
            StringBuilder stringBuilder = this.indent;
            stringBuilder.setLength(n10 += -2);
            return;
        }
        serializable = new IllegalArgumentException(" Outdent() without matching Indent().");
        throw serializable;
    }

    public void print(CharSequence charSequence) {
        boolean bl2 = this.atStartOfLine;
        if (bl2) {
            bl2 = false;
            this.atStartOfLine = false;
            Appendable appendable = this.output;
            boolean bl3 = this.singleLineMode;
            CharSequence charSequence2 = bl3 ? " " : this.indent;
            appendable.append(charSequence2);
        }
        this.output.append(charSequence);
    }
}

