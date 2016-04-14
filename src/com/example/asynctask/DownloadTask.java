package com.example.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DownloadTask extends AsyncTask<Integer, Integer, String> {
    //后面尖括号内分别是参数（线程休息时间），进度(publishProgress用到)，返回值 类型  
    
    private ProgressBar mProgressBar=null;
    private TextView mTextView=null;
    
    public DownloadTask(ProgressBar pb,TextView tv){
        this.mProgressBar=pb;
        this.mTextView=tv;
    }
    /*
     * 第一个执行的方法
     * 执行时机：在执行实际的后台操作前，被UI 线程调用
     * 作用：可以在该方法中做一些准备工作，如在界面上显示一个进度条，或者一些控件的实例化，这个方法可以不用实现。
     * @see android.os.AsyncTask#onPreExecute()
     */
    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        Log.d("sn", "00000");
        super.onPreExecute();
    }
    
    /*
     * 执行时机：在onPreExecute 方法执行后马上执行，该方法运行在后台线程中
     * 作用：主要负责执行那些很耗时的后台处理工作。可以调用 publishProgress方法来更新实时的任务进度。
     * 该方法是抽象方法，子类必须实现。
     * @see android.os.AsyncTask#doInBackground(Params[])
     */
    @Override
    protected String doInBackground(Integer... params) {
        // TODO Auto-generated method stub
        Log.d("sn", "1111111");
        for(int i=0;i<=100;i++){
        	
        	/*在 setProgress 的源码中，首先会判断当前线程是否为主UI线程，
        	若是主UI线程则直接调用 doRefreshProgress 方法更新进度；
        	若不是主UI线程则会先创建一个RefreshProgressRunnable 对象，
        	然后调用 view 的 post(Runnable action) 方法，将 RefreshProgressRunnable 
        	放到主UI线程的消息队列等待处理。所以更新进度的时候，在不在主线程调用setProgress 
        	方法是没有影响的。同理，SeekBar、ProgressDialog 也是可以在子线程直接更新进度的。
        	http://blog.csdn.net/androidzhaoxiaogang/article/details/8136222*/
            mProgressBar.setProgress(i);
            publishProgress(i);//在执行此方法的时候会直接调用onProgressUpdate(Params... values)
            try {
                Thread.sleep(params[0]);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return "执行完毕";
    }

    /*
     * 执行时机：这个函数在doInBackground调用publishProgress时被调用后，UI 线程将调用这个方法.
     * 虽然此方法只有一个参数,但此参数是一个数组，可以用values[i]来调用
     * 作用：在界面上展示任务的进展情况，例如通过一个进度条进行展示。此实例中，该方法会被执行100次
     * @see android.os.AsyncTask#onProgressUpdate(Progress[])
     */
    @Override
    protected void onProgressUpdate(Integer... values) {
        // TODO Auto-generated method stub
        Log.d("sn", "2222222222");
        mTextView.setText(values[0]+"%");
        super.onProgressUpdate(values);
    }
    
    /*
     * 执行时机：在doInBackground 执行完成后，将被UI 线程调用
     * 作用：后台的计算结果将通过该方法传递到UI 线程，并且在界面上展示给用户
     * result:上面doInBackground执行后的返回值，所以这里是"执行完毕"  
     * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
     */
    @Override
    protected void onPostExecute(String result) {
        // TODO Auto-generated method stub
        Log.d("sn", "3333333333");
        mTextView.setText("success");
        super.onPostExecute(result);
    }

}
