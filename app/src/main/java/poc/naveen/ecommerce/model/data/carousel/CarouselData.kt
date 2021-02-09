package poc.naveen.ecommerce.model.data.carousel


import com.google.gson.annotations.SerializedName

data class CarouselData(
    @SerializedName("carousel")
    val carousel: List<Carousel> = listOf()
)