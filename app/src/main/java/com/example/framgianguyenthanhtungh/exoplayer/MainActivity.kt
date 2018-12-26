package com.example.framgianguyenthanhtungh.exoplayer

import android.Manifest
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ext.ima.ImaAdsLoader
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.ads.AdsMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.activity_main.*
import pub.devrel.easypermissions.EasyPermissions

class MainActivity : AppCompatActivity(), EasyPermissions.PermissionCallbacks {
    private var player: SimpleExoPlayer? = null
    private var adsLoader: ImaAdsLoader? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initPermissions()
        //
        adsLoader = ImaAdsLoader(this, Uri.parse("ImaAdsUrl"))
    }

    override fun onStart() {
        super.onStart()
        initExo()
    }

    private fun initExo() {
        val trackSelector = DefaultTrackSelector()
        player = ExoPlayerFactory.newSimpleInstance(this, trackSelector)
        player_view.player = player
        //
        val dataSourceFactory = DefaultDataSourceFactory(
            this,
            Util.getUserAgent(this, "com.example.framgianguyenthanhtungh.exoplayer")
        )
        val videoUri = "https://html5demos.com/assets/dizzy.mp4"
        val mediaSource = ExtractorMediaSource.Factory(dataSourceFactory)
            .createMediaSource(Uri.parse(videoUri))
        //
        val adsMediaSource = AdsMediaSource(mediaSource, dataSourceFactory, adsLoader, player_view.overlayFrameLayout)
        player?.prepare(adsMediaSource)
        player?.playWhenReady = true
    }

    private fun initPermissions() {
        val perms = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )

        if (EasyPermissions.hasPermissions(this, *perms)) {
            //todo
        } else {
            EasyPermissions.requestPermissions(
                this, getString(R.string.request_storage_permisson),
                REQUEST_STORAGE_PERMISSON, *perms
            )
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        //todo
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        //todo
    }

    override fun onPause() {
        super.onPause()
        releaseExo()
    }

    private fun releaseExo() {
        player_view.player = null
        player?.release()
        player = null
    }

    override fun onDestroy() {
        super.onDestroy()
        adsLoader = null
    }
}
