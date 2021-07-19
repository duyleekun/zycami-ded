/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 */
package com.zhiyun.cama.album;

import android.content.IntentSender;
import com.zhiyun.cama.album.AlbumDeleteConfirmDialog;
import com.zhiyun.cama.album.AlbumDeleteConfirmDialog$a;
import d.v.s.b.g$a;

public class AlbumDeleteConfirmDialog$a$a
implements g$a {
    public final /* synthetic */ AlbumDeleteConfirmDialog$a a;

    public AlbumDeleteConfirmDialog$a$a(AlbumDeleteConfirmDialog$a albumDeleteConfirmDialog$a) {
        this.a = albumDeleteConfirmDialog$a;
    }

    public void a(IntentSender intentSender) {
        AlbumDeleteConfirmDialog$a albumDeleteConfirmDialog$a = this.a;
        AlbumDeleteConfirmDialog albumDeleteConfirmDialog = albumDeleteConfirmDialog$a.a;
        int n10 = 100;
        try {
            albumDeleteConfirmDialog.startIntentSenderForResult(intentSender, n10, null, 0, 0, 0, null);
        }
        catch (IntentSender.SendIntentException sendIntentException) {
            sendIntentException.printStackTrace();
        }
    }
}

