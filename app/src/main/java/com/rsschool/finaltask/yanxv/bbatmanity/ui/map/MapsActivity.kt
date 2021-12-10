package com.rsschool.finaltask.yanxv.bbatmanity.ui.map

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.lifecycle.coroutineScope
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.rsschool.finaltask.yanxv.bbatmanity.application.App
import com.rsschool.finaltask.yanxv.bbatmanity.R
import com.rsschool.finaltask.yanxv.bbatmanity.databinding.ActivityMapsBinding
import com.rsschool.finaltask.yanxv.bbatmanity.ui.adapter.MarkerInfoWindowAdapter
import com.rsschool.finaltask.yanxv.bbatmanity.ui.di.UIComponent
import com.rsschool.finaltask.yanxv.bbatmanity.ui.model.MarkerMap
import getIcon
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Scope
import com.google.android.gms.maps.CameraUpdateFactory


@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class ActivityScope

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private var mMap: GoogleMap? = null
    private lateinit var binding: ActivityMapsBinding
    private lateinit var uiComponent: UIComponent
    @Inject lateinit var mapViewModel: MapViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        uiComponent = (applicationContext as App).appComponent.uiComponent().create()

        // Make Dagger instantiate @Inject fields in LoginActivity
        uiComponent.inject(this)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
/*
        mapViewModel.errorMessage.observe(this) {
            Toast.makeText(applicationContext, it, Toast.LENGTH_LONG).show()
        }*/
        mapFragment.getMapAsync(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("CheckResult")
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mapViewModel.fetchBelarusbankAnyNearestUseCase(COUNT_NEAREST_OBJECT)
            .onEach {
                addMarkers(it)
                val update = CameraUpdateFactory.newLatLng(LatLng(mapViewModel.targetLat, mapViewModel.targetLng))
                mMap?.animateCamera(update)
            }
            .catch {
                Log.e("ERROR", "Can't log in", it)
            }
            .launchIn(lifecycle.coroutineScope)
    }

    private fun addMarkers(list: List<MarkerMap>) {
        mMap?.setInfoWindowAdapter(MarkerInfoWindowAdapter(this))
        mMap?.addMarker(
            MarkerOptions()
                .position(LatLng(mapViewModel.targetLat, mapViewModel.targetLng))
        )
        list.onEach {
            mMap?.addMarker(
                MarkerOptions()
                    .icon(getIcon(this, it.isOpen))
                    .alpha(if (it.isOpen) 1F else 0.6F)
                    .position(it.latLng)
            )?.tag = it
        }
    }

    companion object {
        private const val COUNT_NEAREST_OBJECT = 10
    }
}
