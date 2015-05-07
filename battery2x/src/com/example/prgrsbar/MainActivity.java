package com.example.prgrsbar;








import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	Handler updateBarHandler;
	ProgressDialog	barProgressDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		updateBarHandler = new Handler();
		
		Button b =  (Button)findViewById(R.id.angry_btn);
		
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) 
			
			{
					
				final ProgressDialog ringProgressDialog = ProgressDialog.show(MainActivity.this, "Please wait ...",	"Downloading Image ...", true);
				ringProgressDialog.setCancelable(true);
			
				
						new Thread(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								
								try {
									// Here you should write your time consuming task...
									// Let the progress ring for 10 seconds...
									Thread.sleep(10000);
								} catch (Exception e) {

								}
								ringProgressDialog.dismiss();
								
							}
						}).start();
				
				
			}
		});
		
		
		
		
		Button b2 = (Button)findViewById(R.id.angry_btn);
		
		
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				
				
				
				barProgressDialog = new ProgressDialog(MainActivity.this);
		
		
			barProgressDialog.setTitle("Charging your Phone...");
			barProgressDialog.setMessage("Charging in progress ...");
			barProgressDialog.setProgressStyle(barProgressDialog.STYLE_HORIZONTAL);
			//barProgressDialog.setIcon(R.drawable.batt1);
			barProgressDialog.setProgress(0);
			barProgressDialog.setMax(100);
			barProgressDialog.show();
			
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					
					try {
						
						// Here you should write your time consuming task...
						while (barProgressDialog.getProgress() <= barProgressDialog.getMax()) {
							
							Thread.sleep(2000);
							
							updateBarHandler.post(new Runnable() {

	                            public void run() {

	                            	barProgressDialog.incrementProgressBy(5);

	                              }

	                          });

							
							if (barProgressDialog.getProgress() == barProgressDialog.getMax()) {
								
								barProgressDialog.dismiss();
								Intent i = new Intent(MainActivity.this, prank.class);
								startActivity(i);
							
								
							}
						}
					} catch (Exception e) {
					}		
					
					
					
					
					
				}
			}).start();
			
			// runnable ends
			
			}
		});
		
		
		
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
