package top.stores.a20210509_pradeepgedara_nycschools

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import top.stores.a20210509_pradeepgedara_nycschools.databinding.ActivityMainBinding
import top.stores.a20210509_pradeepgedara_nycschools.viewmodel.HomeViewModel
import top.stores.movieappedison.adapter.HomeAdapter
import top.stores.movieappedison.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var homeAdapter : HomeAdapter
    private  var viewModel : HomeViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
//        viewModel = ViewModelProvider(this,
//            ViewModelProvider.AndroidViewModelFactory.getInstance(this)).get<MoviesViewModel>(MoviesViewModel::class.java
//        )
/*        val android_id = Secure.getString(
            this.contentResolver,
            Secure.ANDROID_ID
        )
        Log.d("AndroidID", "$android_id")*/
        //VolleyNetworkManager.downloadData(this)

        moveToFragment(HomeFragment.newInstance())

    }

    private fun moveToFragment(fragment : Fragment){
        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.fragment_container, fragment)
        fragmentTrans.commit()
    }

    private fun swapFragment(frag : Fragment){
        viewModel?.swapFragment(frag)
    }
}