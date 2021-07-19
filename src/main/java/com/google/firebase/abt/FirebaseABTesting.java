/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.firebase.abt;

import android.content.Context;
import com.google.firebase.abt.AbtException;
import com.google.firebase.abt.AbtExperimentInfo;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.AnalyticsConnector$ConditionalUserProperty;
import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FirebaseABTesting {
    public static final String ABT_PREFERENCES = "com.google.firebase.abt";
    public static final String ORIGIN_LAST_KNOWN_START_TIME_KEY_FORMAT = "%s_lastKnownExperimentStartTime";
    private final AnalyticsConnector analyticsConnector;
    private Integer maxUserProperties;
    private final String originService;

    public FirebaseABTesting(Context context, AnalyticsConnector analyticsConnector, String string2) {
        this.analyticsConnector = analyticsConnector;
        this.originService = string2;
        this.maxUserProperties = null;
    }

    private void addExperimentToAnalytics(AnalyticsConnector$ConditionalUserProperty analyticsConnector$ConditionalUserProperty) {
        this.analyticsConnector.setConditionalUserProperty(analyticsConnector$ConditionalUserProperty);
    }

    private void addExperiments(List object) {
        boolean bl2;
        List list = this.getAllExperimentsInAnalytics();
        ArrayDeque<Object> arrayDeque = new ArrayDeque<Object>(list);
        int n10 = this.getMaxUserPropertiesInAnalytics();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            String string2;
            int n11;
            Object object2 = (AbtExperimentInfo)object.next();
            while ((n11 = arrayDeque.size()) >= n10) {
                string2 = ((AnalyticsConnector$ConditionalUserProperty)arrayDeque.pollFirst()).name;
                this.removeExperimentFromAnalytics(string2);
            }
            string2 = this.originService;
            object2 = ((AbtExperimentInfo)object2).toConditionalUserProperty(string2);
            this.addExperimentToAnalytics((AnalyticsConnector$ConditionalUserProperty)object2);
            arrayDeque.offer(object2);
        }
    }

    private static List convertMapsToExperimentInfos(List object) {
        boolean bl2;
        ArrayList<AbtExperimentInfo> arrayList = new ArrayList<AbtExperimentInfo>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            AbtExperimentInfo abtExperimentInfo = AbtExperimentInfo.fromMap((Map)object.next());
            arrayList.add(abtExperimentInfo);
        }
        return arrayList;
    }

    private List getAllExperimentsInAnalytics() {
        AnalyticsConnector analyticsConnector = this.analyticsConnector;
        String string2 = this.originService;
        return analyticsConnector.getConditionalUserProperties(string2, "");
    }

    private ArrayList getExperimentsToAdd(List object, Set set) {
        boolean bl2;
        ArrayList<AbtExperimentInfo> arrayList = new ArrayList<AbtExperimentInfo>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            AbtExperimentInfo abtExperimentInfo = (AbtExperimentInfo)object.next();
            String string2 = abtExperimentInfo.getExperimentId();
            boolean bl3 = set.contains(string2);
            if (bl3) continue;
            arrayList.add(abtExperimentInfo);
        }
        return arrayList;
    }

    private ArrayList getExperimentsToRemove(List object, Set set) {
        boolean bl2;
        ArrayList<AnalyticsConnector$ConditionalUserProperty> arrayList = new ArrayList<AnalyticsConnector$ConditionalUserProperty>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            AnalyticsConnector$ConditionalUserProperty analyticsConnector$ConditionalUserProperty = (AnalyticsConnector$ConditionalUserProperty)object.next();
            String string2 = analyticsConnector$ConditionalUserProperty.name;
            boolean bl3 = set.contains(string2);
            if (bl3) continue;
            arrayList.add(analyticsConnector$ConditionalUserProperty);
        }
        return arrayList;
    }

    private int getMaxUserPropertiesInAnalytics() {
        Object object = this.maxUserProperties;
        if (object == null) {
            object = this.analyticsConnector;
            String string2 = this.originService;
            int n10 = object.getMaxUserProperties(string2);
            this.maxUserProperties = object = Integer.valueOf(n10);
        }
        return this.maxUserProperties;
    }

    private void removeExperimentFromAnalytics(String string2) {
        this.analyticsConnector.clearConditionalUserProperty(string2, null, null);
    }

    private void removeExperiments(Collection object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            String string2 = ((AnalyticsConnector$ConditionalUserProperty)object.next()).name;
            this.removeExperimentFromAnalytics(string2);
        }
    }

    private void replaceAllExperimentsWith(List list) {
        boolean bl2;
        HashSet<String> hashSet;
        boolean bl3;
        boolean bl4 = list.isEmpty();
        if (bl4) {
            this.removeAllExperiments();
            return;
        }
        AbstractCollection abstractCollection = new AbstractCollection();
        Object object = list.iterator();
        while (bl3 = object.hasNext()) {
            hashSet = ((AbtExperimentInfo)object.next()).getExperimentId();
            abstractCollection.add(hashSet);
        }
        object = this.getAllExperimentsInAnalytics();
        hashSet = new HashSet<String>();
        Iterator iterator2 = object.iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2 = ((AnalyticsConnector$ConditionalUserProperty)iterator2.next()).name;
            hashSet.add(string2);
        }
        abstractCollection = this.getExperimentsToRemove((List)object, (Set)((Object)abstractCollection));
        this.removeExperiments(abstractCollection);
        list = this.getExperimentsToAdd(list, hashSet);
        this.addExperiments(list);
    }

    private void throwAbtExceptionIfAnalyticsIsNull() {
        Object object = this.analyticsConnector;
        if (object != null) {
            return;
        }
        object = new AbtException("The Analytics SDK is not available. Please check that the Analytics SDK is included in your app dependencies.");
        throw object;
    }

    public List getAllExperiments() {
        boolean bl2;
        this.throwAbtExceptionIfAnalyticsIsNull();
        Object object = this.getAllExperimentsInAnalytics();
        ArrayList<AbtExperimentInfo> arrayList = new ArrayList<AbtExperimentInfo>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            AbtExperimentInfo abtExperimentInfo = AbtExperimentInfo.fromConditionalUserProperty((AnalyticsConnector$ConditionalUserProperty)object.next());
            arrayList.add(abtExperimentInfo);
        }
        return arrayList;
    }

    public void removeAllExperiments() {
        this.throwAbtExceptionIfAnalyticsIsNull();
        List list = this.getAllExperimentsInAnalytics();
        this.removeExperiments(list);
    }

    public void replaceAllExperiments(List object) {
        this.throwAbtExceptionIfAnalyticsIsNull();
        if (object != null) {
            object = FirebaseABTesting.convertMapsToExperimentInfos((List)object);
            this.replaceAllExperimentsWith((List)object);
            return;
        }
        object = new IllegalArgumentException("The replacementExperiments list is null.");
        throw object;
    }

    public void reportActiveExperiment(AbtExperimentInfo object) {
        this.throwAbtExceptionIfAnalyticsIsNull();
        AbtExperimentInfo.validateAbtExperimentInfo((AbtExperimentInfo)object);
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = ((AbtExperimentInfo)object).toStringMap();
        object.remove("triggerEvent");
        object = AbtExperimentInfo.fromMap((Map)object);
        arrayList.add(object);
        this.addExperiments(arrayList);
    }

    public void validateRunningExperiments(List object) {
        boolean bl2;
        this.throwAbtExceptionIfAnalyticsIsNull();
        HashSet<String> hashSet = new HashSet<String>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            String string2 = ((AbtExperimentInfo)object.next()).getExperimentId();
            hashSet.add(string2);
        }
        object = this.getAllExperimentsInAnalytics();
        object = this.getExperimentsToRemove((List)object, hashSet);
        this.removeExperiments((Collection)object);
    }
}

