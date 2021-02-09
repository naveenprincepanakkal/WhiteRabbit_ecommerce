package poc.naveen.ecommerce.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import poc.naveen.ecommerce.R
import poc.naveen.ecommerce.databinding.FragmentBannerImageBinding
import poc.naveen.ecommerce.model.data.banner.BannerData
import poc.naveen.ecommerce.model.repository.MainRepository
import poc.naveen.ecommerce.utils.Helper


/**
 * A simple [Fragment] subclass.
 * Use the [BannerImageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BannerImageFragment : Fragment() {

    private lateinit var binding: FragmentBannerImageBinding
    private lateinit var bannerData: BannerData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_banner_image, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            BannerImageFragment().apply {
                arguments = Bundle().apply { }
            }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadImage()
    }

    private fun loadImage() {
        bannerData = MainRepository().fetchBannerData(context)
        loadPicasso(bannerData.banner.get((bannerData.banner.indices).random()).imgUrl)
    }

    private fun loadPicasso(i: String) {
        Picasso.get().invalidate(i)
        Picasso.get()
            .load(i)
            .placeholder(Helper.getProgressDrawable(binding.imageViewBanner.context))
            .memoryPolicy(MemoryPolicy.NO_CACHE)
            .networkPolicy(NetworkPolicy.NO_CACHE)
            .into(binding.imageViewBanner)
    }
}