package com.wenen.gridimageviewsample;

import android.app.Application;
import android.content.Context;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Administrator on 2016/12/13.
 */

public class MyApplication extends Application {
  public static RefWatcher getRefWatcher(Context context) {
    MyApplication application = (MyApplication) context.getApplicationContext();
    return application.refWatcher;
  }

  private RefWatcher refWatcher;

  @Override public void onCreate() {
    super.onCreate();
    if (LeakCanary.isInAnalyzerProcess(this)) {
      return;
    }
    refWatcher = LeakCanary.install(this);
  }
}
