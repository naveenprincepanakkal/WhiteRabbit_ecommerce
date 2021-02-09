package poc.naveen.ecommerce.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import poc.naveen.ecommerce.R
import poc.naveen.ecommerce.databinding.FragmentProductCollectionBinding
import poc.naveen.ecommerce.model.data.product.ProductData
import poc.naveen.ecommerce.model.repository.MainRepository
import poc.naveen.ecommerce.view.adapter.ProductAdapter


/**
 * A simple [Fragment] subclass.
 * Use the [ProductCollectionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductCollectionFragment : Fragment() {

    private lateinit var binding: FragmentProductCollectionBinding
    private lateinit var productData: ProductData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_collection, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ProductCollectionFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadViewProduct()
    }

    private fun loadViewProduct() {
        productData = MainRepository().fetchProductData(context)
        binding.rvProduct.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = ProductAdapter(productData.products)
        }

    }
}