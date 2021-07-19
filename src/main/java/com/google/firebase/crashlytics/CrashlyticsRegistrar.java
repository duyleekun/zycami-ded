/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component$Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.crashlytics.CrashlyticsRegistrar$$Lambda$1;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

public class CrashlyticsRegistrar
implements ComponentRegistrar {
    public static /* synthetic */ FirebaseCrashlytics access$lambda$0(CrashlyticsRegistrar crashlyticsRegistrar, ComponentContainer componentContainer) {
        return crashlyticsRegistrar.buildCrashlytics(componentContainer);
    }

    private FirebaseCrashlytics buildCrashlytics(ComponentContainer object) {
        FirebaseApp firebaseApp = (FirebaseApp)object.get(FirebaseApp.class);
        CrashlyticsNativeComponent crashlyticsNativeComponent = (CrashlyticsNativeComponent)object.get(CrashlyticsNativeComponent.class);
        AnalyticsConnector analyticsConnector = (AnalyticsConnector)object.get(AnalyticsConnector.class);
        object = (FirebaseInstallationsApi)object.get(FirebaseInstallationsApi.class);
        return FirebaseCrashlytics.init(firebaseApp, (FirebaseInstallationsApi)object, crashlyticsNativeComponent, analyticsConnector);
    }

    public List getComponents() {
        Component[] componentArray = new Component[2];
        Object object = Component.builder(FirebaseCrashlytics.class);
        Object object2 = Dependency.required(FirebaseApp.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = Dependency.required(FirebaseInstallationsApi.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = Dependency.optional(AnalyticsConnector.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = Dependency.optional(CrashlyticsNativeComponent.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = CrashlyticsRegistrar$$Lambda$1.lambdaFactory$(this);
        componentArray[0] = object = ((Component$Builder)object).factory((ComponentFactory)object2).eagerInDefaultApp().build();
        componentArray[1] = object = LibraryVersionComponent.create("fire-cls", "17.4.0");
        return Arrays.asList(componentArray);
    }
}

