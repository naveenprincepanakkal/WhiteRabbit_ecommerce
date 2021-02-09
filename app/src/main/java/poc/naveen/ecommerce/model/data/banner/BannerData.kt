package poc.naveen.ecommerce.model.data.banner


import com.google.gson.annotations.SerializedName

data class BannerData(
    @SerializedName("banner")
    val banner: List<Banner> = listOf()
)