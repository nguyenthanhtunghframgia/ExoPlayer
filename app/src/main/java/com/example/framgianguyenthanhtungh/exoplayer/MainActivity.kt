package com.example.framgianguyenthanhtungh.exoplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.custome_view.*

class MainActivity : AppCompatActivity() {
//    private var player: SimpleExoPlayer? = null
//    private var adsLoader: ImaAdsLoader? = null
//    private var isMute: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custome_view)
        initViews()
//        initPermissions()
//        //
//        adsLoader = ImaAdsLoader(this, Uri.parse("ImaAdsUrl"))
//        //
//        imageView.setOnClickListener {
//            if (isMute) {
//                player?.volume = 10f
//            } else {
//                player?.volume = 0f
//            }
//            isMute = !isMute
//        }
    }

    private fun initViews() {
        custom_view.setOnClickListener {
            custom_view.swapColor()
        }
    }
//
//    override fun onStart() {
//        super.onStart()
//        initExo()
//        initMultiChoiceAlertDialog()
//        initSingleChoiceAlertDialog()
//    }
//
//    private fun initExo() {
//        // Create a default track selector.
//        val videoTrackSelectionFactory = AdaptiveTrackSelection.Factory()
//        val trackSelector = DefaultTrackSelector(videoTrackSelectionFactory)
//
//        // Create a player instance.
//        player = ExoPlayerFactory.newSimpleInstance(this, trackSelector)
//
//        // Bind the player to the view.
//        player_view.player = player
//
//        //Bandwidth
//        val bandwidthMeter = DefaultBandwidthMeter()
//
//        //DataSource Factory
//        val dataSourceFactory = DefaultDataSourceFactory(
//            this,
//            Util.getUserAgent(this, "com.example.framgianguyenthanhtungh.exoplayer"),
//            bandwidthMeter
//        )
//
//        //VideoSource
//        val videoUri = "https://html5demos.com/assets/dizzy.mp4"
//        val mediaSource = ExtractorMediaSource.Factory(dataSourceFactory)
//            .createMediaSource(Uri.parse(videoUri))
//
//        //AdsMediaSource
//        val adsMediaSource = AdsMediaSource(mediaSource, dataSourceFactory, adsLoader, player_view.overlayFrameLayout)
//
//        //Prepare And Play
//        player?.prepare(adsMediaSource)
//        player?.playWhenReady = false
//    }
//
//    private fun initPermissions() {
//        val perms = arrayOf(
//            Manifest.permission.READ_EXTERNAL_STORAGE,
//            Manifest.permission.WRITE_EXTERNAL_STORAGE
//        )
//
//        if (EasyPermissions.hasPermissions(this, *perms)) {
//            //todo
//        } else {
//            EasyPermissions.requestPermissions(
//                this, getString(R.string.request_storage_permisson),
//                REQUEST_STORAGE_PERMISSON, *perms
//            )
//        }
//    }
//
//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
//    }
//
//    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
//        //todo
//    }
//
//    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
//        //todo
//    }
//
//    override fun onPause() {
//        super.onPause()
//        releaseExo()
//    }
//
//    private fun releaseExo() {
//        if (player != null) {
//            player_view.player = null
//            player?.release()
//            player = null
//        }
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        releaseAds()
//    }
//
//    private fun releaseAds() {
//        if (adsLoader != null) {
//            adsLoader = null
//        }
//    }
//
//    private fun initMultiChoiceAlertDialog() {
//        val builder = AlertDialog.Builder(this@MainActivity)
//
//        val fonts = arrayOf("champagne.ttf", "dancingscript.otf")
//
//        val checkedColors = booleanArrayOf(
//            true,
//            false
//        )
//
//        builder.setMultiChoiceItems(fonts, checkedColors)
//        { _, which, isChecked ->
//
//            checkedColors[which] = isChecked
//        }
//
//        builder.setCancelable(false)
//
//        builder.setTitle("Your preferred fonts?")
//
//        builder.setPositiveButton("OK") { _, _ ->
//            for (i in checkedColors.indices) {
//
//                if (checkedColors[i]) {
//                    edit_text.apply {
//                        text = edit_text.text.append(fonts[i])
//                        typeface = Typeface.createFromAsset(assets, fonts[i])
//                        //val typeface = ResourcesCompat.getFont(context, R.font.myfont)
//                    }
//                } else {
//                    //todo
//                }
//            }
//        }
//
//        builder.setNegativeButton("No") { _, _ ->
//            //todo
//        }
//
//        builder.setNeutralButton("Cancel") { _, _ ->
//            //todo
//        }
//
//        val dialog = builder.create()
//        dialog.show()
//    }
//
//    private fun initSingleChoiceAlertDialog() {
//        var checkedItem: Int? = null
//        val listItems = arrayOf("champagne.ttf", "dancingscript.otf")
//
//        val builder = AlertDialog.Builder(this@MainActivity)
//
//        builder.setTitle("Choose an item")
//
//        builder.setSingleChoiceItems(
//            listItems, -1
//        ) { _, i ->
//            checkedItem = i
//        }
//
//        builder.setCancelable(false)
//
//        builder.setTitle("Your preferred fonts?")
//
//        builder.setPositiveButton("OK") { _, _ ->
//            edit_text.apply {
//                setText(listItems[checkedItem ?: return@setPositiveButton])
//                typeface = Typeface.createFromAsset(assets, listItems[checkedItem ?: return@setPositiveButton])
//            }
//        }
//
//        builder.setNegativeButton("No") { _, _ ->
//            //todo
//        }
//
//        builder.setNeutralButton("Cancel") { _, _ ->
//            //todo
//        }
//
//        val dialog = builder.create()
//        dialog.show()
//    }
}
