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


    val categoryList = mutableListOf<Category>()

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
        var binding = FragmentHomeBinding.inflate(inflater,container,false)

        addarr()


        var adapter = CategoryAdapter(categoryList, object : CategoryAdapter.CategoryInterface{
            override fun onClick(category: Category) {

            }

        })
        var manager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)


        binding.recyclerCategory.adapter = adapter
        binding.recyclerCategory.layoutManager = manager






        return binding.root
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

        categoryList.add(Category("Недвижиость", R.drawable.key))
        categoryList.add(Category("Транспорт", R.drawable.car))
        categoryList.add(Category("Работа", R.drawable.job))
        categoryList.add(Category("Животные", R.drawable.dog))
        categoryList.add(Category("Дом и сад", R.drawable.chair))
        categoryList.add(Category("Электроника", R.drawable.laptop))

    }
}