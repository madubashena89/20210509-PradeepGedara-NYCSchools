package top.stores.movieappedison.adapter

import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import top.stores.a20210509_pradeepgedara_nycschools.databinding.ActivityCardBinding


class HomeAdapterViewHolder(binding: ActivityCardBinding) :  RecyclerView.ViewHolder(binding.root) {

    var itemCardBinding: ActivityCardBinding? = null

    fun MovieViewHolder(itemCardBinding: ActivityCardBinding) {
        //super(itemCardBinding.getRoot())
        this.itemCardBinding = itemCardBinding
    }

//    fun onCLick(v : View) {
//        startActivity(MovieDetailsFragment.newIntent(this))
//        finish()
//    }
}