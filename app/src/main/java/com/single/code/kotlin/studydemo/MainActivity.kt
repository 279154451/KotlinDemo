package com.single.code.kotlin.studydemo

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_user_login.*
import kotlinx.coroutines.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 总控制器：设置导航
        val navView: BottomNavigationView = findViewById(R.id.nav_view);

        val appBarConfiguration: AppBarConfiguration = AppBarConfiguration.Builder(
            R.id.navigation_home,
            R.id.navigation_collect,
            R.id.navigation_personal
        )
            .build()

        val navController: NavController =
            Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        testBtn.setOnClickListener {
//            doNetWorkBlocking(testBtn)
            doNetWorkGlobe(testBtn)
        }
    }

    /**
     * 通过runBlocking从主线程环境过渡（切换）到协程环境
     */
    fun click(view: View): Boolean = runBlocking {//外协程
        //协程环境的高阶函数方法体，默认是main线程
        launch(Dispatchers.IO) {//内协程,通过Dispatchers.IO切换到iO线程,默认main线程

        }
        false
    }

    fun showToast(){
        Log.e("Test","showToast before")
//        Toast.makeText(this,"窗宽",Toast.LENGTH_LONG).show()
        LoadingDialog.show(this)
        Log.e("Test","showToast end")
    }
    //runBlocking是阻塞式协程: 执行顺序是step 1->step 2->step 3->step 4->def->setText->showToast(这个方法中的弹窗会进入阻塞)
    fun doNetWorkBlocking(view: Button?) = runBlocking {
        //进入协程环境，默认是main线程
        Log.e("Test","进入协程环境 thread="+Thread.currentThread().name)
        launch {
            showToast()//弹窗
            //开启异步线程Dispatchers.IO
            withContext(Dispatchers.IO){
                Log.e("Test","step 1")
                Thread.sleep(1000)
            }
            withContext(Dispatchers.IO){
                Log.e("Test","step 2")
                Thread.sleep(1000)
            }
            withContext(Dispatchers.IO){
                Log.e("Test","step 3")
                Thread.sleep(1000)
            }
            withContext(Dispatchers.IO){
                Log.e("Test","step 4")
                Thread.sleep(1000)
            }
            var def = async(Dispatchers.IO) {
                var num = 0;
                for (i in 0..1000000) {
                    num += i
                }
                "成功 num=$num"
            }
            //def 能够拿到异步执行的结果
            val result = def.await()//拿到异步结果，又回到默认的主线程
            view?.text = result//在main线程中更新UI
            Log.e("Test","setText")
        }
        //等价与上面的代码
//        launch {
//            view?.text = async(Dispatchers.IO) {
//                var num = 0;
//                for (i in 0..1000000) {
//                    num += i
//                }
//                "成功 num=$num"
//            }.await()
//        }
    }
   //非阻塞式协程： 执行顺序是showToast(这个方法中的弹窗会立刻弹出)->step 1->step 2->step 3->step 4->def->setText
    fun doNetWorkGlobe(view: Button?){
        GlobalScope.launch(Dispatchers.Main) {//切换到协程环境，并指定默认在main线程
            showToast()//弹窗
            //开启异步线程Dispatchers.IO
            withContext(Dispatchers.IO){
                Log.e("Test","step 1")
                Thread.sleep(1000)
            }
            withContext(Dispatchers.IO){
                Log.e("Test","step 2")
                Thread.sleep(1000)
            }
            withContext(Dispatchers.IO){
                Log.e("Test","step 3")
                Thread.sleep(1000)
            }
            withContext(Dispatchers.IO){
                Log.e("Test","step 4")
                Thread.sleep(1000)
            }
            var def = async(Dispatchers.IO) {
                var num = 0;
                for (i in 0..1000000) {
                    num += i
                }
                "成功 num=$num"
            }
            //def 能够拿到异步执行的结果
            val result = def.await()//拿到异步结果，又回到默认的主线程
            view?.text = result//在main线程中更新UI
            Log.e("Test","setText")
        }
    }

}

