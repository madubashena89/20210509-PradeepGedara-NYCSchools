package top.stores.a20210509_pradeepgedara_nycschools.viewmodel

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.AndroidViewModel
import top.stores.a20210509_pradeepgedara_nycschools.R
import top.stores.a20210509_pradeepgedara_nycschools.repositories.Repository

class HomeViewModel (application: Application) : AndroidViewModel(application){

    private var newSupportFragmentManager : FragmentManager? = null

    private var repository: Repository = Repository(application)

    fun getMovies() = repository.getSchools()

//    fun setMessage(movie: MovieEntity) { repository.setMovies(movie)}

    fun swapFragment(frag : Fragment){
        newSupportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, frag)?.commit()

    }

}