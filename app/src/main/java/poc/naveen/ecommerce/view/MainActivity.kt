package poc.naveen.ecommerce.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
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
    }

    private fun loadFragments() {
        val layout: List<Int> = listOf(R.id.container_top, R.id.container_center, R.id.container_bottom)
        var i = 0;
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        for (item in sortedList) {
            when (item.widgetId) {
                "1" -> fragmentTransaction.replace(layout[i++], ProductCarouselFragment.newInstance())
                "2" -> fragmentTransaction.replace(layout[i++], ProductCollectionFragment.newInstance())
                "3" -> fragmentTransaction.replace(layout[i++], BannerImageFragment.newInstance())

            }
        }
        fragmentTransaction.commit()
    }
}