package com.emupapps.placefinder.adapter

import android.app.Activity
import android.graphics.Bitmap
import android.view.View
import com.emupapps.placefinder.databinding.ContentBookmarkInfoBinding
import com.emupapps.placefinder.ui.MapsActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

class BookmarkInfoWindowAdapter(context: Activity) : GoogleMap.InfoWindowAdapter {

    private val binding = ContentBookmarkInfoBinding.inflate(context.layoutInflater)

    override fun getInfoWindow(marker: Marker): View? {
        return null
    }

    override fun getInfoContents(marker: Marker): View? {
        binding.title.text = marker.title ?: ""
        binding.phone.text = marker.snippet ?: ""
        val imageView = binding.photo
        imageView.setImageBitmap((marker.tag as MapsActivity.PlaceInfo).image)
        return binding.root
    }
}