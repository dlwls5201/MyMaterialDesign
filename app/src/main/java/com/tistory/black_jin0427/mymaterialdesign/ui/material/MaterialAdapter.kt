package com.tistory.black_jin0427.mymaterialdesign.ui.material

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.tistory.black_jin0427.mymaterialdesign.R
import com.tistory.black_jin0427.mymaterialdesign.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MaterialAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items = mutableListOf<Movie>()

    private var listener: ItemClickListener? = null

    private val placeholder = ColorDrawable(Color.GRAY)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieHolder(parent)

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val item = items[position]

        with(holder.itemView) {

            Glide.with(context)
                    .load(item.url)
                    .placeholder(placeholder)
                    .into(ivItemMovie)

            tvItemMovieGenre.text = item.genre
            tvItemMovieTitle.text = item.title
            tvItemMovieContent.text = item.content

            cvItemMovieParent.setOnClickListener{
                listener?.onItemClick(item, ivItemMovie)
            }

        }

    }

    // 아이템 설정
    fun setItems(items: MutableList<Movie>) {
        this.items = items
    }

    // 클릭 리스너 연결
    fun setItemClickListener(listener: ItemClickListener?) {
        this.listener = listener
    }

    // 클릭 인터페이스
    interface ItemClickListener {

        fun onItemClick(movie: Movie, ivItemMovie: ImageView)

    }

    class MovieHolder(parent: ViewGroup): RecyclerView.ViewHolder( LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false))
}