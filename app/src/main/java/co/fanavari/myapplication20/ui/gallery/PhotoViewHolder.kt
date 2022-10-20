package co.fanavari.myapplication20.ui.gallery

import androidx.recyclerview.widget.RecyclerView
import co.fanavari.myapplication20.data.UnsplashPhoto
import co.fanavari.myapplication20.databinding.ItemUnsplashBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class PhotoViewHolder(private val binding: ItemUnsplashBinding):
RecyclerView.ViewHolder(binding.root){

    fun bind(photo: UnsplashPhoto){
        binding.apply {
            titleAnimal.text = photo.user.userName

            Glide.with(itemView)
                .load(photo.urls.regular)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(animalImageView)
        }
    }
}

