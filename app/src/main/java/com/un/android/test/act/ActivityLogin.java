package com.un.android.test.act;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.un.android.test.R;
import com.un.android.test.component.ActivityTheme;

public class ActivityLogin extends ActivityTheme {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.layout_window_login);

	}
}
