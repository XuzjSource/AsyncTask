package com.example.asynctask;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button download;
    private TextView tv;
    private ProgressBar pb;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initView();
    }
    private void initView() {
        // TODO Auto-generated method stub
        tv=(TextView)findViewById(R.id.tv);
        pb=(ProgressBar)findViewById(R.id.pb);
        download=(Button)findViewById(R.id.download);
        download.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DownloadTask dt=new DownloadTask(pb,tv);
                dt.execute(100);
            }
        });
    }
}
