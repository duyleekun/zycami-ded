/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.BaseDataSource;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource$1;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource$CleartextNotPermittedException;
import com.google.android.exoplayer2.upstream.HttpDataSource$HttpDataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidContentTypeException;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.HttpDataSource$RequestProperties;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Predicate;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

public class DefaultHttpDataSource
extends BaseDataSource
implements HttpDataSource {
    private static final Pattern CONTENT_RANGE_HEADER = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 8000;
    public static final int DEFAULT_READ_TIMEOUT_MILLIS = 8000;
    private static final int HTTP_STATUS_PERMANENT_REDIRECT = 308;
    private static final int HTTP_STATUS_TEMPORARY_REDIRECT = 307;
    private static final long MAX_BYTES_TO_DRAIN = 2048L;
    private static final int MAX_REDIRECTS = 20;
    private static final String TAG = "DefaultHttpDataSource";
    private final boolean allowCrossProtocolRedirects;
    private long bytesRead;
    private long bytesSkipped;
    private long bytesToRead;
    private long bytesToSkip;
    private final int connectTimeoutMillis;
    private HttpURLConnection connection;
    private Predicate contentTypePredicate;
    private DataSpec dataSpec;
    private final HttpDataSource$RequestProperties defaultRequestProperties;
    private InputStream inputStream;
    private boolean opened;
    private final int readTimeoutMillis;
    private final HttpDataSource$RequestProperties requestProperties;
    private int responseCode;
    private byte[] skipBuffer;
    private final String userAgent;

    public DefaultHttpDataSource() {
        int n10 = 8000;
        this(null, n10, n10);
    }

    public DefaultHttpDataSource(String string2) {
        int n10 = 8000;
        this(string2, n10, n10);
    }

    public DefaultHttpDataSource(String string2, int n10, int n11) {
        this(string2, n10, n11, false, null);
    }

    public DefaultHttpDataSource(String string2, int n10, int n11, boolean bl2, HttpDataSource$RequestProperties httpDataSource$RequestProperties) {
        this(string2, n10, n11, bl2, httpDataSource$RequestProperties, null);
    }

    private DefaultHttpDataSource(String object, int n10, int n11, boolean bl2, HttpDataSource$RequestProperties httpDataSource$RequestProperties, Predicate predicate) {
        super(true);
        this.userAgent = object;
        this.connectTimeoutMillis = n10;
        this.readTimeoutMillis = n11;
        this.allowCrossProtocolRedirects = bl2;
        this.defaultRequestProperties = httpDataSource$RequestProperties;
        this.contentTypePredicate = predicate;
        this.requestProperties = object = new HttpDataSource$RequestProperties();
    }

    public /* synthetic */ DefaultHttpDataSource(String string2, int n10, int n11, boolean bl2, HttpDataSource$RequestProperties httpDataSource$RequestProperties, Predicate predicate, DefaultHttpDataSource$1 defaultHttpDataSource$1) {
        this(string2, n10, n11, bl2, httpDataSource$RequestProperties, predicate);
    }

    private void closeConnectionQuietly() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            }
            catch (Exception exception) {
                String string2 = TAG;
                String string3 = "Unexpected error while disconnecting";
                Log.e(string2, string3, exception);
            }
            httpURLConnection = null;
            this.connection = null;
        }
    }

    private static long getContentLength(HttpURLConnection object) {
        long l10;
        block26: {
            int n10;
            long l11;
            Object object2;
            String string2;
            String string3;
            int n11;
            String string4;
            block27: {
                int n12;
                block25: {
                    string4 = ((URLConnection)object).getHeaderField("Content-Length");
                    n11 = TextUtils.isEmpty((CharSequence)string4);
                    string3 = "]";
                    string2 = TAG;
                    if (n11 == 0) {
                        try {
                            l10 = Long.parseLong(string4);
                            break block25;
                        }
                        catch (NumberFormatException numberFormatException) {
                            n11 = String.valueOf(string4).length() + 28;
                            StringBuilder stringBuilder = new StringBuilder(n11);
                            stringBuilder.append("Unexpected Content-Length [");
                            stringBuilder.append(string4);
                            stringBuilder.append(string3);
                            object2 = stringBuilder.toString();
                            Log.e(string2, (String)object2);
                        }
                    }
                    l10 = -1;
                }
                object2 = "Content-Range";
                object = ((URLConnection)object).getHeaderField((String)object2);
                n11 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                if (n11 != 0 || (n12 = ((Matcher)(object2 = CONTENT_RANGE_HEADER.matcher((CharSequence)object))).find()) == 0) break block26;
                n12 = 2;
                Object object3 = ((Matcher)object2).group(n12);
                object3 = Assertions.checkNotNull(object3);
                object3 = (String)object3;
                l11 = Long.parseLong((String)object3);
                n10 = 1;
                object2 = ((Matcher)object2).group(n10);
                object2 = Assertions.checkNotNull(object2);
                object2 = (String)object2;
                long l12 = Long.parseLong((String)object2);
                l11 = l11 - l12 + 1L;
                l12 = 0L;
                n11 = (int)(l10 == l12 ? 0 : (l10 < l12 ? -1 : 1));
                if (n11 >= 0) break block27;
                l10 = l11;
                break block26;
            }
            n11 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
            if (n11 == 0) break block26;
            object2 = String.valueOf(string4);
            n11 = ((String)object2).length() + 26;
            CharSequence charSequence = String.valueOf(object);
            n10 = ((String)charSequence).length();
            n11 += n10;
            charSequence = new StringBuilder(n11);
            object2 = "Inconsistent headers [";
            ((StringBuilder)charSequence).append((String)object2);
            ((StringBuilder)charSequence).append(string4);
            string4 = "] [";
            ((StringBuilder)charSequence).append(string4);
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(string3);
            string4 = ((StringBuilder)charSequence).toString();
            Log.w(string2, string4);
            try {
                long l13;
                l10 = l13 = Math.max(l10, l11);
            }
            catch (NumberFormatException numberFormatException) {
                int n13 = String.valueOf(object).length() + 27;
                object2 = new StringBuilder(n13);
                string4 = "Unexpected Content-Range [";
                ((StringBuilder)object2).append(string4);
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append(string3);
                object = ((StringBuilder)object2).toString();
                Log.e(string2, (String)object);
            }
        }
        return l10;
    }

    private static URL handleRedirect(URL object, String object2) {
        if (object2 != null) {
            object2 = "https";
            Object object3 = new URL((URL)object, (String)object2);
            boolean bl2 = ((String)object2).equals(object = ((URL)object3).getProtocol());
            if (!bl2 && !(bl2 = ((String)(object2 = "http")).equals(object))) {
                object3 = "Unsupported protocol redirect: ";
                int n10 = ((String)(object = String.valueOf(object))).length();
                object = n10 != 0 ? ((String)object3).concat((String)object) : new String((String)object3);
                object2 = new ProtocolException((String)object);
                throw object2;
            }
            return object3;
        }
        object = new ProtocolException("Null location redirect");
        throw object;
    }

    private static boolean isCompressed(HttpURLConnection object) {
        object = ((URLConnection)object).getHeaderField("Content-Encoding");
        return "gzip".equalsIgnoreCase((String)object);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private HttpURLConnection makeConnection(DataSpec dataSpec) {
        int n10;
        int n11;
        Object object = dataSpec;
        String string2 = dataSpec.uri.toString();
        URL uRL = new URL(string2);
        int n12 = dataSpec.httpMethod;
        Object object2 = dataSpec.httpBody;
        long l10 = dataSpec.position;
        long l11 = dataSpec.length;
        int n13 = 1;
        float f10 = Float.MIN_VALUE;
        boolean bl2 = dataSpec.isFlagSet(n13);
        int n14 = (int)(this.allowCrossProtocolRedirects ? 1 : 0);
        if (n14 == 0) {
            Map map = dataSpec.httpRequestHeaders;
            object = this;
            boolean bl3 = bl2;
            return this.makeConnection(uRL, n12, (byte[])object2, l10, l11, bl2, true, map);
        }
        n14 = 0;
        Object object3 = null;
        while (true) {
            int n15;
            void var3_4;
            n11 = n14 + 1;
            int n16 = 20;
            if (n14 > n16) break;
            Map map = ((DataSpec)object).httpRequestHeaders;
            object3 = this;
            n10 = n11;
            Object object4 = object2;
            int n17 = n13;
            float f11 = f10;
            long l12 = l11;
            long l13 = l10;
            object3 = this.makeConnection((URL)var3_4, n12, (byte[])object2, l10, l11, bl2, false, map);
            n16 = ((HttpURLConnection)object3).getResponseCode();
            String string3 = ((URLConnection)object3).getHeaderField("Location");
            int n18 = 303;
            n11 = 302;
            int n19 = 301;
            n13 = 300;
            f10 = 4.2E-43f;
            if (n12 != n17 && n12 != (n15 = 3) || n16 != n13 && n16 != n19 && n16 != n11 && n16 != n18 && n16 != (n15 = 307) && n16 != (n15 = 308)) {
                n15 = 2;
                if (n12 != n15 || n16 != n13 && n16 != n19 && n16 != n11 && n16 != n18) return object3;
                ((HttpURLConnection)object3).disconnect();
                string2 = null;
                URL uRL2 = DefaultHttpDataSource.handleRedirect((URL)var3_4, string3);
                object4 = null;
                n12 = n17;
            } else {
                ((HttpURLConnection)object3).disconnect();
                URL uRL3 = DefaultHttpDataSource.handleRedirect((URL)var3_4, string3);
            }
            n14 = n10;
            n13 = n17;
            f10 = f11;
            object2 = object4;
            l11 = l12;
            l10 = l13;
            object = dataSpec;
        }
        n10 = n11;
        object2 = new StringBuilder;
        ((StringBuilder)object2)(31);
        ((StringBuilder)object2).append("Too many redirects: ");
        ((StringBuilder)object2).append(n11);
        object = ((StringBuilder)object2).toString();
        NoRouteToHostException noRouteToHostException = new NoRouteToHostException((String)object);
        throw noRouteToHostException;
    }

    private HttpURLConnection makeConnection(URL object, int n10, byte[] byArray, long l10, long l11, boolean bl2, boolean bl3, Map object2) {
        boolean bl4;
        String string2;
        String string3;
        object = this.openConnection((URL)object);
        int n11 = this.connectTimeoutMillis;
        ((URLConnection)object).setConnectTimeout(n11);
        n11 = this.readTimeoutMillis;
        ((URLConnection)object).setReadTimeout(n11);
        Object object3 = new HashMap();
        Object object4 = this.defaultRequestProperties;
        if (object4 != null) {
            object4 = ((HttpDataSource$RequestProperties)object4).getSnapshot();
            object3.putAll(object4);
        }
        object4 = this.requestProperties.getSnapshot();
        object3.putAll(object4);
        object3.putAll(object2);
        object2 = object3.entrySet().iterator();
        while ((n11 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
            object3 = (Map.Entry)object2.next();
            object4 = (String)object3.getKey();
            object3 = (String)object3.getValue();
            ((URLConnection)object).setRequestProperty((String)object4, (String)object3);
        }
        long l12 = l10 - 0L;
        long l13 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        long l14 = -1;
        if (l13 != false || (l13 = l11 == l14 ? 0 : (l11 < l14 ? -1 : 1)) != false) {
            l13 = 27;
            StringBuilder stringBuilder = new StringBuilder((int)l13);
            stringBuilder.append("bytes=");
            stringBuilder.append(l10);
            stringBuilder.append("-");
            object2 = stringBuilder.toString();
            n11 = (int)(l11 == l14 ? 0 : (l11 < l14 ? -1 : 1));
            if (n11 != 0) {
                object2 = String.valueOf(object2);
                l10 += l11;
                l11 = 1L;
                String string4 = String.valueOf(object2);
                int n12 = string4.length() + 20;
                StringBuilder stringBuilder2 = new StringBuilder(n12);
                stringBuilder2.append((String)object2);
                stringBuilder2.append(l10 -= l11);
                object2 = stringBuilder2.toString();
            }
            string3 = "Range";
            ((URLConnection)object).setRequestProperty(string3, (String)object2);
        }
        if ((string3 = this.userAgent) != null) {
            string2 = "User-Agent";
            ((URLConnection)object).setRequestProperty(string2, string3);
        }
        string3 = bl2 ? "gzip" : "identity";
        string2 = "Accept-Encoding";
        ((URLConnection)object).setRequestProperty(string2, string3);
        ((HttpURLConnection)object).setInstanceFollowRedirects(bl3);
        if (byArray != null) {
            bl4 = true;
        } else {
            bl4 = false;
            string3 = null;
        }
        ((URLConnection)object).setDoOutput(bl4);
        Object object5 = DataSpec.getStringForHttpMethod(n10);
        ((HttpURLConnection)object).setRequestMethod((String)object5);
        if (byArray != null) {
            n10 = byArray.length;
            ((HttpURLConnection)object).setFixedLengthStreamingMode(n10);
            ((URLConnection)object).connect();
            object5 = ((URLConnection)object).getOutputStream();
            ((OutputStream)object5).write(byArray);
            ((OutputStream)object5).close();
        } else {
            ((URLConnection)object).connect();
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void maybeTerminateInputStream(HttpURLConnection object, long l10) {
        if (object == null) return;
        int n10 = Util.SDK_INT;
        int n11 = 19;
        if (n10 < n11) return;
        n11 = 20;
        if (n10 > n11) {
            return;
        }
        try {
            long l11;
            long l12;
            int n12;
            int n13;
            object = ((URLConnection)object).getInputStream();
            long l13 = -1;
            n10 = (int)(l10 == l13 ? 0 : (l10 < l13 ? -1 : 1));
            if (n10 == 0 ? (n13 = ((InputStream)object).read()) == (n12 = -1) : (l12 = (l11 = l10 - (l13 = 2048L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) <= 0) {
                return;
            }
            Object object2 = object.getClass();
            Object object3 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream";
            boolean bl2 = object3.equals(object2 = ((Class)object2).getName());
            if (!bl2) {
                object3 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream";
                boolean bl3 = object3.equals(object2);
                if (!bl3) return;
            }
            object2 = object.getClass();
            object2 = ((Class)object2).getSuperclass();
            object2 = Assertions.checkNotNull(object2);
            object2 = (Class)object2;
            object3 = "unexpectedEndOfInput";
            n10 = 0;
            Class[] classArray = new Class[]{};
            object2 = ((Class)object2).getDeclaredMethod((String)object3, classArray);
            boolean bl4 = true;
            ((Method)object2).setAccessible(bl4);
            object3 = new Object[]{};
            ((Method)object2).invoke(object, object3);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    private int readInternal(byte[] object, int n10, int n11) {
        InputStream inputStream;
        int n12;
        if (n11 == 0) {
            return 0;
        }
        long l10 = this.bytesToRead;
        long l11 = -1;
        Object object2 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n13 = -1;
        if (object2 != false) {
            long l12 = this.bytesRead;
            long l13 = (l10 -= l12) - (l12 = 0L);
            object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 == false) {
                return n13;
            }
            l12 = n11;
            l10 = Math.min(l12, l10);
            n11 = (int)l10;
        }
        if ((n12 = (inputStream = (InputStream)Util.castNonNull(this.inputStream)).read((byte[])object, n10, n11)) == n13) {
            long l14 = this.bytesToRead;
            long l15 = l14 - l11;
            n12 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
            if (n12 == 0) {
                return n13;
            }
            object = new EOFException;
            object();
            throw object;
        }
        long l16 = this.bytesRead;
        l10 = n12;
        this.bytesRead = l16 += l10;
        this.bytesTransferred(n12);
        return n12;
    }

    private void skipInternal() {
        long l10;
        long l11;
        long l12 = this.bytesSkipped;
        long l13 = this.bytesToSkip;
        long l14 = l12 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object == false) {
            return;
        }
        Object object2 = this.skipBuffer;
        if (object2 == null) {
            object = 4096;
            this.skipBuffer = object2 = new byte[object];
        }
        while ((l11 = (l10 = (l12 = this.bytesSkipped) - (l13 = this.bytesToSkip)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            l13 -= l12;
            object2 = this.skipBuffer;
            l12 = ((byte[])object2).length;
            l12 = Math.min(l13, l12);
            object = (int)l12;
            Object object3 = (InputStream)Util.castNonNull(this.inputStream);
            byte[] byArray = this.skipBuffer;
            object = ((InputStream)object3).read(byArray, 0, (int)object);
            object3 = Thread.currentThread();
            int n10 = ((Thread)object3).isInterrupted();
            if (n10 == 0) {
                n10 = -1;
                if (object != n10) {
                    long l15 = this.bytesSkipped;
                    long l16 = object;
                    this.bytesSkipped = l15 += l16;
                    this.bytesTransferred((int)object);
                    continue;
                }
                object2 = new EOFException;
                object2();
                throw object2;
            }
            object2 = new InterruptedIOException;
            object2();
            throw object2;
        }
    }

    public final long bytesRead() {
        return this.bytesRead;
    }

    public final long bytesRemaining() {
        long l10 = this.bytesToRead;
        long l11 = -1;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            l11 = this.bytesRead;
            l10 -= l11;
        }
        return l10;
    }

    public final long bytesSkipped() {
        return this.bytesSkipped;
    }

    public void clearAllRequestProperties() {
        this.requestProperties.clear();
    }

    public void clearRequestProperty(String string2) {
        Assertions.checkNotNull(string2);
        this.requestProperties.remove(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        boolean bl2 = false;
        try {
            InputStream inputStream = this.inputStream;
            if (inputStream == null) return;
            Object object = this.connection;
            long l10 = this.bytesRemaining();
            DefaultHttpDataSource.maybeTerminateInputStream((HttpURLConnection)object, l10);
            try {
                inputStream.close();
                return;
            }
            catch (IOException iOException) {
                Object object2 = this.dataSpec;
                object2 = Util.castNonNull(object2);
                object2 = (DataSpec)object2;
                int n10 = 3;
                object = new HttpDataSource$HttpDataSourceException(iOException, (DataSpec)object2, n10);
                throw object;
            }
        }
        finally {
            this.inputStream = null;
            this.closeConnectionQuietly();
            bl2 = this.opened;
            if (bl2) {
                this.opened = false;
                this.transferEnded();
            }
        }
    }

    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    public int getResponseCode() {
        int n10;
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection == null || (n10 = this.responseCode) <= 0) {
            n10 = -1;
        }
        return n10;
    }

    public Map getResponseHeaders() {
        Object object = this.connection;
        object = object == null ? Collections.emptyMap() : ((URLConnection)object).getHeaderFields();
        return object;
    }

    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.connection;
        httpURLConnection = httpURLConnection == null ? null : Uri.parse((String)httpURLConnection.getURL().toString());
        return httpURLConnection;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public long open(DataSpec var1_1) {
        block27: {
            block28: {
                var2_2 = "Unable to connect";
                this.dataSpec = var1_1;
                this.bytesRead = var3_4 = 0L;
                this.bytesSkipped = var3_4;
                this.transferInitializing((DataSpec)var1_1);
                var5_5 = 1;
                var6_6 = this.makeConnection((DataSpec)var1_1);
                this.connection = var6_6;
                var7_7 = var6_6.getResponseCode();
                this.responseCode = var7_7;
                var8_8 = var6_6.getResponseMessage();
                var9_9 = this.responseCode;
                var7_7 = 200;
                if (var9_9 < var7_7 || var9_9 > (var10_10 = 299)) break block27;
                var2_2 = var6_6.getContentType();
                var11_11 = this.contentTypePredicate;
                if (var11_11 != null && (var10_10 = (int)var11_11.apply(var2_2)) == 0) {
                    this.closeConnectionQuietly();
                    var12_13 = new HttpDataSource$InvalidContentTypeException((String)var2_2, (DataSpec)var1_1);
                    throw var12_13;
                }
                var9_9 = this.responseCode;
                if (var9_9 == var7_7 && (var9_9 = (int)((cfr_temp_0 = (var13_18 = var1_1.position) - var3_4) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) != 0) {
                    var3_4 = var13_18;
                }
                this.bytesToSkip = var3_4;
                var9_9 = (int)DefaultHttpDataSource.isCompressed((HttpURLConnection)var6_6);
                if (var9_9 == 0) {
                    var3_4 = var1_1.length;
                    var13_18 = -1;
                    cfr_temp_1 = var3_4 - var13_18;
                    var15_19 /* !! */  = (long)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                    if (var15_19 /* !! */  != false) {
                        this.bytesToRead = var3_4;
                    } else {
                        var3_4 = DefaultHttpDataSource.getContentLength((HttpURLConnection)var6_6);
                        cfr_temp_2 = var3_4 - var13_18;
                        var15_19 /* !! */  = (long)(cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1));
                        if (var15_19 /* !! */  != false) {
                            var13_18 = this.bytesToSkip;
                            var13_18 = var3_4 - var13_18;
                        }
                        this.bytesToRead = var13_18;
                    }
                } else {
                    this.bytesToRead = var3_4 = var1_1.length;
                }
                try {
                    var12_14 = var6_6.getInputStream();
                }
                catch (IOException var2_3) {
                    this.closeConnectionQuietly();
                    var12_14 = new HttpDataSource$HttpDataSourceException(var2_3, (DataSpec)var1_1, var5_5);
                    throw var12_14;
                }
                this.inputStream = var12_14;
                if (var9_9 == 0) break block28;
                var12_14 = this.inputStream;
                var2_2 = new GZIPInputStream((InputStream)var12_14);
                this.inputStream = var2_2;
            }
            this.opened = var5_5;
            this.transferStarted((DataSpec)var1_1);
            return this.bytesToRead;
        }
        var16_21 = var6_6.getHeaderFields();
        var2_2 = var6_6.getErrorStream();
        if (var2_2 != null) {
            var2_2 = Util.toByteArray((InputStream)var2_2);
        }
        try {
            var2_2 = Util.EMPTY_BYTE_ARRAY;
        }
        catch (IOException v0) {
            var2_2 = Util.EMPTY_BYTE_ARRAY;
        }
lbl75:
        // 2 sources

        while (true) {
            continue;
            break;
        }
        ** while (true)
        var17_22 = var2_2;
        this.closeConnectionQuietly();
        var15_20 = this.responseCode;
        var11_12 = var2_2;
        var2_2 = new HttpDataSource$InvalidResponseCodeException(var15_20, var8_8, var16_21, (DataSpec)var1_1, (byte[])var17_22);
        var18_23 = this.responseCode;
        var19_24 = 416;
        if (var18_23 == var19_24) {
            var19_24 = 0;
            var12_15 = null;
            var1_1 = new DataSourceException(0);
            var2_2.initCause((Throwable)var1_1);
        }
        throw var2_2;
        catch (IOException var12_16) {
            this.closeConnectionQuietly();
            var20_25 = new HttpDataSource$HttpDataSourceException((String)var2_2, var12_16, (DataSpec)var1_1, var5_5);
            throw var20_25;
        }
        catch (IOException var12_17) {
            var20_26 = var12_17.getMessage();
            if (var20_26 != null && (var21_27 = (var20_26 = Util.toLowerInvariant((String)var20_26)).matches((String)(var6_6 = "cleartext http traffic.*not permitted.*")))) {
                var2_2 = new HttpDataSource$CleartextNotPermittedException(var12_17, (DataSpec)var1_1);
                throw var2_2;
            }
            var20_26 = new HttpDataSource$HttpDataSourceException((String)var2_2, var12_17, (DataSpec)var1_1, var5_5);
            throw var20_26;
        }
    }

    public HttpURLConnection openConnection(URL uRL) {
        return (HttpURLConnection)((URLConnection)FirebasePerfUrlConnection.instrument(uRL.openConnection()));
    }

    public int read(byte[] byArray, int n10, int n11) {
        try {
            this.skipInternal();
        }
        catch (IOException iOException) {
            DataSpec dataSpec = (DataSpec)Util.castNonNull(this.dataSpec);
            HttpDataSource$HttpDataSourceException httpDataSource$HttpDataSourceException = new HttpDataSource$HttpDataSourceException(iOException, dataSpec, 2);
            throw httpDataSource$HttpDataSourceException;
        }
        return this.readInternal(byArray, n10, n11);
    }

    public void setContentTypePredicate(Predicate predicate) {
        this.contentTypePredicate = predicate;
    }

    public void setRequestProperty(String string2, String string3) {
        Assertions.checkNotNull(string2);
        Assertions.checkNotNull(string3);
        this.requestProperties.set(string2, string3);
    }
}

