/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.album;

import com.zhiyun.cama.album.AlbumDeleteConfirmDialog;
import com.zhiyun.cama.album.AlbumDeleteConfirmDialog$a$a;
import d.v.c.o0.u0;
import java.util.List;

public class AlbumDeleteConfirmDialog$a {
    public final /* synthetic */ AlbumDeleteConfirmDialog a;

    public AlbumDeleteConfirmDialog$a(AlbumDeleteConfirmDialog albumDeleteConfirmDialog) {
        this.a = albumDeleteConfirmDialog;
    }

    public void a() {
        u0 u02 = AlbumDeleteConfirmDialog.v(this.a);
        List list = AlbumDeleteConfirmDialog.u(this.a);
        AlbumDeleteConfirmDialog$a$a albumDeleteConfirmDialog$a$a = new AlbumDeleteConfirmDialog$a$a(this);
        u02.d(list, albumDeleteConfirmDialog$a$a);
    }

    public void b() {
        this.a.dismiss();
    }
}

