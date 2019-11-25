package com.example.chartssample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.android.synthetic.main.activity_chart.*

class ChartActivity : AppCompatActivity() {

    lateinit var lineData: LineData
    lateinit var lineChart: LineChart

    var listEntry: MutableList<Entry> = mutableListOf()
    var lineDataSetList: List<LineDataSet> =  arrayListOf()

    var indexY = 100f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)
        lineChart = findViewById(R.id.main_chart)
    }

    override fun onStart(){
        super.onStart()
        initData()
    }

    override fun onResume(){
        super.onResume()
        val lineDataSet = LineDataSet(listEntry, "listEntry")
        lineData = LineData(lineDataSet)
        lineChart.setData(lineData)
        lineChart.invalidate()
    }

    fun initData(){
        for(i in 0..10){
            listEntry.add(Entry(i.toFloat(), indexY))
            indexY++
        }
    }
}
