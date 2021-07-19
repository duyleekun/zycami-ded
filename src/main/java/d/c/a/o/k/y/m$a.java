/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k.y;

import d.c.a.o.k.y.m;
import d.c.a.o.k.y.m$b;
import d.c.a.u.o.a$d;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class m$a
implements a$d {
    public final /* synthetic */ m a;

    public m$a(m m10) {
        this.a = m10;
    }

    public m$b a() {
        Object object = "SHA-256";
        try {
            object = MessageDigest.getInstance((String)object);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object = new RuntimeException(noSuchAlgorithmException);
            throw object;
        }
        m$b m$b = new m$b((MessageDigest)object);
        return m$b;
    }
}

