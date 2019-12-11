package com.un.android.test.component;

import com.un.android.test.R;

public class ActivityProjectStandard extends ActivityImmersive {
	@Override
	protected int getSystemUIColor() {
		return getResources().getColor(R.color.color_status_navi);
	}
}
