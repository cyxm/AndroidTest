package com.un.android.test.component;


import android.os.Bundle;

import androidx.annotation.Nullable;

import com.un.android.test.R;

public class ActivitySplash extends ActivityProjectStandard {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_window_splash);
	}

}
