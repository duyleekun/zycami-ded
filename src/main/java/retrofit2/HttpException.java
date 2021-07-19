/*
 * Decompiled with CFR 0.151.
 */
package retrofit2;

import java.util.Objects;
import k.r;

public class HttpException
extends RuntimeException {
    private final transient r a;
    private final int code;
    private final String message;

    public HttpException(r r10) {
        int n10;
        String string2 = HttpException.a(r10);
        super(string2);
        this.code = n10 = r10.b();
        this.message = string2 = r10.h();
        this.a = r10;
    }

    private static String a(r object) {
        Objects.requireNonNull(object, "response == null");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HTTP ");
        int n10 = ((r)object).b();
        stringBuilder.append(n10);
        stringBuilder.append(" ");
        object = ((r)object).h();
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public r response() {
        return this.a;
    }
}

