package com.example.chartssample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chartssample.model.UserDetail
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var initialValue = 0f

    lateinit var lineData: LineData
    lateinit var lineDataSet: LineDataSet

    var userDataList: MutableList<Entry> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart(){
        super.onStart()
        initUserList()
    }

    override fun onResume(){
        super.onResume()
        lineDataSet = LineDataSet(userDataList, "usersList")
        lineData = LineData(lineDataSet)
        line_chart.setData(lineData)
    }

    fun initUserList(){
        for(i in 0..10){
            userDataList.add(Entry(initialValue, Random.nextInt(10).toFloat()))
            initialValue++
        }
    }
}
