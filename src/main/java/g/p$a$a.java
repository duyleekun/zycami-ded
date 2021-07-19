/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import g.p;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;

public final class p$a$a
implements p {
    public List lookup(String string2) {
        Object object;
        Object[] objectArray = "hostname";
        f0.p(string2, (String)objectArray);
        try {
            objectArray = InetAddress.getAllByName(string2);
            object = "InetAddress.getAllByName(hostname)";
        }
        catch (NullPointerException nullPointerException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Broken system behaviour for dns lookup of ");
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            object = new UnknownHostException(string2);
            ((Throwable)object).initCause(nullPointerException);
            throw object;
        }
        f0.o(objectArray, (String)object);
        return ArraysKt___ArraysKt.uy(objectArray);
    }
}

