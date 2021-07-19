/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.media.MediaExtractor
 *  android.media.MediaMetadataRetriever
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.View
 *  android.view.Window
 */
package com.zhiyun.cama.album;

import android.app.Dialog;
import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.album.Album;
import com.zhiyun.cama.album.AlbumInfoDialog$a;
import com.zhiyun.cama.album.AlbumSection;
import com.zhiyun.common.util.Windows;
import d.v.c.w0.d3;
import d.v.e.l.h2;
import d.v.f.g.a;
import d.v.f.i.g;
import java.io.IOException;
import java.util.Locale;

public class AlbumInfoDialog
extends a {
    private d3 f;

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int u(String var1_1) {
        var2_3 = "content://";
        var3_4 = var1_1.startsWith(var2_3) ^ true;
        var4_5 = new MediaMetadataRetriever();
        var5_6 = 0;
        if (!var3_4) ** GOTO lbl10
        try {
            block15: {
                block13: {
                    var4_5.setDataSource(var1_1);
                    break block13;
lbl10:
                    // 1 sources

                    var6_7 /* !! */  = this.requireContext();
                    var7_8 /* !! */  = Uri.parse((String)var1_1);
                    var4_5.setDataSource(var6_7 /* !! */ , var7_8 /* !! */ );
                }
                var8_9 = 25;
                var9_10 = 3.5E-44f;
                var6_7 /* !! */  = var4_5.extractMetadata(var8_9);
                var9_10 = Float.parseFloat((String)var6_7 /* !! */ );
                var8_9 = Math.round(var9_10);
                if (var8_9 <= 0) ** GOTO lbl-1000
lbl20:
                // 4 sources

                while (true) {
                    var4_5.release();
                    if (var8_9 > 0) return var8_9;
                    var4_5 = new MediaExtractor();
                    if (!var3_4) ** GOTO lbl28
                    try {
                        block14: {
                            var4_5.setDataSource(var1_1);
                            break block14;
lbl28:
                            // 1 sources

                            var2_3 = this.requireContext();
                            var1_1 = Uri.parse((String)var1_1);
                            var10_11 = 0;
                            var13_14 = 0.0f;
                            var7_8 /* !! */  = null;
                            var4_5.setDataSource((Context)var2_3, (Uri)var1_1, null);
                        }
                        while (var5_6 < (var15_16 = var4_5.getTrackCount())) {
                            var1_1 = var4_5.getTrackFormat(var5_6);
                            var2_3 = "mime";
                            if ((var2_3 = var1_1.getString(var2_3)) != null) {
                                var7_8 /* !! */  = Locale.getDefault();
                                var3_4 = (var2_3 = var2_3.toLowerCase((Locale)var7_8 /* !! */ )).contains((CharSequence)(var7_8 /* !! */  = "video/"));
                                if (var3_4) {
                                    var2_3 = "frame-rate";
                                    var15_16 = var1_1.getInteger(var2_3);
                                    return var15_16;
                                }
                            }
                            ++var5_6;
                        }
                        return var8_9;
                    }
                    catch (IOException v0) {}
                    return var8_9;
                }
lbl-1000:
                // 1 sources

                try {}
                catch (Exception v1) {
                    ** GOTO lbl20
                }
                break block15;
                catch (Exception v2) {
                    var8_9 = 0;
                    var6_7 /* !! */  = null;
                    var9_10 = 0.0f;
                }
                ** GOTO lbl20
            }
            var10_11 = Build.VERSION.SDK_INT;
            var11_12 = 28;
            var12_13 = 3.9E-44f;
            if (var10_11 < var11_12) ** GOTO lbl20
            var10_11 = 32;
            var13_14 = 4.5E-44f;
            var7_8 /* !! */  = var4_5.extractMetadata(var10_11);
            var13_14 = Float.parseFloat((String)var7_8 /* !! */ );
            var11_12 = 9;
            var12_13 = 1.3E-44f;
            var14_15 = var4_5.extractMetadata(var11_12);
            var12_13 = Float.parseFloat(var14_15);
        }
        catch (Throwable var1_2) {
            var4_5.release();
            throw var1_2;
        }
        var13_14 /= var12_13;
        var11_12 = 1148846080;
        var12_13 = 1000.0f;
        {
            var8_9 = Math.round(var13_14 *= var12_13);
            ** continue;
        }
    }

    private void v() {
        Dialog dialog = this.getDialog();
        if (dialog == null) {
            return;
        }
        dialog = this.getDialog().getWindow();
        if (dialog == null) {
            return;
        }
        int n10 = h2.b(300.0f);
        dialog.setLayout(n10, -2);
        dialog.setBackgroundDrawableResource(2131231975);
        Windows.p((Window)dialog);
    }

    public void onStart() {
        super.onStart();
        this.v();
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        object = this.getArguments();
        if (object != null) {
            object = (AlbumSection)object.getParcelable("album_info");
            this.f.F((AlbumSection)object);
            object2 = ((AlbumSection)object).getAlbum();
            boolean bl2 = ((Album)object2).isVideo;
            if (!bl2) {
                object = this.f;
                object2 = Boolean.FALSE;
                ((d3)object).E((Boolean)object2);
            } else {
                object2 = this.f;
                Comparable<Boolean> comparable = Boolean.TRUE;
                ((d3)object2).E((Boolean)comparable);
                object2 = this.f;
                comparable = new Comparable<Boolean>();
                Object object3 = this.requireContext();
                int n10 = 2131952455;
                object3 = g.m(object3, n10);
                ((StringBuilder)comparable).append((String)object3);
                object3 = ": ";
                ((StringBuilder)comparable).append((String)object3);
                object = object.getAlbum().path;
                int n11 = this.u((String)object);
                ((StringBuilder)comparable).append(n11);
                object = ((StringBuilder)comparable).toString();
                ((d3)object2).D((String)object);
            }
        }
        object = this.f;
        object2 = new AlbumInfoDialog$a(this);
        ((d3)object).C((AlbumInfoDialog$a)object2);
    }

    public int s() {
        return 2131558512;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (d3)viewDataBinding;
        this.f = viewDataBinding;
    }
}

