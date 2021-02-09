package poc.naveen.ecommerce.model.repository

import android.content.Context
import com.google.gson.Gson
import poc.naveen.ecommerce.model.data.banner.BannerData
import poc.naveen.ecommerce.model.data.carousel.CarouselData
import poc.naveen.ecommerce.model.data.product.ProductData
import poc.naveen.ecommerce.model.data.widget.Widget
import poc.naveen.ecommerce.utils.Helper


class MainRepository {

    private val bannerDataUrl: String = "BannerData.json"
    private val carouselDataUrl: String = "CarouselData.json"
    private val productDataUrl: String = "ProductData.json"
    private val widgetDetailsUrl: String = "WidgetDetails.json"

    fun fetchBannerData(context: Context?) : BannerData {
        val jsonFileString = Helper.getJsonDataFromAsset(context, bannerDataUrl)
        return Gson().fromJson(jsonFileString, BannerData::class.java)
    }

    fun fetchCarouselData(context: Context?) : CarouselData {
        val jsonFileString = Helper.getJsonDataFromAsset(context, carouselDataUrl)
        return Gson().fromJson(jsonFileString, CarouselData::class.java)
    }

    fun fetchProductData(context: Context?) : ProductData {
        val jsonFileString = Helper.getJsonDataFromAsset(context, productDataUrl)
        return Gson().fromJson(jsonFileString, ProductData::class.java)
    }

    fun fetchWidgetDetails(context: Context?) : Widget {
        val jsonFileString = Helper.getJsonDataFromAsset(context, widgetDetailsUrl)
        return Gson().fromJson(jsonFileString, Widget::class.java)
    }

}