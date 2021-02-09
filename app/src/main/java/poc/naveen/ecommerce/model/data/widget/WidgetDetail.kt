package poc.naveen.ecommerce.model.data.widget


import com.google.gson.annotations.SerializedName

data class WidgetDetail(
    @SerializedName("orderNumber")
    val orderNumber: String = "",
    @SerializedName("widgetId")
    val widgetId: String = "",
    @SerializedName("widgetName")
    val widgetName: String = "",
    var layoutId: Int,
    var layoutWeight: Int
)