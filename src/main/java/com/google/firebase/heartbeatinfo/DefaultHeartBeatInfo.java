/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.firebase.heartbeatinfo;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component$Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Lazy;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo$$Lambda$1;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo$$Lambda$2;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo$$Lambda$3;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo$$Lambda$4;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo$$Lambda$5;
import com.google.firebase.heartbeatinfo.HeartBeatConsumer;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.heartbeatinfo.HeartBeatInfo$HeartBeat;
import com.google.firebase.heartbeatinfo.HeartBeatInfoStorage;
import com.google.firebase.heartbeatinfo.HeartBeatResult;
import com.google.firebase.heartbeatinfo.SdkHeartBeatResult;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class DefaultHeartBeatInfo
implements HeartBeatInfo {
    private static final ThreadFactory THREAD_FACTORY = DefaultHeartBeatInfo$$Lambda$5.lambdaFactory$();
    private final Executor backgroundExecutor;
    private final Set consumers;
    private Provider storageProvider;

    private DefaultHeartBeatInfo(Context object, Set set) {
        object = DefaultHeartBeatInfo$$Lambda$1.lambdaFactory$(object);
        Lazy lazy = new Lazy((Provider)object);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
        ThreadFactory threadFactory = THREAD_FACTORY;
        super(0, 1, (long)30, timeUnit, linkedBlockingQueue, threadFactory);
        this(lazy, set, (Executor)object);
    }

    public DefaultHeartBeatInfo(Provider provider, Set set, Executor executor) {
        this.storageProvider = provider;
        this.consumers = set;
        this.backgroundExecutor = executor;
    }

    public static Component component() {
        Component$Builder component$Builder = Component.builder(HeartBeatInfo.class);
        Object object = Dependency.required(Context.class);
        component$Builder = component$Builder.add((Dependency)object);
        object = Dependency.setOf(HeartBeatConsumer.class);
        component$Builder = component$Builder.add((Dependency)object);
        object = DefaultHeartBeatInfo$$Lambda$4.lambdaFactory$();
        return component$Builder.factory((ComponentFactory)object).build();
    }

    public static /* synthetic */ HeartBeatInfo lambda$component$4(ComponentContainer object) {
        Context context = (Context)object.get(Context.class);
        object = object.setOf(HeartBeatConsumer.class);
        DefaultHeartBeatInfo defaultHeartBeatInfo = new DefaultHeartBeatInfo(context, (Set)object);
        return defaultHeartBeatInfo;
    }

    public static /* synthetic */ List lambda$getAndClearStoredHeartBeatInfo$2(DefaultHeartBeatInfo object) {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = (HeartBeatInfoStorage)((DefaultHeartBeatInfo)object).storageProvider.get();
        Object object2 = 1;
        Object object3 = ((HeartBeatInfoStorage)object).getStoredHeartBeats((boolean)object2);
        long l10 = ((HeartBeatInfoStorage)object).getLastGlobalHeartBeat();
        object3 = object3.iterator();
        while (bl2 = object3.hasNext()) {
            Object object4 = (SdkHeartBeatResult)object3.next();
            long l11 = ((SdkHeartBeatResult)object4).getMillis();
            boolean bl3 = HeartBeatInfoStorage.isSameDateUtc(l10, l11);
            HeartBeatInfo$HeartBeat heartBeatInfo$HeartBeat = bl3 ? HeartBeatInfo$HeartBeat.COMBINED : HeartBeatInfo$HeartBeat.SDK;
            if (bl3) {
                l10 = ((SdkHeartBeatResult)object4).getMillis();
            }
            String string2 = ((SdkHeartBeatResult)object4).getSdkName();
            long l12 = ((SdkHeartBeatResult)object4).getMillis();
            object4 = HeartBeatResult.create(string2, l12, heartBeatInfo$HeartBeat);
            arrayList.add(object4);
        }
        long l13 = 0L;
        long l14 = l10 - l13;
        object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object2 > 0) {
            ((HeartBeatInfoStorage)object).updateGlobalHeartBeat(l10);
        }
        return arrayList;
    }

    public static /* synthetic */ HeartBeatInfoStorage lambda$new$1(Context context) {
        return HeartBeatInfoStorage.getInstance(context);
    }

    public static /* synthetic */ Thread lambda$static$0(Runnable runnable) {
        Thread thread = new Thread(runnable, "heartbeat-information-executor");
        return thread;
    }

    public static /* synthetic */ Void lambda$storeHeartBeatInfo$3(DefaultHeartBeatInfo object, String string2) {
        long l10 = System.currentTimeMillis();
        HeartBeatInfoStorage heartBeatInfoStorage = (HeartBeatInfoStorage)((DefaultHeartBeatInfo)object).storageProvider.get();
        boolean bl2 = heartBeatInfoStorage.shouldSendSdkHeartBeat(string2, l10);
        if (bl2) {
            object = (HeartBeatInfoStorage)((DefaultHeartBeatInfo)object).storageProvider.get();
            ((HeartBeatInfoStorage)object).storeHeartBeatInformation(string2, l10);
        }
        return null;
    }

    public Task getAndClearStoredHeartBeatInfo() {
        Executor executor = this.backgroundExecutor;
        Callable callable = DefaultHeartBeatInfo$$Lambda$2.lambdaFactory$(this);
        return Tasks.call(executor, callable);
    }

    public HeartBeatInfo$HeartBeat getHeartBeatCode(String string2) {
        long l10 = System.currentTimeMillis();
        boolean bl2 = ((HeartBeatInfoStorage)this.storageProvider.get()).shouldSendSdkHeartBeat(string2, l10);
        HeartBeatInfoStorage heartBeatInfoStorage = (HeartBeatInfoStorage)this.storageProvider.get();
        boolean bl3 = heartBeatInfoStorage.shouldSendGlobalHeartBeat(l10);
        if (bl2 && bl3) {
            return HeartBeatInfo$HeartBeat.COMBINED;
        }
        if (bl3) {
            return HeartBeatInfo$HeartBeat.GLOBAL;
        }
        if (bl2) {
            return HeartBeatInfo$HeartBeat.SDK;
        }
        return HeartBeatInfo$HeartBeat.NONE;
    }

    public Task storeHeartBeatInfo(String object) {
        Object object2 = this.consumers;
        int n10 = object2.size();
        if (n10 <= 0) {
            return Tasks.forResult(null);
        }
        object2 = this.backgroundExecutor;
        object = DefaultHeartBeatInfo$$Lambda$3.lambdaFactory$(this, (String)object);
        return Tasks.call((Executor)object2, (Callable)object);
    }
}

