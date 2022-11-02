package com.example.elmapa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.elmapa.R.mipmap.*

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.elmapa.databinding.ActivityMapsBinding
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;

import com.google.android.gms.maps.GoogleMap.OnInfoWindowCloseListener;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowLongClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerDragListener;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;


class PeleasMapa : AppCompatActivity(),OnMarkerClickListener, OnInfoWindowClickListener, OnMapReadyCallback,GoogleMap.OnMapClickListener {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sanantonio = LatLng(-33.613140433881775, -71.61501650322184)

        val saMarker = mMap.addMarker(
            MarkerOptions()
                .position(sanantonio)
                .snippet("Luis Enrique, campeon mundial con 352 victorias por K.O")
                .title("Pelea en San Antonio")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.icono_round))
        )


        mMap.moveCamera(CameraUpdateFactory.zoomTo(20F))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sanantonio))

        mMap.setOnMarkerClickListener(this)
        mMap.setOnInfoWindowClickListener(this)
        mMap.setOnMapClickListener(this)

        }
    override fun onMarkerClick(marker: Marker): Boolean {
        Toast.makeText(this, "Prueba onMarkerClick", Toast.LENGTH_SHORT).show()

        return false
    }

    override fun onInfoWindowClick(marker: Marker) {
        val intent = Intent(this, Luchadorvista::class.java)
        startActivity(intent)
    }

    override fun onMapClick(p0: LatLng) {
        mMap.clear()
        mMap.addMarker(
            MarkerOptions()
                .position(p0)
                .title("Nueva pelea")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.icono_round))
        )

        }

    }
