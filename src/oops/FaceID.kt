package oops

class FaceID {
    val fingerPrint = "0eooieikekikjr"

    companion object {
        const val FACE_ID = "20938373"
    }
}


fun main() {
    val faceID = FaceID.FACE_ID
    val fingerPrint = FaceID()
    fingerPrint.fingerPrint

    println(faceID)
}