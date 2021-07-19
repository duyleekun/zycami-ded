/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package cn.leancloud.im;

import android.content.Context;
import cn.leancloud.AVLogger;
import cn.leancloud.im.AVIMEventHandler;
import cn.leancloud.im.AVIMOptions;
import cn.leancloud.im.AndroidDatabaseDelegateFactory;
import cn.leancloud.im.AndroidFileMetaAccessor;
import cn.leancloud.im.AndroidInitializer$1;
import cn.leancloud.im.AndroidInitializer$2;
import cn.leancloud.im.AndroidInitializer$AndroidSystemReporter;
import cn.leancloud.im.AndroidOperationTube;
import cn.leancloud.im.DatabaseDelegateFactory;
import cn.leancloud.im.FileMetaAccessor;
import cn.leancloud.im.InternalConfiguration;
import cn.leancloud.im.OperationTube;
import cn.leancloud.im.SystemReporter;
import cn.leancloud.internal.ThreadModel$MainThreadChecker;
import cn.leancloud.internal.ThreadModel$ThreadShuttle;
import cn.leancloud.livequery.AVLiveQueryEventHandler;
import cn.leancloud.push.AVNotificationManager;
import cn.leancloud.push.AVPushMessageListener;
import cn.leancloud.push.AndroidNotificationManager;
import cn.leancloud.utils.LogUtil;

public class AndroidInitializer {
    private static AVLogger LOGGER = LogUtil.getLogger(AndroidInitializer.class);

    private static void init() {
        Object object = new AndroidInitializer$1();
        Object object2 = new AndroidInitializer$2();
        LOGGER.i("[LeanCloud] initialize mainThreadChecker and threadShuttle within AVIMEventHandler.");
        AVIMEventHandler.setMainThreadChecker((ThreadModel$MainThreadChecker)object, (ThreadModel$ThreadShuttle)object2);
        LOGGER.i("[LeanCloud] initialize mainThreadChecker and threadShuttle within AVLiveQueryEventHandler.");
        AVLiveQueryEventHandler.setMainThreadChecker((ThreadModel$MainThreadChecker)object, (ThreadModel$ThreadShuttle)object2);
        object = AVPushMessageListener.getInstance();
        object2 = AndroidNotificationManager.getInstance();
        ((AVPushMessageListener)object).setNotificationManager((AVNotificationManager)object2);
        LOGGER.i("[LeanCloud] initialize Android System Reporter.");
        object = AVIMOptions.getGlobalOptions();
        object2 = new AndroidInitializer$AndroidSystemReporter();
        ((AVIMOptions)object).setSystemReporter((SystemReporter)object2);
    }

    public static void init(Context context) {
        Object object = InternalConfiguration.getDatabaseDelegateFactory();
        if (object != null) {
            LOGGER.i("[LeanCloud] re-initialize InternalConfiguration.");
            return;
        }
        AndroidInitializer.init();
        LOGGER.i("[LeanCloud] initialize InternalConfiguration within AVIMEventHandler.");
        AVIMOptions.getGlobalOptions().setMessageQueryCacheEnabled(true);
        object = new AndroidFileMetaAccessor();
        InternalConfiguration.setFileMetaAccessor((FileMetaAccessor)object);
        object = new AndroidOperationTube();
        InternalConfiguration.setOperationTube((OperationTube)object);
        object = new AndroidDatabaseDelegateFactory(context);
        InternalConfiguration.setDatabaseDelegateFactory((DatabaseDelegateFactory)object);
    }
}

