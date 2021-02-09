package poc.naveen.ecommerce.model.data.product


import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("categoryId")
    val categoryId: String = "",
    @SerializedName("categoryName")
    val categoryName: String = "",
    @SerializedName("desc")
    val desc: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("imgUrl")
    val imgUrl: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("offerDesc")
    val offerDesc: String = "",
    @SerializedName("price")
    val price: String = ""
)