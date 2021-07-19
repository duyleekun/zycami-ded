/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.telephony.TelephonyManager
 */
package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.cct.CctTransportBackend$$Lambda$1;
import com.google.android.datatransport.cct.CctTransportBackend$$Lambda$4;
import com.google.android.datatransport.cct.CctTransportBackend$HttpRequest;
import com.google.android.datatransport.cct.CctTransportBackend$HttpResponse;
import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.android.datatransport.cct.internal.AndroidClientInfo$Builder;
import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.ClientInfo$Builder;
import com.google.android.datatransport.cct.internal.ClientInfo$ClientType;
import com.google.android.datatransport.cct.internal.LogEvent;
import com.google.android.datatransport.cct.internal.LogEvent$Builder;
import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.android.datatransport.cct.internal.LogRequest$Builder;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo$Builder;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo$MobileSubtype;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo$NetworkType;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.EventInternal$Builder;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.retries.Function;
import com.google.android.datatransport.runtime.retries.Retries;
import com.google.android.datatransport.runtime.retries.RetryStrategy;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.encoders.DataEncoder;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;

public final class CctTransportBackend
implements TransportBackend {
    private static final String ACCEPT_ENCODING_HEADER_KEY = "Accept-Encoding";
    public static final String API_KEY_HEADER_KEY = "X-Goog-Api-Key";
    private static final int CONNECTION_TIME_OUT = 30000;
    private static final String CONTENT_ENCODING_HEADER_KEY = "Content-Encoding";
    private static final String CONTENT_TYPE_HEADER_KEY = "Content-Type";
    private static final String GZIP_CONTENT_ENCODING = "gzip";
    private static final int INVALID_VERSION_CODE = 255;
    private static final String JSON_CONTENT_TYPE = "application/json";
    private static final String KEY_APPLICATION_BUILD = "application_build";
    private static final String KEY_COUNTRY = "country";
    private static final String KEY_DEVICE = "device";
    private static final String KEY_FINGERPRINT = "fingerprint";
    private static final String KEY_HARDWARE = "hardware";
    private static final String KEY_LOCALE = "locale";
    private static final String KEY_MANUFACTURER = "manufacturer";
    private static final String KEY_MCC_MNC = "mcc_mnc";
    public static final String KEY_MOBILE_SUBTYPE = "mobile-subtype";
    private static final String KEY_MODEL = "model";
    public static final String KEY_NETWORK_TYPE = "net-type";
    private static final String KEY_OS_BUILD = "os-uild";
    private static final String KEY_PRODUCT = "product";
    private static final String KEY_SDK_VERSION = "sdk-version";
    private static final String KEY_TIMEZONE_OFFSET = "tz-offset";
    private static final String LOG_TAG = "CctTransportBackend";
    private static final int READ_TIME_OUT = 40000;
    private final Context applicationContext;
    private final ConnectivityManager connectivityManager;
    private final DataEncoder dataEncoder;
    public final URL endPoint;
    private final int readTimeout;
    private final Clock uptimeClock;
    private final Clock wallTimeClock;

    public CctTransportBackend(Context context, Clock clock, Clock clock2) {
        this(context, clock, clock2, 40000);
    }

    public CctTransportBackend(Context object, Clock clock, Clock clock2, int n10) {
        DataEncoder dataEncoder;
        this.dataEncoder = dataEncoder = BatchedLogRequest.createDataEncoder();
        this.applicationContext = object;
        object = (ConnectivityManager)object.getSystemService("connectivity");
        this.connectivityManager = object;
        object = CctTransportBackend.parseUrlOrThrow(CCTDestination.DEFAULT_END_POINT);
        this.endPoint = object;
        this.uptimeClock = clock2;
        this.wallTimeClock = clock;
        this.readTimeout = n10;
    }

    public static /* synthetic */ CctTransportBackend$HttpResponse access$lambda$0(CctTransportBackend cctTransportBackend, CctTransportBackend$HttpRequest cctTransportBackend$HttpRequest) {
        return cctTransportBackend.doSend(cctTransportBackend$HttpRequest);
    }

    /*
     * Exception decompiling
     */
    private CctTransportBackend$HttpResponse doSend(CctTransportBackend$HttpRequest var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [31[CATCHBLOCK], 32[CATCHBLOCK]], but top level block is 44[UNCONDITIONALDOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private static int getNetSubtypeValue(NetworkInfo networkInfo) {
        int n10;
        if (networkInfo == null) {
            return NetworkConnectionInfo$MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.getValue();
        }
        int n11 = networkInfo.getSubtype();
        if (n11 == (n10 = -1)) {
            return NetworkConnectionInfo$MobileSubtype.COMBINED.getValue();
        }
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype = NetworkConnectionInfo$MobileSubtype.forNumber(n11);
        if (networkConnectionInfo$MobileSubtype == null) {
            n11 = 0;
            networkInfo = null;
        }
        return n11;
    }

    private static int getNetTypeValue(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo$NetworkType.NONE.getValue();
        }
        return networkInfo.getType();
    }

    private static int getPackageVersionCode(Context object) {
        PackageManager packageManager;
        try {
            packageManager = object.getPackageManager();
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            Logging.e(LOG_TAG, "Unable to find version code for package", nameNotFoundException);
            return -1;
        }
        object = object.getPackageName();
        object = packageManager.getPackageInfo((String)object, 0);
        return object.versionCode;
    }

    private BatchedLogRequest getRequestBody(BackendRequest arrayList) {
        ArrayList<Object> arrayList2;
        Object object;
        Object object2;
        boolean bl2;
        Object object3 = new HashMap();
        arrayList = ((BackendRequest)((Object)arrayList)).getEvents().iterator();
        while (bl2 = arrayList.hasNext()) {
            object2 = (EventInternal)arrayList.next();
            object = ((EventInternal)object2).getTransportName();
            boolean n10 = ((HashMap)object3).containsKey(object);
            if (!n10) {
                arrayList2 = new ArrayList<Object>();
                arrayList2.add(object2);
                ((HashMap)object3).put(object, arrayList2);
                continue;
            }
            object = (List)((HashMap)object3).get(object);
            object.add(object2);
        }
        arrayList = new ArrayList<Object>();
        object3 = ((HashMap)object3).entrySet().iterator();
        while (bl2 = object3.hasNext()) {
            boolean bl3;
            object2 = (Map.Entry)object3.next();
            object = (List)object2.getValue();
            int n10 = 0;
            object = (EventInternal)object.get(0);
            arrayList2 = LogRequest.builder();
            Object object4 = QosTier.DEFAULT;
            arrayList2 = ((LogRequest$Builder)((Object)arrayList2)).setQosTier((QosTier)((Object)object4));
            long l10 = this.wallTimeClock.getTime();
            arrayList2 = ((LogRequest$Builder)((Object)arrayList2)).setRequestTimeMs(l10);
            l10 = this.uptimeClock.getTime();
            arrayList2 = ((LogRequest$Builder)((Object)arrayList2)).setRequestUptimeMs(l10);
            object4 = ClientInfo.builder();
            Object object5 = ClientInfo$ClientType.ANDROID_FIREBASE;
            object4 = ((ClientInfo$Builder)object4).setClientType((ClientInfo$ClientType)((Object)object5));
            object5 = AndroidClientInfo.builder();
            int n11 = ((EventInternal)object).getInteger(KEY_SDK_VERSION);
            Object object6 = n11;
            object5 = ((AndroidClientInfo$Builder)object5).setSdkVersion((Integer)object6);
            object6 = ((EventInternal)object).get(KEY_MODEL);
            object5 = ((AndroidClientInfo$Builder)object5).setModel((String)object6);
            object6 = ((EventInternal)object).get(KEY_HARDWARE);
            object5 = ((AndroidClientInfo$Builder)object5).setHardware((String)object6);
            object6 = ((EventInternal)object).get(KEY_DEVICE);
            object5 = ((AndroidClientInfo$Builder)object5).setDevice((String)object6);
            object6 = ((EventInternal)object).get(KEY_PRODUCT);
            object5 = ((AndroidClientInfo$Builder)object5).setProduct((String)object6);
            object6 = ((EventInternal)object).get(KEY_OS_BUILD);
            object5 = ((AndroidClientInfo$Builder)object5).setOsBuild((String)object6);
            object6 = ((EventInternal)object).get(KEY_MANUFACTURER);
            object5 = ((AndroidClientInfo$Builder)object5).setManufacturer((String)object6);
            object6 = ((EventInternal)object).get(KEY_FINGERPRINT);
            object5 = ((AndroidClientInfo$Builder)object5).setFingerprint((String)object6);
            object6 = ((EventInternal)object).get(KEY_COUNTRY);
            object5 = ((AndroidClientInfo$Builder)object5).setCountry((String)object6);
            object6 = ((EventInternal)object).get(KEY_LOCALE);
            object5 = ((AndroidClientInfo$Builder)object5).setLocale((String)object6);
            object6 = ((EventInternal)object).get(KEY_MCC_MNC);
            object5 = ((AndroidClientInfo$Builder)object5).setMccMnc((String)object6);
            object6 = KEY_APPLICATION_BUILD;
            object = ((EventInternal)object).get((String)object6);
            object = ((AndroidClientInfo$Builder)object5).setApplicationBuild((String)object).build();
            object = ((ClientInfo$Builder)object4).setAndroidClientInfo((AndroidClientInfo)object).build();
            object = ((LogRequest$Builder)((Object)arrayList2)).setClientInfo((ClientInfo)object);
            arrayList2 = object2.getKey();
            arrayList2 = (String)((Object)arrayList2);
            n10 = Integer.parseInt((String)((Object)arrayList2));
            try {
                ((LogRequest$Builder)object).setSource(n10);
            }
            catch (NumberFormatException numberFormatException) {
                arrayList2 = (String)object2.getKey();
                ((LogRequest$Builder)object).setSource((String)((Object)arrayList2));
            }
            arrayList2 = new ArrayList<Object>();
            object2 = ((List)object2.getValue()).iterator();
            while (bl3 = object2.hasNext()) {
                block15: {
                    Object object7;
                    block14: {
                        boolean bl4;
                        block13: {
                            object4 = (EventInternal)object2.next();
                            object5 = ((EventInternal)object4).getEncodedPayload();
                            object6 = ((EncodedPayload)object5).getEncoding();
                            bl4 = ((Encoding)object6).equals(object7 = Encoding.of("proto"));
                            if (!bl4) break block13;
                            object5 = LogEvent.protoBuilder(((EncodedPayload)object5).getBytes());
                            break block14;
                        }
                        object7 = Encoding.of("json");
                        bl4 = ((Encoding)object6).equals(object7);
                        if (!bl4) break block15;
                        object5 = ((EncodedPayload)object5).getBytes();
                        object7 = Charset.forName("UTF-8");
                        object6 = new String((byte[])object5, (Charset)object7);
                        object5 = LogEvent.jsonBuilder((String)object6);
                    }
                    long l11 = ((EventInternal)object4).getEventMillis();
                    object6 = ((LogEvent$Builder)object5).setEventTimeMs(l11);
                    long l12 = ((EventInternal)object4).getUptimeMillis();
                    object6 = ((LogEvent$Builder)object6).setEventUptimeMs(l12);
                    l12 = ((EventInternal)object4).getLong(KEY_TIMEZONE_OFFSET);
                    object6 = ((LogEvent$Builder)object6).setTimezoneOffsetSeconds(l12);
                    object7 = NetworkConnectionInfo.builder();
                    Enum enum_ = NetworkConnectionInfo$NetworkType.forNumber(((EventInternal)object4).getInteger(KEY_NETWORK_TYPE));
                    object7 = ((NetworkConnectionInfo$Builder)object7).setNetworkType((NetworkConnectionInfo$NetworkType)enum_);
                    int n12 = ((EventInternal)object4).getInteger(KEY_MOBILE_SUBTYPE);
                    enum_ = NetworkConnectionInfo$MobileSubtype.forNumber(n12);
                    object7 = ((NetworkConnectionInfo$Builder)object7).setMobileSubtype((NetworkConnectionInfo$MobileSubtype)enum_).build();
                    ((LogEvent$Builder)object6).setNetworkConnectionInfo((NetworkConnectionInfo)object7);
                    object6 = ((EventInternal)object4).getCode();
                    if (object6 != null) {
                        object4 = ((EventInternal)object4).getCode();
                        ((LogEvent$Builder)object5).setEventCode((Integer)object4);
                    }
                    object4 = ((LogEvent$Builder)object5).build();
                    arrayList2.add(object4);
                    continue;
                }
                object4 = LOG_TAG;
                object5 = "Received event of unsupported encoding %s. Skipping...";
                Logging.w((String)object4, (String)object5, object6);
            }
            ((LogRequest$Builder)object).setLogEvents(arrayList2);
            object2 = ((LogRequest$Builder)object).build();
            arrayList.add(object2);
        }
        return BatchedLogRequest.create(arrayList);
    }

    private static TelephonyManager getTelephonyManager(Context context) {
        return (TelephonyManager)context.getSystemService("phone");
    }

    public static long getTzOffset() {
        Calendar.getInstance();
        TimeZone timeZone = TimeZone.getDefault();
        long l10 = Calendar.getInstance().getTimeInMillis();
        return timeZone.getOffset(l10) / 1000;
    }

    public static /* synthetic */ CctTransportBackend$HttpRequest lambda$send$0(CctTransportBackend$HttpRequest cctTransportBackend$HttpRequest, CctTransportBackend$HttpResponse object) {
        URL uRL = ((CctTransportBackend$HttpResponse)object).redirectUrl;
        if (uRL != null) {
            Logging.d(LOG_TAG, "Following redirect to: %s", (Object)uRL);
            object = ((CctTransportBackend$HttpResponse)object).redirectUrl;
            return cctTransportBackend$HttpRequest.withUrl((URL)object);
        }
        return null;
    }

    private static InputStream maybeUnGzip(InputStream inputStream, String object) {
        String string2 = GZIP_CONTENT_ENCODING;
        boolean bl2 = string2.equals(object);
        if (bl2) {
            object = new GZIPInputStream(inputStream);
            return object;
        }
        return inputStream;
    }

    private static URL parseUrlOrThrow(String string2) {
        try {
            URL uRL = new URL(string2);
            return uRL;
        }
        catch (MalformedURLException malformedURLException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid url: ");
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2, malformedURLException);
            throw illegalArgumentException;
        }
    }

    public EventInternal decorate(EventInternal object) {
        Object object2 = this.connectivityManager.getActiveNetworkInfo();
        object = ((EventInternal)object).toBuilder();
        int n10 = Build.VERSION.SDK_INT;
        object = ((EventInternal$Builder)object).addMetadata(KEY_SDK_VERSION, n10);
        String string2 = Build.MODEL;
        object = ((EventInternal$Builder)object).addMetadata(KEY_MODEL, string2);
        string2 = Build.HARDWARE;
        object = ((EventInternal$Builder)object).addMetadata(KEY_HARDWARE, string2);
        string2 = Build.DEVICE;
        object = ((EventInternal$Builder)object).addMetadata(KEY_DEVICE, string2);
        string2 = Build.PRODUCT;
        object = ((EventInternal$Builder)object).addMetadata(KEY_PRODUCT, string2);
        string2 = Build.ID;
        object = ((EventInternal$Builder)object).addMetadata(KEY_OS_BUILD, string2);
        string2 = Build.MANUFACTURER;
        object = ((EventInternal$Builder)object).addMetadata(KEY_MANUFACTURER, string2);
        string2 = Build.FINGERPRINT;
        object = ((EventInternal$Builder)object).addMetadata(KEY_FINGERPRINT, string2);
        long l10 = CctTransportBackend.getTzOffset();
        object = ((EventInternal$Builder)object).addMetadata(KEY_TIMEZONE_OFFSET, l10);
        n10 = CctTransportBackend.getNetTypeValue(object2);
        object = ((EventInternal$Builder)object).addMetadata(KEY_NETWORK_TYPE, n10);
        int n11 = CctTransportBackend.getNetSubtypeValue(object2);
        object = ((EventInternal$Builder)object).addMetadata(KEY_MOBILE_SUBTYPE, n11);
        object2 = Locale.getDefault().getCountry();
        object = ((EventInternal$Builder)object).addMetadata(KEY_COUNTRY, (String)object2);
        object2 = Locale.getDefault().getLanguage();
        object = ((EventInternal$Builder)object).addMetadata(KEY_LOCALE, (String)object2);
        object2 = CctTransportBackend.getTelephonyManager(this.applicationContext).getSimOperator();
        object = ((EventInternal$Builder)object).addMetadata(KEY_MCC_MNC, (String)object2);
        object2 = Integer.toString(CctTransportBackend.getPackageVersionCode(this.applicationContext));
        return ((EventInternal$Builder)object).addMetadata(KEY_APPLICATION_BUILD, (String)object2).build();
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public BackendResponse send(BackendRequest object) {
        int n10;
        int n11;
        block21: {
            CctTransportBackend$HttpRequest cctTransportBackend$HttpRequest;
            Object object2;
            Object object3;
            block20: {
                object3 = this.getRequestBody((BackendRequest)object);
                object2 = this.endPoint;
                byte[] byArray = ((BackendRequest)object).getExtras();
                Object var5_12 = null;
                if (byArray != null) {
                    block19: {
                        String string2;
                        try {
                            object = ((BackendRequest)object).getExtras();
                        }
                        catch (IllegalArgumentException illegalArgumentException) {
                            return BackendResponse.fatalError();
                        }
                        object = CCTDestination.fromByteArray((byte[])object);
                        String string3 = ((CCTDestination)object).getAPIKey();
                        if (string3 == null) break block19;
                        String string4 = string2 = ((CCTDestination)object).getAPIKey();
                    }
                    String string5 = ((CCTDestination)object).getEndPoint();
                    if (string5 == null) break block20;
                    object = ((CCTDestination)object).getEndPoint();
                    object2 = object = CctTransportBackend.parseUrlOrThrow((String)object);
                }
            }
            n11 = 5;
            try {
                void var5_14;
                cctTransportBackend$HttpRequest = new CctTransportBackend$HttpRequest((URL)object2, (BatchedLogRequest)object3, (String)var5_14);
                object3 = CctTransportBackend$$Lambda$1.lambdaFactory$(this);
            }
            catch (IOException iOException) {
                Logging.e(LOG_TAG, "Could not make request to the backend", iOException);
                return BackendResponse.transientError();
            }
            object2 = CctTransportBackend$$Lambda$4.lambdaFactory$();
            object = Retries.retry(n11, cctTransportBackend$HttpRequest, (Function)object3, (RetryStrategy)object2);
            object = (CctTransportBackend$HttpResponse)object;
            n10 = ((CctTransportBackend$HttpResponse)object).code;
            int n12 = 200;
            if (n10 != n12) break block21;
            long l10 = ((CctTransportBackend$HttpResponse)object).nextRequestMillis;
            return BackendResponse.ok(l10);
        }
        n11 = 500;
        if (n10 >= n11 || n10 == (n11 = 404)) return BackendResponse.transientError();
        return BackendResponse.fatalError();
    }
}

