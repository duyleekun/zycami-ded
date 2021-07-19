/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 */
package d.v.c.s0.d7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import com.zhiyun.live.data.api.entity.ReStreamChannel;
import com.zhiyun.live.data.api.entity.ReStreamPlatform;
import d.v.c.s0.d7.r;
import d.v.c.s0.d7.x$a;
import d.v.c.s0.d7.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class x
extends RecyclerView$Adapter {
    public String a = "LiveRestreamListAdapter";
    private z b;
    public List c;

    public x(z z10) {
        ArrayList arrayList;
        this.c = arrayList = new ArrayList();
        this.b = z10;
    }

    private /* synthetic */ void b(int n10, View view) {
        this.e(n10);
    }

    private void e(int n10) {
        Object object = this.b.L();
        Boolean bl2 = Boolean.TRUE;
        ((MutableLiveData)object).setValue(bl2);
        object = this.b;
        int n11 = ((ReStreamChannel)this.c.get((int)n10)).id;
        n10 = (int)(((ReStreamChannel)this.c.get((int)n10)).active ? 1 : 0);
        ((z)object).q0(n11, n10 != 0);
    }

    public boolean a() {
        boolean bl2;
        Iterator iterator2 = this.c.iterator();
        while (bl2 = iterator2.hasNext()) {
            ReStreamChannel reStreamChannel = (ReStreamChannel)iterator2.next();
            bl2 = reStreamChannel.active;
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public /* synthetic */ void c(int n10, View view) {
        this.b(n10, view);
    }

    public void clear() {
        this.c.clear();
        MutableLiveData mutableLiveData = this.b.P();
        Boolean bl2 = Boolean.FALSE;
        mutableLiveData.setValue(bl2);
        this.notifyDataSetChanged();
    }

    public void d(x$a x$a, int n10) {
        Object object = x$a.c;
        ReStreamChannel reStreamChannel = (ReStreamChannel)this.c.get(n10);
        int n11 = reStreamChannel.active;
        n11 = n11 != 0 ? 2131231604 : 2131231596;
        object.setImageResource(n11);
        object = ((ReStreamChannel)this.c.get((int)n10)).platformIdName;
        x$a.b.setText((CharSequence)object);
        x$a = x$a.a;
        object = new r(this, n10);
        x$a.setOnClickListener((View.OnClickListener)object);
    }

    public x$a f(ViewGroup viewGroup, int n10) {
        viewGroup = LayoutInflater.from((Context)viewGroup.getContext()).inflate(2131558636, viewGroup, false);
        x$a x$a = new x$a((View)viewGroup);
        return x$a;
    }

    public void g(ReStreamChannel[] reStreamChannelArray) {
        int n10;
        int n11;
        Object object;
        for (ReStreamChannel reStreamChannel : reStreamChannelArray) {
            object = this.c.iterator();
            while ((n11 = object.hasNext()) != 0) {
                ReStreamChannel reStreamChannel2 = (ReStreamChannel)object.next();
                n10 = reStreamChannel.id;
                int n12 = reStreamChannel2.id;
                if (n10 != n12) continue;
                n11 = (int)(reStreamChannel2.active ? 1 : 0);
                reStreamChannel.active = n11;
            }
        }
        List list = this.c;
        list.clear();
        block2: for (ReStreamChannel reStreamChannel : reStreamChannelArray) {
            object = this.b.i0();
            n11 = ((ReStreamPlatform[])object).length;
            for (n10 = 0; n10 < n11; ++n10) {
                ReStreamPlatform reStreamPlatform = object[n10];
                int n13 = reStreamChannel.streamingPlatformId;
                int n14 = reStreamPlatform.id;
                if (n13 != n14) continue;
                object = reStreamPlatform.name;
                reStreamChannel.platformIdName = object;
                object = this.c;
                object.add(reStreamChannel);
                continue block2;
            }
        }
        this.notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.c.size();
    }

    public long getItemId(int n10) {
        return n10;
    }
}

