/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.zhiyun.cama.camera.live;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.live.LiveDialog;
import d.v.c.s0.d7.z;
import d.v.c.x1.l;

public class LiveDialog$b {
    public final /* synthetic */ LiveDialog a;

    public LiveDialog$b(LiveDialog liveDialog) {
        this.a = liveDialog;
    }

    public void a() {
        l.h(this.a);
        Object object = this.a;
        int n10 = ((LiveDialog)object).h;
        int n11 = 6;
        if (n10 == n11) {
            object = LiveDialog.u((LiveDialog)object).S();
            Boolean bl2 = Boolean.TRUE;
            ((MutableLiveData)object).setValue(bl2);
        }
    }

    public void b() {
        l.h(this.a);
        Object object = this.a;
        int n10 = ((LiveDialog)object).h;
        switch (n10) {
            default: {
                break;
            }
            case 7: {
                LiveDialog.u((LiveDialog)object).E0();
                object = this.a.requireActivity();
                object.finish();
                break;
            }
            case 5: {
                String string2 = "android.settings.INTERNAL_STORAGE_SETTINGS";
                Intent intent = new Intent(string2);
                ((Fragment)object).startActivity(intent);
                break;
            }
            case 4: 
            case 6: {
                object = LiveDialog.u((LiveDialog)object);
                ((z)object).D0();
                break;
            }
            case 3: {
                LiveDialog.u((LiveDialog)object).w();
                object = LiveDialog.u(this.a);
                n10 = 5;
                ((z)object).y0(n10);
                break;
            }
            case 2: {
                object = LiveDialog.u((LiveDialog)object);
                String string3 = LiveDialog.v((LiveDialog)this.a).c.getText().toString();
                ((z)object).u0(string3);
                break;
            }
            case 1: {
                object = LiveDialog.u((LiveDialog)object).S();
                Boolean bl2 = Boolean.TRUE;
                ((MutableLiveData)object).setValue(bl2);
                object = LiveDialog.u(this.a);
                ((z)object).u();
            }
        }
    }
}

