package com.example.framgianguyenthanhtungh.exoplayer

import android.Manifest
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.activity_main.*
import pub.devrel.easypermissions.EasyPermissions

class MainActivity : AppCompatActivity(), EasyPermissions.PermissionCallbacks {
    private var player: SimpleExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initPermissions()
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
            Util.getUserAgent(this, "com.example.framgianguyenthanhtungh.exovideoplayer")
        )
        val videoUri = "https://www.youtube.com/api/manifest/dash/id/bf5bb2419360daf1/source/" +
                "youtube?as=fmp4_audio_clear,fmp4_sd_hd_clear&sparams=ip,ipbits,expire,source,id,as&ip=0.0.0." +
                "0&ipbits=0&expire=19000000000&signature=51AF5F39AB0CEC3E5497CD9C900EBFEAECCCB5C7.8506521BFC3506" +
                "52163895D4C26DEE124209AA9E&key=ik0"
        val mediaSource = ExtractorMediaSource.Factory(dataSourceFactory)
            .createMediaSource(Uri.parse(videoUri))
        player?.prepare(mediaSource)
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
}
