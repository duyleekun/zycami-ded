/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.tencent.liteav.network;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.network.TXCFLVDownloader;

public class TXCFLVDownloader$1
extends Handler {
    public final /* synthetic */ TXCFLVDownloader a;

    public TXCFLVDownloader$1(TXCFLVDownloader tXCFLVDownloader, Looper looper) {
        this.a = tXCFLVDownloader;
        super(looper);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void handleMessage(Message object) {
        Looper looper;
        int n10 = object.what;
        int n11 = 106;
        if (n10 != n11) {
            switch (n10) {
                default: {
                    return;
                }
                case 103: {
                    TXCFLVDownloader tXCFLVDownloader = this.a;
                    TXCFLVDownloader.access$300(tXCFLVDownloader);
                    return;
                }
                case 102: {
                    TXCFLVDownloader tXCFLVDownloader = this.a;
                    TXCFLVDownloader.access$200(tXCFLVDownloader);
                    return;
                }
                case 101: {
                    TXCFLVDownloader tXCFLVDownloader = this.a;
                    TXCFLVDownloader.access$100(tXCFLVDownloader);
                    return;
                }
                case 100: {
                    TXCFLVDownloader tXCFLVDownloader = this.a;
                    TXCFLVDownloader.access$000(tXCFLVDownloader);
                    return;
                }
            }
        }
        try {
            looper = Looper.myLooper();
        }
        catch (Exception exception) {
            return;
        }
        looper.quit();
    }
}

