/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.ResolveInfo
 *  android.os.DeadObjectException
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.IBinder
 *  android.os.Looper
 *  android.os.Message
 *  android.os.RemoteException
 *  android.util.Log
 */
package androidx.core.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;
import android.support.v4.app.INotificationSideChannel$Stub;
import android.util.Log;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.NotificationManagerCompat$ServiceConnectedEvent;
import androidx.core.app.NotificationManagerCompat$SideChannelManager$ListenerRecord;
import androidx.core.app.NotificationManagerCompat$Task;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class NotificationManagerCompat$SideChannelManager
implements Handler.Callback,
ServiceConnection {
    private static final int MSG_QUEUE_TASK = 0;
    private static final int MSG_RETRY_LISTENER_QUEUE = 3;
    private static final int MSG_SERVICE_CONNECTED = 1;
    private static final int MSG_SERVICE_DISCONNECTED = 2;
    private Set mCachedEnabledPackages;
    private final Context mContext;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private final Map mRecordMap;

    public NotificationManagerCompat$SideChannelManager(Context context) {
        Handler handler = new HashMap();
        this.mRecordMap = handler;
        this.mCachedEnabledPackages = handler;
        this.mContext = context;
        super("NotificationManagerCompat");
        this.mHandlerThread = context;
        context.start();
        context = context.getLooper();
        this.mHandler = handler = new Handler((Looper)context, (Handler.Callback)this);
    }

    private boolean ensureServiceBound(NotificationManagerCompat$SideChannelManager$ListenerRecord notificationManagerCompat$SideChannelManager$ListenerRecord) {
        boolean bl2 = notificationManagerCompat$SideChannelManager$ListenerRecord.bound;
        if (bl2) {
            return true;
        }
        Object object = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL");
        Object object2 = notificationManagerCompat$SideChannelManager$ListenerRecord.componentName;
        object = object.setComponent(object2);
        object2 = this.mContext;
        int n10 = 33;
        notificationManagerCompat$SideChannelManager$ListenerRecord.bound = bl2 = object2.bindService((Intent)object, (ServiceConnection)this, n10);
        if (bl2) {
            bl2 = false;
            object = null;
            notificationManagerCompat$SideChannelManager$ListenerRecord.retryCount = 0;
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append("Unable to bind to listener ");
            object2 = notificationManagerCompat$SideChannelManager$ListenerRecord.componentName;
            ((StringBuilder)object).append(object2);
            object = ((StringBuilder)object).toString();
            object2 = "NotifManCompat";
            Log.w((String)object2, (String)object);
            object = this.mContext;
            object.unbindService((ServiceConnection)this);
        }
        return notificationManagerCompat$SideChannelManager$ListenerRecord.bound;
    }

    private void ensureServiceUnbound(NotificationManagerCompat$SideChannelManager$ListenerRecord notificationManagerCompat$SideChannelManager$ListenerRecord) {
        boolean bl2 = notificationManagerCompat$SideChannelManager$ListenerRecord.bound;
        if (bl2) {
            this.mContext.unbindService((ServiceConnection)this);
            bl2 = false;
            notificationManagerCompat$SideChannelManager$ListenerRecord.bound = false;
        }
        notificationManagerCompat$SideChannelManager$ListenerRecord.service = null;
    }

    private void handleQueueTask(NotificationManagerCompat$Task notificationManagerCompat$Task) {
        boolean bl2;
        this.updateListenerMap();
        Iterator iterator2 = this.mRecordMap.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            NotificationManagerCompat$SideChannelManager$ListenerRecord notificationManagerCompat$SideChannelManager$ListenerRecord = (NotificationManagerCompat$SideChannelManager$ListenerRecord)iterator2.next();
            ArrayDeque arrayDeque = notificationManagerCompat$SideChannelManager$ListenerRecord.taskQueue;
            arrayDeque.add(notificationManagerCompat$Task);
            this.processListenerQueue(notificationManagerCompat$SideChannelManager$ListenerRecord);
        }
    }

    private void handleRetryListenerQueue(ComponentName object) {
        Map map = this.mRecordMap;
        if ((object = (NotificationManagerCompat$SideChannelManager$ListenerRecord)map.get(object)) != null) {
            this.processListenerQueue((NotificationManagerCompat$SideChannelManager$ListenerRecord)object);
        }
    }

    private void handleServiceConnected(ComponentName object, IBinder object2) {
        Map map = this.mRecordMap;
        if ((object = (NotificationManagerCompat$SideChannelManager$ListenerRecord)map.get(object)) != null) {
            object2 = INotificationSideChannel$Stub.asInterface(object2);
            object.service = object2;
            object2 = null;
            object.retryCount = 0;
            this.processListenerQueue((NotificationManagerCompat$SideChannelManager$ListenerRecord)object);
        }
    }

    private void handleServiceDisconnected(ComponentName object) {
        Map map = this.mRecordMap;
        if ((object = (NotificationManagerCompat$SideChannelManager$ListenerRecord)map.get(object)) != null) {
            this.ensureServiceUnbound((NotificationManagerCompat$SideChannelManager$ListenerRecord)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void processListenerQueue(NotificationManagerCompat$SideChannelManager$ListenerRecord notificationManagerCompat$SideChannelManager$ListenerRecord) {
        int n10;
        Object object;
        Object object2;
        Object object3 = "NotifManCompat";
        int n11 = 3;
        boolean bl2 = Log.isLoggable((String)object3, (int)n11);
        if (bl2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Processing component ");
            object = notificationManagerCompat$SideChannelManager$ListenerRecord.componentName;
            ((StringBuilder)object2).append(object);
            ((StringBuilder)object2).append(", ");
            n10 = notificationManagerCompat$SideChannelManager$ListenerRecord.taskQueue.size();
            ((StringBuilder)object2).append(n10);
            object = " queued tasks";
            ((StringBuilder)object2).append((String)object);
            object2 = ((StringBuilder)object2).toString();
            Log.d((String)object3, (String)object2);
        }
        if (bl2 = ((ArrayDeque)(object2 = notificationManagerCompat$SideChannelManager$ListenerRecord.taskQueue)).isEmpty()) {
            return;
        }
        bl2 = this.ensureServiceBound(notificationManagerCompat$SideChannelManager$ListenerRecord);
        if (!bl2 || (object2 = notificationManagerCompat$SideChannelManager$ListenerRecord.service) == null) {
            this.scheduleListenerRetry(notificationManagerCompat$SideChannelManager$ListenerRecord);
            return;
        }
        while ((object2 = (NotificationManagerCompat$Task)notificationManagerCompat$SideChannelManager$ListenerRecord.taskQueue.peek()) != null) {
            try {
                n10 = (int)(Log.isLoggable((String)object3, (int)n11) ? 1 : 0);
                if (n10 != 0) {
                    object = new StringBuilder();
                    String string2 = "Sending task ";
                    ((StringBuilder)object).append(string2);
                    ((StringBuilder)object).append(object2);
                    object = ((StringBuilder)object).toString();
                    Log.d((String)object3, (String)object);
                }
                object = notificationManagerCompat$SideChannelManager$ListenerRecord.service;
                object2.send((INotificationSideChannel)object);
                object2 = notificationManagerCompat$SideChannelManager$ListenerRecord.taskQueue;
                ((ArrayDeque)object2).remove();
            }
            catch (RemoteException remoteException) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("RemoteException communicating with ");
                object = notificationManagerCompat$SideChannelManager$ListenerRecord.componentName;
                ((StringBuilder)object2).append(object);
                object2 = ((StringBuilder)object2).toString();
                Log.w((String)object3, (String)object2, (Throwable)remoteException);
                break;
            }
            catch (DeadObjectException deadObjectException) {
                n11 = (int)(Log.isLoggable((String)object3, (int)n11) ? 1 : 0);
                if (n11 == 0) break;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Remote service has died: ");
                object2 = notificationManagerCompat$SideChannelManager$ListenerRecord.componentName;
                stringBuilder.append(object2);
                String string3 = stringBuilder.toString();
                Log.d((String)object3, (String)string3);
                break;
            }
        }
        object3 = notificationManagerCompat$SideChannelManager$ListenerRecord.taskQueue;
        boolean bl3 = ((ArrayDeque)object3).isEmpty();
        if (!bl3) {
            this.scheduleListenerRetry(notificationManagerCompat$SideChannelManager$ListenerRecord);
        }
    }

    private void scheduleListenerRetry(NotificationManagerCompat$SideChannelManager$ListenerRecord notificationManagerCompat$SideChannelManager$ListenerRecord) {
        Object object = this.mHandler;
        int n10 = 3;
        Object object2 = notificationManagerCompat$SideChannelManager$ListenerRecord.componentName;
        int n11 = object.hasMessages(n10, object2);
        if (n11 != 0) {
            return;
        }
        n11 = notificationManagerCompat$SideChannelManager$ListenerRecord.retryCount;
        int n12 = 1;
        notificationManagerCompat$SideChannelManager$ListenerRecord.retryCount = n11 += n12;
        int n13 = 6;
        String string2 = "NotifManCompat";
        if (n11 > n13) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Giving up on delivering ");
            n12 = notificationManagerCompat$SideChannelManager$ListenerRecord.taskQueue.size();
            ((StringBuilder)object).append(n12);
            ((StringBuilder)object).append(" tasks to ");
            object2 = notificationManagerCompat$SideChannelManager$ListenerRecord.componentName;
            ((StringBuilder)object).append(object2);
            ((StringBuilder)object).append(" after ");
            n12 = notificationManagerCompat$SideChannelManager$ListenerRecord.retryCount;
            ((StringBuilder)object).append(n12);
            ((StringBuilder)object).append(" retries");
            object = ((StringBuilder)object).toString();
            Log.w((String)string2, (String)object);
            notificationManagerCompat$SideChannelManager$ListenerRecord.taskQueue.clear();
            return;
        }
        n11 -= n12;
        n11 = (n12 << n11) * 1000;
        n12 = (int)(Log.isLoggable((String)string2, (int)n10) ? 1 : 0);
        if (n12 != 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Scheduling retry for ");
            ((StringBuilder)object2).append(n11);
            String string3 = " ms";
            ((StringBuilder)object2).append(string3);
            object2 = ((StringBuilder)object2).toString();
            Log.d((String)string2, (String)object2);
        }
        object2 = this.mHandler;
        notificationManagerCompat$SideChannelManager$ListenerRecord = notificationManagerCompat$SideChannelManager$ListenerRecord.componentName;
        notificationManagerCompat$SideChannelManager$ListenerRecord = object2.obtainMessage(n10, (Object)notificationManagerCompat$SideChannelManager$ListenerRecord);
        object2 = this.mHandler;
        long l10 = n11;
        object2.sendMessageDelayed((Message)notificationManagerCompat$SideChannelManager$ListenerRecord, l10);
    }

    private void updateListenerMap() {
        Object object;
        boolean bl2;
        Object object2;
        String string2;
        Map.Entry entry;
        Object object3 = NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
        boolean bl3 = object3.equals(entry = this.mCachedEnabledPackages);
        if (bl3) {
            return;
        }
        this.mCachedEnabledPackages = object3;
        entry = this.mContext.getPackageManager();
        Object object4 = new Intent();
        object4 = object4.setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL");
        int n10 = 0;
        Object object5 = null;
        entry = entry.queryIntentServices((Intent)object4, 0);
        object4 = new HashSet();
        entry = entry.iterator();
        while (true) {
            n10 = entry.hasNext();
            string2 = "NotifManCompat";
            if (n10 == 0) break;
            object5 = (ResolveInfo)entry.next();
            object2 = object5.serviceInfo.packageName;
            bl2 = object3.contains(object2);
            if (!bl2) continue;
            object = ((ResolveInfo)object5).serviceInfo;
            String string3 = object.packageName;
            object = object.name;
            object2 = new ComponentName(string3, (String)object);
            object5 = object5.serviceInfo.permission;
            if (object5 != null) {
                object5 = new StringBuilder();
                object = "Permission present on component ";
                ((StringBuilder)object5).append((String)object);
                ((StringBuilder)object5).append(object2);
                object2 = ", not adding listener record.";
                ((StringBuilder)object5).append((String)object2);
                object5 = ((StringBuilder)object5).toString();
                Log.w((String)string2, (String)object5);
                continue;
            }
            object4.add(object2);
        }
        object3 = object4.iterator();
        while (true) {
            bl3 = object3.hasNext();
            n10 = 3;
            if (!bl3) break;
            object2 = this.mRecordMap;
            entry = (ComponentName)object3.next();
            bl2 = object2.containsKey(entry);
            if (bl2) continue;
            if ((n10 = (int)(Log.isLoggable((String)string2, (int)n10) ? 1 : 0)) != 0) {
                object5 = new StringBuilder();
                object2 = "Adding listener record for ";
                ((StringBuilder)object5).append((String)object2);
                ((StringBuilder)object5).append(entry);
                object5 = ((StringBuilder)object5).toString();
                Log.d((String)string2, (String)object5);
            }
            object5 = this.mRecordMap;
            object2 = new NotificationManagerCompat$SideChannelManager$ListenerRecord((ComponentName)entry);
            object5.put(entry, object2);
        }
        object3 = this.mRecordMap.entrySet().iterator();
        while (bl3 = object3.hasNext()) {
            entry = object3.next();
            object2 = entry.getKey();
            bl2 = object4.contains(object2);
            if (bl2) continue;
            bl2 = Log.isLoggable((String)string2, (int)n10);
            if (bl2) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Removing listener record for ");
                object = entry.getKey();
                ((StringBuilder)object2).append(object);
                object2 = ((StringBuilder)object2).toString();
                Log.d((String)string2, (String)object2);
            }
            entry = (NotificationManagerCompat$SideChannelManager$ListenerRecord)entry.getValue();
            this.ensureServiceUnbound((NotificationManagerCompat$SideChannelManager$ListenerRecord)((Object)entry));
            object3.remove();
        }
    }

    public boolean handleMessage(Message object) {
        boolean bl2 = ((Message)object).what;
        boolean bl3 = true;
        if (bl2) {
            if (bl2 != bl3) {
                boolean bl4 = 2 != 0;
                if (bl2 != bl4) {
                    boolean bl5 = 3 != 0;
                    if (bl2 != bl5) {
                        return false;
                    }
                    object = (ComponentName)((Message)object).obj;
                    this.handleRetryListenerQueue((ComponentName)object);
                    return bl3;
                }
                object = (ComponentName)((Message)object).obj;
                this.handleServiceDisconnected((ComponentName)object);
                return bl3;
            }
            object = (NotificationManagerCompat$ServiceConnectedEvent)((Message)object).obj;
            ComponentName componentName = ((NotificationManagerCompat$ServiceConnectedEvent)object).componentName;
            object = ((NotificationManagerCompat$ServiceConnectedEvent)object).iBinder;
            this.handleServiceConnected(componentName, (IBinder)object);
            return bl3;
        }
        object = (NotificationManagerCompat$Task)((Message)object).obj;
        this.handleQueueTask((NotificationManagerCompat$Task)object);
        return bl3;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Object object;
        String string2 = "NotifManCompat";
        boolean bl2 = Log.isLoggable((String)string2, (int)3);
        if (bl2) {
            CharSequence charSequence = new StringBuilder();
            object = "Connected to service ";
            charSequence.append((String)object);
            charSequence.append(componentName);
            charSequence = charSequence.toString();
            Log.d((String)string2, (String)charSequence);
        }
        string2 = this.mHandler;
        object = new NotificationManagerCompat$ServiceConnectedEvent(componentName, iBinder);
        string2.obtainMessage(1, object).sendToTarget();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        String string2 = "NotifManCompat";
        boolean bl2 = Log.isLoggable((String)string2, (int)3);
        if (bl2) {
            CharSequence charSequence = new StringBuilder();
            String string3 = "Disconnected from service ";
            charSequence.append(string3);
            charSequence.append(componentName);
            charSequence = charSequence.toString();
            Log.d((String)string2, (String)charSequence);
        }
        this.mHandler.obtainMessage(2, (Object)componentName).sendToTarget();
    }

    public void queueTask(NotificationManagerCompat$Task notificationManagerCompat$Task) {
        this.mHandler.obtainMessage(0, (Object)notificationManagerCompat$Task).sendToTarget();
    }
}

