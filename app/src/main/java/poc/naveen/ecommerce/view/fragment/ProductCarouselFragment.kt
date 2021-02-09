package poc.naveen.ecommerce.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import poc.naveen.ecommerce.R
import poc.naveen.ecommerce.databinding.FragmentProductCarouselBinding
import poc.naveen.ecommerce.model.data.carousel.CarouselData
import poc.naveen.ecommerce.model.repository.MainRepository
import poc.naveen.ecommerce.view.adapter.ProductCarouselAdapter

/**
 * A simple [Fragment] subclass.
 * Use the [ProductCarouselFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductCarouselFragment : Fragment() {

    private lateinit var binding: FragmentProductCarouselBinding
    private lateinit var carouselData: CarouselData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_carousel, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ProductCarouselFragment().apply { }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadViewPager()
    }

    private fun loadViewPager() {
        carouselData = MainRepository().fetchCarouselData(context)
        val viewPager2 = binding.root.findViewById<ViewPager2>(R.id.view_pager_carousel)
        val tabLayout = binding.root.findViewById<TabLayout>(R.id.tab_dots)
        viewPager2.adapter = ProductCarouselAdapter(carouselData.carousel)

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            //Some implementation
        }.attach()


    }
}