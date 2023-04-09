package com.example.olx

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.olx.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var binding : FragmentHomeBinding
    val categoryList = mutableListOf<Category>()
    var productlist = mutableListOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        addarr()
        setProductAdapter(productlist)

        var categoryadapter = CategoryAdapter(categoryList, object : CategoryAdapter.CategoryInterface{
            override fun onClick(category: Category) {
                var list = mutableListOf<Product>()
                for (i in productlist){
                    if (i.category == category){
                        list.add(i)
                    }
                }
                setProductAdapter(list)
            }

        })
        var manager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)

        binding.recyclerCategory.adapter = categoryadapter
        binding.recyclerCategory.layoutManager = manager

        return binding.root
    }

    fun setProductAdapter(list: MutableList<Product>){
        binding.rcycproduct.adapter = ProductAdapter(list, object : ProductAdapter.ProductInterface{
            override fun onClick(product: Product) {
                parentFragmentManager.beginTransaction().add(R.id.home_container, ProductFragment())
                    .commit()
            }
        })
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun addarr(){

        var bolalar = Category("Bolalar dunyosi",R.drawable.stroller)
        var mulk = Category("Ko'chmas mulk", R.drawable.key)
        var transport = Category("Transport", R.drawable.car)
        var ish = Category("Ish", R.drawable.job)
        var hayvon = Category("Hayvonlar", R.drawable.dog)
        var bog = Category("Uy va bog'", R.drawable.chair)
        var tech = Category("Elektr jihozlari", R.drawable.laptop)

        categoryList.add(bolalar)
        categoryList.add(mulk)
        categoryList.add(transport)
        categoryList.add(ish)
        categoryList.add(hayvon)
        categoryList.add(bog)
        categoryList.add(tech)

        productlist.add(Product("Soat",80000,tech))
        productlist.add(Product("Oyinchoq",80000,bolalar))
        productlist.add(Product("Uy",80000,mulk))
        productlist.add(Product("Velik",80000,transport))
        productlist.add(Product("Kuchik",80000,hayvon))
        productlist.add(Product("Soat",80000,tech))
        productlist.add(Product("Oyinchoq",80000,bolalar))
        productlist.add(Product("Uy",80000,mulk))
        productlist.add(Product("Velik",80000,transport))
        productlist.add(Product("Kuchik",80000,hayvon))

    }
}