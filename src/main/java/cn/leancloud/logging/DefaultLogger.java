/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package cn.leancloud.logging;

import android.util.Log;
import cn.leancloud.AVLogger$Level;
import cn.leancloud.logging.DefaultLogger$1;
import cn.leancloud.logging.InternalLogger;

public class DefaultLogger
extends InternalLogger {
    private String tag = null;

    public DefaultLogger(String string2) {
        this.tag = string2;
    }

    public void internalWriteLog(AVLogger$Level object, String string2) {
        int[] nArray = DefaultLogger$1.$SwitchMap$cn$leancloud$AVLogger$Level;
        int n10 = object.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                break;
            }
            case 6: {
                object = this.tag;
                Log.e((String)object, (String)string2);
                break;
            }
            case 5: {
                object = this.tag;
                Log.w((String)object, (String)string2);
                break;
            }
            case 4: {
                object = this.tag;
                Log.i((String)object, (String)string2);
                break;
            }
            case 3: {
                object = this.tag;
                Log.d((String)object, (String)string2);
                break;
            }
            case 1: 
            case 2: {
                object = this.tag;
                Log.v((String)object, (String)string2);
            }
        }
    }

    public void internalWriteLog(AVLogger$Level object, String string2, Throwable throwable) {
        int[] nArray = DefaultLogger$1.$SwitchMap$cn$leancloud$AVLogger$Level;
        int n10 = object.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                break;
            }
            case 6: {
                object = this.tag;
                Log.e((String)object, (String)string2, (Throwable)throwable);
                break;
            }
            case 5: {
                object = this.tag;
                Log.w((String)object, (String)string2, (Throwable)throwable);
                break;
            }
            case 4: {
                object = this.tag;
                Log.i((String)object, (String)string2, (Throwable)throwable);
                break;
            }
            case 3: {
                object = this.tag;
                Log.d((String)object, (String)string2, (Throwable)throwable);
                break;
            }
            case 1: 
            case 2: {
                object = this.tag;
                Log.v((String)object, (String)string2, (Throwable)throwable);
            }
        }
    }

    public void internalWriteLog(AVLogger$Level object, Throwable throwable) {
        int[] nArray = DefaultLogger$1.$SwitchMap$cn$leancloud$AVLogger$Level;
        int n10 = object.ordinal();
        int n11 = 5;
        if ((n10 = nArray[n10]) == n11) {
            object = this.tag;
            Log.w((String)object, (Throwable)throwable);
        }
    }
}

