/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.h2.t.u;

public final class w$b {
    private w$b() {
    }

    public /* synthetic */ w$b(u u10) {
        this();
    }

    public final void a(StringBuilder stringBuilder, String string2) {
        f0.p(stringBuilder, "$this$appendQuotedString");
        String string3 = "key";
        f0.p(string2, string3);
        char c10 = '\"';
        stringBuilder.append(c10);
        int n10 = string2.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            String string4;
            int n11;
            int n12 = string2.charAt(i10);
            if (n12 != (n11 = 10)) {
                n11 = 13;
                if (n12 != n11) {
                    if (n12 != c10) {
                        stringBuilder.append((char)n12);
                        continue;
                    }
                    string4 = "%22";
                    stringBuilder.append(string4);
                    continue;
                }
                string4 = "%0D";
                stringBuilder.append(string4);
                continue;
            }
            string4 = "%0A";
            stringBuilder.append(string4);
        }
        stringBuilder.append(c10);
    }
}

