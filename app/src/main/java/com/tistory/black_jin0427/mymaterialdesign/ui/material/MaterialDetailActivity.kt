package com.tistory.black_jin0427.mymaterialdesign.ui.material

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.tistory.black_jin0427.mymaterialdesign.R
import com.tistory.black_jin0427.mymaterialdesign.model.Movie
import kotlinx.android.synthetic.main.activity_material_detail.*
import org.jetbrains.anko.toast

class MaterialDetailActivity: AppCompatActivity() {

    companion object {

        const val KEY_MOVIE_ITEM = "key_movie_item"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_detail)

        initView()
        initButton()
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        android.R.id.home -> {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                finishAfterTransition()

            } else {

                finish()
            }

            onBackPressed()

            true
        }

        else -> {

            super.onOptionsItemSelected(item)

        }
    }

    private fun initView() {

        if(null != intent) {
            val movieItem = intent.getParcelableExtra<Movie>(KEY_MOVIE_ITEM)
            if(null != movieItem) {

                // set toolbar
                setSupportActionBar(tbActivityMaterialDetail)
                supportActionBar?.setDisplayHomeAsUpEnabled(true)

                // init view
                with(movieItem) {

                    Glide.with(this@MaterialDetailActivity)
                            .load(url)
                            .placeholder(ContextCompat.getDrawable(applicationContext, R.drawable.placeholder))
                            .into(ivActivityMaterialDetail)

                    tvActivityDetailGenre.text = genre
                    tvActivityDetailTitle.text = title
                    tvActivityDetailContent.text = content

                }

            } else {
                Log.e("MyTag","movieItem null")
            }
        } else {
            Log.e("MyTag","intent null")
        }
    }

    private fun initButton() {

        fabActivityMaterialDetail.setOnClickListener {
            toast("fab")
        }
    }
}