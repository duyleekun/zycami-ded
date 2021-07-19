/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.DependencyException;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import java.util.Set;

public class RestrictedComponentContainer$RestrictedPublisher
implements Publisher {
    private final Set allowedPublishedEvents;
    private final Publisher delegate;

    public RestrictedComponentContainer$RestrictedPublisher(Set set, Publisher publisher) {
        this.allowedPublishedEvents = set;
        this.delegate = publisher;
    }

    public void publish(Event object) {
        Object object2 = this.allowedPublishedEvents;
        Object[] objectArray = ((Event)object).getType();
        boolean bl2 = object2.contains(objectArray);
        if (bl2) {
            this.delegate.publish((Event)object);
            return;
        }
        objectArray = new Object[]{object};
        object = String.format("Attempting to publish an undeclared event %s.", objectArray);
        object2 = new DependencyException((String)object);
        throw object2;
    }
}

