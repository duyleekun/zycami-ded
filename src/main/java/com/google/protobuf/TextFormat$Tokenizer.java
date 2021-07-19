/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.TextFormat;
import com.google.protobuf.TextFormat$1;
import com.google.protobuf.TextFormat$InvalidEscapeSequenceException;
import com.google.protobuf.TextFormat$ParseException;
import com.google.protobuf.TextFormat$UnknownFieldParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TextFormat$Tokenizer {
    private static final Pattern DOUBLE_INFINITY;
    private static final Pattern FLOAT_INFINITY;
    private static final Pattern FLOAT_NAN;
    private static final Pattern TOKEN;
    private static final Pattern WHITESPACE;
    private int column = 0;
    private String currentToken;
    private int line = 0;
    private final Matcher matcher;
    private int pos = 0;
    private int previousColumn = 0;
    private int previousLine = 0;
    private final CharSequence text;

    static {
        int n10 = 8;
        WHITESPACE = Pattern.compile("(\\s|(#.*$))++", n10);
        TOKEN = Pattern.compile("[a-zA-Z_][0-9a-zA-Z_+-]*+|[.]?[0-9+-][0-9a-zA-Z_.+-]*+|\"([^\"\n\\\\]|\\\\.)*+(\"|\\\\?$)|'([^'\n\\\\]|\\\\.)*+('|\\\\?$)", n10);
        n10 = 2;
        DOUBLE_INFINITY = Pattern.compile("-?inf(inity)?", n10);
        FLOAT_INFINITY = Pattern.compile("-?inf(inity)?f?", n10);
        FLOAT_NAN = Pattern.compile("nanf?", n10);
    }

    private TextFormat$Tokenizer(CharSequence object) {
        this.text = object;
        this.matcher = object = WHITESPACE.matcher((CharSequence)object);
        this.skipWhitespace();
        this.nextToken();
    }

    public /* synthetic */ TextFormat$Tokenizer(CharSequence charSequence, TextFormat$1 textFormat$1) {
        this(charSequence);
    }

    public static /* synthetic */ String access$800(TextFormat$Tokenizer textFormat$Tokenizer) {
        return textFormat$Tokenizer.currentToken;
    }

    private void consumeByteString(List object) {
        int n10;
        Object object2 = this.currentToken;
        int n11 = ((String)object2).length();
        int n12 = 0;
        if (n11 > 0) {
            object2 = this.currentToken;
            n12 = ((String)object2).charAt(0);
        }
        if (n12 != (n11 = 34) && n12 != (n11 = 39)) {
            throw this.parseException("Expected string.");
        }
        object2 = this.currentToken;
        n11 = ((String)object2).length();
        if (n11 >= (n10 = 2)) {
            object2 = this.currentToken;
            n10 = ((String)object2).length();
            int n13 = 1;
            n11 = ((String)object2).charAt(n10 -= n13);
            if (n11 == n12) {
                try {
                    object2 = this.currentToken;
                }
                catch (TextFormat$InvalidEscapeSequenceException textFormat$InvalidEscapeSequenceException) {
                    object = textFormat$InvalidEscapeSequenceException.getMessage();
                    throw this.parseException((String)object);
                }
                n12 = ((String)object2).length() - n13;
                object2 = ((String)object2).substring(n13, n12);
                object2 = TextFormat.unescapeBytes((CharSequence)object2);
                this.nextToken();
                object.add(object2);
                return;
            }
        }
        throw this.parseException("String missing ending quote.");
    }

    private TextFormat$ParseException floatParseException(NumberFormatException object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Couldn't parse number: ");
        object = ((Throwable)object).getMessage();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        return this.parseException((String)object);
    }

    private TextFormat$ParseException integerParseException(NumberFormatException object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Couldn't parse integer: ");
        object = ((Throwable)object).getMessage();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        return this.parseException((String)object);
    }

    private void skipWhitespace() {
        Matcher matcher = this.matcher;
        Pattern pattern = WHITESPACE;
        matcher.usePattern(pattern);
        matcher = this.matcher;
        boolean bl2 = matcher.lookingAt();
        if (bl2) {
            matcher = this.matcher;
            int n10 = matcher.end();
            Matcher matcher2 = this.matcher;
            int n11 = matcher2.regionEnd();
            matcher.region(n10, n11);
        }
    }

    public boolean atEnd() {
        String string2 = this.currentToken;
        int n10 = string2.length();
        if (!n10) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        return n10 != 0;
    }

    public void consume(String string2) {
        boolean bl2 = this.tryConsume(string2);
        if (bl2) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected \"");
        stringBuilder.append(string2);
        stringBuilder.append("\".");
        string2 = stringBuilder.toString();
        throw this.parseException(string2);
    }

    public boolean consumeBoolean() {
        CharSequence charSequence = this.currentToken;
        String string2 = "true";
        boolean bl2 = ((String)charSequence).equals(string2);
        if (!(bl2 || (bl2 = ((String)(charSequence = this.currentToken)).equals(string2 = "True")) || (bl2 = ((String)(charSequence = this.currentToken)).equals(string2 = "t")) || (bl2 = ((String)(charSequence = this.currentToken)).equals(string2 = "1")))) {
            charSequence = this.currentToken;
            string2 = "false";
            bl2 = ((String)charSequence).equals(string2);
            if (!(bl2 || (bl2 = ((String)(charSequence = this.currentToken)).equals(string2 = "False")) || (bl2 = ((String)(charSequence = this.currentToken)).equals(string2 = "f")) || (bl2 = ((String)(charSequence = this.currentToken)).equals(string2 = "0")))) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("Expected \"true\" or \"false\". Found \"");
                string2 = this.currentToken;
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append("\".");
                charSequence = ((StringBuilder)charSequence).toString();
                throw this.parseException((String)charSequence);
            }
            this.nextToken();
            return false;
        }
        this.nextToken();
        return true;
    }

    public ByteString consumeByteString() {
        ArrayList arrayList = new ArrayList();
        this.consumeByteString(arrayList);
        String string2;
        String string3;
        boolean bl2;
        while ((bl2 = (string3 = this.currentToken).startsWith(string2 = "'")) || (bl2 = (string3 = this.currentToken).startsWith(string2 = "\""))) {
            this.consumeByteString(arrayList);
        }
        return ByteString.copyFrom(arrayList);
    }

    public double consumeDouble() {
        Object object = DOUBLE_INFINITY;
        String string2 = this.currentToken;
        boolean bl2 = ((Matcher)(object = ((Pattern)object).matcher(string2))).matches();
        if (bl2) {
            object = this.currentToken;
            string2 = "-";
            bl2 = ((String)object).startsWith(string2);
            this.nextToken();
            double d10 = bl2 ? -1.0 / 0.0 : 1.0 / 0.0;
            return d10;
        }
        object = this.currentToken;
        string2 = "nan";
        bl2 = ((String)object).equalsIgnoreCase(string2);
        if (bl2) {
            this.nextToken();
            return 0.0 / 0.0;
        }
        try {
            object = this.currentToken;
        }
        catch (NumberFormatException numberFormatException) {
            throw this.floatParseException(numberFormatException);
        }
        double d11 = Double.parseDouble((String)object);
        this.nextToken();
        return d11;
    }

    public float consumeFloat() {
        Object object = FLOAT_INFINITY;
        String string2 = this.currentToken;
        boolean n10 = ((Matcher)(object = ((Pattern)object).matcher(string2))).matches();
        if (n10) {
            float f10;
            object = this.currentToken;
            string2 = "-";
            boolean bl2 = ((String)object).startsWith(string2);
            this.nextToken();
            if (bl2) {
                int n11 = -8388608;
                f10 = -1.0f / 0.0f;
            } else {
                int n12 = 2139095040;
                f10 = 1.0f / 0.0f;
            }
            return f10;
        }
        object = FLOAT_NAN;
        string2 = this.currentToken;
        boolean bl3 = ((Matcher)(object = ((Pattern)object).matcher(string2))).matches();
        if (bl3) {
            this.nextToken();
            return 0.0f / 0.0f;
        }
        try {
            object = this.currentToken;
        }
        catch (NumberFormatException numberFormatException) {
            throw this.floatParseException(numberFormatException);
        }
        float f11 = Float.parseFloat((String)object);
        this.nextToken();
        return f11;
    }

    public String consumeIdentifier() {
        String string2;
        int n10;
        CharSequence charSequence = null;
        for (int i10 = 0; i10 < (n10 = (string2 = this.currentToken).length()); ++i10) {
            int n11 = 97;
            string2 = this.currentToken;
            n10 = string2.charAt(i10);
            if (n11 <= n10 && n10 <= (n11 = 122) || (n11 = 65) <= n10 && n10 <= (n11 = 90) || (n11 = 48) <= n10 && n10 <= (n11 = 57) || n10 == (n11 = 95) || n10 == (n11 = 46)) continue;
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Expected identifier. Found '");
            string2 = this.currentToken;
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append("'");
            charSequence = ((StringBuilder)charSequence).toString();
            throw this.parseException((String)charSequence);
        }
        charSequence = this.currentToken;
        this.nextToken();
        return charSequence;
    }

    public int consumeInt32() {
        String string2;
        try {
            string2 = this.currentToken;
        }
        catch (NumberFormatException numberFormatException) {
            throw this.integerParseException(numberFormatException);
        }
        int n10 = TextFormat.parseInt32(string2);
        this.nextToken();
        return n10;
    }

    public long consumeInt64() {
        String string2;
        try {
            string2 = this.currentToken;
        }
        catch (NumberFormatException numberFormatException) {
            throw this.integerParseException(numberFormatException);
        }
        long l10 = TextFormat.parseInt64(string2);
        this.nextToken();
        return l10;
    }

    public String consumeString() {
        return this.consumeByteString().toStringUtf8();
    }

    public int consumeUInt32() {
        String string2;
        try {
            string2 = this.currentToken;
        }
        catch (NumberFormatException numberFormatException) {
            throw this.integerParseException(numberFormatException);
        }
        int n10 = TextFormat.parseUInt32(string2);
        this.nextToken();
        return n10;
    }

    public long consumeUInt64() {
        String string2;
        try {
            string2 = this.currentToken;
        }
        catch (NumberFormatException numberFormatException) {
            throw this.integerParseException(numberFormatException);
        }
        long l10 = TextFormat.parseUInt64(string2);
        this.nextToken();
        return l10;
    }

    public int getColumn() {
        return this.column;
    }

    public int getLine() {
        return this.line;
    }

    public int getPreviousColumn() {
        return this.previousColumn;
    }

    public int getPreviousLine() {
        return this.previousLine;
    }

    public boolean lookingAt(String string2) {
        return this.currentToken.equals(string2);
    }

    public boolean lookingAtInteger() {
        String string2 = this.currentToken;
        int n10 = string2.length();
        boolean bl2 = false;
        if (n10 == 0) {
            return false;
        }
        int n11 = 48;
        string2 = this.currentToken;
        n10 = string2.charAt(0);
        if (n11 <= n10 && n10 <= (n11 = 57) || n10 == (n11 = 45) || n10 == (n11 = 43)) {
            bl2 = true;
        }
        return bl2;
    }

    public void nextToken() {
        Object object;
        Object object2;
        int n10;
        int n11;
        int n12;
        int c10;
        this.previousLine = c10 = this.line;
        this.previousColumn = n12 = this.column;
        while ((n11 = this.pos) < (n10 = ((Matcher)(object2 = this.matcher)).regionStart())) {
            object = this.text;
            n10 = this.pos;
            n11 = object.charAt(n10);
            if (n11 == (n10 = 10)) {
                this.line = n11 = this.line + 1;
                n11 = 0;
                object = null;
                this.column = 0;
            } else {
                this.column = n11 = this.column + 1;
            }
            this.pos = n11 = this.pos + 1;
        }
        object = this.matcher;
        int n13 = ((Matcher)object).regionStart();
        if (n13 == (n10 = ((Matcher)(object2 = this.matcher)).regionEnd())) {
            this.currentToken = object = "";
        } else {
            object = this.matcher;
            object2 = TOKEN;
            ((Matcher)object).usePattern((Pattern)object2);
            object = this.matcher;
            boolean bl2 = ((Matcher)object).lookingAt();
            if (bl2) {
                this.currentToken = object = this.matcher.group();
                object = this.matcher;
                n10 = ((Matcher)object).end();
                Matcher matcher = this.matcher;
                int n14 = matcher.regionEnd();
                ((Matcher)object).region(n10, n14);
            } else {
                object = this.text;
                n10 = this.pos;
                char c11 = object.charAt(n10);
                this.currentToken = object = String.valueOf(c11);
                object = this.matcher;
                n10 = this.pos + 1;
                int n15 = ((Matcher)object).regionEnd();
                ((Matcher)object).region(n10, n15);
            }
            this.skipWhitespace();
        }
    }

    public TextFormat$ParseException parseException(String string2) {
        int n10 = this.line + 1;
        int n11 = this.column + 1;
        TextFormat$ParseException textFormat$ParseException = new TextFormat$ParseException(n10, n11, string2);
        return textFormat$ParseException;
    }

    public TextFormat$ParseException parseExceptionPreviousToken(String string2) {
        int n10 = this.previousLine + 1;
        int n11 = this.previousColumn + 1;
        TextFormat$ParseException textFormat$ParseException = new TextFormat$ParseException(n10, n11, string2);
        return textFormat$ParseException;
    }

    public boolean tryConsume(String string2) {
        String string3 = this.currentToken;
        boolean bl2 = string3.equals(string2);
        if (bl2) {
            this.nextToken();
            return true;
        }
        return false;
    }

    public boolean tryConsumeDouble() {
        try {
            this.consumeDouble();
            return true;
        }
        catch (TextFormat$ParseException textFormat$ParseException) {
            return false;
        }
    }

    public boolean tryConsumeFloat() {
        try {
            this.consumeFloat();
            return true;
        }
        catch (TextFormat$ParseException textFormat$ParseException) {
            return false;
        }
    }

    public boolean tryConsumeIdentifier() {
        try {
            this.consumeIdentifier();
            return true;
        }
        catch (TextFormat$ParseException textFormat$ParseException) {
            return false;
        }
    }

    public boolean tryConsumeInt64() {
        try {
            this.consumeInt64();
            return true;
        }
        catch (TextFormat$ParseException textFormat$ParseException) {
            return false;
        }
    }

    public boolean tryConsumeString() {
        try {
            this.consumeString();
            return true;
        }
        catch (TextFormat$ParseException textFormat$ParseException) {
            return false;
        }
    }

    public boolean tryConsumeUInt64() {
        try {
            this.consumeUInt64();
            return true;
        }
        catch (TextFormat$ParseException textFormat$ParseException) {
            return false;
        }
    }

    public TextFormat$UnknownFieldParseException unknownFieldParseExceptionPreviousToken(String string2, String string3) {
        int n10 = this.previousLine + 1;
        int n11 = this.previousColumn + 1;
        TextFormat$UnknownFieldParseException textFormat$UnknownFieldParseException = new TextFormat$UnknownFieldParseException(n10, n11, string2, string3);
        return textFormat$UnknownFieldParseException;
    }
}

