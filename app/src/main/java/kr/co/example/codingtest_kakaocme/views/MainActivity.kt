package kr.co.example.codingtest_kakaocme.views

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kr.co.example.codingtest_kakaocme.R
import kr.co.example.codingtest_kakaocme.api.*
import kr.co.example.codingtest_kakaocme.base.BaseActivity
import kr.co.example.codingtest_kakaocme.base.BaseViewModelFactory
import kr.co.example.codingtest_kakaocme.databinding.ActivityMainBinding
import kr.co.example.codingtest_kakaocme.utils.Utils
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>() {

    @Inject
    lateinit var factory: BaseViewModelFactory

    override fun getLayoutId() = R.layout.activity_main

    override fun getViewModel() = binding.vm as MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val v = ViewModelProvider(this, factory).get(MainViewModel::class.java)

        binding.vm = v
        binding.lifecycleOwner = this

        pagingViewInit()

        getViewModel().hideKeyBoardFlag.observe(this, Observer {
            if (it) Utils.hideKeyboard(this, currentFocus)
        })

        getViewModel().imgItems.observe(this, Observer {
            (binding.viewActivityMainListView.adapter as ImageListAdapter).submitList(it)
        })




    }

    private fun pagingViewInit() {
        binding.viewActivityMainListView.layoutManager = LinearLayoutManager(this)
        binding.viewActivityMainListView.adapter = (ImageListAdapter(getViewModel()))
    }


}