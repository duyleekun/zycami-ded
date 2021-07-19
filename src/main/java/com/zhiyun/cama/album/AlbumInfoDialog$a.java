/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.album;

import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.cama.album.AlbumInfoDialog;

public class AlbumInfoDialog$a {
    public final /* synthetic */ AlbumInfoDialog a;

    public AlbumInfoDialog$a(AlbumInfoDialog albumInfoDialog) {
        this.a = albumInfoDialog;
    }

    public void a() {
        NavHostFragment.findNavController(this.a).popBackStack();
    }
}

