/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import f.h2.t.f0;
import g.h0.l.a;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import okio.ByteString;

public final class b {
    private static final int a = 15;
    private static final int b = 31;
    private static final int c = 63;
    private static final int d = 127;
    private static final int e = 4096;
    private static final int f = 16384;
    private static final a[] g;
    private static final Map h;
    public static final b i;

    static {
        a a10;
        b b10;
        i = b10 = new b();
        a[] aArray = new a[61];
        ByteString byteString = g.h0.l.a.n;
        String string2 = "";
        aArray[0] = a10 = new a(byteString, string2);
        byteString = g.h0.l.a.k;
        aArray[1] = a10 = new a(byteString, "GET");
        aArray[2] = a10 = new a(byteString, "POST");
        byteString = g.h0.l.a.l;
        aArray[3] = a10 = new a(byteString, "/");
        aArray[4] = a10 = new a(byteString, "/index.html");
        byteString = g.h0.l.a.m;
        aArray[5] = a10 = new a(byteString, "http");
        aArray[6] = a10 = new a(byteString, "https");
        byteString = g.h0.l.a.j;
        aArray[7] = a10 = new a(byteString, "200");
        aArray[8] = a10 = new a(byteString, "204");
        aArray[9] = a10 = new a(byteString, "206");
        aArray[10] = a10 = new a(byteString, "304");
        aArray[11] = a10 = new a(byteString, "400");
        aArray[12] = a10 = new a(byteString, "404");
        aArray[13] = a10 = new a(byteString, "500");
        aArray[14] = a10 = new a("accept-charset", string2);
        aArray[15] = a10 = new a("accept-encoding", "gzip, deflate");
        aArray[16] = a10 = new a("accept-language", string2);
        aArray[17] = a10 = new a("accept-ranges", string2);
        aArray[18] = a10 = new a("accept", string2);
        aArray[19] = a10 = new a("access-control-allow-origin", string2);
        aArray[20] = a10 = new a("age", string2);
        aArray[21] = a10 = new a("allow", string2);
        aArray[22] = a10 = new a("authorization", string2);
        aArray[23] = a10 = new a("cache-control", string2);
        aArray[24] = a10 = new a("content-disposition", string2);
        aArray[25] = a10 = new a("content-encoding", string2);
        aArray[26] = a10 = new a("content-language", string2);
        aArray[27] = a10 = new a("content-length", string2);
        aArray[28] = a10 = new a("content-location", string2);
        aArray[29] = a10 = new a("content-range", string2);
        aArray[30] = a10 = new a("content-type", string2);
        aArray[31] = a10 = new a("cookie", string2);
        aArray[32] = a10 = new a("date", string2);
        aArray[33] = a10 = new a("etag", string2);
        aArray[34] = a10 = new a("expect", string2);
        aArray[35] = a10 = new a("expires", string2);
        aArray[36] = a10 = new a("from", string2);
        aArray[37] = a10 = new a("host", string2);
        aArray[38] = a10 = new a("if-match", string2);
        aArray[39] = a10 = new a("if-modified-since", string2);
        aArray[40] = a10 = new a("if-none-match", string2);
        aArray[41] = a10 = new a("if-range", string2);
        aArray[42] = a10 = new a("if-unmodified-since", string2);
        aArray[43] = a10 = new a("last-modified", string2);
        aArray[44] = a10 = new a("link", string2);
        aArray[45] = a10 = new a("location", string2);
        aArray[46] = a10 = new a("max-forwards", string2);
        aArray[47] = a10 = new a("proxy-authenticate", string2);
        aArray[48] = a10 = new a("proxy-authorization", string2);
        aArray[49] = a10 = new a("range", string2);
        aArray[50] = a10 = new a("referer", string2);
        aArray[51] = a10 = new a("refresh", string2);
        aArray[52] = a10 = new a("retry-after", string2);
        aArray[53] = a10 = new a("server", string2);
        aArray[54] = a10 = new a("set-cookie", string2);
        aArray[55] = a10 = new a("strict-transport-security", string2);
        aArray[56] = a10 = new a("transfer-encoding", string2);
        aArray[57] = a10 = new a("user-agent", string2);
        aArray[58] = a10 = new a("vary", string2);
        aArray[59] = a10 = new a("via", string2);
        aArray[60] = a10 = new a("www-authenticate", string2);
        g = aArray;
        h = b10.d();
    }

    private b() {
    }

    private final Map d() {
        a[] aArray = g;
        int n10 = aArray.length;
        Map<a[], ByteString> map = new Map<a[], ByteString>(n10);
        int n11 = aArray.length;
        for (n10 = 0; n10 < n11; ++n10) {
            Object object = g;
            Comparable comparable = object[n10].b;
            boolean bl2 = ((HashMap)map).containsKey(comparable);
            if (bl2) continue;
            object = object[n10].b;
            comparable = Integer.valueOf(n10);
            map.put((a[])object, (ByteString)comparable);
        }
        map = Collections.unmodifiableMap(map);
        f0.o(map, "Collections.unmodifiableMap(result)");
        return map;
    }

    public final ByteString a(ByteString object) {
        Object object2 = "name";
        f0.p(object, (String)object2);
        int n10 = ((ByteString)object).size();
        StringBuilder stringBuilder = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = (byte)65;
            byte by3 = (byte)90;
            byte by4 = ((ByteString)object).getByte(i10);
            if (by2 > by4 || by3 < by4) {
                continue;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("PROTOCOL_ERROR response malformed: mixed case name: ");
            object = ((ByteString)object).utf8();
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            object2 = new IOException((String)object);
            throw object2;
        }
        return object;
    }

    public final Map b() {
        return h;
    }

    public final a[] c() {
        return g;
    }
}

