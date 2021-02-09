package poc.naveen.ecommerce.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import poc.naveen.ecommerce.R
import poc.naveen.ecommerce.model.data.carousel.Carousel
import poc.naveen.ecommerce.utils.Helper

class ProductCarouselAdapter(private val carouselList: List<Carousel>) :
    RecyclerView.Adapter<ProductCarouselAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view_carousel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_product_carousel, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = carouselList[position]
        Picasso.get()
            .load(item.imgUrl)
            .placeholder(Helper.getProgressDrawable(holder.imageView.context))
            .into(holder.imageView)
    }

    override fun getItemCount(): Int = carouselList.size

}