package com.pw.sdk.component.act;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.pw.sdk.advance.res.ResColor;
import com.pw.sdk.advance.ui.SystemUIUtil;

public class ActivityImmersive extends ActivityBase {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		SystemUIUtil.setImmersiveStyle(getWindow(), ResColor.COLOR_QUARTER_TRANSPARENT_BLACK);
	}

}
