/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.google.firebase.remoteconfig.internal;

import com.google.firebase.remoteconfig.internal.ConfigContainer$1;
import com.google.firebase.remoteconfig.internal.ConfigContainer$Builder;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

public class ConfigContainer {
    public static final String ABT_EXPERIMENTS_KEY = "abt_experiments_key";
    public static final String CONFIGS_KEY = "configs_key";
    private static final Date DEFAULTS_FETCH_TIME;
    public static final String FETCH_TIME_KEY = "fetch_time_key";
    public static final String PERSONALIZATION_METADATA_KEY = "personalization_metadata_key";
    private JSONArray abtExperiments;
    private JSONObject configsJson;
    private JSONObject containerJson;
    private Date fetchTime;
    private JSONObject personalizationMetadata;

    static {
        Date date;
        DEFAULTS_FETCH_TIME = date = new Date(0L);
    }

    private ConfigContainer(JSONObject jSONObject, Date date, JSONArray jSONArray, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(CONFIGS_KEY, (Object)jSONObject);
        long l10 = date.getTime();
        jSONObject3.put(FETCH_TIME_KEY, l10);
        jSONObject3.put(ABT_EXPERIMENTS_KEY, (Object)jSONArray);
        jSONObject3.put(PERSONALIZATION_METADATA_KEY, (Object)jSONObject2);
        this.configsJson = jSONObject;
        this.fetchTime = date;
        this.abtExperiments = jSONArray;
        this.personalizationMetadata = jSONObject2;
        this.containerJson = jSONObject3;
    }

    public /* synthetic */ ConfigContainer(JSONObject jSONObject, Date date, JSONArray jSONArray, JSONObject jSONObject2, ConfigContainer$1 configContainer$1) {
        this(jSONObject, date, jSONArray, jSONObject2);
    }

    public static /* synthetic */ Date access$000() {
        return DEFAULTS_FETCH_TIME;
    }

    public static ConfigContainer copyOf(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.optJSONObject(PERSONALIZATION_METADATA_KEY);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        JSONObject jSONObject3 = jSONObject.getJSONObject(CONFIGS_KEY);
        long l10 = jSONObject.getLong(FETCH_TIME_KEY);
        Date date = new Date(l10);
        jSONObject = jSONObject.getJSONArray(ABT_EXPERIMENTS_KEY);
        ConfigContainer configContainer = new ConfigContainer(jSONObject3, date, (JSONArray)jSONObject, jSONObject2);
        return configContainer;
    }

    public static ConfigContainer$Builder newBuilder() {
        ConfigContainer$Builder configContainer$Builder = new ConfigContainer$Builder(null);
        return configContainer$Builder;
    }

    public static ConfigContainer$Builder newBuilder(ConfigContainer configContainer) {
        ConfigContainer$Builder configContainer$Builder = new ConfigContainer$Builder(configContainer);
        return configContainer$Builder;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof ConfigContainer;
        if (!bl2) {
            return false;
        }
        object = (ConfigContainer)object;
        String string2 = this.containerJson.toString();
        object = ((ConfigContainer)object).toString();
        return string2.equals(object);
    }

    public JSONArray getAbtExperiments() {
        return this.abtExperiments;
    }

    public JSONObject getConfigs() {
        return this.configsJson;
    }

    public Date getFetchTime() {
        return this.fetchTime;
    }

    public JSONObject getPersonalizationMetadata() {
        return this.personalizationMetadata;
    }

    public int hashCode() {
        return this.containerJson.hashCode();
    }

    public String toString() {
        return this.containerJson.toString();
    }
}

