package com.un.android.test.component;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

/**
 * 基础Activity
 */
public class ActivityBase extends FragmentActivity {

	protected Activity mActivitySelf;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mActivitySelf = this;

		Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
			@Override
			public boolean queueIdle() {
				onAfterUIInited();
				return false;
			}
		});
	}

	/**
	 * onCreate后UI初始化成功后的回调,可在此处获取View尺寸
	 */
	protected void onAfterUIInited() {
	}

}
