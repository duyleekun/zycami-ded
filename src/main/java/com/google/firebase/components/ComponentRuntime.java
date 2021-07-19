/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.firebase.components;

import android.util.Log;
import com.google.firebase.components.AbstractComponentContainer;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRuntime$$Lambda$1;
import com.google.firebase.components.ComponentRuntime$$Lambda$2;
import com.google.firebase.components.ComponentRuntime$$Lambda$3;
import com.google.firebase.components.ComponentRuntime$$Lambda$4;
import com.google.firebase.components.ComponentRuntime$$Lambda$5;
import com.google.firebase.components.ComponentRuntime$1;
import com.google.firebase.components.ComponentRuntime$Builder;
import com.google.firebase.components.CycleDetector;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.EventBus;
import com.google.firebase.components.InvalidRegistrarException;
import com.google.firebase.components.Lazy;
import com.google.firebase.components.LazySet;
import com.google.firebase.components.MissingDependencyException;
import com.google.firebase.components.OptionalProvider;
import com.google.firebase.components.Preconditions;
import com.google.firebase.components.RestrictedComponentContainer;
import com.google.firebase.dynamicloading.ComponentLoader;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public class ComponentRuntime
extends AbstractComponentContainer
implements ComponentLoader {
    private static final Provider EMPTY_PROVIDER = ComponentRuntime$$Lambda$5.lambdaFactory$();
    private final Map components;
    private final AtomicReference eagerComponentsInitializedWith;
    private final EventBus eventBus;
    private final Map lazyInstanceMap;
    private final Map lazySetMap;
    private final List unprocessedRegistrarProviders;

    private ComponentRuntime(Executor arrayList, Iterable iterable, Collection object) {
        boolean bl2;
        Class<Publisher> clazz;
        Class<Subscriber> clazz2;
        Object object2 = new HashMap();
        this.components = object2;
        object2 = new HashMap();
        this.lazyInstanceMap = object2;
        object2 = new HashMap();
        this.lazySetMap = object2;
        this.eagerComponentsInitializedWith = object2;
        this.eventBus = object2 = new EventBus((Executor)((Object)arrayList));
        arrayList = new ArrayList<Object>();
        int n10 = 2;
        Class[] classArray = new Class[n10];
        classArray[0] = clazz2 = Subscriber.class;
        int n11 = 1;
        classArray[n11] = clazz = Publisher.class;
        object2 = Component.of(object2, EventBus.class, classArray);
        arrayList.add(object2);
        Class[] classArray2 = new Class[]{};
        object2 = Component.of(this, ComponentLoader.class, classArray2);
        arrayList.add(object2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Component)object.next();
            if (object2 == null) continue;
            arrayList.add(object2);
        }
        iterable = ComponentRuntime.iterableToList(iterable);
        this.unprocessedRegistrarProviders = iterable;
        this.discoverComponents(arrayList);
    }

    public /* synthetic */ ComponentRuntime(Executor executor, Iterable iterable, Collection collection, ComponentRuntime$1 componentRuntime$1) {
        this(executor, iterable, collection);
    }

    public ComponentRuntime(Executor executor, Iterable iterable, Component ... object) {
        iterable = ComponentRuntime.toProviders(iterable);
        object = Arrays.asList(object);
        this(executor, iterable, (Collection)object);
    }

    public static ComponentRuntime$Builder builder(Executor executor) {
        ComponentRuntime$Builder componentRuntime$Builder = new ComponentRuntime$Builder(executor);
        return componentRuntime$Builder;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void discoverComponents(List object) {
        Object object2 = new ArrayList();
        synchronized (this) {
            Object object3;
            Object object4;
            Object object5;
            boolean bl2;
            Object object6 = this.unprocessedRegistrarProviders;
            object6 = object6.iterator();
            while (bl2 = object6.hasNext()) {
                object5 = object6.next();
                object5 = (Provider)object5;
                try {
                    object5 = object5.get();
                    if ((object5 = (ComponentRegistrar)object5) == null) continue;
                    object5 = object5.getComponents();
                    object.addAll(object5);
                    object6.remove();
                }
                catch (InvalidRegistrarException invalidRegistrarException) {
                    object6.remove();
                    object4 = "ComponentDiscovery";
                    object3 = "Invalid component registrar.";
                    Log.w((String)object4, (String)object3, (Throwable)invalidRegistrarException);
                }
            }
            object6 = this.components;
            boolean bl3 = object6.isEmpty();
            if (bl3) {
                CycleDetector.detect((List)object);
            } else {
                object5 = this.components;
                object5 = object5.keySet();
                object6 = new Object(object5);
                ((ArrayList)object6).addAll(object);
                CycleDetector.detect(object6);
            }
            object6 = object.iterator();
            while (bl2 = object6.hasNext()) {
                object5 = object6.next();
                object5 = (Component)object5;
                object3 = ComponentRuntime$$Lambda$1.lambdaFactory$(this, object5);
                object4 = new Lazy((Provider)object3);
                object3 = this.components;
                object3.put(object5, object4);
            }
            object = this.processInstanceComponents((List)object);
            object2.addAll(object);
            object = this.processSetComponents();
            object2.addAll(object);
            this.processDependencies();
        }
        object = object2.iterator();
        while (true) {
            boolean bl4;
            if (!(bl4 = object.hasNext())) {
                this.maybeInitializeEagerComponents();
                return;
            }
            object2 = (Runnable)object.next();
            object2.run();
        }
    }

    private void doInitializeEagerComponents(Map object, boolean bl2) {
        boolean bl3;
        object = object.entrySet().iterator();
        while (bl3 = object.hasNext()) {
            boolean bl4;
            Object object2 = (Map.Entry)object.next();
            Component component = (Component)object2.getKey();
            object2 = (Provider)object2.getValue();
            boolean bl5 = component.isAlwaysEager();
            if (!bl5 && (!(bl4 = component.isEagerInDefaultApp()) || !bl2)) continue;
            object2.get();
        }
        this.eventBus.enablePublishingAndFlushPending();
    }

    private static List iterableToList(Iterable object) {
        boolean bl2;
        ArrayList arrayList = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            arrayList.add(e10);
        }
        return arrayList;
    }

    public static /* synthetic */ Object lambda$discoverComponents$0(ComponentRuntime componentRuntime, Component component) {
        ComponentFactory componentFactory = component.getFactory();
        RestrictedComponentContainer restrictedComponentContainer = new RestrictedComponentContainer(component, componentRuntime);
        return componentFactory.create(restrictedComponentContainer);
    }

    public static /* synthetic */ void lambda$processInstanceComponents$2(OptionalProvider optionalProvider, Provider provider) {
        optionalProvider.set(provider);
    }

    public static /* synthetic */ void lambda$processSetComponents$3(LazySet lazySet, Provider provider) {
        lazySet.add(provider);
    }

    public static /* synthetic */ ComponentRegistrar lambda$toProviders$1(ComponentRegistrar componentRegistrar) {
        return componentRegistrar;
    }

    private void maybeInitializeEagerComponents() {
        Boolean bl2 = (Boolean)this.eagerComponentsInitializedWith.get();
        if (bl2 != null) {
            Map map = this.components;
            boolean bl3 = bl2;
            this.doInitializeEagerComponents(map, bl3);
        }
    }

    private void processDependencies() {
        boolean bl2;
        Object object = this.components.keySet().iterator();
        while (bl2 = object.hasNext()) {
            boolean bl3;
            Object object2 = (Component)object.next();
            Object[] objectArray = ((Component)object2).getDependencies().iterator();
            while (bl3 = objectArray.hasNext()) {
                Object object3;
                Map map;
                Object object4 = (Dependency)objectArray.next();
                boolean bl4 = ((Dependency)object4).isSet();
                if (bl4 && !(bl4 = (map = this.lazySetMap).containsKey(object3 = ((Dependency)object4).getInterface()))) {
                    map = this.lazySetMap;
                    object4 = ((Dependency)object4).getInterface();
                    object3 = LazySet.fromCollection(Collections.emptySet());
                    map.put(object4, object3);
                    continue;
                }
                map = this.lazyInstanceMap;
                object3 = ((Dependency)object4).getInterface();
                bl4 = map.containsKey(object3);
                if (bl4) continue;
                bl4 = ((Dependency)object4).isRequired();
                if (!bl4) {
                    bl4 = ((Dependency)object4).isSet();
                    if (bl4) continue;
                    map = this.lazyInstanceMap;
                    object4 = ((Dependency)object4).getInterface();
                    object3 = OptionalProvider.empty();
                    map.put(object4, object3);
                    continue;
                }
                objectArray = new Object[]{object2, object4 = ((Dependency)object4).getInterface()};
                object2 = String.format("Unsatisfied dependency for component %s: %s", objectArray);
                object = new MissingDependencyException((String)object2);
                throw object;
            }
        }
    }

    private List processInstanceComponents(List object) {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            boolean bl3;
            Object object2 = (Component)object.next();
            boolean bl4 = ((Component)object2).isValue();
            if (!bl4) continue;
            Provider provider = (Provider)this.components.get(object2);
            object2 = ((Component)object2).getProvidedInterfaces().iterator();
            while (bl3 = object2.hasNext()) {
                Map map = this.lazyInstanceMap;
                Object object3 = (Class)object2.next();
                boolean bl5 = map.containsKey(object3);
                if (!bl5) {
                    map = this.lazyInstanceMap;
                    map.put(object3, provider);
                    continue;
                }
                map = this.lazyInstanceMap;
                object3 = ComponentRuntime$$Lambda$3.lambdaFactory$((OptionalProvider)((Provider)map.get(object3)), provider);
                arrayList.add(object3);
            }
        }
        return arrayList;
    }

    private List processSetComponents() {
        boolean bl2;
        Object object;
        Object object2;
        boolean bl3;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object3 = new HashMap();
        Object object4 = this.components.entrySet().iterator();
        while (bl3 = object4.hasNext()) {
            object2 = object4.next();
            object = (Component)object2.getKey();
            boolean bl4 = ((Component)object).isValue();
            if (bl4) continue;
            object2 = (Provider)object2.getValue();
            object = ((Component)object).getProvidedInterfaces().iterator();
            while (bl4 = object.hasNext()) {
                Object object5 = (Class)object.next();
                boolean bl5 = object3.containsKey(object5);
                if (!bl5) {
                    HashSet hashSet = new HashSet();
                    object3.put(object5, hashSet);
                }
                object5 = (Set)object3.get(object5);
                object5.add(object2);
            }
        }
        object3 = object3.entrySet().iterator();
        while (bl2 = object3.hasNext()) {
            boolean bl6;
            object2 = this.lazySetMap;
            object4 = (Map.Entry)object3.next();
            object = object4.getKey();
            bl3 = object2.containsKey(object);
            if (!bl3) {
                object2 = this.lazySetMap;
                object = (Class)object4.getKey();
                object4 = LazySet.fromCollection((Collection)object4.getValue());
                object2.put(object, object4);
                continue;
            }
            object2 = this.lazySetMap;
            object = object4.getKey();
            object2 = (LazySet)object2.get(object);
            object4 = ((Set)object4.getValue()).iterator();
            while (bl6 = object4.hasNext()) {
                object = (Provider)object4.next();
                object = ComponentRuntime$$Lambda$4.lambdaFactory$((LazySet)object2, (Provider)object);
                arrayList.add(object);
            }
        }
        return arrayList;
    }

    private static Iterable toProviders(Iterable object) {
        boolean bl2;
        ArrayList<Provider> arrayList = new ArrayList<Provider>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Provider provider = ComponentRuntime$$Lambda$2.lambdaFactory$((ComponentRegistrar)object.next());
            arrayList.add(provider);
        }
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void discoverComponents() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = this.unprocessedRegistrarProviders;
            boolean bl2 = arrayList.isEmpty();
            if (bl2) {
                return;
            }
        }
        arrayList = new ArrayList();
        this.discoverComponents(arrayList);
    }

    public Deferred getDeferred(Class object) {
        if ((object = this.getProvider((Class)object)) == null) {
            return OptionalProvider.empty();
        }
        boolean bl2 = object instanceof OptionalProvider;
        if (bl2) {
            return (OptionalProvider)object;
        }
        return OptionalProvider.of((Provider)object);
    }

    public Provider getProvider(Class object) {
        synchronized (this) {
            Object object2 = "Null interface requested.";
            Preconditions.checkNotNull(object, (String)object2);
            object2 = this.lazyInstanceMap;
            object = object2.get(object);
            object = (Provider)object;
            return object;
        }
    }

    public void initializeAllComponentsForTests() {
        boolean bl2;
        Iterator iterator2 = this.components.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            Provider provider = (Provider)iterator2.next();
            provider.get();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void initializeEagerComponents(boolean bl2) {
        Serializable serializable = this.eagerComponentsInitializedWith;
        Object object = bl2;
        boolean bl3 = serializable.compareAndSet(null, object);
        if (!bl3) {
            return;
        }
        synchronized (this) {
            object = this.components;
            serializable = new HashMap(object);
        }
        this.doInitializeEagerComponents((Map)((Object)serializable), bl2);
    }

    public Provider setOfProvider(Class object) {
        synchronized (this) {
            block7: {
                Map map = this.lazySetMap;
                object = map.get(object);
                object = (LazySet)object;
                if (object == null) break block7;
                return object;
            }
            object = EMPTY_PROVIDER;
            return object;
        }
    }
}

