/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.firebase.perf.internal;

import android.content.Context;
import com.google.firebase.perf.internal.FirebasePerfApplicationInfoValidator;
import com.google.firebase.perf.internal.FirebasePerfGaugeMetricValidator;
import com.google.firebase.perf.internal.FirebasePerfNetworkValidator;
import com.google.firebase.perf.internal.FirebasePerfTraceValidator;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Constants$CounterNames;
import com.google.firebase.perf.util.Constants$TraceNames;
import com.google.firebase.perf.v1.ApplicationInfo;
import com.google.firebase.perf.v1.GaugeMetric;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.PerfMetric;
import com.google.firebase.perf.v1.TraceMetric;
import com.google.protobuf.GeneratedMessageLite;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public abstract class PerfMetricValidator {
    private static List getValidators(PerfMetric generatedMessageLite, Context object) {
        boolean bl2;
        Object object2;
        GeneratedMessageLite generatedMessageLite2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        boolean bl3 = generatedMessageLite.hasTraceMetric();
        if (bl3) {
            generatedMessageLite2 = generatedMessageLite.getTraceMetric();
            object2 = new FirebasePerfTraceValidator((TraceMetric)generatedMessageLite2);
            arrayList.add(object2);
        }
        if (bl3 = generatedMessageLite.hasNetworkRequestMetric()) {
            generatedMessageLite2 = generatedMessageLite.getNetworkRequestMetric();
            object2 = new FirebasePerfNetworkValidator((NetworkRequestMetric)generatedMessageLite2, (Context)object);
            arrayList.add(object2);
        }
        if (bl2 = generatedMessageLite.hasApplicationInfo()) {
            object2 = generatedMessageLite.getApplicationInfo();
            object = new FirebasePerfApplicationInfoValidator((ApplicationInfo)object2);
            arrayList.add(object);
        }
        if (bl2 = generatedMessageLite.hasGaugeMetric()) {
            generatedMessageLite = generatedMessageLite.getGaugeMetric();
            object = new FirebasePerfGaugeMetricValidator((GaugeMetric)generatedMessageLite);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static boolean isValid(PerfMetric iterator2, Context object) {
        boolean bl2 = (iterator2 = PerfMetricValidator.getValidators((PerfMetric)((Object)iterator2), (Context)object)).isEmpty();
        if (bl2) {
            AndroidLogger.getInstance().debug("No validators found for PerfMetric.");
            return false;
        }
        iterator2 = iterator2.iterator();
        while (bl2 = iterator2.hasNext()) {
            object = (PerfMetricValidator)iterator2.next();
            bl2 = ((PerfMetricValidator)object).isValidPerfMetric();
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public static String validateAttribute(Map.Entry object) {
        Object[] objectArray = (Object[])object.getKey();
        object = (String)object.getValue();
        if (objectArray == null) {
            return "Attribute key must not be null";
        }
        if (object == null) {
            return "Attribute value must not be null";
        }
        int n10 = objectArray.length();
        int n11 = 1;
        int n12 = 40;
        if (n10 > n12) {
            object = Locale.US;
            objectArray = new Object[n11];
            Integer n13 = n12;
            objectArray[0] = n13;
            return String.format((Locale)object, "Attribute key length must not exceed %d characters", objectArray);
        }
        int n14 = ((String)object).length();
        if (n14 > (n10 = 100)) {
            object = Locale.US;
            objectArray = new Object[n11];
            Integer n15 = n10;
            objectArray[0] = n15;
            return String.format((Locale)object, "Attribute value length must not exceed %d characters", objectArray);
        }
        object = "^(?!(firebase_|google_|ga_))[A-Za-z][A-Za-z_0-9]*";
        n14 = (int)(objectArray.matches((String)object) ? 1 : 0);
        if (n14 == 0) {
            return "Attribute key must start with letter, must only contain alphanumeric characters and underscore and must not start with \"firebase_\", \"google_\" and \"ga_";
        }
        return null;
    }

    public static String validateMetricName(String object) {
        if (object == null) {
            return "Metric name must not be null";
        }
        int n10 = ((String)object).length();
        int n11 = 100;
        if (n10 > n11) {
            object = Locale.US;
            Object[] objectArray = new Object[1];
            Integer n12 = n11;
            objectArray[0] = n12;
            return String.format((Locale)object, "Metric name must not exceed %d characters", objectArray);
        }
        Constants$CounterNames[] constants$CounterNamesArray = "_";
        n10 = (int)(((String)object).startsWith((String)constants$CounterNamesArray) ? 1 : 0);
        n11 = 0;
        Object var5_7 = null;
        if (n10 != 0) {
            constants$CounterNamesArray = Constants$CounterNames.values();
            int n13 = constants$CounterNamesArray.length;
            for (int i10 = 0; i10 < n13; ++i10) {
                String string2 = constants$CounterNamesArray[i10].toString();
                boolean bl2 = string2.equals(object);
                if (!bl2) continue;
                return null;
            }
            return "Metric name must not start with '_'";
        }
        return null;
    }

    public static String validateTraceName(String object) {
        if (object == null) {
            return "Trace name must not be null";
        }
        int n10 = ((String)object).length();
        int n11 = 100;
        if (n10 > n11) {
            object = Locale.US;
            Object[] objectArray = new Object[1];
            Integer n12 = n11;
            objectArray[0] = n12;
            return String.format((Locale)object, "Trace name must not exceed %d characters", objectArray);
        }
        Object object2 = "_";
        n10 = (int)(((String)object).startsWith((String)object2) ? 1 : 0);
        n11 = 0;
        Object var5_7 = null;
        if (n10 != 0) {
            object2 = Constants$TraceNames.values();
            int n13 = ((Constants$TraceNames[])object2).length;
            for (int i10 = 0; i10 < n13; ++i10) {
                String string2 = object2[i10].toString();
                boolean bl2 = string2.equals(object);
                if (!bl2) continue;
                return null;
            }
            object2 = "_st_";
            boolean bl3 = ((String)object).startsWith((String)object2);
            if (bl3) {
                return null;
            }
            return "Trace name must not start with '_'";
        }
        return null;
    }

    public abstract boolean isValidPerfMetric();
}

