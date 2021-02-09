package poc.naveen.ecommerce.model.data.product


import com.google.gson.annotations.SerializedName

data class ProductData(
    @SerializedName("products")
    val products: List<Product> = listOf()
)