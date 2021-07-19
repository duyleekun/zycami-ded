/*
 * Decompiled with CFR 0.151.
 */
package androidx.appcompat.app;

import androidx.appcompat.app.ToolbarActionBar;

public class ToolbarActionBar$1
implements Runnable {
    public final /* synthetic */ ToolbarActionBar this$0;

    public ToolbarActionBar$1(ToolbarActionBar toolbarActionBar) {
        this.this$0 = toolbarActionBar;
    }

    public void run() {
        this.this$0.populateOptionsMenu();
    }
}

