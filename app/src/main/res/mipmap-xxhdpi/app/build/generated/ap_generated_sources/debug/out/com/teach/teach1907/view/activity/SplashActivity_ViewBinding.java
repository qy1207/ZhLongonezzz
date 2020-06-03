// Generated code from Butter Knife. Do not modify!
package com.teach.teach1907.view.activity;

import android.view.View;
import androidx.annotation.UiThread;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.teach.teach1907.R;
import com.teach.teach1907.base.BaseSplashActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SplashActivity_ViewBinding extends BaseSplashActivity_ViewBinding {
  private SplashActivity target;

  private View view7f080049;

  private View view7f080110;

  @UiThread
  public SplashActivity_ViewBinding(SplashActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SplashActivity_ViewBinding(final SplashActivity target, View source) {
    super(target, source);

    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.advert_image, "method 'onViewClicked'");
    view7f080049 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.time_view, "method 'onViewClicked'");
    view7f080110 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view7f080049.setOnClickListener(null);
    view7f080049 = null;
    view7f080110.setOnClickListener(null);
    view7f080110 = null;

    super.unbind();
  }
}
