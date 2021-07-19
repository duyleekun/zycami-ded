/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.tencent.liteav.txcvodplayer;

import android.os.Bundle;
import com.tencent.ijk.media.player.IjkMediaPlayer$OnNativeInvokeListener;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView;

public class TXCVodVideoView$5
implements IjkMediaPlayer$OnNativeInvokeListener {
    public final /* synthetic */ TXCVodVideoView a;

    public TXCVodVideoView$5(TXCVodVideoView tXCVodVideoView) {
        this.a = tXCVodVideoView;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean onNativeInvoke(int n10, Bundle object) {
        int n11 = 2;
        String string2 = "url";
        String string3 = ",error:";
        CharSequence charSequence = "error";
        if (n10 != n11) {
            n11 = 131074;
            boolean bl2 = true;
            if (n10 != n11) {
                n11 = 131106;
                if (n10 != n11) return false;
                String string4 = object.getString(string2);
                int n12 = object.getInt((String)charSequence);
                StringBuilder stringBuilder = new StringBuilder();
                string2 = "dns resolved url:";
                stringBuilder.append(string2);
                stringBuilder.append(string4);
                stringBuilder.append(string3);
                stringBuilder.append(n12);
                String string5 = stringBuilder.toString();
                String string6 = TXCVodVideoView.k(this.a);
                TXCLog.i(string6, string5);
                if (n12 != 0) return bl2;
                TXCVodVideoView tXCVodVideoView = this.a;
                n11 = 2018;
                string2 = "dns resolved";
                TXCVodVideoView.a(tXCVodVideoView, n11, string5, string2);
                return bl2;
            }
            TXCVodVideoView tXCVodVideoView = this.a;
            String string7 = object.getString("ip");
            TXCVodVideoView.a(tXCVodVideoView, string7);
            n10 = object.getInt("port");
            int n13 = object.getInt((String)charSequence);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TCP Connect ServerIp:");
            string2 = TXCVodVideoView.v(this.a);
            stringBuilder.append(string2);
            string2 = ",port:";
            stringBuilder.append(string2);
            stringBuilder.append(n10);
            stringBuilder.append(string3);
            stringBuilder.append(n13);
            String string8 = stringBuilder.toString();
            String string9 = TXCVodVideoView.k(this.a);
            TXCLog.i(string9, string8);
            if (n13 != 0) return bl2;
            TXCVodVideoView tXCVodVideoView2 = this.a;
            n11 = 2016;
            string2 = "tcp open";
            TXCVodVideoView.a(tXCVodVideoView2, n11, string8, string2);
            return bl2;
        }
        String string10 = object.getString(string2);
        n11 = object.getInt((String)charSequence);
        int n14 = object.getInt("http_code");
        string2 = TXCVodVideoView.k(this.a);
        charSequence = new StringBuilder();
        String string11 = "http connect url:";
        ((StringBuilder)charSequence).append(string11);
        ((StringBuilder)charSequence).append(string10);
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(n11);
        ((StringBuilder)charSequence).append(",httpCode:");
        ((StringBuilder)charSequence).append(n14);
        String string12 = ((StringBuilder)charSequence).toString();
        TXCLog.i(string2, string12);
        return false;
    }
}

