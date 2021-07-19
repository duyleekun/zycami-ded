/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.mob.commons.eventrecoder;

import android.text.TextUtils;
import com.mob.commons.LockAction;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.FileLocker;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public final class EventRecorder$3
implements LockAction {
    public final /* synthetic */ String a;
    public final /* synthetic */ LinkedList b;

    public EventRecorder$3(String string2, LinkedList linkedList) {
        this.a = string2;
        this.b = linkedList;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean run(FileLocker fileLocker) {
        try {
            File file = EventRecorder.a();
            Closeable closeable = new FileInputStream(file);
            Object object = "utf-8";
            InputStreamReader inputStreamReader = new InputStreamReader((InputStream)closeable, (String)object);
            closeable = new BufferedReader(inputStreamReader);
            String string2 = ((BufferedReader)closeable).readLine();
            while (true) {
                void var3_7;
                int n10;
                if ((n10 = TextUtils.isEmpty((CharSequence)var3_7)) != 0) {
                    ((BufferedReader)closeable).close();
                    return false;
                }
                object = " ";
                object = this.a;
                String[] stringArray = var3_7.split((String)object);
                String string3 = stringArray[0];
                n10 = ((String)object).equals(string3);
                if (n10 != 0) {
                    object = "0";
                    int n11 = 2;
                    String string4 = stringArray[n11];
                    n10 = ((String)object).equals(string4);
                    int n12 = 1;
                    if (n10 != 0) {
                        object = this.b;
                        String string5 = stringArray[n12];
                        ((LinkedList)object).add(string5);
                    } else {
                        String string6;
                        int n13;
                        object = "1";
                        string3 = stringArray[n11];
                        n10 = ((String)object).equals(string3);
                        if (n10 != 0 && (n13 = ((LinkedList)(object = this.b)).indexOf(string6 = stringArray[n12])) != (n10 = -1)) {
                            object = this.b;
                            ((LinkedList)object).remove(n13);
                        }
                    }
                }
                String string7 = ((BufferedReader)closeable).readLine();
            }
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.d(throwable);
        }
        return false;
    }
}

