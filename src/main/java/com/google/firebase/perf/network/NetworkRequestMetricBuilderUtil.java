/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.apache.http.HttpMessage
 *  org.apache.http.HttpResponse
 */
package com.google.firebase.perf.network;

import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.logging.AndroidLogger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;

public final class NetworkRequestMetricBuilderUtil {
    private static final Pattern FLG_USER_AGENT_PATTERN = Pattern.compile("(^|.*\\s)datatransport/\\S+ android/($|\\s.*)");

    private NetworkRequestMetricBuilderUtil() {
    }

    public static Long getApacheHttpMessageContentLength(HttpMessage object) {
        block5: {
            String string2 = "content-length";
            object = object.getFirstHeader(string2);
            if (object == null) break block5;
            object = object.getValue();
            long l10 = Long.parseLong((String)object);
            try {
                return l10;
            }
            catch (NumberFormatException numberFormatException) {
                object = AndroidLogger.getInstance();
                string2 = "The content-length value is not a valid number";
                object.debug(string2);
            }
        }
        return null;
    }

    public static String getApacheHttpResponseContentType(HttpResponse object) {
        String string2 = "content-type";
        if ((object = object.getFirstHeader(string2)) != null && (object = object.getValue()) != null) {
            return object;
        }
        return null;
    }

    public static boolean isAllowedUserAgent(String object) {
        Pattern pattern;
        boolean bl2;
        if (object != null && (bl2 = ((Matcher)(object = (pattern = FLG_USER_AGENT_PATTERN).matcher((CharSequence)object))).matches())) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static void logError(NetworkRequestMetricBuilder networkRequestMetricBuilder) {
        boolean bl2 = networkRequestMetricBuilder.hasHttpResponseCode();
        if (!bl2) {
            networkRequestMetricBuilder.setNetworkClientErrorReason();
        }
        networkRequestMetricBuilder.build();
    }
}

