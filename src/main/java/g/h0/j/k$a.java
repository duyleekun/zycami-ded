/*
 * Decompiled with CFR 0.151.
 */
package g.h0.j;

import f.h2.t.f0;
import f.q2.u;
import g.c0;
import g.h0.j.k;
import java.net.ProtocolException;
import okhttp3.Protocol;

public final class k$a {
    private k$a() {
    }

    public /* synthetic */ k$a(f.h2.t.u u10) {
        this();
    }

    public final k a(c0 object) {
        f0.p(object, "response");
        Protocol protocol = ((c0)object).J0();
        int n10 = ((c0)object).v0();
        object = ((c0)object).E0();
        k k10 = new k(protocol, n10, (String)object);
        return k10;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final k b(String string2) {
        void var2_9;
        String string3;
        int n10;
        int n11;
        int n12;
        String string4;
        int n13;
        int n14;
        CharSequence charSequence;
        int n15;
        block12: {
            int n16;
            block13: {
                f0.p(string2, "statusLine");
                String string5 = "HTTP/1.";
                n15 = 0;
                charSequence = null;
                n14 = 2;
                n13 = 0;
                string4 = null;
                n16 = u.q2(string2, string5, false, n14, null);
                n12 = 32;
                n11 = 4;
                n10 = 9;
                string3 = "Unexpected status line: ";
                if (n16 == 0) break block13;
                n16 = string2.length();
                if (n16 >= n10 && (n16 = (int)string2.charAt(8)) == n12) {
                    n16 = string2.charAt(7) + -48;
                    if (n16 == 0) {
                        Protocol protocol = Protocol.HTTP_1_0;
                        break block12;
                    } else {
                        n15 = 1;
                        if (n16 != n15) {
                            charSequence = new StringBuilder();
                            ((StringBuilder)charSequence).append(string3);
                            ((StringBuilder)charSequence).append(string2);
                            string2 = ((StringBuilder)charSequence).toString();
                            ProtocolException protocolException = new ProtocolException(string2);
                            throw protocolException;
                        }
                        Protocol protocol = Protocol.HTTP_1_1;
                    }
                    break block12;
                } else {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append(string3);
                    ((StringBuilder)charSequence).append(string2);
                    string2 = ((StringBuilder)charSequence).toString();
                    ProtocolException protocolException = new ProtocolException(string2);
                    throw protocolException;
                }
            }
            String string6 = "ICY ";
            n16 = (int)(u.q2(string2, string6, false, n14, null) ? 1 : 0);
            if (n16 == 0) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string3);
                ((StringBuilder)charSequence).append(string2);
                string2 = ((StringBuilder)charSequence).toString();
                ProtocolException protocolException = new ProtocolException(string2);
                throw protocolException;
            }
            Protocol protocol = Protocol.HTTP_1_0;
            n10 = n11;
        }
        n15 = string2.length();
        n14 = n10 + 3;
        if (n15 < n14) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            ProtocolException protocolException = new ProtocolException(string2);
            throw protocolException;
        }
        try {
            charSequence = string2.substring(n10, n14);
            string4 = "(this as java.lang.Strin\u2026ing(startIndex, endIndex)";
            f0.o(charSequence, string4);
            n15 = Integer.parseInt((String)charSequence);
        }
        catch (NumberFormatException numberFormatException) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            ProtocolException protocolException = new ProtocolException(string2);
            throw protocolException;
        }
        n13 = string2.length();
        if (n13 > n14) {
            if ((n14 = (int)string2.charAt(n14)) != n12) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string3);
                ((StringBuilder)charSequence).append(string2);
                string2 = ((StringBuilder)charSequence).toString();
                ProtocolException protocolException = new ProtocolException(string2);
                throw protocolException;
            }
            string2 = string2.substring(n10 += n11);
            String string7 = "(this as java.lang.String).substring(startIndex)";
            f0.o(string2, string7);
            return new k((Protocol)var2_9, n15, string2);
        } else {
            string2 = "";
        }
        return new k((Protocol)var2_9, n15, string2);
    }
}

