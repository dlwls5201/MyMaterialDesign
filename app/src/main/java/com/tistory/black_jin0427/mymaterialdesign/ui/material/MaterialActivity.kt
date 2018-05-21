package com.tistory.black_jin0427.mymaterialdesign.ui.material

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import com.tistory.black_jin0427.mymaterialdesign.R
import com.tistory.black_jin0427.mymaterialdesign.data.getMovieItems
import com.tistory.black_jin0427.mymaterialdesign.model.Movie
import com.tistory.black_jin0427.mymaterialdesign.ui.material.MaterialDetailActivity.Companion.KEY_MOVIE_ITEM
import kotlinx.android.synthetic.main.activity_material.*

class MaterialActivity : AppCompatActivity(), MaterialAdapter.ItemClickListener {

    private val adapter by lazy { MaterialAdapter().apply { setItemClickListener(this@MaterialActivity) } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material)

        initView()
    }

    override fun onItemClick(movie: Movie, ivItemMovie: ImageView) {

        val intent = Intent(this, MaterialDetailActivity::class.java).apply {
            // Movie class 가 Parcelable 을 상속받아야 Object 를 전달할 수 있습니다.
            putExtra(KEY_MOVIE_ITEM, movie)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {

            val option : ActivityOptionsCompat
                    = ActivityOptionsCompat.makeSceneTransitionAnimation(this@MaterialActivity,
                    ivItemMovie, "movieWork")

            startActivity(intent, option.toBundle())

        } else {

            startActivity(intent)

        }
    }

    private fun initView() {

        // init recycler view
        with(rvActivityMaterial) {
            layoutManager = LinearLayoutManager(this@MaterialActivity)
            adapter = this@MaterialActivity.adapter
        }

        adapter.setItems(getMovieItems())

    }

}