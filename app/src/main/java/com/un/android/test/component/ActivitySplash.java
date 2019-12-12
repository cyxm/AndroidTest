package com.un.android.test.component;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.un.android.test.R;
import com.un.android.test.util.StatusBarUtil;
import com.un.android.test.util.SystemUIUtil;

public class ActivitySplash extends ActivityBase {

	Button vTest;

	int themei = 0;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (savedInstanceState != null) {
			themei = savedInstanceState.getInt("themei");
		}

		Log.i("PwLog", themei + "");
		if (themei == 0) {
			setTheme(R.style.ThemeShowDefault);
		} else {
			setTheme(R.style.ThemeShowTrans);
		}

		setContentView(R.layout.layout_window_splash);

		SystemUIUtil.setStatusBarTransparent(getWindow());
		SystemUIUtil.setLayoutFullScreen(getWindow());
		if (!StatusBarUtil.setStatusBarDarkTheme(this, true)) {
			StatusBarUtil.setStatusBarColor(this, 0x55000000);
		}

		findViewById(R.id.vTest).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				themei = ++themei%2;
				recreate();
			}
		});
	}

	@Override
	protected void onSaveInstanceState(@NonNull Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("themei", themei);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		if (savedInstanceState != null) {
			themei = savedInstanceState.getInt("themei");
		}
	}
}
