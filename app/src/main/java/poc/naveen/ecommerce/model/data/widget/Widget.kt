package poc.naveen.ecommerce.model.data.widget


import com.google.gson.annotations.SerializedName

data class Widget(
    @SerializedName("widgetDetails")
    val widgetDetails: List<WidgetDetail> = listOf()
)