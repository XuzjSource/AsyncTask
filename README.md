AsyncTask
AsyncTask的简单实现

AsyncTask：对线程间的通讯做了包装，是后台线程和UI线程可以简易通讯：后台线程执行异步任务，将result告知UI线程。

step1：继承AsyncTask 
           Params:输入参数。对应的是调用自定义的AsyncTask的类中调用excute()方法中传递的参数。如果不需要传递参数，则直接设为Void即可。 Progress：子线程执行的百分比 
           Result：返回值类型。和doInBackground（）方法的返回值类型保持一致。

step2：实现以下几个方法：执行时机和作用看示例代码，以下对返回值类型和参数进行说明。
           onPreExecute()：无返回值类型。不传参数 
           doInBackground(Params... params)：主要负责执行那些很耗时的后台处理工作。可以调用 publishProgress方法来更新实时的任务进度。 publishProgress(Params... params)：在执行此方法的时候会直接调用onProgressUpdate(Params... values) 
           onProgressUpdate(Params... values)：无返回值类型。参数：若无就传递Void；若有，就可用Progress，UI 线程将调用这个方法. 
           onPostExecute(Result result) ：无返回值类型。参数：和Result保持一致。在doInBackground 执行完成后，将被UI 线程调用。 作用：后台的计算结果将通过该方法传递到UI 线程，并且在界面上展示给用户

step3：在调用自定义的AsyncTask类中生成对象； 
           执行 ：对象.excute(Params... params);

小注：
1) Task的实例必须在UI thread中创建
2) execute方法必须在UI thread中调用 
3) 不要手动的调用onPreExecute(), onPostExecute(Result)，doInBackground=\'#\'" onProgressUpdate(Progress...)这几个方法 
4) 该task只能被执行一次，否则多次调用时将会出现异常
