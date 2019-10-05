package com.hjw.gifdisplay;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.util.AttributeSet;
import android.view.View;

public class GifView extends View {

	private Movie mMovie;
	private long mMovieStart = 0;
	

	public GifView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mMovie = Movie.decodeStream(getResources().openRawResource(R.drawable.gif));
	}

	@Override
	public void onDraw(Canvas canvas) {
		

		long now = android.os.SystemClock.uptimeMillis();

		if (mMovieStart == 0) {
			mMovieStart = now;
		}

		if (mMovie != null) {
			int dur = mMovie.duration();

			if (dur == 0) {
				dur = 300;
			}

			int relTime = (int) ((now - mMovieStart) % dur);
			mMovie.setTime(relTime);
			mMovie.draw(canvas, 90, 30);

			invalidate();
			
			
			
			
			
		}
		
		
		
		
	
}}
