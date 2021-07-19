/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;
import com.google.common.util.concurrent.ServiceManager;
import com.google.common.util.concurrent.ServiceManager$NoOpService;
import com.google.common.util.concurrent.ServiceManager$ServiceManagerState;
import java.lang.ref.WeakReference;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ServiceManager$ServiceListener
extends Service$Listener {
    public final Service service;
    public final WeakReference state;

    public ServiceManager$ServiceListener(Service service, WeakReference weakReference) {
        this.service = service;
        this.state = weakReference;
    }

    public void failed(Service$State service$State, Throwable object) {
        ServiceManager$ServiceManagerState serviceManager$ServiceManagerState = (ServiceManager$ServiceManagerState)this.state.get();
        if (serviceManager$ServiceManagerState != null) {
            Object object2 = this.service;
            boolean bl2 = object2 instanceof ServiceManager$NoOpService ^ true;
            if (bl2) {
                object2 = ServiceManager.access$200();
                Level level = Level.SEVERE;
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Service ");
                Object object3 = this.service;
                charSequence.append(object3);
                charSequence.append(" has failed in the ");
                charSequence.append((Object)service$State);
                object3 = " state.";
                charSequence.append((String)object3);
                charSequence = charSequence.toString();
                ((Logger)object2).log(level, (String)charSequence, (Throwable)object);
            }
            object = this.service;
            object2 = Service$State.FAILED;
            serviceManager$ServiceManagerState.transitionService((Service)object, service$State, (Service$State)((Object)object2));
        }
    }

    public void running() {
        ServiceManager$ServiceManagerState serviceManager$ServiceManagerState = (ServiceManager$ServiceManagerState)this.state.get();
        if (serviceManager$ServiceManagerState != null) {
            Service service = this.service;
            Service$State service$State = Service$State.STARTING;
            Service$State service$State2 = Service$State.RUNNING;
            serviceManager$ServiceManagerState.transitionService(service, service$State, service$State2);
        }
    }

    public void starting() {
        Object object = (ServiceManager$ServiceManagerState)this.state.get();
        if (object != null) {
            Object object2 = this.service;
            Object object3 = Service$State.NEW;
            Object object4 = Service$State.STARTING;
            ((ServiceManager$ServiceManagerState)object).transitionService((Service)object2, (Service$State)((Object)object3), (Service$State)((Object)object4));
            object = this.service;
            boolean bl2 = object instanceof ServiceManager$NoOpService;
            if (!bl2) {
                object = ServiceManager.access$200();
                object2 = Level.FINE;
                object3 = this.service;
                object4 = "Starting {0}.";
                ((Logger)object).log((Level)object2, (String)object4, object3);
            }
        }
    }

    public void stopping(Service$State service$State) {
        ServiceManager$ServiceManagerState serviceManager$ServiceManagerState = (ServiceManager$ServiceManagerState)this.state.get();
        if (serviceManager$ServiceManagerState != null) {
            Service service = this.service;
            Service$State service$State2 = Service$State.STOPPING;
            serviceManager$ServiceManagerState.transitionService(service, service$State, service$State2);
        }
    }

    public void terminated(Service$State service$State) {
        ServiceManager$ServiceManagerState serviceManager$ServiceManagerState = (ServiceManager$ServiceManagerState)this.state.get();
        if (serviceManager$ServiceManagerState != null) {
            Object object;
            Object object2 = this.service;
            boolean bl2 = object2 instanceof ServiceManager$NoOpService;
            if (!bl2) {
                object2 = ServiceManager.access$200();
                object = Level.FINE;
                int n10 = 2;
                Object[] objectArray = new Object[n10];
                Service service = this.service;
                objectArray[0] = service;
                int n11 = 1;
                objectArray[n11] = service$State;
                String string2 = "Service {0} has terminated. Previous state was: {1}";
                ((Logger)object2).log((Level)object, string2, objectArray);
            }
            object2 = this.service;
            object = Service$State.TERMINATED;
            serviceManager$ServiceManagerState.transitionService((Service)object2, service$State, (Service$State)((Object)object));
        }
    }
}

