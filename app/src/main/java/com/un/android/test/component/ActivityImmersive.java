package com.un.android.test.component;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;

public abstract class ActivityImmersive extends ActivityBase {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//		SystemUIUtil.setImmersiveStyle(getWindow(), getSystemUIColor());
		getWindow().addFlags(
				WindowManager.LayoutParams.FLAG_FULLSCREEN
						|
						WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
						| WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR
		);
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		//		if (Build.VERSION.SDK_INT >= 16) {
		//			View decorView = getWindow().getDecorView();
		//			decorView.setSystemUiVisibility(
		//					View.SYSTEM_UI_FLAG_FULLSCREEN
		//					//							| View.SYSTEM_UI_FLAG_LAYOUT_STABLE
		//					//							| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
		//					//							| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
		//					//							| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
		//					//							| View.SYSTEM_UI_FLAG_FULLSCREEN
		//					//							| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
		//			);
		//		}
	}

	protected abstract int getSystemUIColor();
}
