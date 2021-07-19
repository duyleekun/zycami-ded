/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o;

import java.nio.charset.Charset;
import java.security.MessageDigest;

public interface c {
    public static final String a = "UTF-8";
    public static final Charset b = Charset.forName("UTF-8");

    public void b(MessageDigest var1);

    public boolean equals(Object var1);

    public int hashCode();
}

