package deligation

/**
 * 1. Create an interface
 * 2. Implement interface
 * 3. Create delegation
 * 4. Use deligation
 */

interface Camera {
    fun onCapturePhoto()
}

/**
 * Workers
 */
class CannonCameraImpl(private val shot: Int) : Camera {
    override fun onCapturePhoto() = println("Cannon Shot: $shot")
}

class SonyCameraImpl(private val text: String) : Camera {
    override fun onCapturePhoto() {
        if (text.isEmpty()) println("Sony: Text empty!")
        else println("Sony: $text")
    }
}

/**
 * The Delegate Class
 * Renamed to CameraController to avoid collision with the interface
 */
class CameraController(private val delegate: Camera) : Camera by delegate

fun main() {
    delegateSony()
}

fun delegateCannon() {
    print("Enter number of shot: ")
    val shot = readln()
    val cameraImpl = CannonCameraImpl(shot = shot.toInt())

    CameraController(delegate = cameraImpl).onCapturePhoto()
}

fun delegateSony() {
    print("Please enter your text:...")
    val text = readln()
    val sony = SonyCameraImpl(text = text)
    CameraController(delegate = sony).onCapturePhoto()
}

/**
 * Delegation processing
 * Step 1: Define rule or contract (interface)
 * Step2: Creates work or Implementer (class that implement interface).
 *        Worker can contain more than one worker
 * Step3: Create a controller for delegating to implementer or worker
 * Step4: How to use delegation
 *  - Create an instant of worker or implementer
 *  - Passed an object of instant to controller.
 *  - Controller will decide when worker should work.
 */












