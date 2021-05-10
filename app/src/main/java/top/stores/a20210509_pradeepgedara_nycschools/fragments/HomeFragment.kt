package top.stores.movieappedison.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import top.stores.a20210509_pradeepgedara_nycschools.databinding.FragmentHomeBinding
import top.stores.a20210509_pradeepgedara_nycschools.viewmodel.HomeViewModel
import top.stores.movieappedison.adapter.HomeAdapter


class HomeFragment : Fragment() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private lateinit var adapter: HomeAdapter
    private lateinit var binding : FragmentHomeBinding
    private lateinit var viewModel : HomeViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        activity?.let {
            viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        }
        setUpAdapterWithList(binding.homeRecyclerview,viewModel)
        return binding.root

    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        binding.homeRecyclerview.adapter.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView


        }
    }
//    fun onCLick(v : View) {
//            val fragmentTrans = supportFragmentManager.beginTransaction()
//            fragmentTrans.replace(R.id.fragment_container, MovieDetailsFragment)
//            fragmentTrans.commit()
//
//    }

    fun setUpAdapterWithList(recyclerView: RecyclerView, viewModel: HomeViewModel){
        adapter = HomeAdapter(activity, viewModel.getSchools(requireActivity()!!.applicationContext))
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.stackFromEnd =true
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

//        fun onCLick(v : View) {
//        startActivity(MovieDetailsFragment.newIntent(this))
//        finish()
//        }

    companion object{
        fun newInstance(): HomeFragment = HomeFragment()
    }
}