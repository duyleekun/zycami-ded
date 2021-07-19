/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 */
package d.c.a.o.j;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import d.c.a.o.j.d;
import d.c.a.o.j.d$a;
import d.c.a.o.j.j$a;
import d.c.a.o.j.j$b;
import d.c.a.o.l.g;
import d.c.a.u.c;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class j
implements d {
    private static final String g = "HttpUrlFetcher";
    private static final int h = 5;
    public static final j$b i;
    private static final int j = 255;
    private final g a;
    private final int b;
    private final j$b c;
    private HttpURLConnection d;
    private InputStream e;
    private volatile boolean f;

    static {
        j$a j$a = new j$a();
        i = j$a;
    }

    public j(g g10, int n10) {
        j$b j$b = i;
        this(g10, n10, j$b);
    }

    public j(g g10, int n10, j$b j$b) {
        this.a = g10;
        this.b = n10;
        this.c = j$b;
    }

    private InputStream c(HttpURLConnection object) {
        CharSequence charSequence = ((URLConnection)object).getContentEncoding();
        int n10 = TextUtils.isEmpty((CharSequence)charSequence);
        if (n10 != 0) {
            n10 = ((URLConnection)object).getContentLength();
            object = ((URLConnection)object).getInputStream();
            long l10 = n10;
            this.e = object = d.c.a.u.c.h((InputStream)object, l10);
        } else {
            String string2 = g;
            n10 = (int)(Log.isLoggable((String)string2, (int)3) ? 1 : 0);
            if (n10 != 0) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("Got non empty content encoding: ");
                String string3 = ((URLConnection)object).getContentEncoding();
                ((StringBuilder)charSequence).append(string3);
                charSequence = ((StringBuilder)charSequence).toString();
                Log.d((String)string2, (String)charSequence);
            }
            this.e = object = ((URLConnection)object).getInputStream();
        }
        return this.e;
    }

    private static boolean e(int n10) {
        int n11 = 2;
        n10 = (n10 /= 100) == n11 ? 1 : 0;
        return n10 != 0;
    }

    private static boolean f(int n10) {
        int n11 = 3;
        n10 = (n10 /= 100) == n11 ? 1 : 0;
        return n10 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private InputStream g(URL object, int n10, URL object2, Map map) {
        int n11;
        Object object3;
        int n12 = 5;
        if (n10 >= n12) {
            object = new HttpException("Too many (> 5) redirects!");
            throw object;
        }
        if (object2 != null) {
            try {
                object3 = ((URL)object).toURI();
                object2 = ((URL)object2).toURI();
                n11 = ((URI)object3).equals(object2);
                if (n11 != 0) {
                    object3 = "In re-direct loop";
                    object2 = new HttpException((String)object3);
                    throw object2;
                }
            }
            catch (URISyntaxException uRISyntaxException) {}
        }
        this.d = object2 = this.c.a((URL)object);
        object2 = map.entrySet().iterator();
        while ((n12 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
            object3 = (Map.Entry)object2.next();
            HttpURLConnection httpURLConnection = this.d;
            String string2 = (String)object3.getKey();
            object3 = (String)object3.getValue();
            httpURLConnection.addRequestProperty(string2, (String)object3);
        }
        object2 = this.d;
        n12 = this.b;
        ((URLConnection)object2).setConnectTimeout(n12);
        object2 = this.d;
        n12 = this.b;
        ((URLConnection)object2).setReadTimeout(n12);
        object2 = this.d;
        n12 = 0;
        object3 = null;
        ((URLConnection)object2).setUseCaches(false);
        object2 = this.d;
        int n13 = 1;
        ((URLConnection)object2).setDoInput(n13 != 0);
        this.d.setInstanceFollowRedirects(false);
        this.d.connect();
        this.e = object2 = this.d.getInputStream();
        n11 = this.f;
        if (n11 != 0) {
            return null;
        }
        object2 = this.d;
        n11 = ((HttpURLConnection)object2).getResponseCode();
        n12 = (int)(d.c.a.o.j.j.e(n11) ? 1 : 0);
        if (n12 != 0) {
            object = this.d;
            return this.c((HttpURLConnection)object);
        }
        n12 = (int)(d.c.a.o.j.j.f(n11) ? 1 : 0);
        if (n12 != 0) {
            object2 = this.d;
            object3 = "Location";
            n12 = (int)(TextUtils.isEmpty((CharSequence)(object2 = ((URLConnection)object2).getHeaderField((String)object3))) ? 1 : 0);
            if (n12 == 0) {
                object3 = new URL((URL)object, (String)object2);
                this.b();
                return this.g((URL)object3, n10 += n13, (URL)object, map);
            }
            object = new HttpException("Received empty or null redirect url");
            throw object;
        }
        int n14 = -1;
        if (n11 == n14) {
            object = new HttpException(n11);
            throw object;
        }
        String string3 = this.d.getResponseMessage();
        object = new HttpException(string3, n11);
        throw object;
    }

    public Class a() {
        return InputStream.class;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        Object object = this.e;
        if (object != null) {
            try {
                ((InputStream)object).close();
            }
            catch (IOException iOException) {}
        }
        if ((object = this.d) != null) {
            ((HttpURLConnection)object).disconnect();
        }
        this.d = null;
    }

    public void cancel() {
        this.f = true;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d(Priority object, d$a object2) {
        Throwable throwable2222222;
        int n10;
        long l10;
        String string2;
        block9: {
            block10: {
                block11: {
                    object = "Finished http url fetcher fetch in ";
                    string2 = g;
                    l10 = d.c.a.u.g.b();
                    n10 = 2;
                    Object object3 = this.a;
                    object3 = ((g)object3).i();
                    boolean bl2 = false;
                    Object var9_11 = null;
                    Object object4 = this.a;
                    object4 = ((g)object4).e();
                    object3 = this.g((URL)object3, 0, null, (Map)object4);
                    object2.e(object3);
                    {
                        catch (Throwable throwable2222222) {
                            break block9;
                        }
                        catch (IOException iOException) {}
                        int n11 = 3;
                        {
                            n11 = (int)(Log.isLoggable((String)string2, (int)n11) ? 1 : 0);
                            if (n11 != 0) {
                                String string3 = "Failed to load data for url";
                                Log.d((String)string2, (String)string3, (Throwable)iOException);
                            }
                            object2.c(iOException);
                        }
                        boolean bl3 = Log.isLoggable((String)string2, (int)n10);
                        if (!bl3) break block10;
                        object2 = new StringBuilder();
                        break block11;
                    }
                    boolean bl4 = Log.isLoggable((String)string2, (int)n10);
                    if (!bl4) break block10;
                    object2 = new StringBuilder();
                }
                ((StringBuilder)object2).append((String)object);
                double d10 = d.c.a.u.g.a(l10);
                ((StringBuilder)object2).append(d10);
                object = ((StringBuilder)object2).toString();
                Log.v((String)string2, (String)object);
            }
            return;
        }
        n10 = (int)(Log.isLoggable((String)string2, (int)n10) ? 1 : 0);
        if (n10 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            double d11 = d.c.a.u.g.a(l10);
            stringBuilder.append(d11);
            object = stringBuilder.toString();
            Log.v((String)string2, (String)object);
        }
        throw throwable2222222;
    }

    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }
}

