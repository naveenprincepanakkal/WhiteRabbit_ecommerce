package poc.naveen.ecommerce.view

import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import poc.naveen.ecommerce.R
import poc.naveen.ecommerce.databinding.ActivityMainBinding
import poc.naveen.ecommerce.model.data.widget.Widget
import poc.naveen.ecommerce.model.data.widget.WidgetDetail
import poc.naveen.ecommerce.model.repository.MainRepository
import poc.naveen.ecommerce.view.fragment.BannerImageFragment
import poc.naveen.ecommerce.view.fragment.ProductCarouselFragment
import poc.naveen.ecommerce.view.fragment.ProductCollectionFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private lateinit var widget: Widget
    private lateinit var sortedList: List<WidgetDetail>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        fetchWidgetDetails()
        loadFragments()
    }

    private fun fetchWidgetDetails() {
        widget = MainRepository().fetchWidgetDetails(this)
        sortedList = widget.widgetDetails.sortedWith(compareBy { it.orderNumber })
        setWidgetLoadingDetails()

    }

    private fun setWidgetLoadingDetails() {
        val layout: List<Int> = listOf(R.id.container_top, R.id.container_center, R.id.container_bottom)
        var i = 0;
        for (item in sortedList) {
            item.layoutId = layout[i++]
        }
    }

    private fun loadFragments() {
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        for (item in sortedList) {
            when (item.widgetId) {
                "1" -> {
                    fragmentTransaction.replace(item.layoutId, ProductCarouselFragment.newInstance())
                    setLayoutWeight(item.layoutId, 15.0f)
                }
                "2" -> {
                    fragmentTransaction.replace(item.layoutId, ProductCollectionFragment.newInstance())
                    setLayoutWeight(item.layoutId, 60.0f)
                }
                "3" -> {
                    fragmentTransaction.replace(item.layoutId, BannerImageFragment.newInstance())
                    setLayoutWeight(item.layoutId, 25.0f)
                }
            }
        }
        fragmentTransaction.commit()
    }

    private fun setLayoutWeight(layoutId: Int, weight: Float) {
        val frameLayout: FrameLayout = findViewById(layoutId)
        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0)
        params.weight = weight
        frameLayout.layoutParams = params
    }
}