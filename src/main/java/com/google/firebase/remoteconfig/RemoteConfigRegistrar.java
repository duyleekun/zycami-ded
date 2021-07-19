/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.firebase.remoteconfig;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.abt.component.AbtComponent;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component$Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.google.firebase.remoteconfig.RemoteConfigRegistrar$$Lambda$1;
import java.util.Arrays;
import java.util.List;

public class RemoteConfigRegistrar
implements ComponentRegistrar {
    public static /* synthetic */ RemoteConfigComponent lambda$getComponents$0(ComponentContainer object) {
        RemoteConfigComponent remoteConfigComponent;
        Object object2;
        Object object3 = object2 = object.get(Context.class);
        object3 = (Context)object2;
        Object object4 = object2 = object.get(FirebaseApp.class);
        object4 = (FirebaseApp)object2;
        Object object5 = object2 = object.get(FirebaseInstallationsApi.class);
        object5 = (FirebaseInstallationsApi)object2;
        FirebaseABTesting firebaseABTesting = ((AbtComponent)object.get(AbtComponent.class)).get("frc");
        Object object6 = object = object.get(AnalyticsConnector.class);
        object6 = (AnalyticsConnector)object;
        object2 = remoteConfigComponent;
        remoteConfigComponent = new RemoteConfigComponent((Context)object3, (FirebaseApp)object4, (FirebaseInstallationsApi)object5, firebaseABTesting, (AnalyticsConnector)object6);
        return remoteConfigComponent;
    }

    public List getComponents() {
        Component[] componentArray = new Component[2];
        Object object = Component.builder(RemoteConfigComponent.class);
        Object object2 = Dependency.required(Context.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = Dependency.required(FirebaseApp.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = Dependency.required(FirebaseInstallationsApi.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = Dependency.required(AbtComponent.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = Dependency.optional(AnalyticsConnector.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = RemoteConfigRegistrar$$Lambda$1.lambdaFactory$();
        componentArray[0] = object = ((Component$Builder)object).factory((ComponentFactory)object2).eagerInDefaultApp().build();
        componentArray[1] = object = LibraryVersionComponent.create("fire-rc", "20.0.2");
        return Arrays.asList(componentArray);
    }
}

