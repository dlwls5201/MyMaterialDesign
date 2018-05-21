package com.tistory.black_jin0427.mymaterialdesign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.tistory.black_jin0427.mymaterialdesign.ui.material.MaterialActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initButton()
    }

    private fun initButton() {

        btnActivityMain1.setOnClickListener {

            val intent = Intent(this, MaterialActivity::class.java)
            startActivity(intent)
        }

    }

}
