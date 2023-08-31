package com.sanjoo.atmegatasks

import android.database.Cursor
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.sanjoo.atmegatasks.databinding.ActivitySearchbarBinding

class SearchbarActivity : AppCompatActivity(),TextDataInterface {

//    private lateinit var recyclerView: RecyclerView
//    private  lateinit var searchView:SearchView
    private lateinit var binding:ActivitySearchbarBinding
    private lateinit var theList:ArrayList<SearchData>
    private lateinit var adapter: SearchAdapter
    private lateinit var dbRef:DatabaseReference
    private lateinit var query:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySearchbarBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding=DataBindingUtil.setContentView(this,R.layout.activity_searchbar)
        binding.recyclerViewSearch.setHasFixedSize(true)
        binding.recyclerViewSearch.layoutManager=LinearLayoutManager(this)
            theList= arrayListOf<SearchData>()
//        addDataToList()
        getTextData()
        adapter= SearchAdapter(theList,this)
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

//        binding.searchView.setOnSuggestionListener(object : SearchView.OnSuggestionListener {
//            override fun onSuggestionSelect(position: Int): Boolean {
//                return true
//            }
//
//            override fun onSuggestionClick(position: Int): Boolean {
//                val cursor: Cursor = binding.searchView.getSuggestionsAdapter().getCursor()
//                cursor.moveToPosition(position)
//                val suggestion: String =
//                    cursor.getString(2) //2 is the index of col containing suggestion name.
//                binding.searchView.setQuery(suggestion, true) //setting suggestion
//                return true
//            }
//        })

        //arrow click action

    }

    private fun filterList(query: String?) {
            if(query!=null){
                val filteredList= arrayListOf<SearchData>()
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

//    private fun addDataToList() {
//        theList.add(SearchData("kotlin"))
//        theList.add(SearchData("katlin"))
//        theList.add(SearchData("koalin"))
//        theList.add(SearchData("kotiin"))
//        theList.add(SearchData("kotlin"))
//        theList.add(SearchData("konlin"))
//        theList.add(SearchData("kotpin"))
//        theList.add(SearchData("kotlin"))
//        theList.add(SearchData("kotlen"))
//        theList.add(SearchData("kotline"))

//    }
    private fun getTextData(){
         dbRef = FirebaseDatabase.getInstance().getReference("text")
            //.child(FirebaseAuth.getInstance().uid.toString())
        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d("fire_onDataChange",snapshot.toString())
                if(snapshot.exists()) {
                    for (textSnapshot in snapshot.children) {
                        val theText:String = textSnapshot.value as String
                        val searchData=SearchData(theText)
                        theList.add(searchData)
                    }

//                    adapter = SearchAdapter(theList,this)
                    binding.recyclerViewSearch.adapter = adapter

//                val theText=snapshot.getValue()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun getText(t: String) {
        binding.searchView.setQuery(t,false)

    }
}