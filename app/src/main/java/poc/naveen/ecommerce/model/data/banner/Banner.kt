package poc.naveen.ecommerce.model.data.banner


import com.google.gson.annotations.SerializedName

data class Banner(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("imgUrl")
    val imgUrl: String = ""
)