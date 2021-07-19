/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.firebase.perf.internal;

import android.content.Context;
import com.google.firebase.perf.internal.PerfMetricValidator;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.URLAllowlist;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.NetworkRequestMetric$HttpMethod;
import java.net.URI;

public final class FirebasePerfNetworkValidator
extends PerfMetricValidator {
    private static final int EMPTY_PORT = 255;
    private static final String HTTPS = "https";
    private static final String HTTP_SCHEMA = "http";
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final Context context;
    private final NetworkRequestMetric mNetworkMetric;

    public FirebasePerfNetworkValidator(NetworkRequestMetric networkRequestMetric, Context context) {
        this.context = context;
        this.mNetworkMetric = networkRequestMetric;
    }

    private URI getResultUrl(String string2) {
        String string3;
        if (string2 == null) {
            return null;
        }
        try {
            return URI.create(string2);
        }
        catch (IllegalStateException illegalStateException) {
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        AndroidLogger androidLogger = logger;
        Object[] objectArray = new Object[1];
        string3 = ((Throwable)((Object)string3)).getMessage();
        objectArray[0] = string3;
        androidLogger.warn("getResultUrl throws exception %s", objectArray);
        return null;
    }

    private boolean isAllowlisted(URI uRI, Context context) {
        if (uRI == null) {
            return false;
        }
        return URLAllowlist.isURLAllowlisted(uRI, context);
    }

    private boolean isBlank(String string2) {
        if (string2 == null) {
            return true;
        }
        return string2.trim().isEmpty();
    }

    private boolean isEmptyUrl(String string2) {
        return this.isBlank(string2);
    }

    private boolean isValidHost(String string2) {
        int n10;
        int n11;
        if (string2 != null && (n11 = this.isBlank(string2)) == 0 && (n10 = string2.length()) <= (n11 = 255)) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        return n10 != 0;
    }

    private boolean isValidHttpResponseCode(int n10) {
        n10 = n10 > 0 ? 1 : 0;
        return n10 != 0;
    }

    private boolean isValidPayload(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object >= 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    private boolean isValidPort(int n10) {
        int n11 = -1;
        n10 = n10 != n11 && n10 <= 0 ? 0 : 1;
        return n10 != 0;
    }

    private boolean isValidScheme(String string2) {
        boolean bl2;
        boolean bl3 = false;
        if (string2 == null) {
            return false;
        }
        String string3 = HTTP_SCHEMA;
        boolean bl4 = string3.equalsIgnoreCase(string2);
        if (bl4 || (bl2 = (string3 = HTTPS).equalsIgnoreCase(string2))) {
            bl3 = true;
        }
        return bl3;
    }

    private boolean isValidTime(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object >= 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    private boolean isValidUserInfo(String string2) {
        boolean bl2;
        if (string2 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public boolean isValidHttpMethod(NetworkRequestMetric$HttpMethod networkRequestMetric$HttpMethod) {
        boolean bl2;
        NetworkRequestMetric$HttpMethod networkRequestMetric$HttpMethod2;
        if (networkRequestMetric$HttpMethod != null && networkRequestMetric$HttpMethod != (networkRequestMetric$HttpMethod2 = NetworkRequestMetric$HttpMethod.HTTP_METHOD_UNKNOWN)) {
            bl2 = true;
        } else {
            bl2 = false;
            networkRequestMetric$HttpMethod = null;
        }
        return bl2;
    }

    public boolean isValidPerfMetric() {
        long l10;
        long l11;
        long l12;
        Object object = this.mNetworkMetric.getUrl();
        int n10 = this.isEmptyUrl((String)object);
        if (n10 != 0) {
            object = logger;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("URL is missing:");
            String string2 = this.mNetworkMetric.getUrl();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            ((AndroidLogger)object).info((String)charSequence);
            return false;
        }
        object = this.mNetworkMetric.getUrl();
        if ((object = this.getResultUrl((String)object)) == null) {
            logger.info("URL cannot be parsed");
            return false;
        }
        Object object2 = this.context;
        boolean bl2 = this.isAllowlisted((URI)object, (Context)object2);
        if (!bl2) {
            object2 = logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("URL fails allowlist rule: ");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            ((AndroidLogger)object2).info((String)object);
            return false;
        }
        object2 = ((URI)object).getHost();
        bl2 = this.isValidHost((String)object2);
        if (!bl2) {
            logger.info("URL host is null or invalid");
            return false;
        }
        object2 = ((URI)object).getScheme();
        bl2 = this.isValidScheme((String)object2);
        if (!bl2) {
            logger.info("URL scheme is null or invalid");
            return false;
        }
        object2 = ((URI)object).getUserInfo();
        bl2 = this.isValidUserInfo((String)object2);
        if (!bl2) {
            logger.info("URL user info is null");
            return false;
        }
        n10 = ((URI)object).getPort();
        if ((n10 = (int)(this.isValidPort(n10) ? 1 : 0)) == 0) {
            logger.info("URL port is less than or equal to 0");
            return false;
        }
        object = this.mNetworkMetric;
        n10 = (int)(((NetworkRequestMetric)object).hasHttpMethod() ? 1 : 0);
        if (n10 != 0) {
            object = this.mNetworkMetric.getHttpMethod();
        } else {
            n10 = 0;
            object = null;
        }
        n10 = (int)(this.isValidHttpMethod((NetworkRequestMetric$HttpMethod)object) ? 1 : 0);
        if (n10 == 0) {
            object = logger;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("HTTP Method is null or invalid: ");
            NetworkRequestMetric$HttpMethod networkRequestMetric$HttpMethod = this.mNetworkMetric.getHttpMethod();
            ((StringBuilder)object2).append(networkRequestMetric$HttpMethod);
            object2 = ((StringBuilder)object2).toString();
            ((AndroidLogger)object).info((String)object2);
            return false;
        }
        object = this.mNetworkMetric;
        n10 = (int)(((NetworkRequestMetric)object).hasHttpResponseCode() ? 1 : 0);
        if (n10 != 0) {
            object = this.mNetworkMetric;
            n10 = ((NetworkRequestMetric)object).getHttpResponseCode();
            if ((n10 = (int)(this.isValidHttpResponseCode(n10) ? 1 : 0)) == 0) {
                object = logger;
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("HTTP ResponseCode is a negative value:");
                int n11 = this.mNetworkMetric.getHttpResponseCode();
                ((StringBuilder)object2).append(n11);
                object2 = ((StringBuilder)object2).toString();
                ((AndroidLogger)object).info((String)object2);
                return false;
            }
        }
        if ((n10 = (int)(((NetworkRequestMetric)(object = this.mNetworkMetric)).hasRequestPayloadBytes() ? 1 : 0)) != 0 && (n10 = (int)(this.isValidPayload(l12 = ((NetworkRequestMetric)(object = this.mNetworkMetric)).getRequestPayloadBytes()) ? 1 : 0)) == 0) {
            object = logger;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Request Payload is a negative value:");
            long l13 = this.mNetworkMetric.getRequestPayloadBytes();
            ((StringBuilder)object2).append(l13);
            object2 = ((StringBuilder)object2).toString();
            ((AndroidLogger)object).info((String)object2);
            return false;
        }
        object = this.mNetworkMetric;
        n10 = (int)(((NetworkRequestMetric)object).hasResponsePayloadBytes() ? 1 : 0);
        if (n10 != 0 && (n10 = (int)(this.isValidPayload(l12 = ((NetworkRequestMetric)(object = this.mNetworkMetric)).getResponsePayloadBytes()) ? 1 : 0)) == 0) {
            object = logger;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Response Payload is a negative value:");
            long l14 = this.mNetworkMetric.getResponsePayloadBytes();
            ((StringBuilder)object2).append(l14);
            object2 = ((StringBuilder)object2).toString();
            ((AndroidLogger)object).info((String)object2);
            return false;
        }
        object = this.mNetworkMetric;
        n10 = (int)(((NetworkRequestMetric)object).hasClientStartTimeUs() ? 1 : 0);
        if (n10 != 0 && (n10 = (int)((l11 = (l12 = ((NetworkRequestMetric)(object = this.mNetworkMetric)).getClientStartTimeUs()) - (l10 = 0L)) == 0L ? 0 : (l11 < 0L ? -1 : 1))) > 0) {
            long l15;
            object = this.mNetworkMetric;
            n10 = (int)(((NetworkRequestMetric)object).hasTimeToRequestCompletedUs() ? 1 : 0);
            if (n10 != 0 && (n10 = (int)(this.isValidTime(l12 = ((NetworkRequestMetric)(object = this.mNetworkMetric)).getTimeToRequestCompletedUs()) ? 1 : 0)) == 0) {
                object = logger;
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Time to complete the request is a negative value:");
                long l16 = this.mNetworkMetric.getTimeToRequestCompletedUs();
                ((StringBuilder)object2).append(l16);
                object2 = ((StringBuilder)object2).toString();
                ((AndroidLogger)object).info((String)object2);
                return false;
            }
            object = this.mNetworkMetric;
            n10 = (int)(((NetworkRequestMetric)object).hasTimeToResponseInitiatedUs() ? 1 : 0);
            if (n10 != 0 && (n10 = (int)(this.isValidTime(l12 = ((NetworkRequestMetric)(object = this.mNetworkMetric)).getTimeToResponseInitiatedUs()) ? 1 : 0)) == 0) {
                object = logger;
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Time from the start of the request to the start of the response is null or a negative value:");
                long l17 = this.mNetworkMetric.getTimeToResponseInitiatedUs();
                ((StringBuilder)object2).append(l17);
                object2 = ((StringBuilder)object2).toString();
                ((AndroidLogger)object).info((String)object2);
                return false;
            }
            object = this.mNetworkMetric;
            n10 = (int)(((NetworkRequestMetric)object).hasTimeToResponseCompletedUs() ? 1 : 0);
            if (n10 != 0 && (n10 = (int)((l15 = (l12 = ((NetworkRequestMetric)(object = this.mNetworkMetric)).getTimeToResponseCompletedUs()) - l10) == 0L ? 0 : (l15 < 0L ? -1 : 1))) > 0) {
                object = this.mNetworkMetric;
                n10 = (int)(((NetworkRequestMetric)object).hasHttpResponseCode() ? 1 : 0);
                if (n10 == 0) {
                    logger.info("Did not receive a HTTP Response Code");
                    return false;
                }
                return true;
            }
            object = logger;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Time from the start of the request to the end of the response is null, negative or zero:");
            long l18 = this.mNetworkMetric.getTimeToResponseCompletedUs();
            ((StringBuilder)object2).append(l18);
            object2 = ((StringBuilder)object2).toString();
            ((AndroidLogger)object).info((String)object2);
            return false;
        }
        object = logger;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Start time of the request is null, or zero, or a negative value:");
        long l19 = this.mNetworkMetric.getClientStartTimeUs();
        ((StringBuilder)object2).append(l19);
        object2 = ((StringBuilder)object2).toString();
        ((AndroidLogger)object).info((String)object2);
        return false;
    }
}

