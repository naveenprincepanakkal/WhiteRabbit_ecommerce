package poc.naveen.ecommerce.model.data.carousel


import com.google.gson.annotations.SerializedName

data class Carousel(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("imgUrl")
    val imgUrl: String = ""
)