/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient$$Lambda$1;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient$$Lambda$2;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient$$Lambda$3;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient$$Lambda$4;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient$AwaitListener;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigStorageClient;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ConfigCacheClient {
    private static final Executor DIRECT_EXECUTOR;
    public static final long DISK_READ_TIMEOUT_IN_SECONDS = 5L;
    private static final Map clientInstances;
    private Task cachedContainerTask;
    private final ExecutorService executorService;
    private final ConfigStorageClient storageClient;

    static {
        HashMap hashMap;
        clientInstances = hashMap = new HashMap();
        DIRECT_EXECUTOR = ConfigCacheClient$$Lambda$4.lambdaFactory$();
    }

    private ConfigCacheClient(ExecutorService executorService, ConfigStorageClient configStorageClient) {
        this.executorService = executorService;
        this.storageClient = configStorageClient;
        this.cachedContainerTask = null;
    }

    private static Object await(Task object, long l10, TimeUnit timeUnit) {
        ConfigCacheClient$AwaitListener configCacheClient$AwaitListener = new ConfigCacheClient$AwaitListener(null);
        Executor executor = DIRECT_EXECUTOR;
        ((Task)object).addOnSuccessListener(executor, (OnSuccessListener)configCacheClient$AwaitListener);
        ((Task)object).addOnFailureListener(executor, (OnFailureListener)configCacheClient$AwaitListener);
        ((Task)object).addOnCanceledListener(executor, (OnCanceledListener)configCacheClient$AwaitListener);
        boolean bl2 = configCacheClient$AwaitListener.await(l10, timeUnit);
        if (bl2) {
            bl2 = ((Task)object).isSuccessful();
            if (bl2) {
                return ((Task)object).getResult();
            }
            object = ((Task)object).getException();
            ExecutionException executionException = new ExecutionException((Throwable)object);
            throw executionException;
        }
        object = new TimeoutException("Task await timed out.");
        throw object;
    }

    public static void clearInstancesForTest() {
        Class<ConfigCacheClient> clazz = ConfigCacheClient.class;
        synchronized (clazz) {
            Map map = clientInstances;
            map.clear();
            return;
        }
    }

    public static ConfigCacheClient getInstance(ExecutorService object, ConfigStorageClient configStorageClient) {
        Class<ConfigCacheClient> clazz = ConfigCacheClient.class;
        synchronized (clazz) {
            String string2 = configStorageClient.getFileName();
            Map map = clientInstances;
            boolean bl2 = map.containsKey(string2);
            if (!bl2) {
                ConfigCacheClient configCacheClient = new ConfigCacheClient((ExecutorService)object, configStorageClient);
                map.put(string2, configCacheClient);
            }
            object = map.get(string2);
            object = (ConfigCacheClient)object;
            return object;
        }
    }

    public static /* synthetic */ Void lambda$put$0(ConfigCacheClient configCacheClient, ConfigContainer configContainer) {
        return configCacheClient.storageClient.write(configContainer);
    }

    public static /* synthetic */ Task lambda$put$1(ConfigCacheClient configCacheClient, boolean bl2, ConfigContainer configContainer, Void void_) {
        if (bl2) {
            configCacheClient.updateInMemoryConfigContainer(configContainer);
        }
        return Tasks.forResult(configContainer);
    }

    private void updateInMemoryConfigContainer(ConfigContainer object) {
        synchronized (this) {
            object = Tasks.forResult(object);
            this.cachedContainerTask = object;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clear() {
        synchronized (this) {
            Task task = null;
            this.cachedContainerTask = task = Tasks.forResult(null);
        }
        this.storageClient.clear();
    }

    public Task get() {
        synchronized (this) {
            boolean bl2;
            Object object = this.cachedContainerTask;
            if (object == null || (bl2 = ((Task)object).isComplete()) && !(bl2 = ((Task)(object = this.cachedContainerTask)).isSuccessful())) {
                object = this.executorService;
                Object object2 = this.storageClient;
                object2.getClass();
                object2 = ConfigCacheClient$$Lambda$3.lambdaFactory$((ConfigStorageClient)object2);
                this.cachedContainerTask = object = Tasks.call((Executor)object, (Callable)object2);
            }
            object = this.cachedContainerTask;
            return object;
        }
    }

    public ConfigContainer getBlocking() {
        return this.getBlocking(5);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ConfigContainer getBlocking(long l10) {
        void var5_9;
        Task task;
        synchronized (this) {
            boolean bl2;
            task = this.cachedContainerTask;
            if (task != null && (bl2 = task.isSuccessful())) {
                Object object = this.cachedContainerTask;
                object = ((Task)object).getResult();
                return (ConfigContainer)object;
            }
        }
        try {
            task = this.get();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Object object = ConfigCacheClient.await(task, l10, timeUnit);
            return (ConfigContainer)object;
        }
        catch (TimeoutException timeoutException) {
        }
        catch (ExecutionException executionException) {
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        Log.d((String)"FirebaseRemoteConfig", (String)"Reading from storage file failed.", (Throwable)var5_9);
        return null;
    }

    public Task getCachedContainerTask() {
        synchronized (this) {
            Task task = this.cachedContainerTask;
            return task;
        }
    }

    public Task put(ConfigContainer configContainer) {
        return this.put(configContainer, true);
    }

    public Task put(ConfigContainer object, boolean bl2) {
        Object object2 = this.executorService;
        Object object3 = ConfigCacheClient$$Lambda$1.lambdaFactory$(this, (ConfigContainer)object);
        object2 = Tasks.call((Executor)object2, (Callable)object3);
        object3 = this.executorService;
        object = ConfigCacheClient$$Lambda$2.lambdaFactory$(this, bl2, (ConfigContainer)object);
        return ((Task)object2).onSuccessTask((Executor)object3, (SuccessContinuation)object);
    }
}

