package com.sanjoo.atmegatasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sanjoo.atmegatasks.databinding.ActivitySearchbarBinding

class SearchbarActivity : AppCompatActivity() {

//    private lateinit var recyclerView: RecyclerView
//    private  lateinit var searchView:SearchView
    private lateinit var binding:ActivitySearchbarBinding
    private var theList=ArrayList<SearchData>()
    private lateinit var adapter: SearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding= ActivitySearchbarBinding.inflate(layoutInflater)
//        setContentView(binding.root)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_searchbar)
//        binding.recyclerViewSearch.setHasFixedSize(true)
        binding.recyclerViewSearch.layoutManager=LinearLayoutManager(this)

        addDataToList()
        adapter= SearchAdapter(theList)
        binding.recyclerViewSearch.adapter=adapter

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })

        //arrow click action

    }

    private fun filterList(query: String?) {
            if(query!=null){
                val filteredList=ArrayList<SearchData>()
                for (i in theList){
                    if(i.textData.lowercase().contains(query)){
                        filteredList.add(i)
                    }
                }
                if(filteredList.isEmpty()){
                    Toast.makeText(this,"the query does not exist",Toast.LENGTH_SHORT).show()
                }
                else{
                    adapter.setFilteredList(filteredList)
                }

            }
    }

    private fun addDataToList() {
        theList.add(SearchData("kotlin"))
        theList.add(SearchData("katlin"))
        theList.add(SearchData("koalin"))
        theList.add(SearchData("kotiin"))
        theList.add(SearchData("kotlin"))
        theList.add(SearchData("konlin"))
        theList.add(SearchData("kotpin"))
        theList.add(SearchData("kotlin"))
        theList.add(SearchData("kotlen"))
        theList.add(SearchData("kotline"))

    }
}