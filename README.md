# AsyncTask
AsyncTask的简单实现

AsyncTask：对线程间的通讯做了包装，是后台线程和UI线程可以简易通讯：后台线程执行异步任务，将result告知UI线程。
step1：继承AsyncTask<Params,Progress,Result>

           Params:输入参数。对应的是调用自定义的AsyncTask的类中调用excute()方法中传递的参数。如果不需要传递参数，则直接设为Void即可。

           Progress：子线程执行的百分比

           Result：返回值类型。和doInBackground（）方法的返回值类型保持一致。

step2：实现以下几个方法：执行时机和作用看示例代码，以下对返回值类型和参数进行说明

          onPreExecute()：无返回值类型。不传参数

          doInBackground(Params... params)：返回值类型和Result保持一致。参数：若无就传递Void；若有，就可用Params

          publishProgress(Params... params)：在执行此方法的时候会直接调用onProgressUpdate(Params... values)

          onProgressUpdate(Params... values)：无返回值类型。参数：若无就传递Void；若有，就可用Progress

          onPostExecute(Result  result) ：无返回值类型。参数：和Result保持一致。

step3：在调用自定义的AsyncTask类中生成对象；

          执行  ：对象.excute(Params... params);
