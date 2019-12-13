package com.un.android.test.viewmodel;

import android.os.SystemClock;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.un.android.test.model.ModTimeDate;

import java.util.Timer;
import java.util.TimerTask;

public class LiveDataTimerViewModel extends ViewModel {
	private static final int ONE_SECOND = 1000;

	private MutableLiveData<ModTimeDate> mElapsedTime = new MutableLiveData<>();

	private long mInitialTime;

	public LiveDataTimerViewModel() {
		mInitialTime = SystemClock.elapsedRealtime();
		Timer timer = new Timer();

		// Update the elapsed time every second.
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				synchronized (mElapsedTime) {
					ModTimeDate modTimeDate = new ModTimeDate();
					final long newValue = (SystemClock.elapsedRealtime() - mInitialTime)/1000;
					modTimeDate.setmInitialTime(newValue);
					// setValue() cannot be called from a background thread so post to main thread.
					mElapsedTime.postValue(modTimeDate);
				}
			}
		}, ONE_SECOND, ONE_SECOND);

	}

	public void freshData() {
		synchronized (mElapsedTime) {
			mInitialTime = SystemClock.elapsedRealtime();
			ModTimeDate modTimeDate = new ModTimeDate();
			modTimeDate.setmInitialTime(mInitialTime);

			mElapsedTime.postValue(modTimeDate);
		}
	}

	public LiveData<ModTimeDate> getElapsedTime() {
		return mElapsedTime;
	}
}
