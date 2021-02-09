package poc.naveen.ecommerce.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import poc.naveen.ecommerce.R
import poc.naveen.ecommerce.model.data.product.Product
import poc.naveen.ecommerce.utils.Helper

class ProductAdapter(private val product: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvProductCategory: TextView = itemView.findViewById(R.id.tv_product_category)
        val tvOffer: TextView = itemView.findViewById(R.id.tv_offer)
        val imageView: ImageView = itemView.findViewById(R.id.image_view_product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_product, parent, false))
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        val item = product[position]

        holder.tvProductCategory.text = item.categoryName
        holder.tvOffer.text = item.offerDesc

        Picasso.get()
            .load(item.imgUrl)
            .placeholder(Helper.getProgressDrawable(holder.imageView.context))
            .into(holder.imageView)
    }

    override fun getItemCount(): Int = product.size
}