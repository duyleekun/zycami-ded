/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.eventbus;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.common.eventbus.Subscriber;
import com.google.common.eventbus.SubscriberRegistry$1;
import com.google.common.eventbus.SubscriberRegistry$2;
import com.google.common.eventbus.SubscriberRegistry$MethodIdentifier;
import com.google.common.reflect.TypeToken;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

public final class SubscriberRegistry {
    private static final LoadingCache flattenHierarchyCache;
    private static final LoadingCache subscriberMethodsCache;
    private final EventBus bus;
    private final ConcurrentMap subscribers;

    static {
        CacheBuilder cacheBuilder = CacheBuilder.newBuilder().weakKeys();
        CacheLoader cacheLoader = new SubscriberRegistry$1();
        subscriberMethodsCache = cacheBuilder.build(cacheLoader);
        cacheBuilder = CacheBuilder.newBuilder().weakKeys();
        cacheLoader = new SubscriberRegistry$2();
        flattenHierarchyCache = cacheBuilder.build(cacheLoader);
    }

    public SubscriberRegistry(EventBus eventBus) {
        ConcurrentMap concurrentMap;
        this.subscribers = concurrentMap = Maps.newConcurrentMap();
        this.bus = eventBus = (EventBus)Preconditions.checkNotNull(eventBus);
    }

    public static /* synthetic */ ImmutableList access$000(Class clazz) {
        return SubscriberRegistry.getAnnotatedMethodsNotCached(clazz);
    }

    private Multimap findAllSubscribers(Object object) {
        boolean bl2;
        HashMultimap hashMultimap = HashMultimap.create();
        UnmodifiableIterator unmodifiableIterator = SubscriberRegistry.getAnnotatedMethods(object.getClass()).iterator();
        while (bl2 = unmodifiableIterator.hasNext()) {
            Object object2 = (Method)unmodifiableIterator.next();
            Class<?> clazz = ((Method)object2).getParameterTypes()[0];
            EventBus eventBus = this.bus;
            object2 = Subscriber.create(eventBus, object, (Method)object2);
            hashMultimap.put(clazz, object2);
        }
        return hashMultimap;
    }

    public static ImmutableSet flattenHierarchy(Class object) {
        LoadingCache loadingCache;
        try {
            loadingCache = flattenHierarchyCache;
        }
        catch (UncheckedExecutionException uncheckedExecutionException) {
            throw Throwables.propagate(uncheckedExecutionException.getCause());
        }
        object = loadingCache.getUnchecked(object);
        return (ImmutableSet)object;
    }

    private static ImmutableList getAnnotatedMethods(Class clazz) {
        return (ImmutableList)subscriberMethodsCache.getUnchecked(clazz);
    }

    private static ImmutableList getAnnotatedMethodsNotCached(Class iterator2) {
        boolean bl2;
        iterator2 = TypeToken.of((Class)((Object)iterator2)).getTypes().rawTypes();
        HashMap hashMap = Maps.newHashMap();
        iterator2 = iterator2.iterator();
        while (bl2 = iterator2.hasNext()) {
            for (Method method : ((Class)iterator2.next()).getDeclaredMethods()) {
                boolean bl3;
                Object object = Subscribe.class;
                int n10 = method.isAnnotationPresent((Class<? extends Annotation>)object);
                if (n10 == 0 || (n10 = method.isSynthetic()) != 0) continue;
                object = method.getParameterTypes();
                boolean bl4 = ((Class<?>[])object).length;
                if (bl4 != (bl3 = true)) {
                    bl3 = false;
                }
                n10 = ((Class<?>[])object).length;
                String string2 = "Method %s has @Subscribe annotation but has %s parameters.Subscriber methods must have exactly 1 parameter.";
                Preconditions.checkArgument(bl3, string2, (Object)method, n10);
                object = new SubscriberRegistry$MethodIdentifier(method);
                bl4 = hashMap.containsKey(object);
                if (bl4) continue;
                hashMap.put(object, method);
            }
        }
        return ImmutableList.copyOf(hashMap.values());
    }

    public Iterator getSubscribers(Object object) {
        boolean bl2;
        object = SubscriberRegistry.flattenHierarchy(object.getClass());
        int n10 = ((AbstractCollection)object).size();
        ArrayList arrayList = Lists.newArrayListWithCapacity(n10);
        object = ((ImmutableSet)object).iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (Class)object.next();
            ConcurrentMap concurrentMap = this.subscribers;
            if ((object2 = (CopyOnWriteArraySet)concurrentMap.get(object2)) == null) continue;
            object2 = ((CopyOnWriteArraySet)object2).iterator();
            arrayList.add(object2);
        }
        return Iterators.concat(arrayList.iterator());
    }

    public Set getSubscribersForTesting(Class clazz) {
        clazz = this.subscribers.get(clazz);
        ImmutableSet immutableSet = ImmutableSet.of();
        return (Set)MoreObjects.firstNonNull(clazz, immutableSet);
    }

    public void register(Object iterator2) {
        boolean bl2;
        iterator2 = this.findAllSubscribers(iterator2).asMap().entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = iterator2.next();
            Object object2 = (Class)object.getKey();
            object = (Collection)object.getValue();
            CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet)this.subscribers.get(object2);
            if (copyOnWriteArraySet == null) {
                copyOnWriteArraySet = new CopyOnWriteArraySet();
                ConcurrentMap concurrentMap = this.subscribers;
                copyOnWriteArraySet = object2 = MoreObjects.firstNonNull(concurrentMap.putIfAbsent(object2, copyOnWriteArraySet), copyOnWriteArraySet);
                copyOnWriteArraySet = (CopyOnWriteArraySet)object2;
            }
            copyOnWriteArraySet.addAll(object);
        }
    }

    public void unregister(Object object) {
        boolean bl2;
        Object object2 = this.findAllSubscribers(object).asMap().entrySet().iterator();
        while (bl2 = object2.hasNext()) {
            Object object3 = object2.next();
            Serializable serializable = (Class)object3.getKey();
            object3 = (Collection)object3.getValue();
            ConcurrentMap concurrentMap = this.subscribers;
            if ((serializable = (CopyOnWriteArraySet)concurrentMap.get(serializable)) != null && (bl2 = ((CopyOnWriteArraySet)serializable).removeAll((Collection<?>)object3))) continue;
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("missing event subscriber for an annotated method. Is ");
            ((StringBuilder)object3).append(object);
            ((StringBuilder)object3).append(" registered?");
            object = ((StringBuilder)object3).toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
    }
}

