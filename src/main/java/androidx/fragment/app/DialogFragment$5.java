/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.fragment.app;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentContainer;

public class DialogFragment$5
extends FragmentContainer {
    public final /* synthetic */ DialogFragment this$0;
    public final /* synthetic */ FragmentContainer val$fragmentContainer;

    public DialogFragment$5(DialogFragment dialogFragment, FragmentContainer fragmentContainer) {
        this.this$0 = dialogFragment;
        this.val$fragmentContainer = fragmentContainer;
    }

    public View onFindViewById(int n10) {
        FragmentContainer fragmentContainer = this.val$fragmentContainer;
        boolean bl2 = fragmentContainer.onHasView();
        if (bl2) {
            return this.val$fragmentContainer.onFindViewById(n10);
        }
        return this.this$0.onFindViewById(n10);
    }

    public boolean onHasView() {
        Object object = this.val$fragmentContainer;
        boolean bl2 = ((FragmentContainer)object).onHasView();
        if (!bl2 && !(bl2 = ((DialogFragment)(object = this.this$0)).onHasView())) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

