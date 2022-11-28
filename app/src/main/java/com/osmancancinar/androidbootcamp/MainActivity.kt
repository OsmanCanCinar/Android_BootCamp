package com.osmancancinar.androidbootcamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val scope = CoroutineScope(CoroutineName("MyScope"))
    private val scope2 = CoroutineScope(CoroutineName("MyScope1"))
    val scopeWithContext = CoroutineScope(Dispatchers.IO + CoroutineName("MyScope2"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scope.launch {
            Log.d("Coroutine", this.coroutineContext.toString())
        }

        scopeWithContext.launch {
            Log.d("Coroutine", this.coroutineContext.toString())

            scope2.launch {
                Log.d("Coroutine", this.coroutineContext.toString())
            }
        }

        GlobalScope.launch {
            while (true) {
                delay(500)
                Log.d("Coroutine", "Running...")
            }
        }
    }

    override fun onStart() {
        Log.d("Coroutine", "onStart...")
        super.onStart()
    }

    override fun onResume() {
        Log.d("Coroutine", "onResume...")
        super.onResume()
    }

    override fun onPause() {
        Log.d("Coroutine", "onPause...")
        super.onPause()
    }

    override fun onStop() {
        Log.d("Coroutine", "onStop...")
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}