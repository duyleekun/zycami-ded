/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.j;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import d.c.a.o.j.j$b;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class j$a
implements j$b {
    public HttpURLConnection a(URL uRL) {
        return (HttpURLConnection)((URLConnection)FirebasePerfUrlConnection.instrument(uRL.openConnection()));
    }
}

