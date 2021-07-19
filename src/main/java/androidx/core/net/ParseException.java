/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.net;

public class ParseException
extends RuntimeException {
    public final String response;

    public ParseException(String string2) {
        super(string2);
        this.response = string2;
    }
}

