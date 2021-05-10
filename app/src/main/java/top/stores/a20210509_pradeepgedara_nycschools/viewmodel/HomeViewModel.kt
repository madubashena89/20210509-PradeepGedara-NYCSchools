package top.stores.a20210509_pradeepgedara_nycschools.viewmodel

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import top.stores.a20210509_pradeepgedara_nycschools.R
import top.stores.a20210509_pradeepgedara_nycschools.dataBase.SchoolsEntity
import top.stores.a20210509_pradeepgedara_nycschools.repositories.Repository

class HomeViewModel : ViewModel(){
    private var schoolList: List<SchoolsEntity>? = null

    private var newSupportFragmentManager : FragmentManager? = null


    fun getSchools(context: Context) : List<SchoolsEntity>? {
        schoolList = Repository.getSchools(context)
        return schoolList
    }


    fun swapFragment(frag : Fragment){
        newSupportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, frag)?.commit()

    }

}