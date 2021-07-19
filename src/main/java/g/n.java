/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import okio.ByteString;

public final class n {
    public static final n a;

    static {
        n n10;
        a = n10 = new n();
    }

    private n() {
    }

    public static final String a(String string2, String string3) {
        return n.c(string2, string3, null, 4, null);
    }

    public static final String b(String string2, String charSequence, Charset charset) {
        f0.p(string2, "username");
        f0.p(charSequence, "password");
        f0.p(charset, "charset");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(':');
        stringBuilder.append((String)charSequence);
        string2 = stringBuilder.toString();
        string2 = ByteString.Companion.j(string2, charset).base64();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Basic ");
        ((StringBuilder)charSequence).append(string2);
        return ((StringBuilder)charSequence).toString();
    }

    public static /* synthetic */ String c(String string2, String string3, Charset charset, int n10, Object object) {
        if ((n10 &= 4) != 0) {
            charset = StandardCharsets.ISO_8859_1;
            String string4 = "ISO_8859_1";
            f0.o(charset, string4);
        }
        return n.b(string2, string3, charset);
    }
}

