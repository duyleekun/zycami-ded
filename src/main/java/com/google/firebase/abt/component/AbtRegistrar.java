/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.firebase.abt.component;

import android.content.Context;
import com.google.firebase.abt.component.AbtComponent;
import com.google.firebase.abt.component.AbtRegistrar$$Lambda$1;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component$Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

public class AbtRegistrar
implements ComponentRegistrar {
    public static /* synthetic */ AbtComponent lambda$getComponents$0(ComponentContainer object) {
        Context context = (Context)object.get(Context.class);
        object = (AnalyticsConnector)object.get(AnalyticsConnector.class);
        AbtComponent abtComponent = new AbtComponent(context, (AnalyticsConnector)object);
        return abtComponent;
    }

    public List getComponents() {
        Component[] componentArray = new Component[2];
        Object object = Component.builder(AbtComponent.class);
        Object object2 = Dependency.required(Context.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = Dependency.optional(AnalyticsConnector.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = AbtRegistrar$$Lambda$1.lambdaFactory$();
        componentArray[0] = object = ((Component$Builder)object).factory((ComponentFactory)object2).build();
        componentArray[1] = object = LibraryVersionComponent.create("fire-abt", "20.0.0");
        return Arrays.asList(componentArray);
    }
}

