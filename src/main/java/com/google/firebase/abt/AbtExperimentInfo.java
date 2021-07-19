/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.firebase.abt;

import android.text.TextUtils;
import com.google.firebase.abt.AbtException;
import com.google.firebase.analytics.connector.AnalyticsConnector$ConditionalUserProperty;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AbtExperimentInfo {
    private static final String[] ALL_REQUIRED_KEYS = new String[]{"experimentId", "experimentStartTime", "timeToLiveMillis", "triggerTimeoutMillis", "variantId"};
    public static final String EXPERIMENT_ID_KEY = "experimentId";
    public static final String EXPERIMENT_START_TIME_KEY = "experimentStartTime";
    public static final String TIME_TO_LIVE_KEY = "timeToLiveMillis";
    public static final String TRIGGER_EVENT_KEY = "triggerEvent";
    public static final String TRIGGER_TIMEOUT_KEY = "triggerTimeoutMillis";
    public static final String VARIANT_ID_KEY = "variantId";
    public static final DateFormat protoTimestampStringParser;
    private final String experimentId;
    private final Date experimentStartTime;
    private final long timeToLiveInMillis;
    private final String triggerEventName;
    private final long triggerTimeoutInMillis;
    private final String variantId;

    static {
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", locale);
        protoTimestampStringParser = simpleDateFormat;
    }

    public AbtExperimentInfo(String string2, String string3, String string4, Date date, long l10, long l11) {
        this.experimentId = string2;
        this.variantId = string3;
        this.triggerEventName = string4;
        this.experimentStartTime = date;
        this.triggerTimeoutInMillis = l10;
        this.timeToLiveInMillis = l11;
    }

    public static AbtExperimentInfo fromConditionalUserProperty(AnalyticsConnector$ConditionalUserProperty analyticsConnector$ConditionalUserProperty) {
        Object object = analyticsConnector$ConditionalUserProperty.triggerEventName;
        if (object == null) {
            object = "";
        }
        String string2 = object;
        String string3 = analyticsConnector$ConditionalUserProperty.name;
        String string4 = String.valueOf(analyticsConnector$ConditionalUserProperty.value);
        long l10 = analyticsConnector$ConditionalUserProperty.creationTimestamp;
        Date date = new Date(l10);
        l10 = analyticsConnector$ConditionalUserProperty.triggerTimeout;
        long l11 = analyticsConnector$ConditionalUserProperty.timeToLive;
        object = new AbtExperimentInfo(string3, string4, string2, date, l10, l11);
        return object;
    }

    public static AbtExperimentInfo fromMap(Map object) {
        String string2;
        String string3;
        long l10;
        long l11;
        Date date;
        Object object2;
        Object object3;
        block22: {
            block21: {
                Object v10;
                Object v11;
                object3 = TRIGGER_EVENT_KEY;
                AbtExperimentInfo.validateExperimentInfoMap((Map)object);
                object2 = protoTimestampStringParser;
                String string4 = EXPERIMENT_START_TIME_KEY;
                Object v12 = object.get(string4);
                String string5 = (String)v12;
                date = ((DateFormat)object2).parse(string5);
                object2 = TRIGGER_TIMEOUT_KEY;
                object2 = object.get(object2);
                object2 = (String)object2;
                l11 = Long.parseLong((String)object2);
                object2 = TIME_TO_LIVE_KEY;
                object2 = object.get(object2);
                object2 = (String)object2;
                l10 = Long.parseLong((String)object2);
                String string6 = EXPERIMENT_ID_KEY;
                Object v13 = v11 = object.get(string6);
                string3 = (String)v11;
                String string7 = VARIANT_ID_KEY;
                Object v14 = v10 = object.get(string7);
                string2 = (String)v10;
                boolean bl2 = object.containsKey(object3);
                if (!bl2) break block21;
                object = object.get(object3);
                object = (String)object;
                break block22;
            }
            object = "";
        }
        try {
            object2 = new AbtExperimentInfo(string3, string2, (String)object, date, l11, l10);
            return object2;
        }
        catch (NumberFormatException numberFormatException) {
            object3 = new AbtException("Could not process experiment: one of the durations could not be converted into a long.", numberFormatException);
            throw object3;
        }
        catch (ParseException parseException) {
            object3 = new AbtException("Could not process experiment: parsing experiment start time failed.", parseException);
            throw object3;
        }
    }

    public static void validateAbtExperimentInfo(AbtExperimentInfo abtExperimentInfo) {
        AbtExperimentInfo.validateExperimentInfoMap(abtExperimentInfo.toStringMap());
    }

    private static void validateExperimentInfoMap(Map object) {
        Object object2 = new ArrayList();
        for (String string2 : ALL_REQUIRED_KEYS) {
            boolean bl2 = object.containsKey(string2);
            if (bl2) continue;
            object2.add(string2);
        }
        boolean bl3 = object2.isEmpty();
        if (bl3) {
            return;
        }
        Object[] objectArray = new Object[]{object2};
        object2 = String.format("The following keys are missing from the experiment info map: %s", objectArray);
        object = new AbtException((String)object2);
        throw object;
    }

    public String getExperimentId() {
        return this.experimentId;
    }

    public long getStartTimeInMillisSinceEpoch() {
        return this.experimentStartTime.getTime();
    }

    public long getTimeToLiveInMillis() {
        return this.timeToLiveInMillis;
    }

    public String getTriggerEventName() {
        return this.triggerEventName;
    }

    public long getTriggerTimeoutInMillis() {
        return this.triggerTimeoutInMillis;
    }

    public String getVariantId() {
        return this.variantId;
    }

    public AnalyticsConnector$ConditionalUserProperty toConditionalUserProperty(String string2) {
        long l10;
        AnalyticsConnector$ConditionalUserProperty analyticsConnector$ConditionalUserProperty = new AnalyticsConnector$ConditionalUserProperty();
        analyticsConnector$ConditionalUserProperty.origin = string2;
        analyticsConnector$ConditionalUserProperty.creationTimestamp = l10 = this.getStartTimeInMillisSinceEpoch();
        analyticsConnector$ConditionalUserProperty.name = string2 = this.experimentId;
        string2 = this.variantId;
        analyticsConnector$ConditionalUserProperty.value = string2;
        string2 = this.triggerEventName;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            bl2 = false;
            string2 = null;
        } else {
            string2 = this.triggerEventName;
        }
        analyticsConnector$ConditionalUserProperty.triggerEventName = string2;
        analyticsConnector$ConditionalUserProperty.triggerTimeout = l10 = this.triggerTimeoutInMillis;
        analyticsConnector$ConditionalUserProperty.timeToLive = l10 = this.timeToLiveInMillis;
        return analyticsConnector$ConditionalUserProperty;
    }

    public Map toStringMap() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Object object = this.experimentId;
        hashMap.put(EXPERIMENT_ID_KEY, object);
        object = this.variantId;
        hashMap.put(VARIANT_ID_KEY, object);
        object = this.triggerEventName;
        hashMap.put(TRIGGER_EVENT_KEY, object);
        object = protoTimestampStringParser;
        Date date = this.experimentStartTime;
        object = ((DateFormat)object).format(date);
        hashMap.put(EXPERIMENT_START_TIME_KEY, object);
        object = Long.toString(this.triggerTimeoutInMillis);
        hashMap.put(TRIGGER_TIMEOUT_KEY, object);
        object = Long.toString(this.timeToLiveInMillis);
        hashMap.put(TIME_TO_LIVE_KEY, object);
        return hashMap;
    }
}

