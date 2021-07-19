/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.livequery;

import cn.leancloud.AVObject;
import cn.leancloud.AVUser;
import cn.leancloud.internal.ThreadModel$MainThreadChecker;
import cn.leancloud.internal.ThreadModel$ThreadShuttle;
import cn.leancloud.livequery.AVLiveQuery$EventType;
import cn.leancloud.livequery.AVLiveQueryEventHandler$1;
import cn.leancloud.livequery.AVLiveQueryEventHandler$2;
import cn.leancloud.livequery.AVLiveQueryEventHandler$3;
import cn.leancloud.livequery.AVLiveQueryEventHandler$4;
import cn.leancloud.livequery.AVLiveQueryEventHandler$5;
import cn.leancloud.livequery.AVLiveQueryEventHandler$6;
import cn.leancloud.livequery.AVLiveQueryEventHandler$7;
import java.util.List;

public abstract class AVLiveQueryEventHandler {
    private static volatile ThreadModel$MainThreadChecker mainThreadChecker;
    private static volatile boolean needCheckMainThread = false;
    private static volatile ThreadModel$ThreadShuttle threadShuttle;

    public static void setMainThreadChecker(ThreadModel$MainThreadChecker threadModel$MainThreadChecker, ThreadModel$ThreadShuttle threadModel$ThreadShuttle) {
        if (threadModel$MainThreadChecker == null) {
            needCheckMainThread = false;
            threadModel$MainThreadChecker = null;
            mainThreadChecker = null;
            threadShuttle = null;
        } else {
            boolean bl2;
            needCheckMainThread = bl2 = true;
            mainThreadChecker = threadModel$MainThreadChecker;
            threadShuttle = threadModel$ThreadShuttle;
        }
    }

    public void done(AVLiveQuery$EventType object, AVObject aVObject, List object2) {
        Object object3 = AVLiveQueryEventHandler$7.$SwitchMap$cn$leancloud$livequery$AVLiveQuery$EventType;
        int n10 = ((Enum)object).ordinal();
        n10 = object3[n10];
        switch (n10) {
            default: {
                break;
            }
            case 6: {
                n10 = (int)(needCheckMainThread ? 1 : 0);
                if (n10 != 0 && (n10 = (int)((object = mainThreadChecker).isMainThread() ? 1 : 0)) == 0) {
                    object = threadShuttle;
                    object2 = new AVLiveQueryEventHandler$6(this, aVObject);
                    object.launch((Runnable)object2);
                    break;
                }
                this.onObjectCreated(aVObject);
                break;
            }
            case 5: {
                n10 = (int)(needCheckMainThread ? 1 : 0);
                if (n10 != 0 && (n10 = (int)((object = mainThreadChecker).isMainThread() ? 1 : 0)) == 0) {
                    object = threadShuttle;
                    object2 = new AVLiveQueryEventHandler$5(this, aVObject);
                    object.launch((Runnable)object2);
                    break;
                }
                n10 = aVObject instanceof AVUser;
                if (n10 == 0) break;
                aVObject = (AVUser)aVObject;
                this.onUserLogin((AVUser)aVObject);
                break;
            }
            case 4: {
                n10 = (int)(needCheckMainThread ? 1 : 0);
                if (n10 != 0 && (n10 = (int)((object = mainThreadChecker).isMainThread() ? 1 : 0)) == 0) {
                    object = threadShuttle;
                    object3 = new AVLiveQueryEventHandler$4;
                    object3(this, aVObject, (List)object2);
                    object.launch((Runnable)object3);
                    break;
                }
                this.onObjectLeave(aVObject, (List)object2);
                break;
            }
            case 3: {
                n10 = (int)(needCheckMainThread ? 1 : 0);
                if (n10 != 0 && (n10 = (int)((object = mainThreadChecker).isMainThread() ? 1 : 0)) == 0) {
                    object = threadShuttle;
                    object2 = new AVLiveQueryEventHandler$3(this, aVObject);
                    object.launch((Runnable)object2);
                    break;
                }
                object = aVObject.getObjectId();
                this.onObjectDeleted((String)object);
                break;
            }
            case 2: {
                n10 = (int)(needCheckMainThread ? 1 : 0);
                if (n10 != 0 && (n10 = (int)((object = mainThreadChecker).isMainThread() ? 1 : 0)) == 0) {
                    object = threadShuttle;
                    object3 = new AVLiveQueryEventHandler$2;
                    object3(this, aVObject, (List)object2);
                    object.launch((Runnable)object3);
                    break;
                }
                this.onObjectUpdated(aVObject, (List)object2);
                break;
            }
            case 1: {
                n10 = (int)(needCheckMainThread ? 1 : 0);
                if (n10 != 0 && (n10 = (int)((object = mainThreadChecker).isMainThread() ? 1 : 0)) == 0) {
                    object = threadShuttle;
                    object3 = new AVLiveQueryEventHandler$1;
                    object3(this, aVObject, (List)object2);
                    object.launch((Runnable)object3);
                    break;
                }
                this.onObjectEnter(aVObject, (List)object2);
            }
        }
    }

    public void onObjectCreated(AVObject aVObject) {
    }

    public void onObjectDeleted(String string2) {
    }

    public void onObjectEnter(AVObject aVObject, List list) {
    }

    public void onObjectLeave(AVObject aVObject, List list) {
    }

    public void onObjectUpdated(AVObject aVObject, List list) {
    }

    public void onUserLogin(AVUser aVUser) {
    }
}

