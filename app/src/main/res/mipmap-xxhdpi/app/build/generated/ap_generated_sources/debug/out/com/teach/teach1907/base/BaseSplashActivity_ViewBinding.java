// Generated code from Butter Knife. Do not modify!
package com.teach.teach1907.base;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.teach.teach1907.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BaseSplashActivity_ViewBinding implements Unbinder {
  private BaseSplashActivity target;

  @UiThread
  public BaseSplashActivity_ViewBinding(BaseSplashActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BaseSplashActivity_ViewBinding(BaseSplashActivity target, View source) {
    this.target = target;

    target.advertImage = Utils.findRequiredViewAsType(source, R.id.advert_image, "field 'advertImage'", ImageView.class);
    target.timeView = Utils.findRequiredViewAsType(source, R.id.time_view, "field 'timeView'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BaseSplashActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.advertImage = null;
    target.timeView = null;
  }
}
