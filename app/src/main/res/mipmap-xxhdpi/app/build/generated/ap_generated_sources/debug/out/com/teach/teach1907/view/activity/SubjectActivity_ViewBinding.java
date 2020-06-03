// Generated code from Butter Knife. Do not modify!
package com.teach.teach1907.view.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.teach.teach1907.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SubjectActivity_ViewBinding implements Unbinder {
  private SubjectActivity target;

  private View view7f080050;

  @UiThread
  public SubjectActivity_ViewBinding(SubjectActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SubjectActivity_ViewBinding(final SubjectActivity target, View source) {
    this.target = target;

    View view;
    target.titleContent = Utils.findRequiredViewAsType(source, R.id.title_content, "field 'titleContent'", TextView.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerView, "field 'recyclerView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.back_image, "method 'onViewClicked'");
    view7f080050 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SubjectActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.titleContent = null;
    target.recyclerView = null;

    view7f080050.setOnClickListener(null);
    view7f080050 = null;
  }
}
