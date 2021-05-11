package top.stores.movieappedison.adapter

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import top.stores.a20210509_pradeepgedara_nycschools.R
import top.stores.a20210509_pradeepgedara_nycschools.dataBase.SchoolsEntity
import top.stores.a20210509_pradeepgedara_nycschools.network.VolleyNetworkManager
import top.stores.movieappedison.fragments.SchoolsDetailsFragment



class HomeAdapter(private val context: Context?, private val schoolsList: List<SchoolsEntity>?) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, index: Int): ViewHolder {
        val rootView = LayoutInflater.from(viewGroup.context).inflate(R.layout.activity_card, viewGroup, false)
        return ViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return schoolsList?.size!!
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.schoolName.text = schoolsList?.get(position)?.schoolName
        viewHolder.email.text = schoolsList?.get(position)?.email.toString()
        viewHolder.phoneNumber.text =  schoolsList?.get(position)?.phoneNumber
        viewHolder.overview.text =  schoolsList?.get(position)?.overview



        viewHolder.btnSeeMore.setOnClickListener {
            val movieDetailsFragment = SchoolsDetailsFragment()
            val bundle = Bundle()
            bundle.putInt("POSITION", position)
            bundle.putString("TITLE", schoolsList?.get(position)?.schoolName)
            bundle.putString("RATING", schoolsList?.get(position)?.email.toString())
            bundle.putString("RELEASEDATE", schoolsList?.get(position)?.phoneNumber)
            bundle.putString("OVERVIEW", schoolsList?.get(position)?.overview)
            bundle.putString("POSTERURL", schoolsList?.get(position)?.schoolWebsite)
            movieDetailsFragment.arguments = bundle
            moveToFragment(movieDetailsFragment)
        }

    }


    inner class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

        var schoolName: TextView = itemView.findViewById(R.id.tv_movies_title_card) as TextView
        var email: TextView = itemView.findViewById(R.id.tv_movies_rating) as TextView
        var phoneNumber: TextView = itemView.findViewById(R.id.tv_release_date) as TextView
        var overview: TextView = itemView.findViewById(R.id.over_view_home) as TextView

        var btnSeeMore: Button = itemView.findViewById(R.id.btn_see_more) as Button

    }


    private fun moveToFragment(fragment : Fragment){
        val fragmentTrans = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.fragment_container, fragment)
        fragmentTrans.commit()
    }


}