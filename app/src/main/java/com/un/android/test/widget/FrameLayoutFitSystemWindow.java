package com.un.android.test.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FrameLayoutFitSystemWindow extends FrameLayout {
	public FrameLayoutFitSystemWindow(@NonNull Context context) {
		super(context);
		setFitsSystemWindows(true);
	}

	public FrameLayoutFitSystemWindow(@NonNull Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		setFitsSystemWindows(true);
	}

	public FrameLayoutFitSystemWindow(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		setFitsSystemWindows(true);
	}

	public FrameLayoutFitSystemWindow(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
	}
}
