/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.drm;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.ExoMediaDrm$KeyRequest;
import com.google.android.exoplayer2.drm.ExoMediaDrm$ProvisionRequest;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.drm.MediaDrmCallbackException;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DataSpec$Builder;
import com.google.android.exoplayer2.upstream.HttpDataSource$Factory;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableMap;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class HttpMediaDrmCallback
implements MediaDrmCallback {
    private static final int MAX_MANUAL_REDIRECTS = 5;
    private final HttpDataSource$Factory dataSourceFactory;
    private final String defaultLicenseUrl;
    private final boolean forceDefaultLicenseUrl;
    private final Map keyRequestProperties;

    public HttpMediaDrmCallback(String string2, HttpDataSource$Factory httpDataSource$Factory) {
        this(string2, false, httpDataSource$Factory);
    }

    public HttpMediaDrmCallback(String hashMap, boolean bl2, HttpDataSource$Factory httpDataSource$Factory) {
        boolean bl3;
        bl3 = !bl2 || !(bl3 = TextUtils.isEmpty((CharSequence)((Object)hashMap)));
        Assertions.checkArgument(bl3);
        this.dataSourceFactory = httpDataSource$Factory;
        this.defaultLicenseUrl = hashMap;
        this.forceDefaultLicenseUrl = bl2;
        this.keyRequestProperties = hashMap = new HashMap();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static byte[] executePost(HttpDataSource$Factory object, String object2, byte[] object3, Map map) {
        object = object.createDataSource();
        StatsDataSource statsDataSource = new StatsDataSource((DataSource)object);
        object = new DataSpec$Builder();
        object = ((DataSpec$Builder)object).setUri((String)object2).setHttpRequestHeaders(map).setHttpMethod(2).setHttpBody((byte[])object3);
        int n10 = 1;
        DataSpec dataSpec = ((DataSpec$Builder)object).setFlags(n10).build();
        int n11 = 0;
        object = null;
        object2 = dataSpec;
        while (true) {
            Object object4;
            object3 = new DataSourceInputStream;
            object3(statsDataSource, (DataSpec)object2);
            {
                catch (Exception exception) {
                    Object object5 = object2 = Assertions.checkNotNull(statsDataSource.getLastOpenedUri());
                    object5 = (Uri)object2;
                    Map map2 = statsDataSource.getResponseHeaders();
                    long l10 = statsDataSource.getBytesRead();
                    object4 = object;
                    object = new MediaDrmCallbackException(dataSpec, (Uri)object5, map2, l10, exception);
                    throw object;
                }
            }
            object = Util.toByteArray((InputStream)object3);
            Util.closeQuietly((Closeable)object3);
            return object;
            {
                Throwable throwable22;
                block11: {
                    catch (Throwable throwable22) {
                        break block11;
                    }
                    catch (HttpDataSource$InvalidResponseCodeException httpDataSource$InvalidResponseCodeException) {}
                    {
                        object4 = HttpMediaDrmCallback.getRedirectUrl(httpDataSource$InvalidResponseCodeException, n11);
                        if (object4 == null) throw httpDataSource$InvalidResponseCodeException;
                        ++n11;
                        object2 = ((DataSpec)object2).buildUpon();
                        object2 = ((DataSpec$Builder)object2).setUri((String)object4);
                        object2 = ((DataSpec$Builder)object2).build();
                    }
                    Util.closeQuietly((Closeable)object3);
                    continue;
                }
                Util.closeQuietly((Closeable)object3);
                throw throwable22;
            }
            break;
        }
    }

    private static String getRedirectUrl(HttpDataSource$InvalidResponseCodeException object, int n10) {
        String string2;
        int n11 = ((HttpDataSource$InvalidResponseCodeException)object).responseCode;
        int n12 = 307;
        if ((n11 == n12 || n11 == (n12 = 308)) && n10 < (n11 = 5)) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        n11 = 0;
        if (n10 == 0) {
            return null;
        }
        object = ((HttpDataSource$InvalidResponseCodeException)object).headerFields;
        if (object != null && (object = (List)object.get(string2 = "Location")) != null && (n10 = (int)(object.isEmpty() ? 1 : 0)) == 0) {
            return (String)object.get(0);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clearAllKeyRequestProperties() {
        Map map = this.keyRequestProperties;
        synchronized (map) {
            Map map2 = this.keyRequestProperties;
            map2.clear();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clearKeyRequestProperty(String string2) {
        Assertions.checkNotNull(string2);
        Map map = this.keyRequestProperties;
        synchronized (map) {
            Map map2 = this.keyRequestProperties;
            map2.remove(string2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public byte[] executeKeyRequest(UUID object, ExoMediaDrm$KeyRequest object2) {
        Object object3;
        Object object4 = ((ExoMediaDrm$KeyRequest)object2).getLicenseServerUrl();
        boolean bl2 = this.forceDefaultLicenseUrl;
        if (bl2 || (bl2 = TextUtils.isEmpty((CharSequence)object4))) {
            object4 = this.defaultLicenseUrl;
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)object4)) {
            object2 = new DataSpec$Builder();
            object4 = Uri.EMPTY;
            DataSpec dataSpec = ((DataSpec$Builder)object2).setUri((Uri)object4).build();
            Uri uri = Uri.EMPTY;
            ImmutableMap immutableMap = ImmutableMap.of();
            IllegalStateException illegalStateException = new IllegalStateException("No license URL");
            object4 = object;
            object = new MediaDrmCallbackException(dataSpec, uri, immutableMap, 0L, illegalStateException);
            throw object;
        }
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        Object object5 = C.PLAYREADY_UUID;
        boolean bl3 = ((UUID)object5).equals(object);
        object3 = bl3 ? "text/xml" : ((bl3 = ((UUID)(object3 = C.CLEARKEY_UUID)).equals(object)) ? "application/json" : "application/octet-stream");
        String string2 = "Content-Type";
        hashMap.put(string2, object3);
        boolean bl4 = ((UUID)object5).equals(object);
        if (bl4) {
            object = "SOAPAction";
            object5 = "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense";
            hashMap.put(object, object5);
        }
        object = this.keyRequestProperties;
        synchronized (object) {
            object5 = this.keyRequestProperties;
            hashMap.putAll((Map<Object, Object>)object5);
        }
        object = this.dataSourceFactory;
        object2 = ((ExoMediaDrm$KeyRequest)object2).getData();
        return HttpMediaDrmCallback.executePost((HttpDataSource$Factory)object, (String)object4, (byte[])object2, hashMap);
    }

    public byte[] executeProvisionRequest(UUID object, ExoMediaDrm$ProvisionRequest object2) {
        object = ((ExoMediaDrm$ProvisionRequest)object2).getDefaultUrl();
        object2 = Util.fromUtf8Bytes(((ExoMediaDrm$ProvisionRequest)object2).getData());
        int n10 = String.valueOf(object).length() + 15;
        int n11 = String.valueOf(object2).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append((String)object);
        stringBuilder.append("&signedRequest=");
        stringBuilder.append((String)object2);
        object = stringBuilder.toString();
        object2 = this.dataSourceFactory;
        Map map = Collections.emptyMap();
        return HttpMediaDrmCallback.executePost((HttpDataSource$Factory)object2, (String)object, null, map);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setKeyRequestProperty(String string2, String string3) {
        Assertions.checkNotNull(string2);
        Assertions.checkNotNull(string3);
        Map map = this.keyRequestProperties;
        synchronized (map) {
            Map map2 = this.keyRequestProperties;
            map2.put(string2, string3);
            return;
        }
    }
}

