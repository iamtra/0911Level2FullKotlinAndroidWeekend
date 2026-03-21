package oops

interface SmartPhone {
    /**
     * Core Properties (Device Info)
     */
    val os: String
    val osVersion: String
    val imei: String
    val manufactureYear: Int

    /**
     * Power & Battery
     */
    val batteryLevel: Int        // 0–100
    var isCharging: Boolean

    fun reboot()
    fun charge()

    /**
     * Hardware feature
     *
     */
    fun takePhoto()
    fun recordVideo()
    fun adjustVolume(level: Int)
    fun displayDeviceInfo()
}

class GooglePixel : SmartPhone {
    override val os: String
        get() = "Android"
    override val osVersion: String
        get() = "16"
    override val imei: String
        get() = "urhe438383"
    override val manufactureYear: Int
        get() = 2025
    override val batteryLevel: Int
        get() = 100
    override var isCharging: Boolean = false
        get() = false

    override fun reboot() {
        println("Reboot...")
    }

    override fun charge() {
        this.isCharging = true
    }

    override fun takePhoto() {
        println("Take photos")
    }

    override fun recordVideo() {
        println("Print record videos")
    }

    override fun adjustVolume(level: Int) {
        println(level)
    }

    override fun displayDeviceInfo() {
        println("OS is : $os")
        println("OS Version : $osVersion")
        println("OS Battery Level : $batteryLevel")
    }
}

fun main() {
    val googlePixel10 = GooglePixel()
    googlePixel10.displayDeviceInfo()
}

