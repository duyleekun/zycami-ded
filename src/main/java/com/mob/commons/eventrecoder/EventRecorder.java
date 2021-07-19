/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.eventrecoder;

import com.mob.MobSDK;
import com.mob.commons.LockAction;
import com.mob.commons.e;
import com.mob.commons.eventrecoder.EventRecorder$1;
import com.mob.commons.eventrecoder.EventRecorder$2;
import com.mob.commons.eventrecoder.EventRecorder$3;
import com.mob.commons.eventrecoder.EventRecorder$4;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedList;

public final class EventRecorder
implements PublicMemberKeeper {
    private static File a;
    private static FileOutputStream b;

    public static /* synthetic */ File a() {
        return a;
    }

    public static /* synthetic */ File a(File file) {
        a = file;
        return file;
    }

    public static /* synthetic */ FileOutputStream a(FileOutputStream fileOutputStream) {
        b = fileOutputStream;
        return fileOutputStream;
    }

    private static final void a(LockAction lockAction) {
        File file = MobSDK.getContext().getFilesDir();
        File file2 = new File(file, "comm/locks/.mrlock");
        e.a(file2, lockAction);
    }

    private static final void a(String string2) {
        EventRecorder$2 eventRecorder$2 = new EventRecorder$2(string2);
        EventRecorder.a(eventRecorder$2);
    }

    public static final void addBegin(String string2, String string3) {
        Class<EventRecorder> clazz = EventRecorder.class;
        synchronized (clazz) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            string2 = " ";
            stringBuilder.append(string2);
            stringBuilder.append(string3);
            string2 = " 0\n";
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            EventRecorder.a(string2);
            return;
        }
    }

    public static final void addEnd(String string2, String string3) {
        Class<EventRecorder> clazz = EventRecorder.class;
        synchronized (clazz) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            string2 = " ";
            stringBuilder.append(string2);
            stringBuilder.append(string3);
            string2 = " 1\n";
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            EventRecorder.a(string2);
            return;
        }
    }

    public static /* synthetic */ FileOutputStream b() {
        return b;
    }

    public static final String checkRecord(String string2) {
        Class<EventRecorder> clazz = EventRecorder.class;
        synchronized (clazz) {
            block8: {
                LinkedList linkedList = new LinkedList();
                EventRecorder$3 eventRecorder$3 = new EventRecorder$3(string2, linkedList);
                EventRecorder.a(eventRecorder$3);
                int n10 = linkedList.size();
                if (n10 <= 0) break block8;
                n10 = 0;
                string2 = null;
                string2 = linkedList.get(0);
                return string2;
            }
            return null;
            finally {
            }
        }
    }

    public static final void clear() {
        Class<EventRecorder> clazz = EventRecorder.class;
        synchronized (clazz) {
            EventRecorder$4 eventRecorder$4 = new EventRecorder$4();
            EventRecorder.a(eventRecorder$4);
            return;
        }
    }

    public static final void prepare() {
        Class<EventRecorder> clazz = EventRecorder.class;
        synchronized (clazz) {
            EventRecorder$1 eventRecorder$1 = new EventRecorder$1();
            EventRecorder.a(eventRecorder$1);
            return;
        }
    }
}

