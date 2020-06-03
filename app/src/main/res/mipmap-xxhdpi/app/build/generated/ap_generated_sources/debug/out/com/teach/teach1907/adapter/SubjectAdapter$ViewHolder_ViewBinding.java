// Generated code from Butter Knife. Do not modify!
package com.teach.teach1907.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.teach.teach1907.R;
import com.teach.teach1907.view.design.RoundImage;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SubjectAdapter$ViewHolder_ViewBinding implements Unbinder {
  private SubjectAdapter.ViewHolder target;

  @UiThread
  public SubjectAdapter$ViewHolder_ViewBinding(SubjectAdapter.ViewHolder target, View source) {
    this.target = target;

    target.leftRoundImage = Utils.findRequiredViewAsType(source, R.id.left_round_image, "field 'leftRoundImage'", RoundImage.class);
    target.itemTitle = Utils.findRequiredViewAsType(source, R.id.item_title, "field 'itemTitle'", TextView.class);
    target.itemRecyclerview = Utils.findRequiredViewAsType(source, R.id.item_recyclerview, "field 'itemRecyclerview'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SubjectAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.leftRoundImage = null;
    target.itemTitle = null;
    target.itemRecyclerview = null;
  }
}
