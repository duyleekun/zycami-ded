/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.DirectExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors$1;
import com.google.common.util.concurrent.MoreExecutors$2;
import com.google.common.util.concurrent.MoreExecutors$3;
import com.google.common.util.concurrent.MoreExecutors$4;
import com.google.common.util.concurrent.MoreExecutors$5;
import com.google.common.util.concurrent.MoreExecutors$Application;
import com.google.common.util.concurrent.MoreExecutors$DirectExecutorService;
import com.google.common.util.concurrent.MoreExecutors$ListeningDecorator;
import com.google.common.util.concurrent.MoreExecutors$ScheduledListeningDecorator;
import com.google.common.util.concurrent.SequentialExecutor;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class MoreExecutors {
    private MoreExecutors() {
    }

    public static /* synthetic */ void access$000(ThreadPoolExecutor threadPoolExecutor) {
        MoreExecutors.useDaemonThreadFactory(threadPoolExecutor);
    }

    public static void addDelayedShutdownHook(ExecutorService executorService, long l10, TimeUnit timeUnit) {
        MoreExecutors$Application moreExecutors$Application = new MoreExecutors$Application();
        moreExecutors$Application.addDelayedShutdownHook(executorService, l10, timeUnit);
    }

    public static Executor directExecutor() {
        return DirectExecutor.INSTANCE;
    }

    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor) {
        MoreExecutors$Application moreExecutors$Application = new MoreExecutors$Application();
        return moreExecutors$Application.getExitingExecutorService(threadPoolExecutor);
    }

    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor, long l10, TimeUnit timeUnit) {
        MoreExecutors$Application moreExecutors$Application = new MoreExecutors$Application();
        return moreExecutors$Application.getExitingExecutorService(threadPoolExecutor, l10, timeUnit);
    }

    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        MoreExecutors$Application moreExecutors$Application = new MoreExecutors$Application();
        return moreExecutors$Application.getExitingScheduledExecutorService(scheduledThreadPoolExecutor);
    }

    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long l10, TimeUnit timeUnit) {
        MoreExecutors$Application moreExecutors$Application = new MoreExecutors$Application();
        return moreExecutors$Application.getExitingScheduledExecutorService(scheduledThreadPoolExecutor, l10, timeUnit);
    }

    /*
     * Exception decompiling
     */
    public static Object invokeAnyImpl(ListeningExecutorService var0, Collection var1_1, boolean var2_2, long var3_3, TimeUnit var5_4) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [1 : 91->97)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean isAppEngineWithApiClasses() {
        Object object = System.getProperty("com.google.appengine.runtime.environment");
        boolean bl2 = false;
        if (object == null) {
            return false;
        }
        object = "com.google.appengine.api.utils.SystemProperty";
        try {
            Class.forName((String)object);
            object = "com.google.apphosting.api.ApiProxy";
        }
        catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException reflectiveOperationException) {
            return bl2;
        }
        object = Class.forName((String)object);
        String string2 = "getCurrentEnvironment";
        Object[] objectArray = new Class[]{};
        object = ((Class)object).getMethod(string2, (Class<?>[])objectArray);
        string2 = null;
        objectArray = new Object[]{};
        object = ((Method)object).invoke(null, objectArray);
        if (object == null) return bl2;
        return true;
    }

    public static ListeningExecutorService listeningDecorator(ExecutorService executorService) {
        boolean bl2 = executorService instanceof ListeningExecutorService;
        if (bl2) {
            executorService = (ListeningExecutorService)executorService;
        } else {
            MoreExecutors$ListeningDecorator moreExecutors$ListeningDecorator;
            bl2 = executorService instanceof ScheduledExecutorService;
            if (bl2) {
                executorService = (ScheduledExecutorService)executorService;
                moreExecutors$ListeningDecorator = new MoreExecutors$ScheduledListeningDecorator((ScheduledExecutorService)executorService);
            } else {
                moreExecutors$ListeningDecorator = new MoreExecutors$ListeningDecorator(executorService);
            }
            executorService = moreExecutors$ListeningDecorator;
        }
        return executorService;
    }

    public static ListeningScheduledExecutorService listeningDecorator(ScheduledExecutorService scheduledExecutorService) {
        boolean bl2 = scheduledExecutorService instanceof ListeningScheduledExecutorService;
        if (bl2) {
            scheduledExecutorService = (ListeningScheduledExecutorService)scheduledExecutorService;
        } else {
            MoreExecutors$ScheduledListeningDecorator moreExecutors$ScheduledListeningDecorator = new MoreExecutors$ScheduledListeningDecorator(scheduledExecutorService);
            scheduledExecutorService = moreExecutors$ScheduledListeningDecorator;
        }
        return scheduledExecutorService;
    }

    public static ListeningExecutorService newDirectExecutorService() {
        MoreExecutors$DirectExecutorService moreExecutors$DirectExecutorService = new MoreExecutors$DirectExecutorService(null);
        return moreExecutors$DirectExecutorService;
    }

    public static Executor newSequentialExecutor(Executor executor) {
        SequentialExecutor sequentialExecutor = new SequentialExecutor(executor);
        return sequentialExecutor;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Thread newThread(String string2, Runnable runnable) {
        Preconditions.checkNotNull(string2);
        Preconditions.checkNotNull(runnable);
        ThreadFactory threadFactory = MoreExecutors.platformThreadFactory();
        runnable = threadFactory.newThread(runnable);
        try {
            ((Thread)runnable).setName(string2);
            return runnable;
        }
        catch (SecurityException securityException) {
            return runnable;
        }
    }

    public static ThreadFactory platformThreadFactory() {
        String string2 = "Couldn't invoke ThreadManager.currentRequestThreadFactory";
        boolean bl2 = MoreExecutors.isAppEngineWithApiClasses();
        if (!bl2) {
            return Executors.defaultThreadFactory();
        }
        Object object = "com.google.appengine.api.ThreadManager";
        object = Class.forName((String)object);
        Object object2 = "currentRequestThreadFactory";
        Object[] objectArray = null;
        Class[] classArray = new Class[]{};
        object = ((Class)object).getMethod((String)object2, classArray);
        object2 = null;
        objectArray = new Object[]{};
        object = ((Method)object).invoke(null, objectArray);
        try {
            return (ThreadFactory)object;
        }
        catch (InvocationTargetException invocationTargetException) {
            throw Throwables.propagate(invocationTargetException.getCause());
        }
        catch (NoSuchMethodException noSuchMethodException) {
            object2 = new RuntimeException(string2, noSuchMethodException);
            throw object2;
        }
        catch (ClassNotFoundException classNotFoundException) {
            object2 = new RuntimeException(string2, classNotFoundException);
            throw object2;
        }
        catch (IllegalAccessException illegalAccessException) {
            object2 = new RuntimeException(string2, illegalAccessException);
            throw object2;
        }
    }

    public static Executor rejectionPropagatingExecutor(Executor executor, AbstractFuture abstractFuture) {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(abstractFuture);
        Executor executor2 = MoreExecutors.directExecutor();
        if (executor == executor2) {
            return executor;
        }
        executor2 = new MoreExecutors$5(executor, abstractFuture);
        return executor2;
    }

    public static Executor renamingDecorator(Executor executor, Supplier supplier) {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(supplier);
        MoreExecutors$2 moreExecutors$2 = new MoreExecutors$2(executor, supplier);
        return moreExecutors$2;
    }

    public static ExecutorService renamingDecorator(ExecutorService executorService, Supplier supplier) {
        Preconditions.checkNotNull(executorService);
        Preconditions.checkNotNull(supplier);
        MoreExecutors$3 moreExecutors$3 = new MoreExecutors$3(executorService, supplier);
        return moreExecutors$3;
    }

    public static ScheduledExecutorService renamingDecorator(ScheduledExecutorService scheduledExecutorService, Supplier supplier) {
        Preconditions.checkNotNull(scheduledExecutorService);
        Preconditions.checkNotNull(supplier);
        MoreExecutors$4 moreExecutors$4 = new MoreExecutors$4(scheduledExecutorService, supplier);
        return moreExecutors$4;
    }

    public static boolean shutdownAndAwaitTermination(ExecutorService executorService, long l10, TimeUnit timeUnit) {
        block5: {
            l10 = timeUnit.toNanos(l10);
            long l11 = 2;
            l10 /= l11;
            executorService.shutdown();
            timeUnit = TimeUnit.NANOSECONDS;
            boolean bl2 = executorService.awaitTermination(l10, timeUnit);
            if (bl2) break block5;
            executorService.shutdownNow();
            try {
                executorService.awaitTermination(l10, timeUnit);
            }
            catch (InterruptedException interruptedException) {
                Thread thread = Thread.currentThread();
                thread.interrupt();
                executorService.shutdownNow();
            }
        }
        return executorService.isTerminated();
    }

    private static ListenableFuture submitAndAddQueueListener(ListeningExecutorService object, Callable object2, BlockingQueue object3) {
        object = object.submit((Callable)object2);
        object2 = new MoreExecutors$1((BlockingQueue)object3, (ListenableFuture)object);
        object3 = MoreExecutors.directExecutor();
        object.addListener((Runnable)object2, (Executor)object3);
        return object;
    }

    private static void useDaemonThreadFactory(ThreadPoolExecutor threadPoolExecutor) {
        Object object = new ThreadFactoryBuilder();
        object = ((ThreadFactoryBuilder)object).setDaemon(true);
        ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
        object = ((ThreadFactoryBuilder)object).setThreadFactory(threadFactory).build();
        threadPoolExecutor.setThreadFactory((ThreadFactory)object);
    }
}

