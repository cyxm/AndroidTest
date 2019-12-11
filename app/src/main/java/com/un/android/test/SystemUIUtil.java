package com.un.android.test;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;

public class SystemUIUtil {

	public static int getStatusBarHeight(Context context) {
		int statusBarHeight = 0;
		Resources res = context.getApplicationContext().getResources();
		int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");
		if (resourceId > 0) {
			statusBarHeight = res.getDimensionPixelSize(resourceId);
		}
		return statusBarHeight;
	}

	public static void setImmersiveStyle(Window window, int systemUIColor) {
		window.requestFeature(Window.FEATURE_NO_TITLE);

		window.setStatusBarColor(systemUIColor);
		window.setNavigationBarColor(systemUIColor);

		View decorView = window.getDecorView();

		int option = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
				| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
				| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
		decorView.setSystemUiVisibility(option);
	}

}
