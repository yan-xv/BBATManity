package com.rsschool.finaltask.yanxv.bbatmanity.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import com.rsschool.finaltask.yanxv.bbatmanity.R
import com.rsschool.finaltask.yanxv.bbatmanity.ui.model.MarkerMap

class MarkerInfoWindowAdapter(
    private val context: Context
) : GoogleMap.InfoWindowAdapter {

    @SuppressLint("InflateParams")
    override fun getInfoContents(marker: Marker): View? {
        // 1. Get tag
        val markerMap = marker.tag as? MarkerMap ?: return null

        // 2. Inflate view and set title, address, and rating
        val view = LayoutInflater.from(context).inflate(
            R.layout.marker_info_contents, null
        )
        view.findViewById<TextView>(R.id.text_view_title).text = markerMap.typeObject
        view.findViewById<TextView>(R.id.text_view_work_time).text = markerMap.workTime
        view.findViewById<TextView>(R.id.text_view_address).text = markerMap.address
        view.findViewById<TextView>(R.id.text_view_install_place).text = markerMap.installPlace

        return view
    }

    override fun getInfoWindow(marker: Marker): View? {
        // Return null to indicate that the
        // default window (white bubble) should be used
        return null
    }
}
