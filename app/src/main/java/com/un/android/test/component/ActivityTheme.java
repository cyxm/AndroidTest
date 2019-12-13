package com.un.android.test.component;

import android.view.Window;

import com.pw.sdk.advance.res.RepoColor;
import com.pw.sdk.advance.sys.ui.StatusBarUtil;
import com.pw.sdk.advance.sys.ui.SystemUIUtil;
import com.pw.sdk.component.act.ActivityImmersive;
import com.un.android.test.R;

public abstract class ActivityTheme extends ActivityImmersive {

	@Override
	protected void onThemeSetup() {
		setTheme(R.style.ThemeShowDefault);
	}

	@Override
	protected void onSetStatusBarTheme() {
		Window window = getWindow();
		SystemUIUtil.setStatusBarTransparent(window);
		if (!StatusBarUtil.setStatusBarDarkTheme(this, true)) {
			SystemUIUtil.setStatusBarColor(window, RepoColor.COLOR_QUARTER_TRANSPARENT_BLACK);
		}
	}
}
